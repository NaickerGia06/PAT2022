/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import BackendDatatypes.Student;
import BackendManagerClasses.StudentManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Gia Naicker
 */
public class EditStudentPopup extends javax.swing.JFrame {

    BookBuddy parent;
    Student s;
    StudentManager sm;

    //CONSTRUCTOR
    public EditStudentPopup(BookBuddy parent, Student s) throws ClassNotFoundException, SQLException {
        initComponents();
        setLocationRelativeTo(null);

        this.s = s;

        firstNameTextField.setText(s.getName());
        surnameTextField.setText(s.getSurname());
        gradeComboBox.setSelectedItem(String.valueOf(s.getGrade()));

        //populates comboBox with grades from 8-12
        setGradeComboBox();

        this.parent = parent;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        editAStudentLabel = new javax.swing.JLabel();
        firstNameLabel = new javax.swing.JLabel();
        firstNameTextField = new javax.swing.JTextField();
        surnameLabel = new javax.swing.JLabel();
        surnameTextField = new javax.swing.JTextField();
        gradeLabel1 = new javax.swing.JLabel();
        gradeComboBox = new javax.swing.JComboBox<>();
        editStudentButton = new javax.swing.JButton();
        closeEditStudentButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        editAStudentLabel.setFont(new java.awt.Font("Impact", 0, 35)); // NOI18N
        editAStudentLabel.setForeground(new java.awt.Color(0, 0, 0));
        editAStudentLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        editAStudentLabel.setText("Edit Information");
        editAStudentLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        firstNameLabel.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        firstNameLabel.setForeground(new java.awt.Color(0, 0, 0));
        firstNameLabel.setText("First Name");

        surnameLabel.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        surnameLabel.setForeground(new java.awt.Color(0, 0, 0));
        surnameLabel.setText("Surname");

        gradeLabel1.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        gradeLabel1.setForeground(new java.awt.Color(0, 0, 0));
        gradeLabel1.setText("Grade");

        gradeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        editStudentButton.setText("Edit");
        editStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editStudentButtonActionPerformed(evt);
            }
        });

        closeEditStudentButton.setText("Close");
        closeEditStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeEditStudentButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(editAStudentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(editStudentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(closeEditStudentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(surnameLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(firstNameLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(gradeLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(surnameTextField)
                            .addComponent(gradeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(firstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(editAStudentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(surnameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(surnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(gradeLabel1)
                            .addComponent(gradeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(firstNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(firstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(editStudentButton, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(closeEditStudentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //SETS MODELS
    public void setGradeComboBox() throws ClassNotFoundException, SQLException {
        sm = new StudentManager();
        DefaultComboBoxModel filterByGradeModel = new DefaultComboBoxModel();
        ArrayList<String> grades2 = sm.getGrades();
        filterByGradeModel.addAll(grades2);
        gradeComboBox.setModel(filterByGradeModel);
    }

    //SETS TABLE
    //ADDS STUDENT TO THE DATABASE WHEN BUTTON IS CLICKED
    private void editStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editStudentButtonActionPerformed

        int studentID = s.getStudentID();
        String firstName = firstNameTextField.getText();
        String surname = surnameTextField.getText();
        int grade = Integer.parseInt((String) (gradeComboBox.getSelectedItem()));
        try {
            try {
                sm.updateStudentInformation(studentID, firstName, surname, grade);
                parent.populateStudentsTable();
                JOptionPane.showMessageDialog(null, "This student's information has been updated.", "Confirmation Message", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } catch (SQLException ex) {
                Logger.getLogger(EditStudentPopup.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookBuddy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_editStudentButtonActionPerformed

    private void closeEditStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeEditStudentButtonActionPerformed
        dispose();
    }//GEN-LAST:event_closeEditStudentButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeEditStudentButton;
    private javax.swing.JLabel editAStudentLabel;
    private javax.swing.JButton editStudentButton;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JTextField firstNameTextField;
    private javax.swing.JComboBox<String> gradeComboBox;
    private javax.swing.JLabel gradeLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel surnameLabel;
    private javax.swing.JTextField surnameTextField;
    // End of variables declaration//GEN-END:variables
}
