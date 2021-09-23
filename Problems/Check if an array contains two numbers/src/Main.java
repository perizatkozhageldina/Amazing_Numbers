import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] array = new int[len];

        for (int i = 0; i < len; i++) {
            array[i] = scanner.nextInt();
        }

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        boolean result = false;

        for (int i = 0; i < len; i++) {
            if (array[i] == n) {
                if (i > 0 && array[i - 1] == m) {
                    result = true;
                    break;
                }
                if (i < len - 1 && array[i + 1] == m) {
                    result = true;
                    break;
                }
            }
        }

        System.out.println(result);
    }
}