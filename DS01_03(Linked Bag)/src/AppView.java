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
			System.out.println("<<동전 가방 프로그램을 시작합니다>> \n");
			break;
		case Notice_EndProgram:
			System.out.println("<<동전 가방 프로그램을 종료합니다>> \n");
			break;
		case Notice_Menu:
			System.out.println("수행하려고하는 메뉴를 선택하세요  \n" + "(add: 1, remove: 2, print: 3, search: 4, removeAny: 5, exit: 9)");
			break;
		case Notice_EndMenu:
			System.out.println("9가 입력되어 종료합니다. \n");
			break;
		case Notice_InputCoin:
			System.out.println("코인의 액수를 입력하세요: ");
			break;
			
		
		// MessageIDs for Errors:
		case Error_WrongMenu:
			System.out.println("[Error] 잘못된 메뉴입니다.\n");
			break;
		case Error_Empty:
			System.out.println("[Error] 빈 상태 입니다.\n");
			break;
		case Error_Full:
			System.out.println("[Error] 꽉 찬 상태 입니다.\n");
			break;
		case Error_DoesNotContain:
			System.out.println("[Error] 해당 동전은 존재하지 않습니다.\n");
			break;
					
		default :
			break;
	
		}
	}
	
	public void outputRemove(int removedCoin)
	{
		System.out.println("삭제된 코인: " + removedCoin);
	}
	
	public void outputResult(int aTotalCoinSize, int aMaxCoinValue, int aSumOfCoinValue)
	{
		System.out.println("총 코인: " + aTotalCoinSize + "\n가장 큰 코인: " + aMaxCoinValue + "\n코인의 합: " + aSumOfCoinValue + "\n");
	}
	
	public void outputSearch(int aSearchValue, int aSearchedSize)
	{
		System.out.println(aSearchValue + "코인은 " + aSearchedSize + "개 존재합니다.\n");
	}
	
}
