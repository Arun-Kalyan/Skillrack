import java.util.*;
public class CoronaVirus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();
		int [][] mat = new int [R][C]; 
		int healthy =0, days=0;
		Queue<Integer> queue = new ArrayDeque<>();
		
		for(int i=0; i<R; i++)
		{
		    for(int j=0; j<C; j++)
		    {
		        mat[i][j] = sc.nextInt();
		        if(mat[i][j] == 1)
		        {
		            healthy++;
		        }
		        if(mat[i][j] ==2)
		        {
		            queue.add(i*C+j);
		        }
		    }
		}
		
		
		queue.add(-1);
		while(!queue.isEmpty())
		{
		    int node = queue.poll();
		    if(node == -1)
		    {
		        if(!queue.isEmpty())
		        {
		            days++;
		            queue.add(-1);
		        }
		        continue;
		    }
		    int row = node/C, col= node%C;
		    if(col!=0 && mat[row][col-1] == 1)
		    {
		        mat[row][col-1] = 2;
		        queue.add(row*C+col-1);
		        healthy--;
		    }
		    
		    if(col!= C-1 && mat[row][col+1] ==1)
		    {
		        mat[row][col+1]=2;
		        queue.add(row*C+col+1);
		        healthy--;
		    }
		    
		    if(row!=0 && mat[row-1][col] ==1)
		    {
		        mat[row-1][col] = 2;
		        queue.add((row-1) *C + col);
		        healthy--;
		    }
		    
		    if(row!=R-1 && mat[row+1][col] == 1)
		    {
		        mat[row+1][col] = 2;
		        queue.add((row+1) * C+col);
		        healthy--;
		    }
		}
	
		 System.out.println(healthy==0 ? days : -1);
		

	}

}
