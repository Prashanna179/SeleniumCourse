import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Vector;

public class DurgaSoftCollections {

	public static void main(String[] args) {
		
		//--------Collection(I)--------------
		System.out.println("Collection");
		Collection c = new ArrayList();
		c.add("Prashanna");
		c.add("Dhivyan");
		
		c.iterator();
		
		Collection d  = new ArrayList();
		d.add("Letchu");
		d.add("Prakash");
		d.addAll(c);
		
		
		Collection e = new ArrayList();
		e.add("Prashanna");
		e.add("Prakash");
		
		System.out.println(c);
		System.out.println(d);
		
		//d.removeAll(e);
		
		//d.retainAll(e);
		
		System.out.println(d);
		
		System.out.println("** ** ** ** **");
		
		//-----List(I)-----------
		
		System.out.println("List");
		List l = new ArrayList();
		l.addAll(d);
		System.out.println(l);
		
		
		//ListIterator
		
		ListIterator it = l.listIterator();
		while (it.hasNext()) 
		{
			System.out.println(it.next());  
			
		}
			
		System.out.println("** ** ** ** **");
		//----------ArrayList--------
		
		System.out.println("ArrayList");
		ArrayList al = new ArrayList();
		ArrayList al1 = new ArrayList(d);
		ArrayList al2 = new ArrayList(10);
		System.out.println(al1);
		
		//Iterator*******************
		Iterator itr = al1.iterator();
		while(itr.hasNext())
		{
			if(itr.next()=="Prakash")
			{
			//	itr.remove();
			}
		}
		
		System.out.println(itr.getClass().getName());
		
		System.out.println(al1);
		
		//ListIterator*******************
		ListIterator itr1 = al1.listIterator();
		while(itr1.hasNext())
		{
			if(itr1.next()=="Prakash")
			{
				//itr1.set("ReplacedPrakash");
				  itr1.add("AddedPrakash");
			}
		}
		
		System.out.println(itr1.getClass().getName());
		
		System.out.println(al1);
		
		//itr1.hasPrevious();
		//itr1.previous();
		//itr1.previousIndex();
		
		
		
		System.out.println("** ** ** ** **");
		//----------LinkedList--------
		
		System.out.println("LinkedList");
		LinkedList ll = new LinkedList();
		ll.add("x");
		ll.add("y");
		ll.add("z");
		System.out.println(ll);
		ll.addFirst("w");
		
		System.out.println(ll);
		
		System.out.println("** ** ** ** **");
		//----------Vector--------
		
		System.out.println("Vector");
		Vector v = new Vector();
		Vector v1 = new Vector(15);
		Vector v2 = new Vector(10,5);
		
		
		//Enumeration***************************
		Enumeration en =  v.elements();
		while(en.hasMoreElements())
		{
			en.nextElement();
		}
		
		System.out.println(en.getClass().getName());
		System.out.println("** ** ** ** **");
		//----------Stack--------
		
		System.out.println("Stack");
		Stack s = new Stack();
		s.push("x");
		s.push("y");
		s.push("z");
		
		System.out.println(s);
		
		System.out.println(s.pop());
		
		System.out.println(s);
		
		System.out.println(s.peek());
		
		System.out.println(s.search("y"));
		System.out.println(s.search("a"));
		
		
		System.out.println("** ** ** ** **");
		//----------HashSet--------
		
		System.out.println("HashSet");
		HashSet h = new HashSet();
		HashSet h1 = new HashSet(d);
		
		System.out.println(h1);
	
		
		System.out.println("** ** ** ** **");
		//----------LinkedHashSet--------
		
		System.out.println("LinkedHashSet");
		LinkedHashSet lh1 = new LinkedHashSet();
		LinkedHashSet lh = new LinkedHashSet(d);
		
		
		System.out.println(lh);
		
		
		System.out.println("** ** ** ** **");
		//----------SortedSet--------
		
		System.out.println("SortedSet");
		
		SortedSet ss = new TreeSet();
	
		ss.add("100");
		ss.add("107");
		ss.add("102");
		ss.add("101");
		ss.add("103");
		ss.add("104");
		ss.add("105");
		ss.add("106");
		//ss.add(150);

		
		System.out.println(ss);
		
		System.out.println(ss.headSet("104"));
		
		
		System.out.println("** ** ** ** **");
		//----------TreeSet--------
		
		System.out.println("TreeSet");
		
		TreeSet t = new TreeSet();
		/*t.add("x");
		t.add("a");
		t.add("y");
		t.add("b");*/
		
		System.out.println(t);
		
		//t.add(null);
		
		
	

		
		
		
		
		
		
		
		

		

	
	}
	
}

