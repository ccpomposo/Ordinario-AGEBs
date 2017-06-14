/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import model.CSVReader;
import model.Cola;
import model.ListaDoble;
import model.Poligono;
import model.Punto;
import model.Registro;

/**
 *
 * @author Usuario
 */
public class Controlador {

    private static final String BASE_HTML = "<!DOCTYPE html>\n"
            + "<html>\n"
            + "  <head>\n"
            + "    <meta name=\"viewport\" content=\"initial-scale=1.0, user-scalable=no\">\n"
            + "    <meta charset=\"utf-8\">\n"
            + "    <title>Simple Polygon</title>\n"
            + "    <style>\n"
            + "      /* Always set the map height explicitly to define the size of the div\n"
            + "       * element that contains the map. */\n"
            + "      #map {\n"
            + "        height: 100%;\n"
            + "      }\n"
            + "      /* Optional: Makes the sample page fill the window. */\n"
            + "      html, body {\n"
            + "        height: 100%;\n"
            + "        margin: 0;\n"
            + "        padding: 0;\n"
            + "      }\n"
            + "      .controls {\n"
            + "        margin-top: 10px;\n"
            + "        border: 1px solid transparent;\n"
            + "        border-radius: 2px 0 0 2px;\n"
            + "        box-sizing: border-box;\n"
            + "        -moz-box-sizing: border-box;\n"
            + "        height: 32px;\n"
            + "        outline: none;\n"
            + "        box-shadow: 0 2px 6px rgba(0, 0, 0, 0.3);\n"
            + "      }\n"
            + "\n"
            + "      #pac-input {\n"
            + "        background-color: #fff;\n"
            + "        font-family: Roboto;\n"
            + "        font-size: 15px;\n"
            + "        font-weight: 300;\n"
            + "        margin-left: 12px;\n"
            + "        padding: 0 11px 0 13px;\n"
            + "        text-overflow: ellipsis;\n"
            + "        width: 300px;\n"
            + "      }\n"
            + "\n"
            + "      #pac-input:focus {\n"
            + "        border-color: #4d90fe;\n"
            + "      }\n"
            + "\n"
            + "      .pac-container {\n"
            + "        font-family: Roboto;\n"
            + "      }\n"
            + "\n"
            + "      #type-selector {\n"
            + "        color: #fff;\n"
            + "        background-color: #4d90fe;\n"
            + "        padding: 5px 11px 0px 11px;\n"
            + "      }\n"
            + "\n"
            + "      #type-selector label {\n"
            + "        font-family: Roboto;\n"
            + "        font-size: 13px;\n"
            + "        font-weight: 300;\n"
            + "      }\n"
            + "      #target {\n"
            + "        width: 345px;\n"
            + "      }"
            + "    </style>\n"
            + "  </head>\n"
            + "  <body>\n"
            + "<input id=\"pac-input\" class=\"controls\" type=\"text\" placeholder=\"Buscar\">\n"
            + "    <div id=\"map\"></div>\n"
            + "    <script>\n"
            + "\n"
            + "      // This example creates a simple polygon representing the Bermuda Triangle.\n"
            + "\n"
            + "      function initMap() {\n"
            + "        var map = new google.maps.Map(document.getElementById('map'), {\n"
            + "          zoom: 14,\n"
            + "          center: {lat: 16.952770, lng: -96.754805},\n"
            + "          mapTypeId: 'roadmap'\n"
            + "        });\n"
            + "\n"
            + "var input = document.getElementById('pac-input');\n"
            + "        var searchBox = new google.maps.places.SearchBox(input);\n"
            + "        map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);\n"
            + "\n"
            + "        // Bias the SearchBox results towards current map's viewport.\n"
            + "        map.addListener('bounds_changed', function() {\n"
            + "          searchBox.setBounds(map.getBounds());\n"
            + "        });\n"
            + "\n"
            + "        var markers = [];\n"
            + "        // Listen for the event fired when the user selects a prediction and retrieve\n"
            + "        // more details for that place.\n"
            + "        searchBox.addListener('places_changed', function() {\n"
            + "          var places = searchBox.getPlaces();\n"
            + "\n"
            + "          if (places.length == 0) {\n"
            + "            return;\n"
            + "          }\n"
            + "\n"
            + "          // Clear out the old markers.\n"
            + "          markers.forEach(function(marker) {\n"
            + "            marker.setMap(null);\n"
            + "          });\n"
            + "          markers = [];\n"
            + "\n"
            + "          // For each place, get the icon, name and location.\n"
            + "          var bounds = new google.maps.LatLngBounds();\n"
            + "          places.forEach(function(place) {\n"
            + "            if (!place.geometry) {\n"
            + "              console.log(\"Returned place contains no geometry\");\n"
            + "              return;\n"
            + "            }\n"
            + "            var icon = {\n"
            + "              url: place.icon,\n"
            + "              size: new google.maps.Size(71, 71),\n"
            + "              origin: new google.maps.Point(0, 0),\n"
            + "              anchor: new google.maps.Point(17, 34),\n"
            + "              scaledSize: new google.maps.Size(25, 25)\n"
            + "            };\n"
            + "\n"
            + "            // Create a marker for each place.\n"
            + "            markers.push(new google.maps.Marker({\n"
            + "              map: map,\n"
            + "              icon: icon,\n"
            + "              title: place.name,\n"
            + "              position: place.geometry.location\n"
            + "            }));\n"
            + "\n"
            + "            if (place.geometry.viewport) {\n"
            + "              // Only geocodes have viewport.\n"
            + "              bounds.union(place.geometry.viewport);\n"
            + "            } else {\n"
            + "              bounds.extend(place.geometry.location);\n"
            + "            }\n"
            + "          });\n"
            + "          map.fitBounds(bounds);\n"
            + "        });\nvar i;\n";

