public class Calculate implements CalculateService {

  private double result;

  public Calculate() {
    super();
  }

  public void add(int number1, int number2) {
    this.result = number1 + number2;
    System.out.println("Addition was done");
  }

  public void subtract(int number1, int number2) {
    try {
      if (number1 - number2 < 0)
        throw new IsNegativeException();
      else
        this.result = number1 - number2;
      System.out.println("Subtraction was done");
    } catch (IsNegativeException e) {
      this.result = -2;
      e.errorMessage();
    }
  }

  public void divide(int number1, int number2) {
    try {
      this.result = number1 / number2;
      System.out.println("Division was done");
    } catch (ArithmeticException e) {
      System.out.println("Cannot divide by zero");
      this.result = -1;
    }
  }

  public void multiply(int number1, int number2) {
    this.result = number1 * number2;
    System.out.println("Multiplication was done");
  }

  public double calculate(NumbersAndOperand NaO) {
    switch (NaO.getOperand()) {
    case 1:
      add(NaO.getNum1(), NaO.getNum2());
      break;
    case 2:
      subtract(NaO.getNum1(), NaO.getNum2());
      break;
    case 3:
      divide(NaO.getNum1(), NaO.getNum2());
      break;
    case 4:
      multiply(NaO.getNum1(), NaO.getNum2());
      break;
    default:
      System.out.println("Wrong operand number");
      this.result = -3;
    }
    System.out.println(this.result);
    return this.result;
  }

}
