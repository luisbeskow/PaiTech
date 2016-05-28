/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pai.tech;
import conectabd.conectabanco;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author BESKOW-NOTE
 */
public class cadastro_servico extends javax.swing.JInternalFrame 
{
    Connection conecta;
    PreparedStatement pst;
    ResultSet res;     
            
            
    public cadastro_servico() throws ClassNotFoundException {
        initComponents();
        conecta = conectabanco.conectabanco();
        lista_servico();
        this.dispose();
    }

    
    
    public void lista_servico()
    {
        String sql = "Select * from servico";
        
        try
        {
            pst = conecta.prepareStatement(sql);
            res = pst.executeQuery();
            cadastro_servico_tabelaconsulta2.setModel(DbUtils.resultSetToTableModel(res));            
        }
        
        catch(SQLException error)
        {
          JOptionPane.showMessageDialog(null,error);      
        } 
    }
    
    
    
    public void novo_servico()
    {
        cadastro_servico_campocodigo.setText("") ;
        cadastro_servico_camposervico.setText("") ;
        cadastro_servico_campodescricao.setText("") ;
        cadastro_servico_campovalor.setText("");
        cadastro_servico_campocomissao.setText("");    
    }        
 
    
    
public void  cadastro_servico()       
{
    
    String sql = "Insert into servico(servico,descricao,valor,comissao) values (?,?,?,?)";  
    
    try
    {
        pst = conecta.prepareStatement(sql);
        
        pst.setString(1,cadastro_servico_camposervico.getText());
        pst.setString(2,cadastro_servico_campodescricao.getText());
        pst.setString(3,cadastro_servico_campovalor.getText());
        pst.setString(4,cadastro_servico_campocomissao.getText());
        
        pst.execute();
        JOptionPane.showMessageDialog(null, "Servico cadastrado com sucesso","Cadastro de Servico",JOptionPane.INFORMATION_MESSAGE);
    }
    
    catch(SQLException error)
            {
               JOptionPane.showMessageDialog(null,error);
            }
}



public void pesquisa_servico()
{
    String sql = "Select *from servico where servico like ?";
    
    try
    {
        pst = conecta.prepareStatement(sql);
        pst.setString(1,cadastro_servico_campoconsultar.getText()+"%");
        res = pst.executeQuery();
        cadastro_servico_tabelaconsulta2.setModel(DbUtils.resultSetToTableModel(res)); 
    }
    
    catch (SQLException error)
    {
                
        JOptionPane.showMessageDialog(null,error);                   
    }
 
}



public void mostra_servico()     
{
int seleciona =  cadastro_servico_tabelaconsulta2.getSelectedRow();
cadastro_servico_campocodigo.setText((String) cadastro_servico_tabelaconsulta2.getModel().getValueAt(seleciona, 0).toString()); 
cadastro_servico_camposervico.setText((String) cadastro_servico_tabelaconsulta2.getModel().getValueAt(seleciona, 1).toString());
cadastro_servico_campodescricao.setText((String) cadastro_servico_tabelaconsulta2.getModel().getValueAt(seleciona, 2).toString());
cadastro_servico_campovalor.setText((String) cadastro_servico_tabelaconsulta2.getModel().getValueAt(seleciona, 3).toString());
cadastro_servico_campocomissao.setText((String) cadastro_servico_tabelaconsulta2.getModel().getValueAt(seleciona, 4).toString());


}  



public void edita_servico()
{
  String sql = "Update servico set servico=?,descricao=?,valor=?,comissao=? where codigoservico=?"; 
  
  try
  {
      pst = conecta.prepareStatement(sql);

        pst.setString(1,cadastro_servico_camposervico.getText());
        pst.setString(2,cadastro_servico_campodescricao.getText());
        pst.setString(3,cadastro_servico_campovalor.getText());
        pst.setString(4,cadastro_servico_campocomissao.getText());
        pst.setInt(5,Integer.parseInt(cadastro_servico_campocodigo.getText()));
        
      pst.executeUpdate();
      JOptionPane.showMessageDialog(null,"Servico atualizado com sucesso");
      lista_servico();
  }
        
   catch(SQLException error)
           {
               JOptionPane.showMessageDialog(null,error);
           }
}




    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cadastro_servico_textoservico = new javax.swing.JLabel();
        cadastro_servico_camposervico = new javax.swing.JTextField();
        cadastro_servico_textodescricao = new javax.swing.JLabel();
        cadastro_servico_campodescricao = new javax.swing.JTextField();
        cadastro_clientefisico_textocadastro = new javax.swing.JLabel();
        cadastro_servico_textonumcad = new javax.swing.JLabel();
        cadastro_servico_textovalor = new javax.swing.JLabel();
        cadastro_clientefisico_separador = new javax.swing.JSeparator();
        cadastro_servico_botaocancelar = new javax.swing.JButton();
        cadastro_servico_botaosalvar = new javax.swing.JButton();
        cadastro_servico_botaonovo = new javax.swing.JButton();
        cadastro_servico_botaocadastrar = new javax.swing.JButton();
        cadastro_servico_campoconsultar = new javax.swing.JTextField();
        cadastro_clientefisico_tabelaconsulta = new javax.swing.JScrollPane();
        cadastro_servico_tabelaconsulta2 = new javax.swing.JTable();
        cadastro_servico_campocodigo = new javax.swing.JTextField();
        cadastro_servico_textocomissao = new javax.swing.JLabel();
        cadastro_servico_campovalor = new javax.swing.JFormattedTextField();
        cadastro_servico_campocomissao = new javax.swing.JFormattedTextField();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(0, 153, 255));
        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro de servicos");
        setToolTipText("");
        setMaximumSize(new java.awt.Dimension(574, 430));
        setMinimumSize(new java.awt.Dimension(574, 430));
        setName("cadastro_servico"); // NOI18N
        setNormalBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setPreferredSize(new java.awt.Dimension(574, 430));
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        setVisible(true);

        cadastro_servico_textoservico.setText("Servico");

        cadastro_servico_camposervico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cadastro_servico_camposervicoKeyPressed(evt);
            }
        });

        cadastro_servico_textodescricao.setText("Descricao");

        cadastro_servico_campodescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastro_servico_campodescricaoActionPerformed(evt);
            }
        });
        cadastro_servico_campodescricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cadastro_servico_campodescricaoKeyPressed(evt);
            }
        });

        cadastro_servico_textonumcad.setText("Servico Nº");

        cadastro_servico_textovalor.setText("Valor");

        cadastro_servico_botaocancelar.setText("Cancelar");
        cadastro_servico_botaocancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastro_servico_botaocancelarActionPerformed(evt);
            }
        });
        cadastro_servico_botaocancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cadastro_servico_botaocancelarKeyPressed(evt);
            }
        });

        cadastro_servico_botaosalvar.setText("Salvar");
        cadastro_servico_botaosalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastro_servico_botaosalvarActionPerformed(evt);
            }
        });
        cadastro_servico_botaosalvar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cadastro_servico_botaosalvarKeyPressed(evt);
            }
        });

        cadastro_servico_botaonovo.setText("Novo");
        cadastro_servico_botaonovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastro_servico_botaonovoActionPerformed(evt);
            }
        });

        cadastro_servico_botaocadastrar.setText("Cadastrar");
        cadastro_servico_botaocadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastro_servico_botaocadastrarActionPerformed(evt);
            }
        });
        cadastro_servico_botaocadastrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cadastro_servico_botaocadastrarKeyPressed(evt);
            }
        });

        cadastro_servico_campoconsultar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cadastro_servico_campoconsultarKeyReleased(evt);
            }
        });

        cadastro_servico_tabelaconsulta2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Cadastro", " Razão social", " CNPJ", "E-mail", "Telefone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        cadastro_servico_tabelaconsulta2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cadastro_servico_tabelaconsulta2MouseClicked(evt);
            }
        });
        cadastro_clientefisico_tabelaconsulta.setViewportView(cadastro_servico_tabelaconsulta2);

        cadastro_servico_campocodigo.setEnabled(false);

        cadastro_servico_textocomissao.setText("Comissao");

        try {
            cadastro_servico_campovalor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("R$ #########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            cadastro_servico_campocomissao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("R$ #########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cadastro_servico_botaocadastrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cadastro_servico_botaosalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(135, 135, 135)
                        .addComponent(cadastro_servico_botaocancelar)
                        .addGap(11, 11, 11))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cadastro_clientefisico_textocadastro)
                            .addComponent(cadastro_servico_textonumcad)
                            .addComponent(cadastro_servico_textodescricao)
                            .addComponent(cadastro_servico_textovalor))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cadastro_servico_campocodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cadastro_servico_textoservico)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cadastro_servico_camposervico))
                            .addComponent(cadastro_servico_campodescricao)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cadastro_servico_campovalor, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cadastro_servico_textocomissao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cadastro_servico_campocomissao)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cadastro_clientefisico_tabelaconsulta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                            .addComponent(cadastro_clientefisico_separador, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cadastro_servico_botaonovo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cadastro_servico_campoconsultar)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cadastro_servico_campocodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cadastro_servico_textoservico)
                        .addComponent(cadastro_servico_camposervico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cadastro_clientefisico_textocadastro)
                        .addComponent(cadastro_servico_textonumcad)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cadastro_servico_textodescricao)
                    .addComponent(cadastro_servico_campodescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadastro_servico_textovalor)
                    .addComponent(cadastro_servico_textocomissao)
                    .addComponent(cadastro_servico_campovalor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cadastro_servico_campocomissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadastro_servico_botaosalvar)
                    .addComponent(cadastro_servico_botaocancelar)
                    .addComponent(cadastro_servico_botaocadastrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cadastro_clientefisico_separador, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadastro_servico_campoconsultar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cadastro_servico_botaonovo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(cadastro_clientefisico_tabelaconsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setBounds(0, 430, 574, 430);
    }// </editor-fold>//GEN-END:initComponents

    private void cadastro_servico_botaocadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastro_servico_botaocadastrarActionPerformed
        // TODO add your handling code here:
        cadastro_servico();
    }//GEN-LAST:event_cadastro_servico_botaocadastrarActionPerformed

    private void cadastro_servico_botaosalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastro_servico_botaosalvarActionPerformed
        edita_servico();
    }//GEN-LAST:event_cadastro_servico_botaosalvarActionPerformed

    private void cadastro_servico_botaocancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastro_servico_botaocancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_cadastro_servico_botaocancelarActionPerformed

    private void cadastro_servico_camposervicoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cadastro_servico_camposervicoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            this.dispose();
        }
    }//GEN-LAST:event_cadastro_servico_camposervicoKeyPressed

    private void cadastro_servico_campodescricaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cadastro_servico_campodescricaoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            this.dispose();
        }
    }//GEN-LAST:event_cadastro_servico_campodescricaoKeyPressed

    private void cadastro_servico_botaocancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cadastro_servico_botaocancelarKeyPressed
        // TODO add your handling code here:
        
          if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            this.dispose();
        }

        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE){
            this.dispose();}
    }//GEN-LAST:event_cadastro_servico_botaocancelarKeyPressed

    private void cadastro_servico_botaosalvarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cadastro_servico_botaosalvarKeyPressed
        // TODO add your handling code here:
        
          if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            edita_servico();
        }

        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE){
            this.dispose();}
    }//GEN-LAST:event_cadastro_servico_botaosalvarKeyPressed

    private void cadastro_servico_campoconsultarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cadastro_servico_campoconsultarKeyReleased
        // TODO add your handling code here:
        pesquisa_servico();
    }//GEN-LAST:event_cadastro_servico_campoconsultarKeyReleased

    private void cadastro_servico_tabelaconsulta2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cadastro_servico_tabelaconsulta2MouseClicked
        // TODO add your handling code here:
        mostra_servico();
    }//GEN-LAST:event_cadastro_servico_tabelaconsulta2MouseClicked

    private void cadastro_servico_botaonovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastro_servico_botaonovoActionPerformed
        // TODO add your handling code here:
        novo_servico();
    }//GEN-LAST:event_cadastro_servico_botaonovoActionPerformed

    private void cadastro_servico_botaocadastrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cadastro_servico_botaocadastrarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            cadastro_servico();
        }

        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE){
            this.dispose();}
    }//GEN-LAST:event_cadastro_servico_botaocadastrarKeyPressed

    private void cadastro_servico_campodescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastro_servico_campodescricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cadastro_servico_campodescricaoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator cadastro_clientefisico_separador;
    private javax.swing.JScrollPane cadastro_clientefisico_tabelaconsulta;
    private javax.swing.JLabel cadastro_clientefisico_textocadastro;
    private javax.swing.JButton cadastro_servico_botaocadastrar;
    private javax.swing.JButton cadastro_servico_botaocancelar;
    private javax.swing.JButton cadastro_servico_botaonovo;
    private javax.swing.JButton cadastro_servico_botaosalvar;
    private javax.swing.JTextField cadastro_servico_campocodigo;
    private javax.swing.JFormattedTextField cadastro_servico_campocomissao;
    private javax.swing.JTextField cadastro_servico_campoconsultar;
    private javax.swing.JTextField cadastro_servico_campodescricao;
    private javax.swing.JTextField cadastro_servico_camposervico;
    private javax.swing.JFormattedTextField cadastro_servico_campovalor;
    private javax.swing.JTable cadastro_servico_tabelaconsulta2;
    private javax.swing.JLabel cadastro_servico_textocomissao;
    private javax.swing.JLabel cadastro_servico_textodescricao;
    private javax.swing.JLabel cadastro_servico_textonumcad;
    private javax.swing.JLabel cadastro_servico_textoservico;
    private javax.swing.JLabel cadastro_servico_textovalor;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private void setLocationRelativeTo(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
