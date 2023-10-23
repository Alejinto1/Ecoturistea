package Ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaNueva extends JFrame implements ActionListener {
    static VentanaNueva regresar;
    static JButton AgregarLugar;
    static VentanaAgregarLugares ventanaAgregarLugares;

    public VentanaNueva(){
        AgregarLugar = new JButton("Añadir Lugar");
        AgregarLugar.setSize(140, 50);
        AgregarLugar.setLocation(800, 30);
        AgregarLugar.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        AgregarLugar.addActionListener(this);


        setLayout(null);
        this.setSize(1000,1000);
        setLocationRelativeTo(null);
        Color c = new Color(60, 181, 41);
        getContentPane().setBackground(c);
        //ADDS
        add(AgregarLugar);
    }

    public static VentanaNueva crear20() {
        if (regresar == null){
            regresar = new VentanaNueva();
        }
        return regresar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(AgregarLugar)){
            ventanaAgregarLugares = VentanaAgregarLugares.crear21();
            ventanaAgregarLugares.setVisible(true);
            this.setVisible(false);
            }
        }
}
