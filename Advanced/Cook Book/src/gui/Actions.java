package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;

import cookbook.Category;
import cookbook.CookBook;

public class Actions {
	static JFileChooser fileChooser = new JFileChooser();
	static FileNameExtensionFilter filter 
	= new FileNameExtensionFilter("Cook Book Files", CookBook.extension);
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
			JMenuItem saveButton = (JMenuItem) savePressed.getSource();
			boolean i_saveAs = saveAs 
					|| CookBook.getInstance().getSaveLocation() == null;
			
			if (!i_saveAs) {
				try {
					CookBook.getInstance().save();
				} catch (IOException e) {
					e.printStackTrace();
				}
				return;
			}
			
			if (fileChooser.showSaveDialog(saveButton) 
					== JFileChooser.APPROVE_OPTION) {
				try {
					CookBook.getInstance().save(fileChooser.getSelectedFile());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static class Load implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent loadPressed) {
			JMenuItem loadButton = (JMenuItem) loadPressed.getSource();
			if (fileChooser.showOpenDialog(null)
					== JFileChooser.APPROVE_OPTION) {
				CookBook instance = CookBook.getInstance();
				try {
					instance = CookBook.load(fileChooser.getSelectedFile());
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
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

}
