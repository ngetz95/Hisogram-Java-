// Class: HistogramApp
//
// Author:  Your Name
//
// Created on 8 January, 2009
// Modifications:
//    Date        Name            Reason
//    ----        ----            ------
//    8 Jan 2009  Kelly & Alyce  Created original version
//    9 Jan 2009  Your Name      What did you change?
//
// License Information:
//   This class is free software; you can redistribute it and/or modify
//   it under the terms of the GNU General Public License as published by
//   the Free Software Foundation.
//
//   This class is distributed in the hope that it will be useful,
//   but WITHOUT ANY WARRANTY; without even the implied warranty of
//   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//   GNU General Public License for more details.

import java.awt.Color;

import edu.kzoo.grid.Location;
import edu.kzoo.grid.ColorBlock;
import edu.kzoo.grid.PictureBlock;
import edu.kzoo.grid.TextCell;
import java.util.Random;
import java.util.ArrayList;

/**
 *  Histogram Project:<br>
 *
 * The HistogramLab class (does what?)
 * <br> <br>
 * Created: <br>
 *   4 Jan 2003,  Alyce Brady<br>
 * <br>
 * Modifications: <br>
 *   1 Jan 2004,  Kelly Schultz, Changed to use DisplayableTable<br>
 *   9 Apr 2009,  Kelly Schultz, changed to use SimpleGrid<br>
 *   (date), (your name), Modified to .... <br>
 * 
 * @author (your name) (with assistance from)
 * @version (a version number or a date)
 */
public class HistogramLab
{
    // Specify how many times to run the experiment whose results
    // will be plotted in the histogram.
    private static final int NUM_ITERATIONS = 1000;

    /**
     *  Start the Histogram program.
     *  The String arguments (args) are not used in this application.
     **/

    public static void main(String[] args)
    {
        System.out.println("This will be a program that draws a histogram.");

        // For each run of the experiment, start at location 0.
        // Flip the coin 6 times, moving right on heads and left
        // on tails.  After 6 flips, print the final
        // location of the coin.

        //ColorBlock redBlock = new ColorBlock(Color.RED);
        int coin;
        ArrayList<Integer> counts = new ArrayList<Integer>();
        counts.add(new Integer(0));
        counts.add(new Integer(0));
        counts.add(new Integer(0));
        counts.add(new Integer(0));
        counts.add(new Integer(0));
        counts.add(new Integer(0));
        counts.add(new Integer(0));
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        int e = 0;
        int f = 0;
        int g = 0;
        
        int numIterations = ValidatedInputReader.getInteger("Enter the desired number of iterations", 1000, "");
        Coin myCoin = new Coin();
        for(int j = 1; j <= NUM_ITERATIONS; j++)
        {
            //grid.remove(redBlock, 0, 6 + l);
            int l = 0;
            for(int i = 1; i <= 6; i++)
            {
                myCoin.toss();
                if(myCoin.heads())
                {
                    l++;
                }
                else
                {
                    l--;
                }
            }
            int index = (l/2) +3;
            int counter = counts.get(index) + 1;
            counts.set(index, counter);
        }

        System.out.println("Iterations used: " + NUM_ITERATIONS);
        System.out.println("-6: " + counts.get(0));
        System.out.println("-4: " + counts.get(1));
        System.out.println("-2: " + counts.get(2));
        System.out.println("0: " + counts.get(3));
        System.out.println("2: " + counts.get(4));
        System.out.println("4: " + counts.get(5));
        System.out.println("6: " + counts.get(6));

        //         // Create and initialize the grid.
        SimpleGrid grid = new SimpleGrid(8, NUM_ITERATIONS);
        // 
        //         // Create graphical user interface capable of displaying
        //         // the grid.
        SimpleGridObjectGUI display = new SimpleGridObjectGUI(grid,
                "John Doe", "Kelly Schultz",
                "14 April 2009");
        // 
        // 
        //         // Place a label on each row

        TextCell label1 = new TextCell("-6");
        grid.add(label1, 0, 0);

        TextCell label3 = new TextCell("-4");
        grid.add(label3, 1, 0);

        TextCell label5 = new TextCell("-2");
        grid.add(label5, 2, 0);

        TextCell label7 = new TextCell("0");
        grid.add(label7, 3, 0);

        TextCell label9 = new TextCell("2");
        grid.add(label9, 4, 0);

        TextCell label11 = new TextCell("4");
        grid.add(label11, 5, 0);

        TextCell label13 = new TextCell("6");
        grid.add(label13, 6, 0);

        // 
        //         // Create a color block to place in the grid (MOVED)

        //         
        //         // Place a block for each final location landing on that row

        for(int j = 0; j < 6; j++)
        {
            for(int i = 0; i < counts.get(j); i++)
            {
                ColorBlock redBlock = new ColorBlock(Color.RED);
                grid.add(redBlock, j, i + 1);
            }
        }

        //         
        //         //Display the grid when done
        display.showGrid();

        System.out.println("Done.");
    }

}
