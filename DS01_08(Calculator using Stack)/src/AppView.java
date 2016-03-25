import java.util.Scanner;


public class AppView {
	private Scanner _scanner;
	
	
	// 생성자
	public AppView()
	{
		this._scanner = new Scanner(System.in);
	}
	
	// 기본 입력 함수
	public String inputString() // 문자열 한 줄을 모두 받아온다.
	{
		return this._scanner.nextLine();
	}
	
	// 입력 함수
	public String inputExpression()
	{
		System.out.println("> 수식을 입력하시오: ");
		return this.inputString();
	}

	
	// 출력 함수
	public void outputMessage(MessageID aMessageID)
	{
		switch(aMessageID) {
		
		// Message IDs for Notices:
		case Notice_StartProgram:
			System.out.println(":: 프로그램을 시작합니다 ::");
			break;
		case Notice_EndProgram:
			System.out.println(":: 프로그램을 종료합니다 ::");
			break;
		case Notice_StartMenu:
			System.out.println("[수식 입력을 시작합니다]");
			break;
		case Notice_EndMenu:
			System.out.println("[수식 입력을 종료합니다]");
			break;
		case Notice_InfixToPostfix:
			System.out.println("[Infix를 Postfix로]");
			break;

		// MessageIDs for Errors:
		case Error_Input:
			System.out.println("[Error] 잘못된 입력입니다.");
			break;
			
		default :
			break;
	
		}
	}
	
	public void outputResult(double aValue)
	{
		System.out.printf("\n[최종값] %.1f\n\n",aValue);
	}
	
	public void outputPostfix(String aPostfix)
	{
		System.out.printf("\n[Postfix] %s\n",aPostfix);
	}
}
