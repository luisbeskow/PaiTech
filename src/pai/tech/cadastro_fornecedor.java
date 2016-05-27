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
public class cadastro_fornecedor extends javax.swing.JInternalFrame 
{
    Connection conecta;
    PreparedStatement pst;
    ResultSet res;     
            
            
    public cadastro_fornecedor() throws ClassNotFoundException {
        initComponents();
        conecta = conectabanco.conectabanco();
        lista_fornecedor();
        this.dispose();
    }

    
    
    public void lista_fornecedor()
    {
        String sql = "Select * from fornecedor";
        
        try
        {
            pst = conecta.prepareStatement(sql);
            res = pst.executeQuery();
            cadastro_fornecedor_tabelaconsulta2.setModel(DbUtils.resultSetToTableModel(res));            
        }
        
        catch(SQLException error)
        {
          JOptionPane.showMessageDialog(null,error);      
        } 
    }
    
    
    
    public void novo_fornecedor()
    {
        cadastro_fornecedor_campocodigo.setText("") ;
        cadastro_fornecedor_campocnpj.setText("") ;
        cadastro_fornecedor_campoie.setText("") ;
        cadastro_fornecedor_camporazao.setText("") ;
        cadastro_fornecedor_campologradouro.setText("") ;
        cadastro_fornecedor_camponumero.setText(""); 
        cadastro_fornecedor_campocep.setText("");
        cadastro_fornecedor_campobairro.setText(""); 
        cadastro_fornecedor_campocidade.setText(""); 
        cadastro_fornecedor_campouf.setText(""); 
        cadastro_fornecedor_campoemail.setText("");
        cadastro_fornecedor_campotelefone.setText("");
        cadastro_fornecedor_campocelular.setText("");     
    }        
 
    
    
public void  cadastro_fornecedor()       
{
    
    String sql = "Insert into fornecedor(cnpj,ie,razao,logradouro,numero,cep,bairro,cidade,uf,email,telefone,celular) values (?,?,?,?,?,?,?,?,?,?,?,?)";  
    
    try
    {
        pst = conecta.prepareStatement(sql);
        
        pst.setString(1,cadastro_fornecedor_campocnpj.getText());
        pst.setString(2,cadastro_fornecedor_campoie.getText());
        pst.setString(3,cadastro_fornecedor_camporazao.getText());
        pst.setString(4,cadastro_fornecedor_campologradouro.getText());
        pst.setString(5,cadastro_fornecedor_camponumero.getText());
        pst.setString(6,cadastro_fornecedor_campocep.getText());
        pst.setString(7,cadastro_fornecedor_campobairro.getText());
        pst.setString(8,cadastro_fornecedor_campocidade.getText());
        pst.setString(9,cadastro_fornecedor_campouf.getText());
        pst.setString(10,cadastro_fornecedor_campoemail.getText());
        pst.setString(11,cadastro_fornecedor_campotelefone.getText());
        pst.setString(12,cadastro_fornecedor_campocelular.getText());
        
        pst.execute();
        JOptionPane.showMessageDialog(null, "Fornecedor cadastro com sucesso","Cadastro de fornecedor",JOptionPane.INFORMATION_MESSAGE);
    }
    
    catch(SQLException error)
            {
               JOptionPane.showMessageDialog(null,error);
            }
}



public void pesquisa_fornecedor()
{
    String sql = "Select *from fornecedor where razao like ?";
    
    try
    {
        pst = conecta.prepareStatement(sql);
        pst.setString(1,cadastro_fornecedor_campoconsultar.getText()+"%");
        res = pst.executeQuery();
        cadastro_fornecedor_tabelaconsulta2.setModel(DbUtils.resultSetToTableModel(res)); 
    }
    
    catch (SQLException error)
    {
                
        JOptionPane.showMessageDialog(null,error);                   
    }
 
}



public void mostra_fornecedor()     
{
int seleciona =  cadastro_fornecedor_tabelaconsulta2.getSelectedRow();
cadastro_fornecedor_campocodigo.setText((String) cadastro_fornecedor_tabelaconsulta2.getModel().getValueAt(seleciona, 0).toString()); 
cadastro_fornecedor_campocnpj.setText((String) cadastro_fornecedor_tabelaconsulta2.getModel().getValueAt(seleciona, 1).toString());
cadastro_fornecedor_campoie.setText((String) cadastro_fornecedor_tabelaconsulta2.getModel().getValueAt(seleciona, 2).toString());
cadastro_fornecedor_camporazao.setText((String) cadastro_fornecedor_tabelaconsulta2.getModel().getValueAt(seleciona, 3).toString());
cadastro_fornecedor_campologradouro.setText((String) cadastro_fornecedor_tabelaconsulta2.getModel().getValueAt(seleciona, 4).toString());
cadastro_fornecedor_camponumero.setText((String) cadastro_fornecedor_tabelaconsulta2.getModel().getValueAt(seleciona, 5).toString());
cadastro_fornecedor_campocep.setText((String) cadastro_fornecedor_tabelaconsulta2.getModel().getValueAt(seleciona, 6).toString());
cadastro_fornecedor_campobairro.setText((String) cadastro_fornecedor_tabelaconsulta2.getModel().getValueAt(seleciona, 7).toString());
cadastro_fornecedor_campocidade.setText((String) cadastro_fornecedor_tabelaconsulta2.getModel().getValueAt(seleciona, 8).toString());
cadastro_fornecedor_campouf.setText((String) cadastro_fornecedor_tabelaconsulta2.getModel().getValueAt(seleciona, 9).toString());
cadastro_fornecedor_campoemail.setText((String) cadastro_fornecedor_tabelaconsulta2.getModel().getValueAt(seleciona, 10).toString());
cadastro_fornecedor_campotelefone.setText((String) cadastro_fornecedor_tabelaconsulta2.getModel().getValueAt(seleciona, 11).toString());
cadastro_fornecedor_campocelular.setText((String) cadastro_fornecedor_tabelaconsulta2.getModel().getValueAt(seleciona, 12).toString());

}  



public void edita_fornecedor()
{
  String sql = "Update fornecedor set cnpj=?,ie=?,razao=?,logradouro=?,numero=?,cep=?,bairro=?,cidade=?,uf=?,email=?,telefone=?,celular=? where codigofornecedor=?"; 
  
  try
  {
      pst = conecta.prepareStatement(sql);
        pst.setString(1,cadastro_fornecedor_campocnpj.getText());
        pst.setString(2,cadastro_fornecedor_campoie.getText());
        pst.setString(3,cadastro_fornecedor_camporazao.getText());
        pst.setString(4,cadastro_fornecedor_campologradouro.getText());
        pst.setString(5,cadastro_fornecedor_camponumero.getText());
        pst.setString(6,cadastro_fornecedor_campocep.getText());
        pst.setString(7,cadastro_fornecedor_campobairro.getText());
        pst.setString(8,cadastro_fornecedor_campocidade.getText());
        pst.setString(9,cadastro_fornecedor_campouf.getText());
        pst.setString(10,cadastro_fornecedor_campoemail.getText());
        pst.setString(11,cadastro_fornecedor_campotelefone.getText());
        pst.setString(12,cadastro_fornecedor_campocelular.getText());
        pst.setInt(13,Integer.parseInt(cadastro_fornecedor_campocodigo.getText()));
        
      pst.executeUpdate();
      JOptionPane.showMessageDialog(null,"Cadastro atualizado com sucesso");
      lista_fornecedor();
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
        cadastro_clientejuridico_textonome = new javax.swing.JLabel();
        cadastro_fornecedor_camporazao = new javax.swing.JTextField();
        cadastro_clientejuridico_textologradouro = new javax.swing.JLabel();
        cadastro_fornecedor_campologradouro = new javax.swing.JTextField();
        cadastro_clientejuridico_textonumero = new javax.swing.JLabel();
        cadastro_clientejuridico_textocadastro = new javax.swing.JLabel();
        cadastro_clientejuridico_textonumcad = new javax.swing.JLabel();
        cadastro_clientejuridico_textobairro = new javax.swing.JLabel();
        cadastro_fornecedor_campobairro = new javax.swing.JTextField();
        cadastro_clientejuridico_textocep = new javax.swing.JLabel();
        cadastro_clientejuridico_textoemail1 = new javax.swing.JLabel();
        cadastro_fornecedor_campoemail = new javax.swing.JTextField();
        cadastro_clientejuridico_textotelefone = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        cadastro_fornecedor_botaocancelar = new javax.swing.JButton();
        cadastro_fornecedor_botaosalvar = new javax.swing.JButton();
        cadastro_fornecedor_botaonovo = new javax.swing.JButton();
        cadastro_fornecedor_botaocadastrar = new javax.swing.JButton();
        cadastro_fornecedor_campoconsultar = new javax.swing.JTextField();
        cadastro_clientejuridico_tabelaconsulta = new javax.swing.JScrollPane();
        cadastro_fornecedor_tabelaconsulta2 = new javax.swing.JTable();
        cadastro_fornecedor_campocnpj = new javax.swing.JFormattedTextField();
        cadastro_fornecedor_campocep = new javax.swing.JFormattedTextField();
        cadastro_fornecedor_campotelefone = new javax.swing.JFormattedTextField();
        cadastro_fornecedor_campocodigo = new javax.swing.JTextField();
        cadastro_clientejuridico_textocnpj = new javax.swing.JLabel();
        cadastro_clientejuridico_textoie = new javax.swing.JLabel();
        cadastro_fornecedor_campoie = new javax.swing.JFormattedTextField();
        cadastro_fornecedor_camponumero = new javax.swing.JFormattedTextField();
        cadastro_clientejuridico_textocidade = new javax.swing.JLabel();
        cadastro_fornecedor_campocidade = new javax.swing.JTextField();
        cadastro_clientejuridico_textouf = new javax.swing.JLabel();
        cadastro_fornecedor_campouf = new javax.swing.JTextField();
        cadastro_clientejuridico_textocelular = new javax.swing.JLabel();
        cadastro_fornecedor_campocelular = new javax.swing.JFormattedTextField();

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
        setTitle("Cadastro de fornecedor");
        setToolTipText("");
        setMaximumSize(new java.awt.Dimension(574, 430));
        setMinimumSize(new java.awt.Dimension(574, 430));
        setName("cadastro_cliente"); // NOI18N
        setNormalBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setPreferredSize(new java.awt.Dimension(574, 430));
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        setVisible(true);

        cadastro_clientejuridico_textonome.setText("Razão social");

        cadastro_fornecedor_camporazao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cadastro_fornecedor_camporazaoKeyPressed(evt);
            }
        });

        cadastro_clientejuridico_textologradouro.setText("Logradouro");

        cadastro_fornecedor_campologradouro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cadastro_fornecedor_campologradouroKeyPressed(evt);
            }
        });

        cadastro_clientejuridico_textonumero.setText("Numero");

        cadastro_clientejuridico_textonumcad.setText("Cadastro Nº");

        cadastro_clientejuridico_textobairro.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        cadastro_clientejuridico_textobairro.setText("Bairro");

        cadastro_fornecedor_campobairro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cadastro_fornecedor_campobairroKeyPressed(evt);
            }
        });

        cadastro_clientejuridico_textocep.setText("CEP");

        cadastro_clientejuridico_textoemail1.setText("E-mail");

        cadastro_fornecedor_campoemail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cadastro_fornecedor_campoemailKeyPressed(evt);
            }
        });

        cadastro_clientejuridico_textotelefone.setText("Telefone");

        cadastro_fornecedor_botaocancelar.setText("Cancelar");
        cadastro_fornecedor_botaocancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastro_fornecedor_botaocancelarActionPerformed(evt);
            }
        });
        cadastro_fornecedor_botaocancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cadastro_fornecedor_botaocancelarKeyPressed(evt);
            }
        });

        cadastro_fornecedor_botaosalvar.setText("Salvar");
        cadastro_fornecedor_botaosalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastro_fornecedor_botaosalvarActionPerformed(evt);
            }
        });
        cadastro_fornecedor_botaosalvar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cadastro_fornecedor_botaosalvarKeyPressed(evt);
            }
        });

        cadastro_fornecedor_botaonovo.setText("Novo");
        cadastro_fornecedor_botaonovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastro_fornecedor_botaonovoActionPerformed(evt);
            }
        });

        cadastro_fornecedor_botaocadastrar.setText("Cadastrar");
        cadastro_fornecedor_botaocadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastro_fornecedor_botaocadastrarActionPerformed(evt);
            }
        });
        cadastro_fornecedor_botaocadastrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cadastro_fornecedor_botaocadastrarKeyPressed(evt);
            }
        });

        cadastro_fornecedor_campoconsultar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cadastro_fornecedor_campoconsultarKeyReleased(evt);
            }
        });

        cadastro_fornecedor_tabelaconsulta2.setModel(new javax.swing.table.DefaultTableModel(
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
        cadastro_fornecedor_tabelaconsulta2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cadastro_fornecedor_tabelaconsulta2MouseClicked(evt);
            }
        });
        cadastro_clientejuridico_tabelaconsulta.setViewportView(cadastro_fornecedor_tabelaconsulta2);

        try {
            cadastro_fornecedor_campocnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cadastro_fornecedor_campocnpj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastro_fornecedor_campocnpjActionPerformed(evt);
            }
        });
        cadastro_fornecedor_campocnpj.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cadastro_fornecedor_campocnpjKeyPressed(evt);
            }
        });

        try {
            cadastro_fornecedor_campocep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cadastro_fornecedor_campocep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cadastro_fornecedor_campocepKeyPressed(evt);
            }
        });

        try {
            cadastro_fornecedor_campotelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cadastro_fornecedor_campotelefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cadastro_fornecedor_campotelefoneKeyPressed(evt);
            }
        });

        cadastro_fornecedor_campocodigo.setEnabled(false);

        cadastro_clientejuridico_textocnpj.setText("CNPJ");

        cadastro_clientejuridico_textoie.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        cadastro_clientejuridico_textoie.setText("IE");

        try {
            cadastro_fornecedor_campoie.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###.###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cadastro_fornecedor_campoie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cadastro_fornecedor_campoieKeyPressed(evt);
            }
        });

        cadastro_fornecedor_camponumero.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        cadastro_fornecedor_camponumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cadastro_fornecedor_camponumeroKeyPressed(evt);
            }
        });

        cadastro_clientejuridico_textocidade.setText("Cidade");

        cadastro_fornecedor_campocidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastro_fornecedor_campocidadeActionPerformed(evt);
            }
        });

        cadastro_clientejuridico_textouf.setText("UF");

        cadastro_clientejuridico_textocelular.setText("Celular");

        try {
            cadastro_fornecedor_campocelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cadastro_fornecedor_campocelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastro_fornecedor_campocelularActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cadastro_clientejuridico_tabelaconsulta)
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(cadastro_fornecedor_botaonovo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cadastro_fornecedor_campoconsultar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cadastro_clientejuridico_textonome)
                                .addComponent(cadastro_clientejuridico_textologradouro)
                                .addComponent(cadastro_clientejuridico_textocadastro)
                                .addComponent(cadastro_clientejuridico_textonumcad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(cadastro_clientejuridico_textobairro)
                            .addComponent(cadastro_clientejuridico_textoemail1))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cadastro_fornecedor_camporazao)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(cadastro_fornecedor_campobairro, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cadastro_clientejuridico_textocidade)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cadastro_fornecedor_campocidade, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cadastro_clientejuridico_textouf)
                                    .addGap(16, 16, 16)
                                    .addComponent(cadastro_fornecedor_campouf))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(cadastro_fornecedor_campologradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cadastro_clientejuridico_textonumero)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cadastro_fornecedor_camponumero, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cadastro_clientejuridico_textocep)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cadastro_fornecedor_campocep))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(cadastro_fornecedor_campocodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cadastro_clientejuridico_textocnpj)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cadastro_fornecedor_campocnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cadastro_clientejuridico_textoie)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cadastro_fornecedor_campoie))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(179, 179, 179)
                                    .addComponent(cadastro_fornecedor_botaosalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(cadastro_fornecedor_campoemail, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(10, 10, 10)
                                    .addComponent(cadastro_clientejuridico_textotelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cadastro_fornecedor_campotelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cadastro_clientejuridico_textocelular)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cadastro_fornecedor_campocelular, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cadastro_fornecedor_botaocadastrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cadastro_fornecedor_botaocancelar)
                        .addGap(1, 1, 1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cadastro_fornecedor_campocodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cadastro_clientejuridico_textocnpj)
                        .addComponent(cadastro_fornecedor_campocnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cadastro_clientejuridico_textoie)
                        .addComponent(cadastro_fornecedor_campoie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cadastro_clientejuridico_textocadastro)
                        .addComponent(cadastro_clientejuridico_textonumcad)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadastro_fornecedor_camporazao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cadastro_clientejuridico_textonome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadastro_clientejuridico_textologradouro)
                    .addComponent(cadastro_fornecedor_campologradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cadastro_clientejuridico_textonumero)
                    .addComponent(cadastro_fornecedor_camponumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cadastro_clientejuridico_textocep)
                    .addComponent(cadastro_fornecedor_campocep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadastro_fornecedor_campobairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cadastro_clientejuridico_textobairro)
                    .addComponent(cadastro_clientejuridico_textocidade)
                    .addComponent(cadastro_fornecedor_campocidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cadastro_clientejuridico_textouf)
                    .addComponent(cadastro_fornecedor_campouf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadastro_fornecedor_campoemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cadastro_clientejuridico_textoemail1)
                    .addComponent(cadastro_clientejuridico_textotelefone)
                    .addComponent(cadastro_fornecedor_campotelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cadastro_clientejuridico_textocelular)
                    .addComponent(cadastro_fornecedor_campocelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadastro_fornecedor_botaosalvar)
                    .addComponent(cadastro_fornecedor_botaocancelar)
                    .addComponent(cadastro_fornecedor_botaocadastrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadastro_fornecedor_campoconsultar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cadastro_fornecedor_botaonovo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cadastro_clientejuridico_tabelaconsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setBounds(574, 0, 574, 430);
    }// </editor-fold>//GEN-END:initComponents

    private void cadastro_fornecedor_botaocadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastro_fornecedor_botaocadastrarActionPerformed
        // TODO add your handling code here:
        cadastro_fornecedor();
    }//GEN-LAST:event_cadastro_fornecedor_botaocadastrarActionPerformed

    private void cadastro_fornecedor_botaosalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastro_fornecedor_botaosalvarActionPerformed
        edita_fornecedor();
    }//GEN-LAST:event_cadastro_fornecedor_botaosalvarActionPerformed

    private void cadastro_fornecedor_campocnpjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastro_fornecedor_campocnpjActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cadastro_fornecedor_campocnpjActionPerformed

    private void cadastro_fornecedor_botaocancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastro_fornecedor_botaocancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_cadastro_fornecedor_botaocancelarActionPerformed

    private void cadastro_fornecedor_campocnpjKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cadastro_fornecedor_campocnpjKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE){
            this.dispose();
        }
    }//GEN-LAST:event_cadastro_fornecedor_campocnpjKeyPressed

    private void cadastro_fornecedor_campoieKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cadastro_fornecedor_campoieKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            this.dispose();
        }
    }//GEN-LAST:event_cadastro_fornecedor_campoieKeyPressed

    private void cadastro_fornecedor_camporazaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cadastro_fornecedor_camporazaoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            this.dispose();
        }
    }//GEN-LAST:event_cadastro_fornecedor_camporazaoKeyPressed

    private void cadastro_fornecedor_campologradouroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cadastro_fornecedor_campologradouroKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            this.dispose();
        }
    }//GEN-LAST:event_cadastro_fornecedor_campologradouroKeyPressed

    private void cadastro_fornecedor_camponumeroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cadastro_fornecedor_camponumeroKeyPressed
       if (evt.getKeyCode() == KeyEvent.VK_ESCAPE)
       {
            this.dispose();
       }
    }//GEN-LAST:event_cadastro_fornecedor_camponumeroKeyPressed

    private void cadastro_fornecedor_campobairroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cadastro_fornecedor_campobairroKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            this.dispose();
        }
    }//GEN-LAST:event_cadastro_fornecedor_campobairroKeyPressed

    private void cadastro_fornecedor_campocepKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cadastro_fornecedor_campocepKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            this.dispose();
        }
    }//GEN-LAST:event_cadastro_fornecedor_campocepKeyPressed

    private void cadastro_fornecedor_campoemailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cadastro_fornecedor_campoemailKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            this.dispose();
        }
    }//GEN-LAST:event_cadastro_fornecedor_campoemailKeyPressed

    private void cadastro_fornecedor_campotelefoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cadastro_fornecedor_campotelefoneKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            this.dispose();
        }
    }//GEN-LAST:event_cadastro_fornecedor_campotelefoneKeyPressed

    private void cadastro_fornecedor_botaocancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cadastro_fornecedor_botaocancelarKeyPressed
        // TODO add your handling code here:
        
          if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            this.dispose();
        }

        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE){
            this.dispose();}
    }//GEN-LAST:event_cadastro_fornecedor_botaocancelarKeyPressed

    private void cadastro_fornecedor_botaosalvarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cadastro_fornecedor_botaosalvarKeyPressed
        // TODO add your handling code here:
        
          if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            edita_fornecedor();
        }

        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE){
            this.dispose();}
    }//GEN-LAST:event_cadastro_fornecedor_botaosalvarKeyPressed

    private void cadastro_fornecedor_campoconsultarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cadastro_fornecedor_campoconsultarKeyReleased
        // TODO add your handling code here:
        pesquisa_fornecedor();
    }//GEN-LAST:event_cadastro_fornecedor_campoconsultarKeyReleased

    private void cadastro_fornecedor_tabelaconsulta2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cadastro_fornecedor_tabelaconsulta2MouseClicked
        // TODO add your handling code here:
        mostra_fornecedor();
    }//GEN-LAST:event_cadastro_fornecedor_tabelaconsulta2MouseClicked

    private void cadastro_fornecedor_botaonovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastro_fornecedor_botaonovoActionPerformed
        // TODO add your handling code here:
        novo_fornecedor();
    }//GEN-LAST:event_cadastro_fornecedor_botaonovoActionPerformed

    private void cadastro_fornecedor_botaocadastrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cadastro_fornecedor_botaocadastrarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            cadastro_fornecedor();
        }

        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE){
            this.dispose();}
    }//GEN-LAST:event_cadastro_fornecedor_botaocadastrarKeyPressed

    private void cadastro_fornecedor_campocidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastro_fornecedor_campocidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cadastro_fornecedor_campocidadeActionPerformed

    private void cadastro_fornecedor_campocelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastro_fornecedor_campocelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cadastro_fornecedor_campocelularActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane cadastro_clientejuridico_tabelaconsulta;
    private javax.swing.JLabel cadastro_clientejuridico_textobairro;
    private javax.swing.JLabel cadastro_clientejuridico_textocadastro;
    private javax.swing.JLabel cadastro_clientejuridico_textocelular;
    private javax.swing.JLabel cadastro_clientejuridico_textocep;
    private javax.swing.JLabel cadastro_clientejuridico_textocidade;
    private javax.swing.JLabel cadastro_clientejuridico_textocnpj;
    private javax.swing.JLabel cadastro_clientejuridico_textoemail1;
    private javax.swing.JLabel cadastro_clientejuridico_textoie;
    private javax.swing.JLabel cadastro_clientejuridico_textologradouro;
    private javax.swing.JLabel cadastro_clientejuridico_textonome;
    private javax.swing.JLabel cadastro_clientejuridico_textonumcad;
    private javax.swing.JLabel cadastro_clientejuridico_textonumero;
    private javax.swing.JLabel cadastro_clientejuridico_textotelefone;
    private javax.swing.JLabel cadastro_clientejuridico_textouf;
    private javax.swing.JButton cadastro_fornecedor_botaocadastrar;
    private javax.swing.JButton cadastro_fornecedor_botaocancelar;
    private javax.swing.JButton cadastro_fornecedor_botaonovo;
    private javax.swing.JButton cadastro_fornecedor_botaosalvar;
    private javax.swing.JTextField cadastro_fornecedor_campobairro;
    private javax.swing.JFormattedTextField cadastro_fornecedor_campocelular;
    private javax.swing.JFormattedTextField cadastro_fornecedor_campocep;
    private javax.swing.JTextField cadastro_fornecedor_campocidade;
    private javax.swing.JFormattedTextField cadastro_fornecedor_campocnpj;
    private javax.swing.JTextField cadastro_fornecedor_campocodigo;
    private javax.swing.JTextField cadastro_fornecedor_campoconsultar;
    private javax.swing.JTextField cadastro_fornecedor_campoemail;
    private javax.swing.JFormattedTextField cadastro_fornecedor_campoie;
    private javax.swing.JTextField cadastro_fornecedor_campologradouro;
    private javax.swing.JFormattedTextField cadastro_fornecedor_camponumero;
    private javax.swing.JTextField cadastro_fornecedor_camporazao;
    private javax.swing.JFormattedTextField cadastro_fornecedor_campotelefone;
    private javax.swing.JTextField cadastro_fornecedor_campouf;
    private javax.swing.JTable cadastro_fornecedor_tabelaconsulta2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

    private void setLocationRelativeTo(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
