import java.util.Scanner;


public class AppView {
	private Scanner _scanner;
	
	
	// 생성자
	public AppView()
	{
		this._scanner = new Scanner(System.in);
	}
	
	// 기본 입력 함수
	public int inputInt() // 문자를 숫자형으로 바꿔서 받아온다.
	{
		//return this._scanner.nextInt();
		return Integer.parseInt(this._scanner.nextLine());
	}
	
	public String inputString() // 문자열 한 줄을 모두 받아온다.
	{
		return this._scanner.nextLine();
	}
	
	// 입력 함수	
	public char inputCharacter() // 문자열 중 0번째문자를 받아온다.
	{
		char element;
		System.out.println("- 문자를 입력하시오: ");
		element = this.inputString().charAt(0);
		return element;
	}
	
	// 출력 함수
	public void outputMessage(MessageID aMessageID)
	{
		switch(aMessageID) {
		
		// Message IDs for Notices:
		case Notice_StartProgram:
			System.out.println("> 프로그램을 시작합니다.");
			break;
		case Notice_EndProgram:
			System.out.println("\n> 프로그램을 종료합니다.");
			break;
		case Notice_StartMenu:
			System.out.println("[스택 사용을 시작합니다.]");
			break;
		case Notice_EndMenu:
			System.out.println("[스택 사용을 종료합니다.]");
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
			System.out.println("[Error] 잘못된 입력입니다.");
			break;
		case Error_InputFull:
			System.out.println("[Full] 스택이 꽉 차서 삽입이 불가능합니다.");
			break;
		case Error_RemoveEmpty:
			System.out.println("[Empty] 스택에 삭제할 원소가 없습니다.");
			break;
		case Error_Empty:
			System.out.println("[Empty] 스택이 비어있습니다.");
			break;			
			
		default :
			break;
	
		}
	}
	
	public void outputAddedElement(char anElement)
	{
		System.out.println("[Push] 삽입된 원소는 '" + anElement + "' 입니다.");
	}
	
	public void outputStackElement(char anElement)
	{
		System.out.print(anElement + " ");
	}
	
	public void outputTopElement(char anElement)
	{
		System.out.println("[Top] Top 원소는 '" + anElement + "' 입니다.");
	}
	
	public void outputStackSize(int aStackSize)
	{
		System.out.println("[Size] 스택에는 현재 " + aStackSize + "개의 원소가 있습니다.");
	}
	
	public void outputRemove(char anElement)
	{
		System.out.println("삭제된 원소는 '" + anElement + "' 입니다.");
	}
	
	public void outputResult(int aNumOfInputChars, int aNumOfIgnoredChars, int aNumOfAddedChars)
	{
		System.out.println("... . . 입력된 문자는 총 " + aNumOfInputChars +"개 입니다.");
		System.out.println("... . . 정상 처리된 문자는 " + (aNumOfInputChars - aNumOfIgnoredChars) + "개 입니다.");
		System.out.println("... . . 무시된 문자는 " + aNumOfIgnoredChars + "개 입니다.");
		System.out.println("... . . 삽입된 문자는 " + aNumOfAddedChars + "개 입니다.");
	}
}
