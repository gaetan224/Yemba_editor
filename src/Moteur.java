import java.awt.Color;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.text.StyleConstants; 
import org.hsqldb.result.ResultMetaData;

public class Moteur implements KeyListener{


	public Editor editeur;
	public int deb=0,fin=0 ,q=0,start=0,end=0,i=1;;
	public boolean bool = false;
	public Correcteur cor;
	public String mots = " ";
	
	
	
	public Moteur(Editor editor, Correcteur corr) {
		editeur=editor;
	}

	public void keyPressed(KeyEvent arg0) {
        
        
        
        }
	
			public void keyReleased(KeyEvent arg0) {
                            	fin = editeur.textPane.getCaretPosition();
                               
				start = editeur.textPane.getSelectionStart();
				end = editeur.textPane.getSelectionEnd();
				
				if(fin==0 || start==0 || end==0)deb=0;
				
				switch (arg0.getKeyCode()) {

				//si le touche saisie est "espace"
				case KeyEvent.VK_SPACE :{
                                  						
					String st=editeur.textPane.getText();
					String ng=st.substring(0, 1);
					String str=st.substring(0, 1);
					while(ng.hashCode()==0 || ng.hashCode()==32){
						ng=st.substring(i, i+1);
						str=st.substring(0, i+1);
						i++;
					}
					if(q==0 || deb==0){
						
						String sg=st.substring(i, st.length());
						str=str.toUpperCase();
						str=str.concat(sg);
						editeur.textPane.setText(str);
						q++;
					    deb++;
						i=1;
					}
					mot_errone();
				}break;

				//si la touche saisie est "enter"
				case KeyEvent.VK_ENTER :{
					
					
                                
                                         if(editeur.puce.isSelected()){
					
					String st1=editeur.textPane.getText();
					
					String str1=st1.substring(0, deb);
					String sg1=st1.substring(deb, st1.length());

                                    editeur.textPane.setText(str1+""+sg1);
                                    String sg2=str1+""+sg1+"";
                                                deb++;
						q++;
						
					
                                      editeur.textPane.setText(sg2+editeur.ppuce.getText()+"\t\t");
                                                deb++;
                                                 q++;
						
					}
                                
                                
                                
                                
                                }
					
				} 
				
			}
			public void keyTyped(KeyEvent arg0) {}
			
			
			public void mot_errone(){
				String[] st = editeur.textPane.getText().split(" ");

				for(int i=0; i<st.length;i++){
					if(!test_mot_exist(st[i])){
                                            
                                            editeur.Erreur.setText(editeur.Erreur.getText()+" "+st[i]);
                                        
                                        }
				}
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
                                        PreparedStatement pre = conn.prepareStatement("SELECT * FROM dictionnaire WHERE MOT = ?");
                                        pre.setString(1, mot);
                                        ResultSet res = pre.executeQuery();
                                        if(res.next()){ test = true;}
                                        
                                                       
                                        
                                        
				}catch(Exception e){
				
				}
					return test;
			}
	} 

