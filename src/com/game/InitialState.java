package com.game;

import java.util.Scanner;

import static com.game.config.Constants.MAX_GRID_SIZE;

/***
 * 1. Initial state is a class that initialize game
 * with width/height for the grid
 * 2. The elements themselves
 * 3. x and y coordinates
 * 4. Rounds
 */
public class InitialState {
    private int width; // Max width for the grid
    private int height; // Max height for the grid

    private String[][] grid; // Two dimensional array

    private int offsetX; // looking for coordinates x
    private int offsetY; // looking for coordinates y
    private int maxRounds; // (N) maximum rounds

    public InitialState() {
        this.width = 0;
        this.height = 0;
    }

    public void init() {
        final Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a width ");
        this.width = scanner.nextInt();

        System.out.print("Enter a height ");
        this.height = scanner.nextInt();

        if (this.width != 0 && this.width <= this.height && this.height < MAX_GRID_SIZE)
            System.out.println("The game begins");
        else
            System.out.println("The game starting is failed, try again");

        grid = new String[this.width][this.height];
        initTwoDimensionalArray(grid);

        System.out.println("Enter coordinates for x");
        offsetX = scanner.nextInt();
        System.out.println("Enter coordinates for y");
        offsetY = scanner.nextInt();
        System.out.println("Enter max rounds (N)");
        maxRounds = scanner.nextInt();
    }

    private static void initTwoDimensionalArray(String[][] array){
        Scanner in = new Scanner(System.in);

        for (int i = 0; i < array.length; i++) {
            System.out.println("Row " + (i + 1) + "(green(1s)/red(0s))");
            for (int j = 0; j < array.length; j++) {
                String line = in.nextLine();
                if (line.equals("1s") || line.equals("0s"))
                    array[i][j] = line;
                else array[i][j] = "0s";
            }
        }
    }

    public void showInputs() {
        System.out.println(this.width + ", " + this.height);

        for(short i = 0; i < grid.length; i++) {
            for(short j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " \t");
            }
            System.out.println("\n");
        }

        System.out.println(this.offsetX + ", " + this.offsetY + ", " + this.maxRounds);
    }

    public String[][] getGrid() {
        return grid;
    }

    public int getOffsetX() {
        return offsetX;
    }

    public int getOffsetY() {
        return offsetY;
    }

    public int getMaxRounds() {
        return maxRounds;
    }
}
