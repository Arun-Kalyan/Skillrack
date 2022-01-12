import java.util.*;
class Link{
		    int source, dest, dist;
		}
public class singleSourceShortestPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
				Scanner sc = new Scanner(System.in);
				int N = sc.nextInt(), L = sc.nextInt();
				List<Link> links = new ArrayList<>();
				for(int ctr=1; ctr<=L; ctr++)
				{
				    Link link = new Link();
				    link.source = sc.nextInt();
				    link.dest = sc.nextInt();
				    link.dist = sc.nextInt();
				    links.add(link);
				}
				
				Integer shortest[] = new Integer[N+1];
				shortest[1] =0;
				boolean relaxed = true;
				for(int iter =1; iter<N && relaxed; iter++)
				{
				    relaxed = false;
				    for(Link link: links)
				    {
				        if(shortest[link.source] == null)
				        {
				            continue;
				        }
				        if(shortest[link.dest] == null || shortest[link.source] + link.dist< shortest[link.dest])
				        {
				            shortest[link.dest] = shortest[link.source]+ link.dist;
				            relaxed = true;
				        }
				        
				    }
				}
				
				for(int city=2 ; city<=N; city++)
				{
				    System.out.print(shortest[city]+" ");
				}
				


	}

}

