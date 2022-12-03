import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if(input.matches("^\\d+\\s\\W\\s\\d+$")) {
            System.out.println(calc(input));
        } else if (input.matches("^[VIX]+\\s\\W\\s[VIX]+$")){
            System.out.println(calcRome(input));
        } else {
            throw new RuntimeException("Данные введены некорректно");
        }
    }

    public static String calc(String input) {
        Pattern pattern = Pattern.compile("^\\d+\\s\\W\\s\\d+$");
        Matcher matcher = pattern.matcher(input);
        int result = 0;
        if(matcher.find()) {
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
        } else{
            throw new RuntimeException("Данные введены некорректно");
        }

        return Integer.toString(result);
    }

    public static String calcRome(String input) {
        HashMap<String, Integer> rome = new HashMap<>();
        rome.put("I", 1);
        rome.put("II", 2);
        rome.put("III", 3);
        rome.put("IV", 4);
        rome.put("V", 5);
        rome.put("VI", 6);
        rome.put("VII", 7);
        rome.put("VIII", 8);
        rome.put("IX", 9);
        rome.put("X", 10);

        Pattern pattern = Pattern.compile("^[VIX]+\\s\\W\\s[VIX]+$");        //VI - V
        Matcher matcher = pattern.matcher(input);
        int result = 0;
        String resultRome = null;
        if(matcher.find()) {
            String[] args = input.split(" ");

            if(rome.get(args[0]) > 10 || rome.get(args[2]) > 10) {
                throw new RuntimeException("Данные введены некорректно");
            } else if (rome.get(args[0]) < 1 || rome.get(args[2]) < 1) {
                throw new RuntimeException("Данные введены некорректно");
            }

            if(args[1].equals("+")) {
                result = rome.get(args[0]) + rome.get(args[2]);
            } else if (args[1].equals("-")) {
                result = rome.get(args[0]) - rome.get(args[2]);
            } else if (args[1].equals("*")) {
                result = rome.get(args[0]) * rome.get(args[2]);
            } else if (args[1].equals("/")) {
                result = rome.get(args[0]) / rome.get(args[2]);
            }else {
                throw new RuntimeException("Данные введены некорректно");
            }
        } else{
            throw new RuntimeException("Данные введены некорректно");
        }

        for(var pair : rome.entrySet()) {
            String key = pair.getKey();
            Integer value = pair.getValue();
            if(result == value){
                resultRome = key;
            }
        }
        if(resultRome == null) throw new RuntimeException("в римской системе нет 0 и отрицательных чисел");

        return resultRome;
    }
}
