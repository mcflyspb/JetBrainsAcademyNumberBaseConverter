import com.sun.source.tree.NewArrayTree;

import java.math.BigDecimal;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        BigDecimal b1 = new BigDecimal(s1);
        BigDecimal b2 = new BigDecimal(s2);
        BigDecimal result = b1.multiply(b2);
        System.out.printf("%s", result);

        // write your code here
    }
}