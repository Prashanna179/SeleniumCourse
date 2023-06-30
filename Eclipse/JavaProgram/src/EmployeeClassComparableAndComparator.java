
public class EmployeeClassComparableAndComparator implements Comparable 
{

		int id;
		String name;
		
		public  EmployeeClassComparableAndComparator(int id , String name)
		{
			this.id = id;
			this.name = name;
		}
		
		//@Override
/*		public String toString()
		{
			

		return name+"--"+id;
		
		}*/
		

		@Override
		public int compareTo(Object o) 
			{
	
				int id1 = this.id;
				EmployeeClassComparableAndComparator em =(EmployeeClassComparableAndComparator)o;
				int id2	= em.id;
				
				if(id1<id2)
				{
					return -1;
				}
				else if(id1>id2)
				{
					return +1;
				}
				else
				{
					return 0;
				}
	
			}
		public static void main(String[] args) {
			
			String a = new String();
			EmployeeClassComparableAndComparator et = new EmployeeClassComparableAndComparator(100,"GH");
			System.out.println(et.id);
			System.out.println(et.name);
			System.out.println(et);
			
			System.out.println("Prashanna");
			
		}

}