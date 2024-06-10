package matrix; 
import java.util.*; 


public class Medium {
    /**
     * Set Zeroes 
     *      Objective
     *          Set zeroes to a matrix row and col if an zero valued cell is encountered. 
     *      Stratrgy
     *          Keep our markers as base to seee if there is zero at each row col intersectaction. To do that, 
     *          we need to iterate whole matrix, and change first col and first row values accordingly. 
     *          Along that we are going to keep track of weather we found a zero in either first row and 
     *          first column using a boolean value. 
     *          
     *          Replace inner matrix according to our markers. 
     *          
     *          Using our flags of zero in first row and zero is first column replace reamining values.
     *     
     *      Time Complexity
     *          O(MN)
     *      
     *      Space Complexity
     *          O(1)
     *
     */
    private static void setZeroes(int[][] matrix) {
        boolean firstRow = false; 
        boolean firstCol = false; 
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
    

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++){
                if (matrix[i][j] == 0) {
                    if (i == 0) 
                        firstRow = true; 
                    if (j == 0) 
                        firstCol = true;                     
                    // update markers 
                    // update first row at given col
                    matrix[0][j] = 0;  
                    // update first col at given row
                    matrix[i][0] = 0;                    
                }
            }
        }


        for (int i = 1; i < rowLength; i++) {
            for (int j = 1; j < colLength; j++) {
                //check if first row at current col and check first col at given row
                if (matrix[0][j] == 0 || matrix[i][0] == 0) 
                    matrix[i][j] = 0;                                 
            }
        }


        if (firstRow)
            for (int j = 0; j < colLength; j++) 
                matrix[0][j] = 0; 
        if (firstCol) 
            for (int i = 0; i < rowLength; i++) 
                matrix[i][0] = 0;

    }

    public static void setZeroes() {
        int [][] matrix = {
            {1, 1, 1}, 
            {1, 0, 1}, 
            {1, 1, 1}
        }; 

        int [][] matrix2 = {
            {0, 1, 2, 0}, 
            {3, 4, 5, 2}, 
            {1, 3, 1, 5}
        };

        setZeroes(matrix2);
    
        for (int i = 0; i < matrix2.length; i++)  {
            for (int j = 0; j < matrix2[0].length; j++) 
                System.out.print(matrix2[i][j]); 
            
            System.out.println();
        }


    }
}