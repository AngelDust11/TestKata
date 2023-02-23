import java.util.Objects;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String res = calc(input);
        System.out.printf("%s", res);
    }

    public static String calc(String input) {
        String[] oper = input.split(" ");
        if (oper.length > 3){
            return "throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)";
        }

        if ((oper[1].length() != 1) || (oper[1].matches("[^-+*/]"))) {
            return "throws Exception //т.к. неверный операнд";
        }

        if ((oper[0].matches("[0-9]") && oper[2].matches("[0-9]"))) {
            int op1 = Integer.parseInt(oper[0]);
            int op2 = Integer.parseInt(oper[2]);
            int res = 0;

            if (Objects.equals(oper[1], "+")) {
                res = op1 + op2;
            } else if (Objects.equals(oper[1], "*")) {
                res = op1 * op2;
            } else if (Objects.equals(oper[1], "-")) {
                res = op1 - op2;
            } else if (Objects.equals(oper[1], "/")) {
                res = op1 / op2;
            } else {
                return "throws Exception //т.к. неверный операнд2";
            }

            return Integer.toString(res);

        } else if (!oper[0].matches("[^VXI]") && !oper[2].matches("[^VXI]"))  {

        } else {

        }
        return "Конец";
    }
}