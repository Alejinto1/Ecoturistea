package Ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class VentanaNueva extends JFrame implements ActionListener {
    static VentanaNueva regresar;
    static JLabel agregarLugar,descripcion;
    static JTextField AgregarLugar;
    static JTextField Descripcion;
    static JButton anadir;
    static JTextArea areaTexto;


    public VentanaNueva() {

        agregarLugar = new JLabel("AGREGAR LUGAR: ");
        agregarLugar.setSize(300,100);
        agregarLugar.setLocation(10,20);
        agregarLugar.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        AgregarLugar = new JTextField();
        AgregarLugar.setSize(290,35);
        AgregarLugar.setLocation(200,54);

        descripcion = new JLabel("DESCRIPCION: ");
        descripcion.setSize(300,100);
        descripcion.setLocation(10,80);
        descripcion.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        Descripcion = new JTextField();
        Descripcion.setSize(290,100);
        Descripcion.setLocation(201, 100);

        anadir = new JButton("Añadir");
        anadir.setSize(100,40);
        anadir.setLocation(520,160);
        anadir.addActionListener(this);

        areaTexto = new JTextArea();
        areaTexto.setEditable(false);  // Para que el usuario no pueda editar el texto
        JScrollPane scrollPane = new JScrollPane(areaTexto);

        // Agrega el JScrollPane al JFrame
        add(scrollPane);

        // Configuración básica de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        setLayout(null);
        Color c = new Color(60, 181, 41);
        getContentPane().setBackground(c);

        add(agregarLugar);
        add(AgregarLugar);
        add(descripcion);
        add(Descripcion);
        add(anadir);
        add(areaTexto);
    }


    public static VentanaNueva crear20() {
        if (regresar == null) {
            regresar = new VentanaNueva();
        }
        return regresar;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(anadir)){
            String nom = AgregarLugar.getText();
            String des = Descripcion.getText();

            String Archivo = "/Users/alejandrovalenciacastrillon/Downloads/ECOTURISTEA/src/Ventanas/LugaresAñadidos";
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(Archivo,true));

                writer.write(" Nombre Del Parque " + nom);
                writer.write(" Descripcion: " + des );
                writer.newLine();
                AgregarLugar.setText("");
                Descripcion.setText("");
                writer.close();
            } catch (IOException exception) {
                System.out.println("Error");
            }

            String rutaArchivo = "/Users/alejandrovalenciacastrillon/Downloads/ECOTURISTEA/src/Ventanas/LugaresAñadidos";

            try {
                FileReader archivoLectura = new FileReader(rutaArchivo);
                BufferedReader lector = new BufferedReader(archivoLectura);
                String linea;
                while ((linea = lector.readLine()) != null) {
                    System.out.println(linea);
                }
                lector.close();

            } catch (IOException exe) {
                exe.printStackTrace();
            }
        }
        cargarContenidoArchivo("/Users/alejandrovalenciacastrillon/Downloads/ECOTURISTEA/src/Ventanas/LugaresAñadidos");

    }

    private void cargarContenidoArchivo(String rutaArchivo) {
        try (BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo))) {
            StringBuilder contenido = new StringBuilder();
            String linea;

            // Lee cada línea del archivo y agrega al StringBuilder
            while ((linea = lector.readLine()) != null) {
                contenido.append(linea).append("\n");
            }

            // Establece el contenido en el JTextArea
            areaTexto.setText(contenido.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
