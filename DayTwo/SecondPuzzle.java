/**
 * This is the Code in Java as a solution to second puzzle of Advent of Code 2019
 * 'Find the input noun and verb that cause the program to produce the output 19690720 ?'
 *
 *
 */

import java.io.IOException;
import java.util.*;
import java.io.File;
import java.lang.Integer;

public class SecondPuzzle  {

    public static void main(String[] args) throws IOException
    {
        int nounAndVerb = getNounAndVerbForOpcodes();

        System.out.println("The noun and verb is " + nounAndVerb + " \n");
    }

    /**
     * This function returns the noun and verb to make 19690720 at index 0 in opcodes array.
     * @return
     * @throws IOException
     */
    private static int getNounAndVerbForOpcodes() throws IOException
    {
        int noun = 0;
        int verb = 0;
        for( noun = 0 ; noun < 100; noun++){

            for( verb = 0 ; verb < 100; verb++){
                Integer[] opcodes = getOpcodeInputs();
                opcodes = replaceValues(opcodes, noun, verb);

                opcodes = getModifiedOpcodes(opcodes);

                if (getValueAtPosition(opcodes, 0) == 19690720) {
                    return ( 100 * noun + verb);
                }
            }
        }
        return 0;
    }

    /**
     * This function gets the input opcodes from the file.
     * @return
     * @throws IOException
     */
    private static Integer[] getOpcodeInputs() throws IOException
    {
        String file = "input/input.txt";
        Scanner scanner = new Scanner(new File(file));
        scanner.useDelimiter(",");

        List<Integer> list = new ArrayList<Integer>();

        while (scanner.hasNextInt()) {
            list.add(scanner.nextInt());
        }


        Integer[] opcodes = new Integer[list.size()];
        scanner.close();
        return list.toArray(opcodes);
    }

    /**
     * This function returns Generated opcodes after performing operation on it.
     * @param opcodes
     * @return
     */
    private static Integer[] getModifiedOpcodes(Integer[] opcodes)
    {
        int step = 0;
        while(step < (opcodes.length - 1)){
            int firstOpcode = getValueAtPosition(opcodes, step);
            if (firstOpcode == 1) {
                opcodes = performAdditionOnInputs(opcodes, step);
            } else if (firstOpcode == 2) {
                opcodes = performMultiplicationOnInputs(opcodes, step);
            } else if (firstOpcode == 99) {
                break;
            }
            step = step + 4;
        }
        return opcodes;
    }

    /**
     * This function returns opcodes with new values at index 1 and 2.
     * @param opcodes
     * @param noun
     * @param verb
     * @return
     */
    private static Integer[] replaceValues(Integer[] opcodes, int noun, int verb)
    {
        opcodes[1] = noun;
        opcodes[2] = verb;
        return opcodes;
    }


    /**
     * This function performs Addition on the values  as an index from the opcodes and store it in the value at the index from the opcodes.
     * @param opcodes
     * @param startIndex
     * @return
     */
    private static Integer[] performAdditionOnInputs(Integer[] opcodes,  int startIndex)
    {
        opcodes[opcodes[startIndex + 3]] = opcodes[opcodes[startIndex + 1]] + opcodes[opcodes[startIndex + 2]];
        return opcodes;
    }

    /**
     * This function performs Addition on the values  as an index from the opcodes and store it in the value at the index from the opcodes.p;
     * @param opcodes
     * @param startIndex
     * @return
     */
    private static Integer[] performMultiplicationOnInputs(Integer[] opcodes,  int startIndex)
    {
        opcodes[opcodes[startIndex + 3]] = opcodes[opcodes[startIndex + 1]] * opcodes[opcodes[startIndex + 2]];
        return opcodes;
    }

    /**
     * This function returns value at a given position in the opcodes array
     * @param opcodes
     * @param position
     * @return
     */
    private static int getValueAtPosition(Integer[] opcodes, int position)
    {
        return opcodes[position];
    }
}