package com.urise.webapp;

import java.util.Arrays;

public class MainString {
    public static void main(String[] args) {
       String[] stringArray = new String[]{"1", "2","4","5"};
      // String result = "";
        StringBuilder sb = new StringBuilder();
        for (String str : stringArray) {
            //result += str + ", ";
            sb.append(str).append(", ");
        }
        System.out.println(sb.toString());

        String str1 = "abc";
        String str3 = "c";
        String str2 = ("ab" + str3).intern();
        System.out.println(str1 == str2);
    }
}