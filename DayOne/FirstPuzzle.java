/**
 * This is the Code in Java as a solution to first puzzle of Advent of Code 2019
 * 'What is the sum of the fuel requirements for all of the modules on your spacecraft?'
 *
 */

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.lang.Math;
import java.lang.Integer;

public class FirstPuzzle {

    static int totalFuelRequired = 0;

    public static void main(String[] args) {

        String inputPath = "input/DayOne.txt";

        System.out.println(getTotalFuelRequired( inputPath ) + " is the total fuel required ");
    }

    /**
     * This function returns the total fuel required by all of the modules
     * @param filePath String
     * @return Int
     */
    private static int getTotalFuelRequired (String inputPath)
    {
        try (Stream<String> modules = Files.lines( Paths.get(inputPath), StandardCharsets.UTF_8))
        {
            totalFuelRequired = modules.map(FirstPuzzle::getAmountOfFuelRequired).reduce(0, (x,y) -> x+y);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return totalFuelRequired;
    }

    /**
     * This function returns the Amount of Fuel required for a module
     * @param mass String
     * @return Int
     */
    private static int getAmountOfFuelRequired(String module)
    {
        int mass = Integer.parseInt(module);
        return Math.round(mass / 3) - 2;
    }
}