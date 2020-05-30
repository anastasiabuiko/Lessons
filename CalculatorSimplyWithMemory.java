package calculator;

import java.util.Scanner;

public class CalculatorSimplyWithMemory extends CalculatorSimple{

    private   Double memory=null;

    public    void  getMs(Double result) {
        memory=result;
    }

    public   Double  getMr() {
        return memory;
    }

    public  void getMc() {
        memory=null;
    }

    public  void getMPlus(Double result) {
       if(memory==null){
           getMs(result);
           return;
       }
        memory=memory+result;
    }

    public  void getMMinus(Double result) {
        if(memory==null){
            getMs(result);
            return;
        }
        memory=memory-result;
    }

    public void selectOptionMemory(String operation) {

        if (operation.equals(Messages.MS)) {
            getMs(result);
        }else if (operation.equals(Messages.MC)) {
            getMc();
        } else if (operation.equals(Messages.M_PLUS)) {
            getMPlus(result);
        } else if (operation.equals(Messages.M_MINUS)) {
            getMMinus(result);
        }else {
            System.out.print(Messages.ERROR_INPUT_OPERATION);
            Scanner input = new Scanner(System.in);
            operation = input.next();
            selectOptionMemory(operation);
        }
    }

    public  Double runner(){
        print();
        result= super.selectOptionSimple(operation);
        System.out.println(Messages.RESULT +result);

        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.print(Messages.MEMORY_INPUT);
            String operation = input.nextLine();
            this.selectOptionMemory(operation);
            System.out.printf(Messages.RESULT+"%f:\n", getMr());
            System.out.print(Messages.EXIT_Y_N);
            String exOrNo=input.nextLine().toLowerCase();
            if(exOrNo.equals(Messages.YES)){
                return result;
            }
        }
    }

    public static void  start(){
        CalculatorSimplyWithMemory csm  =new CalculatorSimplyWithMemory();
        csm.runner();
    }
}
