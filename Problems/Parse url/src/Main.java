import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String url = scanner.nextLine();
        String[] str1 = url.split("\\?");
        String[] parameters = str1[1].split("&");
        String[] parameter;
        Boolean isPasswordExists = false;
        String pass = "";

        for (String s : parameters) {
            parameter = s.split("=");
            if (parameter[0].equals("pass")) {
                isPasswordExists = true;
                pass = parameter[1];
            }

            if (parameter.length == 1) {
                System.out.println(parameter[0] + " : not found");
            } else {
                System.out.println(parameter[0] + " : " + parameter[1]);
            }
        }
        if (isPasswordExists) {
            System.out.println("password : " + pass);
        }
    }
}