import java.util.*;
public class maxCoinsBottomRowCannotPick{

    public static void main(String[] args) {
		//Your Code Here
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-- > 0)
		{
		    int R = sc.nextInt(), C = sc.nextInt();
		    int [][] matrix = new int [R][C];
		    
		    for(int i=0; i<R; i++)
		    {
		        for(int j=0; j<C; j++)
		        {
		            matrix[i][j] = sc.nextInt();
		        }
		    }
		    
		    int[][] dp = new int[R][C];
		    for(int col=0; col<C; col++)
		    {
		        dp[0][col] = matrix[0][col];
		    }
		    
		    for(int row =1; row<R; row++)
		    {
		        int [] prev = Arrays.copyOf(dp[row-1], C);
		        Arrays.sort(prev);
		        int firstMax = prev[C-1];
		        int secondMax = prev[C-2];
		        
		        for(int col=0; col<C; col++)
		        {
		            if(dp[row-1][col]!=firstMax)
		            {
		                dp[row][col] = firstMax+matrix[row][col];
		            }
		            else
		            {
		                dp[row][col] = secondMax+ matrix[row][col];
		            }
		        }
		    }
		    
		    Arrays.sort(dp[R-1]);
		    System.out.println(dp[R-1][C-1]);
		    
		}
		

	}
}