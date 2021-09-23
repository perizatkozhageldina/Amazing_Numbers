import java.util.Scanner;

public class Main {

    public static boolean isVowel(char ch) {
        boolean vowel;
        switch (ch) {
            case 'a':
            case 'A':
            case 'o':
            case 'O':
            case 'u':
            case 'U':
            case 'e':
            case 'E':
            case 'i':
            case 'I':
                vowel = true;
                break;
            default:
                vowel = false;
                break;
        }
        return vowel;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char letter = scanner.nextLine().charAt(0);
        System.out.println(isVowel(letter) ? "YES" : "NO");
    }
}