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
    
    public void abrir(JTextArea area){
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if(JFileChooser.APPROVE_OPTION==fc.showOpenDialog(area)){
            File archivo = fc.getSelectedFile();
            FileReader lector;
            try {
                lector = new FileReader(archivo);
                BufferedReader br = new BufferedReader(lector);
                String linea;
                while((linea = br.readLine())!=null){
                   area.setText(linea);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No");
            }
        }
    }
    public void guradr(JTextArea area){
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if(JFileChooser.APPROVE_OPTION==fc.showSaveDialog(area)){
            File archivo = fc.getSelectedFile();
            FileWriter fichero ;
            String jaja= area.getText();
            try {
                fichero = new FileWriter(archivo, true) ;
                fichero.write(jaja);
                fichero.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No");
            }
        }

    }
    public void imagen (JLabel area, JTextField j){
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter formato = new FileNameExtensionFilter("JPG, PNG", "jpg", "png");
        
        fc.setFileFilter(formato);
        int res;
        
        res = fc.showOpenDialog(null);
        
        if(JFileChooser.APPROVE_OPTION==res){
            File archivo=fc.getSelectedFile();
            j.setText(archivo.getAbsolutePath());
            try {
                ImageIcon i=new ImageIcon(archivo.toString());
                Icon icono=new ImageIcon(i.getImage().getScaledInstance(area.getWidth(), area.getHeight(), Image.SCALE_DEFAULT));
                area.setIcon(icono);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No");
            }
        }
    }
       
}
