package com.tan.concurrent.locksupport;

import java.util.concurrent.locks.LockSupport;

public class LockSupportExample {
    public static void main(String[] args) {
        System.out.println("..to unpark...");
        LockSupport.unpark(Thread.currentThread());
        System.out.println("... unpark done...");
        
      System.out.println("..to unpark...");
        LockSupport.unpark(Thread.currentThread());
        System.out.println("... unpark done...");/*  */

        System.out.println("..to park...");
        LockSupport.park();
        System.out.println("..park done...");
        
        System.out.println("..to park...");
        LockSupport.park();
        System.out.println("..park done...");
    }
}
