

import java.util.Calendar;
import java.util.Date;

public class CoreJavaPart2 {

	public static void main(String[] args) {

		//Date class
		
		Date d = new Date();
		System.out.println(d.toString());
	
		//Calendar Class
		
		Calendar c = Calendar.getInstance();
		System.out.println(c.DAY_OF_MONTH);
		System.out.println(c.DAY_OF_YEAR);
		System.out.println(c.get(Calendar.YEAR));
		System.out.println(c.get(Calendar.DAY_OF_MONTH));
		
	}

}
