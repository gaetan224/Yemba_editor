import java.io.Serializable;
import java.util.ArrayList;


public class ObjetUtile implements Serializable{

	public  ArrayList<String> ListePolice = new ArrayList<String>();

	public ObjetUtile(){
		ListePolice.add("Arial");
                //nouveau
                ListePolice.add("Algerian");                
                ListePolice.add("Bradley hand ITC");
                ListePolice.add("Broadway");
                ListePolice.add("Castellar");
                ListePolice.add("Curlz MT");
                ListePolice.add("Goudy Stout");
                ListePolice.add("Harlow Solid Italic");
                ListePolice.add("Jokerman");
                ListePolice.add("Kalinga");
                ListePolice.add("Kartika");
                ListePolice.add("Mistral");
                ListePolice.add("Monotype Corsiva");
                //fin nouveau
		ListePolice.add("Verdana");
		ListePolice.add("Calibri");
		ListePolice.add("Times New Roman");
		ListePolice.add("Comic Sans MS");
		ListePolice.add("Copperplate Gothic Bold");
		ListePolice.add("Constantia");
		
	}

}
