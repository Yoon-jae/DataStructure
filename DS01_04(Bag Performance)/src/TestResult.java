
public class TestResult {
	private int _testSize;
	private long _testInsertTime;
	private long _testFindMaxTime;
	
	public TestResult()
	{
		this._testSize = 0;
		this._testInsertTime = 0;
		this._testFindMaxTime = 0;
	}
	
	public TestResult(int aTestSize, long aTestInsertTime, long aTestFindMaxTime)
	{
		this._testSize = aTestSize;
		this._testInsertTime = aTestInsertTime;
		this._testFindMaxTime = aTestFindMaxTime;
	}

	public int testSize() {
		return this._testSize;
	}

	public void set_testSize(int aTestSize) {
		this._testSize = aTestSize;
	}

	public long testInsertTime() {
		return this._testInsertTime;
	}

	public void setTestInsertTime(long aTestInsertTime) {
		this._testInsertTime = aTestInsertTime;
	}

	public long testFindMaxTime() {
		return this._testFindMaxTime;
	}

	public void setTestFindMaxTime(long aTestFindMaxTime) {
		this._testFindMaxTime = aTestFindMaxTime;
	}
	
	
}
