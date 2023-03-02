import java.util.ArrayList;
import java.util.Iterator;

public class Logical_Thinking {

	public static void main(String[] args) 
	{
		/*
		ArrayList<Integer> box = new ArrayList<Integer>();
		box.add(0);
		box.add(24);
		box.add(48);
		box.add(96);
		
		//java 8 - lambda loop 
		box.stream().forEach(no -> System.out.print(no));
		
		//using iterator
		Iterator <Integer> it =  box.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		*/
		/*
		for (int col = 5 ; col > 0 ; col--)
		{
			for(int row = 5 ; row >= col ; row --)
				{
					System.out.print("x ");
				}
			System.out.println("");
		}
		o/p 
			x 
			x x 
			x x x 
			x x x x 
			x x x x x 
		 */
		
		/*
		for (int col = 0 ; col <= 5 ; col++)
		{
			for(int row = 5 ; row >= col ; row --)
				{
					System.out.print("x ");
				}
			System.out.println("");
		}
		x x x x x x 
		x x x x x 
		x x x x 
		x x x 
		x x 
		x 
		*/
		
		for (int col = 0 ; col <= 5 ; col++)
		{
			
			for(int row = 5 ; row >= col ; row --)
				{
					System.out.print("x ");
					for(int sp = 1 ; sp > col ; sp++)
					{
						System.out.println(" ");
					}
				}
			System.out.println("");
		}
		
	}

}
