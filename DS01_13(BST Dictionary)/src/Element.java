
public class Element<Key extends Comparable<Key>, Obj> implements Comparable<Key> {	
	private Key _key;
	private Obj _object;
	
	public Element()
	{
		this._key = null;
		this._object = null;
	}
	
	public Element(Key aKey)
	{
		this._key = aKey;
		this._object = null;
	}
	
	public Element(Key aKey, Obj anObject)
	{
		this._key = aKey;
		this._object = anObject;
	}

	public Key key() {
		return this._key;
	}

	public void setKey(Key aKey) {
		this._key = aKey;
	}

	public Obj object() {
		return this._object;
	}

	public void setObject(Obj anObject) {
		this._object = anObject;
	}

	@Override
	public int compareTo(Key arg0) {
		// TODO Auto-generated method stub
				// ���� ����� this._key�� ���� ���޵� aKey�� ���Ͽ� �� ���̸� ��ȯ�Ѵ�.
				// ���� ��� 0�� ��ȯ
				// aKey�� Ŭ ���, ����(-) �� ��ȯ
				// aKey�� ���� ���, ���(+) �� ��ȯ�ȴ�.
				return this._key.compareTo((Key)arg0);
	}

}
