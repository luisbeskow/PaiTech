/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pai.tech;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author BESKOW
 */
public class tela_principal extends javax.swing.JFrame {

    /**
     * Creates new form tela_principal
     */
    public tela_principal() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.show();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktop_principal = new javax.swing.JDesktopPane();
        menu_principal = new javax.swing.JMenuBar();
        menu_cadastro = new javax.swing.JMenu();
        cadastro_cliente = new javax.swing.JMenuItem();
        cadastro_fornecedor = new javax.swing.JMenuItem();
        cadastro_funcionario = new javax.swing.JMenuItem();
        cadastro_servico = new javax.swing.JMenuItem();
        cadastro_sair = new javax.swing.JMenuItem();
        menu_servico = new javax.swing.JMenu();
        servico_ordem = new javax.swing.JMenuItem();
        menu_financeiro = new javax.swing.JMenu();
        financeiro_receber = new javax.swing.JMenuItem();
        financeiro_pagar = new javax.swing.JMenuItem();
        menu_relatorio = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pai Tech");
        setResizable(false);

        javax.swing.GroupLayout desktop_principalLayout = new javax.swing.GroupLayout(desktop_principal);
        desktop_principal.setLayout(desktop_principalLayout);
        desktop_principalLayout.setHorizontalGroup(
            desktop_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        desktop_principalLayout.setVerticalGroup(
            desktop_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        menu_cadastro.setText("Cadastros");

        cadastro_cliente.setText("Cliente");
        cadastro_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastro_clienteActionPerformed(evt);
            }
        });
        menu_cadastro.add(cadastro_cliente);

        cadastro_fornecedor.setText("Fornecedor");
        cadastro_fornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastro_fornecedorActionPerformed(evt);
            }
        });
        menu_cadastro.add(cadastro_fornecedor);

        cadastro_funcionario.setText("Funcionarios");
        cadastro_funcionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastro_funcionarioActionPerformed(evt);
            }
        });
        menu_cadastro.add(cadastro_funcionario);

        cadastro_servico.setText("Servico");
        cadastro_servico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastro_servicoActionPerformed(evt);
            }
        });
        menu_cadastro.add(cadastro_servico);

        cadastro_sair.setText("Sair");
        cadastro_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastro_sairActionPerformed(evt);
            }
        });
        menu_cadastro.add(cadastro_sair);

        menu_principal.add(menu_cadastro);

        menu_servico.setText("Servicos");
        menu_servico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_servicoActionPerformed(evt);
            }
        });

        servico_ordem.setText("Ordem de Servico");
        servico_ordem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                servico_ordemActionPerformed(evt);
            }
        });
        menu_servico.add(servico_ordem);

        menu_principal.add(menu_servico);

        menu_financeiro.setText("Financeiro");

        financeiro_receber.setText("Contas a receber");
        financeiro_receber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                financeiro_receberActionPerformed(evt);
            }
        });
        menu_financeiro.add(financeiro_receber);

        financeiro_pagar.setText("Contas a pagar");
        financeiro_pagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                financeiro_pagarActionPerformed(evt);
            }
        });
        menu_financeiro.add(financeiro_pagar);

        menu_principal.add(menu_financeiro);

        menu_relatorio.setText("Relatorios");
        menu_principal.add(menu_relatorio);

        setJMenuBar(menu_principal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop_principal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop_principal)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cadastro_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastro_sairActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cadastro_sairActionPerformed

    private void cadastro_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastro_clienteActionPerformed
        // TODO add your handling code here:
        cadastro_cliente form = null;
        try {
            form = new cadastro_cliente();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(tela_principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        form.setVisible(true);
        desktop_principal.add(form);
    }//GEN-LAST:event_cadastro_clienteActionPerformed

    private void cadastro_funcionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastro_funcionarioActionPerformed
        // TODO add your handling code here:
        
        cadastro_funcionario form = null;
        try {
            form = new cadastro_funcionario();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(tela_principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        form.setVisible(true);
        desktop_principal.add(form);
    }//GEN-LAST:event_cadastro_funcionarioActionPerformed

    private void cadastro_fornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastro_fornecedorActionPerformed
        // TODO add your handling code here:
        
        cadastro_fornecedor form = null;
        try {
            form = new cadastro_fornecedor();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(tela_principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        form.setVisible(true);
        desktop_principal.add(form);
    }//GEN-LAST:event_cadastro_fornecedorActionPerformed

    private void cadastro_servicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastro_servicoActionPerformed
        // TODO add your handling code here:
        
        cadastro_servico form = null;
        try {
            form = new cadastro_servico();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(tela_principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        form.setVisible(true);
        desktop_principal.add(form);
        
    }//GEN-LAST:event_cadastro_servicoActionPerformed

    private void menu_servicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_servicoActionPerformed
    // TODO add your handling code here:
              
    }//GEN-LAST:event_menu_servicoActionPerformed

    private void servico_ordemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_servico_ordemActionPerformed
        // TODO add your handling code here:
        servico_ordem form = null;
        try {
            form = new servico_ordem();
        } 
        catch (ClassNotFoundException ex) 
        {
            Logger.getLogger(tela_principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        form.setVisible(true);
        desktop_principal.add(form);

    }//GEN-LAST:event_servico_ordemActionPerformed

    private void financeiro_receberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_financeiro_receberActionPerformed
        // TODO add your handling code here:
        
        financeiro_receber form = null;
        try {
            form = new financeiro_receber();
        } 
        catch (ClassNotFoundException ex) 
        {
            Logger.getLogger(tela_principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        form.setVisible(true);
        desktop_principal.add(form);
    }//GEN-LAST:event_financeiro_receberActionPerformed

    private void financeiro_pagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_financeiro_pagarActionPerformed
        // TODO add your handling code here:
        financeiro_pagar form = null;
        try {
            form = new financeiro_pagar();
        } 
        catch (ClassNotFoundException ex) 
        {
            Logger.getLogger(tela_principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        form.setVisible(true);
        desktop_principal.add(form);
        
    }//GEN-LAST:event_financeiro_pagarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        System.exit(0);

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tela_principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem cadastro_cliente;
    private javax.swing.JMenuItem cadastro_fornecedor;
    private javax.swing.JMenuItem cadastro_funcionario;
    private javax.swing.JMenuItem cadastro_sair;
    private javax.swing.JMenuItem cadastro_servico;
    private javax.swing.JDesktopPane desktop_principal;
    private javax.swing.JMenuItem financeiro_pagar;
    private javax.swing.JMenuItem financeiro_receber;
    private javax.swing.JMenu menu_cadastro;
    private javax.swing.JMenu menu_financeiro;
    private javax.swing.JMenuBar menu_principal;
    private javax.swing.JMenu menu_relatorio;
    private javax.swing.JMenu menu_servico;
    private javax.swing.JMenuItem servico_ordem;
    // End of variables declaration//GEN-END:variables
}
