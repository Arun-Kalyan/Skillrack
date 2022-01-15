import java.util.*;
public class WordBreak {
    
    static void breakWord(List<String> wordsList, String str, String output, int start )
    {
        if(start == str.length())
        {
           System.out.println(output.trim());
           return;
        }
        
        
        for(int i=start; i<str.length(); i++)
        {
            String word = str.substring(start, i+1);
            if(wordsList.contains(word))
            {
                breakWord(wordsList, str, output+word+" ", i+1);
            }
        }
        
    }
    
    

    public static void main(String[] args) {
		//Your Code Here
		Scanner sc = new Scanner(System.in);
		String words[] = sc.nextLine().split("\\s+");
		String str = sc.nextLine();
		List<String> wordList = Arrays.asList(words);
		breakWord(wordList, str, "", 0);
		

	}
}
