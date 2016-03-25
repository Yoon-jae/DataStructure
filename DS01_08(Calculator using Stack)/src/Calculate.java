
public class Calculate {
	
	private static final int DEFAULT_MAX_SIZE = 100;
	private ArrayList<Character> _oStack; // 연산자 스택
	private ArrayList<Double> _vStack; // 피연산자(연산값) 스택
	private char[] _infix;
	private char[] _postfix;
	
	public Calculate()
	{
		this._oStack = null;
		this._vStack = null;
		this._infix = null;
		this._postfix = null;
	}
	
	public void setInfix(String anInfix)
	{
		this._infix = anInfix.toCharArray();
	}
	
	public String infix()
	{
		if(this._infix != null) {
			return String.valueOf(this._infix);
		} else
			return null;
	}
	
	public String postfix()
	{
		if(this._postfix != null) {
			return String.valueOf(this._postfix);
		} else
			return null;
	}
	
	public boolean infixToPostfix()
	{
		// infix를 postfix로 변경, 연산자의 우선순위에 유의.
				int i = 0; // string pointer for infix
				int p = 0; // string pointer for postfix
				char currentToken, poppedToken, topToken;

				this._oStack = new ArrayList<Character>(this._infix.length); // OpearndStack
				this._postfix = new char[this._infix.length];

				while (i < this._infix.length) {
					currentToken = this._infix[i++];
					if (this.isDigit(currentToken)) {
						// operand: output to postfix expression
						this._postfix[p++] = currentToken;
					} else { // currentToken은 연산자
						if (currentToken == ')') { // currentToken이 괄호 연산자일때
							if (!this._oStack.isEmpty()) {
								poppedToken = (char) this._oStack.pop();
							} else
								return false;

							while (poppedToken != '(') {
								this._postfix[p++] = poppedToken;
								if (!this._oStack.isEmpty()) {
									poppedToken = (char) this._oStack.pop();
								} else
									return false;
							}
							this.showOStackAll();
						} else { // currentToken이 일반 연산자 일때
							int inComingP = this.inComingPrecedence(currentToken);
							if (!this._oStack.isEmpty()) {
								topToken = (char) this._oStack.peek();
								while (this.inStackPrecedence(topToken) >= inComingP) {
									poppedToken = (char) this._oStack.pop();
									this._postfix[p++] = poppedToken;
									if (!this._oStack.isEmpty())
										topToken = (char) this._oStack.peek();
									else
										break;
								}
							}
							this._oStack.push(currentToken);
							this.showOStackAll();
						}
					}

				}
				while (!_oStack.isEmpty()) {
					poppedToken = (char) _oStack.pop();
					_postfix[p++] = poppedToken;
				}
				return true;
	}
	
	public double evalPostfix()
	{
		int p; // string pointer for postfix
		char curToken;
		this._vStack = new ArrayList<Double>(this._infix.length);

		p = 0;

		while (p < this._postfix.length) {
			curToken = _postfix[p++];
			if (isDigit(curToken)) {
				// Token is an operand: get value and push it into stack.
				this._vStack.push(Double.parseDouble(String.valueOf(curToken)));
				this.showVStackAll();
			} else {
				// Token is an operator.
				// Pop two operands, compute, and push the computed value.

				double operand_1 = this._vStack.pop();
				double operand_2;
				double result = 1;

				if (curToken == '+') {
					operand_2 = this._vStack.pop();
					result = operand_2 + operand_1;
				} else if (curToken == '-') {
					operand_2 = this._vStack.pop();
					result = operand_2 - operand_1;
				} else if (curToken == '*') {
					operand_2 = this._vStack.pop();
					result = operand_2 * operand_1;
				} else if (curToken == '/') {
					operand_2 = this._vStack.pop();
					result = operand_2 / operand_1;
				} else if (curToken == '%') {
					operand_2 = this._vStack.pop();
					result = operand_2 % operand_1;
				} else if (curToken == '^') {
					operand_2 = this._vStack.pop();
					for (int i = 0; i < operand_1; i++) {
						result *= operand_2;
					}
				} else {
					this._vStack.push(operand_1);
					return this._vStack.peek();
				}
				this._vStack.push(result);
				this.showVStackAll();
			}
		}
		// Now, the final result is on top of the stack.
		// pop and return this value.
		return this._vStack.peek();
	}
	
	public void showOStackAll()
	{
		System.out.println("OStack: ");
		for(int index = 0; index < this._oStack.size(); index++) {
			System.out.print(this._oStack.elementAt(index) + " ");
		}
		System.out.println();
	}
	
	public void showVStackAll()
	{
		System.out.println("VStack: ");
		for(int index = 0; index < this._vStack.size(); index++) {
			System.out.print(this._vStack.elementAt(index) + " ");
		}
		System.out.println();
	}
	
	private boolean isDigit(char aToken)
	{
		if('0' <= aToken && aToken <= '9') {
			return true;
		} else {
			return false;
		}
	}
	
	private int inComingPrecedence(char aToken)
	{
		if(aToken == '+')
			return 12;
		else if (aToken == '-')
			return 12;
		else if (aToken == '(')
			return 20;
		else if (aToken == ')')
			return 19;
		else if (aToken == '*')
			return 13;
		else if (aToken == '/')
			return 13;
		else if (aToken == '%')
			return 13;
		else if (aToken == '^')
			return 17;
		else if (aToken == '$')
			return 0;
		else
			return -1;
	}
	
	private int inStackPrecedence(char aToken)
	{
		if(aToken == '+')
			return 12;
		else if (aToken == '-')
			return 12;
		else if (aToken == '(')
			return 0;
		else if (aToken == ')')
			return 19;
		else if (aToken == '*')
			return 13;
		else if (aToken == '/')
			return 13;
		else if (aToken == '%')
			return 13;
		else if (aToken == '^')
			return 16;
		else if (aToken == '$')
			return 0;
		else
			return -1;
	}
}
