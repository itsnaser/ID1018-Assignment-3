// ArrayNumberSequence.java

/****************************************************************
 * 
 * ArrayNumberSequence represents a sequence of real numbers.
 * Such a sequence is defined by the interface NumberSequence.
 * The class uses an array to store the numbers in the sequence.
 * 
 * Author
 * Fadil Galjic
 * 
 ****************************************************************/

public class ArrayNumberSequence implements NumberSequence {
	// numbers in the sequence
	private double[] numbers;

	// create the sequence
	public ArrayNumberSequence(double[] numbers) {
		if (numbers.length < 2)
			throw new IllegalArgumentException("not a sequence");

		this.numbers = new double[numbers.length];
		for (int i = 0; i < numbers.length; i++)
			this.numbers[i] = numbers[i];
	}

	// toString returns the character string representing this
	// sequence
	public String toString() {
		String s = "";
		for (int i = 0; i < numbers.length - 1; i++)
			s = s + numbers[i] + ", ";
		s = s + numbers[numbers.length - 1];

		return s;
	}

	// add code here
	public int length() {
		return numbers.length;
	}

	public double upperBound() {
		double upperBound = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] > upperBound)
				upperBound = numbers[i];
		}
		return upperBound;
	}

	public double lowerBound() {
		double lowerBound = numbers[0];
		for (int i = 1; i < numbers.length - 1; i++) {
			if (numbers[i] < lowerBound)
				lowerBound = numbers[i];
		}
		return lowerBound;
	}

	public double numberAt(int position) {
		try {
			return numbers[position];
		} catch (IndexOutOfBoundsException e) {
			throw e;
		}
	}

	public int positionOf(double number) {
		int indx = -1;
		for (int i = 0; i < numbers.length - 1; i++) {
			if (number == numbers[i]) {
				indx = i;
			}
		}
		return indx;
	}

	public boolean isIncreasing() {
		boolean isIncreasing = true;
		for (int i = 1; i < numbers.length - 1; i++) {
			if (numbers[i] < numbers[i - 1]) {
				isIncreasing = false;
				break;
			}
		}
		return isIncreasing;
	}

	public boolean isDecreasing() {
		boolean isIncreasing = true;
		for (int i = 1; i < numbers.length - 1; i++) {
			if (numbers[i] > numbers[i - 1]) {
				isIncreasing = false;
				break;
			}
		}
		return isIncreasing;
	}

	public boolean contains(double number) {
		boolean exist = false;
		for (int i = 0; i < numbers.length - 1; i++) {
			if (number == numbers[i]) {
				exist = true;
				break;
			}
		}
		return exist;
	}

	public void add(double number) {
		double[] temp = numbers;
		numbers = new double[numbers.length + 1];
		for(int i = 0; i < numbers.length - 1; i++){
			numbers[i] = temp[i];
		}
		numbers[temp.length] = number;
	}

	public void insert(int position, double number) {
		if(position > numbers.length){
			throw new IndexOutOfBoundsException();
		}
		double[] temp = numbers;
		numbers = new double[numbers.length + 1];
		for(int i = 0, k = 0; i < numbers.length; i++){
			if(i == position){
				numbers[i] = number;
			}
			else{
				numbers[i] = temp[k++];
			}
		}
	}

	public void removeAt(int position) {
		if (position > numbers.length - 1) {
			throw new IndexOutOfBoundsException();
		} else if (numbers.length <= 2) {
			throw new IndexOutOfBoundsException();
		}
		double[] temp = numbers;
		numbers = new double[numbers.length - 1];
		for (int i = 0, k = 0; i < numbers.length + 1; i++) {
			if (i != position) {
				numbers[k] = temp[i];
				k++;
			}
		}

	}

	public double[] asArray() {
		double[] newArr = new double[numbers.length];
		for(int i = 0; i < numbers.length; i++){
			newArr[i] = numbers[i];
		}
		return newArr;
	}
}