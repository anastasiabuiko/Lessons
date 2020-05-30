package calculator.impl;

public interface IMath {

    /** Returns a+b */
    default Double  add(Double a, Double b){
        return a+b;
    }
    /** Returns a-b */
    default Double  subtract(Double a, Double b){
        return a-b;
    }

    /** Returns a*b */
    default Double  multiply(Double a, Double b){
        return a*b;
    }

    /** Returns a/b */
    default Double  division(Double a, Double b){
        return a/b;
    }

    /** Returns cos */
    default Double cos(Double input){
        return Math.cos(input);
    }

    /** Returns exp */
    default  Double exp(Double input){
        return Math.exp(input);
    }

    /** Returns sqrt */
    default  Double sqrt(Double input){
        return Math.sqrt(input);
    }

}
