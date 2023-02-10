package converter;

import java.math.BigInteger;
import java.util.Objects;
import java.util.Scanner;


public class Convertor {
    private static final String ENTER_NUMBER = "Enter two numbers in format: {source base} {target base} (To quit type /exit)";
    private static final String ENTER_NUMBER_BASE = "Enter number in base %d to convert to base %d (To go back type /back)\n";
    private static final String SCORE_RESULT = "Conversion result: %s%s\n";

    private static int sourceBase = 0;
    private static int targetBase = 0;
    private static boolean mode = false; // mode.   false - First, true - second (/back possible)


    public static void run(Scanner scanner) {
        String input;
        String[] inputArray;

        while (true) {
            if (!mode) {
                System.out.println(ENTER_NUMBER);
            } else {
                System.out.printf(ENTER_NUMBER_BASE, sourceBase, targetBase);
            }
            input = scanner.nextLine();

            if (Objects.equals(input,"/exit") && !mode) {
                return;
            } else if (Objects.equals(input,"/back") && mode) {
                mode = false;
                continue;
            } else {
                inputArray = input.trim().split(" ");
            }

            if (inputArray.length > 1) {
                sourceBase = Integer.parseInt(inputArray[0]);
                targetBase = Integer.parseInt(inputArray[1]);
                mode = true;
                continue;
            }
            System.out.printf(SCORE_RESULT, convertingFirstNumber(inputArray[0], sourceBase, targetBase), convertingSecondNumber(inputArray[0], sourceBase, targetBase));
        }

    }


    private static String convertingFirstNumber(String numberString, int sourceBase, int targetBase) {
        String[] numberArray = numberString.split("[.]");
        BigInteger bigNumber = new BigInteger(numberArray[0], sourceBase);
        BigInteger bigTargetBase = new BigInteger(String.valueOf(targetBase));

        StringBuilder output = new StringBuilder();
        while (bigNumber.compareTo(bigTargetBase) > -1) {
            BigInteger bigDivider = bigNumber.remainder(bigTargetBase);
            output.append(replaceTenMore(bigDivider));
            bigNumber = bigNumber.divide(bigTargetBase);
        }
        output.append(replaceTenMore(bigNumber));
        return output.reverse().toString();
    }

    private static String convertingSecondNumber(String numberString, int sourceBase, int targetBase) {
        String[] numberArray = numberString.split("[.]");
        if (numberArray.length == 1) {
            return "";
        }

        StringBuilder output = new StringBuilder();
        output.append(".");

        String[] newArray = numberArray[1].split("");
        double result = 0;
        for (int x = 0; x < newArray.length; x++) {

            int digit = Character.getNumericValue(newArray[x].toUpperCase().charAt(0));
            result += digit * Math.pow(sourceBase, -1 - x);
        }

        for (int x = 0; x < 5; x++) {
            double curDigit = result * targetBase;
            int curDigitInt = (int)curDigit;
            String outputLetter = replaceTenMore(new BigInteger(String.valueOf(curDigitInt)));
            output.append(outputLetter);
            result = curDigit - curDigitInt;
        }
        return output.toString();
    }

    private static String replaceTenMore(BigInteger bigDivider) {
        int div = bigDivider.intValue();
        if (div > 9) {
            char letter = (char) (div + 55);
            return "" + letter;
        }
        return "" + div;
    }

}
