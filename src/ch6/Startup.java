package ch6;

import java.util.ArrayList;

public class Startup {
    /*
    * Startup instance variables:
    * - an ArrayList of cell locations
    * - the Startup Name
     */
    private ArrayList<String> locationCells;
    private String name;

    // A setter method that updates the startup's locations. (Random locations provided by the GameHelper placeStartup() method
    public void setLocationCells(ArrayList<String> locations) {
         locationCells = locations;
    }

    // Basic Setter method
    public void setName(String newName) {
        name = newName;
    }

    //
    public String checkYourself(String userGuess) {
        String result = "miss";
        // If the user guessed one of the entries in ArrayList, it'll return ArrayList location, else -1
        int index = locationCells.indexOf(userGuess);
        if (index >= 0) {
            // Using ArrayList remove to delete and entry
            locationCells.remove(index);

            // Using .isEmpty() to check if all the locations have been guessed
            if (locationCells.isEmpty()) {
                result = "kill";
                System.out.println("Ouch! You sunk " + name + "  : ( "); // Tell the user the startup has been sunk
            } else {
                result = "hit";
            }
        }
        // Return "miss" or "hit" or "kill"
        return result;
    }
}
