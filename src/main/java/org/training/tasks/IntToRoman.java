package org.training.tasks;

public class IntToRoman {

    public static void execute() {
        StringBuilder builder = new StringBuilder();
        intToRomanInternal(builder, 3749);
        System.out.println(builder);
    }

    private static void appendMultipleAndProceed(StringBuilder builder, int num, int count, String literal, int factor){
        builder.append(literal.repeat(count));
        intToRomanInternal(builder, num - count*factor);
    }

    private static void appendSingleAndProceed(StringBuilder builder, int num, String literal, int factor){
        builder.append(literal);
        intToRomanInternal(builder, num - factor);
    }

    private static void intToRomanInternal(StringBuilder builder, int num){
        int count;
        if ((count = num / 1000) > 0)
            appendMultipleAndProceed(builder, num, count, "M", 1000);
        else if (num / 900  > 0)
            appendSingleAndProceed(builder, num, "CM", 900);
        else if (num / 500 > 0)
            appendSingleAndProceed(builder, num, "D", 500);
        else if (num / 400 > 0)
            appendSingleAndProceed(builder, num, "CD", 400);
        else if ((count = num / 100) > 0)
            appendMultipleAndProceed(builder, num, count, "C", 100);
        else if (num / 90 > 0)
            appendSingleAndProceed(builder, num, "XC", 90);
        else if (num / 50 > 0)
            appendSingleAndProceed(builder, num, "L", 50);
        else if (num / 40 > 0)
            appendSingleAndProceed(builder, num, "XL", 40);
        else if ((count = num / 10) > 0)
            appendMultipleAndProceed(builder, num, count, "X", 10);
        else if (num / 9 > 0)
            appendSingleAndProceed(builder, num, "IX", 9);
        else if (num / 5 > 0)
            appendSingleAndProceed(builder, num, "V", 5);
        else if (num / 4 > 0)
            appendSingleAndProceed(builder, num, "IV", 4);
        else if (num > 0)
            appendMultipleAndProceed(builder, num, num, "I", 1);

    }

}
