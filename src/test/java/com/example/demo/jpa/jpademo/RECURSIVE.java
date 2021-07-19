package com.example.demo.jpa.jpademo;

public class RECURSIVE {
    static StringBuilder s = new StringBuilder();
    static String str = "madam";
    static int len = str.length();

    public static void main(String[] args) {

        System.out.println("pelindrome returned "+stringReverseRecursive("madam"));
        stringReverseRecursive("madam");
        if ("madam".equals(stringReverseRecursive("madam")))
            System.out.println("PELINDROME");
        else
            System.out.println("not PELINDROME");

    }


    static StringBuilder stringReverseRecursive(String str) {
        if (len > 0) {
            String rev = String.valueOf(str.charAt(len - 1));
            s.append(rev);
            len--;
            String s=stringReverseRecursive(str).toString();
        }

     return s;

    }

}

