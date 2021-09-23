import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        int innerCount = 0;
        int outerCount = 0;

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == str2.charAt(0)) {
                for (int j = 0; j < str2.length(); j++) {
                    if (str2.charAt(j) == str1.charAt(i)) {
                        innerCount++;
                        if (i == str1.length() - 1) {
                            break;
                        } else {
                            i++;
                        }
                    }
                }
                if (innerCount == str2.length()) {
                    outerCount++;
                }
                innerCount = 0;
            }
        }
        System.out.println(outerCount);
    }
}