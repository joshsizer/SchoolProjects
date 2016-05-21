package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;

import cookbook.Category;
import cookbook.CookBook;

public class Actions {
	static JFileChooser fileChooser = new JFileChooser();
	static FileNameExtensionFilter filter = new FileNameExtensionFilter(
			"Cook Book Files", CookBook.extension);

	static {
		fileChooser.setFileFilter(filter);
	}

	/**
	 * A class that handles a save event
	 * 
	 * @author Josh Sizer
	 */
	public static class Save implements ActionListener {
		boolean saveAs;

		public Save(boolean saveAs) {
			this.saveAs = saveAs;
		}

		@Override
		public void actionPerformed(ActionEvent savePressed) {
			boolean i_saveAs = saveAs
					|| CookBook.getInstance().getSaveLocation() == null;

			int option = -1;
			if (i_saveAs) {
				option = fileChooser.showSaveDialog(null);
			}
			if (option == JFileChooser.APPROVE_OPTION) {
				CookBook.getInstance()
						.setSaveLocation(fileChooser.getSelectedFile());
			} else return;

			try {
				CookBook.getInstance().save();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static class Load implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent loadPressed) {
			showChooseFileDialogue();
		}

		public void showChooseFileDialogue() {
			if (fileChooser
					.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				CookBook.getInstance();
				try {
					CookBook.load(fileChooser.getSelectedFile());
					System.out.println(CookBook.getInstance());
				} catch (ClassNotFoundException | IOException e) {
					e.printStackTrace();
					showChooseFileDialogue();
				}
			}
		}
	}

	public static class CategoryPressed implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent menuPressed) {
			// gets which category was pressed in the menu
			CategoryMenuItem category = (CategoryMenuItem) menuPressed
					.getSource();
			System.out.println(Category.toString(category.getCategory()));
		}
	}
	
	public static class EditPressed implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			GUI.frame.showEditPanel();
		}
	}
	
	public static class CancelPressed implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			GUI.frame.showRecipePanel();
			
		}
	}

}
