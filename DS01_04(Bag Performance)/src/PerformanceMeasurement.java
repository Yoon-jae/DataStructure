import java.util.Random;


public class PerformanceMeasurement {
	private static final int MaxTestSize = 10000;
	private static final int NumOfTests = 5;
	private static final int FirstTestSize = 1000;
	private static final int SizeIncrement = 1000;
	
	private int _maxTestSize;
	private int _numOfTests;
	private int _firstTestSize;
	private int _sizeIncrement;
	private int [] _data;
	private TestResult [] _testResult;
	
	public PerformanceMeasurement()
	{
		this._maxTestSize = MaxTestSize;
		this._numOfTests = NumOfTests;
		this._firstTestSize = PerformanceMeasurement.FirstTestSize;
		this._sizeIncrement = PerformanceMeasurement.SizeIncrement;
	
		this._data = new int[MaxTestSize];
		this._testResult = new TestResult[NumOfTests];
	}
	
	public PerformanceMeasurement(int aMaxTestSize, int aNumOfTests, int aFirstTestSize, int aSizeIncremnet)
	{
		this._maxTestSize = aMaxTestSize;
		this._numOfTests = aNumOfTests;
		this._firstTestSize = aFirstTestSize;
		this._sizeIncrement =aSizeIncremnet;
	
		this._data = new int[aMaxTestSize];
		this._testResult = new TestResult[aNumOfTests];
	}
	
	public int numOfTests()
	{
		return this._numOfTests;
	}
	
	public void generateData()
	{
		int i = 0;
		Random random = new Random();
		while(i < this._maxTestSize) {
			this._data[i] = random.nextInt(this._maxTestSize);
			i++;
		}
	}
	
	public TestResult[] testResult()
	{
		return this._testResult;
	}
	
	public void testUnsortedArrayBag()
	{
		UnsortedArrayBag bag;
		@SuppressWarnings("unused")
		Coin maxCoin;
		int testSize;
		long timeForAdd, timeForMax;
		long start, stop;
		int testDataCount;
		int testCount = 0;
		
		testSize = this._firstTestSize;
		while(testCount < this._numOfTests) {
			bag = new UnsortedArrayBag(testSize);
			testDataCount = 0;
			timeForAdd = 0;
			timeForMax = 0;
			while(testDataCount < testSize) {
				Coin coin = new Coin(this._data[testDataCount]);
				start = System.nanoTime();
				bag.add(coin);
				stop = System.nanoTime();
				timeForAdd += (stop - start);
				
				start = System.nanoTime();
				maxCoin = bag.maxElement();
				stop = System.nanoTime();
				timeForMax += (stop - start);
				testDataCount++;
			}
			this._testResult[testCount] = new TestResult(testSize, timeForAdd, timeForMax);
			testSize += this._sizeIncrement;
			testCount++;
		}
	}
	
	public void testSortedArrayBag()
	{
		SortedArrayBag bag;
		@SuppressWarnings("unused")
		Coin maxCoin;
		int testSize;
		long timeForAdd, timeForMax;
		long start, stop;
		int testDataCount;
		int testCount = 0;
		
		testSize = this._firstTestSize;
		while(testCount < this._numOfTests) {
			bag = new SortedArrayBag(testSize);
			testDataCount = 0;
			timeForAdd = 0;
			timeForMax = 0;
			while(testDataCount < testSize) {
				Coin coin = new Coin(this._data[testDataCount]);
				start = System.nanoTime();
				bag.add(coin);
				stop = System.nanoTime();
				timeForAdd += (stop - start);
				
				start = System.nanoTime();
				maxCoin = bag.maxElement();
				stop = System.nanoTime();
				timeForMax += (stop - start);
				testDataCount++;
			}
			this._testResult[testCount] = new TestResult(testSize, timeForAdd, timeForMax);
			testSize += this._sizeIncrement;
			testCount++;
		}
	}
	
	public void testUnsortedLinkedBag()
	{
		UnsortedLinkedBag bag;
		@SuppressWarnings("unused")
		Coin maxCoin;
		int testSize;
		long timeForAdd, timeForMax;
		long start, stop;
		int testDataCount;
		int testCount = 0;
		
		testSize = this._firstTestSize;
		while(testCount < this._numOfTests) {
			bag = new UnsortedLinkedBag(testSize);
			testDataCount = 0;
			timeForAdd = 0;
			timeForMax = 0;
			while(testDataCount < testSize) {
				Coin coin = new Coin(this._data[testDataCount]);
				start = System.nanoTime();
				bag.add(coin);
				stop = System.nanoTime();
				timeForAdd += (stop - start);
				
				start = System.nanoTime();
				maxCoin = bag.maxElement();
				stop = System.nanoTime();
				timeForMax += (stop - start);
				testDataCount++;
			}
			this._testResult[testCount] = new TestResult(testSize, timeForAdd, timeForMax);
			testSize += this._sizeIncrement;
			testCount++;
		}
	}
	
	public void testSortedLinkedBag()
	{
		SortedLinkedBag bag;
		@SuppressWarnings("unused")
		Coin maxCoin;
		int testSize;
		long timeForAdd, timeForMax;
		long start, stop;
		int testDataCount;
		int testCount = 0;
		
		testSize = this._firstTestSize;
		while(testCount < this._numOfTests) {
			bag = new SortedLinkedBag(testSize);
			testDataCount = 0;
			timeForAdd = 0;
			timeForMax = 0;
			while(testDataCount < testSize) {
				Coin coin = new Coin(this._data[testDataCount]);
				start = System.nanoTime();
				bag.add(coin);
				stop = System.nanoTime();
				timeForAdd += (stop - start);
				
				start = System.nanoTime();
				maxCoin = bag.maxElement();
				stop = System.nanoTime();
				timeForMax += (stop - start);
				testDataCount++;
			}
			this._testResult[testCount] = new TestResult(testSize, timeForAdd, timeForMax);
			testSize += this._sizeIncrement;
			testCount++;
		}
	}
}
