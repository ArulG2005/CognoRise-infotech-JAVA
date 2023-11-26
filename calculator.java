import java.util.Scanner;

public class calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("-------------------------Calculator-------------------------");
            System.out.println("");
            try {
                System.out.println("Enter the first number");
                int num1 = sc.nextInt();

                System.out.println("Enter the Second Number");
                int num2 = sc.nextInt();

                System.out.println("Select the Operator: '+' , '-' , '*' , '/' , '%' ");
                char op = sc.next().charAt(0);

                switch (op) {
                    case '+':
                        System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
                        System.out.println("");
                        break;
                    case '-':
                        System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
                        System.out.println("");
                        break;
                    case '*':
                        System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
                        System.out.println("");
                        break;
                    case '/':
                        if (num2 != 0) {
                            System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
                            System.out.println("");
                        } else {
                            System.out.println("Cannot divide by zero. Please enter a non-zero second number.");
                            System.out.println("");
                        }
                        break;
                    case '%':
                        System.out.println(num1 + " % " + num2 + " = " + (num1 % num2));
                        System.out.println("");
                        break;
                    default:
                        System.out.println("Enter a valid operator");
                        System.out.println("");
                        break;
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                sc.next(); 
            }
        }
    }
}
