package com.epam.gomel.homework;

import org.testng.TestNG;

import java.util.Arrays;
import java.util.List;

public class TestRunner {

    public static void main(String[] args) {
        TestNG testNG = new TestNG();
        testNG.addListener(new Listner());
        List<String>  files = Arrays.asList("./src/test/resources/test_boy.xml","./src/test/resources/test_girl.xml");
        testNG.setTestSuites(files);
        testNG.run();
    }
}
