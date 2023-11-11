// LinkedNumberSequence.java

/****************************************************************
 * 
 * LinkedNumberSequence represents a sequence of real numbers.
 * Such a sequence is defined by the interface NumberSequence.
 * The class uses linked nodes to store the numbers in the sequence.
 * 
 * Author
 * Fadil Galjic
 * 
 ****************************************************************/

public class LinkedNumberSequence implements NumberSequence {
	private class Node {
		public double number;
		public Node next;

		public Node(double number) {
			this.number = number;
			next = null;
		}
	}

	// the first node in the node-sequence
	private Node first;

	// create the sequence
	public LinkedNumberSequence(double[] numbers) {
		if (numbers.length < 2)
			throw new IllegalArgumentException("not a sequence");

		first = new Node(numbers[0]);
		Node n = first;
		for (int i = 1; i < numbers.length; i++) {
			n.next = new Node(numbers[i]);
			n = n.next;
		}
	}

	// toString returns the character string representing this
	// sequence
	public String toString() {
		String s = "";
		Node n = first;
		while (n.next != null) {
			s = s + n.number + ", ";
			n = n.next;
		}
		s = s + n.number;

		return s;
	}

	// add code here
	public int length(){
		int numberOfElements = 0;
		Node node = this.first;
		while (node != null){
			numberOfElements++;
			node = node.next;
		}
		return numberOfElements;
	}

	public double upperBound(){
		double upBound = this.first.number;
		Node node = first.next;
		for(int i = 1; i < length(); i++){			
			if(upBound < node.number){
				upBound = node.number;
			}
			node = node.next;
		}
		return upBound;
	}

	public double lowerBound(){
		double lowBound = this.first.number;
		Node node = first.next;
		for(int i = 1; i < length(); i++){			
			if(lowBound > node.number){
				lowBound = node.number;
			}
			node = node.next;
		}
		return lowBound;
	}

	public double numberAt(int position){
		if(this.length() < position){
			throw new IndexOutOfBoundsException();
		}
		else{
			Node node = this.first;
			for(int i = 0; i < position; i++){
				node = node.next;
			}
			return node.number;
		}
	}

	public int positionOf(double number){
		Node node = this.first;
		int position = -1;
		for(int i = 0; i <length(); i++){
			if(node.number == number){
				position = i;
				break;
			}
			node = node.next;
		}
		return position;
	}

	public boolean isIncreasing(){
		boolean increasing = true;
		double number = this.first.number;
		Node node = this.first.next;
		for(int i = 0; i < length(); i++){
			if(number > node.number){
				increasing = false;
				break;
			}
			number = node.number;
			node = node.next;
		}
		return increasing;
	}

	public boolean isDecreasing(){
		boolean decreasing = true;
		double number = this.first.number;
		Node node = this.first.next;
		for(int i = 0; i < length(); i++){
			if(number < node.number){
				decreasing = false;
				break;
			}
			number = node.number;
			node = node.next;
		}
		return decreasing;
	}

	public boolean contains(double number){
		Node node = this.first;
		boolean exist = false;
		for(int i = 0; i < length(); i++){
			if(node.number == number){
				exist = true;
				break;
			}
			node = node.next;
		}
		return exist;
	}

	public void add(double number){
		Node newNode = new Node(number);
		Node node = this.first;
		while(node.next != null){
			node = node.next;
		}
		node.next = newNode;
	}

	public void insert(int position, double number){
		if(length() < position){
			throw new IndexOutOfBoundsException();
		}
		Node node = this.first;
		Node newNode = new Node(number);
		int indx = 0 ;
		while(indx < position - 1){
			node = node.next;
			indx++;
		}
		newNode.next = node.next;
		node.next = newNode;
	}

	public void removeAt(int position){
		if(length() < position){
			throw new IndexOutOfBoundsException();
		}
		else if(length() <= 2){
			throw new IllegalStateException();
		}
		Node node = this.first;
		int indx = 1;
		while(indx < position){
			node = node.next;
			indx++;
		}
		if(position != length()){
		node.next = node.next.next;
		}
		else{
			node.next = null;
		}
	}

	public double[] asArray(){
		double[] arr = new double[length()];
		Node node = this.first;
		for(int i = 0; i < length(); i++){
			arr[i] = node.number;
			node = node.next;
		}
		return arr;
	}
}