import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();
        String backward = "";
        int check = 0;

        for (int i = word.length() - 1; i >= 0; i--) {
            backward += word.charAt(i);
        }

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == backward.charAt(i)) {
                check++;
            }
        }
        if (word.length() == check) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}