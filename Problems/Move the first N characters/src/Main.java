import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String[] word = text.split(" ");
        String s = word[0];
        int n = Integer.parseInt(word[1]);

        if (n > s.length()) {
            System.out.println(s);
        } else {
            String str1 = "";
            String str2 = "";

            for (int i = 0; i < n; i++) {
                str1 += s.charAt(i);
            }

            for (int j = n; j < s.length(); j++) {
                str2 += s.charAt(j);
            }
            System.out.println(str2 + str1);
        }
    }
}