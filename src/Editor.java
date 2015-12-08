import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.*;
  
import java.awt.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.io.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.event.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.text.*;
import javax.swing.text.html.HTMLEditorKit;


public class Editor extends JFrame implements ActionListener,CaretListener, Serializable,WindowListener {
   public  String mot_taper = "";
   public JTextPane textPane = new JTextPane();
   public JTextArea Erreur;
   public JMenuBar barre=new JMenuBar();
   public  yemb g, b;
   public Fichier fich=null;
   public String ch;
   public JPanel coul1=new JPanel(),coul2=new JPanel(),coul=new JPanel();
   public Raccourci racc=null;
   public JTextPane ppuce = new JTextPane();
	
   Correcteur correct;
   String[] list_mot_possible={"Aucune Suggestion"};
   public Boolean exit = false;  
   public JButton   B_new,B_saveas,B_save,B_open,B_add,B_print,B_quit,B_cut,B_paste,B_copy,B_erase,B_help,B_consol,B_carac,B_allselect;
	JPanel p1=new JPanel();
	 JPanel p2=new JPanel();
	 int debut=0, fin=0;
	 JPanel p4=new JPanel(),p5=new JPanel(),p3=new JPanel(),principal=new JPanel();
		int ind=0,pos_curseur=0,Longueur=0,Largeur=0;
		int x = 0;
		float sa=9.5f, sb=1.5f;
	 
	  // style par defaut de notre textpane
	  
	 Style defaut;  
	 StyledDocument document;
	 
         
         
		 //fichier contenent le dictionnaire consulter pour afficher les erreurs
		 
		public File Biblio = null;
		
	 // element se trouvant sur la barre de menu notament le menu fichier, edition, format et aide, correcteur
	 
	public JMenu M_EDIT, M_FILE, M_FORMAT, M_INFO, M_CORRECT;
	
	 //element de menu fichier : nouveau; ouvrir; enregistrer; enregistrer sous; ajouter au dictionnaire; imprimer; quitter
	 
	public JMenuItem MI_NEW, MI_OPEN, MI_SAVE, MI_SAVEAS, MI_BIBLIO, MI_PRINT, MI_EXIT;
	
	 //element du menu edition : couper; copier; coller; effacer; selectionner tout; inserer caractere; affiche console;
	 
	public JMenuItem MI_CUT, MI_COPY, MI_PASTE, MI_ERASE, MI_SLCTALL, MI_INSERT, MI_CONSOL, MI_TBAR;
	
	 // element du menu aide : 
	 
	public JMenuItem MI_CMT, MI_HELP, MI_ABOUT;
	public JMenu SM_BGCOLOR, SM_TXTCOLOR, SM_TXTSIZE;
	
	// taille de la police
	 
	public int[] taille1={10,15,20,25,30,34,35,36,37,38,39,40};
	
	// element du menu format : couleur de fond et de texte et taille de texte
	
	public JRadioButtonMenuItem couleurFond[], couleurTexte[], tailleFond[];
	
	// groupe de bouton pour ne pouvoir faire qu'un seul choix dans les menus ci-dessus
	
	public ButtonGroup groupCouleursFond, groupCouleursTexte;  
	
	//les 04 lignes ci-dessous representent les noms et valeurs pour les couleur de choix dans le menu format
	 	 
	public String[] nomCouleur1 = {"Fho'", "sén", "pan", "Ntu méfho methu", "Ntu anwana lephu", "Go", "Agapa pan", "Agapn\u025B s\u025Bh", "Akwhu\u025B agapn\u025B s\u025Bh"};
	public String[] nomCouleur2 = {"Fho'", "sén", "pan", "Ntu méfho methu", "Ntu anwana lephu", "Go", "Agapa pan", "Agapn\u025B s\u025Bh", "Akwhu\u025B agapn\u025B s\u025Bh"};
	public Color[] couleur1 = {Color.white, Color.black, Color.red, Color.green, Color.blue, Color.yellow, Color.orange, Color.gray, Color.lightGray};
	public Color[] couleur2 = {Color.white, Color.black, Color.red, Color.green, Color.blue, Color.yellow, Color.orange, Color.gray, Color.lightGray};
	
	//menu pour le click droit
	 
	public JPopupMenu PM_EDIT = new JPopupMenu();
	
	//element pour le menu du click droit : couper, copier, coller, effacer, selectionner tout, ajouter au dictionnaire
	 
	public JMenuItem PMI_CUT, PMI_COPY, PMI_PASTE, PMI_ERASE, PMI_SLCTALL, PMI_BIBLIO,  
	 mot_poss[] =new JMenuItem[5], ignorer ,ignorertout,traduit;
     
	// fichier contenant le chemin d'acces au fichier en cour de traitement
	 
	public File fichierCourant = null;
	
	//fichier contenent le dictionnaire consulter pour afficher les erreurs
	 
	 /* panneau contenant la zone de saisie ainsi que la palette de caractere a inserer(c1) et panneau contenant
	  la zone d'affichage des erreurs(d).
*/	 
	public JPanel c1, d,c11;
	
	//variable pour afficher les fenetres d'enregistrement ainsi que d'ouverture de fichier
	 
	public  JFileChooser fileChooser = new JFileChooser("CamEditor 2.0");
	
	 //filtre de selection de fichier pour les fenetres d'enregistrement et d'ouverture de fichier
	 
	public  monFiltre filter=new monFiltre(".cam","CamEditor");
	
	//police d'affichage des elements du menu de l'editeur
	 
	public Font fonfon=new Font("Calibri",Font.TRUETYPE_FONT,15);
	
	//variable permettant d'assosier les actions aux elements du menu
	 
	//panneau avec ascenseur pour la zone de saisie(jsp) et pour la zone d'affichage des erreurs(jspE)
	 
	public JScrollPane jsp, jspE;
	
	//variable permetant d'afficher ou de masquer la palette des caracteres a inserer
	 
	public ajout inser= new ajout(this);
	public SimpleAttributeSet attribut = new SimpleAttributeSet();
	public Raccourci rac = new Raccourci(this);
	  
	// Barre d'outil
	 
	public JToolBar toolbar,toolbar2;
	
	//boutton exterieur a la classe 
	 
  public JToolBar barre1 = new JToolBar();
   public JButton rechercher=new JButton(new ImageIcon("img/rech.png")), 
          
           droit=new JButton(new ImageIcon("images/droit.gif")),
           math = new JButton(new ImageIcon("images/math.png")), 
           centre=new JButton(new ImageIcon("images/centre.gif")),
           gauch=new JButton(new ImageIcon("images/gauch.gif")),
           traduir=new JButton(new ImageIcon("images/traduire.png")),
           justif=new JButton(new ImageIcon("images/justif.png"));;
  
   public final JComboBox police=new JComboBox(),
                          taille=new JComboBox(), 
                          inter=new JComboBox();
   
   public JToggleButton soulign=new JToggleButton(new ImageIcon("images/soulign.png")), 
                        maj=new JToggleButton (new ImageIcon("images/maj.png")),
                        sub=new JToggleButton(new ImageIcon("images/sub.png")),
                        puce=new JToggleButton(new ImageIcon("images/puce.png")),
                   
                        gras=new JToggleButton(new ImageIcon("images/gras.gif")), 
                        italic=new JToggleButton(new ImageIcon("images/italic.png")),
                        sup=new JToggleButton(new ImageIcon("images/sup.png"));
 
   public final JButton tcouleur = new JButton(new ImageIcon("images/couletxt.png")), 
                        fcouleur = new JButton(new ImageIcon("images/coulefond.png")),
                        surbrillance = new JButton(new ImageIcon("images/coulesurbri.png"));
   
   public Color couleur_text = Color.BLACK;
   public Color couleur_fond = Color.white;
   public JPanel pan;
   public Moteur moteur=null;
    String titrefichier = "nouveau document";
    private boolean enreg;
   
   
   
   public Editor() {
      super("YembaEditor");
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setIconImage(new ImageIcon("images/CamEditor.png").getImage());
      try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			SwingUtilities.updateComponentTreeUI(fileChooser);
		} catch (final Exception e) {
		}
      textPane.setDocument(documentAssocie);
      
