package org.example.Vista;

import javax.swing.*;
import java.awt.*;

public class VentanaLibro extends JFrame {
    private JLabel lblid;
    private JLabel lblTitulo;
    private JLabel lblAutor;
    private JTextField txtid;
    private JTextField txtiTitulo;
    private JTextField txtAutor;
    private JButton btnAgregar;
    private JButton btnCargar;
    private JTable tblLibro;
    private JScrollPane scrollPane;
    private GridLayout layout;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;


    public VentanaLibro(String title) throws HeadlessException {
        super(title);

        this.setSize(800,800);
        layout = new GridLayout(2,2);
        this.getContentPane().setLayout(layout);

        //panle1
        panel1 = new JPanel(new FlowLayout());
        panel1.setBackground(new Color(40, 206, 206));
        lblid = new JLabel("id:");
        lblTitulo = new JLabel("Titulo:");
        lblAutor = new JLabel("Autor:");
        txtid = new JTextField(3);
        txtid.setText("0");
        txtid.setEnabled(false);
        txtiTitulo = new JTextField(15);
        txtAutor = new JTextField(15);
        btnAgregar = new JButton("Agregar");
        panel1.add(lblid);
        panel1.add(txtid);
        panel1.add(lblTitulo);
        panel1.add(txtiTitulo);
        panel1.add(lblAutor);
        panel1.add(txtAutor);
        panel1.add(btnAgregar);


        //panle2
        panel2 = new JPanel(new FlowLayout());
        panel2.setBackground(new Color(51, 45, 232));
        btnCargar  = new JButton("Cargar");
        panel2.add(btnCargar);
        tblLibro = new JTable();
        scrollPane = new JScrollPane(tblLibro);
        panel2.add(scrollPane);


        //panle3
        panel3 = new JPanel(new FlowLayout());
        panel3.setBackground(new Color(100, 28, 210));


        //panle4
        panel4 = new JPanel(new FlowLayout());
        panel4.setBackground(new Color(192, 25, 204));



        this.getContentPane().add(panel1,0);
        this.getContentPane().add(panel2,1);
        this.getContentPane().add(panel3,2);
        this.getContentPane().add(panel4,3);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public JLabel getLblid() {
        return lblid;
    }

    public void setLblid(JLabel lblid) {
        this.lblid = lblid;
    }

    public JLabel getLblTitulo() {
        return lblTitulo;
    }

    public void setLblTitulo(JLabel lblTitulo) {
        this.lblTitulo = lblTitulo;
    }

    public JLabel getLblAutor() {
        return lblAutor;
    }

    public void setLblAutor(JLabel lblAutor) {
        this.lblAutor = lblAutor;
    }

    public JTextField getTxtid() {
        return txtid;
    }

    public void setTxtid(JTextField txtid) {
        this.txtid = txtid;
    }

    public JTextField getTxtiTitulo() {
        return txtiTitulo;
    }

    public void setTxtiTitulo(JTextField txtiTitulo) {
        this.txtiTitulo = txtiTitulo;
    }

    public JTextField getTxtAutor() {
        return txtAutor;
    }

    public void setTxtAutor(JTextField txtAutor) {
        this.txtAutor = txtAutor;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public void setBtnAgregar(JButton btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    public JButton getBtnCargar() {
        return btnCargar;
    }

    public void setBtnCargar(JButton btnCargar) {
        this.btnCargar = btnCargar;
    }

    public JTable getTblLibro() {
        return tblLibro;
    }

    public void setTblLibro(JTable tblLibro) {
        this.tblLibro = tblLibro;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    @Override
    public GridLayout getLayout() {
        return layout;
    }

    public void setLayout(GridLayout layout) {
        this.layout = layout;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public void setPanel2(JPanel panel2) {
        this.panel2 = panel2;
    }

    public JPanel getPanel3() {
        return panel3;
    }

    public void setPanel3(JPanel panel3) {
        this.panel3 = panel3;
    }

    public JPanel getPanel4() {
        return panel4;
    }

    public void setPanel4(JPanel panel4) {
        this.panel4 = panel4;
    }
    public void limpiar(){
        txtiTitulo.setText(" ");
        txtAutor.setText(" ");
    }

}
