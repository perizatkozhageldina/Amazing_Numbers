import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] l = str.split("");
        String v = "aeiouy";
        boolean isVowels;
        boolean isConsonants;
        int count = 0;

        for (int i = 0; i < l.length - 2; i++) {
            isVowels = v.contains(l[i]) && v.contains(l[i + 1]) && v.contains(l[i + 2]);
            isConsonants = !v.contains(l[i]) && !v.contains(l[i + 1]) && !v.contains(l[i + 2]);
            if (isVowels || isConsonants) {
                count++;
                i++;
            }
        }
        System.out.println(count);
    }
}