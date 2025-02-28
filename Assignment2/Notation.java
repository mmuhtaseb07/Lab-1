package assignment2;

public class Notation {
	
	private static MyQueue<String> queue;
	private static MyStack<String> stack;
	
	public Notation() {
		queue = new MyQueue<>();
		stack = new MyStack<>();

	}
	
	// Evaluates a postfix expression from a string to a double
	public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException{
	
		// empty queue
		while(!queue.isEmpty()) {
			queue.dequeue();
		}
		
		// empty stack
		while(!stack.isEmpty()) {
			stack.pop();
		}
		
		for(int i = 0; i < postfixExpr.length(); i++) {
			char currentChar = postfixExpr.charAt(i);
			String currentStr = String.valueOf(currentChar);
			
			// if character is space then ignore
			if(Character.isSpaceChar(currentChar)) {
				continue;
			}
			// if character is digit then add to stack
			else if(Character.isDigit(currentChar) || currentChar == '(') {
				try {
					stack.push(currentStr);
				}
				catch(StackOverflowException e) {
					System.out.println(e.getMessage());
				}
			}
			// if character is an operator
			else if(currentChar == '*' || currentChar == '/' || currentChar == '+' || currentChar == '-') {
				// pop 2 first values from the stack
				try {
					double right = Double.parseDouble(stack.pop());
					double left = Double.parseDouble(stack.pop());	
					double result = 0;
					
					switch(currentChar) {
						case '*':
							result = left * right;
							break;
							
						case '/':
							result = left / right;
							break;
							
						case '+':
							result = left + right;
							break;
							
						case '-':
							result = left - right;
							break;
					}

					stack.push(String.valueOf(result));
				}
				catch(StackUnderflowException e) {
					throw new InvalidNotationFormatException();
				}
				catch(StackOverflowException e) {
					System.out.println(e.getMessage());
				}
			}
				
		}
		
		// return result 
		if(stack.size() == 1) {
			return Double.parseDouble(stack.pop());
		}
		else {
			throw new InvalidNotationFormatException();
		}
	}
	
	// Converts the postfix expression to the Infix expression
	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException{
		
		// empty queue
		while(!queue.isEmpty()) {
			queue.dequeue();
		}
		
		// empty stack
		while(!stack.isEmpty()) {
			stack.pop();
		}
		
		
		for(int i = 0; i < postfix.length(); i++) {
			char currentChar = postfix.charAt(i);
			String currentStr = String.valueOf(currentChar);
			
			// if character is space then ignore
			if(Character.isSpaceChar(currentChar)) {
				continue;
			}
			// if character is digit then add to stack
			else if(Character.isDigit(currentChar)) {
				try {
					stack.push(currentStr);
				}
				catch(StackOverflowException e) {
					System.out.println(e.getMessage());
				}
			}
			// if character is an operator
			else if(currentChar == '*' || currentChar == '/' || currentChar == '+' || currentChar == '-') {
				// pop 2 first values from the stack and add to string
				try {
					String first = stack.pop();
					String second = stack.pop();
					
					String values = "(" + second + " " + currentChar + " " + first + ")";
					stack.push(values);
				}
				catch(StackUnderflowException e) {
					throw new InvalidNotationFormatException();
				}
				catch(StackOverflowException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		
		// return infix 
		if(stack.size() == 1) {
			return stack.toString();
		}
		else {
			throw new InvalidNotationFormatException();
		}
	}
	
	// Converts an infix expression into a postfix expression
	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException{
		
		// empty queue 
		while(!queue.isEmpty()) {
			queue.dequeue();
		}
		
		// empty stack
		while(!stack.isEmpty()) {
			stack.pop();
		}
		
		
		for(int i = 0; i < infix.length(); i++) {
			char currentChar = infix.charAt(i);
			String currentStr = String.valueOf(currentChar);
			
			// if character is space then ignore
			if(Character.isSpaceChar(currentChar)) {
				continue;
			}
			// if character is digit then add to queue
			else if(Character.isDigit(currentChar)) {
				try {
					queue.enqueue(currentStr);
				}
				catch(QueueOverflowException e) {
					System.out.println(e.getMessage());
				}
			}
			// if character is a left parenthesis then add to stack
			else if(currentChar == '(') {
				try {
					stack.push(currentStr);
				}
				catch(StackOverflowException e) {
					System.out.println(e.getMessage());
				}
			}
			// if character is a multiplication or division operator
			else if(currentChar == '*' || currentChar == '/') {
				
				// pops higher/equal priority operators from stack and adds them to queue
				while(!stack.isEmpty() && (stack.top().equals("*") || stack.top().equals("/"))) {
					queue.enqueue(stack.pop());
				}
				// push current character into stack
				try {
					stack.push(currentStr);
				}
				catch(StackOverflowException e) {
					System.out.println(e.getMessage());
				}

			}
			// if character is addition or subtraction operator
			else if(currentChar == '+' || currentChar == '-') {
				
				// pops higher/equal priority operators from stack and adds them to queue
				while(!stack.isEmpty() && (stack.top().equals("*") || stack.top().equals("/") || stack.top().equals("+") ||stack.top().equals("-"))) {
					queue.enqueue(stack.pop());
				}
				// push current character into stack
				try {
					stack.push(currentStr);
				}
				catch(StackOverflowException e) {
					System.out.println(e.getMessage());
				}

			}
			// if character is right parenthesis
			else if(currentChar == ')') {
				
				// pops operators from stack until empty or left parenthesis found and adds them to queue
				while(!stack.isEmpty() && !stack.top().equals("(")) {
					queue.enqueue(stack.pop());
				}
				// deals with left parenthesis
				if(!stack.isEmpty() && stack.top().equals("(")) {
					stack.pop();
				}
				else {
					throw new InvalidNotationFormatException();
				}
	
			}
				
		}
		
		// pop any leftovers and add to the queue
		while(!stack.isEmpty()) {
			queue.enqueue(stack.pop());
		}
		
		// return postfix 
		return queue.toString();
	}
	
}
