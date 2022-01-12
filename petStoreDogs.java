import java.util.*;
import java.math.*;
public class petStoreDogs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        BigInteger cages[] = new BigInteger[N+1];
        for(int i=1; i<=N; i++)
        {
            if(i<=2)
            {
                cages[i] = new BigInteger(i+"");
            }
            else
            {
                cages[i] = new BigInteger((i-1)+"");
                cages[i] = cages[i].multiply(cages[i-2]);
                cages[i] = cages[i].add(cages[i-1]);
            }
	    }
	    
	    System.out.print(cages[N]);

	}

}
