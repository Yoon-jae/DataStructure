import java.util.Scanner;


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
	
	// ��� �Լ�
	public void outputMessage(MessageID aMessageID)
	{
		switch(aMessageID) {		
		
		// Message IDs for Notices:
		case Notice_StartProgram:
			System.out.println("< ���� ������ �����մϴ� > \n");
			break;
		case Notice_EndProgram:
			System.out.println("< ���� ������ �����մϴ� > \n");
			break;
		case Notice_Menu:
			System.out.println("1:�Է�   2:�־��� �� ����   3:������ �� ����    \n4:���   5:�̸����� �˻�   6:��ǥ�� �˻�   9:����");
			break;
		case Notice_EndMenu:
			System.out.println("");
			break;
		case Notice_InputStar:
			System.out.println("- [�Է�] - ");
			break;
		case Notice_InputStarName:
			System.out.println("- ���� �̸��� �Է��ϼ��� : ");
			break;
		case Notice_InputStarXCoordinate:
			System.out.println("- x��ǥ�� �Է��ϼ��� : ");
			break;
		case Notice_InputStarYCoordinate:
			System.out.println("- y��ǥ�� �Է��ϼ��� : ");
			break;
		case Notice_RemoveStar:
			System.out.println("- [�־��� �� ����] - ");
			break;
		case Notice_RemoveRandomStar:
			System.out.println("- [������ �� ����] - ");
			break;
		case Notice_Show:
			System.out.println("- [���] - ");
			break;
		case Notice_SearchByName:
			System.out.println("- [�̸����� �˻�] - ");
			break;
		case Notice_SearchByCoordinate:
			System.out.println("- [��ǥ�� �˻�] - ");
			break;
			
		// MessageIDs for Errors:
		case Error_WrongMenu:
			System.out.println("[Error] �߸��� �޴� �Է��Դϴ�.\n");
			break;
		case Error_Input:
			System.out.println("[Error] �߸��� �Է��Դϴ�.\n");
			break;
		case Error_Remove:
			System.out.println("[Error] �ش� ���� �������� �ʽ��ϴ�.\n");
			break;
					
		default :
			break;
	
		}
	}
	
	public void showStar(String aStarName, int aX, int aY)
	{
		System.out.println("X ��ǥ: " + aX + "\nY ��ǥ : " + aY + "\n���� �̸� : " + aStarName);
	}
	
	public void showExistence(String aStarName, int aX, int aY)
	{
		if(aStarName == null && (aX != '\0' && aY != '\0')) {
			System.out.printf("(%d,%d) ��ġ�� ���� �����մϴ�.\n", aX, aY);
		} else if(aStarName != null && (aX == '\0' && aY == '\0')) {
			System.out.println(aStarName + " ���� �����մϴ�.");
		} else {
			System.out.println("���ϴ� ���� �������� �ʽ��ϴ�.");
		}
	}
	
	public void showNumOfStars(int aStarCollectorSize)
	{
		System.out.println(aStarCollectorSize + "���� ���� �����մϴ�.");
	}
	
}
