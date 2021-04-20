package View;

import java.io.Serial;

import javax.swing.JDialog;
import javax.swing.JTextArea;

/**
 * This modal shows the result of compilation of all tabs. Error message is
 * shown if compilation fails in any one of the tabs The generated program is
 * shown on successful compilation.
 * 
 * @author Isaac Beale
 * @author Nevedita Kailasam
 */
public class CompileModal extends JDialog {

    @Serial
    private static final long serialVersionUID = 1L;
    String program = "";
    JTextArea textarea = new JTextArea("add your message here");

    public CompileModal() {
        this.setTitle("Compilation Results");
        this.setSize(300, 200);
        textarea.setVisible(true);
        add(textarea);
    }

    public void setCompilationResults(String programBlocks) {

        if (programBlocks=="false") {
            program = "Compilation error";
        } else {
            program = "digraph  G {  " + System.lineSeparator() + programBlocks + System.lineSeparator() + " }";
        }

        textarea.setText(program);
    }

}
