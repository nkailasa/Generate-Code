package View.DragAndDrop;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AddValueModal extends JDialog{

    private static final long serialVersionUID = 1L;
    private static AddValueModal instance;
    private DragAndDropLabel selectedIcon;
    private JTextField userInputField;

    private AddValueModal(JFrame frame){
        super(frame);
        setLayout(new BorderLayout());
        userInputField = new JTextField("");
        add(userInputField, BorderLayout.CENTER);
        add(new JLabel("Add a value"), BorderLayout.NORTH);
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                selectedIcon.getIconParent().setValue(userInputField.getText());
                instance.setVisible(false);
            }
        });
        this.add(saveButton, BorderLayout.SOUTH);
        this.setSize(300, 200);
    }

    public static AddValueModal getInstance(JFrame frame){
        if(instance == null){
            instance = new AddValueModal(frame);
        }
        return instance;
    }

    public static AddValueModal getInstance(){
        return instance;
    }


    public void setIcon(DragAndDropLabel icon){
        this.selectedIcon = icon;
    }

    public void setInputText(String text){
        this.userInputField.setText(text);
    }
}
