package Model.Icons;

import java.io.Serial;

public class GreaterThan extends IconParent {
    @Serial
    private static final long serialVersionUID = 1L;
    public static final String labelText = ":  >  .";

    public GreaterThan() {
        super(2, 1, labelText);
    }
}
