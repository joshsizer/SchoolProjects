package main;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Created by joshs on 1/6/2017.
 *
 * Using an auxillary array to store the previously calculated values is far more efficient than
 * straight recursion. It reduced the number of function calls to exactly n times, as apposed to
 * some exponential growth of n.
 *
 * The end result of using an auxillary array essentially defeats the purpose of using recursion.
 * The function calls loop through n until n is 1, and then travels back up the
 * stack, adding the two previous numbers. The array is acting as the n1 and n2 in the iterative
 * version of calculating a Fibonacci term
 */
public class Main {
  public static void main(String[] args) {
    int index = 21;
    Fibonacci fib = new Fibonacci();
    long calculated = fib.calc(index);
    fib.calcEfficient(index);

    System.out.println("To calculate the " + index + " term of the Fibonacci sequence, " +
        calculated + ", it took:");

    int slowTime = fib.getSlowCount();
    int fastTime = fib.getFastCount();

    System.out.println(slowTime + " iterations without an auxillary array and");
    System.out.println(fastTime + " iterations with an auxillary array.");
  }

  @Test
  public void Test() {
    Fibonacci fib = new Fibonacci();
    assertEquals(fib.calcEfficient(21), 10946, 0.0);
  }
}
