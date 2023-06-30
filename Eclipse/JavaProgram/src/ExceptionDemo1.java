import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExceptionDemo1 {

	
	
	public static void main(String[] args){
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int i =8;
	
		try
		{
		int j=Integer.parseInt(br.readLine());
		int k=i+j;
		if(k<10)
		{
			throw new Exception("Error Prashanna");
		}
		System.out.println(k);
		}
		
		catch(Exception e )
		{
			System.out.println(e);
			System.out.println("Minimum number of output is less than 10");
		} 
		
		/*int k = 0;
		if(k<10)
		{
			throw new ArithmeticException("Error Prashanna");
			throw new Exception("Error Prashanna");
		}*/
		
		
	}
}
