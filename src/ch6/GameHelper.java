package ch6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GameHelper {
    private static final String ALPHAPET = "abcdefg";
    private static final int GRID_LENGTH = 7;
    private static final int GRID_SIZE = 49;
    private static final int MAX_ATTEMPTS = 200;
    static final int HORIZONTAL_INCREMENT = 1; // Better way to represent these two
    static final int VERTICAL_INCREMENT = GRID_LENGTH; // things is an `enum`

    private final int[] grid = new int[GRID_SIZE];
    private final Random random = new Random();
    private int startupCount = 0;

    public String getUserInput(String prompt) {
        System.out.println(prompt + ": ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().toLowerCase();
    }

    public ArrayList<String> placeStartup(int startupSize) {
        // Holds index to grid (0 - 48)
        int[] startupCoords = new int[startupSize];
        int attempts = 0;
        boolean success = false;

        startupCount++;
        int increment = getIncrement();

        while (!success & attempts++ < MAX_ATTEMPTS) { // Main Search loop
           int location = random.nextInt(GRID_SIZE); // get random Starting point

            for (int i = 0; i < startupCoords.length; i++) { // Create array of proposed coords
                startupCoords[i] = location; // Put current location in array
                location += increment; // Calculate the next location
            }
            System.out.println("Trying: " + Arrays.toString(startupCoords)); // Testing the current locations

            if (startupFits(startupCoords, increment)) { // Startup Fits on the grid
                success = coordsAvailable(startupCoords); //  ... and locations aren't taken?
            }
        }

        savePositionsToGrid(startupCoords); // Coords  passed check, save them.
        ArrayList<String> alphaCells = convertCoordsToAlphaFormat(startupCoords);
        System.out.println("Placed at: " + alphaCells); // Tells you exactly where the startup is located
        return alphaCells;
    } // end of placeStartup

    private boolean startupFits(int[] startupCoords, int increment) {
        int finalLocation = startupCoords[startupCoords.length - 1];
        if (increment == HORIZONTAL_INCREMENT) {
            // Check end is on the same row as start
            return calcRowFromIndex(startupCoords[0]) == calcRowFromIndex(finalLocation);
        } else {
            return finalLocation < GRID_SIZE; // Check end isn't off the bottom
        }
    } // End startupFits

    private boolean coordsAvailable(int[] startupCoords) {
        for (int coord : startupCoords) { // check all potential positions
            if (grid[coord] != 0) { // this position is already taken
                System.out.println("Position " + coord + " is already in the grid (taken).");
                return false; // NO success
            }
        }

        return true; // There were no clashes, GOOD!
    } // end CoordsAvailable

    private void savePositionsToGrid(int[] startupCoords) {
        for (int index : startupCoords) {
            grid[index] = 1;
        }
    } // savePositionsToGrid

    private ArrayList<String> convertCoordsToAlphaFormat(int[] startupCoords) {
        ArrayList<String> alphaCells = new ArrayList<String>();
        for (int index : startupCoords) { // for each grid coordinate
            String alphaCoords = getAlphaCoordsFromIndex(index); // turn it into a "a0" style
            alphaCells.add(alphaCoords); // add to a list
        }
        return alphaCells; // Return the "a0"-style coords
    }

    private String getAlphaCoordsFromIndex(int index) {
        int row = calcRowFromIndex(index); // get row value
        int column = index % GRID_LENGTH; // Get numeric column value
        String letter = ALPHAPET.substring(column, column + 1);
        return letter + row;
    } // end

    private int calcRowFromIndex(int index) {
        return index / GRID_LENGTH;
    }

    private int getIncrement() {
        if (startupCount % 2 == 0) {
            return HORIZONTAL_INCREMENT;
        } else {
            return VERTICAL_INCREMENT;
        }
    }
}
