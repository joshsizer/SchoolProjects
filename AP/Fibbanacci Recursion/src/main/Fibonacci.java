package main;

import java.util.Arrays;

/**
 * Created by joshs on 1/6/2017.
 */
public class Fibonacci {
  private static final long defaultValue = -999;
  private long[] elements;

  private int slowCount;
  private int fastCount;

  /**
   * Provides access to the number of function calls for the last calc() function
   * @return number of function calls
   */
  public int getSlowCount() {
    return slowCount;
  }

  /**
   * Provides access to the number of funtion calls for the last calcEfficient() function
   * @return number of function calls
   */
  public int getFastCount() {
    return fastCount;
  }

  /**
   * Default constructor for Fibonacci object
   */
  public Fibonacci() {
    reset();
  }

  /**
   * Must be called before each call of calcEfficient. This allows the method calcEffecient
   * to allocate a new array of size n to store the known values of each "tree branch". If we do
   * not call this, and you are requesting a new term that is a larger index than the last
   * term we wanted, there will most surely be an array out of bounds exception. To avoid this
   * need for a reset function, we could have a helper method that set's the array to null after
   * the calculate method returns from within the helper method.
   */
  public void reset() {
    elements = null;
    slowCount = 0;
    fastCount = 0;
  }

  /**
   * Calculates the nth term of the Fibonacci sequene
   * @implNote Uses an array to store each term as it is calculated recursively, increasing
   * efficiency greatly.
   *
   * @param n The term to calculate
   * @return The nth term
   */
  public long calcEfficient(long n) {
    fastCount++;
    // If the array is null, we know this is the first iteration of the recursive call, so we
    // must allocate a new array of size n.
    if (elements == null ) {
      elements = new long[(int)n];
      Arrays.fill(elements, defaultValue);
    }
    // this is the base case
    if (n <= 2) {
      elements[(int)(n-1)] = 1;
      return 1;
    } else {
      // each value is either calculated for the first time, or taken from the array of known
      // values
      long arg1 = (elements[(int)(n - 2)] != defaultValue ? elements[(int)(n - 2)] :
          calcEfficient(n-1));
      long arg2 = (elements[(int)(n - 3)] != defaultValue ? elements[(int)(n - 3)] :
          calcEfficient(n-2));
      // the resulting value is the next number in the Fibonacci sequence
      long result = arg1 + arg2;
      elements[(int)(n - 1)] = result;

      return result;
    }
  }

  /**
   * Calculates the nth term of the Fibonacci sequence
   *
   * @implNote Uses straight recursion, very innefficient
   * @param n the term to calculate
   * @return the nth term
   */
  public long calc(int n) {
    slowCount++;
    if (n <= 2) {
      return 1;
    } else {
      return calc(n - 1) + calc(n - 2);
    }
  }
}