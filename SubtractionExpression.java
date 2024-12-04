package lab7_var7;
/**
 * The SubtractionExpression class represents the subtraction operation in an algebraic expression.
 */
public class SubtractionExpression implements Expression {
	private Expression leftValue;
	private Expression rightValue;

	public SubtractionExpression(Expression leftValue, Expression rightValue) {
		this.leftValue = leftValue;
		this.rightValue = rightValue;
	}

	public String showComponents(String context) {
		return new String("SubtractionExpression("
				+ leftValue.interpret(context) + "-"
				+ rightValue.interpret(context) + "), "
				+ leftValue.showComponents(context)
				+ rightValue.showComponents(context));
	}

	public int interpret(String context) {
		return leftValue.interpret(context) - rightValue.interpret(context);
	}

}
