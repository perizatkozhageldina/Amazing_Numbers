import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();
        String newWord = "";
        int size = word.length();

        if (size % 2 == 0) {
            for (int i = 0; i < size; i++) {
                if (i + 1 == size / 2 || i + 1 == size / 2 + 1) {
                    continue;
                }
                newWord += word.charAt(i);
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (i + 1 == size / 2 + 1) {
                    continue;
                }
                newWord += word.charAt(i);
            }
        }
        System.out.println(newWord);
    }
}