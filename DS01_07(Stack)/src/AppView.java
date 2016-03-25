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
			System.out.println("\n> ���α׷��� �����մϴ�.");
			break;
		case Notice_StartMenu:
			System.out.println("[���� ����� �����մϴ�.]");
			break;
		case Notice_EndMenu:
			System.out.println("[���� ����� �����մϴ�.]");
			break;
			
		// MessageIDs for Shows:
		case Show_StartBottom:
			System.out.print("[Stack] <Bottom> ");
			break;
		case Show_StartTop:
			System.out.print("[Stack] <Top> ");
			break;
		case Show_EndBottom:
			System.out.println("<Bottom>");
			break;
		case Show_EndTop:
			System.out.println("<Top>");
			break;
			
			
		// MessageIDs for Errors:
		case Error_WrongMenu:
			System.out.println("[Error] �߸��� �Է��Դϴ�.");
			break;
		case Error_InputFull:
			System.out.println("[Full] ������ �� ���� ������ �Ұ����մϴ�.");
			break;
		case Error_RemoveEmpty:
			System.out.println("[Empty] ���ÿ� ������ ���Ұ� �����ϴ�.");
			break;
		case Error_Empty:
			System.out.println("[Empty] ������ ����ֽ��ϴ�.");
			break;			
			
		default :
			break;
	
		}
	}
	
	public void outputAddedElement(char anElement)
	{
		System.out.println("[Push] ���Ե� ���Ҵ� '" + anElement + "' �Դϴ�.");
	}
	
	public void outputStackElement(char anElement)
	{
		System.out.print(anElement + " ");
	}
	
	public void outputTopElement(char anElement)
	{
		System.out.println("[Top] Top ���Ҵ� '" + anElement + "' �Դϴ�.");
	}
	
	public void outputStackSize(int aStackSize)
	{
		System.out.println("[Size] ���ÿ��� ���� " + aStackSize + "���� ���Ұ� �ֽ��ϴ�.");
	}
	
	public void outputRemove(char anElement)
	{
		System.out.println("������ ���Ҵ� '" + anElement + "' �Դϴ�.");
	}
	
	public void outputResult(int aNumOfInputChars, int aNumOfIgnoredChars, int aNumOfAddedChars)
	{
		System.out.println("... . . �Էµ� ���ڴ� �� " + aNumOfInputChars +"�� �Դϴ�.");
		System.out.println("... . . ���� ó���� ���ڴ� " + (aNumOfInputChars - aNumOfIgnoredChars) + "�� �Դϴ�.");
		System.out.println("... . . ���õ� ���ڴ� " + aNumOfIgnoredChars + "�� �Դϴ�.");
		System.out.println("... . . ���Ե� ���ڴ� " + aNumOfAddedChars + "�� �Դϴ�.");
	}
}
