package View.DragAndDrop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serial;


public class AddValueModal extends JDialog{

    @Serial
    private static final long serialVersionUID = 1L;
    private static AddValueModal instance;
    private DragAndDropLabel selectedIcon;
    private final JTextField userInputField;

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

    public static void getInstance(JFrame frame) {
        if (instance == null) {
            instance = new AddValueModal(frame);
        }
    }

    public static AddValueModal getInstance() {
        return instance;
    }


    public void setIcon(DragAndDropLabel icon) {
        this.selectedIcon = icon;
    }

    public void setInputText(String text){
        this.userInputField.setText(text);
    }
}
