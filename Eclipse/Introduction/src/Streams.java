import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//count the number of names starting with Alphabet A in list
		
		ArrayList<String> names = new ArrayList<String>();

		names.add("Prashanna");
		names.add("Apsara");
		names.add("Absar");
		names.add("Rocky");
		names.add("Apes");
		

		int count=0;
		for(String a : names)
		{
			if(a.startsWith("A"))
			{
				System.out.println(a);
				count++;
			}
		}
		System.out.println(count);
		System.out.println(names);
		
		//Streams
		
		/*Stream<String> b = names.stream();
		Stream<String> c = b.filter(s->s.startsWith("A"));
		long d = c.count();*/
		
		//there is no life for intermediate op if there is no terminal op
		//terminal operation will get execute if inter op returns true in this case
		//we can create stream 
		
		long d = names.stream().filter(s->s.startsWith("A")).count();
		System.out.println(d);
		names.stream().filter(s->s.startsWith("A")).forEach(s->System.out.println(s));
		
		
		long e = Stream.of("ABCDD","CDE","EFG","GHKDDD").filter(s->s.length()>4).count();
		System.out.println(e);
		Stream.of("ABCDD","CDE","EFG","GHKDDD").filter(s->s.length()>4).forEach(s->System.out.println(s));
		
		System.out.println(Stream.of("ABCDD","CDE","EFG","GHKDDD").filter(s->s.length()>4).limit(1).count());
		Stream.of("ABCDD","CDE","EFG","GHKDDD").filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
		
		//map
		
		//print names which have last letter as "a" with upper case
		names.stream().filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		//print names which have first letter as "A" with upper case and sort
		names.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		//merging two list
		System.out.println("***************");
		Stream<String> newStream = Stream.concat(names.stream(),Stream.of("ABCDD","CDE","EFG","GHKDDD"));
		//newStream.forEach(s->System.out.println(s));
		
		//check whether Apes is present or not in the final string after merging two strings.
		boolean f = newStream.anyMatch(s->s.equalsIgnoreCase("Apes"));
		System.out.println(f);
		
	
		
		//Collect method.
		//convert the final stream again into list
	List<String> names22 =	names.stream().filter(s->s.endsWith("a")).map(s->s.toUpperCase()).collect(Collectors.toList());
	System.out.println(names22.get(0));
		
		
		/*************************/
	
	//int z[] = {3,2,2,7,5,1,9,7};
	//print unique number from this list
	//sort the array
	
	//List<Integer> h = Arrays.stream(z).boxed().collect(Collectors.toList());
	
	/*String g[] = {"Prashanna","Letchu","Dhiv","Dhiv","Prashanna"};
	List<String> nb = Arrays.asList(g);
	nb.stream().distinct().forEach(s->System.out.println(s));*/

	//List<int[]> values = Arrays.asList(z);
	//List<Integer> values = Arrays.asList(3,2,2,7,5,1,9,7);
	//values.stream().distinct().forEach(s->System.out.println(s));
	
	/*List<int[]> values11 = values.stream().distinct().collect(Collectors.toList());
	for(int[] h : values11)
	{
		System.out.println(h);
	}

	*/
	
	/*Integer ss[]= {1,2,3,4,5};
	List<Integer> ssss = Arrays.asList(ss);
	
	String ee[]= {"Prashan","Letchu","Dhiv"};
	List<String> ggg = Arrays.asList(ee);*/
	
	
	int z[] = {12, 10, 9, 45, 2, 10, 10, 45};	
	int dup=0;
	for(int i=0;i<z.length;i++)
	{
		for(int j=i+1;j<z.length;j++)
		{
			if(z[i]==z[j])
			{
				dup=1;
				break;
			}
		}
		
		if(dup==0)
		{
			
			System.out.println(z[i]);
		}
		
		dup=0;
	}
		
	
	}
}

