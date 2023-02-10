import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String first = scanner.nextLine();
        int second = Integer.parseInt(scanner.nextLine());
        BigDecimal bigFirst = new BigDecimal(first);
        bigFirst = bigFirst.setScale(second, RoundingMode.HALF_DOWN);
        System.out.println(bigFirst);

        // write your code here
    }   
}