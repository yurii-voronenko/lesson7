package org.example;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number between 0 and 100:");
        String strNum = sc.nextLine();
        System.out.println("User entered: " + strNum);

        boolean isInteger = isInteger(strNum);
        boolean isNegative = false;
        boolean isPercentMore50 = false;

        if (isInteger) {
            System.out.println("Value is integer");
            int intVal = Integer.parseInt(strNum);
            isNegative = intVal < 0;
            if (isNegative) {
                System.out.println("Value is negative");
            } else if (intVal == 0) {
                System.out.println("Value is zero");
            } else if (intVal <= 50) {
                System.out.println("Value between 1-50");
            } else if (intVal <= 100) {
                System.out.println("Value between 50-100");
                isPercentMore50 = true;
            } else {
                System.out.println("Number is larger than 100");
            }
        } else {
            System.out.println("Value is not integer");
        }

        if (isPercentMore50 || isInteger && isNegative) {
            System.out.println("Value is negative integer or percentage more than 50%");
        }

        // Ternary operator
        // variable = (boolean) ? trueValue : falseValue;
        int divider = isPercentMore50 ? 5 : 2;
        float divValue = isInteger ? (float) Integer.parseInt(strNum) : 100;
        float value = divValue / divider;
        System.out.println("Divider: " + divider + " - " + value);

        // Switch - int, char, byte, Integer, String
        switch (strNum.toLowerCase()) {
            case "app":
                System.out.println("Value is APP");
                break;
            case "test":
                System.out.println("Value is TEST");
                break;
            default:
                System.out.println("Value is not defined");
        }

    }

    static public boolean isInteger(String value) {
        if (value == null || value.isEmpty())
            return false;
        return Pattern.compile("^-*\\d+$").matcher(value).matches();
    }


}