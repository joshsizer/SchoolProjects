package gui;

import javax.swing.JPanel;

/**
 *
 * @author Josh
 */
@SuppressWarnings("serial")
public class EditPanel extends JPanel {
    protected javax.swing.JButton cancel;
    protected javax.swing.JScrollPane ingredientsScrollPane;
    protected javax.swing.JTextArea ingredientsTextArea;
    protected javax.swing.JLabel noteLabel;
    protected javax.swing.JLabel recipeLabel;
    protected javax.swing.JLabel recipeNameLabel;
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

        stepsScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        stepsTextArea.setColumns(20);
        stepsTextArea.setLineWrap(true);
        stepsTextArea.setRows(5);
        stepsScrollPane.setViewportView(stepsTextArea);

        ingredientsScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        ingredientsTextArea.setColumns(20);
        ingredientsTextArea.setRows(5);
        ingredientsScrollPane.setViewportView(ingredientsTextArea);

        recipeLabel.setText("Ingredients:");

        save.setText("Save");

        cancel.setText("Cancel");
        cancel.addActionListener(new Actions.CancelEdit());

        recipeNameLabel.setText("Steps:");
        recipeNameLabel.setToolTipText("");

        noteLabel.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        noteLabel.setText("(Note: New lines separate ingredients and steps)");

        javax.swing.GroupLayout editPanelLayout = new javax.swing.GroupLayout(this);
        setLayout(editPanelLayout);
        editPanelLayout.setHorizontalGroup(
            editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editPanelLayout.createSequentialGroup()
                        .addGroup(editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ingredientsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(recipeLabel))
                        .addGap(13, 13, 13)
                        .addGroup(editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(recipeNameLabel)
                            .addComponent(stepsScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editPanelLayout.createSequentialGroup()
                        .addComponent(noteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                        .addGap(48, 48, 48)
                        .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancel)))
                .addContainerGap())
        );
        editPanelLayout.setVerticalGroup(
            editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(recipeNameLabel)
                    .addComponent(recipeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ingredientsScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(stepsScrollPane))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save)
                    .addComponent(cancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(noteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }

}
