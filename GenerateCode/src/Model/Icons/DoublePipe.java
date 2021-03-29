/*
package Model.Icons;

import java.io.Serial;

public class DoublePipe extends IconParent {
    @Serial
    private static final long serialVersionUID = 1L;

    public DoublePipe() {
        super(1000, 1000, Constants.PIPE);
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


 */