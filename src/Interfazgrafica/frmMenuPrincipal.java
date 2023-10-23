package Interfazgrafica;

import Ventanas.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmMenuPrincipal extends JFrame implements ActionListener {
    static frmMenuPrincipal regresar;
    static frmMenuPrincipal frmInicio;
    static VentanaImagen1 img1;
    static VentanaImagen2 img2;
    static VentanaImagen3 img3;
    static VentanaImagen4 img4;
    static frmIniciarSesion salir;
    static frmMenuPrincipal ventanaRegistro;
    static JLabel titulo, parqueExplora,jardinBotanico,parqueArvi,cerro;
    static JButton btnimagen,btnimagen1,btnimagen2,btnimagen3,btnsalir,AgregarLugar;
    static VentanaNueva agregarLugares;

    public frmMenuPrincipal() {
        AgregarLugar = new JButton("Añadir Lugar");
        AgregarLugar.setSize(140, 50);
        AgregarLugar.setLocation(800, 30);
        AgregarLugar.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        AgregarLugar.addActionListener(this);

        //Titulo ECOTURISTEA
        titulo = new JLabel("ECOTURISTEA");
        titulo.setSize(300, 100);
        titulo.setLocation(440, 10);
        titulo.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        //Parque explora
        parqueExplora = new JLabel("Parque explora");
        parqueExplora.setSize(300, 100);
        parqueExplora.setLocation(120, 100);
        parqueExplora.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        //Imagen Parque explora
        btnimagen = new JButton(new ImageIcon("/Users/alejandrovalenciacastrillon/Downloads/ECOTURISTEA/src/Imagenes/image 1.png"));
        btnimagen.setLocation(100, 200);
        btnimagen.setSize(200, 200);
        btnimagen.addActionListener(this);
        //Jardín Botánico
        jardinBotanico = new JLabel("Jardin Botánico");
        jardinBotanico.setSize(300,150);
        jardinBotanico.setLocation(680,80);
        jardinBotanico.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        //Imagen Jardín Botánico
        btnimagen1 = new JButton(new ImageIcon("/Users/alejandrovalenciacastrillon/Downloads/ECOTURISTEA/src/Imagenes/image 3.png"));
        btnimagen1.setLocation(660, 200);
        btnimagen1.setSize(200, 200);
        btnimagen1.addActionListener(this);
        //Parque Arvi
        parqueArvi = new JLabel("Parque Arvi");
        parqueArvi.setSize(300,100);
        parqueArvi.setLocation(130,500);
        parqueArvi.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        //Imagen Parque Arvi
        btnimagen2= new JButton(new ImageIcon("/Users/alejandrovalenciacastrillon/Downloads/ECOTURISTEA/src/Imagenes/image 2.png"));
        btnimagen2.setLocation(100, 600);
        btnimagen2.setSize(200, 200);
        btnimagen2.addActionListener(this);
        //Cerro De Las Tres Cruces
        cerro = new JLabel("Cerro de las tres Cruces");
        cerro.setSize(300,100);
        cerro.setLocation(650,500);
        cerro.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        //Imagen cerro
        btnimagen3 = new JButton(new ImageIcon("/Users/alejandrovalenciacastrillon/Downloads/ECOTURISTEA/src/Imagenes/image 4.png"));
        btnimagen3.setSize(200,200);
        btnimagen3.setLocation(660,600);
        btnimagen3.addActionListener(this);
        //Salir
        btnsalir = new JButton("Salir");
        btnsalir.setSize(80,50);
        btnsalir.setLocation(900,850);
        btnsalir.addActionListener(this);
        //ADDS
        add(titulo);
        add(parqueExplora);
        add(btnimagen);
        add(jardinBotanico);
        add(btnimagen1);
        add(parqueArvi);
        add(btnimagen2);
        add(cerro);
        add(btnimagen3);
        add(btnsalir);
        add(AgregarLugar);
        //Pantalla
        setLayout(null);
        this.setSize(1000, 1000);
        setLocation(400, 250);
        Color c = new Color(60, 181, 41);
        getContentPane().setBackground(c);

    }

    //Crear
    public static frmMenuPrincipal crear() {
        if (ventanaRegistro == null) {
            ventanaRegistro = new frmMenuPrincipal();
        }
        return ventanaRegistro;
    }

    public static void main(String[] args) {
        frmMenuPrincipal menu = new frmMenuPrincipal();
        menu.setVisible(false);

        frmInicio = new frmMenuPrincipal();
        frmInicio.setVisible(true);
    }

    public static frmMenuPrincipal crear1() {
        if (regresar == null) {
            regresar = new frmMenuPrincipal();
        }
        return regresar;
    }

    public static frmMenuPrincipal crear4() {
        if (regresar == null){
            regresar = new frmMenuPrincipal();
        }
        return regresar;
    }

    public static frmMenuPrincipal crear5() {
        if(regresar == null){
            regresar = new frmMenuPrincipal();
        }
        return regresar;
    }

    public static frmMenuPrincipal crear6() {
        if(regresar == null){
            regresar = new frmMenuPrincipal();
        }
        return regresar;
    }
    //Acciones de Botones
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnimagen)) {
            img1 = VentanaImagen1.crear();
            img1.setVisible(true);
            this.setVisible(false);
        }
        else if (e.getSource().equals(btnimagen1)) {
            img2 = VentanaImagen2.crear3();
            img2.setVisible(true);
            this.setVisible(false);
        }
        else if(e.getSource().equals(btnimagen2)){
            img3 = VentanaImagen3.crear4();
            img3.setVisible(true);
            this.setVisible(false);
        } else if (e.getSource().equals(btnimagen3)) {
            img4 = VentanaImagen4.crear5();
            img4.setVisible(true);
            this.setVisible(false);

        }
        else if (e.getSource().equals(AgregarLugar)){
            agregarLugares = VentanaNueva.crear20();
            agregarLugares.setSize(1000,1000);
            agregarLugares.setLocationRelativeTo(null);
            agregarLugares.setTitle("Agregar");
            agregarLugares.setVisible(true);
            this.setVisible(false);
        }
        else if(e.getSource().equals(btnsalir)){
            salir = frmIniciarSesion.crear6();
            salir.setVisible(true);
            this.setVisible(false);
        }

    }


}
