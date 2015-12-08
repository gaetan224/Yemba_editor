


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * @author John Li
 *
 */

public class Open implements ActionListener, Serializable {
	
	public  JFileChooser fileChooser = new JFileChooser("YEMBA Editor");
	public File file;
	public monFiltre filtre;
	public Editor edit;
	public JButton but;
	public Fichier fic;
	public JMenuItem MI = new JMenuItem(); 
	
	public Open(Editor ed, JMenuItem me){
		
		this.edit = ed;
		this.file = ed.fichierCourant;
		this.filtre = ed.filter;
		this.MI = me;
		fileChooser.addChoosableFileFilter(filtre);
	}
	
    public Open(Editor ed, JButton bout){
		
    	        this.edit = ed;
		this.file = ed.fichierCourant;
		this.filtre = ed.filter;
		this.but = bout;
		fileChooser.addChoosableFileFilter(filtre);
	}
	
	
	
	public void actionPerformed(ActionEvent e){
		
		fileChooser.showOpenDialog(null);
		if (fileChooser.getSelectedFile() != null) {
			this.file = fileChooser.getSelectedFile();
			try {
				FileInputStream fis = new FileInputStream(this.file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				try {
					this.fic = (Fichier) ois.readObject();
					
					edit.textPane.setText(this.fic.chain);
                                        String tab[] =  file.toString().split("\\");
					edit.setTitle("Yemba Editor 5.0: "+tab[tab.length-1]);
                                        edit.titrefichier =tab[tab.length-1];
				   }catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					ois.close();
		   		       
			} catch (FileNotFoundException e1) {
		   		       e1.printStackTrace();
			} catch (IOException e1) {
		   		       e1.printStackTrace();
		   		      } 
		   		     }
		edit.fichierCourant = this.file;
					}
	

	}

