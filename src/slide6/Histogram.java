package slide6;
import java.util.*;

public class Histogram {
	
	public static void main(String[] args) {
		int[][] matrix1 = {
			{0, 0, 4, 5, 5, 5, 5, 4},
			{0, 4, 6, 6, 6, 6, 4, 0},
			{4, 8, 8, 15, 5, 5, 15, 8},
			{5, 8, 8, 10, 10, 10, 8, 8},
			{5, 8, 8, 10, 15, 15, 10, 8},
			{5, 8, 8, 10, 15, 15, 10, 8},
			{5, 8, 8, 10, 10, 10, 8, 8},
			{0, 4, 6, 6, 6, 6, 6, 4}
		};
		int[][] binaryMatrix = new int[8][8];
		
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (matrix1[i][j] <= 9)
					binaryMatrix[i][j] = 1;
				else
					binaryMatrix[i][j] = 0;
			}
		}
		
		print2D(binaryMatrix);
		calculateHistogram(matrix1);
		
		
	}
	
    public static void print2D(int mat[][]) { 
        for (int[] row : mat) 
            System.out.println(Arrays.toString(row)); 
    }  
    
    
    public static void calculateHistogram(int mat[][]) {
    	int count = 0;
    	
    	// Foi utilizado 16 como valor máximo da intensidade dos pixels na escala de cinza pois os demais valores até 255 são igual a 0.
		for (int k = 0; k < 16; k++) {
			count = 0;
	    	for (int i =0; i < 8; i++) {
	    		for (int j = 0; j < 8; j++) {
	        			if (mat[i][j] == k)
	        				count++;
    			}
    		}
	    	System.out.println("Intesidade " + k + ": " + count + " pixels");
    	}
    	
	}

}