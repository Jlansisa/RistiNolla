/**
 *
 * @author ville
 */
public class SearchDatafield {
    
   static boolean isGameWon(int[][] dataArray)
    {
        
        if(searchHorizontal(dataArray))
        {
            return true;
        }
        
        else if(searchVertical(dataArray))
        {
            return true;
        }
        
        else if(searchDiagonal(dataArray))
        {
            return true;
        }
        
        else
        return false;
        
    }
    
   static boolean searchHorizontal(int[][] dataArray)
   {
       
       for(int i = 0; i < 3; i++)
       {
           
           int rowValue = 0;
           
           for(int j = 0; j < 3; j++)
           {
               
               if(dataArray[i][j] == 1)
               {
                   rowValue++;
               }
               
           }
           
           if(rowValue == 3)
           {
               return true;
           }
           
       }
       
       return false;
       
   }
   
   static boolean searchVertical(int[][] dataArray)
   {
       
       for(int i = 0; i < 3; i++)
       {
           
           int columnValue = 0;
           
           for(int j = 0; j < 3; j++)
           {
               
               if(dataArray[j][i] == 1)
               {
                   columnValue++;
               }
               
           }
           
           if(columnValue == 3)
           {
               return true;
           }
           
       }
       
       return false;
       
   }
   
   static boolean searchDiagonal(int[][] dataArray)
   {
       
       int diagonalValue = 0;
       
           for(int j = 0; j < 3; j++)
           {
               
               if(dataArray[j][j] == 1)
               {
                   diagonalValue++;
               }
               
           }
           
           if(diagonalValue == 3)
           {
               return true;
           }
           
       
       
       return false;       
       
   }
    
}
