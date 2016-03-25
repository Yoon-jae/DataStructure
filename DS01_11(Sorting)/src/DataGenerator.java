import java.util.Random;


public class DataGenerator {
	
	private static final int DEFAULT_MAX_SIZE = 5000;
	private int[] _dataArray;
	private int _dataSize;
	
	public DataGenerator()
	{
		this._dataArray = new int[DataGenerator.DEFAULT_MAX_SIZE];
		this._dataSize = 0;
	}
	
	public void generateSequentialData(int size)
	{
		this._dataArray = new int[size+1];
		this._dataArray[0] = -1;
		this._dataSize = size;
		for(int i = 1; i <= size; i++) {
			this._dataArray[i] = i;
		}
	}
	
	public void generateReverseData(int size)
	{
		this._dataArray = new int[size+1];
		this._dataArray[0] = -1;
		this._dataSize = size;
		for(int i = 1; i <= size; i++) {
			this._dataArray[i] = size - i;
		}
	}
	
	public void generateRandomData(int size)
	{
		Random random = new Random();
		this._dataArray = new int[size+1];
		this._dataArray[0] = -1;
		this._dataSize = size;
		for(int i = 1; i <= size; i++) {
			this._dataArray[i] = random.nextInt(size);
		}
	}
	
	public int[] getData(int size)
	{
		int[] copyArray = new int[size+1];
		for(int i = 1; i <= size; i++) {
			copyArray[i] = this._dataArray[i];
		}
		return copyArray;
	}
}
