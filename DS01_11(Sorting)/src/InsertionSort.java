
public class InsertionSort {

	public InsertionSort()
	{
		
	}
	
	public void sort(int[] data, int dataSize)
	{
		int i, temp;
		for(i = 1; i < dataSize;i++){
			while(i>0 && data[i-1] > data[i]){
				temp = data[i];
				data[i] = data[i-1];
				data[i-1] = temp;
				i--;
			}
		}
	}

}
