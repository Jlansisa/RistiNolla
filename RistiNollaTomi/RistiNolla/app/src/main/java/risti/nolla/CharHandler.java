package risti.nolla;



public class CharHandler {

    private int[][] dataField = new int[3][3];
    public CharHandler(){


    }


    void calculateFields(String inputString)
    {

        switch (inputString){

            case "ULC":
                dataField[0][0] = 1;
                break;

            case "UM":
                dataField[1][0] = 1;
                break;

            case "URC":
                dataField[2][0] = 1;
                break;

            case "LM":
                dataField[0][1] = 1;
                break;

            case "M":
                dataField[1][1] = 1;
                break;

            case "RM":
                dataField[2][1] = 1;
                break;

            case "DLC":
                dataField[0][2] = 1;
                break;

            case "DM":
                dataField[1][2] = 1;
                break;

            case "RMC":
                dataField[2][2] = 1;
                break;


        }

    }

    boolean win(){
   /*     if(dataField[2][2] + dataField[2][1] + dataField[2][0] == 3 ||          //RMC -> URC
                dataField[0][2] + dataField[1][2] + dataField[2][2] == 3 ||     // DLC->RMC
                dataField[0][0] + dataField[0][1] + dataField[0][2] == 3 ||     // ULC->DLC
                dataField[0][0] + dataField[1][0] + dataField[2][0] == 3 ||     // ULC -> URC
                dataField[1][0] + dataField[1][1] + dataField[1][2] == 3 ||     // UM->DM
                dataField[0][1] + dataField[1][1] + dataField[2][1] == 3 ||     // LM->RM
                dataField[0][0] + dataField[1][1] + dataField[2][2] == 3 ||     //ULC->RMC
                dataField[0][2] + dataField[1][1] + dataField[2][0] == 3)       //DLC->URC
        {
            return true;
        }else{
            return false;
        }
*/      if (isGameWon(dataField)) {
            return true;
        }
        return false;
    }



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

