
public class AppController {
	private AppView _appView;
	private Calculate _calculate;
	
	public AppController()
	{
		this._appView = new AppView();
		this._calculate = new Calculate();
	}
		
	public void run()
	{
		this._appView.outputMessage(MessageID.Notice_StartProgram);
		this._appView.outputMessage(MessageID.Notice_StartMenu);
		String input = this._appView.inputExpression();
		while(input.charAt(0) != '!') {
			this._calculate.setInfix(input);
			this.evalExpression();
			input = this._appView.inputExpression();
		}
		this._appView.outputMessage(MessageID.Notice_EndMenu);
		this._appView.outputMessage(MessageID.Notice_EndProgram);


	}
	
	public void evalExpression()
	{
		double finalValue;
		this._appView.outputMessage(MessageID.Notice_InfixToPostfix);
		if(this._calculate.infixToPostfix()) {
			this._appView.outputPostfix(this._calculate.postfix());
			finalValue = this._calculate.evalPostfix();
			this._appView.outputResult(finalValue);
		}
		else
			this._appView.outputMessage(MessageID.Error_Input);
	}
}
