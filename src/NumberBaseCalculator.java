import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberBaseCalculator {
    public static void main(String[] args) {
        Boolean active = true;

        do {
            String choice = Menu();

            if (choice.equals("A") || choice.equals("a")) {
                ConvertToDecimal();

            } else if (choice.equals("B") || choice.equals("b")) {
                ConvertDecimalToAnyNumberBase();

            } else if (choice.equals("C") || choice.equals("c")) {
                ConvertDecimalToAnyNumberBase();

            } else if (choice.equals("D") || choice.equals("d")) {
                ConvertToDecimal();
            } else if (choice.equals("E") || choice.equals("e")) {
                ConvertToDecimal();
            } else if (choice.equals("F") || choice.equals("f")) {
                ConvertToDecimal();
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
    public static void ConvertToDecimal() {
        char values;
        List<Character> reversedArray;
        List<Character> singleNumber = new ArrayList<>();

        System.out.println("_______________________________");
        System.out.println("Convert To Decimal");
        System.out.println("_______________________________");
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the number base you'd like us convert to a decimal. ");
        char base = sc.next().charAt(0);

        System.out.println("Please input the number");
        String number = sc.next();

        for (int i = 0; i < number.length(); i++) {
            values = number.charAt(i);
            singleNumber.add(values);
        }
        reversedArray = new ArrayList<>(reverseArray(singleNumber));

        int answer = compute(reversedArray, base);

        System.out.println("____________________________________________________________");
        System.out.println("Solution = " + answer + " base " + "10");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
    }


    //method to convert decimal to any number base
    public static void ConvertDecimalToAnyNumberBase() {
        int values, n;
        List<Character> remainderList = new ArrayList<>();

        System.out.println("_______________________________");
        System.out.println("Convert Decimal To Any Base");
        System.out.println("_______________________________");
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter the decimal number: ");
        int number = sc.nextInt();
        n = number;

        System.out.println("Please enter the base you want to convert to: ");
        int base = sc.nextInt();

        for (int i = 0; n > 0; i++) {
            values = n % base;
            remainderList.add(Character.forDigit(values,10));
            n /= base;
        }

        String joinedString = "";

        for(int i = 0; i < reverseArray(remainderList).size(); i++){
            joinedString += reverseArray(remainderList).get(i);
        }

        System.out.println("_________________________________");
        System.out.println(number + " base 10 = " + joinedString + " base " + base);
        System.out.println("");
        System.out.println("");
        System.out.println("");
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
