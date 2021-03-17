package View;

import javax.swing.*;
import java.io.Serial;

/**
 * This modal shows the result of compilation of the current tab with a simple
 * success/error message
 * 
 * @author Isaac Beale
 */
public class CompileModal extends JDialog {

    @Serial
    private static final long serialVersionUID = 1L;
    private static CompileModal instance;
    private final JLabel compilationResultsLabel = new JLabel();

    private CompileModal(JFrame frame) {
        super(frame, "Compilation Results");
        this.setSize(300, 200);
        add(compilationResultsLabel);
    }

    public static void getInstance(JFrame frame) {
        if (instance == null) {
            instance = new CompileModal(frame);
        }
    }

    public static CompileModal getInstance() {
        return instance;
    }

    public void setCompilationResults(boolean success) {
        compilationResultsLabel.setText(success ? "Compiled successfully" : "Compilation error");
    }

}
