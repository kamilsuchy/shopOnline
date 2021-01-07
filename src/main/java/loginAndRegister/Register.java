package loginAndRegister;


import java.util.Scanner;

public class Register {
    private static void printOptions() {
        System.out.println("1 - logowanie");
        System.out.println("2 - rejestracja");
        System.out.println("3 - zakończ");
    }

    public static void logOrRegister() {

        printOptions();
        Command log = new LogCommand();
        Command register = new RegisterCommand();
        Invoker invoker = new Invoker();

        Scanner scanner = new Scanner(System.in);
        int c;
        while ((c = scanner.nextInt()) != 1 && c != 2 && c != 3) {
            scanner.nextInt();
        }

        if (c == 1) {
            invoker.takeCommand(log);
        } else if (c == 2) {
            invoker.takeCommand(register);
        }
    }
}