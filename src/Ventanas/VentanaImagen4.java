package Ventanas;

import Interfazgrafica.frmMenuPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaImagen4 extends JFrame implements ActionListener {
    static VentanaImagen4 img;
    static JLabel imagen,txtCerro;
    static JButton btnRegresar;
    static frmMenuPrincipal regresar;


    public VentanaImagen4(){
        imagen = new JLabel();

        imagen = new JLabel(new ImageIcon("/Users/alejandrovalenciacastrillon/Downloads/ECOTURISTEA/src/Imagenes/image 4.png"));
        imagen.setLocation(50, 5);
        imagen.setSize(400, 400);

        txtCerro = new JLabel("<html><p style='font-family: Arial; font-size: 14px; color: black;'>El Cerro de las Tres Cruces en Medellín, Colombia, es un icónico mirador que ofrece impresionantes vistas panorámicas de la ciudad y sus alrededores. Con tres cruces que se alzan en la cima, el cerro es un lugar de encuentro popular para aquellos que buscan disfrutar de la naturaleza y contemplar el paisaje urbano.</p></html>");
        txtCerro.setSize(400, 200);
        txtCerro.setLocation(50, 430);



        //Boton regresar
        btnRegresar = new JButton("Regresar al inicio");
        btnRegresar.setLocation(175, 700);
        btnRegresar.setSize(150, 50);
        btnRegresar.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        btnRegresar.addActionListener(this);

        add(imagen);
        add(btnRegresar);
        add(txtCerro);

        setLayout(null);
        this.setSize(500, 800);
        setLocationRelativeTo(null);
        Color c = new Color(60, 181, 41);
        getContentPane().setBackground(c);
    }

    public static VentanaImagen4 crear5() {
        if(img == null){
            img = new VentanaImagen4();
        }
        return img;
    }
        @Override
        public void actionPerformed (ActionEvent e){
            if (e.getSource().equals(btnRegresar)) {
                regresar = frmMenuPrincipal.crear6();
                regresar.setVisible(true);
                this.setVisible(false);
        }

        }
}
