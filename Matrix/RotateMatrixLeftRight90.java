import java.io.*;

 class RotateMatrix{
 private static void transpose(int[][] m) {                 // rows into cols
        for (int i = 0; i < m.length; i++) {
            for (int j = i; j < m[0].length; j++) {
                int x = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = x;
            }
        }
    }

	
	public static void swapRows(int[][] m) {
        for (int  i = 0, k = m.length - 1; i < k; ++i, --k) {
            int[] x = m[i];
            m[i] = m[k];
            m[k] = x;
        }
    }

    public static void rotateByNinetyToLeft(int[][] m) {
        transpose(m);
        swapRows(m);
    }

    public static void rotateByNinetyToRight(int[][] m) {
        swapRows(m);
        transpose(m);
    }
	
	/*private static void swapCols(String s[])
   {
       for (int i = 0; i < s.length / 2; i++)
       {

            String temp = s[s.length - 1 - i];
            s[s.length - 1 - i] = s[i];
            s[i] = temp;
       }
   }
   
   public static void swap(int[][] arr, int line, int pos1, int pos2) {
    int temp = arr[line][pos1];
    arr[line][pos1] = arr[line][pos2];
    arr[line][pos2] = temp;
  }
   
	*/
	
    public static void printMatrix(int[][] m) {
        for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < m[0].length; j++) {
                    System.out.print(m[i][j] + " ");
                }
                System.out.println();
            }
    }

     public static void main(String[] args) {
            int[][] mEven = {{1, 3},
                            {2, 4},
                            
            };
    
            rotateByNinetyToLeft(mEven);
            printMatrix(mEven);
            
    
            System.out.println("---------------------------------");
    
            rotateByNinetyToRight(mEven);
    
            printMatrix(mEven);
            
            System.out.println("---------------------------------");
    
            int[][] mOdd = {{1, 2, 3},
                            {4, 5, 6},
                            {7, 8, 9}};
    
            rotateByNinetyToLeft(mOdd);
    
            printMatrix(mOdd);
    
            System.out.println("---------------------------------");
    
            rotateByNinetyToRight(mOdd);
    
            printMatrix(mOdd);
    
            System.out.println("---------------------------------");
    
        }
	
}