package Ventanas;

import Interfazgrafica.frmMenuPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaImagen2 extends JFrame implements ActionListener{
    static VentanaImagen2 img2;
    static JLabel imagen;
    static JButton btnRegresar;
    static JLabel txtJardinBotanico;

    frmMenuPrincipal regresar;
    public VentanaImagen2(){

        imagen = new JLabel();

        imagen = new JLabel(new ImageIcon("/Users/alejandrovalenciacastrillon/Downloads/ECOTURISTEA/src/Imagenes/image 3.png"));
        imagen.setLocation(50, 5);
        imagen.setSize(400, 400);

        //Boton regresar
        btnRegresar = new JButton("Regresar al inicio");
        btnRegresar.setLocation(175, 700);
        btnRegresar.setSize(150, 50);
        btnRegresar.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        btnRegresar.addActionListener(this);
        //Txt Jardin Botanico
        txtJardinBotanico = new JLabel("<html><p style='font-family: Arial; font-size: 14px; color: black;'>El Jardín Botánico de Medellín, ubicado en la ciudad colombiana de Medellín, es un oasis verde que combina biodiversidad, educación y recreación. Este espacio cautivador alberga una amplia variedad de especies vegetales, tanto nativas como exóticas, distribuidas en secciones temáticas que promueven la conservación y la conciencia ambiental.</p></html>");
        txtJardinBotanico.setSize(400, 200);
        txtJardinBotanico.setLocation(50, 430);


        add(imagen);
        add(btnRegresar);
        add(txtJardinBotanico);
        setLayout(null);
        this.setSize(500, 800);
        setLocationRelativeTo(null);
        Color c = new Color(60, 181, 41);
        getContentPane().setBackground(c);
    }

    public static VentanaImagen2 crear3() {
        if (img2 == null) {
            img2 = new VentanaImagen2();
        }
        return img2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(btnRegresar)){
            regresar = frmMenuPrincipal.crear4();
            regresar.setVisible(true);
            this.setVisible(false);
        }

    }
    public static void main(String[] args) {
        VentanaImagen2 ventanaImagen2 = new VentanaImagen2();
        ventanaImagen2.setVisible(true);
    }
}
