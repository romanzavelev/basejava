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

    }
}
