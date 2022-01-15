import java.util.*;
public class largestsquarematrixwith1s {

    public static void main(String[] args) {
		//Your Code Here
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt(), c= sc.nextInt();
		int [][] mat = new int[r][c];
		
		for(int i=0; i<r; i++)
		{
		    for(int j=0; j<c; j++)
		    {
		        mat[i][j] = sc.nextInt();
		    }
		}
		
		int temp[][] = new int[r+1][c+1];
		int max=0;
		
		for(int i=1; i<=r; i++)
		{
		    for(int j=1; j<=c; j++)
		    {
		        if(mat[i-1][j-1] == 1)
		        {
		            temp[i][j] = Math.min(temp[i-1][j], Math.min(temp[i][j-1], temp[i-1][j-1])) + 1;
		            max = Math.max(max, temp[i][j]);
		        }
		    }
		}
		
		System.out.println(max);

	}
}