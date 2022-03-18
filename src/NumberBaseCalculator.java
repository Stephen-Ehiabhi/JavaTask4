import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberBaseCalculator {
    public static void main(String[] args) {
        String choice = Menu();

        if(choice.equals("A") || choice.equals("a")){
            ConvertToDecimal();
            Menu();
        }

        //System.out.println();

    }

    //method that shows the menu
    public static String Menu() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Menu");
        System.out.println("Choose what operation you want to perform: ");
        System.out.println("A. Convert from any system to the decimal system: ");
        System.out.println("B. Convert from Decimal system to another system: ");
        System.out.println("C. Summing up numbers from different systems: ");
        System.out.println("D. Subtracting numbers from different systems: ");
        System.out.println("E. Multiplying numbers from different systems: ");
        System.out.println("F. Dividing numbers from different systems: ");
        System.out.println("X. Exit the program: ");

        return sc.next();

    }

    //method to convert to decimal
    public static void ConvertToDecimal() {
        char values;
        int solution;
        List<Character> reversedArray;
        List<Character> singleNumber = new ArrayList<Character>();

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the number base you'd like us convert to a decimal. ");
        char base = sc.next().charAt(0);

        System.out.println("Please input the number");
        String number = sc.next();

        for (int i = 0; i < number.length(); i++) {
            //  lengthNumber = number.length();
            values = number.charAt(i);
            singleNumber.add(values);
        }
        reversedArray = new ArrayList<Character>(reverseArray(singleNumber));

        int answer =  compute(reversedArray,base);

        System.out.println("");
        System.out.println("____________________________________________________________");
        System.out.println(number + " base " + base + " = " + answer + " base " + "10");
        System.out.println("____________________________________________________________");
        System.out.println("____________________________________________________________");
    }

    //method to reverse data in an array
    public static List<Character> reverseArray(List<Character> singleNumber) {
        List<Character> newList = new ArrayList<Character>();

        for (int i = singleNumber.size(); i <= singleNumber.size(); i--) {
            if (i <= 0) {
                break;
            }
            newList.add(singleNumber.get(i - 1));
        }
        return newList;
    }

    //method to compute number * base ^ index
    public static int compute (List<Character> value, char basee) {
        int base = Character.getNumericValue(basee);
        double total;
        int sum = 0;

        for(int i = 1; i <= value.size(); i++){
           total = Character.getNumericValue(value.get(i-1)) * Math.pow(base,i-1);
           sum += (int) total;
        }

       return sum;
    }
}
