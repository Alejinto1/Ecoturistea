package Ventanas;

import Interfazgrafica.frmMenuPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaImagen1 extends JFrame implements ActionListener {
    static JLabel img2;
    static JLabel txtparqueExplora;
    static JButton btnRegresar;
    static VentanaImagen1 img;
    static frmMenuPrincipal regresar;

    public VentanaImagen1() {
        // Imagen Parque Explora
        img2 = new JLabel(new ImageIcon("/Users/alejandrovalenciacastrillon/Downloads/ECOTURISTEA/src/Imagenes/image 1.png"));
        img2.setLocation(50, 5);
        img2.setSize(400, 400);

        // Texto Parque Explora en formato HTML
        txtparqueExplora = new JLabel("<html><p style='font-family: Arial; font-size: 14px; color: black;'>Parque Explora en Medellín es un cautivador centro interactivo de ciencia y tecnología. Desde un emocionante acuario hasta un educativo planetario, ofrece experiencias inmersivas para visitantes de todas las edades. Con programas educativos y talleres, busca inspirar la curiosidad científica. Integrando tecnología innovadora.</p></html>");
        txtparqueExplora.setSize(400, 200);
        txtparqueExplora.setLocation(50, 430);

        // Boton regresar
        btnRegresar = new JButton("Regresar al inicio");
        btnRegresar.setLocation(175, 650);
        btnRegresar.setSize(150, 50);
        btnRegresar.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        btnRegresar.addActionListener(this);

        // ADDS
        add(img2);
        add(btnRegresar);
        add(txtparqueExplora);

        // Interfaz
        setLayout(null);
        this.setSize(500, 800);
        setLocationRelativeTo(null);
        Color c = new Color(60, 181, 41);
        getContentPane().setBackground(c);
    }

    // Crear
    public static VentanaImagen1 crear() {
        if (img == null) {
            img = new VentanaImagen1();
        }
        return img;
    }

    // Acciones de botones
    // Acción regresar
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnRegresar)) {
            regresar = frmMenuPrincipal.crear1();
            regresar.setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        VentanaImagen1 ventanaImagen1 = new VentanaImagen1();
        ventanaImagen1.setVisible(true);
    }
}
