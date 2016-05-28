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
public class financeiro_receber extends javax.swing.JInternalFrame 
{
    Connection conecta;
    PreparedStatement pst;
    ResultSet res;     
            
            
    public financeiro_receber() throws ClassNotFoundException {
        initComponents();
        conecta = conectabanco.conectabanco();
        this.dispose();
    }

    public void pesquisa_recebercliente()
{
    String sql = "Select nome from cliente where nome like ?";
    
    try
    {
        pst = conecta.prepareStatement(sql);
        pst.setString(1,receber_campocliente.getText()+"%");
        res = pst.executeQuery();
        receber_tabelacliente.setModel(DbUtils.resultSetToTableModel(res)); 
    }
    
    catch (SQLException error)
    {
                
        JOptionPane.showMessageDialog(null,error);                   
    }
 
}



public void mostra_recebercliente()     
{
int seleciona =  receber_tabelacliente.getSelectedRow();
receber_campocliente.setText((String) receber_tabelacliente.getModel().getValueAt(seleciona, 0).toString());


}  
  
    
    public void lista_recebercliente()
    {
        String sql = "Select nome from cliente";
        try
        {
            pst = conecta.prepareStatement(sql);
            res = pst.executeQuery();
            receber_tabelacliente.setModel(DbUtils.resultSetToTableModel(res));            
        }
        
        catch(SQLException error)
        {
          JOptionPane.showMessageDialog(null,error);      
        } 
    }
        
    
    
    
  
    public void  novo_receber()
    {
        receber_campocodigo.setText("") ;
        receber_camporesumo.setText("") ;
        receber_camporesumo.setText("") ;
        receber_campocliente.setText("") ;
        receber_campovalor.setText("");
        receber_campovencimento.setText("");    
    }  

