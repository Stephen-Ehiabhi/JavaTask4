import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberBaseCalculator {
    public static void main(String[] args) {
        Boolean active = true;

        do {
            String choice = Menu();
            if (choice.equals("A") || choice.equals("a")) {
                System.out.println("_______________________________");
                System.out.println("Convert To Decimal");
                System.out.println("_______________________________");
                Scanner sc = new Scanner(System.in);
                System.out.println("Please enter the number base you'd like us convert to a decimal. ");
                char base = sc.next().charAt(0);

                System.out.println("Please input the number");
                String number = sc.next();

                System.out.println("____________________________________________________________");
                System.out.println("Solution = " + ConvertToDecimal(number, base) + " base " + "10");
                System.out.println("");

            } else if (choice.equals("B") || choice.equals("b")) {
                System.out.println("_______________________________");
                System.out.println("Convert Decimal To Any Base");
                System.out.println("_______________________________");
                Scanner sc = new Scanner(System.in);

                System.out.println("Please enter the decimal number: ");
                int number = sc.nextInt();

                System.out.println("Please enter the base you want to convert to: ");
                int base = sc.nextInt();

                System.out.println("_________________________________");
                System.out.println(number + " base 10 = " + ConvertDecimalToAnyNumberBase(number, base) + " base " + base);
            } else if (choice.equals("C") || choice.equals("c")) {
                System.out.println("Solution: " + AddNumberSystem());
            } else if (choice.equals("D") || choice.equals("d")) {
                System.out.println("Solution: " + SubtractNumberSystem());
            } else if (choice.equals("E") || choice.equals("e")) {
                System.out.println("Solution: " + MultiplyNumberSystem());
            } else if (choice.equals("F") || choice.equals("f")) {
                System.out.println("Solution: " +  DivideNumberSystem());
            } else {
                System.out.println("Exiting....");
                active = false;
            }
        } while (active);
    }

    //method that shows the menu
    public static String Menu() {
        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.println("------------------------------------------------");
        System.out.println("                    MENU");
        System.out.println("------------------------------------------------");
        System.out.println("Choose what operation you want to perform: ");
        System.out.println("A. Convert from any system to the decimal system: ");
        System.out.println("B. Convert from Decimal system to another system: ");
        System.out.println("C. Summing up numbers from different systems: ");
        System.out.println("D. Subtracting numbers from different systems: ");
        System.out.println("E. Multiplying numbers from different systems: ");
        System.out.println("F. Dividing numbers from different systems: ");
        System.out.println("Type any key to Exit the program: ");

        return sc.next();
    }

    //method to convert to decimal
    public static String AddNumberSystem() {
        return CalulateNumberSystem("sum");
    }

    //method to convert to decimal
    public static String DivideNumberSystem() {
        return CalulateNumberSystem("divide");
    }

    //method to convert to decimal
    public static String SubtractNumberSystem() {
        return CalulateNumberSystem("subtract");
    }

    //method to convert to decimal
    public static String MultiplyNumberSystem() {
        return CalulateNumberSystem("multiply");
    }


    //method to convert to decimal
    public static int ConvertToDecimal(String number, char base) {
        char values;
        List<Character> reversedArray;
        List<Character> singleNumber = new ArrayList<>();

        for (int i = 0; i < number.length(); i++) {
            values = number.charAt(i);
            singleNumber.add(values);
        }
        reversedArray = new ArrayList<>(reverseArray(singleNumber));
        int answer = compute(reversedArray, base);
        return answer;
    }

    //method to convert to decimal
    public static String CalulateNumberSystem(String sign) {
        char values;
        String answer;
        int computeDecimals;

        System.out.println("_______________________________");
        System.out.println(sign + " Numbers from same system");
        System.out.println("_______________________________");
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the number base. ");
        char base = sc.next().charAt(0);

        System.out.println("Please enter the first number you want to add. ");
        String firstNumber = sc.next();

        System.out.println("Please enter the second number. ");
        String SecondNumber = sc.next();

        int convertedToDecimal1 = ConvertToDecimal(firstNumber, base);
        int convertedToDecimal2 = ConvertToDecimal(SecondNumber, base);

        if (sign.equals("sum")) {
            computeDecimals = convertedToDecimal1 + convertedToDecimal2;
        } else if (sign.equals("subtract")) {
            computeDecimals = convertedToDecimal1 - convertedToDecimal2;
        } else if (sign.equals("divide")) {
            computeDecimals = convertedToDecimal1 / convertedToDecimal2;
        } else {
            computeDecimals = convertedToDecimal1 * convertedToDecimal2;
        }

        answer = ConvertDecimalToAnyNumberBase(computeDecimals, Character.getNumericValue(base));
        return answer;
    }


    //method to convert decimal to any number base
    public static String ConvertDecimalToAnyNumberBase(int number, int base) {
        int values, n;
        List<Character> remainderList = new ArrayList<>();
        n = number;
        String joinedString = "";

        for (int i = 0; n > 0; i++) {
            values = n % base;
            remainderList.add(Character.forDigit(values, 10));
            n /= base;
        }

        for (int i = 0; i < reverseArray(remainderList).size(); i++) {
            joinedString += reverseArray(remainderList).get(i);
        }
        return joinedString;
    }


    //method to reverse data in an array
    public static List<Character> reverseArray(List<Character> singleNumber) {
        List<Character> newList = new ArrayList<>();

        for (int i = singleNumber.size(); i <= singleNumber.size(); i--) {
            if (i <= 0) {
                break;
            }
            newList.add(singleNumber.get(i - 1));
        }
        return newList;
    }


    //method to compute number * base ^ index
    public static int compute(List<Character> value, char basee) {
        int base = Character.getNumericValue(basee);
        double total;
        int sum = 0;

        for (int i = 1; i <= value.size(); i++) {
            total = Character.getNumericValue(value.get(i - 1)) * Math.pow(base, i - 1);
            sum += (int) total;
        }
        return sum;
    }
}
