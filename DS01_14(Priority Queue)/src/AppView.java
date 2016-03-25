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
	
	public char inputChar() // 문자열 중 0번째문자를 받아온다.
	{
		return this.inputString().charAt(0);
	}
	
	// 입력 함수

	public int inputNumber() {
		System.out.print("- 삽입할 정수값을 입력하시오: ");
		return this.inputInt();
	}
	
	public char inputCharacter() // 문자열 중 0번째문자를 받아온다.
	{
		char element;
		System.out.println("[다음 중 해야 할 일의 코드를 선택하시오]");
		System.out.println("i : 입력\nm : 최대값 보기\nd : 최대값 삭제\nv : Priority Queue 내용 보기\nx : 모든 원소 차례대로 삭제하여 출력\nr : 난수를 생성하여 10개 입력\nn : 원소의 개수 보기\nq : 프로그램 종료");
		System.out.print("? 해야 할 일의 코드를 치시오: ");
		element = this.inputChar();
		return element;
	}
	

	public void outputAdd(@SuppressWarnings("rawtypes") Comparable anElement)
	{
		System.out.println(anElement + " 원소가 정상적으로 입력 되었습니다.\n");
	}
	
	public void outputSize(int size)
	{
		System.out.println("- Priority Queue에는 " + size +"개의 원소가 들어 있습니다.\n");
	}
	
	public void outputElement(@SuppressWarnings("rawtypes") Comparable anElement)
	{
		System.out.print(" " + anElement + " ");
	}
	
	public void outputRemoveMax(int anElement)
	{
		System.out.println("최대값 " + anElement + " 원소가 삭제 되었습니다.\n");
	}
	
	public void outputMax(int anElement)
	{
		System.out.println("- Priority Queue의 최대값 원소는 " + anElement + "입니다.\n");
	}
	
	// 출력 함수
	public void outputMessage(MessageID aMessageID)
	{
		switch(aMessageID) {
		
		// Message IDs for Notices:
		case Notice_StartProgram:
			System.out.println("< 우선순위 큐를 시작합니다> \n");
			break;
		case Notice_EndProgram:
			System.out.println("< 우선순위 큐를 종료합니다> \n");
			break;
		case Notice_Menu:
			System.out.println("Notice_Menu");
			break;
		case Notice_RandomAdd:
			System.out.println("- 임의의 원소가 10개 입력되었습니다. \n");
			break;
		case Notice_ShowStart:
			System.out.println("= Priority Queue의 내용");
			break;
		case Notice_ShowEnd:
			System.out.println("\n");
			break;
		case Notice_StartRemoveAll:
			System.out.println("= 삭제된 원소들 =");
			break;
		case Notice_EndRemoveAll:
			System.out.println("= 삭제 종료 = Priority Queue는 비었습니다.\n");
			break;
		
		// MessageIDs for Errors:
		case Error_WrongMenu:
			System.out.println("[Error] 잘못된 입력입니다\n");
			break;
		case Error_InputFull:
			System.out.println("[Error] 큐가 가득 찬 상태 입니다.\n");
			break;
		case Error_Empty:
			System.out.println("[Error] 큐가 빈 상태 입니다.\n");
			break;
					
		default :
			break;
	
		}
	}
	
}
