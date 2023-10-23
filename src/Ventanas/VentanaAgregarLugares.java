package Ventanas;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class VentanaAgregarLugares  extends JFrame implements ActionListener {
        static VentanaAgregarLugares regresar;
        static JTextField nombreLugar,descripcion;
        static JLabel NombreLugar,Descripcion,lblFoto;
        static JButton ok, SeleccionarArchivo;
        static FileNameExtensionFilter filtro;
        static JFileChooser fileChooser;
        static File archivoSeleccionado;
        static String nombreArchivo;
        static VentanaNueva ventanaNueva;


    public VentanaAgregarLugares(){

            NombreLugar = new JLabel("Digite el nombre del lugar: ");
            NombreLugar.setSize(300,100);
            NombreLugar.setLocation(10,0);

            nombreLugar = new JTextField();
            nombreLugar.setSize(250, 30);
            nombreLugar.setLocation(190, 35);

            Descripcion = new JLabel("Digita la descripción: ");
            Descripcion.setSize(500,100);
            Descripcion.setLocation(10,50);

            descripcion = new JTextField();
            descripcion.setSize(250,100);
            descripcion.setLocation(190,65);

            ok = new JButton("OK");
            ok.setLocation(190, 200);
            ok.setSize(150, 50);
            ok.addActionListener(this);

            SeleccionarArchivo = new JButton("Cargar Imagen");
            SeleccionarArchivo.setSize(150,50);
            SeleccionarArchivo.setLocation(190,290);
            SeleccionarArchivo.addActionListener(this);

            lblFoto = new JLabel();
            lblFoto.setSize(100, 100);
            lblFoto.setLocation(250, 350);

            setLayout(null);
            Color c = new Color(60, 181, 41);
            getContentPane().setBackground(c);
            this.setSize(500,500);
            setLocationRelativeTo(null);
            add(nombreLugar);
            add(NombreLugar);
            add(Descripcion);
            add(descripcion);
            add(ok);
            add(SeleccionarArchivo);
            add(lblFoto);

    }

    public static VentanaAgregarLugares crear21() {
        if(regresar == null){
            regresar = new VentanaAgregarLugares();
        }
        return regresar;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(ok)) {
            ventanaNueva = new VentanaNueva();
            ventanaNueva.setVisible(true);
            this.setVisible(false);
            String nom = nombreLugar.getText();
            String des = descripcion.getText();
            String Archivo = "/Users/alejandrovalenciacastrillon/Downloads/ECOTURISTEA/src/Ventanas/LugaresAñadidos";
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(Archivo, true));

                writer.write(" Nombre del sitio: " + nom);
                writer.write(" Descripcion: " + des);
                writer.newLine();
                writer.close();
                nombreLugar.setText("");
                descripcion.setText("");
            } catch (IOException exception) {
                System.out.println("Error");
            }

        } else if (e.getSource().equals(SeleccionarArchivo)) {
            fileChooser = new JFileChooser();
            filtro = new FileNameExtensionFilter("Imágenes (PNG, JPEG, GIF)..",
                    "png", "jpeg", "jpg", "gif");
            fileChooser.setFileFilter(filtro);
            int resultado = fileChooser.showOpenDialog(null);

            if (resultado == JFileChooser.APPROVE_OPTION) {
                archivoSeleccionado = fileChooser.getSelectedFile();
                nombreArchivo = archivoSeleccionado.getName();

                try {
                    ImageIcon icon = new ImageIcon(archivoSeleccionado.toString());
                    lblFoto.setIcon(icon);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al cargar la imagen: " + ex.getMessage());

                }
            }
        }
    }

}
