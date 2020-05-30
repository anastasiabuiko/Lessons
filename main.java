import calculator.*;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        start();
    }

    public static void start() {

        loop: while (true) {
            Scanner input = new Scanner(System.in);
            System.out.print("Please select calculator \n"+
                    "Simple-[1],\n" +
                    "SimplyWithMemory-[2],\n" +
                    "SimpleEngineering-[3],\n" +
                    "Simply Engineering With Memory-[4],\n )" +
                    " or exit press any key \n:");

            String str = input.nextLine();

            switch (str) {
                case  Messages.SIMPLE:
                    CalculatorSimple.start();
                    break;
                case Messages.SIMPLE_MEMORY:
                    CalculatorSimplyWithMemory.start();
                    break;
                case Messages.SIMPLE_ENGINEERING:
                    CalculatorSimplyEngineering.start();
                    break;
                case Messages.SIMPLE_ENGINEERING_WITH_MEMORY:
                    CalculatorSimplyEngineeringWithMemory.start();
                    break;
                default:
                    break loop;
            }
        }
    }
}


