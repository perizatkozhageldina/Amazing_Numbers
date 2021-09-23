import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;
        int max = 0;
        while (scanner.hasNext()) {
            number = scanner.nextInt();
            if (number != 0) {
                max = Math.max(number, max);
            }
        }
        System.out.println(max);
    }
}