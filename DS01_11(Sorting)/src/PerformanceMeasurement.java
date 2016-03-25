
public class PerformanceMeasurement {
	private static final int DURATION_CHECKING = 5000;
	private InsertionSort _insertionSort;
	private QuickSort _quickSort;
	private SelectionSort _selectionSort;
	private BubbleSort _bubbleSort;
	
	private double _beforeTime;
	private int _beforeDataSize;
	
	public PerformanceMeasurement()
	{
		this._insertionSort = new InsertionSort();
		this._quickSort = new QuickSort();
		this._selectionSort = new SelectionSort();
		this._bubbleSort = new BubbleSort();
		
		this._beforeTime = 0;
		this._beforeDataSize = 0;
	}
	
	public double testInsertionSort(int [] data, int dataSize)
	{
		double insertTime = 0;
		long start, end;
		
		start = System.nanoTime();
		this._insertionSort.sort(data, dataSize);
		end = System.nanoTime();
		insertTime = (double)(end - start);
		
		return insertTime;
	}
	
	public double testQuickSort(int [] data, int dataSize)
	{
		double quickTime = 0;
		long start, end;
		
		start = System.nanoTime();
		this._quickSort.sort(data, dataSize);
		end = System.nanoTime();
		quickTime = (double)(end - start);
		
		return quickTime;
	}
	
	public double testSelectionSort(int [] data, int dataSize)
	{
		double selectTime = 0;
		long start, end;
		
		start = System.nanoTime();
		this._selectionSort.sort(data, dataSize);
		end = System.nanoTime();
		selectTime = (double)(end - start);
		
		return selectTime;
	}
	
	public double testBubbleSort(int [] data, int dataSize)
	{
		double bubbleTime = 0;
		long start, end;
		
		start = System.nanoTime();
		this._bubbleSort.sort(data, dataSize);
		end = System.nanoTime();
		bubbleTime = (double)(end - start);
		
		return bubbleTime;
	}
}
