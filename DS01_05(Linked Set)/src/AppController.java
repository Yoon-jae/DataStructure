
public class AppController {
	private AppView _appView;
//	private ArraySet _starCollector;
	private LinkedSet _starCollector;
	
	public AppController()
	{
		this._appView = new AppView();
	}
	
	public void run()
	{
//		this._starCollector = new ArraySet();
		this._starCollector = new LinkedSet();
		
		this._appView.outputMessage(MessageID.Notice_StartProgram);
		int command = 0;
		while(command != 9) {
			try {
				this._appView.outputMessage(MessageID.Notice_Menu);
				command = this._appView.inputInt();
				if(command == 1) { // input
					this.input();
				} else if(command == 2) { // remove
					this.remove();
				} else if(command == 3) { // removeAny
					this._appView.outputMessage(MessageID.Notice_RemoveRandomStar);
					Star removedStar = this._starCollector.removeAny();
					if(removedStar != null) {
						this._appView.showStar(removedStar.starName(), removedStar.xCoordinate(), removedStar.yCoordinate());
					} else {
						this._appView.outputMessage(MessageID.Error_Remove);
					}
				} else if(command == 4) { // show size
					this._appView.outputMessage(MessageID.Notice_Show);
					this._appView.showNumOfStars(this._starCollector.size());
				} else if(command == 5) { // search by name
					this.searchByName();
				} else if(command == 6) { // search by coordinate
					this.searchByCoordinate();
				} else if(command == 9) { // exit
					this._appView.outputMessage(MessageID.Notice_EndMenu);
					this._appView.showNumOfStars(this._starCollector.size());
					break;
				} else {
					this._appView.outputMessage(MessageID.Error_WrongMenu);
				}
			} catch(Exception ex) {
				System.out.println("Error Message : " + ex.getMessage());
				continue;
			}
		}
		this._appView.outputMessage(MessageID.Notice_EndProgram);
	}
	
	private void input()
	{
		this._appView.outputMessage(MessageID.Notice_InputStar);
		this._appView.outputMessage(MessageID.Notice_InputStarXCoordinate);
		int xCoordinate = this._appView.inputInt();
		this._appView.outputMessage(MessageID.Notice_InputStarYCoordinate);
		int yCoordinate = this._appView.inputInt();
		this._appView.outputMessage(MessageID.Notice_InputStarName);
		String starName = this._appView.inputString();
		if(!this._starCollector.add(new Star(xCoordinate,yCoordinate,starName))) {
			this._appView.outputMessage(MessageID.Error_Input);
		}
	}
	
	private void remove()
	{
		this._appView.outputMessage(MessageID.Notice_RemoveStar);
		this._appView.outputMessage(MessageID.Notice_InputStarName);		
		String aStarName = this._appView.inputString();
		Star aStar = new Star(aStarName);
		if (this._starCollector.doesContain(aStar)) {
			Star tempStar = this._starCollector.remove(aStar);
			this._appView.showStar(tempStar.starName(), tempStar.xCoordinate(), tempStar.yCoordinate());
		} else {
			this._appView.outputMessage(MessageID.Error_Remove);
		}
	}
	
	private void searchByName()
	{
		this._appView.outputMessage(MessageID.Notice_SearchByName);
		this._appView.outputMessage(MessageID.Notice_InputStarName);
		String aStarName = this._appView.inputString();
		Star aStar = new Star(aStarName);
		if(this._starCollector.doesContain(aStar)) {
			this._appView.showExistence(aStar.starName(),aStar.xCoordinate(),aStar.yCoordinate());
		} else {
			this._appView.outputMessage(MessageID.Error_Remove);
		}
	}
	
	private void searchByCoordinate()
	{
		this._appView.outputMessage(MessageID.Notice_SearchByCoordinate);
		this._appView.outputMessage(MessageID.Notice_InputStarXCoordinate);
		int xCoordinate = this._appView.inputInt();
		this._appView.outputMessage(MessageID.Notice_InputStarYCoordinate);
		int yCoordinate = this._appView.inputInt();
		Star aStar = new Star(xCoordinate, yCoordinate);
		if (this._starCollector.doesContain(aStar)) {
			this._appView.showExistence(null,aStar.xCoordinate(),aStar.yCoordinate());
		} else {
			this._appView.outputMessage(MessageID.Error_Remove);
		}

	}
}
