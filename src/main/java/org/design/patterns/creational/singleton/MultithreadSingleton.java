package org.design.patterns.creational.singleton;

import java.io.Serializable;

/**
 * As mentioned in Lazy Initialization if our get instance method invoked by two threads at the
 * same time, then there are chances that two objects created, and we violate a singleton pattern.
 * To avoid, we have two choices:
 * 1. Create getInstance synchronized so that only one instance can invoke that method. However, the disadvantage is lets say
 * there are 3 thread t1 is inside getInstance and t2,t3 waiting. Now t2 will get into method and simply return instance created by
 * t1 and t3 still waiting. So it had led to unnecessary locks.
 * <p>
 * 2. To avoid, we have a synchronized block which we will implement here.
 */
public class MultithreadSingleton implements Serializable {
    private static MultithreadSingleton instance = null;

    private MultithreadSingleton() {

    }

    public static MultithreadSingleton getInstance() {
        // A Question arises why we have two null checks here.
        // Reason for first null check is same as explained in method level synchronization why create lock if our object is already created.
        if (instance == null) {
            // Our method is static, so we have class level locking here
            synchronized (MultithreadSingleton.class) {
                //Reason for second null check is lets say two objects come inside first null at the same time
                // One call has taken lock and proceeds for creating objects first time. Now once lock is released for t1
                // t2 should not create an object because its already created, and that's why we have a second null check.
                if (instance == null) {
                    instance = new MultithreadSingleton();
                }
            }
        }
        return instance;
    }
}