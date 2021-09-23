import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int parts = scanner.nextInt();
        int ready = 0;
        int removed = 0;
        int fixed = 0;
        for (int i = 0; i < parts; i++) {
            int detector = scanner.nextInt();
            switch (detector) {
                case 0:
                    ready++;
                    continue;
                case 1:
                    fixed++;
                    continue;
                case -1:
                    removed++;
            }
        }
        System.out.println(ready + " " + fixed + " " + removed);
    }
}