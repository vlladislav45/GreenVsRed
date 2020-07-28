package com.game.services.impl;

import com.game.services.base.PlayService;

/***
 * Surround elements is a method that check every element from the
 * two dimensional array with the surrounded elements
 * The method take arguments like the array, x and y coordinates
 * x and y is for are the coordinates of the element that I check how many times it will turn green
 * N is equivalent to rounds
 */
public class PlayServiceImpl implements PlayService {
    public PlayServiceImpl() {
    }

    public int surroundElements(String[][] array, int offsetX, int offsetY, int n) {
        int count = 0;
        int start = 0;
        int greens = 0;
        String[][] tempGrid = new String[array.length][array.length];

        while(start <= n) {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {

                    for (int y = Math.max(0, i - 1); y <= Math.min(i + 1, array.length); y++) { // 0 <= 1; ++
                        for (int x = Math.max(0, j - 1); x <= Math.min(j + 1, array[i].length); x++) { // 0 <= 1; ++

                            if (x >= 0 && y >= 0 && y < array.length && x < array[i].length) {
                                if (y != i || x != j) {
                                    //System.out.print(array[y][x] + " ");
                                    if(array[y][x].equals("1s")) //check if it is green
                                        greens++;
                                }
                            }
                        }
                    }
                    //System.out.println("\n");

                    //Rules
                    if(array[i][j].equals("1s") && checkGreen(greens)) { //green
                        tempGrid[i][j] = "1s";
                    }
                    else if(array[i][j].equals("0s") && checkRed(greens)) { // red
                        tempGrid[i][j] = "1s";
                    }else {
                        tempGrid[i][j] = "0s";
                    }

                    if(j == offsetX && i == offsetY && array[i][j].equals("1s"))
                        count++;

                    //reset green counter
                    greens = 0;
                }
                if(i == array.length-1) {
                    start++;

                   copyArray(array, tempGrid);
                }
            }
        }
        return count;
    }

    private void copyArray(String[][] array, String[][] newArray) {
        for(int i=0; i<array.length; i++)
            for(int j=0; j<array[i].length; j++)
                array[i][j]=newArray[i][j];
    }

    private boolean checkGreen(int greens) {
        if(greens == 2 || greens == 3 || greens == 6)
            return true;
        return false;
    }

    private boolean checkRed(int greens) {
        if(greens == 3 || greens == 6)
            return true;
        return false;
    }

}
