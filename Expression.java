package lab7_var7;

/**
 * The Expression interface defines the common methods for interpreting algebraic expressions.
 */
public interface Expression {
    /**
     * Interprets the expression based on the provided context.
     *
     * @param context The context containing variable assignments.
     * @return The result of interpreting the expression.
     */
    public int interpret(String context);

    /**
     * Generates a string representation of the components of the expression.
     *
     * @param context The context containing variable assignments.
     * @return A string representing the components of the expression.
     */
    public String showComponents(String context);
}