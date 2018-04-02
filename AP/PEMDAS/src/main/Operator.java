package main;

public enum Operator {
 
  SUBTRACTION("-", 0),
  ADDITION("+", 0),
  DIVISION("/", 1),
  MULTIPLICATION("*", 1),
  MODULUS("%", 2),
  EXPONENT("^", 3),
  OPEN_PARENTHESIS("(", 4),
  CLOSED_PARENTHESIS(")", 5);
  
  /** The String value associated with this Operator */
  private final String value;
  private final int precedence;
  
  private Operator(String value, int precedence) {
    this.value = value;
    this.precedence = precedence;
  }
  
  public int compare(Operator op) {
    return this.precedence - op.precedence;
  }
  
  /**
   * Get the string value associated with this Operator
   * @return A string, for example "-" or "%"
   */
  public String getStringValue() {
    return value;
  }
  
  /**
   * Returns an Operator based on the string value
   * @param str The string to use, ie "-" or "+"
   * @return The corresponding operator or null if the str is mispelled
   */
  public static Operator getOperatorFromString(String str) {
    Operator[] values = Operator.values();
    for (Operator cur : values) {
      if (str.equals(cur.getStringValue())) {
        return cur;
      }
    }
    return null;
  }
}
