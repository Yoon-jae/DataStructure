import java.util.Scanner;


public class AppView {
	private Scanner _scanner;
	
	
	// ������
	public AppView()
	{
		this._scanner = new Scanner(System.in);
	}
	
	// �⺻ �Է� �Լ�
	public int inputNumber() // ���ڸ� ���������� �ٲ㼭 �޾ƿ´�.
	{
		//return this._scanner.nextInt();
		System.out.print("���ڸ� �Է��Ͻÿ� : ");
		return Integer.parseInt(this._scanner.nextLine());
	}
	
	public String inputString() // ���ڿ� �� ���� ��� �޾ƿ´�.
	{
		return this._scanner.nextLine();
	}
	
	public char inputCharacter() // ���ڿ� �� 0��°���ڸ� �޾ƿ´�.
	{
		System.out.print("> ���ڸ� �Է��Ͻÿ� : ");
		return this.inputString().charAt(0);
	}
	
	// �Է� �Լ�
	
	// ��� �Լ�
	public void outputMessage(MessageID aMessageID)
	{
		switch(aMessageID) {
		
		// Message IDs for Notices:
		case Notice_StartProgram:
			System.out.println("<����Ʈ�� �����մϴ�>");
			break;
		case Notice_EndProgram:
			System.out.println("����Ʈ�� �����մϴ�>");
			break;
		case Notice_Reset:
			System.out.println("- ����Ʈ�� ������ϴ�.");
			break;
		case Notice_ShowStartList:
			System.out.print("[List]");
			break;
		case Notice_ShowEndList:
			System.out.println("");
			break;
		
		// MessageIDs for Errors:
		case Error_WrongMenu:
			System.out.println("[Error] �߸��� �Է��Դϴ�\n");
			break;
		case Error_InputFull:
			System.out.println("[Error] ���� �� ���� �Դϴ�.\n");
			break;
		case Error_Empty:
			System.out.println("[Error] �� ���� �Դϴ�.\n");
			break;
					
		default :
			break;
	
		}
	}
	
	public void outputSize(int size)
	{
		System.out.println("[Length] ����Ʈ���� ���� " + size + "���� �ֽ��ϴ�.");
	}
	
	public void outputAdd(int anElement)
	{
		System.out.println("[Insert] ���Ե� ���Ҵ� " + anElement + "�Դϴ�.");
	}
	
	public void outputRemove(int anElement)
	{
		System.out.println("[Delete] ������ ���Ҵ� " + anElement + "�Դϴ�.");
	}
	
	public void outputElement(int anElement)
	{
		System.out.print(anElement + " ");
	}
	
}
