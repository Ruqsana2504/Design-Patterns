package org.design.patterns.creational.singleton;

import java.io.Serializable;

/**
 * Lazy initialization mean application will create instance when it is requested.
 * However, this can be used when you have a non-thread-safe application. If used in multi-threading it might break,
 * Why? Because your getInstance method if invoked by two threads at the same time then!!!!
 * <p>
 * When to use?  Non-thread safe and creating common resource like db connection.
 */
public class LazySingleton implements Serializable {

    private static LazySingleton instance = null;

    private LazySingleton() {
        //Private Constructor
    }

    public static LazySingleton getInstance() {
        //Solution: Do eager initialization
        if (instance == null)
            instance = new LazySingleton();
        return instance;
    }
}
