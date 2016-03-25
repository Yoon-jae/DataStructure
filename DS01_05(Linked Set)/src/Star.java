
public class Star {
	
	private int _xCoordinate;
	private int _yCoordinate;
	private String _starName;
	
	public Star()
	{
		this._xCoordinate = 0;
		this._yCoordinate = 0;
		this._starName = null;
	}
	
	public Star(int aX, int aY)
	{
		this._xCoordinate = aX;
		this._yCoordinate = aY;
		this._starName = null;
	}
	
	public Star(String aStarName)
	{
		this._xCoordinate = 0;
		this._yCoordinate = 0;
		this._starName = aStarName;
	}
	
	public Star(int aX, int aY, String aStarName)
	{
		this._xCoordinate = aX;
		this._yCoordinate = aY;
		this._starName = aStarName;
	}

	public int xCoordinate() {
		return this._xCoordinate;
	}

	public void setXCoordinate(int _xCoordinate) {
		this._xCoordinate = _xCoordinate;
	}

	public int yCoordinate() {
		return this._yCoordinate;
	}

	public void setYCoordinate(int _yCoordinate) {
		this._yCoordinate = _yCoordinate;
	}

	public String starName() {
		return this._starName;
	}

	public void setStarName(String aStarName) {
		this._starName = aStarName;
	}
	
	public boolean equals(Star aStar)
	{
		if(this._xCoordinate == aStar._xCoordinate && this._yCoordinate == aStar._yCoordinate) {
			return true;
		} else if(this._starName.equals(aStar._starName) && aStar._starName != null ) {
			return true;
		} else {
			return false;
		}
	}
}
