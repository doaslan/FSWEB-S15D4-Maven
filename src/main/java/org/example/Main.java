
package org.example;

import java.util.Locale;
import java.util.Stack;

public class Main {

    public static boolean checkForPalindrome(String input) {
        if (input == null) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        StringBuilder cleaned = new StringBuilder();

        for (char character : input.toLowerCase(Locale.ROOT).toCharArray()) {
            if (Character.isLetterOrDigit(character)) {
                cleaned.append(character);
                stack.push(character);
            }
        }

        for (int i = 0; i < cleaned.length(); i++) {
            if (cleaned.charAt(i) != stack.pop()) {
                return false;
            }
        }

        return true;
    }

    public static String convertDecimalToBinary(int decimal) {
        if (decimal == 0) {
            return "0";
        }

        if (decimal < 0) {
            return Integer.toBinaryString(decimal);
        }

        Stack<Integer> stack = new Stack<>();

        while (decimal > 0) {
            stack.push(decimal % 2);
            decimal /= 2;
        }

        StringBuilder binary = new StringBuilder();

        while (!stack.isEmpty()) {
            binary.append(stack.pop());
        }

        return binary.toString();
    }
}
