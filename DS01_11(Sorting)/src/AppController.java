
public class AppController {

	private AppView _appView;
	private int [] _data;
	private DataGenerator _dataGenerator;
	private PerformanceMeasurement _pmMeasurement;
	private double _insertionSortDuration;
	private double _selectionSortDuration;
	private double _quickSortDuration;
	private double _bubbleSortDuration;

	private int _sortType;
	private int _maxDataSize;
	private int _dataTerm;
	
	public AppController()
	{
		this._appView = new AppView();
		this._dataGenerator = new DataGenerator();
		this._pmMeasurement = new PerformanceMeasurement();
	}
	
	public void run()
	{
		this._appView.outputMessage(MessageID.Notice_StartProgram);
		this._sortType = 0;
		
		this._maxDataSize = this._appView.inputMaxDataSize();
		this._dataTerm = this._appView.inputDataTerm();
		
		while(this._sortType != 4) {
			this._appView.outputMessage(MessageID.Notice_Menu);
			this._sortType = this._appView.inputSortType();
			
			if(this._sortType == 1) {
				this._dataGenerator.generateSequentialData(this._maxDataSize);
				this._appView.outputMessage(MessageID.Notice_SequentialData);
			}
			else if(this._sortType == 2) {
				this._dataGenerator.generateReverseData(this._maxDataSize);
				this._appView.outputMessage(MessageID.Notice_ReverseData);
			}
			else if(this._sortType == 3) {
				this._dataGenerator.generateRandomData(this._maxDataSize);
				this._appView.outputMessage(MessageID.Notice_RandomData);
			}
			else if(this._sortType == 4) {
				break;
			} 
			else {
				this._appView.outputMessage(MessageID.Error_WrongMenu);
				continue;
			}
			
			this._appView.outputMessage(MessageID.Notice_ShowTitle);
			
			// 메모리 생성 및 테스트의 안정성을 위하여 가장 첫 성능 측정을 미리 한번 진행한다.
			this.doTest(this._dataTerm);
			
			// 실제 테스트 진행
			for(int dataSize = this._dataTerm; dataSize <= this._maxDataSize; dataSize += this._dataTerm) {
				this.doTest(dataSize);
				this._appView.outputResult(dataSize, this._insertionSortDuration, this._quickSortDuration, this._selectionSortDuration, this._bubbleSortDuration);
			}
		}
		this._appView.outputMessage(MessageID.Notice_EndProgram);
	}
	
	private void doTest(int dataSize)
	{
		this._insertionSortDuration = 0;
		this._selectionSortDuration = 0;
		this._quickSortDuration = 0;
		this._bubbleSortDuration = 0;
		
		for(int index = 0; index < this._maxDataSize; index++) {
			this._data = this._dataGenerator.getData(dataSize);
			this._insertionSortDuration += this._pmMeasurement.testInsertionSort(this._data, dataSize);
		}
		this._insertionSortDuration = this._insertionSortDuration / this._maxDataSize;
		
		for(int index = 0; index < this._maxDataSize; index++) {
			this._data = this._dataGenerator.getData(dataSize);
			this._selectionSortDuration += this._pmMeasurement.testSelectionSort(this._data, dataSize);
		}
		this._selectionSortDuration = this._selectionSortDuration / this._maxDataSize;
		
		for(int index = 0; index < this._maxDataSize; index++) {
			this._data = this._dataGenerator.getData(dataSize);
			this._quickSortDuration += this._pmMeasurement.testQuickSort(this._data, dataSize);
		}
		this._quickSortDuration = this._quickSortDuration / this._maxDataSize;
		
		for(int index = 0; index < this._maxDataSize; index++) {
			this._data = this._dataGenerator.getData(dataSize);
			this._bubbleSortDuration += this._pmMeasurement.testBubbleSort(this._data, dataSize);
		}
		this._bubbleSortDuration = this._bubbleSortDuration / this._maxDataSize;		
	}

}
