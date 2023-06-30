import java.util.Comparator;
import java.util.TreeSet;

public class EmployeeClassCompCompoDemo {

	public static void main(String[] args) {
		
		EmployeeClassComparableAndComparator e = new EmployeeClassComparableAndComparator(2,"Prashanna");
		EmployeeClassComparableAndComparator e1 = new EmployeeClassComparableAndComparator(1,"Dhivyan");
		EmployeeClassComparableAndComparator e2 = new EmployeeClassComparableAndComparator(4,"Letchu");
		EmployeeClassComparableAndComparator e3 = new EmployeeClassComparableAndComparator(3,"Prakash");
		
		TreeSet t = new TreeSet();
		t.add(e);
		t.add(e1);
		t.add(e2);
		t.add(e3);
		
		System.out.println(t);
		
		TreeSet t1 = new TreeSet(new MyNameComparator());
		t1.add(e);
		t1.add(e1);
		t1.add(e2);
		t1.add(e3);
		
		System.out.println(t1);
		
	}

}

class MyNameComparator implements Comparator
{

	@Override
	public int compare(Object o1, Object o2) {
		
		EmployeeClassComparableAndComparator e1=(EmployeeClassComparableAndComparator)o1;
		EmployeeClassComparableAndComparator e2=(EmployeeClassComparableAndComparator)o2;
		String name1 = e1.name;
		String name2 = e2.name;
		return name1.compareTo(name2);
		
		
	}
	
}
