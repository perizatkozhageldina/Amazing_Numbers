import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();
        int N = scanner.nextInt();

        String result = "";
        int i = 0;

        while (i < N) {
            for (int j = 0; j < A; j++) {
                if (i < N) {
                    if (i % 2 == 0) {
                        result += 'A';
                        i++;
                    } else {
                        result += 'B';
                        i++;
                    }
                }
            }
            for (int k = 0; k < B; k++) {
                if (i < N) {
                    if (k % 2 == 0) {
                        result += 'a';
                        i++;
                    } else {
                        result += 'b';
                        i++;
                    }
                }
            }
            for (int l = 0; l < C; l++) {
                if (i < N) {
                    if (l % 2 == 0) {
                        result += '1';
                        i++;
                    } else {
                        result += '2';
                        i++;
                    }
                }
            }
        }
        System.out.println(result);
    }
}