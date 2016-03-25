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
	
	public char inputCharacter() // 문자열 중 0번째문자를 받아온다.
	{
		return this.inputString().charAt(0);
	}
	
	// 입력 함수
	
	// 출력 함수
	public void outputMessage(MessageID aMessageID)
	{
		switch(aMessageID) {		
		
		// Message IDs for Notices:
		case Notice_StartProgram:
			System.out.println("<<사전 성능측정 프로그램을 시작합니다>> \n");
			break;
		case Notice_EndProgram:
			System.out.println("\n<<사전 성능측정 프로그램을 종료합니다>>");
			break;
		case Notice_ResultSortedArray:
			System.out.println("<<SortedArray로 구현된 Dictionary의 성능측정 결과>>");
			break;
		case Notice_ResultSortedLinkedList:
			System.out.println("<<SortedLinkedList로 구현된 Dictionary의 성능측정 결과>>");
			break;
		case Notice_ResultBinarySearchTree:
			System.out.println("<<BinarySearchTree로 구현된 Dictionary의 성능측정 결과>>");
			break;
		case Notice_InorderTraverse:
			System.out.print(">>INORDER TRAVERSE : ");
			break;
		case Notice_PreorderTraverse:
			System.out.print(">>PREORDER TRAVERSE : ");
			break;
		case Notice_PostorderTraverse:
			System.out.print(">>POSTORDER TRAVERSE : ");
			break;
		
		// MessageIDs for Errors:
		case Error_WrongMenu:
			System.out.println("[Error] 잘못된 입력입니다\n");
			break;
					
		default :
			break;
	
		}
	}
	
	public void outputResult(int aTestSize, double aTestInsertTime, double aTestSearchTime, double aTestRemoveTime)
	{
		System.out.printf("크기 : %d / 삽입 : %9.1f / 검색 : %9.1f / 삭제 : %9.1f\n",aTestSize,aTestInsertTime,aTestSearchTime,aTestRemoveTime);
	}

	public void outputTraverse(char anObj) {
		System.out.print(anObj + "-");
	}

	public void nextLine() {
		System.out.println();		
	}
	
}
