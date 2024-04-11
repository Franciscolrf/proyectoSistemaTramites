/**
 * Clase creada el 04 de Abril de 2024
 * 
 * 
 */
package bda.itson.Presentacion;

import dtos.LicenciaDTO;
import dtos.PersonaDTO;
import interfaces.IRegistrarLicenciaBO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import negocio.RegistrarLicencia;
import negocio.RegistrarPersona;
import tablas.Conversiones;
import interfaces.IregistrarPersona;

/**
 * Esta clase es la conexion entre el usuario y las funcionalidades para buscar usuarios
 * Aqui el usuario puede buscar a los clientes registrados en la base de datos.
 * 
 * @author abelc
 */
public class BuscarPersona extends javax.swing.JFrame {

    IRegistrarLicenciaBO licencia;
    IregistrarPersona personas;
    Conversiones tabla;
    LicenciaDTO licenciaDTO;
    private int operacion;
    PersonaDTO personaDTO;

    /**
     * Creates new form buscarPersonas
     * @param operacion
     */
    public BuscarPersona(int operacion) {
        this.tabla = new Conversiones();
        this.licencia = new RegistrarLicencia();
        this.licenciaDTO = new LicenciaDTO();
        this.personas = new RegistrarPersona();
        this.operacion = operacion;
        this.personaDTO = new PersonaDTO();
        initComponents();
        if (operacion == 1) {
            vigenciaCombobox.setVisible(true);
            jLabel3.setVisible(true);
            DefaultTableModel model = (DefaultTableModel) tablaPersonas.getModel();
            model.setRowCount(0);
            List<PersonaDTO> listaPersonas = licencia.obtenerPersonas();
            DefaultTableModel newModel = tabla.personasTableModel(listaPersonas);
            tablaPersonas.setModel(newModel);
            tablaPersonas.setDefaultEditor(Object.class, null);
        } else {
            vigenciaCombobox.setVisible(false);
            jLabel3.setVisible(false);
            DefaultTableModel model = (DefaultTableModel) tablaPersonas.getModel();
            model.setRowCount(0);
            List<PersonaDTO> listaPersonas = licencia.obtenerPersonas();
            DefaultTableModel newModel = tabla.personasModuloPlacasTableModel(listaPersonas);
            tablaPersonas.setModel(newModel);
            tablaPersonas.setDefaultEditor(Object.class, null);

        }
        if (operacion == 3) {
            seleccionarBtn.setText("Ver historial");
            DefaultTableModel model = (DefaultTableModel) tablaPersonas.getModel();
            model.setRowCount(0);
            List<PersonaDTO> listaPersonas = licencia.obtenerPersonas();
            DefaultTableModel newModel = tabla.personasTableModel(listaPersonas);
            tablaPersonas.setModel(newModel);
            tablaPersonas.setDefaultEditor(Object.class, null);

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

        jPanel1 = new javax.swing.JPanel();
        parametroTxtField = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        buscarBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPersonas = new javax.swing.JTable();
        regresarBtn = new javax.swing.JButton();
        seleccionarBtn = new javax.swing.JButton();
        vigenciaCombobox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(232, 232, 232));

        jPanel2.setBackground(new java.awt.Color(107, 27, 56));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/descarga (1).png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Seleccione una persona");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2))
        );

