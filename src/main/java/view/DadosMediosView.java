package view;

import javax.swing.JLabel;

public class DadosMediosView extends javax.swing.JInternalFrame {

    
    public DadosMediosView() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelTemp = new javax.swing.JLabel();
        jLabelUmidade = new javax.swing.JLabel();
        jLabelPressao = new javax.swing.JLabel();
        jLabelNumeroRegistros = new javax.swing.JLabel();

        setResizable(true);
        setTitle("Dados médios");
        setVisible(true);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Temperatura");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Umidade");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Pressão");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Nº de registros");

        jLabelTemp.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabelUmidade.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabelPressao.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabelNumeroRegistros.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(118, 118, 118)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNumeroRegistros)
                    .addComponent(jLabelPressao)
                    .addComponent(jLabelUmidade)
                    .addComponent(jLabelTemp))
                .addContainerGap(129, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabelTemp))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabelUmidade))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabelPressao))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabelNumeroRegistros))
                .addContainerGap(91, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelNumeroRegistros;
    private javax.swing.JLabel jLabelPressao;
    private javax.swing.JLabel jLabelTemp;
    private javax.swing.JLabel jLabelUmidade;
    // End of variables declaration//GEN-END:variables
    
    public JLabel getLabelTemp(){
        return jLabelTemp;
    }
    public JLabel getLabelUmidade(){
        return jLabelUmidade;
    }
    public JLabel getLabelPressao(){
        return jLabelPressao;
    }
    public JLabel getLabelNumeroRegistros(){
        return jLabelNumeroRegistros;
    }



}
