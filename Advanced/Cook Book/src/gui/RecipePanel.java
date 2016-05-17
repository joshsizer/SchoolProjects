package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
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
	private Dimension leftPanelPerferredSize;
	private Dimension scrollPanePerferredSize;
	
	private JPanel leftPanel;
	private JPanel rightPanel;

	private JScrollPane recipeDisplayScrollPane;
	private JScrollPane recipeListScrollPane;

	private JTextArea recipeTextArea;
	private String defaultText;

	private JList<String> recipeList;
	
	private JButton showAll;
	private JButton edit;

	public RecipePanel() {
		init();
	}

	private void init() {
		leftPanelPerferredSize = new Dimension((int)(double)(GUI.perferredWidth * 0.30), 100);
		scrollPanePerferredSize = new Dimension(100, (int)(double)(GUI.perferredHeight * 0.7));
		setLayout(new BorderLayout());
		
		initLeftPanel();
		initRightPanel();

		add(leftPanel, BorderLayout.LINE_START);
		add(rightPanel, BorderLayout.CENTER);
	}
	
	private void initLeftPanel() {
		leftPanel = new JPanel();
		
		leftPanel.setLayout(new BorderLayout(100, 100));
		leftPanel.setPreferredSize(leftPanelPerferredSize);
	
		recipeList = new JList<String>(CookBook.getInstance().getRecipeNames());
		recipeList.setLayoutOrientation(JList.VERTICAL);
		// the recipe list is in a scroll pane, in case there are a lot
		
		recipeListScrollPane = new JScrollPane(recipeList);
		recipeListScrollPane.setPreferredSize(scrollPanePerferredSize);
		recipeListScrollPane.setHorizontalScrollBarPolicy(
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		recipeListScrollPane.setVerticalScrollBarPolicy(
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		recipeListScrollPane.setBorder(BorderFactory.createEmptyBorder(
				20, 20, 20, 20));
		
		showAll = new JButton("Show All");

		leftPanel.add(recipeListScrollPane, BorderLayout.PAGE_START);
		leftPanel.add(showAll, BorderLayout.PAGE_END);
	}
	
	private void initRightPanel() {
		rightPanel = new JPanel();
		rightPanel.setLayout(new BorderLayout(50, 50));

		recipeTextArea = new JTextArea();
		recipeDisplayScrollPane = new JScrollPane(recipeTextArea);		

		if (CookBook.getInstance().getRecipes().size() == 0)
			defaultText = "No recipes to display. Add recipe or load cook book.";
		else {
			defaultText = (CookBook.getInstance().getRecipes().get(0)
					.toString());
		}

		recipeTextArea.setLineWrap(true);
		recipeTextArea.setText(defaultText);

		recipeDisplayScrollPane.setPreferredSize(scrollPanePerferredSize);
		recipeDisplayScrollPane.setHorizontalScrollBarPolicy(
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		recipeDisplayScrollPane.setVerticalScrollBarPolicy(
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		recipeDisplayScrollPane.setBorder(BorderFactory.createEmptyBorder(
				20, 20, 20, 20));
		
		edit = new JButton("Edit");
		
		rightPanel.add(recipeDisplayScrollPane, BorderLayout.PAGE_START);
		rightPanel.add(edit, BorderLayout.PAGE_END);
	}
	
}
