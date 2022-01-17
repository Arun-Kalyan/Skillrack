import java.util.*;
public class StreetTravelCount {
	static List<Integer> getRelated (int [][] matrix, int node, int N)
    {
        List<Integer> nodes = new ArrayList<>();
        
        int nodeRow = node/N, nodeCol = node%N;
        for(int col=nodeCol-1; col>=0; col--)
        {
            if(matrix[nodeRow][col] ==1)
            {
                nodes.add(nodeRow*N+col);
            }
            else
            {
                break;
            }
        }
        
        for(int col = nodeCol+1; col<N; col++)
        {
            if(matrix[nodeRow][col] ==1)
            {
                nodes.add(nodeRow*N+col);
            }
            else
            {
                break;
            }
        }
        
        for(int row = nodeRow-1; row>=0; row--)
        {
            if(matrix[row][nodeCol] ==1)
            {
                nodes.add(row*N+nodeCol);
            }
            else
            {
                break;
            }
        }
        
        
        for(int row = nodeRow+1; row<N; row++)
        {
            if(matrix[row][nodeCol] ==1)
            {
                nodes.add(row*N+nodeCol);
            }
            else
            {
                break;
            }
        }
        
        return nodes;
    }

    public static void main(String[] args) {
		//Your Code Here
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
	    int [][] mat = new int [N][N];
	    
	    for(int i=0; i<N; i++)
	    {
	        for(int j=0; j<N; j++)
	        {
	            mat[i][j] = sc.nextInt();
	        }
	    }
	    
	    int source = sc.nextInt()*N+ sc.nextInt();
	    int destination = sc.nextInt()*N + sc.nextInt();
	    
	    boolean visited[] = new boolean [N*N];
	
	    int streets[] = new int [N*N];
	    Queue<Integer> queue = new ArrayDeque<>();
	    queue.add(source);
	    visited[source] = true;
	    streets[source] =0;
	    
	    while(!queue.isEmpty())
	    {
	        int node = queue.poll();
	        List<Integer> related = getRelated(mat, node, N);
	        for(Integer relNode:related)
	        {
	            if(!visited[relNode])
	            {
	                queue.add(relNode);
	                visited[relNode]=true;
	                streets[relNode] = streets[node]+1;
	                if(relNode == destination)
	                {
	                    System.out.println(streets[relNode]);
	                    return;
	                }
	                
	            }
	        }
	    }
	    
	    System.out.println(streets[destination]);
	
    }
}
