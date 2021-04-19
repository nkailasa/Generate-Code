package Controller;

import java.util.ArrayList;
import java.util.List;

import View.DragAndDrop.DragAndDropLabel;
import View.Panels.RightPanel.Tab;

/**
 * This class compiles to check the validity of drawn icons and connections
 * 
 * @return {boolean} true - if compilation is successful
 * @return {boolean} false - if compilation is fails
 * @author Isaac Beale
 */
public class Compiler {

    boolean isCompilationSuccessful(ArrayList<Tab> tabs) {

        for (Tab tab : tabs) {
            for (DragAndDropLabel label : tab.getLabels()) {
                if (label.getIconParent().isIconValid() == false) {
                    return false;
                }
            }
        }

        return true;
    }

    String generateTabBlocks(ArrayList<Tab> tabs) {
        String program = "";
        for (Tab tab : tabs) {
            program += tab.getTitle() + "{  " + System.lineSeparator();
            System.out.println(program);
            for (DragAndDropLabel label : tab.getLabels()) {
                List<String> connectedIcons = label.getIconParent().getOutputList();
                if (connectedIcons.size() > 0)
                    program += '"' + label.getIconParent().getIconId() + '"' + " -> ";
                for (int i = 0; i < connectedIcons.size(); i++) {
                    if (i == connectedIcons.size()-1)
                        program +=  '"' +connectedIcons.get(i) + '"' + ";";
                    else
                        program += '"' + connectedIcons.get(i) +  '"' +" -> ";
                }
                System.out.println(program);
            }
            program += " }" + System.lineSeparator();
            System.out.println(program);
        }
        return program;
    }
}
