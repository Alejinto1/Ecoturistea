package Interfazgrafica;

import unidad1.Registro;
import unidad1.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.channels.DatagramChannel;

public class frmIniciarSesion extends JFrame implements ActionListener {
    static frmRegistro ventanaRegistro;
    static frmMenuPrincipal Menu;
    static frmIniciarSesion frmInicio;
    static JLabel iniciarSesion, usuario, Contrasena;
    static JTextArea Usuario;
    static JButton Iniciar, Registrate,RecordarContra;
    static JPasswordField contrasena;
    static frmIniciarSesion regresar;
    static frmIniciarSesion regresar2;


    public frmIniciarSesion() {
        iniciarSesion = new JLabel("Iniciar Sesión");
        iniciarSesion.setSize(300, 100);
        iniciarSesion.setLocation(180, 10);
        iniciarSesion.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));

        usuario = new JLabel("Usuario");
        usuario.setSize(100, 100);
        usuario.setLocation(100, 60);
        usuario.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));

        Usuario = new JTextArea();
        Usuario.setSize(250, 20);
        Usuario.setLocation(100, 130);

        Contrasena = new JLabel("Contraseña");
        Contrasena.setSize(300, 100);
        Contrasena.setLocation(100, 130);
        Contrasena.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));

        contrasena = new JPasswordField();
        contrasena.setSize(250, 20);
        contrasena.setLocation(100, 200);

        RecordarContra = new JButton("Recordar contraseña");
        RecordarContra.setSize(160, 50);
        RecordarContra.setLocation(165, 260);
        RecordarContra.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        RecordarContra.addActionListener(this);

        //Registrate
        Registrate = new JButton("Registrate");
        Registrate.setSize(100, 50);
        Registrate.setLocation(250, 350);
        Registrate.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        Registrate.addActionListener(this);

        Iniciar = new JButton("Iniciar");
        Iniciar.setSize(100, 50);
        Iniciar.setLocation(130, 350);
        Iniciar.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        Iniciar.addActionListener(this);

        Usuario.setText("");
        contrasena.setText("");
        Color c = new Color(60, 181, 41);
        getContentPane().setBackground(c);

        setLayout(null);
        this.setSize(500, 600);
        setTitle("Ecoturistea");
        setLocationRelativeTo(null);
        add(iniciarSesion);
        add(usuario);
        add(Usuario);
        add(Contrasena);
        add(contrasena);
        add(Iniciar);
        add(Registrate);
        add(RecordarContra);
    }

    public static frmIniciarSesion crear6() {
        if (regresar == null) {
            regresar = new frmIniciarSesion();
        }
        return regresar;
    }

    public static frmIniciarSesion crear7() {
        if (regresar2 == null) {
            regresar2 = new frmIniciarSesion();
        }
        return regresar2;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(Registrate)) {
            ventanaRegistro = frmRegistro.crear();
            ventanaRegistro.setVisible(true);
            this.setVisible(false);
        } else if (e.getSource().equals(Iniciar)) {
            // Leer: Archivo Plano
            String nombreArchivo = "/Users/alejandrovalenciacastrillon/Downloads/ECOTURISTEA/src/unidad1/NombreContraseña.txt";
            String usuarioIngresado = Usuario.getText();
            String contrasenaIngresada = new String(contrasena.getPassword());

            try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
                String linea;
                boolean credencialesCorrectas = false;

                while ((linea = br.readLine()) != null) {
                    if (linea.contains("Nombre:") && linea.contains("Contraseña:")) {
                        int indiceInicioNombre = linea.indexOf("Nombre:") + 8; // Longitud de "Nombre:"
                        int indiceFinNombre = linea.indexOf("Contraseña:") - 1;
                        String nombreUsuario = linea.substring(indiceInicioNombre, indiceFinNombre).trim();

                        int indiceInicioContraseña = linea.indexOf("Contraseña:") + 12; // Longitud de "Contraseña:"
                        String contraseña = linea.substring(indiceInicioContraseña).trim();

                        // Verifica
                        if (nombreUsuario.equals(usuarioIngresado) && contraseña.equals(contrasenaIngresada)) {
                            credencialesCorrectas = true;
                            break;  // Salir del bucle si las credenciales son correctas
                        }
                    }
                }

                if (credencialesCorrectas) {
                    Menu = frmMenuPrincipal.crear();
                    Menu.setVisible(true);
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos", "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
                }

            } catch (IOException ec) {
                ec.printStackTrace();
            }
        } else if (e.getSource().equals(RecordarContra)) {
            String usuarioRecuperacion = JOptionPane.showInputDialog(this, "Ingrese su nombre de usuario o correo electrónico:");

            String nombreArchivo = "/Users/alejandrovalenciacastrillon/Downloads/ECOTURISTEA/src/unidad1/NombreContraseña.txt";

            try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
                String linea;
                boolean usuarioEncontrado = false;
                String contraseñaRecuperada = null;

                while ((linea = br.readLine()) != null) {
                    if (linea.contains("Nombre:") && linea.contains("Contraseña:")) {
                        int indiceInicioNombre = linea.indexOf("Nombre:") + 8;
                        int indiceFinNombre = linea.indexOf("Contraseña:") - 1;
                        String nombreUsuario = linea.substring(indiceInicioNombre, indiceFinNombre).trim();

                        int indiceInicioContraseña = linea.indexOf("Contraseña:") + 12;
                        String contraseña = linea.substring(indiceInicioContraseña).trim();

                        // Verifica si el nombre de usuario coincide con la recuperación
                        if (nombreUsuario.equals(usuarioRecuperacion)) {
                            usuarioEncontrado = true;
                            contraseñaRecuperada = contraseña;
                            break;
                        }
                    }
                }

                if (usuarioEncontrado) {
                    JOptionPane.showMessageDialog(this, "Tu contraseña es: " + contraseñaRecuperada, "Recuperación de Contraseña", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró el usuario", "Recuperación de Contraseña", JOptionPane.ERROR_MESSAGE);
                }

            } catch (IOException ec) {
                ec.printStackTrace();
            }

        }
    }
    public static void main (String[]args){
                frmInicio = new frmIniciarSesion();
                frmInicio.setVisible(true);
            }
}