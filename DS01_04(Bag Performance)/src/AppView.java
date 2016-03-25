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
			System.out.println("< List�� ������ ���� ���� ���� ���� �˾ƺ��� >");
			break;
		case Notice_EndProgram:
			System.out.println("< ���� ������ �����մϴ� > \n");
			break;
		case Notice_UnsortedArrayStart:
			System.out.println("[Unsorted Array]");
			break;
		case Notice_SortedArrayStart:
			System.out.println("[Sorted Array]");
			break;
		case Notice_UnsortedLinkedStart:
			System.out.println("[Unsorted Linked Chain]");
			break;
		case Notice_SortedLinkedStart:
			System.out.println("[Sorted Linked Chain]");
			break;
					
		// MessageIDs for Errors:
		case Error_WrongMenu:
			System.out.println("[Error] �߸��� �Է��Դϴ�\n");
			break;
					
		default :
			break;
	
		}
	}
	
	public void outputResult(int aTestSize, long aTestInsertTime, long aTestFindMaxTime)
	{
		System.out.printf("ũ��: %4d   �����ϱ�: %8d   �ִ밪ã�� : %8d\n", aTestSize, aTestInsertTime, aTestFindMaxTime);
	}
	
}
