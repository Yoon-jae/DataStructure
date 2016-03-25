
public class AppController {
	private AppView _appView;
	private Ban _ban;
	
	public AppController()
	{
		this._appView = new AppView();
	}
	
	public void run()
	{
		this._appView.outputMessage(MessageID.Notice_StartProgram);
		this.inputAndStoreStudents();
		if(this._ban.isEmpty()) {
			this._appView.outputMessage(MessageID.Error_Input);
		} else {
			this.showStatistics();
			this._ban.sortStudentsByScore();
			this.showStudentsSortedByScore();
		}
		this._appView.outputMessage(MessageID.Notice_EndProgram);
	}
	
	private boolean inputAndStoreStudents()
	{
		this._appView.outputMessage(MessageID.Notice_StartMenu);
		int score;
		boolean storingAStudentWasSuccessful = true;
		this._ban = new Ban();
		while(storingAStudentWasSuccessful && this._appView.inputDoesContinueToInputNextStudent()) {
			score = this._appView.inputScore();
			if(score < 0 || 100 < score) {
				this._appView.outputMessage(MessageID.Error_InvalidScore);
			} else {
				Student aStudent = new Student(score);
				this._ban.add(aStudent);
			}
		}
		this._appView.outputMessage(MessageID.Notice_EndMenu);
		return storingAStudentWasSuccessful;
	}
	
	private void showStatistics()
	{
		this._appView.outputAverageScore(this._ban.averageScore());
		this._appView.outputNumberOfStudentsAboveAverage(this._ban.numberOfStudentsAboveAverage());
		this._appView.outputMaxScore(this._ban.maxScore());
		this._appView.outputMinScore(this._ban.minScore());

		GradeCounter gradeCounter= this._ban.countGrades();
		this._appView.outputGradeCountFor('A', gradeCounter.numberOfA());
		this._appView.outputGradeCountFor('B', gradeCounter.numberOfB());
		this._appView.outputGradeCountFor('C', gradeCounter.numberOfC());
		this._appView.outputGradeCountFor('D', gradeCounter.numberOfD());
		this._appView.outputGradeCountFor('F', gradeCounter.numberOfF());
	}
	
	private void showStudentsSortedByScore()
	{
		this._appView.outputMessage(MessageID.Show_SortedStudentList);
		for(int index = 0; index < this._ban.size(); index++) {
			this._appView.outputStudentInfo(this._ban.elementAt(index).score());
		}
	}
}
