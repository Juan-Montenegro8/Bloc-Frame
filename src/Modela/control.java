package Modela;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class control {
    
    public void abrir(JTextArea txtarea){
        JFileChooser FileCh = new JFileChooser();
        FileCh.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if(JFileChooser.APPROVE_OPTION==FileCh.showOpenDialog(txtarea)){
            File archivo = FileCh.getSelectedFile();
            FileReader lector;
            try {
                lector = new FileReader(archivo);
                BufferedReader reader = new BufferedReader(lector);
                String linea;
                while((linea = reader.readLine())!=null){
                   txtarea.setText(linea);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No");
            }
        }
    }
    public void guradr(JTextArea txtarea){
        JFileChooser FileCh = new JFileChooser();
        FileCh.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if(JFileChooser.APPROVE_OPTION==FileCh.showSaveDialog(txtarea)){
            File archivo = FileCh.getSelectedFile();
            FileWriter fichero ;
            String area= txtarea.getText();
            try {
                fichero = new FileWriter(archivo, true) ;
                fichero.write(area);
                fichero.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No");
            }
        }

    }
    public void imagen (JLabel lblarea, JTextField txtarea){
        JFileChooser FileCh = new JFileChooser();
        FileCh.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter formato = new FileNameExtensionFilter("JPG, PNG", "jpg", "png");
        
        FileCh.setFileFilter(formato);
        int respuesta;
        
        respuesta = FileCh.showOpenDialog(null);
        
        if(JFileChooser.APPROVE_OPTION==respuesta){
            File archivo=FileCh.getSelectedFile();
            txtarea.setText(archivo.getAbsolutePath());
            try {
                ImageIcon Imagen=new ImageIcon(archivo.toString());
                Icon icono=new ImageIcon(Imagen.getImage().getScaledInstance(lblarea.getWidth(), lblarea.getHeight(), Image.SCALE_DEFAULT));
                lblarea.setIcon(icono);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No");
            }
        }
    }
       
}
