import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        try { // если вдруг ввод будет совсем не корректный, то перейдет в блок catch и сообщит об этом
            String[] expression = new String[3];
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your expression here:");
            String enter = scanner.nextLine(); // Читаем с клавиатуры ввод
            Pattern p = Pattern.compile("\"([^\"]*)\""); // компилируем регулярное выражение, которое будет выуживать информацию между кавычек
            Matcher m = p.matcher(enter); // применение регулярки
            int counter = 0;
            while (m.find()) { // пока есть к чему ее применить
                expression[counter] = m.group(1); // получаем информацию между кавычек
                counter += 2;
            }
            String str;
            String str2;
            String[] splitStr;
            if (expression[2] == null) { // далее в if-else формируем массив из кусочков выражения, решая все проблемы, которые возникают из-за пробелов внутри строки
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
                    if (StringManipulator.isCorrectString(expression[0]) && StringManipulator.isCorrectString(expression[2])) { // если ввод корректен, аналогичная проверка везде
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