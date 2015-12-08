import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JTextPane;
/**
 * classe permettant de forme les objets a etre enregistre ceci permet de garder les caractere speciaux
 * qui sont enregistés en tant que objet non pas comme des strings simples.
 */

@SuppressWarnings("serial")
class Fichier implements Serializable{
	public String chain;
	
	public Fichier(String s){
		this.chain=s;
	}

	
}
