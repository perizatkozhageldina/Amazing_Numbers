import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String[] words = text.split(" ");

        String max = words[0];
        for (int i = 1; i < words.length; i++) {
            if (words[i].length() > max.length()) {
                max = words[i];
            }
        }
        System.out.println(max);
    }
}