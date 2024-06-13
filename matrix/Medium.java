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

    /** Spiral Order 
     *      Objective
     *          Realize a spiral traversal trough the matrix 
     *      Strategy 
     *          Traverse left to right  (RIGHT)
     *          Traverse top to bottom  (DOWN)
     *          Traverse Left to right  (LEFT)
     *          Traverse bottom to top  (UP)
     *          
     *          Remember to check always if we are inside the boundaries inside the loop. 
     *          Also check whenever we update array indexes whiting the main loop that we are currently within the boundaries.
     *          When we finish the RIGHT traversal and update the row check in the LEFT traversal if it accomplish this boundarie. 
     *          When we finish the LEFT TRAVERSAL and update col check if the RIGHT TRAVERSAL is withing this boundarie.
     *              
     *      
     *     Time Complexity:
     *          O(MN)
     *     Space Complexity(MN)
     */
    private static List<Integer> spiralOrderFun(int[][] matrix) {
        // initial boundaries 
        int colStart = 0; 
        int colEnd = matrix[0].length -1; 
        int rowStart = 0;
        int rowEnd = matrix.length -1; 
        List<Integer> result = new ArrayList<>(); 

        while (colStart <= colEnd && rowStart <= rowEnd) {
            // traverse RIGHT
            for (int j = colStart; j <= colEnd; j++)  {
                result.add(matrix[rowStart][j]); 
            }
            rowStart++;
            // traverse DOWN
            for (int i = rowStart; i <= rowEnd; i++) {
                result.add(matrix[i][colEnd]);
            }
            colEnd--;
            // traverse LEFT 
            // check for correctness 
            if (rowStart <= rowEnd) {
                for( int j = colEnd; j >= colStart; j--) {
                    result.add(matrix[rowEnd][j]); 
                }
                      rowEnd--; 
            }
      

            // traverse TOP
            if ( colStart <= colEnd ) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    result.add(matrix[i][colStart]); 
                }
                  colStart++;
            }
              
             
        }
        return result;        
    }

    public static List<Integer> spiralOrder() {
        int[][] matrix = {
            {1, 2, 3}, 
            {4, 5, 6}, 
            {7, 8, 9}
        }; 
        return spiralOrderFun(matrix);
    }


    /** Rotate Matrix
     *  Objective
     *      Rotate a image matrix nxn in place, by 90 degrees (clockwise). 
     *  Strategy
     *      ...
     *  Time Complexity
     *  Space Complexity
     * 
     * 
     *      
     */
    private static void rotate(int[][] matrix) {        
    }

    public static void rotate() {
        int[][] matrix = {
            {1, 2, 3}, 
            {4, 5, 6}, 
            {7, 8, 9}
        };
        rotate(matrix);
    }
}