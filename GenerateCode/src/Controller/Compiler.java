package Controller;

import java.util.ArrayList;
import java.util.List;

import View.DragAndDrop.DragAndDropLabel;
import View.Panels.RightPanel.Tab;

/**
 * This class compiles to check the validity of drawn icons and connections
 * Method isCompilationSuccessful does not generate program if any one of the icons is invalid
 * Method generateTabBlocks iterates through all tabs and generates program for the connected icons.
 * 
 * @return {String} program - if compilation is successful
 * @return {String} false - if compilation is fails
 * @author Isaac Beale
 * @author Nevedita Kailasam
 */
public class Compiler {

    String isCompilationSuccessful(ArrayList<Tab> tabs) {

        for (Tab tab : tabs) {
            for (DragAndDropLabel label : tab.getLabels()) {
                if (label.getIconParent().isIconValid() == false) {
                    return "false";
                }
            }
        }

        return generateTabBlocks(tabs);
    }

    String generateTabBlocks(ArrayList<Tab> tabs) {
        List<DragAndDropLabel> startLabels = new ArrayList<>();
        List<DragAndDropLabel> endLabels = new ArrayList<>();
        String program = "";
        for (Tab tab : tabs) {
            program += tab.getTitle() + "{  " + System.lineSeparator();
            startLabels.add(tab.getLabels().get(0));
            endLabels.add(tab.getLabels().get(1));
            for (DragAndDropLabel label : tab.getLabels()) {
                List<String> connectedIcons = label.getIconParent().getOutputList();

                for (int i = 0; i < connectedIcons.size(); i++) {
                    program += '"' + label.getIconParent().getIconId() + '"' + " -> ";
                    program += '"' + connectedIcons.get(i) + '"' + ";" + System.lineSeparator();
                }
            }
            program += " }" + System.lineSeparator();
        }
        for (DragAndDropLabel startLabel : startLabels) {
            program += "start" + " -> " + '"' + startLabel.getIconParent().getIconId() + '"' + ";"
                    + System.lineSeparator();
        }
        for (DragAndDropLabel endLabel : endLabels) {
            program += '"' + endLabel.getIconParent().getIconId() + '"' + " -> " + "end" + ";" + System.lineSeparator();
        }
        return program;
    }
}
