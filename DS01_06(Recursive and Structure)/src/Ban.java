
public class Ban { // ArrayBag

	private static final int DEFAULT_MAX_SIZE = 100;
	private int _maxSize;
	private int _size;
	private Student [] _elemenets;
	
	public Ban()
	{
		this._maxSize = Ban.DEFAULT_MAX_SIZE;
		this._size = 0;
		this._elemenets = new Student[Ban.DEFAULT_MAX_SIZE];
	}
	
	public Ban(int givenMaxNumOfStudents)
	{
		this._maxSize = givenMaxNumOfStudents;
		this._size = 0;
		this._elemenets = new Student[givenMaxNumOfStudents];
	}
	
	public int maxSize()
	{
		return this._maxSize;
	}
	
	public int size()
	{
		return this._size;
	}
	
	public boolean isEmpty()
	{
		return (this._size == 0);
	}
	
	public boolean isFull()
	{
		return (this._size == this._maxSize);
	}
	
	public boolean add(Student aScore)
	{
		if(this.isFull()) {
			return false;
		} else {
			this._elemenets[this._size] = aScore;
			this._size++;
			return true;
		}
	}
	
	public Student elementAt(int aPosition)
	{
		if(0 <= aPosition && aPosition <= this._size) {
			return this._elemenets[aPosition];
		} else {
			return null;
		}
		
	}
	
	public int minScore()
	{
		return minScoreRecursively(0, this._size - 1); // 위치값
	}
	
	public int maxScore()
	{
		return maxScoreRecursively(0, this._size - 1); // 위치값
	}
	
	public float averageScore()
	{
		float sumOfScores = (float) sumOfScoresRecursively(0, this._size - 1);
		float average = sumOfScores / (float) this._size;
		return average;
	}
	
	public int numberOfStudentsAboveAverage()
	{
		float average = averageScore();
		float score;
		int numberOfStudentsAboveAverage = 0;
		for(int i = 0; i < this._size; i++) {
			score = (float) this._elemenets[i].score();
			if(score >= average) {
				numberOfStudentsAboveAverage++;
			}
		}
		return numberOfStudentsAboveAverage;
	}
	
	public GradeCounter countGrades()
	{
		char currentGrade;
		GradeCounter gradeCounter = new GradeCounter();
		for(int i = 0; i < this._size; i++) {
			currentGrade = this.scoreToGrade(this._elemenets[i].score());
			gradeCounter.count(currentGrade);
		}
		return gradeCounter;
	}
	
	private void swap(int a, int b)
	{
		Student temp = this._elemenets[a];
		this._elemenets[a] = this._elemenets[b];
		this._elemenets[b] = temp;
	}
	
	public void sortStudentsByScore()
	{
		int size = this._size;
		if(size >= 2) {
			int minLoc = 0;
			for(int i = 1; i < size; i++) {
				if(this._elemenets[i].score() < this._elemenets[minLoc].score()) {
					minLoc = i;
				}
			}
			swap(minLoc, size - 1);
			quickSortRecursively(0, size - 2);
		}
	}
	
	public void quickSortRecursively(int left, int right)
	{
		int mid;
		if(left < right) {
			mid = partition(left, right);
			quickSortRecursively(left, mid - 1);
			quickSortRecursively(mid + 1, right);
		}
	}
	
	public int partition(int left, int right)
	{
		int pivot = left;
		int pivotScore = this._elemenets[pivot].score();
		right++;
		do {
			do {
				left++;
			} while (this._elemenets[left].score() > pivotScore);
			do {
				right--;
			} while (this._elemenets[right].score() < pivotScore);
			if(left < right) {
				this.swap(left, right);
			}
		} while(left < right);
		this.swap(pivot, right);
		return right; // pivot의 위치를 반환
	}
	
	private float sumOfScoresRecursively(int left, int right)
	{
		if(left > right) {
			return 0;
		} else {
			return (this._elemenets[left].score() + sumOfScoresRecursively(left + 1, right));
		}
	}
	
	private int maxScoreRecursively(int left, int right)
	{
		int maxOfRight, maxOfLeft;
		int mid;
		if(left == right) {
			return this._elemenets[left].score();
		} else {
			mid = (left + right) / 2;
			maxOfRight = maxScoreRecursively(left, mid);
			maxOfLeft = maxScoreRecursively(mid + 1, right);
			if(maxOfRight >= maxOfLeft) {
				return maxOfRight;
			} else {
				return maxOfLeft;
			}
		}
	}
	
	private int minScoreRecursively(int left, int right)
	{
		int minScore;
		if(left == right) {
			return this._elemenets[left].score();
		} else {
			minScore = minScoreRecursively(left + 1, right);
			if(this._elemenets[left].score() <= minScore) {
				return this._elemenets[left].score();
			} else {
				return minScore;
			}
		}
	}
	
	private char scoreToGrade(int aScore)
	{
		if(aScore >= 90) 
			return 'A';
		else if(aScore >= 80)
			return 'B';
		else if(aScore >= 70)
			return 'C';
		else if(aScore >= 60)
			return 'D';
		else
			return 'F';
	}	
}
