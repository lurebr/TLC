/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MenuExterno.java
 *
 * Created on 24/11/2012, 14:16:15
 */
package Timeline.Core.Menu;

/**
 *
 * @author Lennon
 */
public class MenuExterno extends javax.swing.JFrame {

    /** Creates new form MenuExterno */
    public MenuExterno() {
        initComponents();
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMenu = new javax.swing.JPanel();
        cPrincipal = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnIniciarJogo = new javax.swing.JRadioButton();
        btnOpcoes = new javax.swing.JRadioButton();
        btnCreditos = new javax.swing.JRadioButton();
        btnSair = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        cOpcoes = new javax.swing.JPanel();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        pnlMenu.setLayout(new java.awt.CardLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnIniciarJogo.setBorder(null);
        btnIniciarJogo.setContentAreaFilled(false);
        btnIniciarJogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Timeline/Core/Menu/BotaoIniciar1.png"))); // NOI18N
        btnIniciarJogo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Timeline/Core/Menu/BotaoIniciar1Mouse.png"))); // NOI18N
        btnIniciarJogo.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Timeline/Core/Menu/BotaoIniciar1.png"))); // NOI18N
        btnIniciarJogo.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Timeline/Core/Menu/BotaoIniciar1Mouse.png"))); // NOI18N
        btnIniciarJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarJogoActionPerformed(evt);
            }
        });
        jPanel1.add(btnIniciarJogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 270, -1));

        btnOpcoes.setBorder(null);
        btnOpcoes.setContentAreaFilled(false);
        btnOpcoes.setDebugGraphicsOptions(javax.swing.DebugGraphics.BUFFERED_OPTION);
        btnOpcoes.setDoubleBuffered(true);
        btnOpcoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Timeline/Core/Menu/BotaoOpcoes.png"))); // NOI18N
        btnOpcoes.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Timeline/Core/Menu/BotaoOpcoesMouse.png"))); // NOI18N
        btnOpcoes.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Timeline/Core/Menu/BotaoOpcoesMouse.png"))); // NOI18N
        btnOpcoes.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Timeline/Core/Menu/BotaoOpcoes.png"))); // NOI18N
        btnOpcoes.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Timeline/Core/Menu/BotaoOpcoes.png"))); // NOI18N
        btnOpcoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpcoesActionPerformed(evt);
            }
        });
        jPanel1.add(btnOpcoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 270, -1));

        btnCreditos.setContentAreaFilled(false);
        btnCreditos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Timeline/Core/Menu/BotaoCreditos.png"))); // NOI18N
        btnCreditos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Timeline/Core/Menu/BotaoCreditosMouse.png"))); // NOI18N
        btnCreditos.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Timeline/Core/Menu/BotaoCreditos.png"))); // NOI18N
        btnCreditos.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Timeline/Core/Menu/BotaoCreditosMouse.png"))); // NOI18N
        jPanel1.add(btnCreditos, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, -1, -1));

        btnSair.setContentAreaFilled(false);
        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Timeline/Core/Menu/BotaoSair.png"))); // NOI18N
        btnSair.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Timeline/Core/Menu/BotaoSairMouse.png"))); // NOI18N
        btnSair.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Timeline/Core/Menu/BotaoSair.png"))); // NOI18N
        btnSair.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Timeline/Core/Menu/BotaoSairMouse.png"))); // NOI18N
        jPanel1.add(btnSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 430, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Timeline/Core/Menu/Menugif2.gif"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout cPrincipalLayout = new javax.swing.GroupLayout(cPrincipal);
        cPrincipal.setLayout(cPrincipalLayout);
        cPrincipalLayout.setHorizontalGroup(
            cPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        cPrincipalLayout.setVerticalGroup(
            cPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlMenu.add(cPrincipal, "cPrincipal");

        btnVoltar.setText("Voltar");

        javax.swing.GroupLayout cOpcoesLayout = new javax.swing.GroupLayout(cOpcoes);
        cOpcoes.setLayout(cOpcoesLayout);
        cOpcoesLayout.setHorizontalGroup(
            cOpcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cOpcoesLayout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(336, Short.MAX_VALUE))
        );
        cOpcoesLayout.setVerticalGroup(
            cOpcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cOpcoesLayout.createSequentialGroup()
                .addContainerGap(367, Short.MAX_VALUE)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );

        pnlMenu.add(cOpcoes, "cOpcoes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOpcoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpcoesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOpcoesActionPerformed

    private void btnIniciarJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarJogoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnIniciarJogoActionPerformed

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
            java.util.logging.Logger.getLogger(MenuExterno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuExterno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuExterno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuExterno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MenuExterno().setVisible(true);
               
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JRadioButton btnCreditos;
    public javax.swing.JRadioButton btnIniciarJogo;
    public javax.swing.JRadioButton btnOpcoes;
    public javax.swing.JRadioButton btnSair;
    public javax.swing.JButton btnVoltar;
    public javax.swing.JPanel cOpcoes;
    public javax.swing.JPanel cPrincipal;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel pnlMenu;
    // End of variables declaration//GEN-END:variables
}
