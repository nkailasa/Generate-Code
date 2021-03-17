package View.DragAndDrop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serial;


public class AddValueModal extends JDialog{

    @Serial
    private static final long serialVersionUID = 1L;
    private DragAndDropLabel selectedIcon;
    private final JTextField userInputField;

    public AddValueModal(){
        setLayout(new BorderLayout());
        userInputField = new JTextField("");
        add(userInputField, BorderLayout.CENTER);
        add(new JLabel("Add a value"), BorderLayout.NORTH);
        JButton saveButton = new JButton("Save");
        AddValueModal instance = this; 
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


    public void setIcon(DragAndDropLabel icon) {
        this.selectedIcon = icon;
        this.userInputField.setText(icon.getIconParent().getValue());
        this.setTitle("Changing value for icon: " + icon.getIconParent().getText());
    }

}
