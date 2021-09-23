import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int check = 0;

        for (int i = 0; i < alphabet.length(); i++) {
            if (alphabet.charAt(i) == word.charAt(0)) {
                for (int j = 0; j < word.length(); j++) {
                    if (word.charAt(j) == alphabet.charAt(i)) {
                        check++;
                        i++;
                    }
                }
                break;
            }
        }
        if (word.length() == check) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}