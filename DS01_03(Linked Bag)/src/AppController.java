
public class AppController {
	private AppView _appView;
	private LinkedBag _coinCollector;
	
	public AppController()
	{
		this._appView = new AppView();
	}
	
	public void run()
	{
		int input = 0;
		int order = 0;
		
		this._appView.outputMessage(MessageID.Notice_StartProgram);

		this._coinCollector = new LinkedBag();
		
		while(order != 9) {
			this._appView.outputMessage(MessageID.Notice_Menu);
			order = this._appView.inputInt();
			if(order == 1) { // add
				if(this._coinCollector.isFull()) {
					this._appView.outputMessage(MessageID.Error_Full);
				} else {
					this._appView.outputMessage(MessageID.Notice_InputCoin);
					input = this._appView.inputInt();
					Coin anCoin = new Coin(input);
					this._coinCollector.add(anCoin);
				}
			}
			else if(order == 2) { // remove
				if(this._coinCollector.isEmpty()) {
					this._appView.outputMessage(MessageID.Error_Empty);
				}
				else {
					this._appView.outputMessage(MessageID.Notice_InputCoin);
					input = this._appView.inputInt();
					Coin givenCoin = new Coin(input);
					if(this._coinCollector.doesContain(givenCoin)) {
						this._appView.outputRemove(this._coinCollector.remove(givenCoin).value());
					} else {
						this._appView.outputMessage(MessageID.Error_DoesNotContain);
					}
				}
			}
			else if(order == 3) { // print
				this._appView.outputResult(this._coinCollector.size(), this._coinCollector.maxElementValue(), this._coinCollector.sumElementValues());
			}
			else if(order == 4) { // search
				if(this._coinCollector.isEmpty()) {
					this._appView.outputMessage(MessageID.Error_Empty);
				}
				else {
					this._appView.outputMessage(MessageID.Notice_InputCoin);
					input = this._appView.inputInt();
					Coin givenCoin = new Coin(input);
					this._appView.outputSearch(input, this._coinCollector.frequencyOf(givenCoin));
				}
			}
			else if(order == 5) { // removeAny
				if(this._coinCollector.isEmpty()) {
					this._appView.outputMessage(MessageID.Error_Empty);
				}
				else {
					this._appView.outputRemove(this._coinCollector.removeAny().value());
				}
			}
			else if(order == 9) { // exit
				this._appView.outputMessage(MessageID.Notice_EndMenu);
				this._appView.outputResult(this._coinCollector.size(), this._coinCollector.maxElementValue(), this._coinCollector.sumElementValues());
				this._appView.outputMessage(MessageID.Notice_EndProgram);
			}
			else {
				this._appView.outputMessage(MessageID.Error_WrongMenu);
			}
		}
	}	
	
}
