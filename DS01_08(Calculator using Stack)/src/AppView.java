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
	public String inputExpression()
	{
		System.out.println("> ������ �Է��Ͻÿ�: ");
		return this.inputString();
	}

	
	// ��� �Լ�
	public void outputMessage(MessageID aMessageID)
	{
		switch(aMessageID) {
		
		// Message IDs for Notices:
		case Notice_StartProgram:
			System.out.println(":: ���α׷��� �����մϴ� ::");
			break;
		case Notice_EndProgram:
			System.out.println(":: ���α׷��� �����մϴ� ::");
			break;
		case Notice_StartMenu:
			System.out.println("[���� �Է��� �����մϴ�]");
			break;
		case Notice_EndMenu:
			System.out.println("[���� �Է��� �����մϴ�]");
			break;
		case Notice_InfixToPostfix:
			System.out.println("[Infix�� Postfix��]");
			break;

		// MessageIDs for Errors:
		case Error_Input:
			System.out.println("[Error] �߸��� �Է��Դϴ�.");
			break;
			
		default :
			break;
	
		}
	}
	
	public void outputResult(double aValue)
	{
		System.out.printf("\n[������] %.1f\n\n",aValue);
	}
	
	public void outputPostfix(String aPostfix)
	{
		System.out.printf("\n[Postfix] %s\n",aPostfix);
	}
}
