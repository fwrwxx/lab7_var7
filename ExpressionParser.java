package lab7_var7;
/**
 * The ExpressionParser class is responsible for transforming infix expressions into an alternative
 * postfix form, parsing the postfix expression to build a syntax tree, and providing access to the
 * syntax tree.
 */
import java.util.Stack;

public class ExpressionParser {
	private Expression syntaxTree;
	private String alternateForm;


	public ExpressionParser(String expression) {
		this.transformToAlternative(expression);
		this.parse();
	}

	private int precedCheck(char oper) {
		switch (oper) {
		case ('*'):
			return 2;
		case ('/'):
			return 2;
		case ('+'):
			return 1;
		case ('-'):
			return 1;
		}
		return 0;
	}


	private void transformToAlternative(String sentance) {
		Stack<String> stack = new Stack<String>();
		StringBuilder build = new StringBuilder();

		for (int i = 0; i < sentance.length(); i++) {
			char temp = sentance.charAt(i);
			boolean expr = (temp != '(') && (temp != ')') && (temp != '+')
					&& (temp != '-') && (temp != '*') && (temp != '/');
			if (expr == true) {
				build.append(sentance.charAt(i));
				build.append(" ");
			} else {
				if (stack.isEmpty())
					stack.push(String.valueOf(temp));
				else {
					String buf = stack.peek();

					if ((temp != '(')
							&& (temp != ')')
							&& (this.precedCheck(buf.charAt(0)) > this
									.precedCheck(temp))) {

						build.append(stack.pop());
						build.append(" ");
						stack.push(String.valueOf(temp));
					}

					else if ((temp != '(')
							&& (temp != ')')
							&& (this.precedCheck(buf.charAt(0)) < this
									.precedCheck(temp))) {
						stack.push(String.valueOf(temp));
					}

					else if (temp == '(') {
						stack.push(String.valueOf(temp));
					}

					else if (temp == ')') {
						while (stack.peek().compareTo("(") != 0) {
							build.append(stack.pop());
							build.append(" ");
						}
						stack.pop();
					}

					else
						stack.push(String.valueOf(temp));
				}
			}
		}
		if (!stack.isEmpty()) {
			while (!stack.isEmpty()) {
				build.append(stack.pop());
				build.append(" ");
			}
		}
		alternateForm = build.toString();
	}


	private void parse() {
		Stack<Expression> stack = new Stack<Expression>();
		for (String token : alternateForm.split(" ")) {
			if (token.equals("+")) {
				Expression subExpr = new SummaryExpression(stack.pop(),
						stack.pop());
				stack.push(subExpr);
			}

			else if (token.equals("-")) {
				Expression rightExpr = stack.pop();
				Expression leftExpr = stack.pop();
				Expression subExpr = new SubtractionExpression(leftExpr,
						rightExpr);
				stack.push(subExpr);
			}

			else if (token.equals("*")) {
				Expression subExpr = new MultiplyExpression(stack.pop(),
						stack.pop());
				stack.push(subExpr);
			}

			else if (token.equals("/")) {
				Expression rightExpr = stack.pop();
				Expression leftExpr = stack.pop();
				Expression subExpr = new DivideExpression(leftExpr, rightExpr);
				stack.push(subExpr);
			} else {
				Expression num = new Value(token);
				stack.push(num);
			}
		}

		syntaxTree = stack.pop();
	}

	public Expression getSyntaxTree() {
		return syntaxTree;
	}


	public String getAlternate() {
		return alternateForm;
	}
}
