package view;

import javax.swing.Box;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JMenu;

public class DadosClimaView extends javax.swing.JFrame {

    
    public DadosClimaView() {
        initComponents();
        this.setVisible(true);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jLabelQuantidadeRegistros = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DadosClima");

        jDesktopPane1.setForeground(new java.awt.Color(0, 0, 102));
        jDesktopPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jDesktopPane1.setDesktopManager(null);
        jDesktopPane1.setDoubleBuffered(true);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 629, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Número de Registros:");

        jLabelQuantidadeRegistros.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelQuantidadeRegistros.setText("0");

        jMenu1.setText("Configurar");
        jMenu1.setFocusable(false);
        jMenu1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuBar2.add(Box.createHorizontalGlue());
        jMenuBar2.add(jMenu1);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(1009, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabelQuantidadeRegistros)
                .addGap(65, 65, 65))
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jDesktopPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabelQuantidadeRegistros))
                .addGap(11, 11, 11))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JDesktopPane jDesktopPane1;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabelQuantidadeRegistros;
    public javax.swing.JMenu jMenu1;
    public javax.swing.JMenuBar jMenuBar2;
    public javax.swing.JMenuItem jMenuItem1;
    // End of variables declaration//GEN-END:variables
    
    public JDesktopPane getDesktopPanel(){
        return jDesktopPane1;
    }
    
    public JMenu getItemMenuConfigura(){
        return jMenu1;
    }
    
    public JLabel getLabelQuantideRegistro(){
        return jLabelQuantidadeRegistros;
    }
 
}

