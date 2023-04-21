package com.dev.wizard.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Slf4j
public class ReadWriteLockDemo {


    public static void main(String[] args) {
        ReadWriteObject readWriteObject = new ReadWriteObject();
        new Thread(() -> {
            readWriteObject.read();
           // readWriteObject.write();
        }, "AAA").start();

        new Thread(() -> {
           // readWriteObject.read();
            readWriteObject.write();
        }, "BBB").start();
    }




    public static class ReadWriteObject{

        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();

        public void read(){

            readLock.lock();
            try {
               log.info("read lock");
               Thread.sleep(3000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                log.info("释放读锁");
                readLock.unlock();
            }
        }

        public void write(){
            writeLock.lock();
            try {
               log.info("write lock");
               Thread.sleep(1500l);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
                log.info("释放写锁");
                writeLock.unlock();
            }
        }


    }
}
