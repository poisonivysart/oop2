public class Calculate implements CalculateService{

  private double result;

  public Calculate(){
    super();
  }

  public void add(int number1, int number2){
    this.result = number1+number2;
  }
  public void subtract(int number1, int number2){
    this.result = number1-number2;
  }
  public void divide(int number1, int number2){
    this.result = number1/number2;
  }
  public void multiply(int number1, int number2){
    this.result = number1*number2;
  }
}
