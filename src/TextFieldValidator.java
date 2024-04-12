import javax.swing.BorderFactory;
import javax.swing.JTextField;
import java.awt.*;

/**
 * TextFieldValidator is a utility class for validating JTextField inputs based on a regular expression.
 */
public class TextFieldValidator {
    // ---------------------- variable initialization
    private String regExp;
    private Color errorColor;
    private JTextField txtField;

    // ---------------------- constructor methods

    /**
     * Constructs a TextFieldValidator with a specified target JTextField and error color.
     * @param myTarget     The target JTextField to be validated.
     * @param myErrorColor The color to be set for displaying error indication.
     */
    public TextFieldValidator(JTextField myTarget, String regExp, Color myErrorColor) {
        regExp = "^[0-9]$"; // Default regular expression for numeric input
        errorColor = myErrorColor;
        txtField = myTarget;
    }

    /**
     * Constructs a TextFieldValidator with a specified target JTextField and default error color (RED).
     * @param myTarget The target JTextField to be validated.
     */
    public TextFieldValidator(JTextField myTarget) {
        regExp = "^[0-9]$"; // Default regular expression for numeric input
        errorColor = Color.RED;
        txtField = myTarget;
    }

    // ---------------------- public methods & gets/sets

    /**
     * Sets the regular expression for input validation.
     * @param myRegExp The regular expression to be set.
     */
    public void setRegExp(String myRegExp) {
        regExp = myRegExp;
    }

    /**
     * Sets the error color for displaying error indication.
     * @param myColor The color to be set as the error color.
     */
    public void setErrorColor(Color myColor) {
        errorColor = myColor;
    }

    /**
     * Validates the text content of the associated JTextField using the specified regular expression.
     * If the content does not match the regular expression, it sets the border color of the JTextField to the error color.
     * @return true if the text content matches the regular expression, false if it does not.
     */
    public boolean check() {
        if (!txtField.getText().matches(regExp)) txtField.setBorder(BorderFactory.createLineBorder(errorColor));
        return txtField.getText().matches(regExp);
    }

    /**
     * Resets the border color of the associated JTextField back to the default color (GRAY).
     */
    public void reset() {
        txtField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
    }
}
