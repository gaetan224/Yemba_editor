import java.io.Serializable;

import javax.swing.JTextPane;
/**
 * classe permettant de forme les objets a etre enregistre ceci permet de garder les caractere speciaux
 * qui sont enregistés en tant que objet non pas comme des strings simples.
 */

@SuppressWarnings("serial")
class yemb implements Serializable{
	public JTextPane tA;

	public yemb(JTextPane tA){
		this.tA=tA;
	}
	public String toString(){
		return tA.getText();
	}
	public void setText(String t){
		tA.setText(t);
	}
}
