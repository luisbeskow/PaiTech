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
public class cadastro_funcionario extends javax.swing.JInternalFrame 
{
    Connection conecta;
    PreparedStatement pst;
    ResultSet res;     
            
            
    public cadastro_funcionario() throws ClassNotFoundException {
        initComponents();
        conecta = conectabanco.conectabanco();
        lista_funcionario();
        this.dispose();
    }

    
    
    public void lista_funcionario()
    {
        String sql = "Select * from funcionario";
        
        try
        {
            pst = conecta.prepareStatement(sql);
            res = pst.executeQuery();
            cadastro_funcionario_tabelaconsulta2.setModel(DbUtils.resultSetToTableModel(res));            
        }
        
        catch(SQLException error)
        {
          JOptionPane.showMessageDialog(null,error);      
        } 
    }
    
    
    
    public void novo_funcionario()
    {
        cadastro_funcionario_campocodigo.setText("") ;
        cadastro_funcionario_campocpf.setText("") ;
        cadastro_funcionario_camporg.setText("") ;
        cadastro_funcionario_camponome.setText("") ;
        cadastro_funcionario_campologradouro.setText("") ;
        cadastro_funcionario_camponumero.setText(""); 
        cadastro_funcionario_campocep.setText("");
        cadastro_funcionario_campobairro.setText(""); 
        cadastro_funcionario_campocidade.setText(""); 
        cadastro_funcionario_campouf.setText(""); 
        cadastro_funcionario_campoemail.setText("");
        cadastro_funcionario_campotelefone.setText("");
        cadastro_funcionario_campocelular.setText("");     
    }        
 
    
    
public void  cadastro_funcionario()       
{
    
    String sql = "Insert into funcionario(cpf,rg,funcionario,logradouro,numero,cep,bairro,cidade,uf,email,telefone,celular) values (?,?,?,?,?,?,?,?,?,?,?,?)";  
    
    try
    {
        pst = conecta.prepareStatement(sql);
        
        pst.setString(1,cadastro_funcionario_campocpf.getText());
        pst.setString(2,cadastro_funcionario_camporg.getText());
        pst.setString(3,cadastro_funcionario_camponome.getText());
        pst.setString(4,cadastro_funcionario_campologradouro.getText());
        pst.setString(5,cadastro_funcionario_camponumero.getText());
        pst.setString(6,cadastro_funcionario_campocep.getText());
        pst.setString(7,cadastro_funcionario_campobairro.getText());
        pst.setString(8,cadastro_funcionario_campocidade.getText());
        pst.setString(9,cadastro_funcionario_campouf.getText());
        pst.setString(10,cadastro_funcionario_campoemail.getText());
        pst.setString(11,cadastro_funcionario_campotelefone.getText());
        pst.setString(12,cadastro_funcionario_campocelular.getText());
        
        pst.execute();
        JOptionPane.showMessageDialog(null, "Funcionario cadastrado com sucesso","Cadastro de funcionario",JOptionPane.INFORMATION_MESSAGE);
    }
    
    catch(SQLException error)
            {
               JOptionPane.showMessageDialog(null,error);
            }
}



public void pesquisa_funcionario()
{
    String sql = "Select * from funcionario where funcionario like ?";
    
    try
    {
        pst = conecta.prepareStatement(sql);
        pst.setString(1,cadastro_funcionario_campoconsultar.getText()+"%");
        res = pst.executeQuery();
        cadastro_funcionario_tabelaconsulta2.setModel(DbUtils.resultSetToTableModel(res)); 
    }
    
    catch (SQLException error)
    {
                
        JOptionPane.showMessageDialog(null,error);                   
    }
 
}



public void mostra_funcionario()     
{
int seleciona =  cadastro_funcionario_tabelaconsulta2.getSelectedRow();
cadastro_funcionario_campocodigo.setText((String) cadastro_funcionario_tabelaconsulta2.getModel().getValueAt(seleciona, 0).toString()); 
cadastro_funcionario_campocpf.setText((String) cadastro_funcionario_tabelaconsulta2.getModel().getValueAt(seleciona, 1).toString());
cadastro_funcionario_camporg.setText((String) cadastro_funcionario_tabelaconsulta2.getModel().getValueAt(seleciona, 2).toString());
cadastro_funcionario_camponome.setText((String) cadastro_funcionario_tabelaconsulta2.getModel().getValueAt(seleciona, 3).toString());
cadastro_funcionario_campologradouro.setText((String) cadastro_funcionario_tabelaconsulta2.getModel().getValueAt(seleciona, 4).toString());
cadastro_funcionario_camponumero.setText((String) cadastro_funcionario_tabelaconsulta2.getModel().getValueAt(seleciona, 5).toString());
cadastro_funcionario_campocep.setText((String) cadastro_funcionario_tabelaconsulta2.getModel().getValueAt(seleciona, 6).toString());
cadastro_funcionario_campobairro.setText((String) cadastro_funcionario_tabelaconsulta2.getModel().getValueAt(seleciona, 7).toString());
cadastro_funcionario_campocidade.setText((String) cadastro_funcionario_tabelaconsulta2.getModel().getValueAt(seleciona, 8).toString());
cadastro_funcionario_campouf.setText((String) cadastro_funcionario_tabelaconsulta2.getModel().getValueAt(seleciona, 9).toString());
cadastro_funcionario_campoemail.setText((String) cadastro_funcionario_tabelaconsulta2.getModel().getValueAt(seleciona, 10).toString());
cadastro_funcionario_campotelefone.setText((String) cadastro_funcionario_tabelaconsulta2.getModel().getValueAt(seleciona, 11).toString());
cadastro_funcionario_campocelular.setText((String) cadastro_funcionario_tabelaconsulta2.getModel().getValueAt(seleciona, 12).toString());

}  



public void edita_funcionario()
{
  String sql = "Update funcionario set cpf=?,rg=?,funcionario=?,logradouro=?,numero=?,cep=?,bairro=?,cidade=?,uf=?,email=?,telefone=?,celular=? where codigofuncionario=?"; 
  
  try
  {
      pst = conecta.prepareStatement(sql);
        pst.setString(1,cadastro_funcionario_campocpf.getText());
        pst.setString(2,cadastro_funcionario_camporg.getText());
        pst.setString(3,cadastro_funcionario_camponome.getText());
        pst.setString(4,cadastro_funcionario_campologradouro.getText());
        pst.setString(5,cadastro_funcionario_camponumero.getText());
        pst.setString(6,cadastro_funcionario_campocep.getText());
        pst.setString(7,cadastro_funcionario_campobairro.getText());
        pst.setString(8,cadastro_funcionario_campocidade.getText());
        pst.setString(9,cadastro_funcionario_campouf.getText());
        pst.setString(10,cadastro_funcionario_campoemail.getText());
        pst.setString(11,cadastro_funcionario_campotelefone.getText());
        pst.setString(12,cadastro_funcionario_campocelular.getText());
        pst.setInt(13,Integer.parseInt(cadastro_funcionario_campocodigo.getText()));
        
      pst.executeUpdate();
      JOptionPane.showMessageDialog(null,"Cadastro atualizado com sucesso");
      lista_funcionario();
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
        cadastro_clientefisico_textonome = new javax.swing.JLabel();
        cadastro_funcionario_camponome = new javax.swing.JTextField();
        cadastro_clientefisico_textologradouro = new javax.swing.JLabel();
        cadastro_funcionario_campologradouro = new javax.swing.JTextField();
        cadastro_clientefisico_textonumero = new javax.swing.JLabel();
        cadastro_clientefisico_textocadastro = new javax.swing.JLabel();
        cadastro_clientefisico_textonumcad = new javax.swing.JLabel();
        cadastro_clientefisico_textobairro = new javax.swing.JLabel();
        cadastro_funcionario_campobairro = new javax.swing.JTextField();
        cadastro_clientefisico_textocep = new javax.swing.JLabel();
        cadastro_clientefisico_textoemail = new javax.swing.JLabel();
        cadastro_funcionario_campoemail = new javax.swing.JTextField();
        cadastro_clientefisico_textotelefone = new javax.swing.JLabel();
        cadastro_clientefisico_separador = new javax.swing.JSeparator();
        cadastro_funcionario_botaocancelar = new javax.swing.JButton();
        cadastro_funcionario_botaosalvar = new javax.swing.JButton();
        cadastro_funcionario_botaonovo = new javax.swing.JButton();
        cadastro_funcionario_botaocadastrar = new javax.swing.JButton();
        cadastro_funcionario_campoconsultar = new javax.swing.JTextField();
        cadastro_clientefisico_tabelaconsulta = new javax.swing.JScrollPane();
        cadastro_funcionario_tabelaconsulta2 = new javax.swing.JTable();
        cadastro_funcionario_campocpf = new javax.swing.JFormattedTextField();
        cadastro_funcionario_campocep = new javax.swing.JFormattedTextField();
        cadastro_funcionario_campotelefone = new javax.swing.JFormattedTextField();
        cadastro_funcionario_campocodigo = new javax.swing.JTextField();
        cadastro_clientefisico_textocpf = new javax.swing.JLabel();
        cadastro_clientefisico_textorg = new javax.swing.JLabel();
        cadastro_funcionario_camporg = new javax.swing.JFormattedTextField();
        cadastro_funcionario_camponumero = new javax.swing.JFormattedTextField();
        cadastro_clientefisico_textocidade = new javax.swing.JLabel();
        cadastro_funcionario_campocidade = new javax.swing.JTextField();
        cadastro_clientefisico_textouf = new javax.swing.JLabel();
        cadastro_funcionario_campouf = new javax.swing.JTextField();
        cadastro_clientefisico_textocelular = new javax.swing.JLabel();
        cadastro_funcionario_campocelular = new javax.swing.JFormattedTextField();

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
        setTitle("Cadastro de funcionarios");
        setToolTipText("");
        setMaximumSize(new java.awt.Dimension(574, 430));
        setMinimumSize(new java.awt.Dimension(574, 430));
        setName("cadastro_funcionario"); // NOI18N
        setNormalBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setPreferredSize(new java.awt.Dimension(574, 430));
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        setVisible(true);

        cadastro_clientefisico_textonome.setText("Nome");

        cadastro_funcionario_camponome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cadastro_funcionario_camponomeKeyPressed(evt);
            }
        });

        cadastro_clientefisico_textologradouro.setText("Logradouro");

        cadastro_funcionario_campologradouro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cadastro_funcionario_campologradouroKeyPressed(evt);
            }
        });

        cadastro_clientefisico_textonumero.setText("Numero");

        cadastro_clientefisico_textonumcad.setText("Cadastro Nº");

        cadastro_clientefisico_textobairro.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        cadastro_clientefisico_textobairro.setText("Bairro");

        cadastro_funcionario_campobairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastro_funcionario_campobairroActionPerformed(evt);
            }
        });
        cadastro_funcionario_campobairro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cadastro_funcionario_campobairroKeyPressed(evt);
            }
        });

        cadastro_clientefisico_textocep.setText("CEP");

        cadastro_clientefisico_textoemail.setText("E-mail");

        cadastro_funcionario_campoemail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cadastro_funcionario_campoemailKeyPressed(evt);
            }
        });

        cadastro_clientefisico_textotelefone.setText("Telefone");

        cadastro_funcionario_botaocancelar.setText("Cancelar");
        cadastro_funcionario_botaocancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastro_funcionario_botaocancelarActionPerformed(evt);
            }
        });
        cadastro_funcionario_botaocancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cadastro_funcionario_botaocancelarKeyPressed(evt);
            }
        });

        cadastro_funcionario_botaosalvar.setText("Salvar");
        cadastro_funcionario_botaosalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastro_funcionario_botaosalvarActionPerformed(evt);
            }
        });
        cadastro_funcionario_botaosalvar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cadastro_funcionario_botaosalvarKeyPressed(evt);
            }
        });

        cadastro_funcionario_botaonovo.setText("Novo");
        cadastro_funcionario_botaonovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastro_funcionario_botaonovoActionPerformed(evt);
            }
        });

        cadastro_funcionario_botaocadastrar.setText("Cadastrar");
        cadastro_funcionario_botaocadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastro_funcionario_botaocadastrarActionPerformed(evt);
            }
        });
        cadastro_funcionario_botaocadastrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cadastro_funcionario_botaocadastrarKeyPressed(evt);
            }
        });

        cadastro_funcionario_campoconsultar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cadastro_funcionario_campoconsultarKeyReleased(evt);
            }
        });

        cadastro_funcionario_tabelaconsulta2.setModel(new javax.swing.table.DefaultTableModel(
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
        cadastro_funcionario_tabelaconsulta2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cadastro_funcionario_tabelaconsulta2MouseClicked(evt);
            }
        });
        cadastro_clientefisico_tabelaconsulta.setViewportView(cadastro_funcionario_tabelaconsulta2);

        try {
            cadastro_funcionario_campocpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cadastro_funcionario_campocpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastro_funcionario_campocpfActionPerformed(evt);
            }
        });
        cadastro_funcionario_campocpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cadastro_funcionario_campocpfKeyPressed(evt);
            }
        });

        try {
            cadastro_funcionario_campocep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cadastro_funcionario_campocep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cadastro_funcionario_campocepKeyPressed(evt);
            }
        });

        try {
            cadastro_funcionario_campotelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cadastro_funcionario_campotelefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cadastro_funcionario_campotelefoneKeyPressed(evt);
            }
        });

        cadastro_funcionario_campocodigo.setEnabled(false);

        cadastro_clientefisico_textocpf.setText("CPF");

        cadastro_clientefisico_textorg.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        cadastro_clientefisico_textorg.setText("RG");

        try {
            cadastro_funcionario_camporg.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cadastro_funcionario_camporg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cadastro_funcionario_camporgKeyPressed(evt);
            }
        });

        try {
            cadastro_funcionario_camponumero.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cadastro_funcionario_camponumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cadastro_funcionario_camponumeroKeyPressed(evt);
            }
        });

        cadastro_clientefisico_textocidade.setText("Cidade");

        cadastro_funcionario_campocidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastro_funcionario_campocidadeActionPerformed(evt);
            }
        });

        cadastro_clientefisico_textouf.setText("UF");

        cadastro_clientefisico_textocelular.setText("Celular");

        try {
            cadastro_funcionario_campocelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cadastro_funcionario_campocelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastro_funcionario_campocelularActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cadastro_clientefisico_tabelaconsulta)
                    .addComponent(cadastro_clientefisico_separador)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(cadastro_funcionario_botaonovo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cadastro_funcionario_campoconsultar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cadastro_clientefisico_textonome)
                                .addComponent(cadastro_clientefisico_textologradouro)
                                .addComponent(cadastro_clientefisico_textocadastro)
                                .addComponent(cadastro_clientefisico_textonumcad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(cadastro_clientefisico_textobairro)
                            .addComponent(cadastro_clientefisico_textoemail))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cadastro_funcionario_camponome)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cadastro_funcionario_campocodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cadastro_clientefisico_textocpf)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cadastro_funcionario_campocpf, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cadastro_clientefisico_textorg)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cadastro_funcionario_camporg))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cadastro_funcionario_campobairro, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cadastro_clientefisico_textocidade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cadastro_funcionario_campocidade, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cadastro_clientefisico_textouf)
                                .addGap(22, 22, 22)
                                .addComponent(cadastro_funcionario_campouf))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cadastro_funcionario_campologradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cadastro_clientefisico_textonumero)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cadastro_funcionario_camponumero, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cadastro_clientefisico_textocep)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cadastro_funcionario_campocep, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(cadastro_funcionario_campoemail)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cadastro_clientefisico_textotelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cadastro_funcionario_campotelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cadastro_clientefisico_textocelular)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cadastro_funcionario_campocelular, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cadastro_funcionario_botaocadastrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cadastro_funcionario_botaosalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(135, 135, 135)
                        .addComponent(cadastro_funcionario_botaocancelar)
                        .addGap(1, 1, 1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cadastro_funcionario_campocodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cadastro_clientefisico_textocpf)
                        .addComponent(cadastro_funcionario_campocpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cadastro_clientefisico_textorg)
                        .addComponent(cadastro_funcionario_camporg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cadastro_clientefisico_textocadastro)
                        .addComponent(cadastro_clientefisico_textonumcad)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cadastro_clientefisico_textonome)
                    .addComponent(cadastro_funcionario_camponome, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadastro_clientefisico_textologradouro)
                    .addComponent(cadastro_funcionario_campologradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cadastro_clientefisico_textonumero)
                    .addComponent(cadastro_funcionario_camponumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cadastro_clientefisico_textocep)
                    .addComponent(cadastro_funcionario_campocep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadastro_funcionario_campobairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cadastro_clientefisico_textobairro)
                    .addComponent(cadastro_clientefisico_textocidade)
                    .addComponent(cadastro_funcionario_campocidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cadastro_clientefisico_textouf)
                    .addComponent(cadastro_funcionario_campouf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadastro_funcionario_campoemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cadastro_clientefisico_textoemail)
                    .addComponent(cadastro_clientefisico_textotelefone)
                    .addComponent(cadastro_funcionario_campotelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cadastro_clientefisico_textocelular)
                    .addComponent(cadastro_funcionario_campocelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadastro_funcionario_botaosalvar)
                    .addComponent(cadastro_funcionario_botaocancelar)
                    .addComponent(cadastro_funcionario_botaocadastrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cadastro_clientefisico_separador, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadastro_funcionario_campoconsultar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cadastro_funcionario_botaonovo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cadastro_clientefisico_tabelaconsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setBounds(0, 0, 574, 430);
    }// </editor-fold>//GEN-END:initComponents

    private void cadastro_funcionario_botaocadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastro_funcionario_botaocadastrarActionPerformed
        // TODO add your handling code here:
        cadastro_funcionario();
    }//GEN-LAST:event_cadastro_funcionario_botaocadastrarActionPerformed

    private void cadastro_funcionario_botaosalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastro_funcionario_botaosalvarActionPerformed
        edita_funcionario();
    }//GEN-LAST:event_cadastro_funcionario_botaosalvarActionPerformed

    private void cadastro_funcionario_campocpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastro_funcionario_campocpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cadastro_funcionario_campocpfActionPerformed

    private void cadastro_funcionario_botaocancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastro_funcionario_botaocancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_cadastro_funcionario_botaocancelarActionPerformed

    private void cadastro_funcionario_campocpfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cadastro_funcionario_campocpfKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE){
            this.dispose();
        }
    }//GEN-LAST:event_cadastro_funcionario_campocpfKeyPressed

    private void cadastro_funcionario_camporgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cadastro_funcionario_camporgKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            this.dispose();
        }
    }//GEN-LAST:event_cadastro_funcionario_camporgKeyPressed

    private void cadastro_funcionario_camponomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cadastro_funcionario_camponomeKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            this.dispose();
        }
    }//GEN-LAST:event_cadastro_funcionario_camponomeKeyPressed

    private void cadastro_funcionario_campologradouroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cadastro_funcionario_campologradouroKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            this.dispose();
        }
    }//GEN-LAST:event_cadastro_funcionario_campologradouroKeyPressed

    private void cadastro_funcionario_camponumeroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cadastro_funcionario_camponumeroKeyPressed
       if (evt.getKeyCode() == KeyEvent.VK_ESCAPE)
       {
            this.dispose();
       }
    }//GEN-LAST:event_cadastro_funcionario_camponumeroKeyPressed

    private void cadastro_funcionario_campobairroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cadastro_funcionario_campobairroKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            this.dispose();
        }
    }//GEN-LAST:event_cadastro_funcionario_campobairroKeyPressed

    private void cadastro_funcionario_campocepKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cadastro_funcionario_campocepKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            this.dispose();
        }
    }//GEN-LAST:event_cadastro_funcionario_campocepKeyPressed

    private void cadastro_funcionario_campoemailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cadastro_funcionario_campoemailKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            this.dispose();
        }
    }//GEN-LAST:event_cadastro_funcionario_campoemailKeyPressed

    private void cadastro_funcionario_campotelefoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cadastro_funcionario_campotelefoneKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            this.dispose();
        }
    }//GEN-LAST:event_cadastro_funcionario_campotelefoneKeyPressed

    private void cadastro_funcionario_botaocancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cadastro_funcionario_botaocancelarKeyPressed
        // TODO add your handling code here:
        
          if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            this.dispose();
        }

        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE){
            this.dispose();}
    }//GEN-LAST:event_cadastro_funcionario_botaocancelarKeyPressed

    private void cadastro_funcionario_botaosalvarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cadastro_funcionario_botaosalvarKeyPressed
        // TODO add your handling code here:
        
          if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            edita_funcionario();
        }

        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE){
            this.dispose();}
    }//GEN-LAST:event_cadastro_funcionario_botaosalvarKeyPressed

    private void cadastro_funcionario_campoconsultarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cadastro_funcionario_campoconsultarKeyReleased
        // TODO add your handling code here:
        pesquisa_funcionario();
    }//GEN-LAST:event_cadastro_funcionario_campoconsultarKeyReleased

    private void cadastro_funcionario_tabelaconsulta2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cadastro_funcionario_tabelaconsulta2MouseClicked
        // TODO add your handling code here:
        mostra_funcionario();
    }//GEN-LAST:event_cadastro_funcionario_tabelaconsulta2MouseClicked

    private void cadastro_funcionario_botaonovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastro_funcionario_botaonovoActionPerformed
        // TODO add your handling code here:
        novo_funcionario();
    }//GEN-LAST:event_cadastro_funcionario_botaonovoActionPerformed

    private void cadastro_funcionario_botaocadastrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cadastro_funcionario_botaocadastrarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            cadastro_funcionario();
        }

        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE){
            this.dispose();}
    }//GEN-LAST:event_cadastro_funcionario_botaocadastrarKeyPressed

    private void cadastro_funcionario_campocidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastro_funcionario_campocidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cadastro_funcionario_campocidadeActionPerformed

    private void cadastro_funcionario_campocelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastro_funcionario_campocelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cadastro_funcionario_campocelularActionPerformed

    private void cadastro_funcionario_campobairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastro_funcionario_campobairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cadastro_funcionario_campobairroActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator cadastro_clientefisico_separador;
    private javax.swing.JScrollPane cadastro_clientefisico_tabelaconsulta;
    private javax.swing.JLabel cadastro_clientefisico_textobairro;
    private javax.swing.JLabel cadastro_clientefisico_textocadastro;
    private javax.swing.JLabel cadastro_clientefisico_textocelular;
    private javax.swing.JLabel cadastro_clientefisico_textocep;
    private javax.swing.JLabel cadastro_clientefisico_textocidade;
    private javax.swing.JLabel cadastro_clientefisico_textocpf;
    private javax.swing.JLabel cadastro_clientefisico_textoemail;
    private javax.swing.JLabel cadastro_clientefisico_textologradouro;
    private javax.swing.JLabel cadastro_clientefisico_textonome;
    private javax.swing.JLabel cadastro_clientefisico_textonumcad;
    private javax.swing.JLabel cadastro_clientefisico_textonumero;
    private javax.swing.JLabel cadastro_clientefisico_textorg;
    private javax.swing.JLabel cadastro_clientefisico_textotelefone;
    private javax.swing.JLabel cadastro_clientefisico_textouf;
    private javax.swing.JButton cadastro_funcionario_botaocadastrar;
    private javax.swing.JButton cadastro_funcionario_botaocancelar;
    private javax.swing.JButton cadastro_funcionario_botaonovo;
    private javax.swing.JButton cadastro_funcionario_botaosalvar;
    private javax.swing.JTextField cadastro_funcionario_campobairro;
    private javax.swing.JFormattedTextField cadastro_funcionario_campocelular;
    private javax.swing.JFormattedTextField cadastro_funcionario_campocep;
    private javax.swing.JTextField cadastro_funcionario_campocidade;
    private javax.swing.JTextField cadastro_funcionario_campocodigo;
    private javax.swing.JTextField cadastro_funcionario_campoconsultar;
    private javax.swing.JFormattedTextField cadastro_funcionario_campocpf;
    private javax.swing.JTextField cadastro_funcionario_campoemail;
    private javax.swing.JTextField cadastro_funcionario_campologradouro;
    private javax.swing.JTextField cadastro_funcionario_camponome;
    private javax.swing.JFormattedTextField cadastro_funcionario_camponumero;
    private javax.swing.JFormattedTextField cadastro_funcionario_camporg;
    private javax.swing.JFormattedTextField cadastro_funcionario_campotelefone;
    private javax.swing.JTextField cadastro_funcionario_campouf;
    private javax.swing.JTable cadastro_funcionario_tabelaconsulta2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private void setLocationRelativeTo(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
