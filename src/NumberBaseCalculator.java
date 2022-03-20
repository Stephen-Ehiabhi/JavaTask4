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
                String base = sc.next();

                System.out.println("Please input the number");
                String number = sc.next();

                System.out.println("____________________________________________________________");
                System.out.println("Solution = " + ConvertToDecimal(number, Integer.parseInt(base)) + " base " + "10");
                System.out.println();

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
                System.out.println("Solution: " + DivideNumberSystem());
            } else {
                System.out.println("Exiting....");
                active = false;
            }
        } while (active);
    }

    //method that shows the menu
    public static String Menu() {
        Scanner sc = new Scanner(System.in);

        System.out.println("------------------------------------------------");
        System.out.println("Choose what operation you want to perform: ");
        System.out.println();
        System.out.println("A. Convert from any system to the decimal system: ");
        System.out.println("B. Convert from Decimal system to another system: ");
        System.out.println("C. Summing up numbers from different systems: ");
        System.out.println("D. Subtracting numbers from different systems: ");
        System.out.println("E. Multiplying numbers from different systems: ");
        System.out.println("F. Dividing numbers from different systems: ");
        System.out.println();
        System.out.println("Type any key to Exit the program: ");

        return sc.next();
    }

    //method to convert to decimal
    public static String AddNumberSystem() {
        return CalculateNumberSystem("sum");
    }

    //method to convert to decimal
    public static String DivideNumberSystem() {
        return CalculateNumberSystem("divide");
    }

    //method to convert to decimal
    public static String SubtractNumberSystem() {
        return CalculateNumberSystem("subtract");
    }

    //method to convert to decimal
    public static String MultiplyNumberSystem() {
        return CalculateNumberSystem("multiply");
    }


    //method to convert to decimal
    public static int ConvertToDecimal(String number, int base) {
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

    //method to calculate number system
    //this method gets two values from the user and the number base,
    // it first converts the values to decimal and then convert it back to its original base with the help of another method
    public static String CalculateNumberSystem(String sign) {
        String answer;
        int computeDecimals;

        System.out.println("_______________________________");
        System.out.println(sign + " Numbers from same system");
        System.out.println("_______________________________");
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the number base. ");
        String base = sc.next();

        System.out.println("Please enter the first number you want to add. ");
        String firstNumber = sc.next();

        System.out.println("Please enter the second number. ");
        String SecondNumber = sc.next();

        int convertedToDecimal1 = ConvertToDecimal(firstNumber, Integer.parseInt(base));
        int convertedToDecimal2 = ConvertToDecimal(SecondNumber, Integer.parseInt(base));

        if (sign.equals("sum")) {
            computeDecimals = convertedToDecimal1 + convertedToDecimal2;
        } else if (sign.equals("subtract")) {
            computeDecimals = convertedToDecimal1 - convertedToDecimal2;
        } else if (sign.equals("divide")) {
            computeDecimals = convertedToDecimal1 / convertedToDecimal2;
        } else {
            computeDecimals = convertedToDecimal1 * convertedToDecimal2;
        }

        answer = ConvertDecimalToAnyNumberBase(computeDecimals, Integer.parseInt(base));
        return answer;
    }


    //method to convert decimal to any number base
    public static String ConvertDecimalToAnyNumberBase(int number, int base) {
        String joinedString = "";
        int values, n;
        n = number;
        //list to store remainders
        List<Character> remainderList = new ArrayList<>();
        //loop to store each remainder in the remainderList
        for (int i = 0; n > 0; i++) {
            values = n % base;
            remainderList.add(Character.forDigit(values, 10));
            n /= base;
        }
        //loop to concat string stored in the reverse array to another stringed variable
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
    public static int compute(List<Character> value, int base) {
        double total;
        int sum = 0;

        for (int i = 1; i <= value.size(); i++) {
            total = Character.getNumericValue(value.get(i - 1)) * Math.pow(base, i - 1);
            sum += (int) total;
        }
        return sum;
    }
}
