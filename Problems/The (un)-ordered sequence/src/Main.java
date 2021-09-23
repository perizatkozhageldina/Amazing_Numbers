import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int asc = 0;
        int desc = 0;
        int prevNumber = 0;
        boolean ordered = false;

        while (scanner.hasNext()) {
            int number = scanner.nextInt();
            if (number == 0) {
                break;
            }
            count++;
            if (prevNumber == 0) {
                prevNumber = number;
            }
            if (number >= prevNumber) {
                asc++;
            }
            if (number <= prevNumber) {
                desc++;
            }
            prevNumber = number;
        }
        if (count == asc || count == desc) {
            ordered = true;
        }
        System.out.println(ordered);
    }
}