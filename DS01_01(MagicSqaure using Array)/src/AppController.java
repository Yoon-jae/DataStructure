
public class AppController {
	private AppView _appView;
	private Board _board;
	private MagicSquare _magicSquare;
	
	public AppController()
	{
		this._appView = new AppView();
		this._board = null;
		this._magicSquare = new MagicSquare();
	}
	
	public void run()
	{
		this._appView.outputMessage(MessageID.Notice_StartProgram);
		OrderValidity currentOrderValidity;
		
		int order = this._appView.inputOrder();
		while(order > 0) {
			currentOrderValidity = this._magicSquare.checkOrderValidty(order);
			if(currentOrderValidity == OrderValidity.Valid) {
				this._appView.outputTitleWithOrder(order);
				this._board = this._magicSquare.solve(order);
				this.showBoard(this._board);
			}
			else {
				this._appView.outputOrderValidityErrorMessage(currentOrderValidity);
			}
			order = this._appView.inputOrder();
		}
		this._appView.outputMessage(MessageID.Notice_EndProgram);
	}
	
	private void showBoard(Board aBoard)
	{
		CellLocation currentLoc = new CellLocation(aBoard.order(), aBoard.order());
		this._appView.outputSpace();
		for(int i = 0; i < aBoard.order(); i++) {
			this._appView.outputColNumber(i);
		}
		this._appView.outputNextLine();
		for(int i = 0; i < aBoard.order(); i++) {
			this._appView.outputRowNumber(i);
			for(int j = 0; j < aBoard.order(); j++) {				
				currentLoc.setRow(i);
				currentLoc.setCol(j);
				this._appView.outputCell(aBoard.cell(currentLoc));
			}
			this._appView.outputNextLine();
		}
	}
	
}
