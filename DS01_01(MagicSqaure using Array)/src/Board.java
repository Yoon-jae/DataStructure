
public class Board {
	private static final int EMPTY_CELL = -1;
	
	private int _order;
	private int[][] _cell;
	
	public Board(int givenOrder)
	{
		this._order = givenOrder;
		this._cell = new int[givenOrder][givenOrder];
		for(int row = 0; row < givenOrder; row++) {
			for(int col = 0; col < givenOrder; col++) {
				this._cell[row][col] = Board.EMPTY_CELL;
			}
		}
	}
	
	public int order()
	{
		return this._order;
	}
	
	public void setCell(CellLocation aLocation, int aNumber)
	{
		this._cell[aLocation.row()][aLocation.col()] = aNumber;
	}
	
	public int cell(CellLocation aLocation)
	{
		return this._cell[aLocation.row()][aLocation.col()];
	}
	
	public boolean cellIsEmpty(CellLocation aLocation)
	{
		return (this._cell[aLocation.row()][aLocation.col()] == Board.EMPTY_CELL);
	}
}
