public class StringManipulator {

    public static boolean isCorrectNumber(int number) {
        return (number >= 1 && number <= 10); // проверка числа на корректность
    }

    public static boolean isCorrectString(String string) {
        return string.matches("^[a-zA-Z0-9. \\[\\]\\{\\}\\(\\)\\-!?:;\"\'#*^%]+$"); // проверка строки на корректность (только англ буквы)
    }

    public static void cutString(String string) {
        if (string.length() > 40) {
            String answer = string.substring(0, 40) + "..."; // если длина больше 40, то после 40-го символа поставить многоточие
            System.out.print(answer);
        } else System.out.print(string);
    }

    public static void addStrings(String firstString, String secondString) { // сложение строк
        System.out.print("\"");
        String answer = firstString + secondString;
        cutString(answer);
        System.out.print("\"");
    }

    public static void subtractStrings(String firstString, String secondString) {
        System.out.print("\"");
        String answer = firstString.replaceAll(secondString, ""); // вычитание строк
        cutString(answer);
        System.out.print("\"");
    }

    public static void multiplyStrings(String firstString, int factor) {
        String result = "";
        System.out.print("\"");
        for (int i = 0; i < factor; i++) {
            result += firstString; // умножение строки, то есть писать строку несколько раз
        }
        cutString(result);
        System.out.print("\"");
    }

    public static void divideStrings(String string, int divider) {
        String result = "";
        if (divider > string.length()) {
            System.out.println("Divider cannot be greater than length of the string.");
        } else {
            System.out.print("\"");
            for (int i = 0; i < string.length() / divider; i++) {
                result += string.charAt(i); // вывести нужное кол-во символов урезанной строки
            }
            cutString(result);
            System.out.print("\"");
        }
    }
}
