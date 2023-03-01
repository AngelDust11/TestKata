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
            return "throws Exception";
        }

        if ((oper[1].length() != 1) || (oper[1].matches("[^-+*/]"))) {
            return "throws Exception";
        }

        if ((oper[0].matches("\\d+") && oper[2].matches("\\d+"))) {
            int op1 = Integer.parseInt(oper[0]);
            int op2 = Integer.parseInt(oper[2]);
            if (op1 > 10 || op2 > 10 ) {
                return "throws Exception";
            }
            int res;

            if (Objects.equals(oper[1], "+")) {
                res = op1 + op2;
            } else if (Objects.equals(oper[1], "*")) {
                res = op1 * op2;
            } else if (Objects.equals(oper[1], "-")) {
                res = op1 - op2;
            } else if (Objects.equals(oper[1], "/")) {
                res = op1 / op2;
            } else {
                return "throws Exception";
            }

            return Integer.toString(res);

        } else if (!oper[0].matches("[^VXI]") && !oper[2].matches("[^VXI]"))  {
            int op1 = RimInArab(oper[0]);
            int op2 = RimInArab(oper[2]);
            if (op1 > 10 || op2 > 10 ) {
                return "throws Exception";
            }
            int arabres;
            if (Objects.equals(oper[1], "+")) {
                arabres = op1 + op2;
            } else if (Objects.equals(oper[1], "*")) {
                arabres = op1 * op2;
            } else if (Objects.equals(oper[1], "-")) {
                arabres = op1 - op2;
            } else if (Objects.equals(oper[1], "/")) {
                arabres = op1 / op2;
                System.out.printf("%d", arabres);
            } else {
                return "throws Exception";
            }
            String res = ArabToRim(arabres);
            return res;

        }
        return "throws Exception";
    }
    public static String ArabToRim (int arab) {
        String res = "";
        if (arab == 100 ) {
            res = "C";
            return res;
        }
        if (arab > 50 ) {
            res = "L";
            arab = arab - 50;
        }
        if (arab >= 10 ) {
            for (;arab >= 10; arab = arab - 10) {
                res = res + "X";
            }
        }
        if (arab < 10) {
            if (arab == 1) {
                res = res + "I";
            } else if (arab == 2) {
                res = res + "II";
            } else if (arab ==3) {
                res = res + "III";
            } else if (arab == 4) {
                res = res + "IV";
            } else if (arab == 5) {
                res = res + "V";
            } else if (arab == 6) {
                res = res + "VI";
            } else if (arab == 7) {
                res = res + "VII";
            } else if (arab == 8) {
                res = res + "VIII";
            } else if (arab == 9) {
                res = res + "IX";
            } else if (arab == 10) {
                res = res + "X";
            }
        }
        return res;
    }
    public static int RimInArab (String oper) {
        int res = 0;
        if (Objects.equals(oper, "I")) {
             res = 1;
        } else if (Objects.equals(oper, "II")) {
             res = 2;
        } else if (Objects.equals(oper,"III")) {
              res = 3;
        } else if (Objects.equals(oper, "IV")) {
            res = 4;
        } else if (Objects.equals(oper,"V")) {
            res = 5;
        } else if (Objects.equals(oper,"VI")) {
            res = 6;
        } else if (Objects.equals(oper, "VII")) {
            res = 7;
        } else if (Objects.equals(oper, "VIII")) {
            res = 8;
        } else if (Objects.equals(oper, "IX")) {
            res = 9;
        } else if (Objects.equals(oper, "X")) {
            res = 10;
        }
        return res;
    }
}

