import java.util.Scanner;


public class AppView {
	private Scanner _scanner;
	
	
	// ������
	public AppView()
	{
		this._scanner = new Scanner(System.in);
	}
	
	// �⺻ �Է� �Լ�
	public String inputString() // ���ڿ� �� ���� ��� �޾ƿ´�.
	{
		return this._scanner.nextLine();
	}
	
	// �Է� �Լ�
	public char inputCharacter() // ���ڿ� �� 0��°���ڸ� �޾ƿ´�.
	{
		char element;
		System.out.println("- ���ڸ� �Է��Ͻÿ�: ");
		element = this.inputString().charAt(0);
		return element;
	}
	
	// ��� �Լ�
	public void outputMessage(MessageID aMessageID)
	{
		switch(aMessageID) {
				
		// Message IDs for Notices:
		case Notice_StartProgram:
			System.out.println("> ���α׷��� �����մϴ�.");
			break;
		case Notice_EndProgram:
			System.out.println("> ���α׷��� �����մϴ�.");
			break;
		case Notice_StartMenu:
			System.out.println("[ť �Է��� �����մϴ�.]");
			break;
		case Notice_EndMenu:
			System.out.println("[ť �Է��� �����մϴ�.]");
			break;
		case Show_QueueStart:
			System.out.print("[Queue] <Front> ");
			break;
		case Show_QueueEnd:
			System.out.println("<Rear>");
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
	
	public void outputAdd(char anElement)
	{
		System.out.println("[EnQueue] ���Ե� ���Ҵ� " + anElement + "�Դϴ�.");
	}
	
	public void outputElement(char anElement)
	{
		System.out.print(anElement + " ");
	}
	
	public void outputFrontElement(char anElement)
	{
		System.out.println("[Front] �� �� ���Ҵ� " + anElement + "�Դϴ�.");
	}
	
	public void outputQueueSize(int aQueueSize)
	{
		System.out.println("[Size] ť���� ���� " + aQueueSize + "���� ���Ұ� �ֽ��ϴ�.");
	}
	
	public void outputRemove(char anElement)
	{
		System.out.println("[DeQueue] ������ ���Ҵ� " + anElement + "�Դϴ�.");
	}
	
	public void outputRemoveN(int aNumOfCharsToBeRemoved)
	{
		System.out.println(aNumOfCharsToBeRemoved + "���� ���Ҹ� �����Ϸ��� �մϴ�.");
	}
	
	public void outputResult(int aNumOfInputChars, int aNumOfIgnoredChars, int aNumOfAddedChars)
	{
		System.out.println("... . . �Էµ� ���ڴ� �� " + aNumOfInputChars +"�� �Դϴ�.");
		System.out.println("... . . ���� ó���� ���ڴ� " + (aNumOfInputChars - aNumOfIgnoredChars) + "�� �Դϴ�.");
		System.out.println("... . . ���õ� ���ڴ� " + aNumOfIgnoredChars + "�� �Դϴ�.");
		System.out.println("... . . ���Ե� ���ڴ� " + aNumOfAddedChars + "�� �Դϴ�.");
	}
}
