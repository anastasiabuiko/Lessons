package calculator;

import java.util.Scanner;

public class CalculatorSimplyEngineering extends  CalculatorSimple{


    public Double selectOptionEngineering(String operation) {

        if(numOne==null){
            return null;
        }

        if (operation.equals(Messages.COS)) {
            result=cos(numOne);
        } else if (operation.equals(Messages.EXP)) {
            result=exp(numOne);
        } else if (operation.equals(Messages.SQRT)) {
            result=sqrt(numOne);
        }else {
            System.out.print(Messages.ERROR_INPUT_OPERATION);
            Scanner input = new Scanner(System.in);
            operation = input.next();
            selectOptionEngineering(operation);
        }

        return result;
    }

    @Override
    public void print(){
        try {
            Scanner input = new Scanner(System.in);
            System.out.print(Messages.NUMBER_INPUT);
            numOne = input.nextDouble();

            System.out.print(Messages.OPERATION_INPUT);
            operation = input.next();
        }catch (Exception e){
            System.out.println(Messages.ERROR_INPUT_NUMBER);
            print();
        }
    }

    @Override
    public Double runner(){

        while (true) {

            Scanner input = new Scanner(System.in);
            System.out.print(Messages.SELECT_OPERATION_SIMPLE_ENGINEERING_MEMORY);
            String out=input.nextLine().toLowerCase();

            if (out.equals("s")) {
                super.print();
                result = super.selectOptionSimple(operation);
            } else if(out.equals("e")) {
                this.print();
                result = selectOptionEngineering(operation);
            }else if(out.equals(Messages.YES)){
                break;
            }
           System.out.println(Messages.RESULT +result);
        }

        return result;
    }

    public static void  start(){
        CalculatorSimplyEngineering cse  =new CalculatorSimplyEngineering();
        cse.runner();
    }

}
