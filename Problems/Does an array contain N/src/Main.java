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
        boolean result = false;
        for (int i = 0; i < len; i++) {
            if (array[i] == number) {
                result = true;
                break;
            }
        }
        System.out.println(result);
    }
}