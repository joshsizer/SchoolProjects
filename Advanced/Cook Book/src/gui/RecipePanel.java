/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.JList;
import javax.swing.JPanel;

import cookbook.CookBook;
import cookbook.Recipe;

/**
 *
 * @author Josh
 */
@SuppressWarnings("serial")
public class RecipePanel extends JPanel {
	protected javax.swing.JButton edit;
	protected javax.swing.JScrollPane recipeDisplayScrollPane;
	protected javax.swing.JTextArea recipeDisplayTextArea;
	protected javax.swing.JLabel recipeLabel;
	protected JList<Recipe> recipeList;
	protected javax.swing.JScrollPane recipeListScrollPane;
	protected javax.swing.JLabel recipeNameLabel;
	protected javax.swing.JButton showAll;

	public RecipePanel() {
		initComponents();
	}

	private void initComponents() {
		recipeDisplayScrollPane = new javax.swing.JScrollPane();
		recipeDisplayTextArea = new javax.swing.JTextArea();
		recipeListScrollPane = new javax.swing.JScrollPane();
		recipeList = new javax.swing.JList<Recipe>();
		recipeLabel = new javax.swing.JLabel();
		showAll = new javax.swing.JButton();
		edit = new javax.swing.JButton();
		recipeNameLabel = new javax.swing.JLabel();

		recipeDisplayScrollPane.setVerticalScrollBarPolicy(
				javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		recipeDisplayTextArea.setColumns(20);
		recipeDisplayTextArea.setLineWrap(true);
		recipeDisplayTextArea.setRows(5);
		recipeDisplayScrollPane.setViewportView(recipeDisplayTextArea);

		recipeListScrollPane.setHorizontalScrollBarPolicy(
				javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

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

		javax.swing.GroupLayout RecipePanelLayout = new javax.swing.GroupLayout(
				this);
		setLayout(RecipePanelLayout);
		RecipePanelLayout.setHorizontalGroup(RecipePanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(RecipePanelLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(RecipePanelLayout
								.createParallelGroup(
										javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(RecipePanelLayout
										.createSequentialGroup()
										.addGroup(RecipePanelLayout
												.createParallelGroup(
														javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(showAll)
												.addComponent(
														recipeListScrollPane,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														122,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(RecipePanelLayout
												.createParallelGroup(
														javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														javax.swing.GroupLayout.Alignment.TRAILING,
														RecipePanelLayout
																.createSequentialGroup()
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addComponent(
																		edit))
												.addGroup(RecipePanelLayout
														.createSequentialGroup()
														.addGap(14, 14, 14)
														.addGroup(
																RecipePanelLayout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
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
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				244,
																				Short.MAX_VALUE))))
										.addContainerGap())
								.addGroup(RecipePanelLayout
										.createSequentialGroup()
										.addComponent(recipeLabel)
										.addGap(149, 349, Short.MAX_VALUE)))));
		RecipePanelLayout.setVerticalGroup(RecipePanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(RecipePanelLayout.createSequentialGroup()
						.addGap(16, 16, 16)
						.addGroup(RecipePanelLayout
								.createParallelGroup(
										javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(recipeNameLabel)
								.addComponent(recipeLabel))
						.addPreferredGap(
								javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(RecipePanelLayout
								.createParallelGroup(
										javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(recipeListScrollPane,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										206, Short.MAX_VALUE)
								.addComponent(recipeDisplayScrollPane))
						.addPreferredGap(
								javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(RecipePanelLayout
								.createParallelGroup(
										javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(showAll).addComponent(edit,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE))
						.addGap(19, 19, 19)));
	}

	public void paint() {
		String recipeString = "";
		String nameString = "Name: ";
    	Recipe cur = CookBook.getInstance().getCurrentRecipe();

        if (CookBook.getInstance() != null && cur != null) {
        	recipeString = cur.toString();
        	nameString += cur.getName();
        }
    	
        recipeDisplayTextArea.setText(recipeString);
        recipeNameLabel.setText(nameString);
    }
}
