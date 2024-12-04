package lab7_var7;
/**
 * The MultiplyExpression class represents the multiplication operation in an algebraic expression.
 */
public class MultiplyExpression implements Expression {
	private Expression leftValue;
	private Expression rightValue;

	public MultiplyExpression(Expression leftValue, Expression rightValue) {
		this.leftValue = leftValue;
		this.rightValue = rightValue;
	}


	public String showComponents(String context) {
		return new String("MultiplyExpression(" + leftValue.interpret(context)
				+ "*" + rightValue.interpret(context) + "), "
				+ leftValue.showComponents(context)
				+ rightValue.showComponents(context));
	}

	public int interpret(String context) {
		return leftValue.interpret(context) * rightValue.interpret(context);
	}

}

