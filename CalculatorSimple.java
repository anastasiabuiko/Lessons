package calculator;

import calculator.impl.IMath;

import java.util.Scanner;


public class CalculatorSimple implements IMath {


    protected  Double numOne;

    protected  Double numTwo;

    protected  String operation;

    public   Double  result;


    public  void print(){

            try {
                Scanner input = new Scanner(System.in);
                System.out.print(Messages.FIRST_NUMBER_INPUT);

                numOne = input.nextDouble();

                System.out.print(Messages.SECOND_NUMBER_INPUT);
                numToo = input.nextDouble();

                System.out.print(Messages.OPERATION_INPUT);
                operation = input.next();

            } catch (Exception e) {
                System.out.println(Messages.ERROR_INPUT_NUMBER);
                print();
            }

    }

    public Double selectOptionSimple(String operation) {

        if (operation.equals(Messages.ADD)) {
            result = add(numOne, numTwo);
        } else if (operation.equals(Messages.SUBTRACT)) {
            result = subtract(numOne, numTwo);
        } else if (operation.equals(Messages.MULTIPLY)) {
            result = multiply(numOne, numTwo);
        } else if (operation.equals(Messages.DIVISION)) {
            result = division(numOne, numTwo);
        }else {
            System.out.print(Messages.ERROR_INPUT_OPERATION);
            Scanner input = new Scanner(System.in);
            operation = input.next();
            selectOptionSimple(operation);
        }

        return result;
    }

    public Double  runner(){

        while(true) {

            print();
            result=selectOptionSimple(operation);
            System.out.println(Messages.RESULT +result);
            System.out.print(Messages.EXIT_Y_N);
            Scanner input = new Scanner(System.in);
            String exOrNo=input.nextLine().toLowerCase();
            if(exOrNo.equals(Messages.YES)){
                return result;
            }
        }
    }

    public static void  start(){
        CalculatorSimple cs = new CalculatorSimple();
        cs.runner();
    }
}

