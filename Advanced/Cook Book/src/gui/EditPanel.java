package gui;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;

import cookbook.Category;

/**
 *
 * @author Josh
 */
@SuppressWarnings("serial")
public class EditPanel extends JPanel {
	protected javax.swing.JButton addCategory;
	protected javax.swing.JButton cancel;
	protected javax.swing.JList<Integer> categoryList;
	protected javax.swing.JScrollPane categoryListScrollPane;
	protected javax.swing.JComboBox<Integer> categorySelection;
	protected javax.swing.JScrollPane ingredientsScrollPane;
	protected javax.swing.JTextArea ingredientsTextArea;
	protected javax.swing.JLabel nameLabel;
	protected javax.swing.JTextField nameTextField;
	protected javax.swing.JLabel noteLabel;
	protected javax.swing.JLabel recipeLabel;
	protected javax.swing.JLabel recipeNameLabel;
	protected javax.swing.JButton remove;
	protected javax.swing.JButton save;
	protected javax.swing.JScrollPane stepsScrollPane;
	protected javax.swing.JTextArea stepsTextArea;

	public EditPanel() {
		initComponents();
	}

	private void initComponents() {
		stepsScrollPane = new javax.swing.JScrollPane();
		stepsTextArea = new javax.swing.JTextArea();
		ingredientsScrollPane = new javax.swing.JScrollPane();
		ingredientsTextArea = new javax.swing.JTextArea();
		recipeLabel = new javax.swing.JLabel();
		save = new javax.swing.JButton();
		cancel = new javax.swing.JButton();
		recipeNameLabel = new javax.swing.JLabel();
		noteLabel = new javax.swing.JLabel();
		categoryListScrollPane = new javax.swing.JScrollPane();
		categoryList = new javax.swing.JList<Integer>();
		addCategory = new javax.swing.JButton();
		categorySelection = new javax.swing.JComboBox<Integer>();
		remove = new javax.swing.JButton();
		nameTextField = new javax.swing.JTextField();
		nameLabel = new javax.swing.JLabel();

		stepsScrollPane.setVerticalScrollBarPolicy(
				javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		stepsTextArea.setColumns(20);
		stepsTextArea.setLineWrap(true);
		stepsTextArea.setRows(5);
		stepsScrollPane.setViewportView(stepsTextArea);

		ingredientsScrollPane.setHorizontalScrollBarPolicy(
				javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		ingredientsTextArea.setColumns(20);
		ingredientsTextArea.setRows(5);
		ingredientsScrollPane.setViewportView(ingredientsTextArea);

		recipeLabel.setText("Ingredients:");

		save.setText("Save");
		save.addActionListener(new Actions.SaveRecipe());

		cancel.setText("Cancel");
		cancel.addActionListener(new Actions.CancelEdit());

		recipeNameLabel.setText("Steps:");
		recipeNameLabel.setToolTipText("");

		noteLabel.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
		noteLabel.setText("(Note: New lines separate ingredients and steps)");

		categoryListScrollPane.setVerticalScrollBarPolicy(
				javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

		categoryList.setSelectionMode(
				javax.swing.ListSelectionModel.SINGLE_SELECTION);
		categoryList.setLayoutOrientation(javax.swing.JList.HORIZONTAL_WRAP);
		categoryList.setCellRenderer(new CategoryRenderer());
		categoryListScrollPane.setViewportView(categoryList);

		addCategory.setText("Add");

		Integer[] allCategories = new Integer[Category.numberOfCategories];
		for (int i = 0; i < allCategories.length; i++) {
			allCategories[i] = i;
		}
		categorySelection.setRenderer(new CategoryRenderer());
		categorySelection.setModel(new DefaultComboBoxModel<Integer>(allCategories));
		

		remove.setText("Remove");

		nameLabel.setText("Name:");

		javax.swing.GroupLayout editPanelLayout = new javax.swing.GroupLayout(
				this);
		setLayout(editPanelLayout);
		editPanelLayout.setHorizontalGroup(editPanelLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
						editPanelLayout.createSequentialGroup()
								.addContainerGap().addGroup(editPanelLayout
										.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(editPanelLayout
												.createSequentialGroup()
												.addGroup(editPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																ingredientsScrollPane,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																123,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																recipeLabel))
												.addPreferredGap(
														javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addGroup(editPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																editPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				addCategory)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				categorySelection,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				99,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				remove)
																		.addGap(0,
																				0,
																				Short.MAX_VALUE))
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																editPanelLayout
																		.createSequentialGroup()
																		.addGroup(
																				editPanelLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING)
																						.addGroup(
																								editPanelLayout
																										.createSequentialGroup()
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												Short.MAX_VALUE)
																										.addComponent(
																												save,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												83,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												cancel))
																						.addGroup(
																								editPanelLayout
																										.createSequentialGroup()
																										.addComponent(
																												recipeNameLabel)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												Short.MAX_VALUE)
																										.addComponent(
																												nameLabel)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												nameTextField,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												90,
																												javax.swing.GroupLayout.PREFERRED_SIZE))
																						.addComponent(
																								stepsScrollPane,
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								categoryListScrollPane,
																								javax.swing.GroupLayout.Alignment.LEADING))
																		.addGap(26,
																				26,
																				26))))
										.addGroup(
												javax.swing.GroupLayout.Alignment.TRAILING,
												editPanelLayout
														.createSequentialGroup()
														.addComponent(noteLabel,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addGap(201, 201,
																201)))));
		editPanelLayout.setVerticalGroup(editPanelLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
						editPanelLayout.createSequentialGroup().addGap(13, 13,
								13).addGroup(editPanelLayout
										.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(recipeNameLabel)
										.addComponent(recipeLabel).addComponent(
												nameTextField,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(nameLabel))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(editPanelLayout.createParallelGroup(
										javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(ingredientsScrollPane)
										.addGroup(editPanelLayout
												.createSequentialGroup()
												.addComponent(stepsScrollPane,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														93, Short.MAX_VALUE)
												.addGap(10, 10, 10).addGroup(
														editPanelLayout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.BASELINE)
																.addComponent(
																		addCategory)
																.addComponent(
																		categorySelection,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(
																		remove))
												.addPreferredGap(
														javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(
														categoryListScrollPane,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														66,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(editPanelLayout.createParallelGroup(
										javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(save).addComponent(cancel,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE).addComponent(
														noteLabel,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														13,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addContainerGap()));
	}

}
