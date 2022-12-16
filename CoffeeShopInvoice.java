// Name: Manasse Bosango
// Reason: Understand the importance of what a method returns and what a method has as passed parameters (arguments).

import java.util.Scanner;

public class CoffeeShopInvoice {

    // 1. a class constant that defines the width of the columns of the
    // invoice being printed
    public static final int COL_WIDTH = 15;

    /*
     * 2.
     * padString method that accepts two parameters: a String and an integer
     * representing a length. The method should pad the parameter string with spaces
     * until its length is the given length and return the padded string. For
     * example,
     * padString("hello", 8) should return " hello". If the string's length is
     * already at least as long as the length parameter, your method should return
     * the
     * original string.
     */
    public static String padString(String string, int length) {
        if (length == string.length()) {
            return string;
        } else {
            int l = (length - string.length());
            String s = "";
            for (int i = 0; i < l; i++) {
                s += " ";
            }
            return s + string;
        }
    }

    /*
     * 3.
     * that takes no parameters and prints the logo of the coffee shop
     * as shown in the sample runs above. Use the COL_WIDTH class constant to print
     * the correct size separator lines
     */
    public static void printLogo() {

        // Separation bar of stars "*"
        for (int j = 0; j < COL_WIDTH * 3 + 2; j++) {
            System.out.print("*");
        }
        System.out.println();

        // print the the welcom message
        System.out.println("Welcom come to AM Coffe shop");

        // Separation bar of stars "*"
        for (int j = 0; j < COL_WIDTH * 3 + 2; j++) {
            System.out.print("*");
        }
        System.out.println();

        // Coffe shop Logo
        System.out
                .println("      /\\" + "       |\\    /|" + "\n" + "     /  \\" + "      | \\  / |"
                        + "\n" + "    /    \\" + "     |  \\/  |" + "\n"
                        + "   /------\\" + "    |      | " + "\n"
                        + "  /        \\" + "   |      |" + "\n" + " /          \\" + "  |      |");

        // Separation bar of stars "*"
        for (int j = 0; j < COL_WIDTH * 3 + 2; j++) {
            System.out.print("*");
        }
        System.out.println();
    }

    /*
     * 4.
     */
    public static double roundTo2Decimal(double number) {
     // Rounding the number to 2 decimal places.
        double roundedNumber = Math.round(number * 100.0) / 100.0;
        // System.out.println(roundedNumber);
        return roundedNumber;
    }

    /*
     * 5.
     * ccalculateShippingCost method that accepts the number of pounds ordered and
     * returns the shipping cost rounded to 2 decimal places.
     *
     * Shipping charges are $0.65 per pound + $2.50 fixed cost for
     * overhead
     */
    public static double calculateShippingCost(double poundsOfCoffe) {
        double shippingCharges = (0.65 * poundsOfCoffe) + 2.50;
        // System.out.println(shippingCharges);
        return roundTo2Decimal(shippingCharges);
    }

    /*
     * 6.
     * calculateCostOfCoffee method that accepts the number of pounds ordered and
     * returns the cost of coffee rounded to 2 decimal places.
     *
     * Coffee shop charges $9.50 per pound
     */
    public static double calculateCostOfCoffe(double poundsOfCoffe) {
        double costOfCoffee = poundsOfCoffe * 9.50;
        // System.out.println(costOfCoffee);
        return roundTo2Decimal(costOfCoffee);
    }

    /*
     * 7.
     * calculateTax method that accepts the date and cost of coffee as parameters.
     * It
     * calculates the tax rate, applies it to the cost of coffee and returns the tax
     * amount
     * rounded to 2 decimal places
     *
     * Tax rate is variable depending on the day of the month. Tax
     * percentage is number of days remaining in the month (assuming all
     * months are 31 days long) divided by 5. e.g. on the 5th day of the
     * month, the tax rate is (31 -date)/5 = 5.2 %. Tax is applied only to the
     * cost of coffee
     */
    public static double calculateTax(int date, double costOfCoffee) {
        double taxPercentage = ((31 - date) / 5.0) / 100;
        // System.out.println(taxPercentage);
        double taxAppliedToCostOfCoffe = (taxPercentage) * costOfCoffee;
        // System.out.println(taxAppliedToCostOfCoffe);
        return roundTo2Decimal(taxAppliedToCostOfCoffe);
    }

    // 8.
    public static void printInvoice(int date, double poundsOfCoffe) {
        double shippingCharges = calculateShippingCost(poundsOfCoffe);
        double costOfCoffee = calculateCostOfCoffe(poundsOfCoffe);
        double taxRate = 0.0;
        double totalCost = 0.0;

        // Printing a separation bar of stars "*"
        separationBarOfStarts();

        // print shippingChargs and costOfCoffe
        System.out.println("Shipping Cost: " + "$" + shippingCharges + "\n" + "Cost of coffe: " + "$" + costOfCoffee);

        // It prints a separation bar of stars "*"
        separationBarOfStarts();

        // Title
        System.out.println(
                padString("Date", COL_WIDTH) + padString("Tax", COL_WIDTH + 1) + padString("Total", COL_WIDTH + 1));

        // A method that prints a separation bar of "="
        separationBar();

        // The tax rate and totalCost changes for 3 succecif days
        for (int i = 0; i < 3; i++) {
            taxRate = calculateTax(date + i, costOfCoffee);
            totalCost = roundTo2Decimal(shippingCharges + costOfCoffee + taxRate);

            System.out.println(padString(Integer.toString(date + i), COL_WIDTH)
                    + padString("$" + Double.toString(taxRate), COL_WIDTH + 1)
                    + padString("$" + Double.toString(totalCost), COL_WIDTH + 1));

            // A method that prints a separation bar of "="
            separationBar();

        }
    }

    public static void separationBar() {
        // Separation bar "="
        for (int k = 0; k < 3; k++) {
            for (int j = 0; j < COL_WIDTH; j++) {
                System.out.print("=");
            }
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void separationBarOfStarts() {
        // Separation bar of stars "*"
        for (int j = 0; j < COL_WIDTH * 3 + 2; j++) {
            System.out.print("*");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // Scanner Object to scanner user input
        Scanner console = new Scanner(System.in);

        // print welcome message
        printLogo();

        // Ask user for date input
        System.out.print("Enter the date: ");
        int date = console.nextInt();

        // Ask the user for pounds of coffee input
        System.out.print("Enter the pounds of coffee: ");
        double poundsOfCoffe = console.nextDouble();

        // method calls
        printInvoice(date, poundsOfCoffe);
    }
}
