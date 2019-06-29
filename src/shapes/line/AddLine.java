package shapes.line;

import model.ShapeModel;
import shapes.Command;
import view.LoggerView;

public class AddLine implements Command{
	
	private ShapeModel model;
	private Line line;

	
	public AddLine(ShapeModel model, Line line) {
		this.model = model;
		this.line = line;

	}

	@Override
	public void execute() {
		this.model.add(line);

	}

	@Override
	public void unexecute() {
		this.model.remove(line);
		
	}
	
	public String toString() {
		return "Add: " + line.toString();
	}

}
