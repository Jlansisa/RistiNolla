package com.example.ville.myapplication;

/**
 * Created by ville on 9.2.2017.
 */

public class CharHandler {

    private int[][] dataField = new int[3][3];


    void calculateFields(char inputChar)
    {

        switch (inputChar){

        case a:
            dataField[0][0] = 1;
            break;

        case b:
            dataField[1][0] = 1;
            break;

        case c:
            dataField[2][0] = 1;
            break;

        case d:
            dataField[0][1] = 1;
            break;

        case e:
            dataField[1][1] = 1;
            break;

        case f:
            dataField[2][1] = 1;
            break;

        case g:
            dataField[0][2] = 1;
            break;

        case h:
           dataField[1][2] = 1;
            break;

        case i:
            dataField[2][2] = 1;
            break;


    }

    }


}
