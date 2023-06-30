import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionDemo {

	public static void main(String[] args) {
		
	//List
		
	//ArrayList
		
	int a[]= {1,2,3,4,5,6};
	String b = a.toString();
	List<Integer> l = Arrays.stream(a).boxed().collect(Collectors.toList());
	l.add(2, 10);
	System.out.println(l);
	
	
	ArrayList<String> Al = new ArrayList<String>();
	
	Al.add("Prashanna");
	Al.add("Dhivyan");
	Al.add("Letchu");
	
	System.out.println(Al);
	
	//Iterate through elements.
	Iterator<String> it = Al.iterator();
	while(it.hasNext())
	{
		System.out.println(it.next());
	}
	System.out.println("*********");
	//Iterate through elements using for loop
	for(String s : Al)
	{
		System.out.println(s);
	}
	
	//Ascending Order 
	Al.sort((aa,bb)->aa.compareTo(bb));
	System.out.println(Al);
	
	//Descending Order
	Al.sort((aa,bb)->bb.compareTo(aa));
	System.out.println(Al);
	
	
	Collections.sort(Al);
	System.out.println(Al);

	
	//Al.stream().filter(s->s.toString().length()>6).forEach(s->System.out.println(s));
	System.out.println("************");
	
	//Unique numbers in a array
	
	//int z[]= {4,5,5,5,4,6,6,9,4};
	
	int z[]= {1,2,2,3};
	

	List<Integer> li =	Arrays.stream(z).boxed().collect(Collectors.toList());

	int zz[]=new int[20];
	int index=0;
	
	
	for(int i =0;i<z.length;i++)
	{	
		int flag=0;
		for(int j =0;j<i;j++)
		{
			if(z[i]==z[j])
			{
				
				break;
			}
			
			if(i==j)
			{
				System.out.print(z[i] + "");
			}	
		}
		
		
		
	}
	
	//List<Integer> fl = Arrays.stream(zz).boxed().collect(Collectors.toList());
	//fl.stream().filter(s->s!=0).forEach(s->System.out.print(s));
	
	/*Arrays.sort(zz);
	for(int i=0;i<zz.length;i++)
	{
		System.out.print(zz[i]);
	}*/
	
	
}
}
