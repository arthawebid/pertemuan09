package pertemuan09;

import static pertemuan09.koneksi.buatkoneks;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;

/**
 *
 * @author INSTIKI
 * tgl: 2024-05-16
 */
public class jForm1 extends javax.swing.JFrame {
    DefaultTableModel TM = new DefaultTableModel();
    //loadIMG img = new loadIMG();

    /**
     * Creates new form jForm1
     */
    public jForm1() throws SQLException {
        initComponents();
        ImageIcon imageIcon = new ImageIcon("img/photo.png");
        this.setIconImage(imageIcon.getImage());
        jTable1.setModel(TM);
        TM.addColumn("IDTeman");
        TM.addColumn("Nama");
        TM.addColumn("Alamat");
        TM.addColumn("Telp");
        TM.addColumn("JenisKelamin");
        
//        Object[] dta = new Object[3];
//        dta[0] = "Wayan Aruni";
//        dta[1] = "Jl. Saja susah";
//        dta[2] = "08877666";
//        TM.addRow(dta);
//                
//        dta[0] = "Made Aruni";
//        dta[1] = "Jl. Saja susah";
//        dta[2] = "08877666";
//        TM.addRow(dta);
//        
//        dta[0] = "Nyoman Aruni";
//        dta[1] = "Jl. Saja susah";
//        dta[2] = "08877666";
//        TM.addRow(dta);
        String[] jkx = {"Pilih Jenis Kelamin","Laki-Laki","Perempuan"};
        jk.setSelectedIndex(2);
        jk.removeAllItems();
        jk.addItem(jkx[0]);
        jk.addItem(jkx[1]);
        jk.addItem(jkx[2]);
        jk.setSelectedIndex(0);
        
        kosongkanform();
        list_all();
        tombol(false);
        cTambah.setEnabled(true);
        cClose.setEnabled(true);
        loadphoto("");
        

    }
    private void loadphoto(String idx){
        String urlGambar = "img/photo"+idx+ ".png";
        if(idx.equals("")){
            urlGambar = "img/photo.png";
        }
        
        //BufferedImage loadImg = loadIMG.loadImage(urlGambar);
        //if(loadImg == null){
        //    loadImg = loadIMG.loadImage(urlGambarNull);
        //}
        ImageIcon imageIcon = new ImageIcon(urlGambar);
        phteman.setIcon(imageIcon);
    }
    private void list_all() throws SQLException{
        Connection cnn = buatkoneks();
        
        TM.getDataVector().removeAllElements();
        TM.fireTableDataChanged();
        
        if(!cnn.isClosed()){
        
            PreparedStatement ps = cnn.prepareStatement("SELECT * FROM teman;");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Object[] dta = new Object[5];
                dta[0] = rs.getInt("idteman");
                dta[1] = rs.getString("nama");
                dta[2] = rs.getString("alamat");
                dta[3] = rs.getString("telp");
                dta[4] = rs.getString("jk");
                
                TM.addRow(dta);
            }
            cnn.close();
        }
    }
    private void Storedata() throws SQLException{
        Connection cnn = buatkoneks();
        String NM = txNAMA.getText();
        String AL = txALAMAT.getText();
        String TL = txTELP.getText();
        if(!cnn.isClosed()){
            PreparedStatement ps = cnn.prepareStatement("INSERT INTO teman(nama,alamat,telp) VALUES(?,?,?);");
            ps.setString(1, NM);
            ps.setString(2, AL);
            ps.setString(3, TL);
            ps.executeUpdate();
        }
    }
    private void updatedata(int idx) throws SQLException{
        Connection cnn = buatkoneks();
        String NM = txNAMA.getText();
        String AL = txALAMAT.getText();
        String TL = txTELP.getText();
        String JK = String.valueOf(jk.getSelectedItem());
        if(!cnn.isClosed()){
            PreparedStatement ps = cnn.prepareStatement("UPDATE teman SET nama=?, alamat=?, telp=?, jk=? WHERE idteman=?;");
            ps.setString(1, NM);
            ps.setString(2, AL);
            ps.setString(3, TL);
            ps.setString(4, JK);
            ps.setInt(5, idx);
            ps.executeUpdate();
        }
    }
    private void destroydata(int idx) throws SQLException{
        Connection cnn = buatkoneks();
        if(!cnn.isClosed()){
            PreparedStatement ps = cnn.prepareStatement("DELETE FROM teman WHERE idteman=?;");
            ps.setInt(1, idx);
            ps.executeUpdate();
        }
    }
    private void kosongkanform(){
        txIDTEMAN.setText("");
        txNAMA.setText("");
        txALAMAT.setText("");
        txTELP.setText("");
    }
    private void tombol(boolean stt){
        cTambah.setEnabled(stt);
        cUpdate.setEnabled(stt);
        cDelete.setEnabled(stt);
        cClose.setEnabled(stt);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txNAMA = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txALAMAT = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txTELP = new javax.swing.JTextField();
        txIDTEMAN = new javax.swing.JTextField();
        cTambah = new javax.swing.JButton();
        cUpdate = new javax.swing.JButton();
        cDelete = new javax.swing.JButton();
        cClose = new javax.swing.JButton();
        phteman = new javax.swing.JLabel();
        jk = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikasi Daftar Teman");
        setAlwaysOnTop(true);
        setMaximumSize(null);
        setMinimumSize(new java.awt.Dimension(450, 450));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 51));
        jLabel1.setText("Daftar Teman");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama", "Alamat", "Telp"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Nama");

        txNAMA.setText("jTextField1");

        jLabel3.setText("Alamat");

        txALAMAT.setText("jTextField2");

        jLabel4.setText("Telpon");

        txTELP.setText("jTextField3");

        txIDTEMAN.setText("jTextField1");

        cTambah.setText("Tambah");
        cTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cTambahActionPerformed(evt);
            }
        });

        cUpdate.setText("Ubah Data");
        cUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cUpdateActionPerformed(evt);
            }
        });

        cDelete.setText("Hapus Data");
        cDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cDeleteActionPerformed(evt);
            }
        });

        cClose.setText("Tutup");
        cClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cCloseActionPerformed(evt);
            }
        });

        phteman.setBackground(new java.awt.Color(0, 0, 0));
        phteman.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        phteman.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText("Jenis Kelamin");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cClose))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(phteman, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txIDTEMAN, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(44, 44, 44))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txALAMAT, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jk, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txTELP, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txNAMA, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))))))
            .addGroup(layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(jLabel1)
                .addGap(10, 10, 10))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cClose, cDelete, cTambah, cUpdate});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phteman, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txNAMA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txALAMAT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txTELP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txIDTEMAN, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cClose, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        tombol(true);
        txIDTEMAN.setText( jTable1.getValueAt( jTable1.getSelectedRow(),0).toString() );
        txNAMA.setText( jTable1.getValueAt( jTable1.getSelectedRow(),1).toString() );
        txALAMAT.setText( jTable1.getValueAt( jTable1.getSelectedRow(),2).toString() );
        txTELP.setText( jTable1.getValueAt( jTable1.getSelectedRow(),3).toString() );
        String jkx = jTable1.getValueAt( jTable1.getSelectedRow(),4).toString();
        jk.setSelectedIndex(1);
        if(jkx.equals("Perempuan"))
            jk.setSelectedIndex(2);
        loadphoto(txIDTEMAN.getText());
    }//GEN-LAST:event_jTable1MouseClicked

    private void cCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cCloseActionPerformed
        if(cClose.getText().equals("Tutup")){
            int jawab = JOptionPane.showOptionDialog(this, 
                    "Ingin Keluar?", 
                    "Keluar", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.QUESTION_MESSAGE, null, null, null);
            if(jawab == JOptionPane.YES_OPTION){
                System.exit(0);
            }
        }else{
            try {
                list_all();
                tombol(false);
                cTambah.setText("Tambah");
                cTambah.setEnabled(true);
                cClose.setText("Tutup");
                cClose.setEnabled(true);
            } catch (SQLException ex) {
                Logger.getLogger(jForm1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_cCloseActionPerformed

    private void cUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cUpdateActionPerformed
        try {
            updatedata(Integer.parseInt(txIDTEMAN.getText()));
            list_all();
            cTambah.setText("Tambah");
            cClose.setText("Tutup");
            tombol(false);
        } catch (SQLException ex) {
            Logger.getLogger(jForm1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cUpdateActionPerformed

    private void cTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cTambahActionPerformed
        if(cTambah.getText().equals("Tambah")){
            kosongkanform();
            tombol(false);
            cTambah.setText("Simpan");
            cTambah.setEnabled(true);
            cClose.setText("Batal");
            cClose.setEnabled(true);
            txIDTEMAN.setEditable(false);
        }else{
            try {
                Storedata();
                list_all();
            } catch (SQLException ex) {
                Logger.getLogger(jForm1.class.getName()).log(Level.SEVERE, null, ex);
            }
            cTambah.setText("Tambah");
            cClose.setText("Tutup");
            tombol(false);
            txIDTEMAN.setEditable(false);
        }
    }//GEN-LAST:event_cTambahActionPerformed

    private void cDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cDeleteActionPerformed
        if(cDelete.getText().equals("Hapus Data")){
            int jawab = JOptionPane.showOptionDialog(this, 
                    "Hapus Data Record ke "+txIDTEMAN.getText()+", atas Nama "+txNAMA.getText(), 
                    "Hapus Data", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.QUESTION_MESSAGE, null, null, null);
            if(jawab == JOptionPane.YES_OPTION){
                try {
                    destroydata(Integer.parseInt( txIDTEMAN.getText() ) );
                    list_all();
                    kosongkanform();
                    tombol(false);
                    cClose.setEnabled(true);
                } catch (SQLException ex) {
                    Logger.getLogger(jForm1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_cDeleteActionPerformed

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
            java.util.logging.Logger.getLogger(jForm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jForm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jForm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jForm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new jForm1().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(jForm1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cClose;
    private javax.swing.JButton cDelete;
    private javax.swing.JButton cTambah;
    private javax.swing.JButton cUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> jk;
    private javax.swing.JLabel phteman;
    private javax.swing.JTextField txALAMAT;
    private javax.swing.JTextField txIDTEMAN;
    private javax.swing.JTextField txNAMA;
    private javax.swing.JTextField txTELP;
    // End of variables declaration//GEN-END:variables
}
