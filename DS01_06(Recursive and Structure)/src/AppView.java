import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;


public class AppView {
	private Scanner _scanner;
	
	// ������
	public AppView()
	{
		this._scanner = new Scanner(System.in);
	}
	
	// �⺻ �Է� �Լ�
	public int inputInt() // ���ڸ� ���������� �ٲ㼭 �޾ƿ´�.
	{
		//return this._scanner.nextInt();
		return Integer.parseInt(this._scanner.nextLine());
	}
	
	public String inputString() // ���ڿ� �� ���� ��� �޾ƿ´�.
	{
		return this._scanner.nextLine();
	}
	
	// �Է� �Լ�
	public int inputScore()
	{
		int score;
		System.out.println("������ �Է��ϼ���: ");
		score = this.inputInt();
		return score;
	}
	
	public boolean inputDoesContinueToInputNextStudent()
	{
		char answer;
		System.out.print("�������Է��Ϸ���'Y' ��, �����Ϸ���ٸ��ƹ�Ű��ġ�ÿ�: ");
		answer = this.inputString().charAt(0);
		return (answer == 'Y' || answer == 'y');
	}
	
	// ��� �Լ�
	public void outputMessage(MessageID aMessageID)
	{
		switch(aMessageID) {
		
		// Message IDs for Notices:
		case Notice_StartProgram:
			System.out.println("<< ���� ó���� �����մϴ� >> \n");
			break;
		case Notice_EndProgram:
			System.out.println("\n<< ���� ó���� �����մϴ� >>");
			break;
		case Notice_StartMenu:
			System.out.println("[���� �Է��� �����մϴ�]");
			break;
		case Notice_EndMenu:
			System.out.println("[���� �Է��� �����մϴ�]\n");
			break;
			
		// MessageIDs for Shows:	
		case Show_SortedStudentList:
			System.out.println("\n�л����� ������ ����Դϴ�.");
			break;
			
		// MessageIDs for Errors:
		case Error_WrongMenu:
			System.out.println("[Error] �߸��� �Է��Դϴ�.\n");
			break;
		case Error_InvalidScore:
			System.out.println("[Error] ������ 0���� �۰ų� 100���� Ŀ�� �������� ������ �ƴմϴ�.");
			break;
		case Error_Input:
			System.out.println("[Error] �ƹ� ������ �Էµ��� �ʾҽ��ϴ�.\n");
			break;
					
		default :
			break;
	
		}
	}
	
	public void outputAverageScore(float anAverageScore)
	{
		System.out.println("��� ������ " + anAverageScore + " �Դϴ�.");
	}
	
	public void outputNumberOfStudentsAboveAverage(int aNumber)
	{
		System.out.println("��� �̻��� �л��� ��� " + aNumber + "�� �Դϴ�.");
	}
	
	public void outputMaxScore(int aMaxScore)
	{
		System.out.println("�ְ����� " + aMaxScore + "�� �Դϴ�.");
	}
	
	public void outputMinScore(int aMinScore)
	{
		System.out.println("�������� " + aMinScore + "�� �Դϴ�.");

	}
	
	public void outputGradeCountFor(char aGrade, int aCount)
	{
		System.out.println(aGrade + " ������ ��� " + aCount + "�� �Դϴ�.");
	}
	
	public void outputStudentInfo(int aScore)
	{
		System.out.println("���� : " + aScore);
	}
	
}
