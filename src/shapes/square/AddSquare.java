package shapes.square;

import model.ShapeModel;
import shapes.Command;
import view.LoggerView;

public class AddSquare implements Command {

	private ShapeModel model;
	private Square square;

	
	public AddSquare(ShapeModel model, Square square) {
		this.model = model;
		this.square = square;

	}
	@Override
	public void execute() {
		this.model.add(square);

	}

	@Override
	public void unexecute() {
		this.model.remove(square);
		
	}
	
	public String toString() {
		return "Add: " + square.toString();
	}

}
