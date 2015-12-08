import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class ajout  implements ActionListener, Serializable{

	/**
	 * 
	 */
	public static final long serialVersionUID = 8266823794956117680L;
	JButton a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,
	A,B,C,D,E,F,G,H,I,J,a1,b1,c1,iacsent,erenverser,ichapeau,aacsent,cote;
	JPanel panolettre;
	Editor edit;

	public ajout(Editor editeur){

		edit = editeur;
		
		
		a=new  JButton("à"); 
		a.setBorderPainted(true);
	    a.setCursor(new Cursor(12));
	    a.setFocusPainted(false);
	    a.setToolTipText("alt+0");
	    	    
		b=new  JButton("\u0106");
		b.setBorderPainted(true);
	    b.setCursor(new Cursor(12));
	    b.setFocusPainted(false);
	    b.setToolTipText("alt+1");
	   	    
		c=new  JButton("\u0112");
		c.setCursor(new Cursor(12));
	    c.setFocusPainted(false);
	    c.setToolTipText("alt+2");
	    
		d=new  JButton("\u0101"); 
		d.setCursor(new Cursor(12));
	    d.setFocusPainted(false);
	    d.setToolTipText("alt+a");
		
		e=new  JButton("\u0107");
		e.setCursor(new Cursor(12));
	    e.setFocusPainted(false);
	    e.setToolTipText("alt+z");
		
		f=new  JButton("\u0129");
		f.setCursor(new Cursor(12));
	    f.setFocusPainted(false);
	    f.setToolTipText("alt+i");
		
		g=new  JButton("\u0143");
		g.setCursor(new Cursor(12));
	    g.setFocusPainted(false);
	    g.setToolTipText("alt+3");
		
		h=new  JButton("\u012A");
		h.setCursor(new Cursor(12));
	    h.setFocusPainted(false);
	    h.setToolTipText("alt+4");
		
		i=new  JButton("\u012B");
		i.setCursor(new Cursor(12));
	    i.setFocusPainted(false);
	    i.setToolTipText("alt+t");
		
		j=new  JButton("\u0113");
		j.setCursor(new Cursor(12));
	    j.setFocusPainted(false);
	    j.setToolTipText("alt+e");

		k=new  JButton("\u0154");
		k.setCursor(new Cursor(12));
	    k.setFocusPainted(false);
	    k.setToolTipText("alt+5");
		
		l=new  JButton("\u0155");
		l.setCursor(new Cursor(12));
	    l.setFocusPainted(false);
	    l.setToolTipText("alt+r");
		
		m=new  JButton("\u014A");
		m.setCursor(new Cursor(12));
	    m.setFocusPainted(false);
	    m.setToolTipText("alt+n");
		
		n=new  JButton("\u014B");
		n.setCursor(new Cursor(12));
	    n.setFocusPainted(false);
	    n.setToolTipText("alt+n");
		
		o=new  JButton("\u0220");
		o.setCursor(new Cursor(12));
	    o.setFocusPainted(false);
	    o.setToolTipText("alt+;");
		
		p=new  JButton("\u015A");
		p.setCursor(new Cursor(12));
	    p.setFocusPainted(false);
	    p.setToolTipText("alt+6");
		
		q=new  JButton("\u015B");
		q.setCursor(new Cursor(12));
	    q.setFocusPainted(false);
	    q.setToolTipText("alt+s");
		
		r=new  JButton("\u0117");
		r.setCursor(new Cursor(12));
	    r.setFocusPainted(false);
	    r.setToolTipText("alt+y");
	    
		s=new  JButton("\u0120");
		s.setCursor(new Cursor(12));
	    s.setFocusPainted(false);
	    s.setToolTipText("alt+7");

		t=new  JButton("\u0103"); 
		t.setCursor(new Cursor(12));
	    t.setFocusPainted(false);
	    t.setToolTipText("alt+p");
		
		u=new  JButton("\u0111");
		u.setCursor(new Cursor(12));
	    u.setFocusPainted(false);
	    u.setToolTipText("alt+d");
		
		v=new  JButton("\u0116");
		v.setCursor(new Cursor(12));
	    v.setFocusPainted(false);
	    v.setToolTipText("alt+8");
		
		w=new  JButton("\u0104");
		w.setCursor(new Cursor(12));
	    w.setFocusPainted(false);
	    w.setToolTipText("alt+9");
		
		x=new  JButton("\u0105");
		x.setCursor(new Cursor(12));
	    x.setFocusPainted(false);
	    x.setToolTipText("alt+q");
		
		y=new  JButton("\u0121");
		y.setCursor(new Cursor(12));
	    y.setFocusPainted(false);
	    y.setToolTipText("alt+g");
		
		z=new  JButton("\u03CD");
		z.setCursor(new Cursor(12));
	    z.setFocusPainted(false);
	    z.setToolTipText("alt+v");
		
		A=new  JButton("\u0144"); 
		A.setCursor(new Cursor(12));
	    A.setFocusPainted(false);
	    A.setToolTipText("alt+w");
		
		B=new  JButton("\u014C");
		B.setCursor(new Cursor(12));
	    B.setFocusPainted(false);
	    B.setToolTipText("alt+x");
		
		C=new  JButton("\u014D");
		C.setCursor(new Cursor(12));
	    C.setFocusPainted(false);
	    C.setToolTipText("alt+o");
		
		D=new  JButton("\u016A"); 
		D.setCursor(new Cursor(12));
	    D.setFocusPainted(false);
	    D.setToolTipText("alt");
		
		E=new  JButton("\u016B");
		E.setCursor(new Cursor(12));
	    E.setFocusPainted(false);
	    E.setToolTipText("alt+u");
		
		F=new  JButton("\u0190");
		F.setCursor(new Cursor(12));
	    F.setFocusPainted(false);
	    F.setToolTipText("alt+k");
		
		G=new  JButton("\u03AD"); 
		G.setCursor(new Cursor(12));
	    G.setFocusPainted(false);
	    G.setToolTipText("alt+j");
		
		H=new  JButton("\u03CC");
		H.setCursor(new Cursor(12));
	    H.setFocusPainted(false);
	    H.setToolTipText("alt+f");
		
		I=new  JButton("\u0186");
		I.setCursor(new Cursor(12));
	    I.setFocusPainted(false);
	    I.setToolTipText("alt+h");
		
		J=new  JButton("\u025B");
		J.setCursor(new Cursor(12));
	    J.setFocusPainted(false);
	    J.setToolTipText("alt+m");
		
		a1=new JButton("\u0289");
		a1.setCursor(new Cursor(12));
	    a1.setFocusPainted(false);
	    a1.setToolTipText("alt+l");
		
		b1=new JButton("\u0254");
		b1.setCursor(new Cursor(12));
	    b1.setFocusPainted(false);
	    b1.setToolTipText("alt+c");
		
		c1=new JButton("\u00FA");
		c1.setCursor(new Cursor(12));
	    c1.setFocusPainted(false);
	    c1.setToolTipText("alt+b");
            //nouvelle ajout
            
            iacsent=new JButton("\u00ed");
	    iacsent.setCursor(new Cursor(12));
	    iacsent.setFocusPainted(false);
	    iacsent.setToolTipText("alt+");
            
            erenverser=new JButton("\u0259");
	    erenverser.setCursor(new Cursor(12));
	    erenverser.setFocusPainted(false);
	    erenverser.setToolTipText("alt+");
            
            ichapeau=new JButton("\u00ee");
	    ichapeau.setCursor(new Cursor(12));
	    ichapeau.setFocusPainted(false);
	    ichapeau.setToolTipText("alt+");
            
            aacsent=new JButton("\u00e1");
	    aacsent.setCursor(new Cursor(12));
	    aacsent.setFocusPainted(false);
	    aacsent.setToolTipText("alt+");
            
            cote=new JButton("\u2019");
	    cote.setCursor(new Cursor(12));
	    cote.setFocusPainted(false);
	    cote.setToolTipText("alt+");
            
          
            

		panolettre= new JPanel();
            

		a.setBackground(edit.couleur1[0]);  
		b.setBackground(edit.couleur1[0]);
		c.setBackground(edit.couleur1[0]);
		d.setBackground(edit.couleur1[0]);
		e.setBackground(edit.couleur1[0]);
		f.setBackground(edit.couleur1[0]);
		g.setBackground(edit.couleur1[0]);
		h.setBackground(edit.couleur1[0]);
		i.setBackground(edit.couleur1[0]);

		j.setBackground(edit.couleur1[0]);
		k.setBackground(edit.couleur1[0]);
		l.setBackground(edit.couleur1[0]);
		m.setBackground(edit.couleur1[0]); 
		n.setBackground(edit.couleur1[0]);
		o.setBackground(edit.couleur1[0]);
		p.setBackground(edit.couleur1[0]);
		q.setBackground(edit.couleur1[0]);
		r.setBackground(edit.couleur1[0]);

		s.setBackground(edit.couleur1[0]);
		t.setBackground(edit.couleur1[0]); 
		u.setBackground(edit.couleur1[0]);
		v.setBackground(edit.couleur1[0]);  
		w.setBackground(edit.couleur1[0]);
		x.setBackground(edit.couleur1[0]);
		y.setBackground(edit.couleur1[0]); 
		z.setBackground(edit.couleur1[0]); 
		A.setBackground(edit.couleur1[0]);

		B.setBackground(edit.couleur1[0]); 
		C.setBackground(edit.couleur1[0]);  
		D.setBackground(edit.couleur1[0]);
		E.setBackground(edit.couleur1[0]); 
		F.setBackground(edit.couleur1[0]); 
		G.setBackground(edit.couleur1[0]);
		H.setBackground(edit.couleur1[0]);
		I.setBackground(edit.couleur1[0]);  
		J.setBackground(edit.couleur1[0]);
		a1.setBackground(edit.couleur1[0]);
		b1.setBackground(edit.couleur1[0]);
		c1.setBackground(edit.couleur1[0]);

		a.addActionListener(this);
		b.addActionListener(this);
		c.addActionListener(this);
		d.addActionListener(this);
		e.addActionListener(this);
		f.addActionListener(this);
		g.addActionListener(this);

		h.addActionListener(this);
		i.addActionListener(this);
		j.addActionListener(this);
		k.addActionListener(this);
		l.addActionListener(this);
		m.addActionListener(this);
		n.addActionListener(this);

		o.addActionListener(this);
		p.addActionListener(this);
		q.addActionListener(this);
		r.addActionListener(this);
		s.addActionListener(this);
		t.addActionListener(this);
		u.addActionListener(this);

		v.addActionListener(this);
		w.addActionListener(this);
		x.addActionListener(this);
		y.addActionListener(this);
		z.addActionListener(this);
		A.addActionListener(this);
		B.addActionListener(this);

		C.addActionListener(this);	
		D.addActionListener(this);
		E.addActionListener(this);
		F.addActionListener(this);
		G.addActionListener(this);
		H.addActionListener(this);
		I.addActionListener(this);

		J.addActionListener(this);
		a1.addActionListener(this);
		b1.addActionListener(this);
		c1.addActionListener(this);
                
                iacsent.addActionListener(this);
		erenverser.addActionListener(this);
                ichapeau.addActionListener(this);
                aacsent.addActionListener(this);
                cote.addActionListener(this);
               
                
		GridLayout disp = new GridLayout(12,4,3,3);
		panolettre.setLayout(disp);
               /* for(int i=0; i<72; i++)
                    this.panolettre.add(new JButton(""+i));
		*/
                panolettre.add(a);
		panolettre.add(b);
		panolettre.add(c);
		panolettre.add(d);
		panolettre.add(e);
		panolettre.add(f);
		panolettre.add(g);
		panolettre.add(h);
		panolettre.add(i);
		panolettre.add(j);
                
                panolettre.add(k);
		panolettre.add(l);
		panolettre.add(m);
		panolettre.add(n);
		panolettre.add(o);
		panolettre.add(p);
		panolettre.add(q);
		panolettre.add(r);
		panolettre.add(s);
		panolettre.add(t);
                
                panolettre.add(t);
		panolettre.add(u);
		panolettre.add(v);
		panolettre.add(w);
		panolettre.add(x);
		panolettre.add(y);
		panolettre.add(z);
		panolettre.add(J);   
		panolettre.add(A); 
		panolettre.add(B);
		
                panolettre.add(C);
		panolettre.add(D);
		panolettre.add(E);
		panolettre.add(F);
		panolettre.add(G);
		panolettre.add(H);
		panolettre.add(I);
		panolettre.add(a1);
		panolettre.add(b1);
		panolettre.add(c1);
                
                panolettre.add(iacsent);
		panolettre.add(erenverser);
                panolettre.add(ichapeau);
                 panolettre.add(aacsent);
                 panolettre.add(cote);
           //                 panolettre.add(oacsent);
               
		
	}

	public void actionPerformed(ActionEvent evt){

		Object src=evt.getSource();
		try{
			if(src==a){
				edit.textPane.replaceSelection("à");
				edit.textPane.requestFocus();
			}
                        if(src==cote){
				edit.textPane.replaceSelection("\u2019");
				edit.textPane.requestFocus();
			}
                       
                        if(src==ichapeau){
				edit.textPane.replaceSelection("\u00ee");
				edit.textPane.requestFocus();
			}
                        if(src==aacsent){
				edit.textPane.replaceSelection("\u00e1");
				edit.textPane.requestFocus();
			}
			else if(src==b){
				edit.textPane.replaceSelection("\u0106");
				edit.textPane.requestFocus();
			}
                        else if(src==iacsent){
				edit.textPane.replaceSelection("\u00ed");
				edit.textPane.requestFocus();
			}
                        else if(src==erenverser){
				edit.textPane.replaceSelection("\u0259");
				edit.textPane.requestFocus();
			}
			else if(src==c){
				edit.textPane.replaceSelection("\u0112");
				edit.textPane.requestFocus();
			}
			else if(src==d){
				edit.textPane.replaceSelection("\u0101");
				edit.textPane.requestFocus();
			}
			else if(src==e){
				edit.textPane.replaceSelection("\u0107");
				edit.textPane.requestFocus();
			}
			else if(src==f){
				edit.textPane.replaceSelection("\u0129");
				edit.textPane.requestFocus();
			}
			else if(src==g){
				edit.textPane.replaceSelection("\u0143");
				edit.textPane.requestFocus();
			}
			else if(src==h){
				edit.textPane.replaceSelection("\u012A");
				edit.textPane.requestFocus();
			}
			else if(src==i){
				edit.textPane.replaceSelection("\u012B");
				edit.textPane.requestFocus();
			}
			else if(src==j){
				edit.textPane.replaceSelection("\u0113");
				edit.textPane.requestFocus();
			}
			else if(src==k){
				edit.textPane.replaceSelection("\u0154");
				edit.textPane.requestFocus();
			}
			else if(src==l){
				edit.textPane.replaceSelection("\u0155");
				edit.textPane.requestFocus();
			}
			else if(src==m){
				edit.textPane.replaceSelection("\u014A");
				edit.textPane.requestFocus();
			}
			else if(src==n){
				edit.textPane.replaceSelection("\u014B");
				edit.textPane.requestFocus();
			}
			else if(src==o){
				edit.textPane.replaceSelection("\u0220");
				edit.textPane.requestFocus();
			}
			else if(src==p){
				edit.textPane.replaceSelection("\u015A");
				edit.textPane.requestFocus();
			}
			else if(src==q){
				edit.textPane.replaceSelection("\u015B");
				edit.textPane.requestFocus();
			}
			else if(src==r){
				edit.textPane.replaceSelection("\u0117");
				edit.textPane.requestFocus();
			}
			else if(src==s){
				edit.textPane.replaceSelection("\u0120");
				edit.textPane.requestFocus();
			}
			else if(src==t){
				edit.textPane.replaceSelection("\u0103");
				edit.textPane.requestFocus();
			}
			else if(src==u){
				edit.textPane.replaceSelection("\u0111");
				edit.textPane.requestFocus();
			}
			else if(src==v){
				edit.textPane.replaceSelection("\u0116");
				edit.textPane.requestFocus();
			}
			else if(src==w){
				edit.textPane.replaceSelection("\u0104");
				edit.textPane.requestFocus();
			}
			else if(src==x){
				edit.textPane.replaceSelection("\u0105");
				edit.textPane.requestFocus();
			}
			else if(src==A) {
				edit.textPane.replaceSelection("\u0144");
				edit.textPane.requestFocus();
			}
			else if(src==B){
				edit.textPane.replaceSelection("\u014C");
				edit.textPane.requestFocus();
			}
			else if(src==C){
				edit.textPane.replaceSelection("\u014D");
				edit.textPane.requestFocus();
			}
			else if(src==D){
				edit.textPane.replaceSelection("\u016A");
				edit.textPane.requestFocus();
			}
			else if(src==E){
				edit.textPane.replaceSelection("\u016B");
				edit.textPane.requestFocus();
			}
			else if(src==F){
				edit.textPane.replaceSelection("\u0190");
				edit.textPane.requestFocus();
			}
			else if(src==G){
				edit.textPane.replaceSelection("\u03AD");
				edit.textPane.requestFocus();
			}
			else if(src==H){
				edit.textPane.replaceSelection("\u03CC");
				edit.textPane.requestFocus();
			}
			else if(src==I){
				edit.textPane.replaceSelection("\u0186");
				edit.textPane.requestFocus();
			}
			else if(src==J){
				edit.textPane.replaceSelection("\u025B");
				edit.textPane.requestFocus();
			}
			else if(src==y){
				edit.textPane.replaceSelection("\u0121");
				edit.textPane.requestFocus();
			}
			else if(src==z){
				edit.textPane.replaceSelection("\u03CD");
				edit.textPane.requestFocus();
			}
			else if(src==a1){
				edit.textPane.replaceSelection("\u0289");
				edit.textPane.requestFocus();
			}
			else if(src==b1){
				edit.textPane.replaceSelection("\u037B");
				edit.textPane.requestFocus();
			}
			else if(src==c1){
				edit.textPane.replaceSelection("\u00FA");
				edit.textPane.requestFocus();
			}
			
		}catch(Exception e){
			JOptionPane.showConfirmDialog(null,"veullez utiliser l alphabet ci dessus "," attention",JOptionPane.PLAIN_MESSAGE);
		}
	}
}
