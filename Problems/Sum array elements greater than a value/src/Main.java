import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] array = new int[len];

        for (int i = 0; i < len; i++) {
            array[i] = scanner.nextInt();
        }

        int number = scanner.nextInt();

        int sum = 0;
        for (int i = 0; i < len; i++) {
            if (array[i] > number) {
                sum += array[i];
            }
        }
        System.out.println(sum);
    }
}