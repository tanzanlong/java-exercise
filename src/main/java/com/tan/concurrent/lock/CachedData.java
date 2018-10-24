package com.tan.concurrent.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**代码中声明了一个volatile类型的cacheValid变量，
 * 保证其可见性。首先获取读锁，如果cache不可用，则释放读锁，
 * 获取写锁，在更改数据之前，再检查一次cacheValid的值，然后修改数据，
 * 将cacheValid置为true，然后在释放写锁前获取读锁；此时，cache中数据可用，
 * 处理cache中数据，最后释放读锁。这个过程就是一个完整的锁降级的过程，
 * 目的是保证数据可见性，如果当前的线程C在修改完cache中的数据后，
 * 没有获取读锁而是直接释放了写锁，那么假设此时另一个线程T获取了写锁并修改了数据，
 * 那么C线程无法感知到数据已被修改，则数据出现错误。如果遵循锁降级的步骤，
 * 线程C在释放写锁之前获取读锁，那么线程T在获取写锁时将被阻塞，直到线程C完成数据处理过程，释放读锁。
 * @author Administrator
 *
 */
public class CachedData {
    Object data;
    volatile boolean cacheValid;
    final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    void processCachedData() {
        rwl.readLock().lock();
        if (!cacheValid) {
            // Must release read lock before acquiring write lock
            rwl.readLock().unlock();
            rwl.writeLock().lock();
            try {
                // Recheck state because another thread might have
                // acquired write lock and changed state before we did.
                if (!cacheValid) {
                    // data = ...
                    cacheValid = true;
                }
                // Downgrade by acquiring read lock before releasing write lock
                rwl.readLock().lock();
            } finally {
                rwl.writeLock().unlock(); // Unlock write, still hold read
            }
        }

        try {
            // use(data);
        } finally {
            rwl.readLock().unlock();
        }
    }
}
