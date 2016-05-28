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
public class servico_ordem extends javax.swing.JInternalFrame 
{
    Connection conecta;
    PreparedStatement pst;
    ResultSet res;     
            
            
    public servico_ordem() throws ClassNotFoundException {
        initComponents();
        conecta = conectabanco.conectabanco();
        this.dispose();
    }

    public void pesquisa_servico()
{
    String sql = "Select * from servico where servico like ?";
    
    try
    {
        pst = conecta.prepareStatement(sql);
        pst.setString(1,servico_camposervico.getText()+"%");
        res = pst.executeQuery();
        servico_tabelaservico.setModel(DbUtils.resultSetToTableModel(res)); 
    }
    
    catch (SQLException error)
    {
                
        JOptionPane.showMessageDialog(null,error);                   
    }
 
}


public void mostra_servico()     
{
int seleciona =  servico_tabelaservico.getSelectedRow();
servico_campocodigo.setText((String) servico_tabelaservico.getModel().getValueAt(seleciona, 0).toString());
servico_camposervico.setText((String) servico_tabelaservico.getModel().getValueAt(seleciona, 1).toString());
servico_campodescricao.setText((String) servico_tabelaservico.getModel().getValueAt(seleciona, 2).toString());
servico_campovalor.setText((String) servico_tabelaservico.getModel().getValueAt(seleciona, 3).toString());
servico_campocomissao.setText((String) servico_tabelaservico.getModel().getValueAt(seleciona, 4).toString());
}

public void lista_servico()
    {
        String sql = "Select * from servico";
        try
        {
            pst = conecta.prepareStatement(sql);
            res = pst.executeQuery();
            servico_tabelaservico.setModel(DbUtils.resultSetToTableModel(res));            
        }
        
        catch(SQLException error)
        {
          JOptionPane.showMessageDialog(null,error);      
        } 
    }    






    
    public void pesquisa_servicocliente()
{
    String sql = "Select nome from cliente where nome like ?";
    
    try
    {
        pst = conecta.prepareStatement(sql);
        pst.setString(1,servico_campocliente.getText()+"%");
        res = pst.executeQuery();
        servico_tabelacliente.setModel(DbUtils.resultSetToTableModel(res)); 
    }
    
    catch (SQLException error)
    {
                
        JOptionPane.showMessageDialog(null,error);                   
    }
 
}



public void mostra_servicocliente()     
{
int seleciona =  servico_tabelacliente.getSelectedRow();
servico_campocliente.setText((String) servico_tabelacliente.getModel().getValueAt(seleciona, 0).toString());


}  
  
    
    public void lista_servicocliente()
    {
        String sql = "Select nome from cliente";
        try
        {
            pst = conecta.prepareStatement(sql);
            res = pst.executeQuery();
            servico_tabelacliente.setModel(DbUtils.resultSetToTableModel(res));            
        }
        
        catch(SQLException error)
        {
          JOptionPane.showMessageDialog(null,error);      
        } 
    }
    
    
    
    
    
     public void pesquisa_servicofuncionario()
{
    String sql = "Select funcionario from funcionario where funcionario like ?";
    
    try
    {
        pst = conecta.prepareStatement(sql);
        pst.setString(1,servico_campofuncionario.getText()+"%");
        res = pst.executeQuery();
        servico_tabelafuncionario.setModel(DbUtils.resultSetToTableModel(res)); 
    }
    
    catch (SQLException error)
    {
                
        JOptionPane.showMessageDialog(null,error);                   
    }
 
}



public void mostra_servicofuncionario()     
{
int seleciona =  servico_tabelafuncionario.getSelectedRow();
servico_campofuncionario.setText((String) servico_tabelafuncionario.getModel().getValueAt(seleciona, 0).toString());


}  
  
    
    public void lista_servicofuncionario()
    {
        String sql = "Select funcionario from funcionario";
        try
        {
            pst = conecta.prepareStatement(sql);
            res = pst.executeQuery();
            servico_tabelafuncionario.setModel(DbUtils.resultSetToTableModel(res));            
        }
        
        catch(SQLException error)
        {
          JOptionPane.showMessageDialog(null,error);      
        } 
    }
    
    
    
    
    
    
  
    public void  novo_ordemservico()
    {
        servico_campocodigo.setText("") ;
        servico_camposervico.setText("") ;
        servico_campodescricao.setText("") ;
        servico_campovalor.setText("");
        servico_campocomissao.setText("");    
    }  

