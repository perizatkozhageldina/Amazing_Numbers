import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();
        String[] letters = word.split("");
        String newLetters = "";

        for (String letter : letters) {
            newLetters += letter;
            newLetters += letter;
        }

        System.out.println(newLetters);
    }
}