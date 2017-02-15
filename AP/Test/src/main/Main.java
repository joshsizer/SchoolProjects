package main;

/**
 * Created by Joshua Sizer on 2/8/2017.
 */
public class Main {
  public static void main(String[]  args) {
    int b = 0xaa;
    b <<= 8;
    int a = 0x55;
    b |= a;
    System.out.println(b);
  }
}
