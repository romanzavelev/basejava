package com.urise.webapp.ListOfObject;

import java.time.LocalDate;

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

        ListOfIm lо1 = new ListOfIm<Object>();

        lо1.add(123);
        lо1.add("blah");
        lо1.add(LocalDate.now());

        for (int i = 0; i < lо1.light; i++) {
            System.out.println(lо1.get(i));
        }

    }
}
