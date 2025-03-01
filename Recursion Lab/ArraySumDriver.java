package lab4;

public class ArraySumDriver {
	private final static int ARRAY_SIZE = 6;
	private final static int ARRAY_SIZE2 = 9;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int index = 0;

		Integer[] myArray = new Integer[ARRAY_SIZE];
		ArraySum arraySum = new ArraySum();
		
		myArray[index++] = 3;
		myArray[index++] = 5;
		myArray[index++] = 2;
		myArray[index++] = 6;
		
		int sum = arraySum.sumOfArray(myArray, 3);
		System.out.println(sum);
		
		myArray[index++] = 7;
		myArray[index++] = 1;
		
		sum = arraySum.sumOfArray(myArray, 5);
		System.out.println(sum);
		
		index = 0;
		Integer[] myArray2 = new Integer[ARRAY_SIZE2];
		myArray2[index++] = 10;
		myArray2[index++] = 3;
		myArray2[index++] = 19;
		myArray2[index++] = 5;
		myArray2[index++] = 6;
		myArray2[index++] = 7;
		myArray2[index++] = 21;


		// should print 71
		sum = arraySum.sumOfArray(myArray2, 6);
		System.out.println(sum);
	}

}