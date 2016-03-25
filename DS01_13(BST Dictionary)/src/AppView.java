import java.util.Scanner;


public class AppView {
	private Scanner _scanner;
	
	
	// ������
	public AppView()
	{
		this._scanner = new Scanner(System.in);
	}
	
	// �⺻ �Է� �Լ�
	public int inputInt() // ���ڸ� ���������� �ٲ㼭 �޾ƿ´�.
	{
		//return this._scanner.nextInt();
		return Integer.parseInt(this._scanner.nextLine());
	}
	
	public String inputString() // ���ڿ� �� ���� ��� �޾ƿ´�.
	{
		return this._scanner.nextLine();
	}
	
	public char inputCharacter() // ���ڿ� �� 0��°���ڸ� �޾ƿ´�.
	{
		return this.inputString().charAt(0);
	}
	
	// �Է� �Լ�
	
	// ��� �Լ�
	public void outputMessage(MessageID aMessageID)
	{
		switch(aMessageID) {		
		
		// Message IDs for Notices:
		case Notice_StartProgram:
			System.out.println("<<���� �������� ���α׷��� �����մϴ�>> \n");
			break;
		case Notice_EndProgram:
			System.out.println("\n<<���� �������� ���α׷��� �����մϴ�>>");
			break;
		case Notice_ResultSortedArray:
			System.out.println("<<SortedArray�� ������ Dictionary�� �������� ���>>");
			break;
		case Notice_ResultSortedLinkedList:
			System.out.println("<<SortedLinkedList�� ������ Dictionary�� �������� ���>>");
			break;
		case Notice_ResultBinarySearchTree:
			System.out.println("<<BinarySearchTree�� ������ Dictionary�� �������� ���>>");
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
			System.out.println("[Error] �߸��� �Է��Դϴ�\n");
			break;
					
		default :
			break;
	
		}
	}
	
	public void outputResult(int aTestSize, double aTestInsertTime, double aTestSearchTime, double aTestRemoveTime)
	{
		System.out.printf("ũ�� : %d / ���� : %9.1f / �˻� : %9.1f / ���� : %9.1f\n",aTestSize,aTestInsertTime,aTestSearchTime,aTestRemoveTime);
	}

	public void outputTraverse(char anObj) {
		System.out.print(anObj + "-");
	}

	public void nextLine() {
		System.out.println();		
	}
	
}
