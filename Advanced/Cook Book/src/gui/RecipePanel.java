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
	private javax.swing.JButton edit;
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenu jMenu2;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JScrollPane recipeDisplayScrollPane;
	private javax.swing.JTextArea recipeDisplayTextArea;
	private javax.swing.JLabel recipeLabel;
	private javax.swing.JList<String> recipeList;
	private javax.swing.JScrollPane recipeListScrollPane;
	private javax.swing.JLabel recipeNameLabel;
	private javax.swing.JButton showAll;

	public RecipePanel() {
		initComponents();
	}

	private void initComponents() {
		recipeDisplayScrollPane = new javax.swing.JScrollPane();
		recipeDisplayTextArea = new javax.swing.JTextArea();
		recipeListScrollPane = new javax.swing.JScrollPane();
		recipeList = new javax.swing.JList<>();
		recipeLabel = new javax.swing.JLabel();
		showAll = new javax.swing.JButton();
		edit = new javax.swing.JButton();
		recipeNameLabel = new javax.swing.JLabel();
		
		recipeDisplayScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		recipeDisplayTextArea.setColumns(20);
		recipeDisplayTextArea.setLineWrap(true);
		recipeDisplayTextArea.setRows(5);
		recipeDisplayScrollPane.setViewportView(recipeDisplayTextArea);

		recipeListScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		recipeList.setModel(new javax.swing.AbstractListModel<String>() {
			String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };

			public int getSize() {
				return strings.length;
			}

			public String getElementAt(int i) {
				return strings[i];
			}
		});
		recipeListScrollPane.setViewportView(recipeList);

		recipeLabel.setText("Recipes");

		showAll.setText("Show All");

		edit.setText("Edit");

		recipeNameLabel.setText("Name: ");
		recipeNameLabel.setToolTipText("");

		javax.swing.GroupLayout RecipePanelLayout = new javax.swing.GroupLayout(this);
		setLayout(RecipePanelLayout);
		RecipePanelLayout.setHorizontalGroup(RecipePanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(RecipePanelLayout.createSequentialGroup().addContainerGap().addGroup(RecipePanelLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(recipeListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 101,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGroup(RecipePanelLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(showAll,
								javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(RecipePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RecipePanelLayout
										.createSequentialGroup()
										.addComponent(recipeDisplayScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE,
												244, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										RecipePanelLayout.createSequentialGroup().addComponent(edit).addGap(107, 107,
												107))))
				.addGroup(RecipePanelLayout.createSequentialGroup().addGap(38, 38, 38).addComponent(recipeLabel)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(recipeNameLabel).addGap(149, 149, 149)));
		RecipePanelLayout.setVerticalGroup(RecipePanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(RecipePanelLayout.createSequentialGroup().addGap(16, 16, 16)
						.addGroup(RecipePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(recipeNameLabel).addComponent(recipeLabel))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(
								RecipePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(recipeListScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 206,
												Short.MAX_VALUE)
										.addComponent(recipeDisplayScrollPane))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(RecipePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(showAll).addComponent(edit, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
	}
}
