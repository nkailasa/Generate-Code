package View.DragAndDropItems;


public abstract class DragAndDropParent {
    protected int inputLimit;
    protected int outputLimit;
    protected DragAndDropParent[] inputs;
    protected DragAndDropParent[] outputs;


    public DragAndDropParent(int inputLimit, int outputLimit){

        this.inputLimit = inputLimit;
        this.outputLimit = outputLimit;
        this.inputs = new DragAndDropParent[inputLimit];
        this.outputs = new DragAndDropParent[outputLimit];
    }

    public DragAndDropParent addInput(int location, DragAndDropParent inputElement){
        if(0 < location && location < inputLimit && inputs[location] == null){
            inputs[location] = inputElement;
            return inputElement;
        }
        return null;
    }

    public DragAndDropParent addOutput(int location, DragAndDropParent outputElement){
        if(0 < location && location < outputLimit && outputs[location] == null){
            outputs[location] = outputElement;
            return outputElement;
        }
        return null;
    }

    public DragAndDropParent removeInput(int location){
        if(0 < location && location < inputLimit && inputs[location] != null){
            DragAndDropParent item = inputs[location];
            inputs[location] = null;
            return item;
        }
        return null;
    }

    public DragAndDropParent removeOutput(int location){
        if(0 < location && location < outputLimit && outputs[location] != null){
            DragAndDropParent item = outputs[location];
            outputs[location] = null;
            return item;
        }
        return null;
    }

    /*
    get input and output methods throw exceptions if trying to access outside of
    input or output bounds.
    */
    public DragAndDropParent getInput(int location){
        return inputs[location];
    }

    public DragAndDropParent getOutput(int location){
        return outputs[location];
    }
}
