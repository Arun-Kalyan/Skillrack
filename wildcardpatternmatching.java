import java.util.*;
public class wildcardpatternmatching {

    public static void main(String[] args) {
		//Your Code Here
		Scanner sc = new Scanner(System.in);
		String text = sc.nextLine();
		String pattern = sc.nextLine();
		int R = text.length(), C= pattern.length();
		boolean matrix[][] = new boolean[R+1][C+1];
		matrix[0][0] = true;
		
		if(pattern.charAt(0) == '*')
		{
		    matrix[0][1] = true;
		}
		
		for(int i=1; i<=R; i++){
		    for(int j=1; j<=C; j++)
		    {
		        if(pattern.charAt(j-1) == '?' || pattern.charAt(j-1) == text.charAt(i-1))
		        {
		            matrix[i][j] = matrix[i-1][j-1];
		        }
		        else if(pattern.charAt(j-1) == '*')
		        {
		            matrix[i][j] = matrix[i-1][j] || matrix[i][j-1];
		        }
		    }
		}
        
        System.out.println(matrix[R][C]  ? "Matching" : "Not Matching");
        
	}
}