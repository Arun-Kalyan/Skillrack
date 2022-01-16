import java.util.*;
public class maximum_profit_winebottles {
	static int maxRevenue(int [] prices, int [][] max, int left, int right, int year)
    {
        if(max[left][right] !=0)
        {
            return max[left][right];
        }
        if(left == right)
        {
            return prices[left]* year;
        }
        int leftRevenue = prices[left] * year + maxRevenue(prices, max, left+1, right, year+1);
        
        int rightRevenue = prices[right] * year + maxRevenue(prices, max, left, right-1, year+1);
        
        max[left][right] = Math.max(leftRevenue, rightRevenue);
        return max[left][right];
        
    }

    public static void main(String[] args) {
		//Your Code Here
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int [] arr = new int[N];
		for(int i=0; i<N; i++)
		{
		    arr[i] = sc.nextInt();
		}
		
		int [][] max = new int[N][N];
		System.out.println(maxRevenue(arr, max, 0, N-1, 1));

    }

}
