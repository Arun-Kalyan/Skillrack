import java.util.*;
public class toll_gate_collection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int end = sc.nextInt(), distance = sc.nextInt(), size= sc.nextInt();
		int [] tolls = new int[size]; int [] fare = new int[size];
		
		for(int i=0; i<size; i++)
		{
			tolls[i] = sc.nextInt();
		}
		
		for(int i=0; i<size; i++)
		{
			fare[i] = sc.nextInt();
		}
		
		int revenue [] = new int[end+1], index=0;
		
		for(int i=1; i<=end; i++)
		{
			if(tolls[index] == i)
			{
				revenue[i] = Math.max(revenue[i-1], fare[index] + (tolls[index] <=distance ? 0 : revenue[i-distance-1]));
				System.out.printf("\nRevenue at %d is %d and fare at %d is %d and toll at %d is %d and revenue at %d is %d", i-1, 
						revenue[i-1], index, fare[index], index, tolls[index], i-distance-1, revenue[i-distance-1]);
				System.out.printf("\n Revenue stored at %d is %d ", i, revenue[i]);
				index++;
				if(index == size)
				{
					System.out.println("\n"+revenue[i]);
					return;
				}
			}
			
			else
			{
				revenue[i] = revenue[i-1];
			}
		}
	}

}
