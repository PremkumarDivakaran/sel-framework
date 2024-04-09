package org.example.framework.builder;

import org.testng.annotations.Test;

public class SingletonExample {

    private static SingletonExample instance;

    private SingletonExample(){}

    public static SingletonExample getInstance(){
        if(instance != null) instance = new SingletonExample();
        return instance;
    }

}

class SingletonExecution{

    @Test
    public void runner(){
        SingletonExample.getInstance();
        SingletonExample.getInstance();
        SingletonExample.getInstance();

    }
}
