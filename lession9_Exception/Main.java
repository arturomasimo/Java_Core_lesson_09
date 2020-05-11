package lession9_Exception;
/**
 * The Main class processing methods with exceptions
 * @author ARTUR
 * @since JDK 13.0.2
 */
public class Main {
	public static void main(String[] args) throws IllegalAccessException, MyException {
		
		double [] x = {10, -12, 0, 15};
		double [] y = {2, 4, -10, 0};
		double r=0;
		Methods m = new Methods ();
		for (int i =0; i <2; i++)
			for (int j = 0; j <2; j++)
			{
				r=m.plus(x[i], y[j]);
				System.out.println("Додавання : "+x[i]+ "+" + y[j]+ "="+ r);
	            r=m.minus(x[i], y[j]);
				System.out.println("Віднімання: "+x[i]+ "-" + y[j]+ "="+ r);
				r=m.mnoj(x[i], y[j]);
				System.out.println("Множення  : "+x[i]+ "*" + y[j]+ "="+ r);
				r=m.dil(x[i], y[j]);
				System.out.println("Ділення   : "+x[i]+ "/" + y[j]+ "="+ r);
				System.out.println("--------------------------------------------------------------");
			}
	}
}
