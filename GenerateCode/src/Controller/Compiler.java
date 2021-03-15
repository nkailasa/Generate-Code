package Controller;

import java.util.ArrayList;

import View.DragAndDrop.DragAndDropLabel;

public class Compiler {
    public boolean isCompilationSuccessful(ArrayList<DragAndDropLabel> labels){
        for(DragAndDropLabel label : labels){
            if(label.getIconParent().isIconValid() == false){
                return false;
            }
        }
        return true;
    }
}
