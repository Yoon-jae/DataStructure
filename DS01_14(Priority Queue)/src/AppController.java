
public class AppController {
	private AppView _appView;
	HeapPriorityQueue<Integer> _priorityQueue;
//	SortedArrayPriorityQueue<Integer> _priorityQueue;
//	SortedLinkedPriorityQueue<Integer> _priorityQueue;
	
	public AppController()
	{
		this._appView = new AppView();
	}
	
	public void run()
	{
		this._priorityQueue = new HeapPriorityQueue<Integer>();
//		this._priorityQueue = new SortedArrayPriorityQueue<Integer>();
//		this._priorityQueue = new SortedLinkedPriorityQueue<Integer>();
		

		char command = 0;
		int input;
		
		this._appView.outputMessage(MessageID.Notice_StartProgram);
		while(command != 'q') {
			command = this._appView.inputCharacter();
			if(command == 'i') {
				input = this._appView.inputNumber();
				this.add(input); // ����
			} 
			else if(command == 'm')
				this.showMax(); // �ִ밪�� ���
			else if(command == 'd')
				this.removeMax(); // �ִ밪�� ����
			else if(command == 'v')
				this.showAll(); // ť�� ������ ������
			else if(command == 'x')
				this.removeAndShow(); // ���Ҹ� ���ʷ� �����ϸ鼭 ���
			else if(command == 'r') {
				this.randomAdd(); // ������ 10�� �����Ͽ� ����
			}			
			else if(command == 'n')
				this.showSize(); // ť ������ ������ ���
			else if(command == 'q')
				break;
			else
				this._appView.outputMessage(MessageID.Error_WrongMenu);
		}
		this._appView.outputMessage(MessageID.Notice_EndProgram);
	}
	
	public void add(int inputValue)
	{
		boolean error;
		error = this._priorityQueue.add(inputValue);
		if(error == false)
			this._appView.outputMessage(MessageID.Error_InputFull);
		else
			this._appView.outputAdd(inputValue);
		
	}
	
	public void showMax()
	{
		Integer removeOk = (Integer)this._priorityQueue.max();
		if(removeOk == null)
			this._appView.outputMessage(MessageID.Error_Empty);
		else
			this._appView.outputMax(removeOk);
	}
	
	public void removeMax()
	{
		Integer removeOk = (Integer) this._priorityQueue.removeMax();
		if(removeOk == null)
			this._appView.outputMessage(MessageID.Error_Empty);
		else
			this._appView.outputRemoveMax(removeOk);
	}
	
	public void showAll()
	{
		if(this._priorityQueue.isEmpty()) {
			this._appView.outputMessage(MessageID.Error_Empty);
		} else {
			this._appView.outputMessage(MessageID.Notice_ShowStart);
			HeapPriorityQueue<Integer>.PriorityQueueIterator<Integer> iterator = this._priorityQueue.priorityQueueIterator();
//			SortedArrayPriorityQueue<Integer>.PriorityQueueIterator<Integer> iterator = this._priorityQueue.priorityQueueIterator();
//			SortedLinkedPriorityQueue<Integer>.PriorityQueueIterator<Integer> iterator = this._priorityQueue.priorityQueueIterator();

			while(iterator.hasNext()) {
				this._appView.outputElement((Comparable) iterator.next());
			}
			this._appView.outputMessage(MessageID.Notice_ShowEnd);
		}
	}
	
	public void removeAndShow()
	{
		if(this._priorityQueue.isEmpty()){
			this._appView.outputMessage(MessageID.Error_Empty);
		}
		else {
			this._appView.outputMessage(MessageID.Notice_StartRemoveAll);
			for (int i = _priorityQueue.size(); i > 0; i--) {
				this._appView.outputElement(this._priorityQueue.removeMax());
			}
			System.out.println("");
			this._appView.outputMessage(MessageID.Notice_EndRemoveAll);
		}	
	}
	
	public void randomAdd()
	{
		for (int i = 0; i < 10; i++) {
			Integer n = (int) (Math.random() * 100);
			if (this._priorityQueue.add(n)) 
				this._appView.outputAdd(n);
			else 
				this._appView.outputMessage(MessageID.Error_InputFull);
		}
		this._appView.outputMessage(MessageID.Notice_RandomAdd);
	}
	
	public void showSize()
	{
		this._appView.outputSize(this._priorityQueue.size());
	}
}
