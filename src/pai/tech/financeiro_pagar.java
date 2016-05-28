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
public class financeiro_pagar extends javax.swing.JInternalFrame 
{
    Connection conecta;
    PreparedStatement pst;
    ResultSet res;     
            
            
    public financeiro_pagar() throws ClassNotFoundException {
        initComponents();
        conecta = conectabanco.conectabanco();
        this.dispose();
    }

    
    
    public void pesquisa_pagarfornecedor()
{
    String sql = "Select razao from fornecedor where razao like ?";
    
    try
    {
        pst = conecta.prepareStatement(sql);
        pst.setString(1,pagar_campofornecedor.getText()+"%");
        res = pst.executeQuery();
        pagar_tabelafornecedor.setModel(DbUtils.resultSetToTableModel(res)); 
    }
    
    catch (SQLException error)
    {
                
        JOptionPane.showMessageDialog(null,error);                   
    }
 
}



public void mostra_pagarfornecedor()     
{
int seleciona =  pagar_tabelafornecedor.getSelectedRow();
pagar_campofornecedor.setText((String) pagar_tabelafornecedor.getModel().getValueAt(seleciona, 0).toString());


}  
  
    
    public void lista_pagarfornecedor()
    {
        String sql = "Select razao from fornecedor";
        try
        {
            pst = conecta.prepareStatement(sql);
            res = pst.executeQuery();
            pagar_tabelafornecedor.setModel(DbUtils.resultSetToTableModel(res));            
        }
        
        catch(SQLException error)
        {
          JOptionPane.showMessageDialog(null,error);      
        } 
    }
    
    
    
    
    public void pesquisa_pagarfuncionario()
{
    String sql = "Select funcionario from funcionario where funcionario like ?";
    
    try
    {
        pst = conecta.prepareStatement(sql);
        pst.setString(1,pagar_campofornecedor.getText()+"%");
        res = pst.executeQuery();
        pagar_tabelafornecedor.setModel(DbUtils.resultSetToTableModel(res)); 
    }
    
    catch (SQLException error)
    {
                
        JOptionPane.showMessageDialog(null,error);                   
    }
 
}



public void mostra_pagarfuncionario()     
{
int seleciona =  pagar_tabelafornecedor.getSelectedRow();
pagar_campofornecedor.setText((String) pagar_tabelafornecedor.getModel().getValueAt(seleciona, 0).toString());


}  
  
    
    public void lista_pagarfuncionario()
    {
        String sql = "Select funcionario from funcionario";
        try
        {
            pst = conecta.prepareStatement(sql);
            res = pst.executeQuery();
            pagar_tabelafornecedor.setModel(DbUtils.resultSetToTableModel(res));            
        }
        
        catch(SQLException error)
        {
          JOptionPane.showMessageDialog(null,error);      
        } 
    }
        
    
    
    
    
    
    
  
    public void  novo_pagar()
    {
        pagar_campoidentificador.setText("") ;
        pagar_camporesumo.setText("") ;
        pagar_camporesumo.setText("") ;
        pagar_campofornecedor.setText("") ;
        pagar_campovalor.setText("");
        pagar_campovencimento.setText("");    
    }  

