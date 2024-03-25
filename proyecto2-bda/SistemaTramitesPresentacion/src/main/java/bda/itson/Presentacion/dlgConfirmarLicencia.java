/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package bda.itson.Presentacion;

import dtos.LicenciaDTO;
import interfaces.IRegistrarLicenciaBO;
import java.text.SimpleDateFormat;
import negocio.RegistrarLicencia;

/**
 *
 * @author abelc
 */
public class dlgConfirmarLicencia extends javax.swing.JDialog {
LicenciaDTO licenciaDatos;
IRegistrarLicenciaBO licencia;
    /**
     * Creates new form dlgConfirmarLicencia
     */
    public dlgConfirmarLicencia(java.awt.Frame parent, boolean modal,LicenciaDTO licenciaDatos) {
        super(parent, modal);
         this.licencia=new RegistrarLicencia();
         this.licenciaDatos = licenciaDatos; 
         System.out.println(licenciaDatos.getPersona().getId());
        initComponents();
         SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        personaTxt.setText(licenciaDatos.getPersona().getNombres()+" "+
                licenciaDatos.getPersona().getApellidoPaterno()+" "+licenciaDatos.getPersona().getApellidoMaterno());
        rfcTxt.setText(licenciaDatos.getPersona().getRFC());
        vigenciaTxt.setText(Integer.toString(licenciaDatos.getVigencia()));
        fechaExTxt.setText(dateFormat.format(licenciaDatos.getFechaExpedicion().getTime()));
        fechaVenTxt.setText(dateFormat.format(licenciaDatos.getFechaVencimiento().getTime()));
      costoTxt.setText(Double.toString(licenciaDatos.getCosto()));
        setVisible(true);
     
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        nombreTxt = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        personaTxt = new javax.swing.JLabel();
        Txt1 = new javax.swing.JLabel();
        rfcTxt = new javax.swing.JLabel();
        Txt2 = new javax.swing.JLabel();
        Txt3 = new javax.swing.JLabel();
        fechaVenTxt = new javax.swing.JLabel();
        Txt5 = new javax.swing.JLabel();
        vigenciaTxt = new javax.swing.JLabel();
        fechaExTxt = new javax.swing.JLabel();
        Txt6 = new javax.swing.JLabel();
        costoTxt = new javax.swing.JLabel();
        regresarBtn = new javax.swing.JButton();
        confirmarBtn = new javax.swing.JButton();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(232, 232, 232));

        nombreTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nombreTxt.setForeground(new java.awt.Color(0, 0, 0));
        nombreTxt.setText("Nombre:");

        jPanel2.setBackground(new java.awt.Color(107, 27, 56));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/descarga (1).png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Sistema de control de trámites");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addComponent(jLabel2)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2))
        );

        personaTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        Txt1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Txt1.setForeground(new java.awt.Color(0, 0, 0));
        Txt1.setText("RFC:");

        rfcTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rfcTxt.setForeground(new java.awt.Color(0, 0, 0));

        Txt2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Txt2.setForeground(new java.awt.Color(0, 0, 0));
        Txt2.setText("Vigencia:");

        Txt3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Txt3.setForeground(new java.awt.Color(0, 0, 0));
        Txt3.setText("Fecha de expedicion:");

        fechaVenTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fechaVenTxt.setForeground(new java.awt.Color(0, 0, 0));

        Txt5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Txt5.setForeground(new java.awt.Color(0, 0, 0));
        Txt5.setText("Costo:");

        vigenciaTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        vigenciaTxt.setForeground(new java.awt.Color(0, 0, 0));

        fechaExTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fechaExTxt.setForeground(new java.awt.Color(0, 0, 0));

        Txt6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Txt6.setForeground(new java.awt.Color(0, 0, 0));
        Txt6.setText("Fecha de vencimiento:");

        costoTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        costoTxt.setForeground(new java.awt.Color(0, 0, 0));

        regresarBtn.setBackground(new java.awt.Color(107, 27, 56));
        regresarBtn.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        regresarBtn.setForeground(new java.awt.Color(255, 255, 255));
        regresarBtn.setText("Regresar");
        regresarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarBtnActionPerformed(evt);
            }
        });

        confirmarBtn.setBackground(new java.awt.Color(107, 27, 56));
        confirmarBtn.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        confirmarBtn.setForeground(new java.awt.Color(255, 255, 255));
        confirmarBtn.setText("Confirmar licencia");
        confirmarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Txt2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(vigenciaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(nombreTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(personaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rfcTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Txt3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fechaExTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Txt5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(costoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Txt6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fechaVenTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(regresarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(confirmarBtn)
                        .addGap(31, 31, 31))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(personaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rfcTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(vigenciaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Txt2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fechaExTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Txt3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fechaVenTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Txt6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Txt5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(costoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmarBtn)
                    .addComponent(regresarBtn))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void regresarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarBtnActionPerformed
        dispose();
    }//GEN-LAST:event_regresarBtnActionPerformed

    private void confirmarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarBtnActionPerformed

        licencia.registrarLicencia(licenciaDatos);
        dispose();
    }//GEN-LAST:event_confirmarBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Txt1;
    private javax.swing.JLabel Txt2;
    private javax.swing.JLabel Txt3;
    private javax.swing.JLabel Txt5;
    private javax.swing.JLabel Txt6;
    private javax.swing.JButton confirmarBtn;
    private javax.swing.JLabel costoTxt;
    private javax.swing.JLabel fechaExTxt;
    private javax.swing.JLabel fechaVenTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel nombreTxt;
    private javax.swing.JLabel personaTxt;
    private javax.swing.JButton regresarBtn;
    private javax.swing.JLabel rfcTxt;
    private javax.swing.JLabel vigenciaTxt;
    // End of variables declaration//GEN-END:variables
}
