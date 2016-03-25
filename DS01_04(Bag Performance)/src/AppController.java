
public class AppController {
	private AppView _appView;
	private PerformanceMeasurement _pml;
	
	public AppController()
	{
		this._appView = new AppView();
	}
	
	public void run()
	{
		this._pml = new PerformanceMeasurement();
		this._appView.outputMessage(MessageID.Notice_StartProgram);
		this._pml.generateData();
		
		this._appView.outputMessage(MessageID.Notice_UnsortedArrayStart);
		this._pml.testUnsortedArrayBag();
		this.showAllOfTestResult();
		
		this._appView.outputMessage(MessageID.Notice_SortedArrayStart);
		this._pml.testSortedArrayBag();
		this.showAllOfTestResult();
		
		this._appView.outputMessage(MessageID.Notice_UnsortedLinkedStart);
		this._pml.testUnsortedLinkedBag();
		this.showAllOfTestResult();
		
		this._appView.outputMessage(MessageID.Notice_SortedLinkedStart);
		this._pml.testSortedLinkedBag();
		this.showAllOfTestResult();
		
		this._appView.outputMessage(MessageID.Notice_EndProgram);
	}
	
	private void showAllOfTestResult()
	{
		TestResult testResult[] = this._pml.testResult();
		for(int index = 0; index < this._pml.numOfTests(); index++) {
			this._appView.outputResult(testResult[index].testSize(), testResult[index].testInsertTime(), testResult[index].testFindMaxTime());

		}
	} 
}
