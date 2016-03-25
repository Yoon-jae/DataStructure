import java.util.Scanner;


public class AppView {
	private Scanner _scanner;
	
	
	// 생성자
	public AppView()
	{
		this._scanner = new Scanner(System.in);
	}
	
	// 기본 입력 함수
	public int inputNumber() // 문자를 숫자형으로 바꿔서 받아온다.
	{
		//return this._scanner.nextInt();
		System.out.print("숫자를 입력하시오 : ");
		return Integer.parseInt(this._scanner.nextLine());
	}
	
	public String inputString() // 문자열 한 줄을 모두 받아온다.
	{
		return this._scanner.nextLine();
	}
	
	public char inputCharacter() // 문자열 중 0번째문자를 받아온다.
	{
		System.out.print("> 문자를 입력하시오 : ");
		return this.inputString().charAt(0);
	}
	
	// 입력 함수
	
	// 출력 함수
	public void outputMessage(MessageID aMessageID)
	{
		switch(aMessageID) {
		
		// Message IDs for Notices:
		case Notice_StartProgram:
			System.out.println("<리스트를 시작합니다>");
			break;
		case Notice_EndProgram:
			System.out.println("리스트를 종료합니다>");
			break;
		case Notice_Reset:
			System.out.println("- 리스트를 비웠습니다.");
			break;
		case Notice_ShowStartList:
			System.out.print("[List]");
			break;
		case Notice_ShowEndList:
			System.out.println("");
			break;
		
		// MessageIDs for Errors:
		case Error_WrongMenu:
			System.out.println("[Error] 잘못된 입력입니다\n");
			break;
		case Error_InputFull:
			System.out.println("[Error] 가득 찬 상태 입니다.\n");
			break;
		case Error_Empty:
			System.out.println("[Error] 빈 상태 입니다.\n");
			break;
					
		default :
			break;
	
		}
	}
	
	public void outputSize(int size)
	{
		System.out.println("[Length] 리스트에는 현재 " + size + "개가 있습니다.");
	}
	
	public void outputAdd(int anElement)
	{
		System.out.println("[Insert] 삽입된 원소는 " + anElement + "입니다.");
	}
	
	public void outputRemove(int anElement)
	{
		System.out.println("[Delete] 삭제된 원소는 " + anElement + "입니다.");
	}
	
	public void outputElement(int anElement)
	{
		System.out.print(anElement + " ");
	}
	
}