        buscarBtn.setBackground(new java.awt.Color(107, 27, 56));
        buscarBtn.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        buscarBtn.setForeground(new java.awt.Color(255, 255, 255));
        buscarBtn.setText("Buscar");
        buscarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarBtnActionPerformed(evt);
            }
        });

        tablaPersonas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombres", "Apellido Paterno", "Apellido Materno", "Telefono", "RFC", "Discapacidad", "Fecha de nacimiento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });
        tablaPersonas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tablaPersonas);

        regresarBtn.setBackground(new java.awt.Color(107, 27, 56));
        regresarBtn.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        regresarBtn.setForeground(new java.awt.Color(255, 255, 255));
        regresarBtn.setText("Regresar");
        regresarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarBtnActionPerformed(evt);
            }
        });

        seleccionarBtn.setBackground(new java.awt.Color(107, 27, 56));
        seleccionarBtn.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        seleccionarBtn.setForeground(new java.awt.Color(255, 255, 255));
        seleccionarBtn.setText("Seleccionar");
        seleccionarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarBtnActionPerformed(evt);
            }
        });

        vigenciaCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));

        jLabel3.setText("Vigencia:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(183, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(parametroTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buscarBtn)
                        .addGap(69, 69, 69))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(vigenciaCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(181, 181, 181))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(regresarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(seleccionarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(parametroTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarBtn))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(vigenciaCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(regresarBtn)
                    .addComponent(seleccionarBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    /**
     * Metodo para ejecutar la busqueda de personas, donde se traeran de la logica de negocios, la lista de usuarios.
     * 
     * Si no existen parametros, traera todos los clientes, si existen parametros, verificara que existan en la base de datos.
     * @param evt 
     */
    private void buscarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarBtnActionPerformed
        DefaultTableModel model = (DefaultTableModel) tablaPersonas.getModel();
        model.setRowCount(0);

        List<PersonaDTO> listaPersonas = licencia.buscarPersonas(parametroTxtField.getText());

        if (listaPersonas.isEmpty() || parametroTxtField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se encontraron resultados", "Búsqueda vacía", JOptionPane.INFORMATION_MESSAGE);
            listaPersonas = licencia.obtenerPersonas();
        }

        if (operacion == 1) {
            DefaultTableModel newModel = tabla.personasTableModel(listaPersonas);
            tablaPersonas.setModel(newModel);
        } else if (operacion == 2) {
            DefaultTableModel newModel = tabla.personasModuloPlacasTableModel(listaPersonas);
            tablaPersonas.setModel(newModel);
        } else if (operacion == 3) {
            DefaultTableModel newModel = tabla.personasTableModel(listaPersonas);
            tablaPersonas.setModel(newModel);
        }
    }//GEN-LAST:event_buscarBtnActionPerformed

    
    /**
     * Metodo para ejecutar la seleccion de un cliente.
     * Verifica si el cliente selecciono la opcion para tramitar licencia.
     *  Si ya tiene licencia vigente, el sistema manda un mensaje de advertencia.
     *  Si el usuario selecciona la opcion para tramitar placas, el sistema verifica primero si ya tiene licencia
     *  
     * @param evt 
     */
    private void seleccionarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionarBtnActionPerformed
        if (operacion == 1) {
            obtenerDatosFilaSeleccionada();
            if (licencia.verificarLicenciaActiva(licenciaDTO.getPersona()) == false) {
                System.out.println(licenciaDTO.getCosto());
                this.dispose();
                DlgConfirmaciones dlgConfLicencia = new DlgConfirmaciones(this, true, licenciaDTO, null, 1);
            } else {
                JOptionPane.showMessageDialog(null, "La persona ya tiene una licencia activa.", "Licencia activa encontrada", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        if (operacion == 2) {
            obtenerDatosFilaSeleccionada();
            if (licencia.verificarLicenciaActiva(personaDTO) == true) {
                Vehiculos vehiculosVentana = new Vehiculos(personaDTO);
                vehiculosVentana.setVisible(true);
                this.dispose();
            } else {
                int respuesta = JOptionPane.showOptionDialog(null, "¿Quiere tramitar una licencia?", "La persona seleccionada no cuenta con licencia activa", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Sí", "No"}, "Sí");
                if (respuesta == JOptionPane.YES_OPTION) {
                    licenciaDTO.setPersona(personaDTO);
                    int resp = JOptionPane.showOptionDialog(
                            null,
                            "Seleccione la vigencia para la licencia:",
                            "Duración de la licencia",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            new String[]{"1 año", "2 años", "3 años"},
                            "1 año");
                    int duracion = 0;
                    if (resp == 0) {

                        duracion = 1;

                    } else if (resp == 1) {

                        duracion = 2;

                    } else if (resp == 2) {

                        duracion = 3;

                    }
                    if (duracion != 0) {
                        licenciaDTO.setVigencia(duracion);
                        licencia.asignarValoresLicencia(licenciaDTO);
                        this.dispose();
                        DlgConfirmaciones dlgConfLicencia = new DlgConfirmaciones(this, true, licenciaDTO, null, 1);
                    }

                }
            }
        }
        if (operacion == 3) {
            obtenerDatosFilaSeleccionada();
            Historial historial = new Historial(personaDTO);
            historial.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_seleccionarBtnActionPerformed

    /**
     * Metodo para regresar al menu principal
     * @param evt 
     */
    private void regresarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarBtnActionPerformed
        if (operacion == 1 || operacion == 2) {
            this.dispose();
            DlgEleccionTramite eleccionTramite = new DlgEleccionTramite(this, true);

        }
        if (operacion == 3) {
            MenuPrincipal menu = new MenuPrincipal();
            menu.setVisible(true);
            this.dispose();
        }

    }//GEN-LAST:event_regresarBtnActionPerformed
   
    /**
     * Metodo para obtener los datos de la persona seleccionada
     */
    private void obtenerDatosFilaSeleccionada() {
        if (operacion == 1) {
            int filaSeleccionada = tablaPersonas.getSelectedRow();

            if (filaSeleccionada != -1) {
                String rfc = tablaPersonas.getValueAt(filaSeleccionada, 4).toString(); // Obtener RFC de la fila seleccionada

                PersonaDTO personaDTO = personas.buscarRFC(rfc);

                if (personaDTO != null) {
                    licenciaDTO.setPersona(personaDTO);
                    System.out.println(licenciaDTO.getPersona().getId());
                    try {
                        licenciaDTO.setVigencia(Integer.parseInt((String) vigenciaCombobox.getSelectedItem()));
                    } catch (NumberFormatException e) {
                        System.err.println("El valor seleccionado no es un número válido.");
                    }
                    licencia.asignarValoresLicencia(licenciaDTO);

                }
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, seleccione una persona.");
            }
        }
        if (operacion == 2) {
            int filaSeleccionada = tablaPersonas.getSelectedRow();

            if (filaSeleccionada != -1) {
                String rfc = tablaPersonas.getValueAt(filaSeleccionada, 4).toString();

                personaDTO = personas.buscarRFC(rfc);
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, seleccione una persona.");
            }
        }
        if (operacion == 3) {
            int filaSeleccionada = tablaPersonas.getSelectedRow();

            if (filaSeleccionada != -1) {
                String rfc = tablaPersonas.getValueAt(filaSeleccionada, 4).toString();

                personaDTO = personas.buscarRFC(rfc);
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, seleccione una persona.");
            }
        }
    }

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
            java.util.logging.Logger.getLogger(BuscarPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new BuscarPersona(1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscarBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField parametroTxtField;
    private javax.swing.JButton regresarBtn;
    private javax.swing.JButton seleccionarBtn;
    private javax.swing.JTable tablaPersonas;
    private javax.swing.JComboBox<String> vigenciaCombobox;
    // End of variables declaration//GEN-END:variables
}
