import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        try { 
            String[] expression = new String[3];
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your expression here:");
            String enter = scanner.nextLine(); 
            Pattern p = Pattern.compile("\"([^\"]*)\"");
            Matcher m = p.matcher(enter); 
            int counter = 0;
            while (m.find()) { 
                expression[counter] = m.group(1); 
                counter += 2;
            }
            String str;
            String str2;
            String[] splitStr;
            if (expression[2] == null) { 
                str = enter.replace(expression[0], "");
                str2 = str.replace("\"", "").substring(1);
                splitStr = str2.split("\\s+");
                expression[1] = splitStr[0];
                expression[2] = splitStr[1];
            } else {
                str = enter.replace(expression[0], "").replace(expression[2], "").replace("\"", "").substring(1);
                str2 = str.replace(str.substring(str.length() - 1), "");
                expression[1] = str2;
            }
            switch (expression[1]) {
                case "+":
                    if (StringManipulator.isCorrectString(expression[0]) && StringManipulator.isCorrectString(expression[2])) { 
                        StringManipulator.addStrings(expression[0], expression[2]);
                    } else {
                        System.out.println("Enter is incorrect.");
                    }
                    break;
                case "-":
                    if (StringManipulator.isCorrectString(expression[0]) && StringManipulator.isCorrectString(expression[2])) {
                        StringManipulator.subtractStrings(expression[0], expression[2]);
                    } else {
                        System.out.println("Enter is incorrect.");
                    }
                    break;
                case "*":
                    if (StringManipulator.isCorrectString(expression[0]) && StringManipulator.isCorrectNumber(new Integer(expression[2]))) {
                        StringManipulator.multiplyStrings(expression[0], new Integer(expression[2]));
                    } else {
                        System.out.println("Enter is incorrect.");
                    }
                    break;
                case "/":
                    if (StringManipulator.isCorrectString(expression[0]) && StringManipulator.isCorrectNumber(new Integer(expression[2]))) {
                        StringManipulator.divideStrings(expression[0], new Integer(expression[2]));
                    } else {
                        System.out.println("Enter is incorrect.");
                    }
                    break;
                default:
                    System.out.println("Enter is incorrect.");
            }
        } catch (StringIndexOutOfBoundsException stringIndexOutOfBoundsException) {
            System.out.println("Input is incorrect.");
        } catch (NullPointerException nullPointerException) {
            System.out.println("Input is incorrect.");
        }
    }
}
