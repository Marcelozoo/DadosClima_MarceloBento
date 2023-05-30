package view;

import javax.swing.JLabel;


public class UltimaAtualizacaoDoTempoView extends javax.swing.JInternalFrame {

    
    public UltimaAtualizacaoDoTempoView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelData = new javax.swing.JLabel();
        jLabelTemperatura = new javax.swing.JLabel();
        jLabelUmidade = new javax.swing.JLabel();
        jLabelPressao = new javax.swing.JLabel();

        setTitle("Ultima atualização do tempo");
        setVisible(true);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Data");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Temperatura");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Umidade");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Pressão");

        jLabelData.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabelTemperatura.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabelUmidade.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabelPressao.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPressao)
                    .addComponent(jLabelUmidade)
                    .addComponent(jLabelTemperatura)
                    .addComponent(jLabelData))
                .addContainerGap(187, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabelData))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabelTemperatura))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabelUmidade))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabelPressao))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelData;
    private javax.swing.JLabel jLabelPressao;
    private javax.swing.JLabel jLabelTemperatura;
    private javax.swing.JLabel jLabelUmidade;
    // End of variables declaration//GEN-END:variables

    public JLabel getLabelData(){
        return jLabelData;
    }
    
    public JLabel getLabelTemperatura(){
        return jLabelTemperatura;
    }
    public JLabel getLabelPressao(){
        return jLabelPressao;
    }
    public JLabel getLabelUmidade(){
        return jLabelUmidade;
    }
}

