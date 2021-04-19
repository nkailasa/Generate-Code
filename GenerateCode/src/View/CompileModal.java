package View;

import java.io.Serial;

import javax.swing.JDialog;
import javax.swing.JTextArea;

/**
 * This modal shows the result of compilation of the current tab with a simple
 * success/error message
 * 
 * @author Isaac Beale
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

    public void setCompilationResults(boolean success,String programBlocks) {

        if (!success) {
            program = "Compilation error";
        }else{
            program = "digraph  G {  " + System.lineSeparator() + programBlocks + System.lineSeparator() + " }";
        }

        textarea.setText(program);
    }

}
