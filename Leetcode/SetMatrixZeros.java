public class Solution {                                                         
    public void setZeroes(int[][] matrix) {                                     
        // IMPORTANT: Please reset any member data you declared, as             
        // the same Solution instance will be reused for each test case.        
                                                                                
        int rows = matrix.length;                                               
        int cols = matrix[0].length;                                            
        boolean zeroRow = false;                                                
        boolean zeroCol = false;                                                
                                                                                
        for(int i = 0; i < rows; i++) {                                         
            if(matrix[i][0] == 0) {                                              
                zeroCol = true;    
                break;
            }
        }                                                                       
                                                                                
        for(int j = 0; j < cols; j++) {                                         
            if(matrix[0][j] == 0) {                                              
                zeroRow = true;   
                break;
            }
        }                                                                       
                                                                                
        for(int i = 1; i < rows; i++) {                                         
            for(int j = 1; j < cols; j++) {                                     
                if(matrix[i][j] == 0) {                                         
                    matrix[i][0] = 0;                                           
                    matrix[0][j] = 0;                                           
                }                                                               
            }                                                                   
        }                                                                       
                                                                                
        for(int i = 1; i < rows; i++) {                                         
            if(matrix[i][0] == 0) {                                             
                for(int j = 1; j < cols; j++)                                   
                    matrix[i][j] = 0;                                           
            }                                                                   
        }  
        
        for(int j = 1; j < cols; j++) {                                         
            if(matrix[0][j] == 0) {                                             
                for(int i = 1; i < rows; i++)                           
                    matrix[i][j] = 0;                                           
            }                                                                   
        }                                                                       
                                                                                
        if(zeroRow == true) {                                                   
            for(int i = 0; i < cols; i++)                                       
                matrix[0][i] = 0;                                               
        }                                                                       
                                                                                
        if(zeroCol == true) {                                                   
            for(int j = 0; j < rows; j++)                                       
                matrix[j][0] = 0;                                               
        }                                                                       
    }                                                                           
}          
