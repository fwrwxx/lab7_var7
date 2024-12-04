package lab7_var7;
/**
 * The SummaryExpression class represents the addition operation in an algebraic expression.
 */
public class SummaryExpression implements Expression {
	private Expression leftValue;
	private Expression rightValue;

	public SummaryExpression(Expression leftValue, Expression rightValue) {
		this.leftValue = leftValue;
		this.rightValue = rightValue;
	}


	public String showComponents(String context) {
		return new String("SummaryExpression(" + leftValue.interpret(context)
				+ "+" + rightValue.interpret(context) + "), "
				+ leftValue.showComponents(context)
				+ rightValue.showComponents(context));
	}


	public int interpret(String context) {
		return leftValue.interpret(context) + rightValue.interpret(context);
	}

}

