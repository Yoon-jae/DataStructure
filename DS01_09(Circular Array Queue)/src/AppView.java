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
			System.out.println("> 프로그램을 종료합니다.");
			break;
		case Notice_StartMenu:
			System.out.println("[큐 입력을 시작합니다.]");
			break;
		case Notice_EndMenu:
			System.out.println("[큐 입력을 종료합니다.]");
			break;
		case Show_QueueStart:
			System.out.print("[Queue] <Front> ");
			break;
		case Show_QueueEnd:
			System.out.println("<Rear>");
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
	
	public void outputAdd(char anElement)
	{
		System.out.println("[EnQueue] 삽입된 원소는 " + anElement + "입니다.");
	}
	
	public void outputElement(char anElement)
	{
		System.out.print(anElement + " ");
	}
	
	public void outputFrontElement(char anElement)
	{
		System.out.println("[Front] 맨 앞 원소는 " + anElement + "입니다.");
	}
	
	public void outputQueueSize(int aQueueSize)
	{
		System.out.println("[Size] 큐에는 현재 " + aQueueSize + "개의 원소가 있습니다.");
	}
	
	public void outputRemove(char anElement)
	{
		System.out.println("[DeQueue] 삭제된 원소는 " + anElement + "입니다.");
	}
	
	public void outputRemoveN(int aNumOfCharsToBeRemoved)
	{
		System.out.println(aNumOfCharsToBeRemoved + "개의 원소를 삭제하려고 합니다.");
	}
	
	public void outputResult(int aNumOfInputChars, int aNumOfIgnoredChars, int aNumOfAddedChars)
	{
		System.out.println("... . . 입력된 문자는 총 " + aNumOfInputChars +"개 입니다.");
		System.out.println("... . . 정상 처리된 문자는 " + (aNumOfInputChars - aNumOfIgnoredChars) + "개 입니다.");
		System.out.println("... . . 무시된 문자는 " + aNumOfIgnoredChars + "개 입니다.");
		System.out.println("... . . 삽입된 문자는 " + aNumOfAddedChars + "개 입니다.");
	}
}
