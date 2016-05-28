package gui;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

import cookbook.Category;

/**
 * Instead of displaying the integer value of the category in the category JList
 * and the JComboBox in the edit panel, they will display the name 
 * associated with the category. 
 * 
 * @author Josh Sizer
 *
 */
@SuppressWarnings("serial")
public class CategoryRenderer extends DefaultListCellRenderer {
	public Component getListCellRendererComponent(JList<?> list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {
		super.getListCellRendererComponent(list, value, index, isSelected,
				cellHasFocus);
		
		Integer c = (Integer) value;
		setText(Category.toString(c));
		return this;
	}
}
