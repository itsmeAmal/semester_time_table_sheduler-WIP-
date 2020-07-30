/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttms.ui;

import com.ttms.controller.commonController;
import com.ttms.controller.lecturerController;
import com.ttms.daoimpl.lecturerDaoImpl;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Amal
 */
public class manageLecturers extends javax.swing.JFrame {

    /**
     * Creates new form addStudent
     */
    public manageLecturers() {
        initComponents();
        loadLecturerData();
    }

    private void clearAll() {
        txtContactNo.setText("");
        txtDetail.setText("");
        txtEmail1.setText("");
        txtName.setText("");
    }

    private void addLecturer() {
        try {
            int option = JOptionPane.showConfirmDialog(this, "Are you sure you want to save this lecturer details ?");
            if (option == JOptionPane.YES_OPTION) {
                boolean status = lecturerController.addLecturer(comboTitle.getSelectedItem().toString(), txtName.getText().trim(),
                        txtEmail1.getText().trim(), txtContactNo.getText().trim(), txtDetail.getText().trim());
                if (status) {
                    JOptionPane.showMessageDialog(this, "Lecturer registered successfully !");
                    clearAll();
                    loadLecturerData();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(manageLecturers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadLecturerData() {
        try {
            ResultSet rset = new lecturerDaoImpl().getAlllecturers();
            String[] columnList = {"lecturer_id", "lecturer_name", "lecturer_email", "lecturer_contact_no", "lecturer_detail"};
            commonController.loadDataToTable(tblLectures, rset, columnList);
        } catch (SQLException ex) {
            Logger.getLogger(manageLecturers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void editSelectedCourse() {
        int selectedRaw = tblLectures.getSelectedRow();
        if (selectedRaw == -1) {
            JOptionPane.showMessageDialog(this, "Please select the row you want to update !", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        DefaultTableModel dtm = (DefaultTableModel) tblLectures.getModel();
        int lecturerId = commonController.getIntOrZeroFromString(dtm.getValueAt(selectedRaw, 0).toString());
        new editLecturer(this, true, lecturerId).setVisible(true);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLectures = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        txtName = new javax.swing.JTextField();
        txtEmail1 = new javax.swing.JTextField();
        txtContactNo = new javax.swing.JTextField();
        comboTitle = new javax.swing.JComboBox<>();
        txtDetail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btSave = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        Email = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        txtContactNo1 = new javax.swing.JTextField();
        btnEdit1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lecturer Management");
        setMaximumSize(new java.awt.Dimension(1340, 643));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblLectures.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        tblLectures.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "lecture id", "Name", "Email", "Contact No", "Detail"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLectures.setRowHeight(20);
        tblLectures.setRowMargin(2);
        tblLectures.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblLectures);
        if (tblLectures.getColumnModel().getColumnCount() > 0) {
            tblLectures.getColumnModel().getColumn(0).setMinWidth(0);
            tblLectures.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblLectures.getColumnModel().getColumn(0).setMaxWidth(0);
            tblLectures.getColumnModel().getColumn(1).setResizable(false);
            tblLectures.getColumnModel().getColumn(2).setResizable(false);
            tblLectures.getColumnModel().getColumn(3).setResizable(false);
            tblLectures.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(332, 83, 1002, 554));

        jPanel2.setBackground(new java.awt.Color(0, 0, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtName.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        txtName.setToolTipText("Lecturer Name");
        txtName.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txtName.setSelectionColor(new java.awt.Color(255, 255, 0));

        txtEmail1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        txtEmail1.setToolTipText("Email ");
        txtEmail1.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txtEmail1.setSelectionColor(new java.awt.Color(255, 255, 0));

        txtContactNo.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        txtContactNo.setToolTipText("Contact No");
        txtContactNo.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txtContactNo.setSelectionColor(new java.awt.Color(255, 255, 0));

        comboTitle.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        comboTitle.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mr", "Mrs", "Miss", "Dr" }));
        comboTitle.setToolTipText("Title");

        txtDetail.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        txtDetail.setToolTipText("Details / Remarks");
        txtDetail.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txtDetail.setSelectionColor(new java.awt.Color(255, 255, 0));

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ttms/lableIcons/email.PNG"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ttms/lableIcons/Detail.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ttms/lableIcons/Contact_Num.png"))); // NOI18N

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ttms/lableIcons/Name.png"))); // NOI18N

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ttms/lableIcons/User_Title.png"))); // NOI18N

        btSave.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        btSave.setForeground(new java.awt.Color(255, 255, 255));
        btSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ttms/labelIcons2/saveIcon_green.png"))); // NOI18N
        btSave.setToolTipText("Add new lecturer");
        btSave.setBorder(null);
        btSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Title");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Lecturer Name");

        Email.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        Email.setForeground(new java.awt.Color(255, 255, 255));
        Email.setText("Email");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Contact No");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Details / Remark");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboTitle, 0, 251, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btSave, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(22, 22, 22))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Email)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel22)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btSave, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(238, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 322, 643));

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ttms/labelIcons2/editIcon.png"))); // NOI18N
        btnEdit.setToolTipText("Edit Lecturer Details");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel1.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 20, 40, 40));

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ttms/labelIcons2/deleteIcon.png"))); // NOI18N
        btnDelete.setToolTipText("Delete Lecturer Details");
        jPanel1.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 20, 40, 40));

        txtContactNo1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        txtContactNo1.setToolTipText("Search by Name");
        txtContactNo1.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txtContactNo1.setSelectionColor(new java.awt.Color(255, 255, 0));
        jPanel1.add(txtContactNo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 340, 40));

        btnEdit1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ttms/labelIcons2/searchIcon.png"))); // NOI18N
        btnEdit1.setToolTipText("Search");
        btnEdit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEdit1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnEdit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 20, 40, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed
        addLecturer();
        clearAll();
        loadLecturerData();
    }//GEN-LAST:event_btSaveActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        editSelectedCourse();
        loadLecturerData();
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnEdit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEdit1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEdit1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(manageLecturers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(manageLecturers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(manageLecturers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(manageLecturers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new manageLecturers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Email;
    private javax.swing.JButton btSave;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnEdit1;
    private javax.swing.JComboBox<String> comboTitle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblLectures;
    private javax.swing.JTextField txtContactNo;
    private javax.swing.JTextField txtContactNo1;
    private javax.swing.JTextField txtDetail;
    private javax.swing.JTextField txtEmail1;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
