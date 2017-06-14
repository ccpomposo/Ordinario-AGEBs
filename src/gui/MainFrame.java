/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;
import controller.Controlador;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Usuario
 */
public class MainFrame extends JFrame{

    private Browser browser;
    private BrowserView brwView;
    private Controlador controlador;
    private JPanel pnlCentro;
    private JButton btnTest;
    
    public MainFrame() {
        super("AGEBsTools v1.0");
        super.setLayout(new BorderLayout());
        super.setSize(700,500);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pnlCentro = new JPanel();
        JLabel lblMensaje = new JLabel("¡Bienvenido a AGEBsTools v1.0");
        lblMensaje.setFont(new Font("Arial Bold", Font.BOLD, 20));
        this.pnlCentro.add(lblMensaje);
        super.setJMenuBar(this.crearMenu());
        super.add(this.pnlCentro);
        this.btnTest = new JButton("Cargar archivo...");
        btnTest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    cargarMapa();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(MainFrame.this, "¡No se puede cargar el mapa!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        super.add(btnTest,BorderLayout.SOUTH);
        super.setVisible(true);
    }
    
    private void cargarMapa() throws FileNotFoundException, IOException {
        JFileChooser fchChooser= new JFileChooser();
        fchChooser.showOpenDialog(this);
        this.controlador = new Controlador(fchChooser.getSelectedFile());
        this.browser = new Browser();
        this.brwView = new BrowserView(browser);
        String aux = this.controlador.generarHTML();
        this.browser.loadHTML(aux);
        System.out.println(aux);
        super.remove(this.pnlCentro);
        super.remove(this.btnTest);
        super.add(this.brwView);
        //super.pack();
        super.revalidate();
    }
    
    private JMenuBar crearMenu() {
        JMenuBar mnbBarra = new JMenuBar();
        JMenu mnArchivo = new JMenu("Archivo");
        JMenuItem mniCargar = new JMenuItem("Cargar archivo...");
        mniCargar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    cargarMapa();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(MainFrame.this, "¡No se puede cargar el mapa!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        JMenuItem mniSalir = new JMenuItem("Salir");
        mniSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        JMenu mnAyuda = new JMenu("Ayuda");
        JMenuItem mniAbout = new JMenuItem("Acerca de...");
        mniAbout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JOptionPane.showMessageDialog(MainFrame.this,String.format("AGEBsTools v1.0%nDesarrollado por: César Cruz Pomposo%n14/06/2017"));
            }
        });
        
        mnArchivo.add(mniCargar);
        mnArchivo.addSeparator();
        mnArchivo.add(mniSalir);
        
        mnAyuda.add(mniAbout);
        
        mnbBarra.add(mnArchivo);
        mnbBarra.add(mnAyuda);
        
        return mnbBarra;
    }
}

class Test {

    public static void main(String[] args) {
//        Browser browser = new Browser();
//        BrowserView view = new BrowserView(browser);
//        
//        JFrame frame = new JFrame("JxBrowser Google Maps En Java");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.add(view, BorderLayout.CENTER);
//        frame.setSize(700, 500);
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);
//        browser.loadHTML("<!DOCTYPE html>\n" +
//"<html>\n" +
//"  <head>\n" +
//"    <meta name=\"viewport\" content=\"initial-scale=1.0, user-scalable=no\">\n" +
//"    <meta charset=\"utf-8\">\n" +
//"    <title>Simple Polygon</title>\n" +
//"    <style>\n" +
//"      /* Always set the map height explicitly to define the size of the div\n" +
//"       * element that contains the map. */\n" +
//"      #map {\n" +
//"        height: 100%;\n" +
//"      }\n" +
//"      /* Optional: Makes the sample page fill the window. */\n" +
//"      html, body {\n" +
//"        height: 100%;\n" +
//"        margin: 0;\n" +
//"        padding: 0;\n" +
//"      }\n" +
//"    </style>\n" +
//"  </head>\n" +
//"  <body>\n" +
//"    <div id=\"map\"></div>\n" +
//"    <script>\n" +
//"\n" +
//"      // This example creates a simple polygon representing the Bermuda Triangle.\n" +
//"\n" +
//"      function initMap() {\n" +
//"        var map = new google.maps.Map(document.getElementById('map'), {\n" +
//"          zoom: 9,\n" +
//"          center: {lat: 17.1167, lng: -97.6667},\n" +
//"          mapTypeId: 'roadmap'\n" +
//"        });\n" +
//"\n" +
//"        // Define the LatLng coordinates for the polygon's path.\n" +
//"        var triangleCoords = [\n" +
//"          {lat: 25.774, lng: -80.190},\n" +
//"          {lat: 18.466, lng: -66.118},\n" +
//"          {lat: 32.321, lng: -64.757},\n" +
//"          {lat: 25.774, lng: -80.190}\n" +
//"        ];\n" +
//"\n" +
//"        // Construct the polygon.\n" +
//"        var bermudaTriangle = new google.maps.Polygon({\n" +
//"          paths: triangleCoords,\n" +
//"          strokeColor: '#FF0000',\n" +
//"          strokeOpacity: 0.8,\n" +
//"          strokeWeight: 2,\n" +
//"          fillColor: '#FF0000',\n" +
//"          fillOpacity: 0.35\n" +
//"        });\n" +
//"        bermudaTriangle.setMap(map);\n" +
//"      }\n" +
//"    </script>\n" +
//"    <script async defer\n" +
//"    src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyDfA1Z216LkInfn3Xg-ERtQ5-U4HKeaBxM&callback=initMap\">\n" +
//"    </script>\n" +
//"  </body>\n" +
//"</html>");    
        new MainFrame();
    }
}