    private static final String FIN_HTML = "}</script>\n"
            + "    <script async defer\n"
            + "    src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyDfA1Z216LkInfn3Xg-ERtQ5-U4HKeaBxM&libraries=places&callback=initMap\">\n"
            + "    </script>\n"
            + "  </body>\n"
            + "</html>";

    private static Double CONVERT_X = 0d, CONVERT_Y = 0d;
    private CSVReader reader;
    private ListaDoble poligonos;

    public Controlador(File file) throws FileNotFoundException {

        this.reader = new CSVReader(file);
        this.poligonos = new ListaDoble();
    }

    public String generarHTML() throws IOException {
        this.crearPoligonos();
        String rs = BASE_HTML;
        String nombre;
        String aux;
        String aux2;
        for (Object poligono : this.poligonos) {
            nombre = ((Poligono) poligono).getNombre();
            //System.out.println(nombre);
            aux = String.format("var %sCoords = %s var %s =  new google.maps.Polygon({%npaths: %sCoords,%nstrokeColor: '#FF0000',%nstrokeOpacity: 0.8,%nstrokeWeight: 2,%nfillColor: '#FF0000',%nfillOpacity: 0.35%n});%n%s.setMap(map);%n",
                    nombre, ((Poligono) poligono).toString(), nombre, nombre, nombre);
            rs += aux;
            aux2 = String.format("var %sMarker = new google.maps.Marker({position: %sCoords[0],map: map, title: '%s'});%n",
                    nombre,nombre,nombre);
            rs += aux2;
        }
        rs += FIN_HTML;
        return rs;
    }

    private void crearPoligonos() throws IOException {
        Cola cola = new Cola();
        this.reader.readInicio();
        while (this.reader.isListo()) {
            String lala = this.reader.readRecord();
            cola.insertar(new Registro(this.reader.cleanRecord(lala)));
            //System.out.println(lala);
        }
        this.reader.cerrar();
        Registro rcd;
        String nombre;
        String auxNombre = "AGEB200230001006A";//Cambiar
        Poligono p = new Poligono(auxNombre);
        while (!cola.isVacia()) {
            rcd = (Registro) cola.quitar();
            nombre = rcd.getNombre();
            if (nombre.compareTo(auxNombre) == 0) {
                p.addPunto(new Punto(Double.valueOf(rcd.getCoordX()) - CONVERT_X, Double.valueOf(rcd.getCoordY()) - CONVERT_Y));
            } else {
                this.poligonos.insertarFinal(p);
                auxNombre = rcd.getNombre();
                p = new Poligono(auxNombre);
                p.addPunto(new Punto(Double.valueOf(rcd.getCoordX()) - CONVERT_X, Double.valueOf(rcd.getCoordY()) - CONVERT_Y));
            }
        }
    }
}