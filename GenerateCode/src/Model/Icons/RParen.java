package Model.Icons;

import java.io.Serial;

public class RParen extends IconParent {
    @Serial
    private static final long serialVersionUID = 1L;
    public static final String labelText = ". ) ";

    public RParen() {
        super(1, 0, labelText);
    }
}
