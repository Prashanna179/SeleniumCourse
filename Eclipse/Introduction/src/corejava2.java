import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class corejava2 {

	public static void main(String[] args) {
		//arrayList
		
		ArrayList a = new ArrayList();
		a.add("Prashanna");
		a.add("Dhivyan");
		a.add("Letchu");
	
		
		System.out.println(a);
		//System.out.println(a.get(0));
		
		for(int i=0;i<a.size();i++)
		{
			
			System.out.println(a.get(i));
		}
		
		for(Object s:a)
		{
			System.out.println(s);
		}
		
		System.out.println(a.contains("Dhivyan"));
		
		//conversion of Array into Arraylist

		String name1[]= {"Prashanna","Dhivyan","letchu"};
		List<String>  L = Arrays.asList(name1);
		System.out.println(L.contains("Dhivyan"));
		
		
}	
	

}
