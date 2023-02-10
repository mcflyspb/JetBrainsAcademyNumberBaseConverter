import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String string = scanner.nextLine();
        String[] array = string.trim().split(" ");
        int result = 0;
        for (int x = 0; x < size; x++) {
            result = result + Integer.parseInt(array[x]);
        }

        System.out.println(result);
    }
}