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
	
	// 입력 함수

	// 출력 함수
	public void outputMessage(MessageID aMessageID)
	{
		switch(aMessageID) {		
		
		// Message IDs for Notices:
		case Notice_StartProgram:
			System.out.println("< List의 구현에 따른 실행 성능 차이 알아보기 >");
			break;
		case Notice_EndProgram:
			System.out.println("< 성능 측정을 종료합니다 > \n");
			break;
		case Notice_UnsortedArrayStart:
			System.out.println("[Unsorted Array]");
			break;
		case Notice_SortedArrayStart:
			System.out.println("[Sorted Array]");
			break;
		case Notice_UnsortedLinkedStart:
			System.out.println("[Unsorted Linked Chain]");
			break;
		case Notice_SortedLinkedStart:
			System.out.println("[Sorted Linked Chain]");
			break;
					
		// MessageIDs for Errors:
		case Error_WrongMenu:
			System.out.println("[Error] 잘못된 입력입니다\n");
			break;
					
		default :
			break;
	
		}
	}
	
	public void outputResult(int aTestSize, long aTestInsertTime, long aTestFindMaxTime)
	{
		System.out.printf("크기: %4d   삽입하기: %8d   최대값찾기 : %8d\n", aTestSize, aTestInsertTime, aTestFindMaxTime);
	}
	
}
