public class IsNegativeException extends Exception{
  String error;
  IsNegativeException(){
    this.error = "Result is a negative number";
  }

  public void errorMessage(){
    System.out.println(this.error);
  }
}
