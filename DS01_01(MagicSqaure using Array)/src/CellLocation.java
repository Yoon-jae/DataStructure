
public class CellLocation {

	private int _row;
	private int _col;
	
	public CellLocation()
	{
		this._row = -1;
		this._col = -1;
	}
	
	public CellLocation(int givenRow, int givenCol)
	{
		this._row = givenRow;
		this._col = givenCol;
	}

	public int row()
	{
		return this._row;
	}

	public void setRow(int aRow)
	{
		this._row = aRow;
	}

	public int col()
	{
		return this._col;
	}

	public void setCol(int aCol)
	{
		this._col = aCol;
	}
	
	
}
