package Model.Icons;

public class RPipe extends IconParent {
    private static final long serialVersionUID = 1L;
    public RPipe() {
        super(1, 1000, Constants.RPIPE);
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
