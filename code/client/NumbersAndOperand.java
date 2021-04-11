import java.util.Arrays;  
// Should be serializable because we add it ass argument to skeleoton
public class NumbersAndOperand extends Serialize {
  private int number1;
  private int number2;
  private int operand;

  public NumbersAndOperand(int number1, int number2, int operand){
    this.number1 = number1;
    this.number2 = number2;
    this.operand = operand;
  }

  public NumbersAndOperand getNumbersAndOperand(){
    NumbersAndOperand NaO = NumbersAndOperand(this.number1, this.number2, this.operand);
    return NaO;
  }
}
