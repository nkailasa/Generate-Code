package Model.Icons;

public class LPipe extends IconParent {
    private static final long serialVersionUID = 1L;

    public LPipe() {
        super(1000, 1, Constants.LPIPE);
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
