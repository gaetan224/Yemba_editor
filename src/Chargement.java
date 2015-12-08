

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
public class Chargement extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2666478955191183954L;
	ImageIcon imgfond;
	Color couleur;
	Chargement pred;
	Chargement suiv;
	
	public Chargement(){
		super();
		
	 imgfond = new ImageIcon("./img/charg.gif");
		couleur=Color.BLACK;
		
		pred=null;
		suiv=null;
	}
	public void paintComponent(Graphics g){
		super.paintComponents(g);
		g.setColor(couleur);
		
		Image img=imgfond.getImage();
		
		g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1,10,10);
		
	
		g.drawImage(img,2,2,getWidth()-4,getHeight()-4,this);		
		
			
	}
	
}

/*public static void main(String []args){
	
	
	
	JFrame fen=new JFrame();
	fen.setContentPane(new Chargement());
	fen.setBounds(100,200,500,500);
	
	fen.setUndecorated(true);
	fen.setVisible(true);
	
}}		
	*/