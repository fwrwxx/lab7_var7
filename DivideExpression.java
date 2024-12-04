package lab7_var7;
/**
 * The DivideExpression class represents the division operation in an algebraic expression.
 */
public class DivideExpression implements Expression {
	private Expression leftValue;
	private Expression rightValue;

	public DivideExpression(Expression leftValue, Expression rightValue) {
		this.leftValue = leftValue;
		this.rightValue = rightValue;
	}

	public String showComponents(String context) {
		return new String("DivideExpression(" + leftValue.interpret(context)
				+ "/" + rightValue.interpret(context) + "), "
				+ leftValue.showComponents(context)
				+ rightValue.showComponents(context));
	}

	public int interpret(String context) {
		return leftValue.interpret(context) / rightValue.interpret(context);
	}

}
