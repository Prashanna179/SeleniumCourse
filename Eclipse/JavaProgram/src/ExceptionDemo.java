import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExceptionDemo {

	
	public void dispException()
	{
		System.out.println("Exception displayed");
	}
	public static void main(String[] args) {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try
		{
			//NumberFormat Exception
			//int j = Integer.parseInt(br.readLine());
			//Arithmetic Exception
			//int f=7/j;
			//System.out.println(f);
			
			//IndexoutofBoundsException
			int c[]= {1,2};
			System.out.println(c[2]);
		}
			
		catch(ArrayIndexOutOfBoundsException Oe)
		{
			System.out.println(Oe);
			System.out.println("Array index out of bound / exception catched");
			throw new RuntimeException("Hello Runtime Error");
	
		}
		
		catch(ArithmeticException Ae)
		{
			System.out.println(Ae);
			System.out.println("Arithmetic / exception catched");
		
		}
		
		catch(NumberFormatException Nf)
		{
			System.out.println(Nf);
			System.out.println("NumberFormat / exception catched");
		
		}
		/*catch(IOException Io)
		{
			System.out.println(Io);
			System.out.println("IO / exception catched");
		
		}*/
		catch(Exception e)
		{
			System.out.println(e);
			System.out.println("general / exception catched");
		
		}
		
		finally {
			System.out.println("FInally block called");
		}
		
		
		
		
		System.out.println("hello exception demo");
		ExceptionDemo ed = new ExceptionDemo();
		ed.dispException();
		
		
		
	}

}
