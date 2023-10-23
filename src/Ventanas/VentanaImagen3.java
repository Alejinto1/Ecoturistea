package Ventanas;

import Interfazgrafica.frmMenuPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaImagen3 extends JFrame implements ActionListener {
    static VentanaImagen3 img;
    static JLabel imagen,txtParqueArvi;
    static JButton btnRegresar;
    frmMenuPrincipal regresar;
    public VentanaImagen3(){


        imagen = new JLabel();
        imagen= new JLabel(new ImageIcon("/Users/alejandrovalenciacastrillon/Downloads/ECOTURISTEA/src/Imagenes/image 2.png"));
        imagen.setLocation(50, 5);
        imagen.setSize(400, 400);

        txtParqueArvi = new JLabel("<html><p style='font-family: Arial; font-size: 14px; color: black;'>El Jardín Botánico de Medellín, ubicado en la ciudad colombiana de Medellín, es un oasis verde que combina biodiversidad, educación y recreación. Este espacio cautivador alberga una amplia variedad de especies vegetales, tanto nativas como exóticas, distribuidas en secciones temáticas que promueven la conservación y la conciencia ambiental.</p></html>");
        txtParqueArvi.setSize(400, 200);
        txtParqueArvi.setLocation(50, 430);

        //Boton regresar
        btnRegresar = new JButton("Regresar al inicio");
        btnRegresar.setLocation(175, 700);
        btnRegresar.setSize(150, 50);
        btnRegresar.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        btnRegresar.addActionListener(this);

        //ADDS
        add(imagen);
        add(btnRegresar);
        add(txtParqueArvi);
        setLayout(null);
        this.setSize(500, 800);
        setLocationRelativeTo(null);
        Color c = new Color(60, 181, 41);
        getContentPane().setBackground(c);
    }

    public static VentanaImagen3 crear4() {
        if(img == null){
            img = new VentanaImagen3();
        }
        return img;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnRegresar)){
            regresar = frmMenuPrincipal.crear5();
            regresar.setVisible(true);
            this.setVisible(false);
        }


    }

    public static void main(String[] args) {
        VentanaImagen3 ventanaImagen3 = new VentanaImagen3();
        ventanaImagen3.setVisible(true);
    }
}
