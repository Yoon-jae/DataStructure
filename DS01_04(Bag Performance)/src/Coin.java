
public class Coin {
	
	private int _value;
	
	public Coin()
	{
		this._value = 0;
	}
	
	public Coin(int aValue)
	{
		this._value = aValue;
	}

	public int value()
	{
		return this._value;
	}

	public void setValue(int aValue)
	{
		this._value = aValue;
	}
	
	public boolean equals(Coin aCoin)
	{
		return (this._value == aCoin.value());
	}
	
}