    public void  cadastro_ordemservico()       
{
    
    String sql = "Insert into servico(servico,descricao,valor,comissao) values (?,?,?,?)";  
    
    try
    {
        pst = conecta.prepareStatement(sql);
        
        pst.setString(1,servico_camposervico.getText());
        pst.setString(2,servico_campodescricao.getText());
        pst.setString(3,servico_campovalor.getText());
        pst.setString(4,servico_campocomissao.getText());
        
        pst.execute();
        JOptionPane.showMessageDialog(null, "Servico cadastrado com sucesso","Cadastro de Servico",JOptionPane.INFORMATION_MESSAGE);
    }
    
    catch(SQLException error)
            {
               JOptionPane.showMessageDialog(null,error);
            }
}


    
public void edita_ordemservico()
{
  String sql = "Update servico set servico=?,descricao=?,valor=?,comissao=? where codigoservico=?"; 
  
  try
  {
      pst = conecta.prepareStatement(sql);

        pst.setString(1,servico_camposervico.getText());
        pst.setString(2,servico_campodescricao.getText());
        pst.setString(3,servico_campovalor.getText());
        pst.setString(4,servico_campocomissao.getText());
        pst.setInt(5,Integer.parseInt(servico_campocodigo.getText()));
        
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
        servico_textoservico = new javax.swing.JLabel();
        servico_camposervico = new javax.swing.JTextField();
        servico_textodescricao = new javax.swing.JLabel();
        servico_campodescricao = new javax.swing.JTextField();
        cadastro_clientefisico_textocadastro = new javax.swing.JLabel();
        cadastro_servico_textonumcad = new javax.swing.JLabel();
        cadastro_servico_textovalor = new javax.swing.JLabel();
        servico_campovalor = new javax.swing.JTextField();
        cadastro_clientefisico_separador = new javax.swing.JSeparator();
        cadastro_servico_botaocancelar = new javax.swing.JButton();
        cadastro_servico_botaosalvar = new javax.swing.JButton();
        cadastro_servico_botaonovo = new javax.swing.JButton();
        cadastro_servico_botaocadastrar = new javax.swing.JButton();
        servico_tabelacliente1 = new javax.swing.JScrollPane();
        servico_tabelacliente = new javax.swing.JTable();
        servico_campocodigo = new javax.swing.JTextField();
        cadastro_servico_textocomissao = new javax.swing.JLabel();
        servico_campocomissao = new javax.swing.JTextField();
        servico_textocliente = new javax.swing.JLabel();
        servico_campocliente = new javax.swing.JTextField();
        servico_textofuncionario = new javax.swing.JLabel();
        servico_campofuncionario = new javax.swing.JTextField();
        servico_campopesquisa = new javax.swing.JTextField();
        servico_tabelaordem1 = new javax.swing.JScrollPane();
        servico_tabelaordem = new javax.swing.JTable();
        servico_tabelafuncionario1 = new javax.swing.JScrollPane();
        servico_tabelafuncionario = new javax.swing.JTable();
        servico_tabelaservico1 = new javax.swing.JScrollPane();
        servico_tabelaservico = new javax.swing.JTable();
        cadastro_clientefisico_separador1 = new javax.swing.JSeparator();
        cadastro_clientefisico_separador3 = new javax.swing.JSeparator();
        servico_textofuncionario1 = new javax.swing.JLabel();

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

        servico_textoservico.setText("Pesq. servico");

        servico_camposervico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                servico_camposervicoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                servico_camposervicoKeyReleased(evt);
            }
        });

        servico_textodescricao.setText("Descricao");

        servico_campodescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                servico_campodescricaoActionPerformed(evt);
            }
        });
        servico_campodescricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                servico_campodescricaoKeyPressed(evt);
            }
        });

        cadastro_servico_textonumcad.setText("Servico Nº");

        cadastro_servico_textovalor.setText("Valor");

        servico_campovalor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                servico_campovalorKeyPressed(evt);
            }
        });

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

        servico_tabelacliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        servico_tabelacliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                servico_tabelaclienteMouseClicked(evt);
            }
        });
        servico_tabelacliente1.setViewportView(servico_tabelacliente);

        servico_campocodigo.setEnabled(false);

        cadastro_servico_textocomissao.setText("Comissao");

        servico_campocomissao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                servico_campocomissaoKeyPressed(evt);
            }
        });

        servico_textocliente.setText("Pesq. Cliente");

        servico_campocliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                servico_campoclienteKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                servico_campoclienteKeyReleased(evt);
            }
        });

        servico_textofuncionario.setText("Pesq. Funcionario");

        servico_campofuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                servico_campofuncionarioActionPerformed(evt);
            }
        });
        servico_campofuncionario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                servico_campofuncionarioKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                servico_campofuncionarioKeyReleased(evt);
            }
        });

        servico_campopesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                servico_campopesquisaKeyPressed(evt);
            }
        });

        servico_tabelaordem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        servico_tabelaordem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                servico_tabelaordemMouseClicked(evt);
            }
        });
        servico_tabelaordem1.setViewportView(servico_tabelaordem);

        servico_tabelafuncionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        servico_tabelafuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                servico_tabelafuncionarioMouseClicked(evt);
            }
        });
        servico_tabelafuncionario1.setViewportView(servico_tabelafuncionario);

        servico_tabelaservico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        servico_tabelaservico.setUpdateSelectionOnSort(false);
        servico_tabelaservico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                servico_tabelaservicoMouseClicked(evt);
            }
        });
        servico_tabelaservico1.setViewportView(servico_tabelaservico);

        servico_textofuncionario1.setText("Pesquisar OS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cadastro_clientefisico_separador, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(servico_tabelacliente1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(servico_tabelaordem1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(servico_tabelaservico1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cadastro_clientefisico_textocadastro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cadastro_servico_textonumcad)
                        .addGap(32, 32, 32)
                        .addComponent(servico_campocodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(servico_textoservico)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(servico_camposervico))
                    .addComponent(servico_tabelafuncionario1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cadastro_clientefisico_separador1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(servico_textodescricao)
                            .addComponent(cadastro_servico_textovalor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(servico_campovalor, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cadastro_servico_textocomissao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(servico_campocomissao, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(servico_campodescricao)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(servico_textocliente)
                        .addGap(26, 26, 26)
                        .addComponent(servico_campocliente, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cadastro_clientefisico_separador3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cadastro_servico_botaocadastrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cadastro_servico_botaosalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94)
                        .addComponent(cadastro_servico_botaonovo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(cadastro_servico_botaocancelar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(servico_textofuncionario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(servico_campofuncionario))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(servico_textofuncionario1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(servico_campopesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cadastro_servico_textonumcad)
                        .addComponent(servico_campocodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(servico_textoservico)
                        .addComponent(servico_camposervico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cadastro_clientefisico_textocadastro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(servico_tabelaservico1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(servico_campodescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(servico_textodescricao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cadastro_servico_textovalor)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(servico_campovalor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cadastro_servico_textocomissao)
                        .addComponent(servico_campocomissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cadastro_clientefisico_separador, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(servico_textocliente)
                    .addComponent(servico_campocliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(servico_tabelacliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cadastro_clientefisico_separador1, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(servico_textofuncionario)
                    .addComponent(servico_campofuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(servico_tabelafuncionario1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cadastro_clientefisico_separador3, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadastro_servico_botaocadastrar)
                    .addComponent(cadastro_servico_botaosalvar)
                    .addComponent(cadastro_servico_botaonovo)
                    .addComponent(cadastro_servico_botaocancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(servico_campopesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(servico_textofuncionario1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(servico_tabelaordem1, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                .addContainerGap())
        );

        setBounds(0, 0, 620, 559);
    }// </editor-fold>//GEN-END:initComponents

    private void cadastro_servico_botaocadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastro_servico_botaocadastrarActionPerformed
        // TODO add your handling code here:
        cadastro_ordemservico();
    }//GEN-LAST:event_cadastro_servico_botaocadastrarActionPerformed

    private void cadastro_servico_botaosalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastro_servico_botaosalvarActionPerformed
        edita_ordemservico();
    }//GEN-LAST:event_cadastro_servico_botaosalvarActionPerformed

    private void cadastro_servico_botaocancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastro_servico_botaocancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_cadastro_servico_botaocancelarActionPerformed

    private void servico_camposervicoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_servico_camposervicoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            this.dispose();
        }
    }//GEN-LAST:event_servico_camposervicoKeyPressed

    private void servico_campovalorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_servico_campovalorKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            this.dispose();
        }
    }//GEN-LAST:event_servico_campovalorKeyPressed

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
            edita_ordemservico();
        }

        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE){
            this.dispose();}
    }//GEN-LAST:event_cadastro_servico_botaosalvarKeyPressed

    private void servico_tabelaclienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_servico_tabelaclienteMouseClicked
        // TODO add your handling code here:
       mostra_servicocliente();
    }//GEN-LAST:event_servico_tabelaclienteMouseClicked

    private void cadastro_servico_botaonovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastro_servico_botaonovoActionPerformed
        // TODO add your handling code here:
        novo_ordemservico();
    }//GEN-LAST:event_cadastro_servico_botaonovoActionPerformed

    private void cadastro_servico_botaocadastrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cadastro_servico_botaocadastrarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            cadastro_ordemservico();
        }

        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE){
            this.dispose();}
    }//GEN-LAST:event_cadastro_servico_botaocadastrarKeyPressed

    private void servico_campocomissaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_servico_campocomissaoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_servico_campocomissaoKeyPressed

    private void servico_campodescricaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_servico_campodescricaoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            this.dispose();
        }
    }//GEN-LAST:event_servico_campodescricaoKeyPressed

    private void servico_campodescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_servico_campodescricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_servico_campodescricaoActionPerformed

    private void servico_campoclienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_servico_campoclienteKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_servico_campoclienteKeyPressed

    private void servico_campofuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_servico_campofuncionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_servico_campofuncionarioActionPerformed

    private void servico_campofuncionarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_servico_campofuncionarioKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_servico_campofuncionarioKeyPressed

    private void servico_campopesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_servico_campopesquisaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_servico_campopesquisaKeyPressed

    private void servico_tabelaordemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_servico_tabelaordemMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_servico_tabelaordemMouseClicked

    private void servico_tabelafuncionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_servico_tabelafuncionarioMouseClicked
        // TODO add your handling code here:
        mostra_servicofuncionario();
    }//GEN-LAST:event_servico_tabelafuncionarioMouseClicked

    private void servico_tabelaservicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_servico_tabelaservicoMouseClicked
        // TODO add your handling code here:
        mostra_servico();
    }//GEN-LAST:event_servico_tabelaservicoMouseClicked

    private void servico_camposervicoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_servico_camposervicoKeyReleased
        // TODO add your handling code here:
         pesquisa_servico();
    }//GEN-LAST:event_servico_camposervicoKeyReleased

    private void servico_campoclienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_servico_campoclienteKeyReleased
        // TODO add your handling code here:
        pesquisa_servicocliente();
    }//GEN-LAST:event_servico_campoclienteKeyReleased

    private void servico_campofuncionarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_servico_campofuncionarioKeyReleased
        // TODO add your handling code here:
         pesquisa_servicofuncionario();
    }//GEN-LAST:event_servico_campofuncionarioKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator cadastro_clientefisico_separador;
    private javax.swing.JSeparator cadastro_clientefisico_separador1;
    private javax.swing.JSeparator cadastro_clientefisico_separador3;
    private javax.swing.JLabel cadastro_clientefisico_textocadastro;
    private javax.swing.JButton cadastro_servico_botaocadastrar;
    private javax.swing.JButton cadastro_servico_botaocancelar;
    private javax.swing.JButton cadastro_servico_botaonovo;
    private javax.swing.JButton cadastro_servico_botaosalvar;
    private javax.swing.JLabel cadastro_servico_textocomissao;
    private javax.swing.JLabel cadastro_servico_textonumcad;
    private javax.swing.JLabel cadastro_servico_textovalor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField servico_campocliente;
    private javax.swing.JTextField servico_campocodigo;
    private javax.swing.JTextField servico_campocomissao;
    private javax.swing.JTextField servico_campodescricao;
    private javax.swing.JTextField servico_campofuncionario;
    private javax.swing.JTextField servico_campopesquisa;
    private javax.swing.JTextField servico_camposervico;
    private javax.swing.JTextField servico_campovalor;
    private javax.swing.JTable servico_tabelacliente;
    private javax.swing.JScrollPane servico_tabelacliente1;
    private javax.swing.JTable servico_tabelafuncionario;
    private javax.swing.JScrollPane servico_tabelafuncionario1;
    private javax.swing.JTable servico_tabelaordem;
    private javax.swing.JScrollPane servico_tabelaordem1;
    private javax.swing.JTable servico_tabelaservico;
    private javax.swing.JScrollPane servico_tabelaservico1;
    private javax.swing.JLabel servico_textocliente;
    private javax.swing.JLabel servico_textodescricao;
    private javax.swing.JLabel servico_textofuncionario;
    private javax.swing.JLabel servico_textofuncionario1;
    private javax.swing.JLabel servico_textoservico;
    // End of variables declaration//GEN-END:variables

    private void setLocationRelativeTo(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
