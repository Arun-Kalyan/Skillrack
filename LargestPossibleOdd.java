import java.util.*;
public class LargestPossibleOdd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		int [] digits = new int [10];
		while(N!=0)
		{
			digits[(int) (N % 10)]++;
			N=N/10;
		}
		
		int ud=-1;
		
		for(int i=1; i<=9; i+=2) // odd number traversal
		{
			if(digits[i] > 0)
			{
				ud = i;
				digits[i]--;
				break;
			}
		}
		
		if(ud==-1)
		{
			System.out.print("no");
			return;
		}
		int start=1;
		for(int i=1; i<=9; i++)
		{
			if(digits[i] > 0)
			{
				start=0;
				break;
			}
		}
		for(int i=9; i>=start; i--)
		{
			while(digits[i] > 0)
			{
				System.out.print(i);
				digits[i]--;
			}
		}
		
		System.out.print(ud);

	}

}
