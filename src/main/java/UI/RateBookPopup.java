/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Gia Naicker
 */
public class RateBookPopup extends javax.swing.JFrame {

    /**
     * Creates new form RateBook
     */
    BookBuddy parent;

    public RateBookPopup(BookBuddy parent) {
        initComponents();
        setLocationRelativeTo(null);
        this.parent = parent;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        rateOrCommentLabel = new javax.swing.JLabel();
        selectRatingLabel = new javax.swing.JLabel();
        selectRatingSpinner = new javax.swing.JSpinner();
        commentLabel = new javax.swing.JLabel();
        closeRateBookScreenButton = new javax.swing.JButton();
        confirmRatingButton = new javax.swing.JButton();
        pleaseLeaveRatingLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        commentTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        rateOrCommentLabel.setFont(new java.awt.Font("Impact", 0, 35)); // NOI18N
        rateOrCommentLabel.setForeground(new java.awt.Color(0, 0, 0));
        rateOrCommentLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rateOrCommentLabel.setText("Before you return this book...");
        rateOrCommentLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        selectRatingLabel.setFont(new java.awt.Font("Impact", 0, 15)); // NOI18N
        selectRatingLabel.setForeground(new java.awt.Color(0, 0, 0));
        selectRatingLabel.setText("Select a value from 0 - 5:");

        selectRatingSpinner.setFont(new java.awt.Font("Impact", 0, 15)); // NOI18N
        selectRatingSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1));

        commentLabel.setFont(new java.awt.Font("Impact", 0, 15)); // NOI18N
        commentLabel.setForeground(new java.awt.Color(0, 0, 0));
        commentLabel.setText("Leave a comment?");

        closeRateBookScreenButton.setText("Ignore");
        closeRateBookScreenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeRateBookScreenButtonActionPerformed(evt);
            }
        });

        confirmRatingButton.setText("Confirm Rating");
        confirmRatingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmRatingButtonActionPerformed(evt);
            }
        });

        pleaseLeaveRatingLabel.setFont(new java.awt.Font("Impact", 0, 15)); // NOI18N
        pleaseLeaveRatingLabel.setForeground(new java.awt.Color(0, 0, 0));
        pleaseLeaveRatingLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pleaseLeaveRatingLabel.setText("Please leave a rating or comment!");

        commentTextArea.setColumns(20);
        commentTextArea.setRows(5);
        jScrollPane1.setViewportView(commentTextArea);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rateOrCommentLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pleaseLeaveRatingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(selectRatingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(selectRatingSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(commentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(confirmRatingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(closeRateBookScreenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(34, 34, 34))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(rateOrCommentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pleaseLeaveRatingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(selectRatingLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(selectRatingSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(commentLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(closeRateBookScreenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmRatingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeRateBookScreenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeRateBookScreenButtonActionPerformed
        JOptionPane.showMessageDialog(null, "This book has been returned.", "Confirmation Message", JOptionPane.INFORMATION_MESSAGE);
        dispose();
        try {
            parent.bm.getHighestRatedBooks();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RateBookPopup.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RateBookPopup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_closeRateBookScreenButtonActionPerformed

    private void confirmRatingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmRatingButtonActionPerformed
        int rating = (int) selectRatingSpinner.getValue();
        String comment = commentTextArea.getText();
        //pass these values into a function in bookBuddy, then call a method in bookManager using those values as arguments

    }//GEN-LAST:event_confirmRatingButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeRateBookScreenButton;
    private javax.swing.JLabel commentLabel;
    private javax.swing.JTextArea commentTextArea;
    private javax.swing.JButton confirmRatingButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel pleaseLeaveRatingLabel;
    private javax.swing.JLabel rateOrCommentLabel;
    private javax.swing.JLabel selectRatingLabel;
    private javax.swing.JSpinner selectRatingSpinner;
    // End of variables declaration//GEN-END:variables
}
