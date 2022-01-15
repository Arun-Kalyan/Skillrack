import java.util.*;
class Item implements Comparable <Item> {
    int costPrice, profit;
    
    @Override
    
    public int compareTo(Item other)
    {
        return this.costPrice - other.costPrice;
    }
    
    
}
public class VendorMaximumProfit {

    public static void main(String[] args) {
		//Your Code Here
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		List<Item> items = new ArrayList<>();
		
		items.add(new Item());
		
		for(int ctr=1; ctr<=K; ctr++)
		{
		    Item item = new Item();
		    item.costPrice = sc.nextInt();
		    item.profit = sc.nextInt();
		    items.add(item);
		}
		
		Collections.sort(items);
		
	    int matrix[][] = new int[K+1] [N+1];
	    for(int item=1; item<=K; item++)
	    {
	        Item currItem = items.get(item);
	        if(currItem.costPrice > N)
	        {
	            System.out.println(matrix[item-1][N]);
	            return;
	        }
	        for(int amt=1; amt<=N; amt++)
	        {
	            if(amt<currItem.costPrice)
	            {
	                matrix[item][amt] = matrix[item-1][amt];
	            }
	            else
	            {
	                int incProfit = currItem.profit+ matrix[item-1][amt-currItem.costPrice];
	                int excProfit  = matrix[item-1][amt];
	                matrix[item][amt] = Math.max(incProfit, excProfit);
	            }
	        }
	    }
        System.out.println(matrix[K][N]);
	}
}
