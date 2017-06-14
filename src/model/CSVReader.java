/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Usuario
 */
public class CSVReader {

    private File file;
    private FileReader reader;
    private BufferedReader buffer;

    public CSVReader(File file) throws FileNotFoundException {
        this.file = file;
        this.reader = new FileReader(this.file);
        this.buffer = new BufferedReader(this.reader);
    }

    public String readRecord() throws IOException {
        if (!this.canRead()){
            this.iniciar();
        }
        return this.buffer.readLine();
    }
    
    public String readInicio() throws IOException {
        this.cerrar();
        this.iniciar();
        return this.buffer.readLine();
    }

    public String[] cleanRecord(String registro) throws IOException {
        String rs = registro;
        String[] aux = rs.split(",");
        return aux;
    }
    
    private boolean canRead() throws IOException {
        return this.buffer.ready();
    }

    public void cerrar() throws IOException {
        this.buffer.close();
        this.reader.close();
    }

    public boolean isListo() throws IOException {
        return this.buffer.ready();
    }

    private void iniciar() throws FileNotFoundException {
        this.buffer = new BufferedReader(new FileReader(this.file));
    }
}