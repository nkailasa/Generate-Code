package Model.Icons;

public class DoublePipe extends IconParent {
    private static final long serialVersionUID = 6493562606158135612L;

    public DoublePipe() {
        super(1000, 1000, "*  |  |  *");
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
