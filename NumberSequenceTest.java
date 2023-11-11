// NumberSequenceTest.java

/****************************************************************

NumberSequenceTest is a test program for the classes
ArrayNumberSequence and LinkedNumberSequence.

Author
Fadil Galjic

****************************************************************/

import static java.lang.System.out;

import java.util.Arrays;

class NumberSequenceTest
{
    public static void main (String[] args)
    {
		double[] realNumbers =
		    {8.0, 2.0, 16.0, 5.0, 1.0, 12.0, 4.0};
        NumberSequence sequence = null;
        // sequence = new ArrayNumberSequence(realNumbers);
        sequence = new LinkedNumberSequence(realNumbers);
        out.println("the sequence:");
        out.println(sequence);
        out.println();

        // add code here
        out.print("length:");
        out.println(sequence.length());
        
        out.print("one upper bound: ");
        out.println(sequence.upperBound());        
        
        out.print("one lower bound: ");
        out.println(sequence.lowerBound());
        out.println();
        
        out.print("number at position 3: ");
        out.println(sequence.numberAt(3));
        
        out.print("position of 8.0: ");
        out.println(sequence.positionOf(8.0));
        out.println();

        out.print("is increasing: ");
        out.println(sequence.isIncreasing());
        
        out.print("is decreasing: ");
        out.println(sequence.isDecreasing());

        out.print("contains 16.0: ");
        out.println(sequence.contains(16.0));
        out.println();

        out.println("add 32.0: ");
        sequence.add(32.0);
        out.println(sequence);

        out.println("insert 0.0 at position 7: ");
        sequence.insert(7, 0.0);
        out.println(sequence);
        
        out.println("remove at position 7: ");
        sequence.removeAt(7);
        out.println(sequence);
        out.println();

        out.println("corresponding array: ");
        out.println(Arrays.toString(sequence.asArray()).replace(",", "").replace("[", "").replace("]", ""));
        out.println();

    }
}