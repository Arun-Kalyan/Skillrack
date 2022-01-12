import java.util.*;
public class minimumDistanceBetweenStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		String b = sc.nextLine();
		int lena = a.length();
		int lenb = b.length();
		int dist[][] = new int[lena+1][lenb+1];
		for(int i=0; i<lena; i++)
		{
		    dist[i+1][0] = i+1;
		}
		
		for(int i=0; i<lenb; i++)
		{
		    dist[0][i+1] = i+1;
		}
		
		
		for(int i=0; i<lena; i++){
		    for(int j=0; j<lenb; j++)
		    {
		        if(a.charAt(i) == b.charAt(j))
		            dist[i+1][j+1] = dist[i][j];
		        else
		            dist[i+1][j+1] = Math.min(Math.min(dist[i][j+1], dist[i+1][j])+1, dist[i][j]+1);
		    }
		}
        
        System.out.println(dist[lena][lenb]);

	}

}
