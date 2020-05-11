package lession9_Exception;

public class Methods {
	
	public Methods() {
		super();
	}
	
	void chooseException (double a, double b) throws MyException, IllegalAccessException {
		try {
		if (a < 0 && b < 0)
			{throw new IllegalArgumentException("a="+a+" b="+b+ " умова a < 0 && b < 0" );}
		if ((a == 0 && b!=0) || (a!=0 && b==0))
			{throw new ArithmeticException("a="+a+" b="+b+ " умова (a == 0 && b!=0) || (a!=0 && b==0)");}
		if (a==0 && b == 0)
			{throw new IllegalAccessException ("a="+a+" b="+b+ " умова a==0 && b == 0");}
		if (a > 0 && b > 0) 
			{throw new MyException("a="+a+" b="+b+ " умова a > 0 && b > 0");}
	}
		catch (IllegalArgumentException exception) {
			exception.printStackTrace();
		} catch (ArithmeticException exception) {
			exception.printStackTrace();
		} catch (IllegalAccessException exception) {
			exception.printStackTrace();
		}
		catch (MyException exception) {
			exception.printStackTrace();
		}
	}
	
	double plus (double a, double b) throws IllegalAccessException, MyException {
		chooseException (a,b);
		return a+b;
	}
	double minus(double a, double b) throws IllegalAccessException, MyException {
		chooseException (a,b);
		return a-b;
	}
	double mnoj (double a, double b) throws IllegalAccessException, MyException {
		chooseException (a,b);
		return a * b;
	}
	double dil (double a, double b) throws IllegalAccessException, MyException {
		chooseException (a,b);
		return a / b;
	}
	
}
