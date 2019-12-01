/**
 * This is the Code in Java as a solution to second puzzle of Advent of Code 2019
 * 'What is the sum of the fuel requirements for all of the modules on your spacecraft when also taking into account
 *  the mass of the added fuel?'
 *
 */

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.lang.Math;
import java.lang.Integer;

public class SecondPuzzle {

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
            modules.map(Integer::parseInt).forEach(SecondPuzzle::getTotalAmountOfFuelRequired);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return totalFuelRequired;
    }

    /**
     * This function returns total amount of fuel required for the each module mass
     * @param fuel
     * @return
     */
    private static int getFuelRequired(int inputModuleMass)
    {
        int fuelRequired =  Math.round(inputModuleMass / 3);

        return (fuelRequired > 2) ? fuelRequired - 2 : inputModuleMass;
    }

    /**
     * This function returns total amount of fuel required for the module
     * @param fuel
     * @return
     */
    private static int getTotalAmountOfFuelRequired(int inputModuleMass)
    {
        int fuelRequired = getFuelRequired(inputModuleMass);

        if (fuelRequired == inputModuleMass) {
            return totalFuelRequired;
        }

        totalFuelRequired = totalFuelRequired + fuelRequired;

        return getTotalAmountOfFuelRequired(fuelRequired);
    }
}
