import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] str2 = str.split("");
        int count = 1;
        String result = "";

        if (str2.length == 1) {
            result = str2[0] + count;
        } else {
            for (int i = 0; i < str2.length - 1; i++) {
                if (str2[i].equals(str2[i + 1])) {
                    count++;
                    if (i == str2.length - 2) {
                        result += str2[i] + count;
                    }
                } else {
                    result += str2[i] + count;
                    count = 1;
                    if (i == str2.length - 2) {
                        result += str2[i + 1] + count;
                    }
                }
            }
        }
        System.out.println(result);
    }
}