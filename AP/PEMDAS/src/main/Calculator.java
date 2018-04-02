package main;

import java.util.Stack;

/**
 * A class that uses two stacks, an operator and operand stack, to evaluate mathematical
 * expressions. The expected input is a string with each operator and operand separated by white
 * space. This class can deal with addition, subtraction, multiplication, division, modulus,
 * exponents, and parenthesis.
 * 
 * This could have been purely static and achieved the same results
 * 
 * @author Joshua Sizer
 *
 */
public class Calculator {

  private Stack<Operator> operatorStack;
  private Stack<Double> operandStack;

  /**
   * Creates a calculator!
   */
  public Calculator() {
    operatorStack = new Stack();
    operandStack = new Stack();
  }

  /**
   * Evaluates the string expression
   * 
   * @param expression A string with each operator and operand separated by white space
   * @return An integer
   */
  public double evaluate(String expression) {
    return evaluate(tokenizeExpression(expression));
  }

  /**
   * Evaluates an expression comprised of an array of operators and operands
   * 
   * @param expression The string array of operators and operands
   * @return The value of the evaluates expression
   */
  public double evaluate(String[] expression) {
    Object[] parsedExpress = parseExpression(expression);
    if (!checkParenthesis(parsedExpress)) {
      throw new ExpressionFormatException(
          "There are an unequal amount of open and closed parenthesis!");
    }
    
    for (Object obj : parsedExpress) {
      if (obj instanceof Operator) {
        Operator op = (Operator) obj;
        if (operatorStack.isEmpty()) {
          operatorStack.push(op);
          continue;
        } 
        
        Operator lastOperator = operatorStack.peek();
        System.out.println(lastOperator);
        if (op.compare(lastOperator) < 0) {
          calculateAndPush();
        } else {
          operatorStack.push(op);
        }
      } else {
        operandStack.push((Double) obj);
      }
    }
    
    while (!operatorStack.isEmpty()) {
      calculateAndPush();
    }
    return operandStack.peek();
  }

  /**
   * Splits an expression up into its tokens, ie operators and operands
   * 
   * @param expression The expression to parse
   * @return A string array of tokens
   */
  public String[] tokenizeExpression(String expression) {
    return expression.split(" ");
  }

  /**
   * This parses the tokens into an object array containing both doubles and Operators
   * 
   * @param expression The string[] of tokens to parse
   * @return An object array containing every operator and operand, in order
   */
  public Object[] parseExpression(String[] expression) {
    Object[] ret = new Object[expression.length];
    Object toAdd = null;
    Operator possibleOperator;
    double possibleOperand;
    int i = 0;

    for (String oper : expression) {
      possibleOperator = Operator.getOperatorFromString(oper);
      possibleOperand = 0.0;

      if (possibleOperator != null) {
        toAdd = possibleOperator;
      } else {
        possibleOperand = Double.parseDouble(oper);
        toAdd = possibleOperand;
      }
      //System.out.println(toAdd);
      ret[i++] = toAdd;
    }
    return ret;
  }

  /**
   * Checks to see there are an equal number of open and closed parenthesis, otherwise there is an
   * error!
   * 
   * @param arr The object array with the operands to check
   * @return True if there are an equal number of open and closed parenthesis. False otherwise.
   */
  public boolean checkParenthesis(Object[] arr) {
    int openCount = 0;
    int closedCount = 0;
    for (Object cur : arr) {
      if (cur instanceof Operator) {
        Operator op = (Operator) cur;
        if (op.equals(Operator.OPEN_PARENTHESIS)) {
          openCount++;
        } else if (op.equals(Operator.CLOSED_PARENTHESIS)) {
          closedCount++;
        }
      }
    }
    return openCount == closedCount;
  }
  
  /**
   * Calculates the value based upon the arguments and the operator
   * This will perform arg1 operator arg2
   * 
   * @param arg1
   * @param arg2
   * @param operator
   * @return
   */
  public double calculate(double arg1, double arg2, Operator operator) {
    switch (operator) {
      case ADDITION:
        return arg1 + arg2;
      case SUBTRACTION:
        return arg1 - arg2;
      case MULTIPLICATION:
        return arg1 * arg2;
      case DIVISION:
        return arg1 / arg2;
      case MODULUS:
        return arg1 % arg2;
      case EXPONENT:
        return Math.pow(arg1, arg2);
      default: 
        return 0.0;
    }
  }
  
  public void calculateAndPush(){
    double arg1 = operandStack.pop();
    double arg2 = operandStack.pop();
    Operator op1 = operatorStack.pop();
    operandStack.push(calculate(arg2, arg1, op1));
    System.out.println(operandStack.peek());
  }
}
