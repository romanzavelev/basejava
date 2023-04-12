package com.urise.webapp;

import com.urise.webapp.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class MainReflection {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Resume r = new Resume();
        Field field = r.getClass().getDeclaredFields()[0];
        field.setAccessible(true);
        System.out.println(field.getName());
        System.out.println(field.get(r));
        field.set(r, "new uuid");
        Method method = r.getClass().getDeclaredMethod("toString");
        method.setAccessible(true);
        method.invoke(r);
        System.out.println(r);

        Resume r1 = new Resume("uuid1");
        Resume r2 = new Resume("uuid3");
        Resume r3 = new Resume("uuid4");

        List<Resume> resumes = Arrays.asList(r1,r2,r3);
       // resumes.remove(1);
        System.out.println(resumes);
    }
}
