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
	
	// 입력함수
	public int inputOrder()
	{
		int order;
		System.out.printf("차수를 입력하세요: ");
		order = this.inputInt();
		return order;
	}
	
	// 출력 함수
	public void outputMessage(MessageID aMessageID)
	{
		switch(aMessageID) {
		
		// Message IDs for Notices:
		case Notice_StartProgram:
			System.out.println("<<<마방진 풀이를 시작합니다>>>\n");
			break;
		case Notice_EndProgram:
			System.out.println("<마방진 풀이를 종료합니다> \n");
			break;
					
		default :
			break;
		}
	}
	
	public void outputOrderValidityErrorMessage(OrderValidity anOrderValidity)
	{
		switch(anOrderValidity) {
			case TooSmall:
				System.out.println("오류: 차수가 너무 작습니다. 3 보다 크거나 같아야 합니다.\n");
				break;
			case TooLarge:
				System.out.println("오류: 차수가 너무 큽니다. 99 보다 작거나 같아야 합니다.\n");
				break;
			case NotOddNumber:
				System.out.println("오류: 차수가 짝수입니다. 홀수이어야 합니다.\n");
				break;
			default:
				break;
		}
	}
	
	public void outputTitleWithOrder(int anOrder)
	{
		System.out.println("Magic Square Board : Order " + anOrder);
	}
	
	public void outputRowNumber(int aRowNumber)
	{
		System.out.printf("[%4d] ", aRowNumber);
	}
	
	public void outputColNumber(int aColNumber)
	{
		System.out.printf("[%4d]", aColNumber);
	}
	
	public void outputCell(int anElement)
	{
		System.out.printf(" %4d ", anElement);
	}
	
	public void outputNextLine()
	{
		System.out.println("");
	}
	
	public void outputSpace()
	{
		System.out.print("      ");
	}
	
}
