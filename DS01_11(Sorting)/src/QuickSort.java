
public class QuickSort {

	public QuickSort()
	{
		
	}
	
	public void sort(int[] data, int dataSize)
	{
		this.quickSort(data, 0, dataSize - 1);
	}
	
	private void quickSort(int data[], int left, int right) {
		int pivot, low, high;
		low = left;
		high = right;
		pivot = data[left];
		while (left < right) {
			while ((data[right] >= pivot) && (left < right))
				right--;
			if (left != right) {
				data[left] = data[right];
				left++;
			}
			while ((data[left] <= pivot) && (left < right))
				left++;
			if (left != right) {
				data[right] = data[left];
				right--;
			}
		}
		data[left] = pivot;
		pivot = left;
		left = low;
		right = high;
		if (left < pivot)
			quickSort(data, left, pivot - 1);
		if (right > pivot)
			quickSort(data, pivot + 1, right);
	}

}
