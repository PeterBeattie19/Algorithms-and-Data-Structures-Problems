import java.util.*; 
import java.io.*; 

public class NQueensBackTracking {
	public static void main (String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

		int arr[][] = new int[4][4];

		findSolution(arr, 0);

		for(int i = 0; i<4; i++){
			for (int j = 0; j<4; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println(); 
		}

	}

	public static boolean isSafe(int board[][], int r, int c){

		for(int i = 0; i<board.length; i++){
			if(i != r && (board[i][c] == 1))
				return false;

			if(i != c && board[r][i] == 1)
				return false;
		}



		/*for(int i = r-c, int j = 0; i<board.length && j<board.length; i++,j++){
			if(i!=r && j!=c && board[i][j] == 1)
				return false; 
		}

		for(int i = r-c, int j = board.length-1; i>=0 && j>=0; i--,j--){
			if(i!=r && j!=c && board[i][j] == 1)
				return false; 
		} */ 

	        /* Check upper diagonal on left side */
	        int i = 0;
	        int j = 0;
        for ( i=r,  j=c; i>=0 && j>=0; i--, j--)
            if (board[i][j] == 1)
                return false;
 
        /* Check lower diagonal on left side */
        for ( i=r,  j=c; j>=0 && i<board.length; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true; 
	}

	public static boolean findSolution(int board[][], int col){
		if(col >= board.length)
			return true;

		for(int i = 0; i<board.length; i++){
			if(isSafe(board, i, col)){
				board[i][col] = 1;

				if(findSolution(board, col+1))
					return true;
				board[i][col] = 0; 
			}
		}

		return false; 
	}
} 