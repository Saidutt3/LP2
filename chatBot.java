
import java.util.Scanner;

class chatBot {
    public static void greet(String botName, int birthYear) {
        System.out.println("Hello! My name is " + botName + ".");
        System.out.println("I was created in " + birthYear + ".");
    }

    public static void remindName() {
        System.out.println("Please, remind me your name.");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("What a great name you have, " + name + "!");
    }

    public static void guessAge() {
        System.out.println("Let me guess your age.");
        System.out.println("Enter remainders of dividing your age by 3, 5 and 7.");

        Scanner scanner = new Scanner(System.in);
        int rem3 = scanner.nextInt();
        int rem5 = scanner.nextInt();
        int rem7 = scanner.nextInt();
        int age = (rem3 * 70 + rem5 * 21 + rem7 * 15) % 105;

        System.out.println("Your age is " + age + "; that's a good time to start programming!");
    }

    public static void count() {
        System.out.println("Now I will prove to you that I can count to any number you want.");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        int counter = 0;
        while (counter <= num) {
            System.out.println(counter + " !");
            counter += 1;
        }
    }

    public static void test() {
        System.out.println("Let's test your programming knowledge.");
        System.out.println("Why do we use methods?");
        System.out.println("1. To repeat a statement multiple times.");
        System.out.println("2. To decompose a program into several small subroutines.");
        System.out.println("3. To determine the execution time of a program.");
        System.out.println("4. To interrupt the execution of a program.");

        int answer = 2;
        Scanner scanner = new Scanner(System.in);
        int guess = scanner.nextInt();
        while (guess != answer) {
            System.out.println("Please, try again.");
            guess = scanner.nextInt();
        }

        System.out.println("Completed, have a nice day!");
        System.out.println(".................................");
        System.out.println(".................................");
        System.out.println(".................................");
    }

    public static void end() {
        System.out.println("Congratulations, have a nice day!");
        System.out.println(".................................");
        System.out.println(".................................");
        System.out.println(".................................");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    public static void main(String[] args) {
        greet("Sbot", 2024);
        remindName();
        guessAge();
        count();
        test();
        end();
    }
}
