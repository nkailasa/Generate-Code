package View;

import javax.swing.*;
import java.io.Serial;

public class CompileModal extends JDialog{

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
