import java.util.*;
class FoodItem implements Comparable<FoodItem>{
    
    String name;
    List<Integer> customers;
    
    @Override
    public int compareTo(FoodItem other)
    {
        return this.customers.size() - other.customers.size();
    }
}
public class intelligent_chef {

    public static void main(String[] args) {
		//Your Code Here
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		Map<String, FoodItem> foodItemMap = new HashMap<>();
		List<Integer> remainingCustomers = new ArrayList<>();
		for(int i=1;i<=N; i++)
		{
		    remainingCustomers.add(i);
		    String preference [] = sc.nextLine().split("\\s+");
		    for(String item: preference)
		    {
		        if(!foodItemMap.containsKey(item))
		        {
		            FoodItem fi = new FoodItem();
		            fi.name = item;
		            fi.customers = new ArrayList<>();
		            foodItemMap.put(item,fi);
		        }
		        foodItemMap.get(item).customers.add(i);
		    }
		}
		
		int count=0;
		while(!remainingCustomers.isEmpty())
		{
		    List<FoodItem> items = new ArrayList<>(foodItemMap.values());
		    Collections.sort(items, Collections.reverseOrder());
		    FoodItem mostPreffered = items.get(0);
		    count++;
		    foodItemMap.remove(mostPreffered.name);
		    remainingCustomers.removeAll(mostPreffered.customers);
		    for(String foodItem : foodItemMap.keySet())
		    {
		        foodItemMap.get(foodItem).customers.removeAll(mostPreffered.customers);
		        
		    }
		}
		
		System.out.println(count);

	}
}