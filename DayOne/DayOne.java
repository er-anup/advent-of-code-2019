/**
 *
 *
 *
 */

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.util.Scanner;
import java.lang.Math;
import java.lang.Integer;

public class DayOne {

    static int fuelRequiredTotalSum = 0;

    public static void main(String[] args) {

/*        Scanner reader = new Scanner(System.in);
        System.out.print("Enter a number: ");

        int mass = reader.nextInt();
        int fuel = Math.round(mass / 3) - 2;*/

        String filePath = "input/DayOne.txt";

        System.out.println(readLineByLineJava8( filePath ) + " is the total fuel required ");
        //System.out.println("For a mass of " + mass + ", the fuel required is " + fuel);
    }

    private static int readLineByLineJava8 (String filePath)
    {
        int sum = 0;
        try (Stream<String> numbers = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8))
        {

            //sum = numbers.map(Integer::parseInt).map(DayOne::getFuelRequired).reduce(0, (x,y) -> x+y);
            numbers.map(Integer::parseInt).forEach(DayOne::getFuelRequired);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return fuelRequiredTotalSum;
    }

    private static int getFuelRequiredForLanding(int mass)
    {
        return Math.round(mass / 3) - 2;
    }

    private static int getFuelRequiredForFuelModule(int fuel)
    {

        int fuelRequired =  Math.round(fuel / 3);

        if (fuelRequired > 2) {
            fuelRequired = fuelRequired - 2;
        } else {
            fuelRequired = fuel;
        }

        return fuelRequired;
    }

    private static int getFuelRequired(int fuel)
    {

        int fuelRequired = getFuelRequiredForFuelModule(fuel);

        if (fuelRequired == fuel) {
            return fuelRequiredTotalSum;
        }

        fuelRequiredTotalSum = fuelRequiredTotalSum + fuelRequired;

        return getFuelRequired(fuelRequired);
    }




}