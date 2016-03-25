
public class Student {
	
	private int _score;
	
	public Student()
	{
		this._score = 0;
	}
	
	public Student(int aScore)
	{
		this._score = aScore;
	}
	
	public int score()
	{
		return this._score;
	}
	
	public void setScore(int aScore)
	{
		this._score = aScore;
	}
}
