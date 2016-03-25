import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;


public class AppView {
	private Scanner _scanner;
	
	// 생성자
	public AppView()
	{
		this._scanner = new Scanner(System.in);
	}
	
	// 기본 입력 함수
	public int inputInt() // 문자를 숫자형으로 바꿔서 받아온다.
	{
		//return this._scanner.nextInt();
		return Integer.parseInt(this._scanner.nextLine());
	}
	
	public String inputString() // 문자열 한 줄을 모두 받아온다.
	{
		return this._scanner.nextLine();
	}
	
	// 입력 함수
	public int inputScore()
	{
		int score;
		System.out.println("점수를 입력하세요: ");
		score = this.inputInt();
		return score;
	}
	
	public boolean inputDoesContinueToInputNextStudent()
	{
		char answer;
		System.out.print("성적을입력하려면'Y' 를, 종료하려면다른아무키나치시오: ");
		answer = this.inputString().charAt(0);
		return (answer == 'Y' || answer == 'y');
	}
	
	// 출력 함수
	public void outputMessage(MessageID aMessageID)
	{
		switch(aMessageID) {
		
		// Message IDs for Notices:
		case Notice_StartProgram:
			System.out.println("<< 성적 처리를 시작합니다 >> \n");
			break;
		case Notice_EndProgram:
			System.out.println("\n<< 성적 처리를 종료합니다 >>");
			break;
		case Notice_StartMenu:
			System.out.println("[성적 입력을 시작합니다]");
			break;
		case Notice_EndMenu:
			System.out.println("[성적 입력을 종료합니다]\n");
			break;
			
		// MessageIDs for Shows:	
		case Show_SortedStudentList:
			System.out.println("\n학생들의 성적순 목록입니다.");
			break;
			
		// MessageIDs for Errors:
		case Error_WrongMenu:
			System.out.println("[Error] 잘못된 입력입니다.\n");
			break;
		case Error_InvalidScore:
			System.out.println("[Error] 점수가 0보다 작거나 100보다 커서 정상적인 점수가 아닙니다.");
			break;
		case Error_Input:
			System.out.println("[Error] 아무 성적이 입력되지 않았습니다.\n");
			break;
					
		default :
			break;
	
		}
	}
	
	public void outputAverageScore(float anAverageScore)
	{
		System.out.println("평균 점수는 " + anAverageScore + " 입니다.");
	}
	
	public void outputNumberOfStudentsAboveAverage(int aNumber)
	{
		System.out.println("평균 이상인 학생은 모두 " + aNumber + "명 입니다.");
	}
	
	public void outputMaxScore(int aMaxScore)
	{
		System.out.println("최고점은 " + aMaxScore + "점 입니다.");
	}
	
	public void outputMinScore(int aMinScore)
	{
		System.out.println("최저점은 " + aMinScore + "점 입니다.");

	}
	
	public void outputGradeCountFor(char aGrade, int aCount)
	{
		System.out.println(aGrade + " 학점은 모두 " + aCount + "명 입니다.");
	}
	
	public void outputStudentInfo(int aScore)
	{
		System.out.println("점수 : " + aScore);
	}
	
}
