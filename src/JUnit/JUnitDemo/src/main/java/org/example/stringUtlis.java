package org.example;
public class stringUtlis {

    public static boolean isPalindrome(String str) {

        String reversed = new StringBuilder(str)
                .reverse()
                .toString();

        return str.equals(reversed);
    }
}