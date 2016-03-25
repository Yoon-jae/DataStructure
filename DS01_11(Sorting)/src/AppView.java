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
	
	// �Է� �Լ�
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
	// ��� �Լ�
	public void outputMessage(MessageID aMessageID)
	{
		switch(aMessageID) {
		
		// Message IDs for Notices:
		case Notice_StartProgram:
			System.out.println("< ���Ŀ� ���� ���� ���� ���� �˾ƺ��� > \n");
			break;
		case Notice_EndProgram:
			System.out.println("< ���� ������ �����մϴ�. > \n");
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
			System.out.println("[Error] �߸��� �Է��Դϴ�\n");
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
