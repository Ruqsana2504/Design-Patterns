package org.design.patterns.creational.singleton;

import java.io.Serializable;

/**
 * This is an eager initialization a concept where
 * as soon as JVM start the object will be created irrespective whether it got accessed by
 * any code in application or not.
 * When to use: One possible usage can be let say your application has some static cache which is required to be loaded.
 * Drawback: As mention consumes resource even if application does not use it.
 */
public class EagerSingleton implements Serializable {

    //Solution: Use LazySingleton method with Synchronized Multithreading
    private static final EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() {
        //Private Constructor
    }

    public static EagerSingleton getInstance() {
        return instance;
    }
}
