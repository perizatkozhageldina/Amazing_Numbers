import java.util.Scanner;

class ConcatenateStringsProblem {

    public static String concatenateStringsWithoutDigits(String[] strings) {
        StringBuilder result = new StringBuilder("");
        for (String string : strings) {
            int j = 0;
            while (j < string.length()) {
                char ch = string.charAt(j);
                if (!Character.isDigit(ch)) {
                    result.append(string.charAt(j));
                }
                j++;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split("\\s+");
        String result = concatenateStringsWithoutDigits(strings);
        System.out.println(result);
    }
}