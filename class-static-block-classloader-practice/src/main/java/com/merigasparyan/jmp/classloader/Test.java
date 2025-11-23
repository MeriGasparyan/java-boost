package com.merigasparyan.jmp.classloader;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class Test {
    public static void main(String[] args) throws Exception {
        System.out.println("New version: " + StringUtils.repeat("A", 3));

        File oldJarFile = new File("class-static-block-classloader-practice/libs/commons-lang3-3.0.jar");
        URL oldJar = oldJarFile.toURI().toURL();
        URLClassLoader oldLoader = new URLClassLoader(new URL[]{oldJar}, null);

        Class<?> oldUtils = oldLoader.loadClass("org.apache.commons.lang3.StringUtils");
        Method repeatMethod = oldUtils.getMethod("repeat", String.class, int.class);
        String oldResult = (String) repeatMethod.invoke(null, "B", 2);
        System.out.println("Old version: " + oldResult);

        oldLoader.close();
    }
}
