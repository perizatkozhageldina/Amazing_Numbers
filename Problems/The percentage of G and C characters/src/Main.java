import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine().toLowerCase();
        String[] splitWord = word.split("");
        int count = 0;

        for (int i = 0; i < splitWord.length; i++) {
            if (word.charAt(i) == 'g' || word.charAt(i) == 'c') {
                count++;
            }
        }

        double result;
        result = (double) (count * 100) / splitWord.length;
        System.out.println(result);

    }
}