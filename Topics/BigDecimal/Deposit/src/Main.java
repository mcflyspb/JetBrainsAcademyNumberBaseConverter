import com.sun.source.tree.NewArrayTree;

import java.math.BigDecimal;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        String s3 = scanner.nextLine();
        BigDecimal b1 = new BigDecimal(s1);
        BigDecimal b2 = new BigDecimal(s2);
        int b3 = Integer.parseInt(s3);
        b2 = b2.divide(new BigDecimal("100"));
        b2 = b2.add(new BigDecimal("1"));
        b2 = b2.pow(b3);

        BigDecimal result = b1.multiply(b2).setScale(2, BigDecimal.ROUND_CEILING);
        System.out.printf("Amount of money in the account: %s", result);

        // write your code here
    }
}