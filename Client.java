package lab7_var7;
/**
 * The Client class demonstrates the usage of the Interpreter pattern for evaluating and displaying
 * algebraic expressions. It constructs expression parsers, builds syntax trees, and interprets
 * expressions in a given context.
 */
public class Client {
	public static void main(String[] args) {
		String exp = new String("1+a*(8-b)+4/2");
		String exp1 = new String("a+b/3+7*6+3+4*2-1");

		String context = new String("a=7, b=3");
		ExpressionParser p = new ExpressionParser(exp);
		ExpressionParser p1 = new ExpressionParser(exp1);

		Expression syntaxTree = p.getSyntaxTree();
		Expression syntaxTree1 = p1.getSyntaxTree();

		int res = syntaxTree.interpret(context);
		int res1 = syntaxTree1.interpret(context);

		String res2 = syntaxTree.showComponents(context);

		System.out.println("1+7*(8-3)+4/2=" + res);

		System.out.println("7+3/3+7*6+3+4*2-1=" + res1);
		System.out.println();
		System.out.println("Components of expression (with arguments):");
		System.out.println(res2);

	}

}
