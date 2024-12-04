package lab7_var7;
/**
 * The Value class represents a numeric or variable value in an algebraic expression.
 */
public class Value implements Expression {
	private String value;

	public Value(String value) {
		this.value = value;
	}

	public String showComponents(String context) {
		if (value.equals("a")) {
			int i = 0;
			while (context.charAt(i) != 'a')
				i++;
			value = String.valueOf(context.charAt(i + 2));
		}
		if (value.equals("b")) {
			int i = 0;
			while (context.charAt(i) != 'b')
				i++;
			value = String.valueOf(context.charAt(i + 2));
		}
		return new String("number(" + value + "),");
	}

	public int interpret(String context) {
		if (value.equals("a")) {
			int i = 0;
			while (context.charAt(i) != 'a')
				i++;
			value = String.valueOf(context.charAt(i + 2));
		}
		if (value.equals("b")) {
			int i = 0;
			while (context.charAt(i) != 'b')
				i++;
			value = String.valueOf(context.charAt(i + 2));
		}
		return (int) Integer.parseInt(value);
	}
}

