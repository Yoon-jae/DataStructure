
public class AppController {
	private AppView _appView;
//	private SortedArrayList _sortedList;
	private SortedLinkedList _sortedList;
	
	public AppController()
	{
		this._appView = new AppView();
	}
	
	public void run()
	{
//		this._sortedList = new SortedArrayList<Integer>();
		this._sortedList = new SortedLinkedList<Integer>();
		char command = 0;
		int input;
		
		this._appView.outputMessage(MessageID.Notice_StartProgram);
		while(command != '!') {
			command = this._appView.inputCharacter();
			if(command == '%') {
				input = this._appView.inputNumber();
				this.add(input);
			} 
			else if(command == '~')
				this.reset();
			else if(command == '-')
				this.removeMin();
			else if(command == '+')
				this.removeMax();
			else if(command == '#')
				this.showSize();
			else if(command == '?') {
				input = this._appView.inputNumber();
				this.removeFrom(input);
			} 
			else if(command == '/')
				this.showAll();
			else if(command == '!') 
				break;
			else
				this._appView.outputMessage(MessageID.Error_WrongMenu);
		}
		this._appView.outputMessage(MessageID.Notice_EndProgram);
	}
	
	public void showSize()
	{
		this._appView.outputSize(this._sortedList.size());
	}
	
	public void reset()
	{
		this._sortedList.clear();
		this._appView.outputMessage(MessageID.Notice_Reset);
	}
	
	public void showAll()
	{
		this._appView.outputMessage(MessageID.Notice_ShowStartList);
//		SortedArrayList<Integer>.ListIterator<Integer> iterator = this._sortedList.listIterator();
		SortedLinkedList<Integer>.ListIterator<Integer> iterator = this._sortedList.listIterator();
		while(iterator.hasNext()) {
			this._appView.outputElement((int) iterator.next());
		}
		this._appView.outputMessage(MessageID.Notice_ShowEndList);

	}
	
	public void add(int inputValue)
	{
		boolean append = this._sortedList.add(inputValue);
		if(append) {
			this._appView.outputAdd(inputValue);
		} else {
			this._appView.outputMessage(MessageID.Error_InputFull);
		}
	}
	
	public void removeMin()
	{
		Integer temp =(Integer)this._sortedList.removeMin();
		if(temp != null)
			this._appView.outputRemove(temp);
		else
			this._appView.outputMessage(MessageID.Error_Empty);
	}
	
	public void removeMax()
	{
		Integer temp =(Integer)this._sortedList.removeMax();
		if(temp != null)
			this._appView.outputRemove(temp);
		else
			this._appView.outputMessage(MessageID.Error_Empty);
	}
	
	public void removeFrom(int aPosition)
	{
		Integer temp = (Integer) this._sortedList.removeFrom(aPosition);
		if(temp != null)
			this._appView.outputRemove(temp);
		else
			this._appView.outputMessage(MessageID.Error_Empty);
	}
	
}
