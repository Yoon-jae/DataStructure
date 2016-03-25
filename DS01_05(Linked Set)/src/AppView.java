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
	
	// 출력 함수
	public void outputMessage(MessageID aMessageID)
	{
		switch(aMessageID) {		
		
		// Message IDs for Notices:
		case Notice_StartProgram:
			System.out.println("< 별의 집합을 시작합니다 > \n");
			break;
		case Notice_EndProgram:
			System.out.println("< 별의 집합을 종료합니다 > \n");
			break;
		case Notice_Menu:
			System.out.println("1:입력   2:주어진 별 삭제   3:임의의 별 삭제    \n4:출력   5:이름으로 검색   6:좌표로 검색   9:종료");
			break;
		case Notice_EndMenu:
			System.out.println("");
			break;
		case Notice_InputStar:
			System.out.println("- [입력] - ");
			break;
		case Notice_InputStarName:
			System.out.println("- 별의 이름을 입력하세요 : ");
			break;
		case Notice_InputStarXCoordinate:
			System.out.println("- x좌표를 입력하세요 : ");
			break;
		case Notice_InputStarYCoordinate:
			System.out.println("- y좌표를 입력하세요 : ");
			break;
		case Notice_RemoveStar:
			System.out.println("- [주어진 별 삭제] - ");
			break;
		case Notice_RemoveRandomStar:
			System.out.println("- [임의의 별 삭제] - ");
			break;
		case Notice_Show:
			System.out.println("- [출력] - ");
			break;
		case Notice_SearchByName:
			System.out.println("- [이름으로 검색] - ");
			break;
		case Notice_SearchByCoordinate:
			System.out.println("- [좌표로 검색] - ");
			break;
			
		// MessageIDs for Errors:
		case Error_WrongMenu:
			System.out.println("[Error] 잘못된 메뉴 입력입니다.\n");
			break;
		case Error_Input:
			System.out.println("[Error] 잘못된 입력입니다.\n");
			break;
		case Error_Remove:
			System.out.println("[Error] 해당 별이 존재하지 않습니다.\n");
			break;
					
		default :
			break;
	
		}
	}
	
	public void showStar(String aStarName, int aX, int aY)
	{
		System.out.println("X 좌표: " + aX + "\nY 좌표 : " + aY + "\n별의 이름 : " + aStarName);
	}
	
	public void showExistence(String aStarName, int aX, int aY)
	{
		if(aStarName == null && (aX != '\0' && aY != '\0')) {
			System.out.printf("(%d,%d) 위치에 별이 존재합니다.\n", aX, aY);
		} else if(aStarName != null && (aX == '\0' && aY == '\0')) {
			System.out.println(aStarName + " 별이 존재합니다.");
		} else {
			System.out.println("원하는 별이 존재하지 않습니다.");
		}
	}
	
	public void showNumOfStars(int aStarCollectorSize)
	{
		System.out.println(aStarCollectorSize + "개의 별이 존재합니다.");
	}
	
}
