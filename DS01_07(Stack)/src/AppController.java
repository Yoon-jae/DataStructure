
public class AppController {
	
	private AppView _appView;
	@SuppressWarnings("rawtypes")
	private ArrayList _arrayStack;
	private int _inputChars;
	private int _ignoredChars;
	private int _addedChars;
	
	public AppController()
	{
		this._appView = new AppView();
		this._inputChars = 0;
		this._ignoredChars = 0;
		this._addedChars = 0;
	}
	
	public void run()
	{
		this._arrayStack = new ArrayList<Character>();
		char input;
		this._appView.outputMessage(MessageID.Notice_StartProgram);
		this._appView.outputMessage(MessageID.Notice_StartMenu);
		input = this._appView.inputCharacter();
		while(input != '!') {
			this.countInputChar();
			if(('A' <= input && input <= 'Z') || ('a' <= input && input <= 'z')) {
				this.addToStack(input);
			} else if('0' <= input && input <= '9') {
				this.removeN(input - '0');
			} else if(input == '-') {
				this.removeOne();
			} else if(input == '#') {
				this.showStackSize();
			} else if(input == '/') {
				this.showAllFromBottom();
			} else if(input == '\\') {
				this.showAllFromTop();
			} else if(input == '^') {
				this.showTopElement();
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
	
	private void showAllFromBottom()
	{
		this._appView.outputMessage(MessageID.Show_StartBottom);
		for(int index = 0; index < this._arrayStack.size(); index++) {
			this._appView.outputStackElement((char)this._arrayStack.elementAt(index));
		}
		this._appView.outputMessage(MessageID.Show_EndTop);
	}
	
	private void showAllFromTop()
	{
		this._appView.outputMessage(MessageID.Show_StartTop);
		for(int index = this._arrayStack.size() - 1; index >= 0; index--) {
			this._appView.outputStackElement((char)this._arrayStack.elementAt(index));
		}
		this._appView.outputMessage(MessageID.Show_EndBottom);
	}
	
	private void showTopElement()
	{		
		if(this._arrayStack.isEmpty()) {
			this._appView.outputMessage(MessageID.Error_Empty);
		} else {
			this._appView.outputTopElement((char)this._arrayStack.peek());
		}
	}
	
	private void showStackSize()
	{
		this._appView.outputStackSize(this._arrayStack.size());
	}
	
	private void countAdded()
	{
		this._addedChars++;
	}
	
	private void countIgnored()
	{
		this._ignoredChars++;
	}
	
	private void countInputChar()
	{
		this._inputChars++;
	}
	
	@SuppressWarnings("unchecked")
	private void addToStack(char inputChar)
	{
		if(this._arrayStack.push(new Character(inputChar))) {
			this._appView.outputAddedElement(inputChar);
			this.countAdded();
		} else {
			this._appView.outputMessage(MessageID.Error_InputFull);
		}
	}
	
	private void removeOne()
	{
		if(this._arrayStack.isEmpty()) {
			this._appView.outputMessage(MessageID.Error_RemoveEmpty);
		} else {
			this._appView.outputRemove((char)this._arrayStack.pop());
		}
	}
	
	private void removeN(int numOfCharsToBeRemoved)
	{
		for(int i = 0; i < numOfCharsToBeRemoved; i++) {
			if(this._arrayStack.isEmpty()) {
				this._appView.outputMessage(MessageID.Error_RemoveEmpty);
				break;
			}
			this.removeOne();
		}
	}
	
	private void conclusion()
	{
		for(int i = 0; i < this._arrayStack.size(); i++) {
			this._appView.outputRemove((char)this._arrayStack.pop());
		}
		this._appView.outputResult(this._inputChars, this._ignoredChars, this._addedChars);
	}
}
