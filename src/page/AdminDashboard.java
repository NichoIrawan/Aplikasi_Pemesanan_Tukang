package tubespbo.src;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import tubespbo.src.component.koneksi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class AdminDashboard extends javax.swing.JFrame {    
    public AdminDashboard() {
        initComponents();
        loadUserAndTukangData();
    }
    private void loadUserAndTukangData() {
        DefaultTableModel model = (DefaultTableModel) tblUser.getModel();
        model.setRowCount(0);

        try (Connection conn = koneksi.connect()) {
            String query = "SELECT u.id, u.nama, u.email, u.no_hp, u.hak_akses, u.status, t.verification FROM user u LEFT JOIN tukang t ON u.id = t.id_user";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("nama"),
                    rs.getString("email"),
                    rs.getString("no_hp"), 
                    rs.getString("hak_akses"),
                    rs.getString("status"),
                    rs.getString("verification")
                });
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Gagal memuat data user dan tukang!");
        }
    }
    
    private void suspendAccount(int userId) {
        try (Connection conn = koneksi.connect()) {
            String query = "UPDATE user SET status = 'suspended' WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, userId);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Akun berhasil ditangguhkan!");
                loadUserAndTukangData();
            } else {
                JOptionPane.showMessageDialog(this, "Gagal menangguhkan akun!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menangguhkan akun!");
        }
    }
    
    private void verifyCertification(int userId) {
        try (Connection conn = koneksi.connect()) {
            String query = "UPDATE tukang SET verification = 'verified' WHERE id_user = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, userId);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Sertifikasi berhasil diverifikasi!");
                loadUserAndTukangData();
            } else {
                JOptionPane.showMessageDialog(this, "Gagal memverifikasi sertifikasi!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat memverifikasi sertifikasi!");
        }
    }       
    
    private void updateRole(int userId, String newRole) {
        try (Connection conn = koneksi.connect()) {
            String selectQuery = "SELECT hak_akses FROM user WHERE id = ?";
            PreparedStatement selectStmt = conn.prepareStatement(selectQuery);
            selectStmt.setInt(1, userId);
            ResultSet rs = selectStmt.executeQuery();

            if (rs.next()) {
                String currentRole = rs.getString("hak_akses");
                if (!currentRole.equals(newRole)) {
                    String updateQuery = "UPDATE user SET hak_akses = ? WHERE id = ?";
                    PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
                    updateStmt.setString(1, newRole);
                    updateStmt.setInt(2, userId);

                    int rowsAffected = updateStmt.executeUpdate();
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(this, "Role berhasil diubah menjadi " + newRole + "!");
                        loadUserAndTukangData(); 
                    } else {
                        JOptionPane.showMessageDialog(this, "Gagal mengubah role!");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Role sudah sesuai!");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat mengubah role!");
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtAccountId = new javax.swing.JTextField();
        btnSuspendAccount = new javax.swing.JButton();
        btnVerifyCertification = new javax.swing.JButton();
        btnCallDatabase = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        outputArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblUser = new javax.swing.JTable();
        btnActive = new javax.swing.JButton();
        btnChange = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Dashboard Admin");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Account ID:");

        btnSuspendAccount.setText("Suspend Account");
        btnSuspendAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuspendAccountActionPerformed(evt);
            }
        });

        btnVerifyCertification.setText("Verify Certification");
        btnVerifyCertification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerifyCertificationActionPerformed(evt);
            }
        });

        btnCallDatabase.setText("Call Database");
        btnCallDatabase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCallDatabaseActionPerformed(evt);
            }
        });

        outputArea.setColumns(20);
        outputArea.setRows(5);
        jScrollPane1.setViewportView(outputArea);

        tblUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Email", "Phone Number", "Role", "Status", "Verification"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblUser);

        btnActive.setText("Activied Account");
        btnActive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActiveActionPerformed(evt);
            }
        });

        btnChange.setText("Change Role");
        btnChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnSuspendAccount, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                .addComponent(btnCallDatabase, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                            .addComponent(btnChange, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVerifyCertification)
                            .addComponent(btnActive, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtAccountId, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 872, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(44, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtAccountId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54)
                        .addComponent(btnSuspendAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCallDatabase, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnChange, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnVerifyCertification, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnActive, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSuspendAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuspendAccountActionPerformed

        int selectedRow = tblUser.getSelectedRow();
        if (selectedRow != -1) {
            int userId = (int) tblUser.getValueAt(selectedRow, 0);
            suspendAccount(userId);
        } else {
            JOptionPane.showMessageDialog(this, "Pilih user terlebih dahulu!");
        }

    }//GEN-LAST:event_btnSuspendAccountActionPerformed

    private void btnVerifyCertificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerifyCertificationActionPerformed

        int selectedRow = tblUser.getSelectedRow();
        if (selectedRow != -1) {
            int userId = (int) tblUser.getValueAt(selectedRow, 0); 
            verifyCertification(userId);
        } else {
            JOptionPane.showMessageDialog(this, "Pilih tukang terlebih dahulu!");
        }
    }//GEN-LAST:event_btnVerifyCertificationActionPerformed

    private void btnCallDatabaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCallDatabaseActionPerformed
         try (Connection conn = koneksi.connect()) {
            String query = "SELECT COUNT(*) AS userCount FROM user";
            PreparedStatement stmt = conn.prepareStatement(query);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int userCount = rs.getInt("userCount");
                outputArea.setText("Total Users in Database: " + userCount);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching data from database.");
        }
    }//GEN-LAST:event_btnCallDatabaseActionPerformed

    private void btnActiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActiveActionPerformed
        String accountId = txtAccountId.getText();
        if (accountId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Masukkan Account ID yang akan diaktifkan!");
            return;
        }

        try (Connection conn = koneksi.connect()) {
            String query = "UPDATE user SET status = 'active' WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, accountId);

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Akun dengan ID " + accountId + " telah diaktifkan!");
                loadUserAndTukangData(); 
            } else {
                JOptionPane.showMessageDialog(this, "Akun dengan ID " + accountId + " tidak ditemukan.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error mengaktifkan akun!");
        }
    }//GEN-LAST:event_btnActiveActionPerformed

    private void btnChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeActionPerformed

        int selectedRow = tblUser.getSelectedRow();
        if (selectedRow != -1) {
            int userId = (int) tblUser.getValueAt(selectedRow, 0); 
            String currentRole = (String) tblUser.getValueAt(selectedRow, 4); 

            String newRole = JOptionPane.showInputDialog(this, "Masukkan Role Baru (user/tukang/admin):");
            if (newRole != null) {
                if (currentRole.equals("admin")) {
                    JOptionPane.showMessageDialog(this, "Role admin tidak dapat diubah!");
                } 
                else if (!newRole.equals(currentRole)) {
                    if (newRole.equals("user") || newRole.equals("tukang")) {
                        updateRole(userId, newRole);
                    } else {
                        JOptionPane.showMessageDialog(this, "Role tidak valid!");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Role sudah sesuai dengan yang dipilih!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Role tidak valid!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Pilih user terlebih dahulu!");
        }
    }//GEN-LAST:event_btnChangeActionPerformed

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
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AdminDashboard adminDashboard = new AdminDashboard();
                new AdminDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActive;
    private javax.swing.JButton btnCallDatabase;
    private javax.swing.JButton btnChange;
    private javax.swing.JButton btnSuspendAccount;
    private javax.swing.JButton btnVerifyCertification;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea outputArea;
    private javax.swing.JTable tblUser;
    private javax.swing.JTextField txtAccountId;
    // End of variables declaration//GEN-END:variables
}