    public void  cadastro_pagar()       
{
    
    String sql = "Insert into pagar(resumo,cliente,descricao,valor,vencimento) values (?,?,?,?,?)";  
    
    try
    {
        pst = conecta.prepareStatement(sql);
        
        pst.setString(1,pagar_camporesumo.getText());
        pst.setString(2,pagar_campofornecedor.getText());
        pst.setString(3,pagar_campodescricao.getText());
        pst.setString(4,pagar_campovalor.getText());
        pst.setString(5,pagar_campovencimento.getText());
        
        pst.execute();
        JOptionPane.showMessageDialog(null, "Contas a pagar cadastrado com sucesso","Cadastro Financeiro",JOptionPane.INFORMATION_MESSAGE);
    }
    
    catch(SQLException error)
            {
               JOptionPane.showMessageDialog(null,error);
            }
}


    
public void edita_pagar()
{
  String sql = "Update pagar set resumo=?,cliente=?,descricao=?,valor=?,vencimento=? where codigoreceber=?"; 
  
  try
  {
      pst = conecta.prepareStatement(sql);

        pst.setString(1,pagar_camporesumo.getText());
        pst.setString(2,pagar_campofornecedor.getText());
        pst.setString(3,pagar_campodescricao.getText());
        pst.setString(4,pagar_campovalor.getText());
        pst.setString(5,pagar_campovencimento.getText());
        pst.setInt(6,Integer.parseInt(pagar_campoidentificador.getText()));
        
      pst.executeUpdate();
      JOptionPane.showMessageDialog(null,"Contas a pagar atualizado com sucesso");
      lista_pagar();
  }
        
   catch(SQLException error)
           {
               JOptionPane.showMessageDialog(null,error);
           }
}



public void pesquisa_pagar()
{
    String sql = "Select * from pagar where resumo like ?";
    
    try
    {
        pst = conecta.prepareStatement(sql);
        pst.setString(1,pagar_campopesquisa.getText()+"%");
        res = pst.executeQuery();
        pagar_tabelapesquisa.setModel(DbUtils.resultSetToTableModel(res)); 
    }
    
    catch (SQLException error)
    {
                
        JOptionPane.showMessageDialog(null,error);                   
    }
 
}


public void mostra_pagar()     
{
int seleciona =  pagar_tabelapesquisa.getSelectedRow();
pagar_campoidentificador.setText((String) pagar_tabelapesquisa.getModel().getValueAt(seleciona, 0).toString());
pagar_camporesumo.setText((String) pagar_tabelapesquisa.getModel().getValueAt(seleciona, 1).toString());
pagar_campofornecedor.setText((String) pagar_tabelapesquisa.getModel().getValueAt(seleciona, 2).toString());
pagar_campodescricao.setText((String) pagar_tabelapesquisa.getModel().getValueAt(seleciona, 3).toString());
pagar_campovalor.setText((String) pagar_tabelapesquisa.getModel().getValueAt(seleciona, 4).toString());
pagar_campovencimento.setText((String) pagar_tabelapesquisa.getModel().getValueAt(seleciona, 5).toString());
}  
  
    
    public void lista_pagar()
    {
        String sql = "Select * from pagar";
        try
        {
            pst = conecta.prepareStatement(sql);
            res = pst.executeQuery();
            pagar_tabelapesquisa.setModel(DbUtils.resultSetToTableModel(res));            
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
        pagar_textoresumo = new javax.swing.JLabel();
        pagar_camporesumo = new javax.swing.JTextField();
        pagar_textodescricao = new javax.swing.JLabel();
        cadastro_clientefisico_textocadastro = new javax.swing.JLabel();
        pagar_textoidentificador = new javax.swing.JLabel();
        pagar_textovalor = new javax.swing.JLabel();
        pagar_botaocancelar = new javax.swing.JButton();
        pagar_botaosalvar = new javax.swing.JButton();
        pagar_botaonovo = new javax.swing.JButton();
        pagar_botaocadastrar = new javax.swing.JButton();
        receber_tabelacliente1 = new javax.swing.JScrollPane();
        pagar_tabelafornecedor = new javax.swing.JTable();
        pagar_campoidentificador = new javax.swing.JTextField();
        pagar_textofornecedor = new javax.swing.JLabel();
        pagar_campofornecedor = new javax.swing.JTextField();
        pagar_campopesquisa = new javax.swing.JTextField();
        servico_tabelaordem1 = new javax.swing.JScrollPane();
        pagar_tabelapesquisa = new javax.swing.JTable();
        cadastro_clientefisico_separador3 = new javax.swing.JSeparator();
        pagar_textopesquisa = new javax.swing.JLabel();
        pagar_textovencimento = new javax.swing.JLabel();
        pagar_campovalor = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        pagar_campodescricao = new javax.swing.JTextArea();
        pagar_campovencimento = new javax.swing.JFormattedTextField();

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
        setTitle("Contas a pagar");
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

        pagar_textoresumo.setText("Resumo");

        pagar_camporesumo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pagar_camporesumoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pagar_camporesumoKeyReleased(evt);
            }
        });

        pagar_textodescricao.setText("Descricao");

        pagar_textoidentificador.setText("Identificador");

        pagar_textovalor.setText("Valor");

        pagar_botaocancelar.setText("Cancelar");
        pagar_botaocancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagar_botaocancelarActionPerformed(evt);
            }
        });
        pagar_botaocancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pagar_botaocancelarKeyPressed(evt);
            }
        });

        pagar_botaosalvar.setText("Salvar");
        pagar_botaosalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagar_botaosalvarActionPerformed(evt);
            }
        });
        pagar_botaosalvar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pagar_botaosalvarKeyPressed(evt);
            }
        });

        pagar_botaonovo.setText("Novo");
        pagar_botaonovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagar_botaonovoActionPerformed(evt);
            }
        });

        pagar_botaocadastrar.setText("Cadastrar");
        pagar_botaocadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagar_botaocadastrarActionPerformed(evt);
            }
        });
        pagar_botaocadastrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pagar_botaocadastrarKeyPressed(evt);
            }
        });

        pagar_tabelafornecedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        pagar_tabelafornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pagar_tabelafornecedorMouseClicked(evt);
            }
        });
        receber_tabelacliente1.setViewportView(pagar_tabelafornecedor);

        pagar_campoidentificador.setEnabled(false);

        pagar_textofornecedor.setText("Pesq. Forn");

        pagar_campofornecedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pagar_campofornecedorKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pagar_campofornecedorKeyReleased(evt);
            }
        });

        pagar_campopesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagar_campopesquisaActionPerformed(evt);
            }
        });
        pagar_campopesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pagar_campopesquisaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pagar_campopesquisaKeyReleased(evt);
            }
        });

        pagar_tabelapesquisa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        pagar_tabelapesquisa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pagar_tabelapesquisaMouseClicked(evt);
            }
        });
        servico_tabelaordem1.setViewportView(pagar_tabelapesquisa);

        pagar_textopesquisa.setText("Pesquisar Contas a pagar");

        pagar_textovencimento.setText("Vencimento");

        try {
            pagar_campovalor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("R$ #########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        pagar_campovalor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagar_campovalorActionPerformed(evt);
            }
        });

        pagar_campodescricao.setColumns(20);
        pagar_campodescricao.setRows(5);
        jScrollPane1.setViewportView(pagar_campodescricao);

        try {
            pagar_campovencimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        pagar_campovencimento.setHorizontalAlignment(javax.swing.JTextField.CENTER);

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
                        .addComponent(cadastro_clientefisico_textocadastro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pagar_textoidentificador)
                            .addComponent(pagar_textofornecedor, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pagar_campofornecedor, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pagar_campoidentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pagar_textoresumo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pagar_camporesumo))))
                    .addComponent(receber_tabelacliente1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pagar_textodescricao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pagar_textovalor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pagar_campovalor, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(pagar_textovencimento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pagar_campovencimento))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pagar_botaocadastrar)
                        .addGap(85, 85, 85)
                        .addComponent(pagar_botaosalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98)
                        .addComponent(pagar_botaonovo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pagar_botaocancelar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(pagar_textopesquisa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pagar_campopesquisa)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(pagar_textoidentificador)
                        .addComponent(pagar_campoidentificador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pagar_textoresumo)
                        .addComponent(pagar_camporesumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cadastro_clientefisico_textocadastro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pagar_textofornecedor)
                    .addComponent(pagar_campofornecedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(receber_tabelacliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(pagar_textodescricao)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pagar_campovalor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pagar_textovencimento)
                    .addComponent(pagar_campovencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pagar_textovalor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cadastro_clientefisico_separador3, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pagar_botaocadastrar)
                    .addComponent(pagar_botaosalvar)
                    .addComponent(pagar_botaonovo)
                    .addComponent(pagar_botaocancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pagar_campopesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pagar_textopesquisa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(servico_tabelaordem1, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                .addContainerGap())
        );

        setBounds(0, 0, 620, 527);
    }// </editor-fold>//GEN-END:initComponents

    private void pagar_botaocadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagar_botaocadastrarActionPerformed
        // TODO add your handling code here:
        cadastro_pagar();
    }//GEN-LAST:event_pagar_botaocadastrarActionPerformed

    private void pagar_botaosalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagar_botaosalvarActionPerformed
        edita_pagar();
    }//GEN-LAST:event_pagar_botaosalvarActionPerformed

    private void pagar_botaocancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagar_botaocancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_pagar_botaocancelarActionPerformed

    private void pagar_camporesumoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pagar_camporesumoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            this.dispose();
        }
    }//GEN-LAST:event_pagar_camporesumoKeyPressed

    private void pagar_botaocancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pagar_botaocancelarKeyPressed
        // TODO add your handling code here:
        
          if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            this.dispose();
        }

        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE){
            this.dispose();}
    }//GEN-LAST:event_pagar_botaocancelarKeyPressed

    private void pagar_botaosalvarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pagar_botaosalvarKeyPressed
        // TODO add your handling code here:
        
          if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            edita_pagar();
        }

        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE){
            this.dispose();}
    }//GEN-LAST:event_pagar_botaosalvarKeyPressed

    private void pagar_tabelafornecedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pagar_tabelafornecedorMouseClicked
        // TODO add your handling code here:
       mostra_pagarfornecedor();
    }//GEN-LAST:event_pagar_tabelafornecedorMouseClicked

    private void pagar_botaonovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagar_botaonovoActionPerformed
        // TODO add your handling code here:
        novo_pagar();
    }//GEN-LAST:event_pagar_botaonovoActionPerformed

    private void pagar_botaocadastrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pagar_botaocadastrarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            cadastro_pagar();
        }

        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE){
            this.dispose();}
    }//GEN-LAST:event_pagar_botaocadastrarKeyPressed

    private void pagar_campofornecedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pagar_campofornecedorKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_pagar_campofornecedorKeyPressed

    private void pagar_campopesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pagar_campopesquisaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_pagar_campopesquisaKeyPressed

    private void pagar_tabelapesquisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pagar_tabelapesquisaMouseClicked
        // TODO add your handling code here:
        mostra_pagar();
    }//GEN-LAST:event_pagar_tabelapesquisaMouseClicked

    private void pagar_camporesumoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pagar_camporesumoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_pagar_camporesumoKeyReleased

    private void pagar_campofornecedorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pagar_campofornecedorKeyReleased
        // TODO add your handling code here:
        pesquisa_pagarfornecedor();
    }//GEN-LAST:event_pagar_campofornecedorKeyReleased

    private void pagar_campovalorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagar_campovalorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pagar_campovalorActionPerformed

    private void pagar_campopesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagar_campopesquisaActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_pagar_campopesquisaActionPerformed

    private void pagar_campopesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pagar_campopesquisaKeyReleased
        // TODO add your handling code here:
         pesquisa_pagar();
    }//GEN-LAST:event_pagar_campopesquisaKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator cadastro_clientefisico_separador3;
    private javax.swing.JLabel cadastro_clientefisico_textocadastro;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton pagar_botaocadastrar;
    private javax.swing.JButton pagar_botaocancelar;
    private javax.swing.JButton pagar_botaonovo;
    private javax.swing.JButton pagar_botaosalvar;
    private javax.swing.JTextArea pagar_campodescricao;
    private javax.swing.JTextField pagar_campofornecedor;
    private javax.swing.JTextField pagar_campoidentificador;
    private javax.swing.JTextField pagar_campopesquisa;
    private javax.swing.JTextField pagar_camporesumo;
    private javax.swing.JFormattedTextField pagar_campovalor;
    private javax.swing.JFormattedTextField pagar_campovencimento;
    private javax.swing.JTable pagar_tabelafornecedor;
    private javax.swing.JTable pagar_tabelapesquisa;
    private javax.swing.JLabel pagar_textodescricao;
    private javax.swing.JLabel pagar_textofornecedor;
    private javax.swing.JLabel pagar_textoidentificador;
    private javax.swing.JLabel pagar_textopesquisa;
    private javax.swing.JLabel pagar_textoresumo;
    private javax.swing.JLabel pagar_textovalor;
    private javax.swing.JLabel pagar_textovencimento;
    private javax.swing.JScrollPane receber_tabelacliente1;
    private javax.swing.JScrollPane servico_tabelaordem1;
    // End of variables declaration//GEN-END:variables

    private void setLocationRelativeTo(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
