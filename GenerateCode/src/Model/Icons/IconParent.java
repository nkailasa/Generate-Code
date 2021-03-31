package Model.Icons;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

public abstract class IconParent implements java.io.Serializable {
	@Serial
	private static final long serialVersionUID = 1L;
	protected int inputLimit;
	protected int outputLimit;
	protected List<IconParent> inputs;
	protected List<IconParent> outputs;
	protected String text;
	protected String value;

	/**
	 * This class has a reference to all inputs, outputs, value and connection
	 * linked to a particular icon
	 *
	 * @author Issac Beale
	 */
	public IconParent(int inputLimit, int outputLimit, String text) {
		this.inputLimit = inputLimit;
		this.outputLimit = outputLimit;
		this.inputs = new ArrayList<>();
		this.outputs = new ArrayList<>();
		this.text = text;
		this.value = "";
	}

	public void addInput(IconParent inputElement) {
		if (this.inputs.size() < inputLimit)
			this.inputs.add(inputElement);
	}

	public void addOutput(IconParent outputElement) {
		if (this.outputs.size() < outputLimit)
			this.outputs.add(outputElement);

	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean isInputSpaceAvailable() {
		return this.inputs.size() < this.inputLimit;
	}

	public boolean isOutputSpaceAvailable() {
		return this.outputs.size() < this.outputLimit;
	}

	public String getText() {
		return this.text;
	}

	public boolean containsLoop() {
		boolean isLoopConditionFilled = false;
		ArrayList<IconParent> visitedIcons = new ArrayList<IconParent>();
		visitedIcons.add(this);
		int count = 0;
		boolean hasAtSymbol = false;
		while (count < visitedIcons.size()) {
			for (IconParent output : visitedIcons.get(count).outputs) {
				if (output == this) {
					isLoopConditionFilled = true;
					break;
				} else {
					if (output instanceof AtSymbol) {
						hasAtSymbol = true;
					}
					if (!visitedIcons.contains(output)) {
						visitedIcons.add(output);
					}
				}
			}
			count++;
		}
		return (isLoopConditionFilled && !hasAtSymbol);
	}

	public boolean connectionsFilled() {
		boolean valid = true;
		if ((inputLimit > 0 && inputs.size() == 0) || (outputLimit > 0 && outputs.size() == 0)) {
			valid = false;
		}
		for (IconParent item : inputs) {
			if (item == null) {
				valid = false;
			}
		}
		for (IconParent item : outputs) {
			if (item == null) {
				valid = false;
			}
		}
		return valid;
	}

	public boolean isIconValid() {
		boolean valid = connectionsFilled();
		return (valid && !containsLoop());
	}
}
