import java.io.File;
import java.io.Serializable;

import javax.swing.filechooser.FileFilter;

class monFiltre extends FileFilter implements Serializable{

	public Editor edit;
	private static final long serialVersionUID = 6351238782001865785L;
	public String extension = "cam",
	description = "Editeur";

	public monFiltre(String ext, String descrip){
		this.extension = ext;
		this.description = descrip;
	}

	public monFiltre() {

	}

	public boolean accept(File file){
		return (file.isDirectory() || file.getName().endsWith(this.extension));
	}

	public String getDescription(){
		return this.extension + " - " + this.description;
	}	
	

}