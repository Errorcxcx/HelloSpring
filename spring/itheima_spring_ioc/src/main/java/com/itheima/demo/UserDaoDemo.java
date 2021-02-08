package com.itheima.demo;

import com.itheima.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class UserDaoDemo {
    public static void main(String[] args) throws InterruptedException {
        Queue queue = new LinkedList<>();
//        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
//        concurrentLinkedQueue.offer("ss");//使用compareAndSet保证线程安全
        AtomicInteger a = new AtomicInteger();
        ReentrantLock takeLock = new ReentrantLock();
        Set set = new HashSet();
        StringBuffer s= new StringBuffer();
        s.append("S");
        set.add("sss");
        takeLock.lock();
        LinkedBlockingQueue queue1 = new LinkedBlockingQueue();
//        queue1.offer("ssssd");//ReentrantLock和AtomicInteger 保证线程安全
//        queue1.put("sdsds");
//        queue1.take();
//        ArrayBlockingQueue queue2 = new ArrayBlockingQueue(4);//ReentrantLock保证线程安全
//        queue2.put("sdsds");
//        HashSet set = new HashSet();
//        set.add("sdsd");
        List list = new ArrayList();
        list.add("s");
        Map map = new HashMap();
        Hashtable hashtable = new Hashtable();
        hashtable.put("ss","ss");
        hashtable.get("ss");
        map.put("jixiao","sdsds");
        ConcurrentMap concurrentMap = new ConcurrentHashMap();//数组中链表的头节点作为锁
        concurrentMap.put("ss","ss");
        Vector v = new Vector();
        v.add("sss");
        Animal c = new Cat();
        c.chi();
    }
}
