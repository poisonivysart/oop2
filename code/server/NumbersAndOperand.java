import java.io.Serializable;
import java.util.Arrays;

// Should be serializable because we add it ass argument to skeleoton
public class NumbersAndOperand implements Serializable {
  /**
   *
   */
  private static final long serialVersionUID = 1L;
  private int number1;
  private int number2;
  private int operand;

  public NumbersAndOperand(int number1, int number2, int operand) {
    this.number1 = number1;
    this.number2 = number2;
    this.operand = operand;
  }

  public int getNum1() {
    return this.number1;
  }

  public int getNum2() {
    return this.number2;
  }

  public int getOperand() {
    return this.operand;
  }

}
