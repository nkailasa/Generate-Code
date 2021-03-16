package Model.Icons;

public class DoublePipe extends IconParent {
    private static final long serialVersionUID = 1L;
    public static final String labelText = "*  |  |  *";

    public DoublePipe() {
        super(1000, 1000, labelText);
    }
    
    @Override
    public boolean isIconValid(){
        boolean hasAnInput = false;
        boolean hasAnOutput = false;
        for(IconParent item : inputs){
            if(item != null){
                hasAnInput = true;
                break;
            }
        }
        for(IconParent item: outputs){
            if(item != null){
                hasAnOutput = true;
                break;
            }
        }
        return(hasAnInput && hasAnOutput);
    }
}
