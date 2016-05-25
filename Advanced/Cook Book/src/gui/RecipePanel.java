/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.ScrollPaneConstants;

import cookbook.CookBook;
import cookbook.Recipe;

/**
 * The recipe panel. From this panel, you can choose what recipe to view, and
 * you can see the steps, ingredients, name, and category of the currently
 * selected recipe. The GUI code is taken from netbeans.
 * 
 * @author Josh Sizer
 */
@SuppressWarnings("serial")
public class RecipePanel extends JPanel {
	protected JButton edit;
	protected JScrollPane recipeDisplayScrollPane;
	protected JTextArea recipeDisplayTextArea;
	protected JLabel recipeLabel;
	protected JList<Recipe> recipeList;
	protected JScrollPane recipeListScrollPane;
	protected JLabel recipeNameLabel;
	protected JButton showAll;

	public RecipePanel() {
		initComponents();
	}

	private void initComponents() {
		recipeDisplayScrollPane = new JScrollPane();
		recipeDisplayTextArea = new JTextArea();
		recipeListScrollPane = new JScrollPane();
		recipeList = new JList<Recipe>();
		recipeLabel = new JLabel();
		showAll = new JButton();
		edit = new JButton();
		recipeNameLabel = new JLabel();

		recipeDisplayScrollPane.setVerticalScrollBarPolicy(
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		recipeDisplayTextArea.setEditable(false);
		recipeDisplayTextArea.setColumns(20);
		recipeDisplayTextArea.setLineWrap(true);
		recipeDisplayTextArea.setRows(5);
		recipeDisplayScrollPane.setViewportView(recipeDisplayTextArea);

		recipeListScrollPane.setHorizontalScrollBarPolicy(
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		recipeList = new JList<Recipe>(
				CookBook.getInstance().getRecipesAsArray());
		recipeList.setCellRenderer(new RecipeRenderer());

		recipeList.addListSelectionListener(new Actions.RecipeSelected());
		recipeListScrollPane.setViewportView(recipeList);

		recipeLabel.setText("Recipes:");

		showAll.setText("Show All");
		showAll.addActionListener(new Actions.ShowAllRecipes());

		edit.setText("Edit");
		edit.addActionListener(new Actions.EditRecipe());

		recipeNameLabel.setToolTipText("");

		GroupLayout RecipePanelLayout = new GroupLayout(
				this);
		setLayout(RecipePanelLayout);
		RecipePanelLayout.setHorizontalGroup(RecipePanelLayout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(RecipePanelLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(RecipePanelLayout
								.createParallelGroup(
										GroupLayout.Alignment.LEADING)
								.addGroup(RecipePanelLayout
										.createSequentialGroup()
										.addGroup(RecipePanelLayout
												.createParallelGroup(
														GroupLayout.Alignment.LEADING)
												.addComponent(showAll)
												.addComponent(
														recipeListScrollPane,
														GroupLayout.PREFERRED_SIZE,
														122,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(RecipePanelLayout
												.createParallelGroup(
														GroupLayout.Alignment.LEADING)
												.addGroup(
														GroupLayout.Alignment.TRAILING,
														RecipePanelLayout
																.createSequentialGroup()
																.addPreferredGap(
																		LayoutStyle.ComponentPlacement.RELATED,
																		GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addComponent(
																		edit))
												.addGroup(RecipePanelLayout
														.createSequentialGroup()
														.addGap(14, 14, 14)
														.addGroup(
																RecipePanelLayout
																		.createParallelGroup(
																				GroupLayout.Alignment.LEADING)
																		.addGroup(
																				RecipePanelLayout
																						.createSequentialGroup()
																						.addComponent(
																								recipeNameLabel)
																						.addGap(0,
																								0,
																								Short.MAX_VALUE))
																		.addComponent(
																				recipeDisplayScrollPane,
																				GroupLayout.DEFAULT_SIZE,
																				244,
																				Short.MAX_VALUE))))
										.addContainerGap())
								.addGroup(RecipePanelLayout
										.createSequentialGroup()
										.addComponent(recipeLabel)
										.addGap(149, 349, Short.MAX_VALUE)))));
		RecipePanelLayout.setVerticalGroup(RecipePanelLayout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(RecipePanelLayout.createSequentialGroup()
						.addGap(16, 16, 16)
						.addGroup(RecipePanelLayout
								.createParallelGroup(
										GroupLayout.Alignment.BASELINE)
								.addComponent(recipeNameLabel)
								.addComponent(recipeLabel))
						.addPreferredGap(
								LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(RecipePanelLayout
								.createParallelGroup(
										GroupLayout.Alignment.LEADING)
								.addComponent(recipeListScrollPane,
										GroupLayout.DEFAULT_SIZE,
										206, Short.MAX_VALUE)
								.addComponent(recipeDisplayScrollPane))
						.addPreferredGap(
								LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(RecipePanelLayout
								.createParallelGroup(
										GroupLayout.Alignment.BASELINE)
								.addComponent(showAll).addComponent(edit,
										GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE))
						.addGap(19, 19, 19)));
	}
}
