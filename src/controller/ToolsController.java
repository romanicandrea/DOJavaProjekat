package controller;

import java.awt.event.MouseEvent;
import java.util.Iterator;
import javax.swing.JOptionPane;
import app.MainFrame;
import shapes.Shape;
import view.ToolsView;
import zcommand.*;

public class ToolsController {

	private ToolsView toolsView;
	private MainFrame frame;
	

	public ToolsController(MainFrame frame) {
		this.toolsView = frame.getToolsView();
		this.frame=frame;
	}
	
	// SELECT

	public void handleSelection(MouseEvent arg0) {
		if( frame.getView().getModel().getShapes().size() ==0 && toolsView.getTglbtnSelect().isSelected())
		{
			JOptionPane.showMessageDialog(null, "No elements to select!");
			toolsView.getTglbtnSelect().setSelected(false);
		}
		else
		{
			for(int i = frame.getView().getModel().getShapes().size()-1;i>=0;i--)
			{
				if(frame.getView().getModel().getShape(i).contains(arg0.getX(), arg0.getY()))
				{
					if(frame.getView().getModel().getShape(i).isSelected())
					{
						frame.getView().getModel().getShape(i).setSelected(false);
					}
					else
					{
						frame.getView().getModel().getShape(i).setSelected(true);
					}
					
					
					frame.getView().repaint();
					break;
					
				}
			}
		}
		
	}


	// DESELECT
	
	public void handeDeselection(){
		
		Iterator<Shape> it = frame.getView().getModel().getShapes().iterator();
		while (it.hasNext()) it.next().setSelected(false);
		frame.getView().repaint();
		
	}
	
	//DELETE
	
	public void handleDelete() {
		
		for (int i = frame.getView().getModel().getShapes().size() - 1; i >= 0; i--) {
			
			if (frame.getView().getModel().getShapes().get(i).isSelected()) {
				frame.getCommandController().generateRemoveCommand(frame.getView().getModel().getShapes().get(i), frame.getView().getModel()).execute();
			}
			
		}
		frame.getView().repaint();
	}
	
	
	//DELETE ALL
	
	public void handleDeleteAll() {
		
		for (int i = frame.getView().getModel().getShapes().size() - 1; i >= 0; i--) {
			frame.getCommandController().generateRemoveCommand(frame.getView().getModel().getShapes().get(i), frame.getView().getModel()).execute();
				
		}
		frame.getView().repaint();
	}
	
	public void handleModify() {
		frame.getView().getModel().countSelectedShapes();
		if (frame.getView().getModel().countSelectedShapes()!=0) {
			if (frame.getView().getModel().countSelectedShapes() == 1) {

				// TODO implement update
				for (int i = frame.getView().getModel().getShapes().size() - 1; i >= 0; i--) {
					
					if (frame.getView().getModel().getShapes().get(i).isSelected()) {
						frame.getCommandController().generateUpdateCommand(frame.getView().getModel().getShapes().get(i), frame.getView().getModel()).execute();
					}
					
				}
				frame.getView().repaint();
				
			} else {
				JOptionPane.showMessageDialog(null, "More than one shape are selected!", "Error!!",
						JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, "You need to select shape!", "Error!!", JOptionPane.ERROR_MESSAGE);
		}

	}
	
	
	// BRING TO FRONT
	
	public void handleBringToFront() {
		if (frame.getView().getModel().countSelectedShapes()!=0) {
		BringToFront cmd = new BringToFront(frame.getView().getModel());
		cmd.execute();
		frame.getView().repaint();
		}else {
			JOptionPane.showMessageDialog(null, "You need to select shape!", "Error!!", JOptionPane.ERROR_MESSAGE);
		}
	}
			
	// BRING TO BACK
	
	public void handleBringToBack() {
		if (frame.getView().getModel().countSelectedShapes()!=0) {
		BringToBack cmd = new BringToBack(frame.getView().getModel());
		cmd.execute();
		frame.getView().repaint();
		}else {
			JOptionPane.showMessageDialog(null, "You need to select shape!", "Error!!", JOptionPane.ERROR_MESSAGE);
		}
	}
			
	// SEND TO FRONT
	
	public void handleSendToFront() {
		if (frame.getView().getModel().countSelectedShapes()!=0) {
		ToFront cmd = new ToFront(frame.getView().getModel());
		cmd.execute();
		frame.getView().repaint();
		}else {
			JOptionPane.showMessageDialog(null, "You need to select shape!", "Error!!", JOptionPane.ERROR_MESSAGE);
		}
	}
			
	// SEND TO BACK
	
	public void handleSendToBack() {
		if (frame.getView().getModel().countSelectedShapes()!=0) {
		ToBack cmd = new ToBack(frame.getView().getModel());
		cmd.execute();
		frame.getView().repaint();
		}else {
			JOptionPane.showMessageDialog(null, "You need to select shape!", "Error!!", JOptionPane.ERROR_MESSAGE);
		}
	}
			
	
	
	
	
	
	
	
	
}
