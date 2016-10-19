package gui;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

import cookbook.Category;

/**
 * The edit panel for this program. This is where the user can edit and add
 * recipes to the cook book. The GUI code was taken from netbeans, and
 * action listeners were added to the components. 
 * 
 * @author Josh Sizer
 */
@SuppressWarnings("serial")
public class EditPanel extends JPanel {
	protected JButton addCategory;
	protected JButton cancel;
	protected JList<Integer> categoryList;
	protected JScrollPane categoryListScrollPane;
	protected JComboBox<Integer> categorySelection;
	protected JScrollPane ingredientsScrollPane;
	protected JTextArea ingredientsTextArea;
	protected JLabel nameLabel;
	protected JTextField nameTextField;
	protected JLabel noteLabel;
	protected JLabel recipeLabel;
	protected JLabel recipeNameLabel;
	protected JButton remove;
	protected JButton save;
	protected JScrollPane stepsScrollPane;
	protected JTextArea stepsTextArea;

	public EditPanel() {
		initComponents();
	}

	private void initComponents() {
		stepsScrollPane = new JScrollPane();
		stepsTextArea = new JTextArea();
		ingredientsScrollPane = new JScrollPane();
		ingredientsTextArea = new JTextArea();
		recipeLabel = new JLabel();
		save = new JButton();
		cancel = new JButton();
		recipeNameLabel = new JLabel();
		noteLabel = new JLabel();
		categoryListScrollPane = new JScrollPane();
		categoryList = new JList<Integer>();
		addCategory = new JButton();
		categorySelection = new JComboBox<Integer>();
		remove = new JButton();
		nameTextField = new JTextField();
		nameLabel = new JLabel();

		stepsScrollPane.setVerticalScrollBarPolicy(
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		stepsTextArea.setColumns(20);
		stepsTextArea.setLineWrap(false);
		stepsTextArea.setRows(5);
		stepsScrollPane.setViewportView(stepsTextArea);

		ingredientsScrollPane.setHorizontalScrollBarPolicy(
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

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
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

		categoryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		categoryList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		categoryList.setCellRenderer(new CategoryRenderer());
		categoryListScrollPane.setViewportView(categoryList);

		addCategory.setText("Add");
		addCategory.addActionListener(new Actions.AddCategory());

		Integer[] allCategories = new Integer[Category.numberOfCategories];
		for (int i = 0; i < allCategories.length; i++) {
			allCategories[i] = i;
		}
		categorySelection.setRenderer(new CategoryRenderer());
		categorySelection.setModel(new DefaultComboBoxModel<Integer>(allCategories));

		remove.setText("Remove");
		remove.addActionListener(new Actions.RemoveCategory());

		nameLabel.setText("Name:");

		GroupLayout editPanelLayout = new GroupLayout(this);
		setLayout(editPanelLayout);
		editPanelLayout.setHorizontalGroup(editPanelLayout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(editPanelLayout
						.createSequentialGroup().addContainerGap().addGroup(
								editPanelLayout.createParallelGroup(
										GroupLayout.Alignment.LEADING).addGroup(
												editPanelLayout
														.createSequentialGroup()
														.addGroup(
																editPanelLayout
																		.createParallelGroup(
																				GroupLayout.Alignment.LEADING)
																		.addComponent(
																				ingredientsScrollPane,
																				GroupLayout.PREFERRED_SIZE,
																				123,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				recipeLabel))
														.addPreferredGap(
																LayoutStyle.ComponentPlacement.RELATED)
														.addGroup(
																editPanelLayout
																		.createParallelGroup(
																				GroupLayout.Alignment.LEADING)
																		.addGroup(
																				editPanelLayout
																						.createSequentialGroup()
																						.addComponent(
																								addCategory)
																						.addPreferredGap(
																								LayoutStyle.ComponentPlacement.RELATED)
																						.addComponent(
																								categorySelection,
																								GroupLayout.PREFERRED_SIZE,
																								99,
																								GroupLayout.PREFERRED_SIZE)
																						.addPreferredGap(
																								LayoutStyle.ComponentPlacement.RELATED)
																						.addComponent(
																								remove)
																						.addGap(0,
																								0,
																								Short.MAX_VALUE))
																		.addGroup(
																				GroupLayout.Alignment.TRAILING,
																				editPanelLayout
																						.createSequentialGroup()
																						.addGroup(
																								editPanelLayout
																										.createParallelGroup(
																												GroupLayout.Alignment.TRAILING)
																										.addGroup(
																												editPanelLayout
																														.createSequentialGroup()
																														.addPreferredGap(
																																LayoutStyle.ComponentPlacement.RELATED,
																																GroupLayout.DEFAULT_SIZE,
																																Short.MAX_VALUE)
																														.addComponent(
																																save,
																																GroupLayout.PREFERRED_SIZE,
																																83,
																																GroupLayout.PREFERRED_SIZE)
																														.addPreferredGap(
																																LayoutStyle.ComponentPlacement.RELATED)
																														.addComponent(
																																cancel))
																										.addGroup(
																												editPanelLayout
																														.createSequentialGroup()
																														.addComponent(
																																recipeNameLabel)
																														.addPreferredGap(
																																LayoutStyle.ComponentPlacement.RELATED,
																																GroupLayout.DEFAULT_SIZE,
																																Short.MAX_VALUE)
																														.addComponent(
																																nameLabel)
																														.addPreferredGap(
																																LayoutStyle.ComponentPlacement.RELATED)
																														.addComponent(
																																nameTextField,
																																GroupLayout.PREFERRED_SIZE,
																																90,
																																GroupLayout.PREFERRED_SIZE))
																										.addComponent(
																												stepsScrollPane,
																												GroupLayout.Alignment.LEADING)
																										.addComponent(
																												categoryListScrollPane,
																												GroupLayout.Alignment.LEADING))
																						.addGap(26,
																								26,
																								26))))
										.addGroup(
												GroupLayout.Alignment.TRAILING,
												editPanelLayout
														.createSequentialGroup()
														.addComponent(noteLabel,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addGap(201, 201,
																201)))));
		editPanelLayout.setVerticalGroup(editPanelLayout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(editPanelLayout
						.createSequentialGroup().addGap(13, 13, 13).addGroup(
								editPanelLayout.createParallelGroup(
										GroupLayout.Alignment.BASELINE)
										.addComponent(recipeNameLabel)
										.addComponent(recipeLabel).addComponent(
												nameTextField,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(nameLabel))
						.addPreferredGap(
								LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(editPanelLayout.createParallelGroup(
								GroupLayout.Alignment.LEADING).addComponent(
										ingredientsScrollPane).addGroup(
												editPanelLayout
														.createSequentialGroup()
														.addComponent(
																stepsScrollPane,
																GroupLayout.DEFAULT_SIZE,
																93,
																Short.MAX_VALUE)
														.addGap(10, 10, 10)
														.addGroup(
																editPanelLayout
																		.createParallelGroup(
																				GroupLayout.Alignment.BASELINE)
																		.addComponent(
																				addCategory)
																		.addComponent(
																				categorySelection,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				remove))
														.addPreferredGap(
																LayoutStyle.ComponentPlacement.UNRELATED)
														.addComponent(
																categoryListScrollPane,
																GroupLayout.PREFERRED_SIZE,
																66,
																GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(editPanelLayout.createParallelGroup(
								GroupLayout.Alignment.BASELINE).addComponent(
										save).addComponent(cancel,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE).addComponent(
														noteLabel,
														GroupLayout.PREFERRED_SIZE,
														13,
														GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
	}

}
