package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;

import cookbook.Category;
import cookbook.CookBook;

public class Actions {
	/**
	 * A class that handles a save event
	 * @author Josh Sizer
	 */
	static public class SaveAction implements ActionListener {
		boolean saveAs;
		
		public SaveAction(boolean saveAs) {
			this.saveAs = saveAs;
		}
		
		@Override
		public void actionPerformed(ActionEvent savePressed) {
			JMenuItem saveButton = (JMenuItem) savePressed.getSource();
			boolean i_saveAs = saveAs 
					|| CookBook.getInstance().getSaveLocation() == null;
			
			if (!i_saveAs) {
				CookBook.getInstance().save();
				return;
			}
			
			JFileChooser fileChooser = new JFileChooser();
			if (fileChooser.showSaveDialog(saveButton) 
					== JFileChooser.APPROVE_OPTION) {
				CookBook.getInstance().save(fileChooser.getSelectedFile());
			}
		}
	}

	static public class CategoryPressed implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent menuPressed) {
			// gets which category was pressed in the menu
			CategoryMenuItem category = (CategoryMenuItem) menuPressed
					.getSource();
			System.out.println(Category.toString(category.getCategory()));
		}
	}

}
