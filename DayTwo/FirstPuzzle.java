/**
 *This is the Code in Java as a solution to first puzzle of Advent of Code 2019
 *'What value is left at position 0 after the program halts?'
 *
 *
 *
 */

import java.io.IOException;
import java.util.*;
import java.io.File;
import java.lang.Integer;

public class FirstPuzzle  {

    public static void main(String[] args) throws IOException
    {

        Integer[] opcodes = getOpcodeInputs();
        opcodes = replaceValues(opcodes, 12, 2);

        opcodes = getModifiedOpcodes(opcodes);

       System.out.print("The Value left at position 0 is " + getValueAtPosition(opcodes, 0) + "\n");
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