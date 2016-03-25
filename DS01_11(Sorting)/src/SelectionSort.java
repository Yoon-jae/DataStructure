
public class SelectionSort {

	public SelectionSort()
	{
		
	}
	
	public void sort(int[] data, int dataSize)
	{
		selectionSort(data, 0, dataSize);
	}

	private void selectionSort(int[] array, int startIndex, int size) {
		if (startIndex >= size - 1)
			return;
		int minIndex = startIndex;
		for (int index = startIndex + 1; index < size; index++) {
			if (array[index] < array[minIndex])
				minIndex = index;
		}

		SWAP(array[startIndex], array[minIndex]);
		selectionSort(array, startIndex + 1, size);

	}
	
	private void SWAP(int x, int y) {
		int temp;
		temp = x;
		x = y;
		y = temp;
	}
}
