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
	public int inputMaxDataSize()
	{
		int maxDataSize;
		System.out.print("Insert Max Data Size >> ");
		maxDataSize = this.inputInt();
		return maxDataSize;
	}

	public int inputDataTerm()
	{
		int maxDataTerm;
		System.out.print("Insert Data Term >> ");
		maxDataTerm = this.inputInt();
		return maxDataTerm;
	}
	
	public int inputSortType()
	{
		int sortType;
		System.out.print("Select a Sort Type >> ");
		sortType = this.inputInt();
		return sortType;
	}
	// 출력 함수
	public void outputMessage(MessageID aMessageID)
	{
		switch(aMessageID) {
		
		// Message IDs for Notices:
		case Notice_StartProgram:
			System.out.println("< 정렬에 따른 실행 성능 차이 알아보기 > \n");
			break;
		case Notice_EndProgram:
			System.out.println("< 성능 측정을 종료합니다. > \n");
			break;
		case Notice_Menu:
			System.out.println("[1] Sequential Data\n[2] Reverse Data\n[3] Random Data\n[4] End");
			break;
		case Notice_SequentialData:
			System.out.println("=== Sequential Data ===");
			break;
		case Notice_ReverseData:
			System.out.println("=== Reverse Data ===");
			break;
		case Notice_RandomData:
			System.out.println("=== Random Data ===");
			break;
		case Notice_ShowTitle:
			System.out.println("DataSize         Insertion        Quick            Selection        Bubble         ");
			break;
		
		// MessageIDs for Errors:
		case Error_WrongMenu:
			System.out.println("[Error] 잘못된 입력입니다\n");
			break;

		default :
			break;
	
		}
	}
	
	public void outputResult(int dataSize, double insertionSortDuration, double quickSortDuration, double selectionSortDuration, double bubbleSortDuration)
	{
		System.out.printf("[%7d]        [%10.2f]     [%10.2f]     [%10.2f]     [%10.2f]\n", dataSize, insertionSortDuration, quickSortDuration, selectionSortDuration, bubbleSortDuration);
	}
	
}
