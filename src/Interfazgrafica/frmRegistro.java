package Interfazgrafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class frmRegistro extends JFrame implements ActionListener {
    static frmIniciarSesion guardarInfo;
    static frmRegistro ventanaRegistro;
    JLabel registrarte, nombreUsuario, email, password, edad, pais;
    static JTextField NombreUsuario;
    static JTextField Email;
    static JTextField Edad;
    static JPasswordField Password;
    static JComboBox<String> Pais;
    JButton Registrarme, btnRegistro;

    public static frmRegistro crear() {
        if (ventanaRegistro == null) {
            ventanaRegistro = new frmRegistro();
        }
        return ventanaRegistro;
    }

    private frmRegistro() {

        //Registrarse
        registrarte = new JLabel("Registrate");
        registrarte.setSize(300, 100);
        registrarte.setLocation(200, 0);
        registrarte.setFont(new Font("PT Serif", Font.ITALIC, 20));
        //NombreUsuario
        nombreUsuario = new JLabel("Usuario");
        nombreUsuario.setSize(300, 100);
        nombreUsuario.setLocation(30, 60);
        nombreUsuario.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        //Texto Nombre Usuario
        NombreUsuario = new JTextField();
        NombreUsuario.setSize(200, 20);
        NombreUsuario.setLocation(120, 102);
        //Email
        email = new JLabel("Email");
        email.setSize(300, 100);
        email.setLocation(30, 100);
        email.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        //Texto Email
        Email = new JTextField();
        Email.setSize(200, 20);
        Email.setLocation(120, 140);
        //Password
        password = new JLabel("Contraseña");
        password.setSize(300, 100);
        password.setLocation(30, 140);
        password.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        //Texto Password
        Password = new JPasswordField();
        Password.setSize(200, 20);
        Password.setLocation(120, 180);
        //Edad
        edad = new JLabel("Edad");
        edad.setSize(300, 100);
        edad.setLocation(30, 180);
        edad.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        //Texto Edad
        Edad = new JTextField(2);
        Edad.setSize(200, 20);
        Edad.setLocation(120, 220);
        //Pais
        pais = new JLabel("Pais");
        pais.setSize(300, 100);
        pais.setLocation(30, 220);
        pais.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        //Opcion Pais
        Pais = new JComboBox<String>();
        Pais.addItem("Colombia");
        Pais.addItem("Venezuela");
        Pais.addItem("Chile");
        Pais.addItem("Argentina");
        Pais.addItem("Bolivia");
        Pais.addItem("Ecuador");
        Pais.addItem("Perú");
        Pais.addItem("Guayana");
        Pais.addItem("Uruguay");
        Pais.addItem("Brasil");
        Pais.setSize(200, 200);
        Pais.setLocation(120, 170);
        //Registrarme
        Registrarme = new JButton("Regresar");
        Registrarme.setSize(140, 40);
        Registrarme.setLocation(100, 350);
        Registrarme.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        Registrarme.addActionListener(this);
        //Registro
        btnRegistro = new JButton("Registrate");
        btnRegistro.setSize(140, 40);
        btnRegistro.setLocation(250, 350);
        btnRegistro.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        btnRegistro.addActionListener(this);


        //INTERFAZ
        setLayout(null);
        this.setSize(500, 600);
        setLocationRelativeTo(null);
        setTitle("Registro");
        Color c = new Color(60, 181, 41);
        getContentPane().setBackground(c);
        //ADD
        add(registrarte);
        add(nombreUsuario);
        add(NombreUsuario);
        add(email);
        add(Email);
        add(password);
        add(Password);
        add(edad);
        add(Edad);
        add(pais);
        add(Pais);
        add(Registrarme);
        add(btnRegistro);


    }

    public void actionPerformed(ActionEvent exepcion) {
        if (exepcion.getSource().equals(Registrarme)) {

            guardarInfo = frmIniciarSesion.crear7();
            frmIniciarSesion.frmInicio.setVisible(true);
            this.setVisible(false);


            //Boton registro
        } else if (exepcion.getSource().equals(btnRegistro)) {

            frmIniciarSesion.frmInicio.setVisible(true);
            this.setVisible(false);
            JFrame jFrame = new JFrame("Registro exitoso");
            JOptionPane.showMessageDialog(jFrame, "Registro exitoso");
            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jFrame.setSize(300, 200);
            jFrame.setVisible(true);
            jFrame.setVisible(false);

            String nom = NombreUsuario.getText();
            String email = Email.getText();
            String pass = Password.getText();
            String edad = Edad.getText();
            String pais = Pais.getSelectedItem().toString();

            String rutaArchivo = "/Users/alejandrovalenciacastrillon/Downloads/ECOTURISTEA/src/unidad1/Usuarios.txt";
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo,true));

                writer.write(" Nombre: " + nom);
                writer.write(" Email: " + email);
                writer.write(" Edad: " + edad);
                writer.write(" Pais: " + pais);
                writer.write(" Contraseña: " + pass);
                writer.newLine();
                NombreUsuario.setText("");
                Password.setText("");
                Email.setText("");
                Edad.setText("");

                writer.close();
            } catch (IOException exception) {
                System.out.println("Error");
            }

            String Archivo = "/Users/alejandrovalenciacastrillon/Downloads/ECOTURISTEA/src/unidad1/NombreContraseña.txt";
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(Archivo,true));

                writer.write(" Nombre: " + nom);
                writer.write(" Contraseña: " + pass );
                writer.newLine();
                NombreUsuario.setText("");
                Password.setText("");
                writer.close();
            } catch (IOException exception) {
                System.out.println("Error");
            }
        }
    }
}
