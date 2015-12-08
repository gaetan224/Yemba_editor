import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class Raccourci  implements ActionListener, Serializable{

	/**
	 * 
	 */
	public static final long serialVersionUID = 8266823794956117680L;
	JButton [] tab ;
	JPanel panoletter;
	Editor edite;

	public Raccourci(Editor editeur){

		edite = editeur;
		
		tab = new JButton[48];
		
		tab[0]=new  JButton("à"); 
		tab[0].setMnemonic('0');
		tab[0].setEnabled(true);
	    
		tab[1]=new  JButton("\u0106");
		tab[1].setMnemonic('1');
		tab[1].setEnabled(true);
	    
		tab[2]=new  JButton("\u0112");
		tab[2].setMnemonic('2');
		
		tab[3]=new  JButton("\u0101"); 
		tab[3].setMnemonic('a');
		
		tab[4]=new  JButton("\u0107");
		tab[4].setMnemonic('z');
		
		tab[5]=new  JButton("\u0129");
		tab[5].setMnemonic('i');
		
		tab[6]=new  JButton("\u0143");
		tab[6].setMnemonic('3');
		
		tab[7]=new  JButton("\u012A");
		tab[7].setMnemonic('4');
		
		tab[8]=new  JButton("\u012B");
		tab[8].setMnemonic('t');
		
		tab[9]=new  JButton("\u0113");
		tab[9].setMnemonic('e');

		tab[10]=new  JButton("\u0154");
		tab[10].setMnemonic('5');
		
		tab[11]=new  JButton("\u0155");
		tab[11].setMnemonic('r');
		
		tab[12]=new  JButton("\u014A");
		tab[12].setMnemonic('r');
		
		tab[13]=new  JButton("\u014B");
		tab[13].setMnemonic('n');
		
		tab[14]=new  JButton("\u0220");
		tab[14].setMnemonic(';');
		
		tab[15]=new  JButton("\u015A");
		tab[15].setMnemonic('6');
		
		tab[16]=new  JButton("\u015B");
		tab[16].setMnemonic('s');
		
		tab[17]=new  JButton("\u0117");
		tab[17].setMnemonic('y');
		
		tab[18]=new  JButton("\u0120");
		tab[18].setMnemonic('7');

		tab[19]=new  JButton("\u0103"); 
		tab[19].setMnemonic('p');
		
		tab[20]=new  JButton("\u0111");
		tab[20].setMnemonic('d');
		
		tab[21]=new  JButton("\u0116");
		tab[21].setMnemonic('8');
		
		tab[22]=new  JButton("\u0104");
		tab[22].setMnemonic('9');
		
		tab[23]=new  JButton("\u0105");
		tab[23].setMnemonic('q');
		
		tab[24]=new  JButton("\u0121");
		tab[24].setMnemonic('g');
		
		tab[25]=new  JButton("\u03CD");
		tab[25].setMnemonic('v');
		
		tab[26]=new  JButton("\u0144"); 
		tab[26].setMnemonic('w');
		
		tab[27]=new  JButton("\u014C");
		tab[27].setMnemonic('x');
		
		tab[28]=new  JButton("\u014D");
		tab[28].setMnemonic('o');
		
		tab[29]=new  JButton("\u016A"); 
		//tab[29].setMnemonic('v');
		
		tab[30]=new  JButton("\u016B");
		tab[30].setMnemonic('u');
		
		tab[31]=new  JButton("\u0190");
		tab[31].setMnemonic('k');
		
		tab[32]=new  JButton("\u03AD"); 
		tab[32].setMnemonic('j');
		
		tab[33]=new  JButton("\u03CC");
		tab[33].setMnemonic('f');
		
		tab[34]=new  JButton("\u0186");
		tab[34].setMnemonic('h');
		
		tab[35]=new  JButton("\u025B");
		tab[35].setMnemonic('m');
		
		tab[36]=new JButton("\u0289");
		tab[36].setMnemonic('l');
		
		tab[37]=new JButton("\u037B");
		tab[37].setMnemonic('c');
		
		tab[38]=new JButton("\u00FA");
		tab[38].setMnemonic('b');
                
                tab[39]=new JButton("\u00ed");
		tab[39].setMnemonic('i');
                
                tab[40]=new JButton("\u0259");
		tab[40].setMnemonic('=');
                
		panoletter= new JPanel();
		
		
		tab[41]=new JButton("\u00FA");
		tab[42]=new JButton("\u00FA");
		tab[43]=new JButton("\u00FA");
		tab[44]=new JButton("\u00FA");
		tab[45]=new JButton("\u00FA");
		tab[46]=new JButton("\u00FA");
		tab[47]=new JButton("\u00FA");
		
		

		for(int i = 0;i<48;i++){
			panoletter.add(tab[i]);
			tab[i].addActionListener(this);
		}
		

		panoletter.setLayout(null);	
		
	}

	public void actionPerformed(ActionEvent evt){

		Object src=evt.getSource();
		try{
			if(src==tab[0])edite.textPane.replaceSelection("à");	
			
			if(src==tab[1])edite.textPane.replaceSelection("\u0106");
			
			if(src==tab[2])edite.textPane.replaceSelection("\u0112");
			
			if(src==tab[3])edite.textPane.replaceSelection("\u0101");
			
			if(src==tab[4])edite.textPane.replaceSelection("\u0107");
			
			if(src==tab[5])edite.textPane.replaceSelection("\u0129");	
			
	        if(src==tab[6])edite.textPane.replaceSelection("\u0143");	
			
		    if(src==tab[7])edite.textPane.replaceSelection("\u012A");	
			
		    if(src==tab[8])edite.textPane.replaceSelection("\u012B");	
			
			if(src==tab[9])edite.textPane.replaceSelection("\u0113");	
			
			if(src==tab[10])edite.textPane.replaceSelection("\u0154");	
			
			if(src==tab[11])edite.textPane.replaceSelection("\u0155");
			
			if(src==tab[12])edite.textPane.replaceSelection("\u014A");
			
			if(src==tab[13])edite.textPane.replaceSelection("\u014B");
			
			if(src==tab[14])edite.textPane.replaceSelection("\u0220");
			
			if(src==tab[15])edite.textPane.replaceSelection("\u015A");
			
			if(src==tab[16])edite.textPane.replaceSelection("\u015B");
			
			if(src==tab[17])edite.textPane.replaceSelection("\u0117");	
			
			if(src==tab[18])edite.textPane.replaceSelection("\u0120");
			
			if(src==tab[19])edite.textPane.replaceSelection("\u0103");
			
			if(src==tab[20])edite.textPane.replaceSelection("\u0111");
			
			if(src==tab[21])edite.textPane.replaceSelection("\u0116");	
			
			if(src==tab[22])edite.textPane.replaceSelection("\u0104");	
			
		    if(src==tab[23])edite.textPane.replaceSelection("\u0105");
			
            if(src==tab[24])edite.textPane.replaceSelection("\u0121");
			
			if(src==tab[25])edite.textPane.replaceSelection("\u03CD");
			
			if(src==tab[26])edite.textPane.replaceSelection("\u0144");
			
			if(src==tab[27])edite.textPane.replaceSelection("\u014C");	
			
			if(src==tab[28])edite.textPane.replaceSelection("\u014D");	
			
			if(src==tab[29])edite.textPane.replaceSelection("\u016A");
			
			if(src==tab[30])edite.textPane.replaceSelection("\u016B");
			
			if(src==tab[31])edite.textPane.replaceSelection("\u0190");
			
			if(src==tab[32])edite.textPane.replaceSelection("\u03AD");
			
			if(src==tab[33])edite.textPane.replaceSelection("\u03CC");
			
			if(src==tab[34])edite.textPane.replaceSelection("\u0186");
			
			if(src==tab[35])edite.textPane.replaceSelection("\u025B");
						
			if(src==tab[36])edite.textPane.replaceSelection("\u0289");
			
			if(src==tab[37])edite.textPane.replaceSelection("\u037B");
			
			if(src==tab[38])edite.textPane.replaceSelection("\u00FA");
                        if(src==tab[38])edite.textPane.replaceSelection("\u00ed");
                        if(src==tab[38])edite.textPane.replaceSelection("\u0259");
			
			edite.textPane.requestFocus();
						
		}catch(Exception e){
			JOptionPane.showConfirmDialog(null,"veullez utiliser l alphabet ci dessus "," attention",JOptionPane.PLAIN_MESSAGE);
		}
	}
}
