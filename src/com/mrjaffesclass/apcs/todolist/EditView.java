package com.mrjaffesclass.apcs.todolist;

import com.mrjaffesclass.apcs.messenger.*;

/**
 * View for editing to do items
 *
 * @author Rachel Schmeltzer, Rebekah Leslie, and Ann Tran
 * @version 1.0
 */
public class EditView extends javax.swing.JDialog implements MessageHandler {

    // Instance variables
    //  item:       The item being edited
    //  messenger:  The messenger object
    ToDoItem item;
    Messenger messenger;

    /**
     * Creates new form to edit the to do item
     *
     * @param parent The main window
     * @param _item The to do item to edit
     * @param _messenger Messenger class
     */
    public EditView(java.awt.Frame parent, ToDoItem _item, Messenger _messenger) {
        super(parent, true);
        item = _item;
        messenger = _messenger;
        this.setLocationRelativeTo(parent); // Set window location near the main window
        initComponents();
        setFieldValues();
    }

    // This method implements the messageHandler method defined in
    // the MessageHandler interface
    @Override
    public void messageHandler(String messageName, Object messagePayload) {
        // Received confirmation message that data was processed... 
        // close the edit dialog
        if (messageName.equals("saved")) {
            cancelBtnActionPerformed(null);
        }
    }

    /**
     * Initialize the view after object is constructed
     */
    public void init() {
        messenger.subscribe("saved", this);
    }

    /**
     * Initialize the values in the edit fields
     */
    private void setFieldValues() {
        descriptionText.setText(item.getDescription());
        completedCheckBox.setSelected(item.isDone());
    }

    /**
     * Get editing fields from form and save in the item
     */
    private void getValues() {
        item.setDescription(descriptionText.getText());
        item.setDone(completedCheckBox.isSelected());
        item.setDate(datePicker.getDate());
    }

    /**
     * Save or delete the item as appropriate
     *
     * @param action "save" or "delete"
     */
    private void itemAction(String action) {
        getValues();
        switch (action) {
            case "save":
                messenger.notify("saveItem", item, true);
                break;

            case "delete":
                messenger.notify("deleteItem", item, true);
                break;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        editLabel = new javax.swing.JLabel();
        cancelBtn = new javax.swing.JButton();
        okBtn = new javax.swing.JButton();
        descriptionLabel = new javax.swing.JLabel();
        descriptionScrollPane = new javax.swing.JScrollPane();
        descriptionText = new javax.swing.JTextArea();
        completedCheckBox = new javax.swing.JCheckBox();
        completionLabel = new javax.swing.JLabel();
        deleteBtn = new javax.swing.JButton();
        datePicker = new org.jdesktop.swingx.JXDatePicker();
        dateLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        editLabel.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        editLabel.setText("Edit To Do Item");

        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        okBtn.setText("OK");
        okBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okBtnActionPerformed(evt);
            }
        });

        descriptionLabel.setText("Description");

        descriptionText.setBackground(new java.awt.Color(0, 255, 102));
        descriptionText.setColumns(20);
        descriptionText.setLineWrap(true);
        descriptionText.setRows(5);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, descriptionText, org.jdesktop.beansbinding.ELProperty.create("${s}"), descriptionText, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        descriptionScrollPane.setViewportView(descriptionText);

        completionLabel.setText("Completed");

        deleteBtn.setText("Delete item");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        dateLabel.setText("Date");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editLabel)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(deleteBtn)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(okBtn)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cancelBtn))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(completionLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(completedCheckBox)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dateLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(datePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(descriptionLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(descriptionScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(editLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(completionLabel)
                                .addComponent(completedCheckBox))
                            .addComponent(datePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(descriptionLabel)
                            .addComponent(descriptionScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(okBtn)
                                .addComponent(cancelBtn))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(deleteBtn)
                                .addContainerGap())))
                    .addComponent(dateLabel)))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

  private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
      this.dispose(); // Close and dispose of the dialog
  }//GEN-LAST:event_cancelBtnActionPerformed

  private void okBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okBtnActionPerformed
      itemAction("save");
  }//GEN-LAST:event_okBtnActionPerformed

  private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
      itemAction("delete");
  }//GEN-LAST:event_deleteBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JCheckBox completedCheckBox;
    private javax.swing.JLabel completionLabel;
    private javax.swing.JLabel dateLabel;
    private org.jdesktop.swingx.JXDatePicker datePicker;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JScrollPane descriptionScrollPane;
    private javax.swing.JTextArea descriptionText;
    private javax.swing.JLabel editLabel;
    private javax.swing.JButton okBtn;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
