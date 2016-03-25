
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
				// 현재 저장된 this._key의 값과 전달된 aKey를 비교하여 그 차이를 반환한다.
				// 같을 경우 0이 반환
				// aKey가 클 경우, 음수(-) 가 반환
				// aKey가 작을 경우, 양수(+) 가 반환된다.
				return this._key.compareTo((Key)arg0);
	}

}