      formater(x,sa,sb);
      init_variable();
      menubar_init();
      outil_text();
      init_actionlistener();
            
            
      d = new JPanel();
      d.setLayout(new BorderLayout());
      c1 = new JPanel();
      c11 = new JPanel();
      Erreur.setFont(fonfon);
      Erreur.setForeground(Color.RED);
	  jspE=new JScrollPane(Erreur);
	  c1.setLayout( new BorderLayout() );
	  c11.setLayout(new GridLayout(2,1) );
          
	  c11.add(toolbar);
	  c11.add(toolbar2);
          
          //c11.add(toolbar3);
	  c1.add(BorderLayout.CENTER, c11);
	  JScrollPane scroll = new JScrollPane(textPane);
	  d.add(scroll,BorderLayout.CENTER);
        textPane.addCaretListener(this);
      moteur = new Moteur(this, correct); 
      textPane.addKeyListener(moteur);
      
        
      Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
      Longueur = dim.width;
      Largeur = dim.height;
	  setSize(Longueur-20, Largeur-40);
	  System.out.println(dim.width );
	  System.out.println(dim.height);
	 
	  d.setBounds(Longueur-1125,Largeur-668,Longueur-460, Largeur-222);
	  c1.setBounds(5, 0, Longueur-37, Largeur-678);
	  jspE.setBounds(Longueur-1125,Largeur-121,Longueur-460, 30);
	  jspE.setBackground(new Color(215,235,255));
	  Erreur.setBackground(new Color(215,235,255));
	  inser.panolettre.setBounds(Longueur-180, Largeur-668,Longueur-1230, Largeur-190);
	  inser.panolettre.setBackground(new Color(215,235,255));
	  inser.panolettre.setVisible(false);
	  
	  rac= new Raccourci(this);
	  rac.panoletter.setBounds(0, 0, 0, 0);
	 
	  principal.setBounds(0,0,Longueur-20, Largeur-40);
	  principal.setLayout(null);
	  principal.add(d);
	  principal.add(c1);
	  principal.add(jspE);
	  principal.add(rac.panoletter);
	  principal.add(inser.panolettre);
          principal.setBackground(new java.awt.Color(217, 250, 240));
	  c1.setBackground(new java.awt.Color(217, 250, 240));
          c11.setBackground(new java.awt.Color(217, 250, 240));
          toolbar.setBackground(new java.awt.Color(192, 226, 247));
          toolbar2.setBackground(new java.awt.Color(192, 226, 247));
	  setJMenuBar(barre);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      this.setLayout(null);
      this.setContentPane(principal);
      this.setLocationRelativeTo(null);
      setVisible(true);
      //textPane.requestFocus();
     
    	   
      
