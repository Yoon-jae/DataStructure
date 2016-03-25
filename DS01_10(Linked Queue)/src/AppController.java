
public class AppController {
	private AppView _appView;
	private LinkedQueue<Character> _linkedQueue;
	private int _inputChars;
	private int _ignoredChars;
	private int _addedChars;
	
	public AppController()
	{
		this._appView = new AppView();
	}
	
	public void run()
	{
		this._linkedQueue = new LinkedQueue<Character>();
		
		char input;
		
		this._appView.outputMessage(MessageID.Notice_StartProgram);
		this._appView.outputMessage(MessageID.Notice_StartMenu);
		input = this._appView.inputCharacter();
		while(input != '!') {
			this.countInputChar();
			if(('A' <= input && input <= 'Z') || ('a' <= input && input <= 'z')) {
				this.add(input);
			} else if('0' <= input && input <= '9') {
				this.removeN(Integer.parseInt(String.valueOf(input)));
			} else if(input == '-') {
				this.removeOne();
			} else if(input == '#') {
				this.showQueueSize();
			} else if(input == '/') {
				this.showAll();
			} else if(input == '^') {
				this.showFrontElement();
			} else {
				this._appView.outputMessage(MessageID.Error_WrongMenu);
				this.countIgnored();
			}
			input = this._appView.inputCharacter();
		}
		this._appView.outputMessage(MessageID.Notice_EndMenu);
		this.conclusion();
		this._appView.outputMessage(MessageID.Notice_EndProgram);
	}
	
	public void showFrontElement()
	{
		if(this._linkedQueue.isEmpty()) {
			this._appView.outputMessage(MessageID.Error_Empty);
		} else {
			this._appView.outputFrontElement((char)this._linkedQueue.frontElement());
		}
	}
	
	public void showQueueSize()
	{
		this._appView.outputQueueSize(this._linkedQueue.size());
	}
	
	public void showAll()
	{
		this._appView.outputMessage(MessageID.Show_QueueStart);
		for(int i = 0; i < this._linkedQueue.size(); i++) {
			this._appView.outputElement((char)this._linkedQueue.elementAt(i));
		}
		this._appView.outputMessage(MessageID.Show_QueueEnd);
	}
	
	public void initCharCounts()
	{
		this._inputChars = 0;
		this._addedChars = 0;
		this._ignoredChars = 0;
	}
	
	public void countAdded()
	{
		this._addedChars++;
	}
	
	public void countIgnored()
	{
		this._ignoredChars++;
	}
	
	public void countInputChar()
	{
		this._inputChars++;
	}
	
	public void add(char c)
	{
		if(this._linkedQueue.isFull()) {
			this._appView.outputMessage(MessageID.Error_InputFull);
		} else {
			this._linkedQueue.enQueue(c);
			this._appView.outputAdd(c);
			
		}
	}
	
	public void removeOne()
	{
		if(this._linkedQueue.isEmpty()) {
			this._appView.outputMessage(MessageID.Error_Empty);
		} else {
			this._appView.outputRemove((char)this._linkedQueue.deQueue());
		}
	}
	
	public void removeN(int numOfCharsToBeDeleted)
	{
		this._appView.outputRemoveN(numOfCharsToBeDeleted);
		for(int i = 0; i < numOfCharsToBeDeleted; i++) {
			if(this._linkedQueue.isEmpty()) {
				this._appView.outputMessage(MessageID.Error_Empty);
				break;
			} else {
				this.removeOne();
			}
		}
	}
	
	public void conclusion()
	{
		this.removeN(this._linkedQueue.size());
		this._appView.outputResult(this._inputChars, this._ignoredChars, this._addedChars);
	}
}
