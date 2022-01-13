import java.util.*;
public class MinimumJumpsToReachEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		if(N==1)
		{
			System.out.println("0");
			return;
		}
		int stones[] = new int[N];
		for(int i=0; i<N; i++) stones[i] = sc.nextInt();
		int jumps = 1, maxIndex=stones[0], steps=stones[0];
		
		for(int i=1; i<N-1; i++)
		{
			if(maxIndex < i+stones[i]) 	
			{
				maxIndex = i+stones[i];
			}		
			steps--;
			if(steps==0) {
				jumps++;
				steps = maxIndex - i;
			}					
			
		}		
			
		System.out.println(jumps);

	}

}
