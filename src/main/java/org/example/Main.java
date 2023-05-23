package org.example;

public class Main {
    public static void main(String[] args) {

        int[][] matrix = new int[9][3];

        matrix[0][0]=1;
        matrix[0][1]=2;
        matrix[0][2]=3;

        matrix[1][0]=4;
        matrix[1][1]=5;
        matrix[1][2]=-1;

        matrix[2][0]=-1;
        matrix[2][1]=5;
        matrix[2][2]=-1;

        matrix[3][0]=-1;
        matrix[3][1]=-1;
        matrix[3][2]=3;

        matrix[4][0]=6;
        matrix[4][1]=7;
        matrix[4][2]=-1;

        matrix[5][0]=-1;
        matrix[5][1]=5;
        matrix[5][2]=-1;

        matrix[6][0]=6;
        matrix[6][1]=5;
        matrix[6][2]=-1;

        matrix[7][0]=-1;
        matrix[7][1]=8;
        matrix[7][2]=-1;

        matrix[8][0]=-1;
        matrix[8][1]=5;
        matrix[8][2]=-1;

//Pongo que estados son finales y cuales no lo son
        boolean[] fin = new boolean[9];
        fin[0]=false;
        fin[1]=true;
        fin[2]=true;
        fin[3]=true;
        fin[4]=false;
        fin[5]=true;
        fin[6]=false;
        fin[7]=true;
        fin[8]=true;















    }
}