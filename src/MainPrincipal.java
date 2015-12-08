import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;


public class MainPrincipal implements Serializable{
	

	private static final long serialVersionUID = 1657795754520065527L;


	public static void main(String[] s) {
            
		Editor app = new Editor();
		app.setResizable(false);
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			SwingUtilities.updateComponentTreeUI(app);
		} catch (final Exception e) {
		}
		}

}
  