    public void  cadastro_receber()       
{
    
    String sql = "Insert into receber(resumo,cliente,descricao,valor,vencimento) values (?,?,?,?,?)";  
    
    try
    {
        pst = conecta.prepareStatement(sql);
        
        pst.setString(1,receber_camporesumo.getText());
        pst.setString(2,receber_campocliente.getText());
        pst.setString(3,receber_campodescricao.getText());
        pst.setString(4,receber_campovalor.getText());
        pst.setString(5,receber_campovencimento.getText());
        
        pst.execute();
        JOptionPane.showMessageDialog(null, "Contas a receber cadastrado com sucesso","Cadastro Financeiro",JOptionPane.INFORMATION_MESSAGE);
    }
    
    catch(SQLException error)
            {
               JOptionPane.showMessageDialog(null,error);
            }
}


    
public void edita_receber()
{
  String sql = "Update receber set resumo=?,cliente=?,descricao=?,valor=?,vencimento=? where codigoreceber=?"; 
  
  try
  {
      pst = conecta.prepareStatement(sql);

        pst.setString(1,receber_camporesumo.getText());
        pst.setString(2,receber_campocliente.getText());
        pst.setString(3,receber_campodescricao.getText());
        pst.setString(4,receber_campovalor.getText());
        pst.setString(5,receber_campovencimento.getText());
        pst.setInt(6,Integer.parseInt(receber_campocodigo.getText()));
        
      pst.executeUpdate();
      JOptionPane.showMessageDialog(null,"Contas a receber atualizado com sucesso");
      lista_receber();
  }
        
   catch(SQLException error)
           {
               JOptionPane.showMessageDialog(null,error);
           }
}



public void pesquisa_receber()
{
    String sql = "Select * from receber where codigoreceber like ?";
    
    try
    {
        pst = conecta.prepareStatement(sql);
        pst.setString(1,receber_campopesquisa.getText()+"%");
        res = pst.executeQuery();
        receber_tabelapesquisa.setModel(DbUtils.resultSetToTableModel(res)); 
    }
    
    catch (SQLException error)
    {
                
        JOptionPane.showMessageDialog(null,error);                   
    }
 
}


public void mostra_receber()     
{
int seleciona =  receber_tabelapesquisa.getSelectedRow();
receber_camporesumo.setText((String) receber_tabelapesquisa.getModel().getValueAt(seleciona, 1).toString());
receber_campocliente.setText((String) receber_tabelapesquisa.getModel().getValueAt(seleciona, 2).toString());
receber_campodescricao.setText((String) receber_tabelapesquisa.getModel().getValueAt(seleciona, 3).toString());
receber_campovalor.setText((String) receber_tabelapesquisa.getModel().getValueAt(seleciona, 4).toString());
receber_campovencimento.setText((String) receber_tabelapesquisa.getModel().getValueAt(seleciona, 5).toString());
}  
  
    
    public void lista_receber()
    {
        String sql = "Select * from receber";
        try
        {
            pst = conecta.prepareStatement(sql);
            res = pst.executeQuery();
            receber_tabelapesquisa.setModel(DbUtils.resultSetToTableModel(res));            
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
        receber_textoresumo = new javax.swing.JLabel();
        receber_camporesumo = new javax.swing.JTextField();
        receber_textodescricao = new javax.swing.JLabel();
        cadastro_clientefisico_textocadastro = new javax.swing.JLabel();
        cadastro_servico_textonumcad = new javax.swing.JLabel();
        receber_textovalor = new javax.swing.JLabel();
        receber_botaocancelar = new javax.swing.JButton();
        receber_botaosalvar = new javax.swing.JButton();
        receber_botaonovo = new javax.swing.JButton();
        receber_botaocadastrar = new javax.swing.JButton();
        receber_tabelacliente1 = new javax.swing.JScrollPane();
        receber_tabelacliente = new javax.swing.JTable();
        receber_campocodigo = new javax.swing.JTextField();
        receber_textocliente = new javax.swing.JLabel();
        receber_campocliente = new javax.swing.JTextField();
        receber_campopesquisa = new javax.swing.JTextField();
        servico_tabelaordem1 = new javax.swing.JScrollPane();
        receber_tabelapesquisa = new javax.swing.JTable();
        cadastro_clientefisico_separador3 = new javax.swing.JSeparator();
        receber_textopesquisa = new javax.swing.JLabel();
        receber_textovencimento = new javax.swing.JLabel();
        receber_campovalor = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        receber_campodescricao = new javax.swing.JTextArea();
        receber_campovencimento = new javax.swing.JFormattedTextField();

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

        receber_textoresumo.setText("Resumo");

        receber_camporesumo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                receber_camporesumoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                receber_camporesumoKeyReleased(evt);
            }
        });

        receber_textodescricao.setText("Descricao");

        cadastro_servico_textonumcad.setText("Identificador");

        receber_textovalor.setText("Valor");

        receber_botaocancelar.setText("Cancelar");
        receber_botaocancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receber_botaocancelarActionPerformed(evt);
            }
        });
        receber_botaocancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                receber_botaocancelarKeyPressed(evt);
            }
        });

        receber_botaosalvar.setText("Salvar");
        receber_botaosalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receber_botaosalvarActionPerformed(evt);
            }
        });
        receber_botaosalvar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                receber_botaosalvarKeyPressed(evt);
            }
        });

        receber_botaonovo.setText("Novo");
        receber_botaonovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receber_botaonovoActionPerformed(evt);
            }
        });

        receber_botaocadastrar.setText("Cadastrar");
        receber_botaocadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receber_botaocadastrarActionPerformed(evt);
            }
        });
        receber_botaocadastrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                receber_botaocadastrarKeyPressed(evt);
            }
        });

        receber_tabelacliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        receber_tabelacliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                receber_tabelaclienteMouseClicked(evt);
            }
        });
        receber_tabelacliente1.setViewportView(receber_tabelacliente);

        receber_campocodigo.setEnabled(false);

        receber_textocliente.setText("Pesq. Cliente");

        receber_campocliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                receber_campoclienteKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                receber_campoclienteKeyReleased(evt);
            }
        });

        receber_campopesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receber_campopesquisaActionPerformed(evt);
            }
        });
        receber_campopesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                receber_campopesquisaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                receber_campopesquisaKeyReleased(evt);
            }
        });

        receber_tabelapesquisa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        receber_tabelapesquisa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                receber_tabelapesquisaMouseClicked(evt);
            }
        });
        servico_tabelaordem1.setViewportView(receber_tabelapesquisa);

        receber_textopesquisa.setText("Pesquisar Contas a receber");

        receber_textovencimento.setText("Vencimento");

        receber_campovalor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receber_campovalorActionPerformed(evt);
            }
        });

        receber_campodescricao.setColumns(20);
        receber_campodescricao.setRows(5);
        jScrollPane1.setViewportView(receber_campodescricao);

        try {
            receber_campovencimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##            /          ##           /               ####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        receber_campovencimento.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(servico_tabelaordem1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
                    .addComponent(cadastro_clientefisico_separador3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cadastro_clientefisico_textocadastro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cadastro_servico_textonumcad))
                            .addComponent(receber_textocliente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(receber_campocliente, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(receber_campocodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(receber_textoresumo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(receber_camporesumo))))
                    .addComponent(receber_tabelacliente1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(receber_textodescricao)
                            .addComponent(receber_textovalor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(receber_campovalor, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(receber_textovencimento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(receber_campovencimento))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(receber_botaocadastrar)
                        .addGap(85, 85, 85)
                        .addComponent(receber_botaosalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98)
                        .addComponent(receber_botaonovo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(receber_botaocancelar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(receber_textopesquisa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(receber_campopesquisa)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cadastro_servico_textonumcad)
                        .addComponent(receber_campocodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(receber_textoresumo)
                        .addComponent(receber_camporesumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cadastro_clientefisico_textocadastro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(receber_textocliente)
                    .addComponent(receber_campocliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(receber_tabelacliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(receber_textodescricao)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(receber_campovalor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(receber_textovencimento)
                    .addComponent(receber_campovencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(receber_textovalor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cadastro_clientefisico_separador3, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(receber_botaocadastrar)
                    .addComponent(receber_botaosalvar)
                    .addComponent(receber_botaonovo)
                    .addComponent(receber_botaocancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(receber_campopesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(receber_textopesquisa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(servico_tabelaordem1, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                .addContainerGap())
        );

        setBounds(0, 0, 620, 527);
    }// </editor-fold>//GEN-END:initComponents

    private void receber_botaocadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receber_botaocadastrarActionPerformed
        // TODO add your handling code here:
        cadastro_receber();
    }//GEN-LAST:event_receber_botaocadastrarActionPerformed

    private void receber_botaosalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receber_botaosalvarActionPerformed
        edita_receber();
    }//GEN-LAST:event_receber_botaosalvarActionPerformed

    private void receber_botaocancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receber_botaocancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_receber_botaocancelarActionPerformed

    private void receber_camporesumoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_receber_camporesumoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            this.dispose();
        }
    }//GEN-LAST:event_receber_camporesumoKeyPressed

    private void receber_botaocancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_receber_botaocancelarKeyPressed
        // TODO add your handling code here:
        
          if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            this.dispose();
        }

        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE){
            this.dispose();}
    }//GEN-LAST:event_receber_botaocancelarKeyPressed

    private void receber_botaosalvarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_receber_botaosalvarKeyPressed
        // TODO add your handling code here:
        
          if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            edita_receber();
        }

        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE){
            this.dispose();}
    }//GEN-LAST:event_receber_botaosalvarKeyPressed

    private void receber_tabelaclienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_receber_tabelaclienteMouseClicked
        // TODO add your handling code here:
       mostra_recebercliente();
    }//GEN-LAST:event_receber_tabelaclienteMouseClicked

    private void receber_botaonovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receber_botaonovoActionPerformed
        // TODO add your handling code here:
        novo_receber();
    }//GEN-LAST:event_receber_botaonovoActionPerformed

    private void receber_botaocadastrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_receber_botaocadastrarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            cadastro_receber();
        }

        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE){
            this.dispose();}
    }//GEN-LAST:event_receber_botaocadastrarKeyPressed

    private void receber_campoclienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_receber_campoclienteKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_receber_campoclienteKeyPressed

    private void receber_campopesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_receber_campopesquisaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_receber_campopesquisaKeyPressed

    private void receber_tabelapesquisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_receber_tabelapesquisaMouseClicked
        // TODO add your handling code here:
        mostra_receber();
    }//GEN-LAST:event_receber_tabelapesquisaMouseClicked

    private void receber_camporesumoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_receber_camporesumoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_receber_camporesumoKeyReleased

    private void receber_campoclienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_receber_campoclienteKeyReleased
        // TODO add your handling code here:
        pesquisa_recebercliente();
    }//GEN-LAST:event_receber_campoclienteKeyReleased

    private void receber_campovalorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receber_campovalorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_receber_campovalorActionPerformed

    private void receber_campopesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receber_campopesquisaActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_receber_campopesquisaActionPerformed

    private void receber_campopesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_receber_campopesquisaKeyReleased
        // TODO add your handling code here:
         pesquisa_receber();
    }//GEN-LAST:event_receber_campopesquisaKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator cadastro_clientefisico_separador3;
    private javax.swing.JLabel cadastro_clientefisico_textocadastro;
    private javax.swing.JLabel cadastro_servico_textonumcad;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton receber_botaocadastrar;
    private javax.swing.JButton receber_botaocancelar;
    private javax.swing.JButton receber_botaonovo;
    private javax.swing.JButton receber_botaosalvar;
    private javax.swing.JTextField receber_campocliente;
    private javax.swing.JTextField receber_campocodigo;
    private javax.swing.JTextArea receber_campodescricao;
    private javax.swing.JTextField receber_campopesquisa;
    private javax.swing.JTextField receber_camporesumo;
    private javax.swing.JFormattedTextField receber_campovalor;
    private javax.swing.JFormattedTextField receber_campovencimento;
    private javax.swing.JTable receber_tabelacliente;
    private javax.swing.JScrollPane receber_tabelacliente1;
    private javax.swing.JTable receber_tabelapesquisa;
    private javax.swing.JLabel receber_textocliente;
    private javax.swing.JLabel receber_textodescricao;
    private javax.swing.JLabel receber_textopesquisa;
    private javax.swing.JLabel receber_textoresumo;
    private javax.swing.JLabel receber_textovalor;
    private javax.swing.JLabel receber_textovencimento;
    private javax.swing.JScrollPane servico_tabelaordem1;
    // End of variables declaration//GEN-END:variables

    private void setLocationRelativeTo(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
