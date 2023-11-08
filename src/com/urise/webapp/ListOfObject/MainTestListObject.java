package com.urise.webapp.ListOfObject;

import com.urise.webapp.model.Resume;

import java.time.LocalDate;
import java.util.Map;

public class MainTestListObject {
    public static void main(String[] args) {
        ListOfObjectsIm lo = new ListOfObjectsIm();

        lo.add(123);
        lo.add("blah");
        lo.add(LocalDate.now());

        for (int i = 0; i < lo.getLight(); i++) {
            System.out.println(lo.get(i));
        }

        System.out.println("----------------------------------------------");

        ListOfIm<Integer> lо1 = new ListOfIm<>();

        lо1.add(123);
        //lо1.add("234");
        lо1.add(345);

        Resume r  = new Resume();

       // r.getClass().getAnnotations()

        for (int i = 0; i < lо1.light; i++) {
            System.out.println(lо1.get(i));
        }

        System.out.println(lо1.max());

    }

    public class A {
        Integer i;
    }
}
