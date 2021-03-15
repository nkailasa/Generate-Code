package View;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CompileModal extends JDialog{

    private static final long serialVersionUID = 1L;
    private static CompileModal instance;
    private JLabel compilationResultsLabel = new JLabel();

    private CompileModal(JFrame frame){
        super(frame, "Compilation Results");
        this.setSize(300, 200);
        add(compilationResultsLabel);
    }

    public static CompileModal getInstance(JFrame frame){
        if(instance == null){
            instance = new CompileModal(frame);
        }
        return instance;
    }

    public static CompileModal getInstance(){
        return instance;
    }

    public void setCompilationResults(boolean success){
        compilationResultsLabel.setText(success ? "Compiled successfully" : "Compilation error");
    }

    class SingletonNotInstantiatedException extends Exception{

        private static final long serialVersionUID = 1L;

    }
}
