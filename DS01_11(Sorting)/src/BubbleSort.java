
public class BubbleSort {

	public BubbleSort()
	{
		
	}
	
	public void sort(int[] data, int dataSize)
	{
		for (int i = 1; i < dataSize; i++)
			for (int j = 1; j < dataSize - i - 1; j++)
				if (data[j] > data[j + 1])
					SWAP(data[j], data[j + 1]);
	}

	private void SWAP(int x, int y) {
		int temp;
		temp = x;
		x = y;
		y = temp;
	}
}
