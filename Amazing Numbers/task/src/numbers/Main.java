package numbers;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Amazing Numbers!\n" +
                "\n" +
                "Supported requests:\n" +
                "- enter a natural number to know its properties;\n" +
                "- enter two natural numbers to obtain the properties of the list:\n" +
                "  * the first parameter represents a starting number;\n" +
                "  * the second parameter shows how many consecutive numbers are to be printed;\n" +
                "- two natural numbers and properties to search for;\n" +
                "- a property preceded by minus must not be present in numbers;\n" +
                "- separate the parameters with one space;\n" +
                "- enter 0 to exit.");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a request: ");
            String[] command = scanner.nextLine().split(" ");
            long number = Long.parseLong(command[0]);

            if (number == 0) {
                System.out.println("Goodbye!");
                break;
            } else if (number < 0) {
                System.out.println("The first parameter should be a natural number or zero.");
            } else {
                if (command.length == 1) {
                    printPropertiesOfNumber(number);
                } else {
                    printProperties(number, command);
                }
            }
        }
    }
    public enum Properties {
        EVEN(0, 0), ODD(0, 0),
        DUCK(0, 0), SPY(0, 0),
        SQUARE(0, 0), SUNNY(0, 0),
        HAPPY(0, 0), SAD(0, 0),
        BUZZ(0, 0), PALINDROMIC(0, 0),
        GAPFUL(0, 0), JUMPING(0, 0);

        int plus;
        int minus;
        Properties(int plus, int minus) {
            this.plus = plus;
            this.minus = minus;
        }

        public void addPlus() {
            this.plus++;
        }

        public void addMinus() {
            this.minus++;
        }

        int getPlus() {
            return this.plus;
        }

        int getMinus() {
            return this.minus;
        }

        public void setZeroPlus() {
            this.plus = 0;
        }

        public void setZeroMinus() {
            this.minus = 0;
        }
    }
    public static boolean checkErrors(long n, String[] request) {
        boolean isCorrect = true;
        if (Integer.parseInt(request[1]) < 1) {
            System.out.println("The second parameter should be a natural number.");
            isCorrect = false;
        } else if (request.length > 2) {
            int count = 0;
            StringBuilder errorProperty = new StringBuilder("");
            for (int i = 2; i < request.length; i++) {
                for (Properties props : Properties.values()) {
                    if (request[i].toUpperCase().equals(props.name())) {
                        count++;
                        props.addPlus();
                    } else if (request[i].toUpperCase().equals("-" + props.name())) {
                        count++;
                        props.addMinus();
                    }
                }
                if (count == 0) errorProperty.append(request[i]).append(" ");
                count = 0;
            }
            for (Properties props : Properties.values()) {
                if ((props.getPlus() > 0) && (props.getMinus() > 0)) {
                    isCorrect = false;
                    System.out.println("The request contains mutually exclusive properties: [-" + props.name() + ", " + props.name() + "]\n" +
                            "There are no numbers with these properties.");
                }
            }
            if (Properties.EVEN.getPlus() > 0 && Properties.ODD.getPlus() > 0) {
                isCorrect = false;
                System.out.println("The request contains mutually exclusive properties: [ODD, EVEN]\n" +
                        "There are no numbers with these properties.");
            } else if (Properties.EVEN.getMinus() > 0 && Properties.ODD.getMinus() > 0) {
                isCorrect = false;
                System.out.println("The request contains mutually exclusive properties: [-ODD, -EVEN]\n" +
                        "There are no numbers with these properties.");
            } else if (Properties.DUCK.getPlus() > 0 && Properties.SPY.getPlus() > 0) {
                isCorrect = false;
                System.out.println("The request contains mutually exclusive properties: [DUCK, SPY]\n" +
                        "There are no numbers with these properties.");
            } else if (Properties.DUCK.getMinus() > 0 && Properties.SPY.getMinus() > 0) {
                isCorrect = false;
                System.out.println("The request contains mutually exclusive properties: [-DUCK, -SPY]\n" +
                        "There are no numbers with these properties.");
            } else if (Properties.SQUARE.getPlus() > 0 && Properties.SUNNY.getPlus() > 0) {
                isCorrect = false;
                System.out.println("The request contains mutually exclusive properties: [SQUARE, SUNNY]\n" +
                        "There are no numbers with these properties.");
            } else if (Properties.SQUARE.getMinus() > 0 && Properties.SUNNY.getMinus() > 0) {
                isCorrect = false;
                System.out.println("The request contains mutually exclusive properties: [-SQUARE, -SUNNY]\n" +
                        "There are no numbers with these properties.");
            } else if (Properties.HAPPY.getPlus() > 0 && Properties.SAD.getPlus() > 0) {
                isCorrect = false;
                System.out.println("The request contains mutually exclusive properties: [HAPPY, SAD]\n" +
                        "There are no numbers with these properties.");
            } else if (Properties.HAPPY.getMinus() > 0 && Properties.SAD.getMinus() > 0) {
                isCorrect = false;
                System.out.println("The request contains mutually exclusive properties: [-HAPPY, -SAD]\n" +
                        "There are no numbers with these properties.");
            } else if (errorProperty.length() != 0) {
                isCorrect = false;
                String[] errorPropString = errorProperty.toString().split(" ");
                if (errorPropString.length == 1) {
                    System.out.println("The property [" + errorPropString[0].toUpperCase() + "] is wrong.\n" +
                            "Available properties:\n" +
                            "[EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]");
                } else {
                    System.out.print("The properties [");
                    for (int i = 0; i < errorPropString.length; i++) {
                        System.out.print(errorPropString[i].toUpperCase());
                        if (i != errorPropString.length - 1) {
                            System.out.print(", ");
                        }
                    }
                    System.out.println("] are wrong.\n" +
                            "Available properties:\n" +
                            "[EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]");
                }
            }
        }
        for (Properties props : Properties.values()) {
            props.setZeroPlus();
            props.setZeroMinus();
        }
        return isCorrect;
    }
    public static void printProperties(long number, String[] request){
        if (checkErrors(number, request)) {
            int size = 0;
            while (size != Integer.parseInt(request[1])) {
                int count = 0;
                for (int i = 2; i < request.length; i++) {
                    switch (request[i].toLowerCase()) {
                        case "even":
                            if (isEven(number)) {
                                count++;
                            }
                            break;
                        case "-even":
                            if (!isEven(number)) {
                                count++;
                            }
                            break;
                        case "odd":
                            if (isOdd(number)) {
                                count++;
                            }
                            break;
                        case "-odd":
                            if (!isOdd(number)) {
                                count++;
                            }
                            break;
                        case "buzz":
                            if (isBuzz(number)) {
                                count++;
                            }
                            break;
                        case "-buzz":
                            if (!isBuzz(number)) {
                                count++;
                            }
                            break;
                        case "duck":
                            if (isDuck(number)) {
                                count++;
                            }
                            break;
                        case "-duck":
                            if (!isDuck(number)) {
                                count++;
                            }
                            break;
                        case "palindromic":
                            if (isPalindromic(number)) {
                                count++;
                            }
                            break;
                        case "-palindromic":
                            if (!isPalindromic(number)) {
                                count++;
                            }
                            break;
                        case "gapful":
                            if (isGapful(number)) {
                                count++;
                            }
                            break;
                        case "-gapful":
                            if (!isGapful(number)) {
                                count++;
                            }
                            break;
                        case "spy":
                            if (isSpy(number)) {
                                count++;
                            }
                            break;
                        case "-spy":
                            if (!isSpy(number)) {
                                count++;
                            }
                            break;
                        case "square":
                            if (isSquare(number)) {
                                count++;
                            }
                            break;
                        case "-square":
                            if (!isSquare(number)) {
                                count++;
                            }
                            break;
                        case "sunny":
                            if (isSunny(number)) {
                                count++;
                            }
                            break;
                        case "-sunny":
                            if (!isSunny(number)) {
                                count++;
                            }
                            break;
                        case "jumping":
                            if (isJumping(number)) {
                                count++;
                            }
                            break;
                        case "-jumping":
                            if (!isJumping(number)) {
                                count++;
                            }
                        case "happy":
                            if (isHappy(number)) {
                                count++;
                            }
                            break;
                        case "-happy":
                            if (!isHappy(number)) {
                                count++;
                            }
                            break;
                        case "sad":
                            if (isSad(number)) {
                                count++;
                            }
                            break;
                        case "-sad":
                            if (!isSad(number)) {
                                count++;
                            }
                            break;
                    }
                }
                if (count == request.length - 2) {
                    printPropertiesOfList(number);
                    size++;
                }
                number++;
            }
        }
    }
    public static void printPropertiesOfNumber(long n) {
        System.out.println("Properties of " + n);
        System.out.println("even: " + isEven(n));
        System.out.println("odd: " + isOdd(n));
        System.out.println("buzz: " + isBuzz(n));
        System.out.println("duck: " + isDuck(n));
        System.out.println("palindromic: " + isPalindromic(n));
        System.out.println("gapful: " + isGapful(n));
        System.out.println("spy: " + isSpy(n));
        System.out.println("square: " + isSquare(n));
        System.out.println("sunny: " + isSunny(n));
        System.out.println("jumping: " + isJumping(n));
        System.out.println("happy: " + isHappy(n));
        System.out.println("sad: " + isSad(n));
    }
    public static void printPropertiesOfList(long n) {
        System.out.print(n + " is ");
        if (isSad(n)) System.out.print("sad, ");
        if (isHappy(n)) System.out.print("happy, ");
        if (isJumping(n)) System.out.print("jumping, ");
        if (isSunny(n)) System.out.print("sunny, ");
        if (isSquare(n)) System.out.print("square, ");
        if (isSpy(n)) System.out.print("spy, ");
        if (isBuzz(n)) System.out.print("buzz, ");
        if (isDuck(n)) System.out.print("duck, ");
        if (isPalindromic(n)) System.out.print("palindromic, ");
        if (isGapful(n)) System.out.print("gapful, ");
        if (isEven(n)) System.out.print("even");
        if (isOdd(n)) System.out.print("odd");
        System.out.println("");
    }
    public static boolean isEven(long n) {
        return n % 2 == 0;
    }
    public static boolean isOdd(long n) {
        return n % 2 != 0;
    }
    public static boolean isBuzz(long n) {
        return n % 10 == 7 || n % 7 == 0;
    }
    public static boolean isDuck(long n) {
        boolean duck = false;

        while (n >= 10) {
            if (n % 10 == 0) {
                duck  = true;
                break;
            }
            n = n / 10;
        }
        return duck;
    }
    public static boolean isPalindromic(long n) {
        boolean palindromic;
        if (n < 10) {
            palindromic = true;
        } else {
            long count = 0;
            long number1 = n;
            long number2 = n;
            long newNumber = 0;
            while (number1 > 0) {
                number1 = number1 / 10;
                count++;
            }

            while (count > 0) {
                newNumber += (number2 % 10) * (long) Math.pow(10, count - 1);
                number2 /= 10;
                count--;
            }
            palindromic = n == newNumber;
        }

        return palindromic;
    }
    public static boolean isGapful(long n) {
        boolean gapful;
        long secondDigit = n % 10;
        long firstDigit = n;

        while (firstDigit / 10 > 0) {
            firstDigit /= 10;
        }

        if (n < 100) {
            gapful = false;
        } else  {
            gapful = n % (firstDigit * 10 + secondDigit) == 0;
        }

        return gapful;
    }
    public static boolean isSpy(long n) {
        long sum = 0;
        long multiplication = 1;

        while (n > 0) {
            long lastDigit = n % 10;
            sum += lastDigit;
            multiplication *= lastDigit;
            n /= 10;
        }
        return sum == multiplication;
    }
    public static boolean isSquare(long n) {
        double sqrt = Math.sqrt(n);
        double floor = Math.floor(sqrt);
        boolean square = sqrt - floor == 0;
        return square;
    }
    public static boolean isSunny(long n) {
        return (isSquare(n + 1));
    }
    public static boolean isJumping(long n) {
        boolean jumping = true;
        int lastDigit;
        int beforeLastDigit;

        while (n > 0) {
            if (n < 10) {
                break;
            }

            lastDigit = (int) n % 10;
            beforeLastDigit = n < 100 ? (int) n / 10 : (int) (n % 100) / 10;

            if (Math.abs(lastDigit - beforeLastDigit) != 1) {
                jumping = false;
                break;
            }
            n /= 10;
        }
        return jumping;
    }
    public static long sqrSum (long number) {
        long result = 0;
        while (number != 0){
            result += Math.pow(number % 10, 2);
            number /= 10;
        }
        return result;
    }
    public static boolean isHappy(long n) {
        n *= 10;
        while (n / 10 != 0) {
            n = sqrSum(n);
        }
        return n == 1;
    }
    public static boolean isSad(long n) {
        return !isHappy(n);
    }
}