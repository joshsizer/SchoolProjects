package main;

import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    String expression = "5 / 8";
    
    Calculator myCalculator = new Calculator();
    Operator op1 = Operator.ADDITION;
    Operator op2 = Operator.MULTIPLICATION;
   
    System.out.println("Final answer: " + myCalculator.evaluate(expression));
  }
}
