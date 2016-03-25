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
	
	public char inputChar() // ���ڿ� �� 0��°���ڸ� �޾ƿ´�.
	{
		return this.inputString().charAt(0);
	}
	
	// �Է� �Լ�

	public int inputNumber() {
		System.out.print("- ������ �������� �Է��Ͻÿ�: ");
		return this.inputInt();
	}
	
	public char inputCharacter() // ���ڿ� �� 0��°���ڸ� �޾ƿ´�.
	{
		char element;
		System.out.println("[���� �� �ؾ� �� ���� �ڵ带 �����Ͻÿ�]");
		System.out.println("i : �Է�\nm : �ִ밪 ����\nd : �ִ밪 ����\nv : Priority Queue ���� ����\nx : ��� ���� ���ʴ�� �����Ͽ� ���\nr : ������ �����Ͽ� 10�� �Է�\nn : ������ ���� ����\nq : ���α׷� ����");
		System.out.print("? �ؾ� �� ���� �ڵ带 ġ�ÿ�: ");
		element = this.inputChar();
		return element;
	}
	

	public void outputAdd(@SuppressWarnings("rawtypes") Comparable anElement)
	{
		System.out.println(anElement + " ���Ұ� ���������� �Է� �Ǿ����ϴ�.\n");
	}
	
	public void outputSize(int size)
	{
		System.out.println("- Priority Queue���� " + size +"���� ���Ұ� ��� �ֽ��ϴ�.\n");
	}
	
	public void outputElement(@SuppressWarnings("rawtypes") Comparable anElement)
	{
		System.out.print(" " + anElement + " ");
	}
	
	public void outputRemoveMax(int anElement)
	{
		System.out.println("�ִ밪 " + anElement + " ���Ұ� ���� �Ǿ����ϴ�.\n");
	}
	
	public void outputMax(int anElement)
	{
		System.out.println("- Priority Queue�� �ִ밪 ���Ҵ� " + anElement + "�Դϴ�.\n");
	}
	
	// ��� �Լ�
	public void outputMessage(MessageID aMessageID)
	{
		switch(aMessageID) {
		
		// Message IDs for Notices:
		case Notice_StartProgram:
			System.out.println("< �켱���� ť�� �����մϴ�> \n");
			break;
		case Notice_EndProgram:
			System.out.println("< �켱���� ť�� �����մϴ�> \n");
			break;
		case Notice_Menu:
			System.out.println("Notice_Menu");
			break;
		case Notice_RandomAdd:
			System.out.println("- ������ ���Ұ� 10�� �ԷµǾ����ϴ�. \n");
			break;
		case Notice_ShowStart:
			System.out.println("= Priority Queue�� ����");
			break;
		case Notice_ShowEnd:
			System.out.println("\n");
			break;
		case Notice_StartRemoveAll:
			System.out.println("= ������ ���ҵ� =");
			break;
		case Notice_EndRemoveAll:
			System.out.println("= ���� ���� = Priority Queue�� ������ϴ�.\n");
			break;
		
		// MessageIDs for Errors:
		case Error_WrongMenu:
			System.out.println("[Error] �߸��� �Է��Դϴ�\n");
			break;
		case Error_InputFull:
			System.out.println("[Error] ť�� ���� �� ���� �Դϴ�.\n");
			break;
		case Error_Empty:
			System.out.println("[Error] ť�� �� ���� �Դϴ�.\n");
			break;
					
		default :
			break;
	
		}
	}
	
}
