package Model.Icons;

public class RPipe extends IconParent {
    public RPipe() {
        super(1000, 1, Constants.RPIPE);
    }

    @Override
    public boolean isIconValid() {
        boolean hasAnInput = false;
        boolean hasAnOutput = false;
        for (IconParent item : inputs) {
            if (item != null) {
                hasAnInput = true;
                break;
            }
        }
        for (IconParent item : outputs) {
            if (item != null) {
                hasAnOutput = true;
                break;
            }
        }
        return (hasAnInput && hasAnOutput);
    }
}
