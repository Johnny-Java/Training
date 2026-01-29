package org.training.tasks;

public class StringToInteger {
    public static void execute(){
        System.out.println(myAtoi("-91283472332"));
    }

    private static int myAtoi(String s){
        Character c;
        boolean signFound = false;
        boolean digitFound = false;
        boolean isPositive = true;
        long result = 0;
        int digitCount = 0;

        for (int i=0;i<s.length();i++){
            c = s.charAt(i);
            if (Character.isDigit(c)) {
                if (!digitFound)
                    digitFound = true;
                result = result * 10 + Character.getNumericValue(c);
                if (result > 0)
                    digitCount ++;
                if (digitCount>10) {
                    if (isPositive)
                        return Integer.MAX_VALUE;
                    else
                        return Integer.MIN_VALUE;
                }
            } else if (digitFound) {
                break;
            } else if (signFound) {
                break;
            } else if (c.equals('-')) {
                signFound = true;
                isPositive = false;
            } else if (c.equals('+')) {
                signFound = true;
            } else if (!c.equals(' ')) {
                break;
            }
        }

        if (!isPositive)
            result = -result;

        if (result < (long) Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        if (result > (long) Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        return (int) result;

    }
}
