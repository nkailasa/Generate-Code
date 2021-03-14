package Model.Icons;


public abstract class IconParent implements java.io.Serializable{
    private static final long serialVersionUID = -1493725299136428484L;
    protected int inputLimit;
    protected int outputLimit;
    protected IconParent[] inputs;
    protected IconParent[] outputs;
    protected String text;
    protected String value;


    public IconParent(int inputLimit, int outputLimit, String text){
        this.inputLimit = inputLimit;
        this.outputLimit = outputLimit;
        this.inputs = new IconParent[inputLimit];
        this.outputs = new IconParent[outputLimit];
        this.text = text;
        this.value = "";
    }

    public IconParent addInput(int location, IconParent inputElement){
        if(0 < location && location < inputLimit && inputs[location] == null){
            inputs[location] = inputElement;
            return inputElement;
        }
        return null;
    }

    public IconParent addOutput(int location, IconParent outputElement){
        if(0 < location && location < outputLimit && outputs[location] == null){
            outputs[location] = outputElement;
            return outputElement;
        }
        return null;
    }

    public IconParent removeInput(int location){
        if(0 < location && location < inputLimit && inputs[location] != null){
            IconParent item = inputs[location];
            inputs[location] = null;
            return item;
        }
        return null;
    }

    public IconParent removeOutput(int location){
        if(0 < location && location < outputLimit && outputs[location] != null){
            IconParent item = outputs[location];
            outputs[location] = null;
            return item;
        }
        return null;
    }

    /*
    get input and output methods throw exceptions if trying to access outside of
    input or output bounds.
    */
    public IconParent getInput(int location){
        return inputs[location];
    }

    public IconParent getOutput(int location){
        return outputs[location];
    }

    public String getText(){
        return this.text;
    }

    public void setValue(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }

    public boolean isIconValid(){
        for(IconParent item : inputs){
            if(item == null){
                return false;
            }
        }
        for(IconParent item: outputs){
            if(item == null){
                return false;
            }
        }
        return true;
    }
}
