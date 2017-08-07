import java.io.*;

class GFG {
    int N = 8;
    
    static int MATRIX[][] = new int[][]{{0, 0, 1, 1},
                    					{0, 0, 1, 0},
                    					{0, 0, 0, 0},
                    					{0, 1, 1, 0}};

    static boolean knows(int a, int b)
    {
        if(MATRIX[a][b] == 1)
          return true;
        else   
    	  return false;
    }
    
    public static int findCelebrity(int n) {
		int celebrity = 0;

		for (int i = 1; i < n; ++i) {
			if (knows(celebrity, i)) {
				celebrity = i;
			}
		}

		for (int i = 0; i < n; ++i) {             // celebrity should not know any other
			if (i != celebrity &&
				(!knows(i, celebrity) || knows(celebrity, i))) {
				return -1;
			}
		}

		return celebrity;
    }
    
	public static void main (String[] args) {
		//code
		int n = 4;
	int id = findCelebrity(n);
	if(id == -1)
	   System.out.println("No celebrity"); 
	 else  
			System.out.println( "Celebrity ID " + id);
	
	}
}