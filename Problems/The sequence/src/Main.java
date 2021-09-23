import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int max = 0;

        for (int i = 0; i < count; i++) {
            int number = scanner.nextInt();
            if (number % 4 == 0) {
                max = Math.max(max, number);
            }
        }
        System.out.println(max);
    }
}