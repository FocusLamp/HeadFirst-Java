import java.util.ArrayList;


public class StartupBust {
    // Declare and initialization
    private GameHelper helper = new GameHelper(); // Help with the interacting with the game logic
    private ArrayList<Startup> startups = new ArrayList<Startup>(); // Will hold the StartUps locations cells
    private int numOfGuesses = 0; // Initial value


    // 4 Functions
    // Start Game
    private void setUpGame() {
        // Make three startup objects, name them, put them in the startups ArrayList
        Startup one = new Startup();
        one.setName("einee");
        Startup two = new Startup();
        two.setName("minee");
        Startup three = new Startup();
        three.setName("mo");

        startups.add(one);
        startups.add(two);
        startups.add(three);

        // Print brief user instructions for user
        System.out.println("Your goal is to sink the Startups.");
        System.out.println("Einee, minee, mo");
        System.out.println("Try to sink them all in the fewest number of guesses");


        for (Startup startup : startups) { // repeat with each startup in the list
            ArrayList<String> newLocation = helper.placeStartup(3); // Ask helper for startup locations
            startup.setLocationCells(newLocation); // Call Setter method on this startup to give it you just got from the helper
        }
    }

    // Mid-Game
    private void startPlaying() {
        // While there are startups, continue playing
        while (!startups.isEmpty()) { // As long as the `startups` list is NOT empty
            String userGuess = helper.getUserInput("Enter a guess: "); // Get User input
            checkUserGuess(userGuess); // Call our own checkUserGuess method
        }
        finishGame(); // Call our own finishGame Method
    }
    private void checkUserGuess(String userGuess) {
        // check if the user got hit/kill and increment the numOfGuesses
        numOfGuesses++; // Increment the number of guesses the user has made
        String result = "miss"; // Assume it's a miss unless told otherwise

        // repeat with all the startups in the list
        for (Startup startupToTest : startups) {
            result = startupToTest.checkYourself(userGuess); // Ask the startup to check the user guess, looking for a hit (or kill)

            if (result.equals("hit")) {
                break; // Get out of the loop early no point in testing the others
            }
            if (result.equals("kill")) {
                // this one's dead, take out of the `startups` list and get out of the loop
                startups.remove(startupToTest);
                break;
            }
        }
        System.out.println("Your guess is: " + result); // Print the result for the user
    }

    // End Game
    // Print the result for the user
    private void finishGame() {
        // Game ended screen
        System.out.println("All Startups are dead! Your stock is now worthless 🔥🔥");
        if (numOfGuesses <= 18) {
            System.out.println("It only took you " + numOfGuesses + " guesses.");
            System.out.println("You got out before your options sank.");
        } else {
            System.out.println("Took you long enough " + numOfGuesses + " guesses.");
            System.out.println("Fish are dancing with your options");
        }
    }

    public static void main(String[] args) {
        StartupBust game = new StartupBust(); // Create the game object
        game.setUpGame(); // Tell the game object to set up the game
        game.startPlaying(); // Tell the game object to start the main game loop
    }
}