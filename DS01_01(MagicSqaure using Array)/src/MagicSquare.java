
public class MagicSquare {
	private static final int DEFAULT_MAX_ORDER = 99;
	
	private int _maxOrder;
	private int _order;
	private Board _board;
	
	public MagicSquare()
	{
		this._maxOrder = MagicSquare.DEFAULT_MAX_ORDER;
		this._order = 3;
		this._board = null;
	}
	
	public MagicSquare(int givenMaxOrder)
	{
		this._maxOrder = givenMaxOrder;
		this._order = 3;
		this._board = null;
	}
	
	public OrderValidity checkOrderValidty(int anOrder)
	{
		if(anOrder %2 == 0) 
			return OrderValidity.NotOddNumber;
		if(anOrder <= 2) 
			return OrderValidity.TooSmall;
		if(anOrder > MagicSquare.DEFAULT_MAX_ORDER)
			return OrderValidity.TooLarge;
		else 
			return OrderValidity.Valid;
	}
	
	public int maxOrder()
	{
		return this._maxOrder;
	}
	
	public int order()
	{
		return this._order;
	}
	
	public Board solve(int anOrder)
	{
		this._order = anOrder;
		if(this.checkOrderValidty(anOrder) != OrderValidity.Valid) {
			return null;
		}
		else {
			this._board = new Board(this._order);
			CellLocation currentLoc = new CellLocation(0,this._order/2);
			CellLocation nextLoc = new CellLocation();
			
			this._board.setCell(currentLoc,1);
			int lastNumber = this._order * this._order;
			for(int number = 2; number <= lastNumber; number++) {
				// <������ġ>�κ��� <������ġ>�� "��������" ��ġ�� ���
				nextLoc.setRow((currentLoc.row() + this._order - 1) % this._order);
				nextLoc.setCol((currentLoc.col() + 1) % this._order);
				// <������ġ>�� ä���� ������
				// <������ġ>�� <������ġ>�� �ٷ� �� �� �Ʒ� ĭ ��ġ�� ����
				if(!this._board.cellIsEmpty(nextLoc)) {
					nextLoc.setRow((currentLoc.row() + 1) % this._order);
					nextLoc.setCol(currentLoc.col());
				}
				// <������ġ>�� ���ο� <���� ��ġ>�� �Ѵ�
				currentLoc.setRow(nextLoc.row());
				currentLoc.setCol(nextLoc.col());
				// ���ο� <������ġ>�� number���� �ִ´�
				this._board.setCell(currentLoc, number);
			}
		}
		return this._board;
	}
}
