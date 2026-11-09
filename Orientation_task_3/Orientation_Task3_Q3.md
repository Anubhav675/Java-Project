# Orientation Task 3 Q3: 

A Singleton must have only one instance, so its **constructor is private**. A private constructor can only be called from inside the class itself, so `new Singleton()` from outside is a compile error.

Other classes get the single instance through a public static method, `getInstance()`. It creates the object on first use and returns the same object every time:

```java
public class Singleton {
    private static Singleton instance;      // the only instance

    private Singleton() { }                 // private: "new Singleton()" fails outside the class

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```

In the simulator this guarantees exactly one `Clock`, so all parts of the program share the same simulation time.