package com.epam.gomel.homework;

import org.testng.annotations.Factory;

public class ExtendFactory {

    @Factory
    public Object[] factoryMethod()
    {
        return new Object[] {new BoyTest()};
    }

}
