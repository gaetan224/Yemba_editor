import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.text.*;


public class Correcteur extends JFrame implements Serializable{
	
	
	
	private static final long serialVersionUID = 1L;
	public ArrayList<String> l_mot;
	int compt=0, comptfinal=5;
	public String mess_aucun="Aucune suggestion";
	public Editor ed;
	
	
	
	public Correcteur(Editor c){
		l_mot=new ArrayList<String>();
		ed=c;
	}
  
  
  
  public ArrayList<String> insert_Mot(ArrayList<String> liste, String mot){
	  ArrayList<String> list=new ArrayList<String>();
	  int k=0;
	  int tt=liste.size();
	  while(k<tt && !mot.equals(liste.get(k))){
		  k++;
	  }
	  if(mot.equals(liste.get(k))) {liste.remove(k);}
	  liste.add(mot);
	  
	  compt++;
	  return list;
  }
  
  
  public ArrayList<String> mot_possible(String mot){
	  ArrayList<String> liste=Tous_Mot_Dict();
	 if(mot != null){
          int t=mot.length();
	  int nb=t,i=0,j=1;
	  String sous_chaine=new String();
	  while(nb>=2){
		  if(l_mot.size()>comptfinal){
			  break;
		  }
		  i=0;
		  j=nb;
		   while(j<=t){
				
			  if(l_mot.size()>comptfinal){
				  break;
			  }
			  sous_chaine=mot.substring(i,j);
			  liste=mot_dict_sc(liste, sous_chaine);
			  i++;
			  j++;
		  }
		  nb--;
	  }
	  return liste;
         }
        ArrayList<String> rt = new ArrayList<String>();
         return rt;
  }
  
  

public ArrayList<String> mot_dict_sc(ArrayList<String> l,String sc) {
	
	int k=0;
	while(k<l.size()){
		String mot=l.get(k);
		if(appartient(sc,mot)){
			if(l_mot.size()>comptfinal){
				  break;
			  }
			else{
				if(!l_mot.contains(mot))l_mot.add(mot);
			}
			
		}
		
		k++;
	}
	return l;
}

	


public boolean appartient(String sc, String mot) {
	boolean test=false;
	  mot=mot.concat(" ");
	  if(mot.indexOf(sc, 0)!=-1){
		  test=true;
	  }
	  
	return test;
}



public ArrayList<String> Tous_Mot_Dict(){
	ArrayList<String> liste=new ArrayList<String>();
	String url = "jdbc:hsqldb:data/DICO";
	String user = "sa";
	String passwd = "";
	Connection conn;
	try {
		Class.forName("org.hsqldb.jdbcDriver").newInstance();
		System.out.println("DRIVER OKsssssss ! ");
		System.out.println("DRIVER OKsssssss ! ");
		System.out.println("DRIVER OKsssssss ! ");
		System.out.println("DRIVER OKsssssss ! ");
		conn = DriverManager.getConnection(url, user, passwd);
		System.out.println("Connection effective !");			
		
		Statement state = conn.createStatement();

		ResultSet result = state.executeQuery("SELECT * FROM dictionnaire");
		while(result.next()){	
			liste.add(result.getObject(1).toString());
		}
		} 
	
	catch (Exception e) {
		e.printStackTrace();
	}		
	return liste;
}



public boolean test_mot_exist(String mot) {
	String url = "jdbc:hsqldb:data/DICO";
	String user = "sa";
	String passwd = "";

	boolean test=false;
	ArrayList<String> list=new ArrayList<String>();
	try{
		Class.forName("org.hsqldb.jdbcDriver").newInstance();
		System.out.println("DRIVER OKeeee ! ");
		Connection conn = DriverManager.getConnection(url, user, passwd);
		System.out.println("Connection effective !");			
		Statement state = conn.createStatement();
		ResultSet resul= state.executeQuery("SELECT * FROM dictionnaire");
		while(resul.next()){
			if(mot.equals(resul.getObject(1).toString())){
				test=true;
			}
		}
			
	}catch(Exception e){
	
	}
		return test;
}



public void ajout_mot(String mot) {
	ArrayList<String> liste=new ArrayList<String>();
	String url = "jdbc:hsqldb:data/DICO";
	String user = "sa";
	String passwd = "";
	if(!test_mot_exist(mot)){
	try {
		Class.forName("org.hsqldb.jdbcDriver").newInstance();
		System.out.println("DRIVER OKeeee ! ");
		Connection conn = DriverManager.getConnection(url, user, passwd);
		System.out.println("Connection effective !");			
		Statement state = conn.createStatement();
		state.executeUpdate("INSERT INTO dictionnaire (mot) VALUES ('"+mot+"')");
		JOptionPane.showMessageDialog(null, "mot enregistre avec succes", "Information", JOptionPane.INFORMATION_MESSAGE);
				
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	else{
		JOptionPane.showMessageDialog(null, "Ce mot existe deja dans notre base de bonnees", "Information", JOptionPane.INFORMATION_MESSAGE);
	}
	
}



public String[] affiche(ArrayList<String> a){
	String[] aa;
    /*    for(int i =0; i<a.size(); i++)
            System.out.println("possible  == "+(String)a.get(i));
           
            */
	String bon = new String();
	bon = ed.textPane.getSelectedText(); 
	int j = 0;
	if(a.size()>0){
	aa=new String[a.size()];
	for(int i=0; i<a.size(); i++){
		
		if(bon.charAt(0)== a.get(i).charAt(0) && bon.charAt(1)== a.get(i).charAt(1)) { aa[j]=a.get(i); j++;}else{
                aa[j]=a.get(i); j++;
                }
		System.out.println("eeeeeeeeeeeee: "+aa[i]+"  "+bon.charAt(0)+ " "+aa.length);
	}
	}
	else{
		aa=new String[1];
		aa[0]=mess_aucun;
	}
	return aa;
}
}

