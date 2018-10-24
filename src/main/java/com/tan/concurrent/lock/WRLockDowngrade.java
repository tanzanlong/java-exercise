package com.tan.concurrent.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class WRLockDowngrade {
    ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    ReentrantReadWriteLock.ReadLock readerLock = rwl.readLock();
    ReentrantReadWriteLock.WriteLock writerLock = rwl.writeLock();
    volatile boolean update = false;

    public void processData() {
        readerLock.lock();
        if (!update) {
            // 必须先释放读锁
            readerLock.unlock();
            // 锁降级从写锁获取到开始
            writerLock.lock();
            try {
                if (!update) {
                    // 准备数据的流程（略）
                    update = true;
                }
                readerLock.lock();
            } finally {
                writerLock.unlock();
            }// 锁降级完成，写锁降级为读锁
        }
        try {// 使用数据的流程（略）
        } finally {
            readerLock.unlock();
        }
    }
}
