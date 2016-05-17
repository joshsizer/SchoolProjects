package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpringLayout;
import javax.swing.border.Border;

import cookbook.CookBook;

@SuppressWarnings("serial")
public class RecipePanel extends JPanel {
	private JPanel leftPanel;
	private JPanel rightPanel;

	private JScrollPane recipeDisplayScrollPane;
	private JScrollPane recipeListScrollPane;

	private JTextArea recipeTextArea;
	private String defaultText;

	private JList<String> recipeList;
	
	private JButton showAll;

	public RecipePanel() {
		init();
	}

	private void init() {
		leftPanel = new JPanel();
		rightPanel = new JPanel();

		// set both panels layouts to be spring.
		// spring allows for laying out components relative
		// to each other.
		leftPanel.setLayout(new BorderLayout(100, 100));
		rightPanel.setLayout(new SpringLayout());

		// the parent panel for the left and right will have
		// a grid layout, so that both panels are just right
		// next to each other
		setLayout(new GridLayout(1, 2));

		recipeTextArea = new JTextArea();
		recipeDisplayScrollPane = new JScrollPane(recipeTextArea);

		// just a list of the recipes' names
		recipeList = new JList<String>(CookBook.getInstance().getRecipeNames());
		recipeList.setLayoutOrientation(JList.VERTICAL);
		// the recipe list is in a scroll pane, in case there are a lot
		recipeListScrollPane = new JScrollPane(recipeList);
		recipeListScrollPane.setHorizontalScrollBarPolicy(
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		recipeListScrollPane.setVerticalScrollBarPolicy(
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		//recipeListScrollPane.setPreferredSize(new Dimension(400, 100));
		recipeListScrollPane.setBorder(BorderFactory.createEmptyBorder(
				20, 20, 20, 20));


		if (CookBook.getInstance().getRecipes().size() == 0)
			defaultText = "No recipes to display. Add recipe or load cook book.";
		else {
			defaultText = (CookBook.getInstance().getRecipes().get(0)
					.toString());
		}

		recipeTextArea.setPreferredSize(
				new Dimension(
						(int)( (double)GUI.perferredWidth * 0.30 ),
						(int)( (double)GUI.perferredHeight * 0.70) ));
		recipeTextArea.setLineWrap(true);
		recipeTextArea.setText(defaultText);

		recipeDisplayScrollPane.setHorizontalScrollBarPolicy(
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		recipeDisplayScrollPane.setVerticalScrollBarPolicy(
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		JPanel buttonPanel = new JPanel();
		showAll = new JButton("Show All");
		showAll.setBorder(BorderFactory.createEmptyBorder(
				20, 20, 20, 20));
		buttonPanel.add(showAll);
		
		// recipeListScrollPane.add(recipeList);
		leftPanel.add(recipeListScrollPane, BorderLayout.CENTER);
		leftPanel.add(buttonPanel, BorderLayout.PAGE_END);
		rightPanel.add(recipeDisplayScrollPane);

		add(leftPanel);
		add(rightPanel);
	}
}