      textPane.addMouseListener(
				new MouseAdapter() {
					public void mousePressed(MouseEvent e) {
						checkTrigger(e);
					}
					public void mouseReleased(MouseEvent e) {
						checkTrigger(e);
					}
					public void checkTrigger(MouseEvent e) {
						if (e.isPopupTrigger()) {
							updatePopupOptions();
                                                        
							PM_EDIT.show(e.getComponent(), e.getX(), e.getY());
						} } 
                                }
						);  
   
      
      this.addWindowListener(this);
      
      
     
   }
                   
     
  // public Editor(String n){}
   
   public void init_actionlistener() {
	   
	   italic.addActionListener(this);
   //	   init.addActionListener(this);
	   gras.addActionListener(this);
	   soulign.addActionListener(this);
	   tcouleur.addActionListener(this);
           surbrillance.addActionListener(this);
	   fcouleur.addActionListener(this);
	   sub.addActionListener(this);
	   sup.addActionListener(this);
	   maj.addActionListener(this);
	   droit.addActionListener(this);
	   gauch.addActionListener(this);
	   centre.addActionListener(this);
	   justif.addActionListener(this);           
           math.addActionListener(this);
            puce.addActionListener(this);
            traduir.addActionListener(this);
           
         
           
           
           
           
	   		   
	   taille.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent arg0) {
				StyleConstants.setFontSize(attribut,Integer.valueOf((String)taille.getSelectedItem()).intValue()); 
				textPane.setCharacterAttributes(attribut, false);
			    textPane.repaint();
			    textPane.requestFocus();
			}   });
	   
	   inter.addActionListener(new ActionListener() { 
           public void actionPerformed(ActionEvent e){ 
			     
			       int b=inter.getSelectedIndex();
			       float sb=(float)b;
			       sb = sb+2.0f;
			       float sa= sb+8.0f;
			 	  System.out.println("interligne  :"+sb+"  "+sa);
            	  formater(x,sa,sb);
           }
           }); 
				   
		police.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent arg0) {
				StyleConstants.setFontFamily(attribut,police.getSelectedItem().toString()); 
				textPane.setCharacterAttributes(attribut, false);
				textPane.repaint();
				textPane.requestFocus();
			}  });  }
	
   
   
   public void init_variable() {
	   
	// Console d'erreur
		Erreur = new JTextArea("CTRL+F pour masquer/afficher Fautes d'orthographe");
		Erreur.setEditable(false);
		jspE = new JScrollPane(Erreur);
   }
   
   
   public void menubar_init() {
	   barre = new JMenuBar();
		toolbar = new JToolBar();

		// Menu 1: Fichier
		M_FILE = new JMenu("\u014Bka\u014Ba menu");
		M_FILE.setToolTipText("Fichier");
		
		M_FILE.addMouseListener(
				new MouseAdapter() {
					public void mousePressed(MouseEvent e) {
						updateMenuOptions();
					} });
	
		
		M_FILE.setFont(fonfon);
			
		//Nouveau
		MI_NEW = new JMenuItem("anu eshsw\u012B");
		MI_NEW.setToolTipText("Nouveau");
		MI_NEW.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK, false));
		MI_NEW.addActionListener(this);
		MI_NEW.setFont(fonfon);
				
		M_FILE.add(MI_NEW);
		
		//Ouvrir
		MI_OPEN = new JMenuItem("ts\u037B'\u037B");
		MI_OPEN.setToolTipText("Ouvrir");
		MI_OPEN.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK, false));
		MI_OPEN.setFont(fonfon);
		MI_OPEN.addActionListener(new Open(this,MI_OPEN));
		M_FILE.add(MI_OPEN);
		
		//Enregistrer
		MI_SAVE = new JMenuItem("l\u037B'\u037B");
		MI_SAVE.setToolTipText("Enregistrer");
		MI_SAVE.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK, false));
		MI_SAVE.setFont(fonfon);
		MI_SAVE.addActionListener(this);
		M_FILE.add(MI_SAVE);
		
		//Enregistrer sous
		MI_SAVEAS = new JMenuItem("l\u037B'\u037B \u00E1 \u0144t");
		MI_SAVEAS.setToolTipText("Enregistrer sous");
		MI_SAVEAS.setFont(fonfon);
		MI_SAVEAS.addActionListener(this);
		M_FILE.add(MI_SAVEAS);
		M_FILE.addSeparator();
		
		//Dictionnaire
		MI_BIBLIO = new JMenuItem("Tswi'n\u025B  \u025B a n\u025B acu'o");
		MI_BIBLIO.setToolTipText("Ajouter au dictionnaire");
		MI_BIBLIO.setFont(fonfon);
		MI_BIBLIO.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J, InputEvent.CTRL_MASK, false));
		MI_BIBLIO.addActionListener(this);
		M_FILE.add(MI_BIBLIO);
		
		//Imprimer
		MI_PRINT = new JMenuItem("F\u037Bk\u037B");
		MI_PRINT.setToolTipText("Imprimer ce document");
		MI_PRINT.setFont(fonfon);
		MI_PRINT.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK, false));
		MI_PRINT.addActionListener(this);
		M_FILE.add(MI_PRINT);
		M_FILE.addSeparator();
		
		//Quitter
		MI_EXIT = new JMenuItem("T\u00FA\u037B");
		MI_EXIT.setToolTipText("Quitter");
		MI_EXIT.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK, false));
		MI_EXIT.setFont(fonfon);
		MI_EXIT.addActionListener(this);
		M_FILE.add(MI_EXIT);
		barre.add(M_FILE);

		// Menu 2: Edition
		M_EDIT = new JMenu("levho");
		M_EDIT.setToolTipText("Edition");
		M_EDIT.setFont(fonfon);
		M_EDIT.addMouseListener(
				new MouseAdapter() {
					public void mousePressed(MouseEvent e) {
						updateMenuOptions();
					}  } );
	
		
		//Couper
		MI_CUT = new JMenuItem("zaà’aà");
		MI_CUT.setToolTipText("Couper");
		MI_CUT.setFont(fonfon);
		MI_CUT.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK, false));
		MI_CUT.addActionListener(this);
		M_EDIT.add(MI_CUT);
		
		//Copier
		MI_COPY = new JMenuItem("lókóö");
		MI_COPY.setToolTipText("Copier");
		MI_COPY.setFont(fonfon);
		MI_COPY.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK, false));
		MI_COPY.addActionListener(this);
		M_EDIT.add(MI_COPY);
		
		//Coller
		MI_PASTE = new JMenuItem("yátáö");
		MI_PASTE.setToolTipText("Coller");
		MI_PASTE.setFont(fonfon);
		MI_PASTE.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK, false));
		MI_PASTE.addActionListener(this);
		M_EDIT.add(MI_PASTE);
		
		//Effacer
		MI_ERASE = new JMenuItem("pïùkáà");
		MI_ERASE.setToolTipText("Effacer");
		MI_ERASE.setFont(fonfon);
		MI_ERASE.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK, false));
		MI_ERASE.addActionListener(this);
		M_EDIT.add(MI_ERASE);
		M_EDIT.addSeparator();
		
		//Selectionner tout
		MI_SLCTALL = new JMenuItem("tsóà’ \u014Bàkwa");
		MI_SLCTALL.setToolTipText("Selectionner tout");
		MI_SLCTALL.setFont(fonfon);
		MI_SLCTALL.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK, false));
		MI_SLCTALL.addActionListener(this);
		M_EDIT.add(MI_SLCTALL);
		
		//Inserer caractere
		MI_INSERT = new JMenuItem("Nén\u025B ta' letsen anu");
		MI_INSERT.setToolTipText("Clavier visuel");
		MI_INSERT.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_MASK, false));
		MI_INSERT.setFont(fonfon);
		MI_INSERT.addActionListener(this);
		M_EDIT.add(MI_INSERT);
		
		//Console d'erreur
		MI_CONSOL = new JMenuItem("alana melo'");
		MI_CONSOL.setToolTipText("Afficher/masquer la console d'erreur");
		MI_CONSOL.setFont(fonfon);
		MI_CONSOL.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_MASK, false));
		MI_CONSOL.addActionListener(this);
		M_EDIT.add(MI_CONSOL);
		
		// barre d'outils
		MI_TBAR = new JMenuItem("alana ");
		MI_TBAR.setToolTipText("Afficher/masquer la barre d'outil");
		MI_TBAR.setFont(fonfon);
		MI_TBAR.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_MASK, false));
		MI_TBAR.addActionListener(this);
		M_EDIT.add(MI_TBAR);		
		barre.add(M_EDIT);

		// Menu 3: Format
		M_FORMAT = new JMenu("  ef\u0289’");
		M_FORMAT.setToolTipText("Format");
		M_FORMAT.setFont(fonfon);
		
		// Sous-menu 1: Couleur de fond
		SM_BGCOLOR = new JMenu("Ayinn\u025B ntu");
		SM_BGCOLOR.setToolTipText("Couleur du fond");
		SM_BGCOLOR.setFont(fonfon);

		groupCouleursFond = new ButtonGroup();
		couleurFond = new JRadioButtonMenuItem[nomCouleur1.length];
		
		for (int i = 0; i < nomCouleur1.length; i++) {
			couleurFond[i] = new JRadioButtonMenuItem(nomCouleur1[i]);
			if (couleur1[i] == textPane.getBackground())
				couleurFond[i].setSelected(true);
			couleurFond[i].addActionListener(this);
			couleurFond[i].setFont(fonfon);
			groupCouleursFond.add(couleurFond[i]);
			SM_BGCOLOR.add(couleurFond[i]);
		}
		
		M_FORMAT.add(SM_BGCOLOR);

		// Sous-menu 2: police des caracteres
		SM_TXTSIZE = new JMenu("\u014Bkiaà");
		SM_TXTSIZE.setToolTipText("Taille de la police");
		SM_TXTSIZE .setFont(fonfon);
		tailleFond = new JRadioButtonMenuItem[taille1.length];
		
		for (int i = 0; i < taille1.length; i++) {
			tailleFond[i] = new JRadioButtonMenuItem(taille1[i]+"");
			tailleFond[i].setFont(fonfon);
			if (taille1[i] ==textPane.getFont().getSize())
				tailleFond[i].setSelected(true);
			tailleFond[i].addActionListener(this);
			groupCouleursFond.add(tailleFond[i]);
			SM_TXTSIZE.add(tailleFond[i]);
		}
		
		M_FORMAT.add(SM_TXTSIZE);

		// Sous-menu 3: Couleur du texte
		SM_TXTCOLOR = new JMenu("Ntu ak\u025Bte");
		SM_TXTCOLOR.setToolTipText("Couleur du texte");
		SM_TXTCOLOR.setFont(fonfon);
		groupCouleursTexte = new ButtonGroup();
		couleurTexte = new JRadioButtonMenuItem[nomCouleur2.length];
		
		for (int i = 0; i < nomCouleur2.length; i++) {
			couleurTexte[i] = new JRadioButtonMenuItem(nomCouleur2[i]);
			couleurTexte[i].setFont(fonfon);
			if (couleur2[i] == textPane.getForeground())
				couleurTexte[i].setSelected(true);
			couleurTexte[i].addActionListener(this);
			groupCouleursTexte.add(couleurTexte[i]);
			SM_TXTCOLOR.add(couleurTexte[i]);
		}
		
		M_FORMAT.add(SM_TXTCOLOR);
		barre.add(M_FORMAT);

		// Menu 4: aide
		M_INFO = new JMenu(" akwiite");
		M_INFO.setToolTipText("Aide");
		M_INFO.setFont(fonfon);
		
		//menu de correction
		M_CORRECT=new JMenu();
		M_CORRECT.setFont(fonfon);
		
		//commentaire
		MI_CMT = new JMenuItem("Mepinte");
		MI_CMT.setToolTipText("Commentaire");
		MI_CMT.setFont(fonfon);
		MI_CMT.addActionListener(this);
		M_INFO.add(MI_CMT);
		
		//droit d'auteur
		MI_HELP = new JMenuItem("hïùip aà nà YembaEditor");
		MI_HELP.setToolTipText("Aide sur YembaEditor");
		MI_HELP.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0, false));
		MI_HELP.setFont(fonfon);
		MI_HELP.addActionListener(this);
		M_INFO.add(MI_HELP);
		
		//A Propos
		MI_ABOUT = new JMenuItem("e\340sh\372\366\u2019 a\340 n\341");
		MI_ABOUT.setToolTipText("A propos");
		MI_ABOUT.setFont(fonfon);
		MI_ABOUT.addActionListener(this);
		M_INFO.add(MI_ABOUT);
		barre.add(M_INFO);

		// Popup (Copier, Coller, etc...)
		
		config_popup();
		
		//Barre d'outil
		
		//boutton nouveau
		B_new = new JButton("anu..");
		B_new.setIcon(new ImageIcon("./img/new.png"));
		B_new.setToolTipText("nouveau fichier (ctrl+N)");
		B_new.addActionListener(this);
                B_new.setBackground(new java.awt.Color(192, 226, 247));
		toolbar.add(B_new);
        
		//boutton ouvrir
		B_open = new JButton("tsóà’óà...");
		B_open.setIcon(new ImageIcon("./img/open.png"));
		B_open.setToolTipText("ouvrir fichier (ctrl+O)");
		B_open.addActionListener(new Open(this, B_open));
                B_open.setBackground(new java.awt.Color(192, 226, 247));
		toolbar.add(B_open);
		toolbar.addSeparator();

		//boutton enregistrer
		B_save = new JButton("ló’óö...");
		B_save.setIcon(new ImageIcon("./img/Save.png"));
		B_save.setToolTipText("enregistrer fichier (ctrl+S)");
		B_save.addActionListener(this);
		B_save.setEnabled(false);
                B_save.setBackground(new java.awt.Color(192, 226, 247));
		toolbar.add(B_save);		

		//boutton enregistrer sous
		B_saveas = new JButton("ló’óö...");
		B_saveas.setIcon(new ImageIcon("./img/saveas.png"));
		B_saveas.setToolTipText("enregistrer fichier sous");
		B_saveas.addActionListener(this);
                B_saveas.setBackground(new java.awt.Color(192, 226, 247));
		toolbar.add(B_saveas);

		//boutton imprimer
		B_print = new JButton("Foko");
		B_print.setIcon(new ImageIcon("./img/Print.png"));
		B_print.setToolTipText("imprimer fichier (ctrl+P)");
		B_print.addActionListener(this);
                B_print.setBackground(new java.awt.Color(192, 226, 247));
		toolbar.add(B_print);

		//boutton ajout dico
		B_add = new JButton("Tswi'...");
		B_add.setIcon(new ImageIcon("./img/add.png"));
		B_add.setToolTipText("Ajouter au dico (ctrl+J)");
		B_add.addActionListener(this);
		B_add.setEnabled(false);
                B_add.setBackground(new java.awt.Color(192, 226, 247));
		toolbar.add(B_add);
		toolbar.addSeparator();

		//boutton copier
		B_copy = new JButton("lókóö");
		B_copy.setIcon(new ImageIcon("./img/Copy.png"));
		B_copy.setToolTipText("Copier (ctrl+C)");
		B_copy.addActionListener(this);
		B_copy.setEnabled(false);
		B_copy.setBackground(new java.awt.Color(192, 226, 247));
                toolbar.add(B_copy);

		//boutton couper
		B_cut = new JButton("zaà");
		B_cut.setIcon(new ImageIcon("./img/Cut.png"));
		B_cut.setToolTipText("Couper (ctrl+X)");
		B_cut.addActionListener(this);
		B_cut.setEnabled(false);
		B_cut.setBackground(new java.awt.Color(192, 226, 247));
                toolbar.add(B_cut);
                

		//boutton coller
		B_paste = new JButton("yátáö");
		B_paste.setIcon(new ImageIcon("./img/colle.png"));
		B_paste.setToolTipText("Coller (ctrl+V)");
		B_paste.addActionListener(this);
                B_paste.setBackground(new java.awt.Color(192, 226, 247));
		toolbar.add(B_paste);

		//boutton effacer
		B_erase = new JButton("pïùkáà");
		B_erase.setIcon(new ImageIcon("./img/Erase.png"));
		B_erase.setToolTipText("Supprimer (ctrl+E)");
		B_erase.addActionListener(this);
		B_erase.setEnabled(false);
                B_erase.setBackground(new java.awt.Color(192, 226, 247));
		toolbar.add(B_erase);

		//boutton selectionner tout
		B_allselect = new JButton("tsóà’..");
		B_allselect.setIcon(new ImageIcon("./img/selectall.png"));
		B_allselect.setToolTipText("selctionner tout (ctrl+A)");
		B_allselect.addActionListener(this);
                B_allselect.setBackground(new java.awt.Color(192, 226, 247));
		toolbar.add(B_allselect);
		toolbar.addSeparator();

		//boutton caractere speciaux
		B_carac = new JButton("Nén\u025B ta'...");
		B_carac.setIcon(new ImageIcon("./img/carac.png"));
		B_carac.setToolTipText("Clavier Visuel (ctrl+I)");
		B_carac.addActionListener(this);
                B_carac.setBackground(new java.awt.Color(192, 226, 247));
                
		toolbar.add(B_carac);

		//boutton console
		B_consol = new JButton("alana melo'");
		B_consol.setIcon(new ImageIcon("./img/consol.png"));
		B_consol.setToolTipText("Afficher/Masquer console (ctrl+F)");
		B_consol.addActionListener(this);
                B_consol.setBackground(new java.awt.Color(192, 226, 247));
		toolbar.add(B_consol);
		toolbar.addSeparator();

		//boutton aide
		B_help = new JButton("eàshúö’.");
		B_help.setIcon(new ImageIcon("./img/Help.png"));
		B_help.setToolTipText("Aide F1");
		B_help.addActionListener(this);
                B_help.setBackground(new java.awt.Color(192, 226, 247));
		toolbar.add(B_help);
                toolbar.addSeparator();
                rechercher.setBackground(new java.awt.Color(192, 226, 247));
                rechercher.setText("lefa’ nnÙ");
                toolbar.add(rechercher);
                math.setText("métzó a sāŋ");
                math.setBackground(new java.awt.Color(192, 226, 247));
                math.setToolTipText("caractère mathématiques");
                rechercher.setToolTipText("recherche d'un mot dans le texte");
                
                rechercher.addActionListener(this);
                

		//boutton quitter
		B_quit = new JButton("Tuo");
		B_quit.setIcon(new ImageIcon("./img/Exit.png"));
		B_quit.setToolTipText("Quitter (ctrl+Q)");
		B_quit.addActionListener(this);
                B_quit.setBackground(new java.awt.Color(192, 226, 247));
		toolbar.add(B_quit);
		toolbar.addSeparator();
                
               
		
   }
   
   
   public void config_popup(){
	   PM_EDIT = new JPopupMenu();
	   
	  	System.out.println("configuration click droit");
		  if(list_mot_possible.length>0){
			for(int i=0; i<mot_poss.length; i++){
			  if(i<list_mot_possible.length ){
				mot_poss[i]=new JMenuItem(list_mot_possible[i]);
				mot_poss[i].setFont(new Font("Arial", Font.BOLD,12));
				mot_poss[i].setForeground(Color.BLUE);
				mot_poss[i].addActionListener(this);
				PM_EDIT.add(mot_poss[i]);
				ind=i;
				  }  }  }  
			  		
		PM_EDIT.addSeparator();
			
                
		//ignorer
		ignorer = new JMenuItem("ignorer");
		ignorer.setToolTipText("ignorer");
		ignorer.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				textPane.replaceSelection(textPane.getSelectedText());}});
		PM_EDIT.add(ignorer);
		//ignorer
		
		//ignorer
		ignorertout = new JMenuItem("ignorer tout");
		ignorertout.setToolTipText("ignorer tout");
		ignorertout.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				textPane.replaceSelection(textPane.getSelectedText());}});	
		PM_EDIT.add(ignorertout);
                
                
                //traduire
		traduit = new JMenuItem("traduire le mot");
		traduit.setToolTipText("traduire");
                traduit.addActionListener(this);
                
                    
		PM_EDIT.add(traduit);
                
		
		//Ajouter au dictionnaire
		PMI_BIBLIO = new JMenuItem("Ajouter au dictionnaire");
		PMI_BIBLIO.addActionListener(this);
		PMI_BIBLIO.setToolTipText("selectionner le mot à ajouter dans le dictionnaire");
		PM_EDIT.add(PMI_BIBLIO);
		PM_EDIT.addSeparator();
		
		//Couper
		PMI_CUT = new JMenuItem("Couper");
		PMI_CUT.setToolTipText("Couper");
		PMI_CUT.addActionListener(this);
		PM_EDIT.add(PMI_CUT);
		
		//Copier
		PMI_COPY = new JMenuItem("Copier");
		PMI_COPY.setToolTipText("Copier");
		PMI_COPY.addActionListener(this);
		PM_EDIT.add(PMI_COPY);
		
		//Coller
		PMI_PASTE = new JMenuItem("Coller");
		PMI_PASTE.setToolTipText("Coller");
		PMI_PASTE.addActionListener(this);
		PM_EDIT.add(PMI_PASTE);
		
		//Effacer
		PMI_ERASE = new JMenuItem("Effacer");
		PMI_ERASE.setToolTipText("Effacer");
		PMI_ERASE.addActionListener(this);
		PM_EDIT.add(PMI_ERASE);
		
		//trait de separation
		PM_EDIT.addSeparator();
		
		//selectionner tout
		PMI_SLCTALL = new JMenuItem("Selectionner tout");
		PMI_SLCTALL.setToolTipText("Selectionner tout");
		PMI_SLCTALL.addActionListener(this);
		PM_EDIT.add(PMI_SLCTALL);

   }
   
   
   public void formater(int j,float w,float q) {  
	   float i = -0.08f;
      textPane.setFont(new Font("Verdana", Font.PLAIN, 13));
      textPane.setBackground(couleur_fond);
      defaut = textPane.getStyle("default");  
      document = textPane.getStyledDocument();
      switch(j){
		case 0 :{
              StyleConstants.setAlignment(defaut, StyleConstants.ALIGN_JUSTIFIED);
              break;}
		case 1 :{
		      StyleConstants.setAlignment(defaut, StyleConstants.ALIGN_CENTER);
		      break;}
		case 2 :{
		      StyleConstants.setAlignment(defaut, StyleConstants.ALIGN_LEFT);
		      break;}
		case 3 :{
		      StyleConstants.setAlignment(defaut, StyleConstants.ALIGN_RIGHT);
		      break;}
      }
     
      StyleConstants.setLeftIndent(defaut, 100.0F);
      StyleConstants.setRightIndent(defaut, 100.0F);
      StyleConstants.setSpaceAbove(defaut, w);
      StyleConstants.setSpaceBelow(defaut, q);
      StyleConstants.setLineSpacing(defaut, i);
      StyleConstants.setForeground(defaut, couleur_text);
      textPane.setParagraphAttributes(defaut, true);  
   }   
   
   
   public void actionPerformed(ActionEvent e) {
	  
      //SimpleAttributeSet attribut = new SimpleAttributeSet();
      if(e.getSource()==rechercher) {
          new MotRech(this,false).setVisible(true);
          
      }
      
      if(e.getSource()==math) new Math(this,true).setVisible(true);
      if(e.getSource() == traduit || e.getSource() == traduir ){
      String ch = this.textPane.getSelectedText().replace(' ', ',');
      String[] tab = ch.split(",");
      JOptionPane.showMessageDialog(this, tab[0]+" = "+this.traduire(tab[0]), "Traduction", JOptionPane.INFORMATION_MESSAGE);
      textPane.setCharacterAttributes(attribut, true);
      }
      if (e.getSource()==italic){
         
    	  StyleConstants.setItalic(attribut,italic.isSelected());   	
          StyleConstants.setUnderline(attribut,soulign.isSelected());
    	  StyleConstants.setBold(attribut, gras.isSelected());
      
      } 
      
      if (e.getSource()==gras){ 
          
          
    	  //StyleConstants.setItalic(attribut,false);
         // gras.setBackground(new java.awt.Color(226, 161, 49));  
          StyleConstants.setUnderline(attribut,soulign.isSelected());
    	  StyleConstants.setBold(attribut, gras.isSelected());
          StyleConstants.setItalic(attribut,italic.isSelected());  
      }

      if (e.getSource()==soulign){
          StyleConstants.setUnderline(attribut,soulign.isSelected());
          StyleConstants.setBold(attribut, gras.isSelected());
         StyleConstants.setItalic(attribut,italic.isSelected());  
      
        }
      if (e.getSource()==sub)  StyleConstants.setSubscript(attribut, sub.isSelected());
      
      if (e.getSource()==maj){
          if(maj.isSelected()){
          String texts = textPane.getSelectedText();
          textPane.replaceSelection(texts.toUpperCase());
          
          }else{
          
          String texts = textPane.getSelectedText();
          textPane.replaceSelection(texts.toLowerCase());
          
          
          }
      }
      
      if (e.getSource()==sup){ StyleConstants.setSuperscript(attribut, sup.isSelected());}
      if (e.getSource()==droit) {
    	   x=2;
    	  formater(x,sa,sb); }
      if (e.getSource()==gauch){
    	  x=3;
    	  formater(x,sa,sb); 
      }
      if (e.getSource()==centre){
    	  x=1;
    	  formater(x,sa,sb); 
      }
      if (e.getSource()==justif){
    	  x=0;
    	  formater(x,sa,sb); 
      }
      if(e.getSource()==puce) {
          new Puce(this,true).setVisible(true);
      }

         
      if (e.getSource()==tcouleur) {
    	 
    	 couleur_text = JColorChooser.showDialog(this, "Couleur du texte", couleur_text); 
         coul1.setBackground(couleur_text);
         StyleConstants.setForeground(attribut, couleur_text);
      }
      
      if (e.getSource()==surbrillance) {
    	 if(textPane.getSelectedText() != null){
              try {
    	 Color c = JColorChooser.showDialog(this, "Couleur de surbrillance", couleur_text); 
         coul.setBackground(c);
         
                  if(c != null){
                  Style surbri = textPane.addStyle("surbri", styleRacine); 
                  surbri.addAttributes(attribut);
                 // surbri.addAttributes(attribut);
                  String txt = textPane.getSelectedText();
                  int selectS = textPane.getSelectionStart();
                  int selectE = textPane.getSelectionEnd();
                  if(selectS > selectE){
                  textPane.replaceSelection("");
                  StyleConstants.setBackground(surbri, c);
                  documentAssocie.insertString(selectE, txt, surbri);
                  }else{
                     
                       textPane.replaceSelection("");
                       StyleConstants.setBackground(surbri, c);
                       documentAssocie.insertString(selectS, txt, surbri);
                      
                  }
                 // attribut.addAttributes(surbri);
                  }
              } catch (BadLocationException ex) {
                  Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
              }
         }else{
         StyleConstants.setBackground(attribut, Color.WHITE);
         }
      }
       
      if (e.getSource()==fcouleur) {
          couleur_fond = JColorChooser.showDialog(this, "Couleur du textPane", couleur_fond); 
          textPane.setBackground(couleur_fond);
          coul2.setBackground(couleur_fond);    
       }
      if (MI_INSERT == e.getSource() || B_carac == e.getSource()){
    	  
			if (!exit){
                           d.setBounds(Longueur-1225,Largeur-668,Longueur-460, Largeur-222);
                                inser.panolettre.setBounds(Longueur-310, Largeur-668,Longueur-1090, Largeur-220);
				inser.panolettre.setVisible(true);
				exit = true;
                                
				//SwingUtilities.updateComponentTreeUI(Editor.this);
				}
			else{
                           d.setBounds(Longueur-1125,Largeur-668,Longueur-460, Largeur-222);
                           inser.panolettre.setBounds(Longueur-180, Largeur-668,Longueur-1230, Largeur-190);
				inser.panolettre.setVisible(false);
				exit=false;
			}
		}

		//si l'action vient du menu afficher ou masquer la console
		if (MI_CONSOL == e.getSource() || B_consol == e.getSource()){
			if ( !Erreur.isVisible() ){
				Erreur.setVisible(true);
				SwingUtilities.updateComponentTreeUI(Editor.this); 
			}else{
				Erreur.setVisible(false);
				SwingUtilities.updateComponentTreeUI(Editor.this);
			}
		}

		//si l'action vient du menu nouveau document
		if (MI_NEW == e.getSource() || B_new == e.getSource()){
			SwingUtilities.updateComponentTreeUI(fileChooser);
			nouveauFichier();
		}

		//si l'action vient du menu enregistre
		if (MI_SAVE == e.getSource() || B_save == e.getSource()){
			 
		      ch=superpop();
		      fich= new Fichier(ch);
		      
			fileChooser.addChoosableFileFilter((FileFilter)filter);
			enregistrerFichier();}

		//si l'action vient du menu enregistre sous
		if (MI_SAVEAS == e.getSource() || B_saveas == e.getSource()){
			 
		      ch=superpop();
		      fich= new Fichier(ch);
		      
			fileChooser.addChoosableFileFilter((FileFilter)filter);
			enregistrerFichierSous();				
		}
		
		//si l'action vient du menu imprimer
		if (MI_PRINT == e.getSource() || B_print == e.getSource())
			Imprimer();

		//si l'action vient du menu afficher ou masquez barre d'outil
		if ( MI_TBAR == e.getSource() ) {
			if ( toolbar.isVisible() ) toolbar.setVisible(false);
			else toolbar.setVisible(true);
		}
		
		//si l'action vient du menu quitter
		if (MI_EXIT == e.getSource() || B_quit == e.getSource()){
			if (JOptionPane.showConfirmDialog(null, "voulez vous vraiment quitter?", "QUITTER", JOptionPane.YES_NO_OPTION)==0)System.exit(0);
		}

		//si l'action vient d'un element etiquetter "Couper"
		if ( "Couper" == e.getActionCommand() || B_cut == e.getSource() )
			textPane.cut();

		//si l'action vient d'un element etiquetter "Copier"
		if ( "Copier" == e.getActionCommand() || B_copy == e.getSource() )
			textPane.copy();

		//si l'action vient d'un element etiquetter "Coller"
		if ( "Coller" == e.getActionCommand() || B_paste == e.getSource() )
			textPane.paste();

		//si l'action vient d'un element etiquetter "Supprimer"
		if ( "Effacer" == e.getActionCommand() || "Effacer" == e.getActionCommand() || B_erase == e.getSource() )
			textPane.replaceSelection("");

		//si l'action vient d'un element etiquetter "Selectionner tout"
		if ( "Selectionner tout" == e.getActionCommand() || B_allselect == e.getSource() )
			textPane.selectAll();

		//si l'action vient d'un element etiquetter "Ajouter au dictio"
		
		if (MI_BIBLIO == e.getSource() )ajouterBibliotheque(textPane.getSelectedText());

		if ( "Ajouter au dictionnaire" == e.getActionCommand() || B_add == e.getSource() )ajouterBibliotheque(textPane.getSelectedText());

		//si l'action est de modiffier la couleur de fond
		for (int i = 0; i < nomCouleur1.length; i++) {
			if (couleurFond[i] == e.getSource()){
				textPane.setBackground(couleur1[i]);
                         break;
                        }
		}

		//si l'action est de modiffier la couleur du texte
		for (int i = 0; i < nomCouleur2.length; i++) {
			if (couleurTexte[i] == e.getSource()){
				textPane.setForeground(couleur2[i]);
                         break;
                        }
		}

		//si l'action est de modifier la taille de ecrit dans la zone de saisie
		for(int i=0;i<taille1.length;i++){
			if(tailleFond[i]==e.getSource()){		    		
				textPane.setFont(new Font("Times new roman", 0, taille1[i]));
			}
		}

		// si l'action est d'affiche le commentaire
		if (MI_CMT == e.getSource())
			afficheMessage(getComments(), "Commentaires");

		if (MI_HELP == e.getSource()|| B_help == e.getSource() ){
			try {
				
				// 1. create HelpSet and HelpBroker objects
				final HelpSet hs = getHelpSet("yembaHelp.hs");

				// 2. assign help to components
				final HelpBroker hb = hs.createHelpBroker();
				
				//CSH.setHelpIDString(getJButtonAide(), "top");
				hb.showID("yemba.lance",
						"javax.help.SecondaryWindow", null);

			} catch (final Exception e1) {
				System.out.println("message :" + e1.getMessage());
			}
		}

		if (MI_ABOUT == e.getSource()) afficheMessage(getAbout(), "à Propos");
		if (mot_poss[0] == e.getSource()){
			if(!list_mot_possible[0].equals(correct.mess_aucun))textPane.replaceSelection(list_mot_possible[0]);
		}
		if (mot_poss[1] == e.getSource()){
			if(!list_mot_possible[1].equals(correct.mess_aucun))textPane.replaceSelection(list_mot_possible[1]);
		}
		if (mot_poss[2] == e.getSource()){
			if(!list_mot_possible[2].equals(correct.mess_aucun))textPane.replaceSelection(list_mot_possible[2]);
		}
		if (mot_poss[3] == e.getSource()){
			if(!list_mot_possible[3].equals(correct.mess_aucun))textPane.replaceSelection(list_mot_possible[3]);
		}
		if (mot_poss[4] == e.getSource()){
			if(!list_mot_possible[4].equals(correct.mess_aucun))textPane.replaceSelection(list_mot_possible[4]);
		}
		this.attribut.addAttributes(attribut);
      textPane.setCharacterAttributes(attribut, true);
      textPane.repaint();
      textPane.requestFocus();
       }
   
   
   public void caretUpdate(CaretEvent e) {
      AttributeSet attribut= textPane.getCharacterAttributes();
      Enumeration liste = attribut.getAttributeNames();
      ArrayList<String> noms = new ArrayList<String>();
      while (liste.hasMoreElements()) noms.add(liste.nextElement().toString());
            
        barre1.revalidate();
        enreg=true;
	B_save.setEnabled(true);
	B_saveas.setEnabled(true);
	if (textPane.getSelectedText() == null) {
		B_copy.setEnabled(false);
		B_cut.setEnabled(false);
		B_cut.setEnabled(false);
		B_erase.setEnabled(false);
		B_add.setEnabled(false);
                surbrillance.setEnabled(false);
                traduir.setEnabled(false);
                
	} else {
		B_copy.setEnabled(true);
		B_cut.setEnabled(true);
		B_cut.setEnabled(true);
		B_erase.setEnabled(true);
		B_add.setEnabled(true);
                surbrillance.setEnabled(true);
                traduir.setEnabled(true);
	}
	pos_curseur=textPane.getSelectionStart();
	
	int init=pos_curseur,fin=pos_curseur+1;
	String carac=new String();
		
	carac=textPane.getSelectedText();
	
		
	try
	{
	    correct=new Correcteur(this);
	    carac=textPane.getSelectedText();
	    correct.mot_possible(carac);
	    list_mot_possible=correct.affiche(correct.l_mot);
	    config_popup();
	}
	catch (NullPointerException ee){
		ee.printStackTrace();
	}
	
	 barre1.revalidate();
   }
   
   
   public void outil_text() {
	   	
	   	    toolbar2=new JToolBar();
			JPanel pp=new JPanel();
			pp.setPreferredSize(new Dimension(100,45));
			
			outil_presse();
			outil_police1();
			outil_police2();
			outil_paragraph();
			outil_couleur();
                        p1.setBackground(new java.awt.Color(192, 226, 247));
                        p2.setBackground(new java.awt.Color(192, 226, 247));
                        p3.setBackground(new java.awt.Color(192, 226, 247));
                        p5.setBackground(new java.awt.Color(192, 226, 247));
			toolbar2.add(p1);
			toolbar2.add(p2);
			toolbar2.add(p5);
			toolbar2.add(p3);
			//toolbar2.add(p4);
                JPanel p = new JPanel(); 
                p.setMaximumSize(new Dimension(100,48));
                p.add(coul1);
                p.add(tcouleur);
                p.setBackground(new java.awt.Color(192, 226, 247));
                toolbar2.add(p);
		
		JPanel p2 = new JPanel();
                p2.setMaximumSize(new Dimension(100,48));
                p2.add(coul2);
                p2.add(fcouleur);
                p2.setBackground(new java.awt.Color(192, 226, 247));
                
                toolbar2.add(p2);
		
               JPanel p3 = new JPanel();
               p3.setMaximumSize(new Dimension(100,48));
               p3.add(coul);
               surbrillance.setEnabled(false);
               p3.add(surbrillance);
               p3.setBackground(new java.awt.Color(192, 226, 247));               
               toolbar2.add(p3);
		
                        toolbar2.addSeparator();
                        toolbar2.add(math);
                        toolbar2.add(puce);
                        traduir.setEnabled(false);
                        traduir.setOpaque(false);
                        toolbar2.add(traduir);
                        pp.setBackground(new java.awt.Color(192, 226, 247));
                
			toolbar2.add(pp);
     		        toolbar2.setFloatable(false);
			toolbar2.setSize(5000, 45);
                       // toolbar3 = new JToolBar();
                       // toolbar3.add(math);
                        puce.setText("nsāŋ pō nzō");
                        puce.setToolTipText("les puce");
                        traduir.setText("traduire un mot");
                        traduir.setToolTipText("traduire un mot yemba");
	   }
  
   
   
   public void outil_presse(){
		
   	JPanel p11=new JPanel();
   	p11.setLayout(new GridLayout(1,3));
		
		maj.setToolTipText("Maj/Min");
		sub.setToolTipText("mettre en indice");
		sup.setToolTipText("exposant");
		p11.add(maj);
		p11.add(sub);
		p11.add(sup);
		p1.setLayout(new GridLayout(1,1));
		p1.add(p11);	
		p1.setPreferredSize(new Dimension(45,10));
		p1.setBorder(BorderFactory.createTitledBorder(""));
	   }
   
   
   
   public void outil_police1(){
    ArrayList<String> lp=(new ObjetUtile()).ListePolice;
    
   	JPanel p22=new JPanel();
   	 p22.setBackground(new java.awt.Color(192, 226, 247));
         p2.setBackground(new java.awt.Color(192, 226, 247));
         inter.setBackground(new java.awt.Color(192, 226, 247));
                      
         
   	police.addItem("ŋkāŋ nti letī");
   	for(int i=0; i<lp.size(); i++){
   		police.addItem(lp.get(i));
   	}
   	
   	taille.addItem("efuε’");
   	for(int i=8; i<13; i++){
   		taille.addItem(""+i);
   	}
        for(int i=14; i<31; i+=2){
   		taille.addItem(""+i);
   	}
        for(int i=32; i<84; i+=4){
   		taille.addItem(""+i);
   	}
   	
   	inter.addItem("leta");
   	for(int i=1; i<11; i++){
   		inter.addItem(""+i);
   	}
        
   	
   	    p22.add(police);
		p22.add(taille);
		p22.add(inter);
		p2.setLayout(new GridLayout(1,1));
		p2.add(p22);
		p2.setPreferredSize(new Dimension(242,10));
		p2.setBorder(BorderFactory.createTitledBorder(""));
		
		police.setToolTipText("Police");
		taille.setToolTipText("Taille");
		inter.setToolTipText("Interligne");
		
	
   }
   public  void outil_police2(){
	   
   	    p5.setLayout(new GridLayout(1,1));
  	
   	    JPanel to2=new JPanel(new GridLayout(1,3));
   	 
//   	    to2.add(init);
   	    to2.add(gras);
		to2.add(italic);
		to2.add(soulign);	
		p5.add(to2);
		p5.setPreferredSize(new Dimension(60,10));
		p5.setBorder(BorderFactory.createTitledBorder(""));
		
		//init.setToolTipText("Annuler l'effet Gras ou Italic");
		//init.setFocusPainted(false);
		gras.setToolTipText("Gras");
              // gras.setSelectedIcon(new ImageIcon("images/grasselect.jpg"));
                // gras.setBackground(new java.awt.Color(226, 161, 49)); 
                
		gras.setFocusPainted(false);
		italic.setToolTipText("Italic");
		italic.setFocusPainted(false);
		soulign.setToolTipText("Souligné");
		soulign.setFocusPainted(true);
		
		italic.addActionListener(this);
      		//init.addActionListener(this);
		gras.addActionListener(this);
		soulign.addActionListener(this);
    }
   
   
   public void outil_paragraph(){
   	
   	    JPanel to3=new JPanel(new GridLayout(1,4));
   	 
		to3.add(droit);
		to3.add(centre);
		to3.add(gauch);
		to3.add(justif);
		p3.setLayout(new GridLayout(1,1));
		p3.add(to3);
		p3.setPreferredSize(new Dimension(60,10));
		p3.setBorder(BorderFactory.createTitledBorder(""));
		droit.setToolTipText("Aligner le texte à gauche");
		gauch.setToolTipText("Aligner le texte à droite");
		centre.setToolTipText("Aligner le texte au centre");
		justif.setToolTipText("Aligner le texte au centre justifier");
	   }
   
   
   public void outil_couleur(){
   	   JPanel to4=new JPanel();
        
   	   JLabel titp4=new JLabel("Couleur");
   	   Font font=new Font("Arial",Font.BOLD,12);
   	   
		titp4.setFont(font);

		coul1.setBackground(couleur_text);
		coul2.setBackground(couleur_fond);
                coul.setBackground(Color.WHITE);
		coul1.setPreferredSize(new Dimension(20,20));
		coul2.setPreferredSize(new Dimension(20,20));
                coul.setPreferredSize(new Dimension(20,20));
               
                
		
               
                
                
		
		tcouleur.setToolTipText("Choix de la couleur du text");
		fcouleur.setToolTipText("Choix de la couleur de fond d'ecran");
                surbrillance.setToolTipText("Choix de la couleur de surbrillance d'une partie du texte");
		p4.setPreferredSize(new Dimension(300,100));
                
		p4.setBorder(BorderFactory.createTitledBorder("hj"));
		
   	
   }
   
 
   
   public void updateMenuOptions() {
		if (textPane.getSelectedText() == null) {
			MI_CUT.setEnabled(false);
			MI_COPY.setEnabled(false);
			MI_ERASE.setEnabled(false);
			MI_BIBLIO.setEnabled(false);
		}
		else {
			MI_CUT.setEnabled(true);
			MI_COPY.setEnabled(true);
			MI_ERASE.setEnabled(true);
			MI_BIBLIO.setEnabled(true);
		}
	}
   
   
  public void nouveauFichier() {
		fichierCourant = null;
		/*Erreur.setText("CTRL+F pour masquer/afficher les\nFautes d'orthographe:\n");
		textPane.setText("");
		setTitle("         CamEditor : Document sans nom.cam");  */
	   int rep=JOptionPane.showConfirmDialog (this, "voulez enregistrer les modifications sur ce document ?",
               "enregistrer", JOptionPane.YES_NO_CANCEL_OPTION) ;
	   if (rep==JOptionPane.YES_OPTION){                                   ///////////////////////////////////////////////////////////////////////
		   enregistrerFichier();
		   dispose();
		   new Editor();
	   }
	   else if(rep==JOptionPane.NO_OPTION){
		   dispose();
		   new Editor();
	   }
	   else{
		   
	   }
	   
	}

   
  	 // cette fonction retoune un objet yem contenant le texte en cour de traitement
	 
	public String superpop(){
		 
	      String k = (String)textPane.getText();
	      
	      System.out.println("ok  "+k);
	    			
	      return k;
	}

	 //ette fonction nous permet d'enregistrer un fichier en cour de traitement sans demande de confirmation de l'enregistrement
	
	
	public void enregistrerFichier() {
		
		if (this.fichierCourant !=  null) {
			
			try {
				FileOutputStream fis = new FileOutputStream(this.fichierCourant);
				ObjectOutputStream ois = new ObjectOutputStream(fis);		
				
				ois.writeObject(fich);
				ois.flush();
                                
				
				ois.close();
				
			}catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException ee) {
				ee.printStackTrace();
			}
		}
		else {
			enregistrerFichierSous();
		}}

	//cette fonction donne a l'utilisateur une fenetre lui permettant de faire l'enregistrement de son  document en cour de traitement
	
	@SuppressWarnings("static-access")
	
	public void enregistrerFichierSous()
    {
        fileChooser.showSaveDialog(this);
        File tmpFile = fileChooser.getSelectedFile();
        if(fileChooser.getSelectedFile() != null)
        {
            tmpFile = fileChooser.getSelectedFile();
            if(fileChooser.getFileFilter().accept(tmpFile))
            {
                fichierCourant = tmpFile;
                try
                {
                    FileOutputStream fis = new FileOutputStream(fichierCourant);
                    ObjectOutputStream ois = new ObjectOutputStream(fis);
                    ois.writeObject(fich);
                    ois.flush();
                    System.out.println(fich.chain);
                    ois.close();
                    
                }
                catch(Exception err)
                {
                    err.printStackTrace();
                }
            } else
            {
               
                JOptionPane.showMessageDialog(null, "Format incorrect  (.cam)! \n Echec de sauvegarde!", "Erreur", 0);
            }
        }
    }

	//cette fonction permet de verifier si un mot appartient au dictionnaire ou non et le signal dans la zone d'erreur au cas ou ce dernier n'est pas le dictionnaire
	
	
	public void recherche(){
		StringTokenizer ligne;
		boolean NonTrouver = true;
		//int lig;
		String val = "";
		
	}

	public HelpSet getHelpSet(String helpsetfile) {
		HelpSet hs = null;
		final ClassLoader cl = this.getClass().getClassLoader();
		try {
			final URL hsURL = HelpSet.findHelpSet(cl, helpsetfile);
			hs = new HelpSet(null, hsURL);
			System.out.println("HelpSet trouve son chemin est : "
					+ hsURL.getPath().toString());
		} catch (final Exception ee) {
			System.out.println("HelpSet: " + ee.getMessage());
			System.out.println("HelpSet: " + helpsetfile + " not found");
		}
		return hs;
	}	

	public void afficheMessage(String message, String titre) {
		JOptionPane.showMessageDialog(null, message,
				titre, JOptionPane.INFORMATION_MESSAGE);
	}


	public String getComments() {
		return "Nous avons concus cette application dans le but de revaloriser les langues vernaculaire à l'exemple du yemba.\n      -INF 03";
	}

	public String getAbout() {
		return "Vous pouvez modifier le contenu de ce programme, à condition d'indiquer " +
		"\n les changements apport&s ainsi que votre nom. Comme suit: " +
		"\n\nModifié par: INFORMATIQUE FONDAMENTALE \ndate: juillet 2013.\n\n   Merci, \n      -INF 3";
	}

	public void Imprimer() {

		if (!textPane.getText().equals("")){
			try {
				textPane.print();
			} catch (PrinterException e) {
				e.printStackTrace();
			}
		}
	}

	public void rafrechir() {

		textPane.setText("");
		//textPane.setText(g.toString());
	}
	
	
	public boolean test_mot_exist(String mot) {
		String url = "jdbc:hsqldb:data/DICO";
		String user = "sa";
		String passwd = "";

		boolean test=false;
		ArrayList<String> list=new ArrayList<String>();
		try{
					Class.forName("org.hsqldb.jdbcDriver").newInstance();
					
					Connection conn = DriverManager.getConnection(url, user, passwd);
					System.out.println("test mo de classe editor");
                                        PreparedStatement pre = conn.prepareStatement("SELECT * FROM dictionnaire WHERE MOT = ?");
                                        pre.setString(1, mot);
                                        ResultSet res = pre.executeQuery();
                                        if(res.next()){ test = true;}
                                        
                                                       
                                        
                                        
				}catch(Exception e){
				
				}
			return test;
	}
	public void ajouterBibliotheque(String mot){
		ArrayList<String> liste=new ArrayList<String>();
		String url = "jdbc:hsqldb:data/DICO";
		String user = "sa";
		String passwd = "";
		if(!test_mot_exist(mot)){
		try {
			Class.forName("org.hsqldb.jdbcDriver").newInstance();
			Connection conn = DriverManager.getConnection(url, user, passwd);		
			Statement state = conn.createStatement();
			state.executeUpdate("INSERT INTO dictionnaire (mot) VALUES ('"+mot+"')");
			JOptionPane.showMessageDialog(null, "mot enregistre avec succès", "Information", JOptionPane.INFORMATION_MESSAGE);
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
		else{
			JOptionPane.showMessageDialog(null, "Ce mot existe deja dans le dictionnaire", "Information", JOptionPane.INFORMATION_MESSAGE);
		}
	
	}
	
	public void updatePopupOptions() {
		if (textPane.getSelectedText() == null) {
			PMI_CUT.setEnabled(false);
			PMI_COPY.setEnabled(false);
			PMI_ERASE.setEnabled(false);
			PMI_BIBLIO.setEnabled(false);
                        traduit.setEnabled(false);
		}
		else {
			PMI_CUT.setEnabled(true);
			PMI_COPY.setEnabled(true);
			PMI_ERASE.setEnabled(true);
			PMI_BIBLIO.setEnabled(true);
                        traduit.setEnabled(true);
		}
	}
	
	public void soulign_mot(int d,int f, Color c){
		textPane.select(d, f);
		StyleConstants.setUnderline(attribut,true); 
	}
        
        public String traduire(String mot){
                                String url = "jdbc:hsqldb:data/DICO",url2 = "jdbc:hsqldb:data/FRANC";
				String user = "sa";
				String passwd = "";

				boolean yem=false,fran=false;
				try{
                                        Statement state=null;
					Class.forName("org.hsqldb.jdbcDriver").newInstance();
					System.out.println("method truduction");
					Connection conn = DriverManager.getConnection(url, user, passwd);
					
                                        PreparedStatement pre = conn.prepareStatement("SELECT * FROM dictionnaire WHERE MOT = ?");
                                        pre.setString(1, mot);
                                        ResultSet res = pre.executeQuery();
                                        if(res.next()){ yem = true;}
                                        
                                        conn = DriverManager.getConnection(url2, user, passwd);
					
                                        pre = conn.prepareStatement("SELECT * FROM FRAN WHERE MOT = ?");
                                        pre.setString(1, mot);
                                        res = pre.executeQuery();
                                        if(res.next()){ fran = true;}
                                        int n =1;
                                        if(yem){
                                        System.out.println("mot kjjjjjjjjjjjjjjjjjj yemba !!!!");
                                        conn = DriverManager.getConnection(url, user, passwd);    
                                        state= conn.createStatement();   
                                        res = state.executeQuery("SELECT * FROM DICTIONNAIRE");
                                        while(res.next() && !mot.equals(res.getString("MOT")))n++;
                                        
                                        conn = DriverManager.getConnection(url2, user, passwd);    
                                        state= conn.createStatement();   
                                        res = state.executeQuery("SELECT * FROM FRAN");
                                        int i=1;
                                         while(res.next() && i<n )i++;
                                        
                                        return res.getString("MOT");
                                        }else if(fran){
                                            System.out.println("mot francais!!!! !");
                                        res = state.executeQuery("SELECT * FROM FRAN");
                                        while(res.next() && mot!=res.getString("MOT"))n++;
                                        
                                        conn = DriverManager.getConnection(url, user, passwd);    
                                        state= conn.createStatement();   
                                        res = state.executeQuery("SELECT * FROM DICTIONNAIRE");
                                        int i=1;
                                         while(res.next() && i<n )i++;
                                        
                                        return res.getString("MOT");
                                        
                                       
                                        }else{
                                        
                                        
                                        return "mot introuvable";
                                        }
                                        
                                                       
                                        
                                      
				}catch(Exception e){
				
				}
        
        
        
        return "mot introuvable";  
        }
                
        
        public void appendStyledLineTextAt(int offset, String text, String nomStyle)
	throws BadLocationException{
		documentAssocie.insertString(offset, text, documentAssocie.getStyle(nomStyle));
	}
        private DefaultStyledDocument documentAssocie = new DefaultStyledDocument();
        Style styleRacine = StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);
        

    public void windowOpened(WindowEvent e) {}

    public void windowClosing(WindowEvent e) {
    if(enreg){
    
     int rep=JOptionPane.showConfirmDialog (this, "voulez-vous enregistrer les modifications apportées à "+this.titrefichier+" ?",
               "Yemba Editor 2013", JOptionPane.YES_NO_CANCEL_OPTION) ;
     if (rep==JOptionPane.YES_OPTION){
                   this.enregistrerFichier();
                   System.exit(0);
                   
    }else if(rep==JOptionPane.NO_OPTION){
		   System.exit(0); 
	   }
	   else{
		  
	   }
	   
    }
    
    }
    public void windowClosed(WindowEvent e) {
    
    }
    
    public void windowIconified(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}
    public void windowActivated(WindowEvent e) {}
   public void windowDeactivated(WindowEvent e) {}
   
}



