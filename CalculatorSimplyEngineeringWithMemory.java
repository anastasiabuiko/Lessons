package calculator;

import calculator.impl.IMath;

import java.util.Scanner;

public class CalculatorSimplyEngineeringWithMemory extends CalculatorSimplyWithMemory implements IMath {

    private CalculatorSimplyEngineering calculatorSimplyEngineering;

    CalculatorSimplyEngineeringWithMemory(){
       calculatorSimplyEngineering= new CalculatorSimplyEngineering();
    }

    @Override
    public  Double runner(){
        result=calculatorSimplyEngineering.runner();
        System.out.println(Messages.RESULT +result);

        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.print(Messages.MEMORY_INPUT);
            String operation = input.nextLine();
            super.selectOptionMemory(operation);
            System.out.printf(Messages.RESULT+"%f:\n", getMr());
            System.out.println();
            System.out.print(Messages.EXIT_Y_N);
            String exOrNo=input.nextLine().toLowerCase();
            if(exOrNo.equals(Messages.YES)){
                return result;
            }
        }
    }

    public static void  start(){
        CalculatorSimplyEngineeringWithMemory  csem =new CalculatorSimplyEngineeringWithMemory();
        csem.runner();
    }

}

