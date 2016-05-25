package gui;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import cookbook.Recipe;
import java.awt.Component;

/**
 * Allows the JList to display the recipe's  instead of the recipe's
 * <code>toString()</code>, which has the recipe's ingredients and
 * steps included.
 * 
 * @author Josh Sizer
 *
 */
@SuppressWarnings("serial")
public class RecipeRenderer extends DefaultListCellRenderer {
	public RecipeRenderer() {
	}

	public Component getListCellRendererComponent(JList<?> list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {
		super.getListCellRendererComponent(list, value, index, isSelected,
				cellHasFocus);
		
		Recipe r = (Recipe) value;
		setText(r.getName());
		return this;
	}
}
