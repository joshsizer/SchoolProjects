package gui;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

import cookbook.Category;
import cookbook.Recipe;

public class CategoryRenderer extends DefaultListCellRenderer {
	public CategoryRenderer() {
	}

	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {
		super.getListCellRendererComponent(list, value, index, isSelected,
				cellHasFocus);
		
		Integer c = (Integer) value;
		setText(Category.toString(c));
		return this;
	}
}
