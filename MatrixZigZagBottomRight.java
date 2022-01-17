import java.util.*;
public class MatrixZigZagBottomRight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();
		int [][] mat = new int[R][C];
		for(int i=0; i<R; i++)
		{
		    for(int j=0; j<C; j++)
		    {
		        mat[i][j] = sc.nextInt();
		    }
		}
		
		int direction = 1, row =R-1, col =C-1;
		
		for(int i=1; i<=R+C+1; i++)
		{
		    if(direction==1)
		    {
		        while(row>=0 && col <C)
		        {
		            System.out.print(mat[row][col]+" ");
		            row--;
		            col++;
		        }
		        direction=-1;
		        if(row<0)
		        {
		            row=0;
		            col-=2;
		        }
		        if(col>=C && row>=0)
		        {
		            col=C-1;
		        }
		    }
		    
		    else
		    {
		        while(row<R && col>=0)
		        {
		            System.out.print(mat[row][col]+" ");
		            row++;
		            col--;
		        }
		        
		        direction=1;
		        if(col<0)
		        {
		            col=0;
		            row-=2;
		        }
		        
		        if(row>=R)
		        {
		            row=R-1;
		        }
		        
		    }
		}
		

	}

}
