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
	
	// �Է� �Լ�
	
	// ��� �Լ�
	public void outputMessage(MessageID aMessageID)
	{
		switch(aMessageID) {
		
		// Message IDs for Notices:
		case Notice_StartProgram:
			System.out.println("<<���� ���� ���α׷��� �����մϴ�>> \n");
			break;
		case Notice_EndProgram:
			System.out.println("<<���� ���� ���α׷��� �����մϴ�>> \n");
			break;
		case Notice_Menu:
			System.out.println("�����Ϸ����ϴ� �޴��� �����ϼ���  \n" + "(add: 1, remove: 2, print: 3, search: 4, removeAny: 5, exit: 9)");
			break;
		case Notice_EndMenu:
			System.out.println("9�� �ԷµǾ� �����մϴ�. \n");
			break;
		case Notice_InputCoin:
			System.out.println("������ �׼��� �Է��ϼ���: ");
			break;
			
		
		// MessageIDs for Errors:
		case Error_WrongMenu:
			System.out.println("[Error] �߸��� �޴��Դϴ�.\n");
			break;
		case Error_Empty:
			System.out.println("[Error] �� ���� �Դϴ�.\n");
			break;
		case Error_Full:
			System.out.println("[Error] �� �� ���� �Դϴ�.\n");
			break;
		case Error_DoesNotContain:
			System.out.println("[Error] �ش� ������ �������� �ʽ��ϴ�.\n");
			break;
					
		default :
			break;
	
		}
	}
	
	public void outputRemove(int removedCoin)
	{
		System.out.println("������ ����: " + removedCoin);
	}
	
	public void outputResult(int aTotalCoinSize, int aMaxCoinValue, int aSumOfCoinValue)
	{
		System.out.println("�� ����: " + aTotalCoinSize + "\n���� ū ����: " + aMaxCoinValue + "\n������ ��: " + aSumOfCoinValue + "\n");
	}
	
	public void outputSearch(int aSearchValue, int aSearchedSize)
	{
		System.out.println(aSearchValue + "������ " + aSearchedSize + "�� �����մϴ�.\n");
	}
	
}
