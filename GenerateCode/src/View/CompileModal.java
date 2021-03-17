package View;

import javax.swing.*;
import java.io.Serial;

public class CompileModal extends JDialog{

    @Serial
    private static final long serialVersionUID = 1L;
    private final JLabel compilationResultsLabel = new JLabel();

    public CompileModal() {
        this.setTitle("Compilation Results");
        this.setSize(300, 200);
        add(compilationResultsLabel);
    }



    public void setCompilationResults(boolean success) {
        compilationResultsLabel.setText(success ? "Compiled successfully" : "Compilation error");
    }

}
