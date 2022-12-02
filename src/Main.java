import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(calc(input));

    }

    public static String calc(String input) {
        if(input.length() != 5) {
            throw new RuntimeException("Данные введены некорректно");
        }

        int result = 0;
        String[] args = input.split(" ");

        if(Integer.parseInt(args[0]) > 10 || Integer.parseInt(args[2]) > 10) {
            throw new RuntimeException("Данные введены некорректно");
        } else if (Integer.parseInt(args[0]) < 1 || Integer.parseInt(args[2]) < 1) {
            throw new RuntimeException("Данные введены некорректно");
        }

        if(args[1].equals("+")) {
            result = Integer.parseInt(args[0]) + Integer.parseInt(args[2]);
        } else if (args[1].equals("-")) {
            result = Integer.parseInt(args[0]) - Integer.parseInt(args[2]);
        } else if (args[1].equals("*")) {
            result = Integer.parseInt(args[0]) * Integer.parseInt(args[2]);
        } else if (args[1].equals("/")) {
            result = Integer.parseInt(args[0]) / Integer.parseInt(args[2]);
        }else {
            throw new RuntimeException("Данные введены некорректно");
        }


        return Integer.toString(result);
    }

    public String calcRome(String input) {

    }
}
