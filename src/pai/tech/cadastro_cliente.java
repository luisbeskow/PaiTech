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
public class cadastro_cliente extends javax.swing.JInternalFrame 
{
    Connection conecta;
    PreparedStatement pst;
    ResultSet res;     
            
            
    public cadastro_cliente() throws ClassNotFoundException {
        initComponents();
        conecta = conectabanco.conectabanco();
        lista_cliente();
        this.dispose();
    }

    
    
    public void lista_cliente()
    {
        String sql = "Select * from cliente";
        
        try
        {
            pst = conecta.prepareStatement(sql);
            res = pst.executeQuery();
            cadastro_clientejuridico_tabelaconsulta2.setModel(DbUtils.resultSetToTableModel(res));            
        }
        
        catch(SQLException error)
        {
          JOptionPane.showMessageDialog(null,error);      
        } 
    }
    
    
    
    public void novo_cliente()
    {
        cadastro_cliente_campocodigo.setText("") ;
        cadastro_cliente_campodocumento.setText("") ;
        cadastro_cliente_campodocauxiliar.setText("") ;
        cadastro_cliente_camporazao.setText("") ;
        cadastro_cliente_campologradouro.setText("") ;
        cadastro_cliente_camponumero.setText(""); 
        cadastro_cliente_campocep.setText("");
        cadastro_cliente_campobairro.setText(""); 
        cadastro_cliente_campocidade.setText(""); 
        cadastro_cliente_campouf.setText(""); 
        cadastro_cliente_campoemail.setText("");
        cadastro_cliente_campotelefone.setText("");
        cadastro_cliente_campocelular.setText("");     
    }        
 
    
    
public void  cadastro_cliente()       
{
    
    String sql = "Insert into cliente(documento,doc_auxiliar,nome,logradouro,numero,cep,bairro,cidade,uf,email,telefone,celular) values (?,?,?,?,?,?,?,?,?,?,?,?)";  
    
    try
    {
        pst = conecta.prepareStatement(sql);
        
        pst.setString(1,cadastro_cliente_campodocumento.getText());
        pst.setString(2,cadastro_cliente_campodocauxiliar.getText());
        pst.setString(3,cadastro_cliente_camporazao.getText());
        pst.setString(4,cadastro_cliente_campologradouro.getText());
        pst.setString(5,cadastro_cliente_camponumero.getText());
        pst.setString(6,cadastro_cliente_campocep.getText());
        pst.setString(7,cadastro_cliente_campobairro.getText());
        pst.setString(8,cadastro_cliente_campocidade.getText());
        pst.setString(9,cadastro_cliente_campouf.getText());
        pst.setString(10,cadastro_cliente_campoemail.getText());
        pst.setString(11,cadastro_cliente_campotelefone.getText());
        pst.setString(12,cadastro_cliente_campocelular.getText());
        
        pst.execute();
        JOptionPane.showMessageDialog(null, "Cliente cadastro com sucesso","Cadastro de clientes pessoa juridica",JOptionPane.INFORMATION_MESSAGE);
    }
    
    catch(SQLException error)
            {
               JOptionPane.showMessageDialog(null,error);
            }
}



public void pesquisa_cliente()
{
    String sql = "Select *from cliente where nome like ?";
    
    try
    {
        pst = conecta.prepareStatement(sql);
        pst.setString(1,cadastro_cliente_campoconsultar.getText()+"%");
        res = pst.executeQuery();
        cadastro_clientejuridico_tabelaconsulta2.setModel(DbUtils.resultSetToTableModel(res)); 
    }
    
    catch (SQLException error)
    {
                
        JOptionPane.showMessageDialog(null,error);                   
    }
 
}



public void mostra_clientejuridico()     
{
int seleciona =  cadastro_clientejuridico_tabelaconsulta2.getSelectedRow();
cadastro_cliente_campocodigo.setText((String) cadastro_clientejuridico_tabelaconsulta2.getModel().getValueAt(seleciona, 0).toString()); 
cadastro_cliente_campodocumento.setText((String) cadastro_clientejuridico_tabelaconsulta2.getModel().getValueAt(seleciona, 1).toString());
cadastro_cliente_campodocauxiliar.setText((String) cadastro_clientejuridico_tabelaconsulta2.getModel().getValueAt(seleciona, 2).toString());
cadastro_cliente_camporazao.setText((String) cadastro_clientejuridico_tabelaconsulta2.getModel().getValueAt(seleciona, 3).toString());
cadastro_cliente_campologradouro.setText((String) cadastro_clientejuridico_tabelaconsulta2.getModel().getValueAt(seleciona, 4).toString());
cadastro_cliente_camponumero.setText((String) cadastro_clientejuridico_tabelaconsulta2.getModel().getValueAt(seleciona, 5).toString());
cadastro_cliente_campocep.setText((String) cadastro_clientejuridico_tabelaconsulta2.getModel().getValueAt(seleciona, 6).toString());
cadastro_cliente_campobairro.setText((String) cadastro_clientejuridico_tabelaconsulta2.getModel().getValueAt(seleciona, 7).toString());
cadastro_cliente_campocidade.setText((String) cadastro_clientejuridico_tabelaconsulta2.getModel().getValueAt(seleciona, 8).toString());
cadastro_cliente_campouf.setText((String) cadastro_clientejuridico_tabelaconsulta2.getModel().getValueAt(seleciona, 9).toString());
cadastro_cliente_campoemail.setText((String) cadastro_clientejuridico_tabelaconsulta2.getModel().getValueAt(seleciona, 10).toString());
cadastro_cliente_campotelefone.setText((String) cadastro_clientejuridico_tabelaconsulta2.getModel().getValueAt(seleciona, 11).toString());
cadastro_cliente_campocelular.setText((String) cadastro_clientejuridico_tabelaconsulta2.getModel().getValueAt(seleciona, 12).toString());

}  



public void edita_clientejuridico()
{
  String sql = "Update cliente set documento=?,doc_auxiliar=?,nome=?,logradouro=?,numero=?,cep=?,bairro=?,cidade=?,uf=?,email=?,telefone=?,celular=? where codigocliente=?"; 
  
  try
  {
      pst = conecta.prepareStatement(sql);
        pst.setString(1,cadastro_cliente_campodocumento.getText());
        pst.setString(2,cadastro_cliente_campodocauxiliar.getText());
        pst.setString(3,cadastro_cliente_camporazao.getText());
        pst.setString(4,cadastro_cliente_campologradouro.getText());
        pst.setString(5,cadastro_cliente_camponumero.getText());
        pst.setString(6,cadastro_cliente_campocep.getText());
        pst.setString(7,cadastro_cliente_campobairro.getText());
        pst.setString(8,cadastro_cliente_campocidade.getText());
        pst.setString(9,cadastro_cliente_campouf.getText());
        pst.setString(10,cadastro_cliente_campoemail.getText());
        pst.setString(11,cadastro_cliente_campotelefone.getText());
        pst.setString(12,cadastro_cliente_campocelular.getText());
        pst.setInt(13,Integer.parseInt(cadastro_cliente_campocodigo.getText()));
        
      pst.executeUpdate();
      JOptionPane.showMessageDialog(null,"Cadastro atualizado com sucesso");
      lista_cliente();
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
        cadastro_cliente_textonome = new javax.swing.JLabel();
        cadastro_cliente_camporazao = new javax.swing.JTextField();
        cadastro_cliente_textologradouro = new javax.swing.JLabel();
        cadastro_cliente_campologradouro = new javax.swing.JTextField();
        cadastro_cliente_textonumero = new javax.swing.JLabel();
        cadastro_cliente_textocadastro = new javax.swing.JLabel();
        cadastro_cliente_textonumcad = new javax.swing.JLabel();
        cadastro_cliente_textobairro = new javax.swing.JLabel();
        cadastro_cliente_campobairro = new javax.swing.JTextField();
        cadastro_cliente_textocep = new javax.swing.JLabel();
        cadastro_cliente_textoemail = new javax.swing.JLabel();
        cadastro_cliente_campoemail = new javax.swing.JTextField();
        cadastro_cliente_textotelefone = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        cadastro_cliente_botaocancelar = new javax.swing.JButton();
        cadastro_cliente_botaosalvar = new javax.swing.JButton();
        cadastro_cliente_botaonovo = new javax.swing.JButton();
        cadastro_cliente_botaocadastrar = new javax.swing.JButton();
        cadastro_cliente_campoconsultar = new javax.swing.JTextField();
        cadastro_cliente_tabelaconsulta = new javax.swing.JScrollPane();
        cadastro_clientejuridico_tabelaconsulta2 = new javax.swing.JTable();
        cadastro_cliente_campocep = new javax.swing.JFormattedTextField();
        cadastro_cliente_campotelefone = new javax.swing.JFormattedTextField();
        cadastro_cliente_campocodigo = new javax.swing.JTextField();
        cadastro_cliente_textodocumento = new javax.swing.JLabel();
        cadastro_cliente_textodocauxiliar = new javax.swing.JLabel();
        cadastro_cliente_camponumero = new javax.swing.JFormattedTextField();
        cadastro_cliente_textocidade = new javax.swing.JLabel();
        cadastro_cliente_campocidade = new javax.swing.JTextField();
        cadastro_cliente_textouf = new javax.swing.JLabel();
        cadastro_cliente_textocelular = new javax.swing.JLabel();
        cadastro_cliente_campocelular = new javax.swing.JFormattedTextField();
        cadastro_cliente_campodocumento = new javax.swing.JTextField();
        cadastro_cliente_campodocauxiliar = new javax.swing.JTextField();
        cadastro_cliente_campouf = new javax.swing.JFormattedTextField();

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
        setTitle("Cadastro de clientes");
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

        cadastro_cliente_textonome.setText("Nome/Razao");

        cadastro_cliente_camporazao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cadastro_cliente_camporazaoKeyPressed(evt);
            }
        });

        cadastro_cliente_textologradouro.setText("Logradouro");

        cadastro_cliente_campologradouro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cadastro_cliente_campologradouroKeyPressed(evt);
            }
        });

        cadastro_cliente_textonumero.setText("Numero");

        cadastro_cliente_textonumcad.setText("Cadastro Nº");

        cadastro_cliente_textobairro.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        cadastro_cliente_textobairro.setText("Bairro");

        cadastro_cliente_campobairro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cadastro_cliente_campobairroKeyPressed(evt);
            }
        });

        cadastro_cliente_textocep.setText("CEP");

        cadastro_cliente_textoemail.setText("E-mail");

        cadastro_cliente_campoemail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cadastro_cliente_campoemailKeyPressed(evt);
            }
        });

        cadastro_cliente_textotelefone.setText("Telefone");

        cadastro_cliente_botaocancelar.setText("Cancelar");
        cadastro_cliente_botaocancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastro_cliente_botaocancelarActionPerformed(evt);
            }
        });
        cadastro_cliente_botaocancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cadastro_cliente_botaocancelarKeyPressed(evt);
            }
        });

        cadastro_cliente_botaosalvar.setText("Salvar");
        cadastro_cliente_botaosalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastro_cliente_botaosalvarActionPerformed(evt);
            }
        });
        cadastro_cliente_botaosalvar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cadastro_cliente_botaosalvarKeyPressed(evt);
            }
        });

        cadastro_cliente_botaonovo.setText("Novo");
        cadastro_cliente_botaonovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastro_cliente_botaonovoActionPerformed(evt);
            }
        });

        cadastro_cliente_botaocadastrar.setText("Cadastrar");
        cadastro_cliente_botaocadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastro_cliente_botaocadastrarActionPerformed(evt);
            }
        });
        cadastro_cliente_botaocadastrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cadastro_cliente_botaocadastrarKeyPressed(evt);
            }
        });

        cadastro_cliente_campoconsultar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cadastro_cliente_campoconsultarKeyReleased(evt);
            }
        });

        cadastro_clientejuridico_tabelaconsulta2.setModel(new javax.swing.table.DefaultTableModel(
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
        cadastro_clientejuridico_tabelaconsulta2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cadastro_clientejuridico_tabelaconsulta2MouseClicked(evt);
            }
        });
        cadastro_cliente_tabelaconsulta.setViewportView(cadastro_clientejuridico_tabelaconsulta2);

        try {
            cadastro_cliente_campocep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cadastro_cliente_campocep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cadastro_cliente_campocepKeyPressed(evt);
            }
        });

        try {
            cadastro_cliente_campotelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cadastro_cliente_campotelefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cadastro_cliente_campotelefoneKeyPressed(evt);
            }
        });

        cadastro_cliente_campocodigo.setEnabled(false);

        cadastro_cliente_textodocumento.setText("Documento");

        cadastro_cliente_textodocauxiliar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        cadastro_cliente_textodocauxiliar.setText("Doc auxiliar");

        cadastro_cliente_camponumero.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        cadastro_cliente_camponumero.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cadastro_cliente_camponumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cadastro_cliente_camponumeroKeyPressed(evt);
            }
        });

        cadastro_cliente_textocidade.setText("Cidade");

        cadastro_cliente_campocidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastro_cliente_campocidadeActionPerformed(evt);
            }
        });

        cadastro_cliente_textouf.setText("UF");

        cadastro_cliente_textocelular.setText("Celular");

        try {
            cadastro_cliente_campocelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cadastro_cliente_campocelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastro_cliente_campocelularActionPerformed(evt);
            }
        });

        cadastro_cliente_campodocauxiliar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastro_cliente_campodocauxiliarActionPerformed(evt);
            }
        });

        try {
            cadastro_cliente_campouf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cadastro_cliente_tabelaconsulta)
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(cadastro_cliente_botaonovo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cadastro_cliente_campoconsultar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cadastro_cliente_textonome)
                                .addComponent(cadastro_cliente_textologradouro)
                                .addComponent(cadastro_cliente_textocadastro)
                                .addComponent(cadastro_cliente_textonumcad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(cadastro_cliente_textobairro)
                            .addComponent(cadastro_cliente_textoemail))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cadastro_cliente_camporazao)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cadastro_cliente_campologradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cadastro_cliente_textonumero)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cadastro_cliente_camponumero, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cadastro_cliente_textocep)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cadastro_cliente_campocep))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cadastro_cliente_campocodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cadastro_cliente_textodocumento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cadastro_cliente_campodocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cadastro_cliente_textodocauxiliar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cadastro_cliente_campodocauxiliar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cadastro_cliente_campobairro, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cadastro_cliente_textocidade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cadastro_cliente_campocidade, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cadastro_cliente_textouf)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cadastro_cliente_campouf))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cadastro_cliente_campoemail, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(cadastro_cliente_botaosalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cadastro_cliente_textotelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cadastro_cliente_campotelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cadastro_cliente_textocelular)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cadastro_cliente_campocelular, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cadastro_cliente_botaocadastrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cadastro_cliente_botaocancelar)
                        .addGap(1, 1, 1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cadastro_cliente_campocodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cadastro_cliente_textodocumento)
                        .addComponent(cadastro_cliente_textodocauxiliar)
                        .addComponent(cadastro_cliente_campodocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cadastro_cliente_campodocauxiliar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cadastro_cliente_textocadastro)
                        .addComponent(cadastro_cliente_textonumcad)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadastro_cliente_camporazao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cadastro_cliente_textonome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadastro_cliente_textologradouro)
                    .addComponent(cadastro_cliente_campologradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cadastro_cliente_textonumero)
                    .addComponent(cadastro_cliente_camponumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cadastro_cliente_textocep)
                    .addComponent(cadastro_cliente_campocep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadastro_cliente_campobairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cadastro_cliente_textobairro)
                    .addComponent(cadastro_cliente_textocidade)
                    .addComponent(cadastro_cliente_campocidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cadastro_cliente_textouf)
                    .addComponent(cadastro_cliente_campouf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadastro_cliente_campoemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cadastro_cliente_textoemail)
                    .addComponent(cadastro_cliente_textotelefone)
                    .addComponent(cadastro_cliente_campotelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cadastro_cliente_textocelular)
                    .addComponent(cadastro_cliente_campocelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadastro_cliente_botaosalvar)
                    .addComponent(cadastro_cliente_botaocancelar)
                    .addComponent(cadastro_cliente_botaocadastrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadastro_cliente_campoconsultar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cadastro_cliente_botaonovo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cadastro_cliente_tabelaconsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setBounds(0, 0, 574, 430);
    }// </editor-fold>//GEN-END:initComponents

    private void cadastro_cliente_botaocadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastro_cliente_botaocadastrarActionPerformed
        // TODO add your handling code here:
        cadastro_cliente();
    }//GEN-LAST:event_cadastro_cliente_botaocadastrarActionPerformed

    private void cadastro_cliente_botaosalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastro_cliente_botaosalvarActionPerformed
        edita_clientejuridico();
    }//GEN-LAST:event_cadastro_cliente_botaosalvarActionPerformed

    private void cadastro_cliente_botaocancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastro_cliente_botaocancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_cadastro_cliente_botaocancelarActionPerformed

    private void cadastro_cliente_camporazaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cadastro_cliente_camporazaoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            this.dispose();
        }
    }//GEN-LAST:event_cadastro_cliente_camporazaoKeyPressed

    private void cadastro_cliente_campologradouroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cadastro_cliente_campologradouroKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            this.dispose();
        }
    }//GEN-LAST:event_cadastro_cliente_campologradouroKeyPressed

    private void cadastro_cliente_camponumeroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cadastro_cliente_camponumeroKeyPressed
       if (evt.getKeyCode() == KeyEvent.VK_ESCAPE)
       {
            this.dispose();
       }
    }//GEN-LAST:event_cadastro_cliente_camponumeroKeyPressed

    private void cadastro_cliente_campobairroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cadastro_cliente_campobairroKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            this.dispose();
        }
    }//GEN-LAST:event_cadastro_cliente_campobairroKeyPressed

    private void cadastro_cliente_campocepKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cadastro_cliente_campocepKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            this.dispose();
        }
    }//GEN-LAST:event_cadastro_cliente_campocepKeyPressed

    private void cadastro_cliente_campoemailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cadastro_cliente_campoemailKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            this.dispose();
        }
    }//GEN-LAST:event_cadastro_cliente_campoemailKeyPressed

    private void cadastro_cliente_campotelefoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cadastro_cliente_campotelefoneKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            this.dispose();
        }
    }//GEN-LAST:event_cadastro_cliente_campotelefoneKeyPressed

    private void cadastro_cliente_botaocancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cadastro_cliente_botaocancelarKeyPressed
        // TODO add your handling code here:
        
          if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            this.dispose();
        }

        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE){
            this.dispose();}
    }//GEN-LAST:event_cadastro_cliente_botaocancelarKeyPressed

    private void cadastro_cliente_botaosalvarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cadastro_cliente_botaosalvarKeyPressed
        // TODO add your handling code here:
        
          if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            edita_clientejuridico();
        }

        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE){
            this.dispose();}
    }//GEN-LAST:event_cadastro_cliente_botaosalvarKeyPressed

    private void cadastro_cliente_campoconsultarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cadastro_cliente_campoconsultarKeyReleased
        // TODO add your handling code here:
        pesquisa_cliente();
    }//GEN-LAST:event_cadastro_cliente_campoconsultarKeyReleased

    private void cadastro_clientejuridico_tabelaconsulta2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cadastro_clientejuridico_tabelaconsulta2MouseClicked
        // TODO add your handling code here:
        mostra_clientejuridico();
    }//GEN-LAST:event_cadastro_clientejuridico_tabelaconsulta2MouseClicked

    private void cadastro_cliente_botaonovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastro_cliente_botaonovoActionPerformed
        // TODO add your handling code here:
        novo_cliente();
    }//GEN-LAST:event_cadastro_cliente_botaonovoActionPerformed

    private void cadastro_cliente_botaocadastrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cadastro_cliente_botaocadastrarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            cadastro_cliente();
        }

        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE){
            this.dispose();}
    }//GEN-LAST:event_cadastro_cliente_botaocadastrarKeyPressed

    private void cadastro_cliente_campocidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastro_cliente_campocidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cadastro_cliente_campocidadeActionPerformed

    private void cadastro_cliente_campocelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastro_cliente_campocelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cadastro_cliente_campocelularActionPerformed

    private void cadastro_cliente_campodocauxiliarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastro_cliente_campodocauxiliarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cadastro_cliente_campodocauxiliarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cadastro_cliente_botaocadastrar;
    private javax.swing.JButton cadastro_cliente_botaocancelar;
    private javax.swing.JButton cadastro_cliente_botaonovo;
    private javax.swing.JButton cadastro_cliente_botaosalvar;
    private javax.swing.JTextField cadastro_cliente_campobairro;
    private javax.swing.JFormattedTextField cadastro_cliente_campocelular;
    private javax.swing.JFormattedTextField cadastro_cliente_campocep;
    private javax.swing.JTextField cadastro_cliente_campocidade;
    private javax.swing.JTextField cadastro_cliente_campocodigo;
    private javax.swing.JTextField cadastro_cliente_campoconsultar;
    private javax.swing.JTextField cadastro_cliente_campodocauxiliar;
    private javax.swing.JTextField cadastro_cliente_campodocumento;
    private javax.swing.JTextField cadastro_cliente_campoemail;
    private javax.swing.JTextField cadastro_cliente_campologradouro;
    private javax.swing.JFormattedTextField cadastro_cliente_camponumero;
    private javax.swing.JTextField cadastro_cliente_camporazao;
    private javax.swing.JFormattedTextField cadastro_cliente_campotelefone;
    private javax.swing.JFormattedTextField cadastro_cliente_campouf;
    private javax.swing.JScrollPane cadastro_cliente_tabelaconsulta;
    private javax.swing.JLabel cadastro_cliente_textobairro;
    private javax.swing.JLabel cadastro_cliente_textocadastro;
    private javax.swing.JLabel cadastro_cliente_textocelular;
    private javax.swing.JLabel cadastro_cliente_textocep;
    private javax.swing.JLabel cadastro_cliente_textocidade;
    private javax.swing.JLabel cadastro_cliente_textodocauxiliar;
    private javax.swing.JLabel cadastro_cliente_textodocumento;
    private javax.swing.JLabel cadastro_cliente_textoemail;
    private javax.swing.JLabel cadastro_cliente_textologradouro;
    private javax.swing.JLabel cadastro_cliente_textonome;
    private javax.swing.JLabel cadastro_cliente_textonumcad;
    private javax.swing.JLabel cadastro_cliente_textonumero;
    private javax.swing.JLabel cadastro_cliente_textotelefone;
    private javax.swing.JLabel cadastro_cliente_textouf;
    private javax.swing.JTable cadastro_clientejuridico_tabelaconsulta2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

    private void setLocationRelativeTo(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
