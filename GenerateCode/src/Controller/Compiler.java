package Controller;

import java.util.ArrayList;

import View.DragAndDrop.DragAndDropLabel;

/**
 * This class compiles to check the validity of drawn icons and connections
 * 
 * @return {boolean} true - if compilation is successful
 * @return {boolean} false - if compilation is fails
 * @author Isaac Beale
 */
public class Compiler {
    public boolean isCompilationSuccessful(ArrayList<DragAndDropLabel> labels) {
        for (DragAndDropLabel label : labels) {
            if (label.getIconParent().isIconValid() == false) {
                return false;
            }
        }
        return true;
    }
}
