
public class Main {

	public static void main(String[] args) throws IllegalAccessException {
		// TODO Auto-generated method stub
		LinearProbing linearHashTable = new LinearProbing();
		linearHashTable.putAll();
		
		QuadraticProbing quadraticHashTable = new QuadraticProbing();
		quadraticHashTable.putAll();
		
		DoubleHasing doubleHashTable = new DoubleHasing();
		doubleHashTable.putAll();
	}

}
