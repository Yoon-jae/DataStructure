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
	
	// �Է��Լ�
	public int inputOrder()
	{
		int order;
		System.out.printf("������ �Է��ϼ���: ");
		order = this.inputInt();
		return order;
	}
	
	// ��� �Լ�
	public void outputMessage(MessageID aMessageID)
	{
		switch(aMessageID) {
		
		// Message IDs for Notices:
		case Notice_StartProgram:
			System.out.println("<<<������ Ǯ�̸� �����մϴ�>>>\n");
			break;
		case Notice_EndProgram:
			System.out.println("<������ Ǯ�̸� �����մϴ�> \n");
			break;
					
		default :
			break;
		}
	}
	
	public void outputOrderValidityErrorMessage(OrderValidity anOrderValidity)
	{
		switch(anOrderValidity) {
			case TooSmall:
				System.out.println("����: ������ �ʹ� �۽��ϴ�. 3 ���� ũ�ų� ���ƾ� �մϴ�.\n");
				break;
			case TooLarge:
				System.out.println("����: ������ �ʹ� Ů�ϴ�. 99 ���� �۰ų� ���ƾ� �մϴ�.\n");
				break;
			case NotOddNumber:
				System.out.println("����: ������ ¦���Դϴ�. Ȧ���̾�� �մϴ�.\n");
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
