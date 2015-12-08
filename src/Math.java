/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

/**
 *
 * @author Gaetan
 */
public class Math extends javax.swing.JDialog  implements ActionListener{

    /**
     * A return status code - returned if Cancel button has been pressed
     */
    public static final int RET_CANCEL = 0;
    /**
     * A return status code - returned if OK button has been pressed
     */
    public static final int RET_OK = 1;

    /**
     * Creates new form Math
     */
    Editor ed;
    public Math(Editor parent, boolean modal) {
        
        super(parent, modal);
        initComponents();
        ed = parent;
        // Close the dialog when Esc is pressed
        String cancelName = "cancel";
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), cancelName);
        ActionMap actionMap = getRootPane().getActionMap();
        actionMap.put(cancelName, new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                doClose(RET_CANCEL);
            }
        });
        
        
        setLocationRelativeTo(null);
        
        tabb[0] = new JButton("∞");
        tabb[1] = new JButton("±");
        tabb[2] = new JButton("≠");
        tabb[3] = new JButton("×");
        tabb[4] = new JButton("÷");
        tabb[5] = new JButton("∝");
        tabb[6] = new JButton("≪");
        tabb[7] = new JButton("≫");
        tabb[8] = new JButton("≤");
        tabb[9] = new JButton("≥");
        tabb[10] = new JButton("∓");
        tabb[11] = new JButton("≅");
        tabb[12] = new JButton("≈");
        tabb[13] = new JButton("≡");
        tabb[14] = new JButton("∀");
        tabb[15] = new JButton("∁");
        tabb[16] = new JButton("∂");
        tabb[17] = new JButton("√");
        tabb[18] = new JButton("∛");
        tabb[19] = new JButton("∜");
        tabb[20] = new JButton("∩");
        tabb[21] = new JButton("∪");
        tabb[22] = new JButton("∅");
        tabb[23] = new JButton("∆");
        tabb[24] = new JButton("∇");
        tabb[25] = new JButton("∃");
        tabb[26] = new JButton("∄");
        tabb[27] = new JButton("∈");
        tabb[28] = new JButton("∋");
        tabb[29] = new JButton("←");
        tabb[30] = new JButton("↑");
        tabb[31] = new JButton("→");
        
        tabb[32] = new JButton("↓");
        tabb[33] = new JButton("↔");
        tabb[34] = new JButton("∴");
        tabb[35] = new JButton("⋮");
        tabb[36] = new JButton("∎");
        tabb[37] = new JButton("α");
        tabb[38] = new JButton("β");
        tabb[39] = new JButton("γ");
        tabb[40] = new JButton("δ");
        tabb[41] = new JButton("ε");
        tabb[42] = new JButton("ϵ");
        tabb[43] = new JButton("ζ");
        tabb[44] = new JButton("η");
        tabb[45] = new JButton("θ");
        tabb[46] = new JButton("ϑ");
        tabb[47] = new JButton("π");
        tabb[48] = new JButton("ω");
        tabb[49] = new JButton("ψ");
        tabb[50] = new JButton("χ");
        tabb[51] = new JButton("ϕ");
        tabb[52] = new JButton("φ");
        tabb[53] = new JButton("ϖ");
        tabb[54] = new JButton("σ");
        tabb[55] = new JButton("τ");
        tabb[56] = new JButton("Γ");
        tabb[57] = new JButton("Ξ");
        tabb[58] = new JButton("Δ");
        tabb[59] = new JButton("Λ");
        tabb[60] = new JButton("Π");
        tabb[61] = new JButton("Φ");
        tabb[62] = new JButton("Ψ");
        tabb[63] = new JButton("Ω");
        
        
        for(int i = 0; i<64; i++){
        tabb[i].addActionListener(this);
        panbase.add(tabb[i]);
        }


        tabo[0] = new JButton("+");
        tabo[1] = new JButton("-");
        tabo[2] = new JButton("÷");
        tabo[3] = new JButton("×");
        tabo[4] = new JButton("±");
        tabo[5] = new JButton("∝");
        tabo[6] = new JButton("∘");
        tabo[7] = new JButton("⊎");
        tabo[8] = new JButton("⋄");
        tabo[9] = new JButton("∧");
        tabo[10] = new JButton("≠");
        tabo[11] = new JButton("<");
        tabo[12] = new JButton(">");
        tabo[13] = new JButton("≤");
        tabo[14] = new JButton("≥");
        tabo[15] = new JButton("≮");
        tabo[16] = new JButton("≰");
        tabo[17] = new JButton("≯");
        tabo[18] = new JButton("≱");
        tabo[19] = new JButton("≡");
        tabo[20] = new JButton("∼");
        tabo[21] = new JButton("≃");
        tabo[22] = new JButton("≈");
        tabo[23] = new JButton("≅");
        tabo[24] = new JButton("≢");
        tabo[25] = new JButton("≄");
        tabo[26] = new JButton("≉");
        tabo[27] = new JButton("∈");
        tabo[28] = new JButton("∉");
        tabo[29] = new JButton("⊂");
        tabo[30] = new JButton("⊃");
        tabo[31] = new JButton("⊆");
        tabo[32] = new JButton("⊇");
        tabo[33] = new JButton("∑");
        tabo[34] = new JButton("∫");
        tabo[35] = new JButton("∬");
        tabo[36] = new JButton("∭");
        tabo[37] = new JButton("∮");
        tabo[38] = new JButton("∯");
        tabo[39] = new JButton("∰");
        tabo[40] = new JButton("∨");
        tabo[41] = new JButton("∏");
        tabo[42] = new JButton("∐");
        tabo[43] = new JButton("≪");
        tabo[44] = new JButton("≫");
        tabo[45] = new JButton("≺");
        tabo[46] = new JButton("≻");
        tabo[47] = new JButton("≼");
        tabo[48] = new JButton("≽");
        tabo[49] = new JButton("⊏");
        tabo[50] = new JButton("⊐");
        tabo[51] = new JButton("⊑");
        tabo[52] = new JButton("⊒");
        tabo[53] = new JButton("∥");
        tabo[54] = new JButton("⊥");
        tabo[55] = new JButton("⊢");
        tabo[56] = new JButton("⊣");
        tabo[57] = new JButton("⋈");
        tabo[58] = new JButton("≍");
        tabo[59] = new JButton("⊚");
        tabo[60] = new JButton("⋋");
        tabo[61] = new JButton("∪");
        tabo[62] = new JButton("∖");
        tabo[63] = new JButton("∩");


        for(int i = 0; i<64; i++){
        tabo[i].addActionListener(this);
        panoper.add(tabo[i]);
        }

        
    }
    JButton[] tabb = new JButton[64];
    JButton[] tabo = new JButton[64];

    /**
     * @return the return status of this dialog - one of RET_OK or RET_CANCEL
     */
    public int getReturnStatus() {
        return returnStatus;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        panbase = new javax.swing.JPanel();
        panoper = new javax.swing.JPanel();
        annuler = new javax.swing.JButton();

        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        panbase.setLayout(new java.awt.GridLayout(8, 8, 5, 5));
        jTabbedPane1.addTab("Caractère de base", panbase);

        panoper.setLayout(new java.awt.GridLayout(8, 8, 5, 5));
        jTabbedPane1.addTab("Opérateur", panoper);

        annuler.setText("Annuler");
        annuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                annulerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(236, 236, 236)
                        .addComponent(annuler))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(annuler)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        doClose(RET_CANCEL);
    }//GEN-LAST:event_closeDialog

    private void annulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_annulerActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_annulerActionPerformed
    
    private void doClose(int retStatus) {
        returnStatus = retStatus;
        setVisible(false);
        dispose();
    }

    /**
     * @param args the command line arguments
     */
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton annuler;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel panbase;
    private javax.swing.JPanel panoper;
    // End of variables declaration//GEN-END:variables
    private int returnStatus = RET_CANCEL;
    
    
    
   //ecouteur des boutons du panbase
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == tabb[0]){ ed.textPane.replaceSelection("∞"); }
        if(e.getSource() == tabb[1]){ ed.textPane.replaceSelection("±"); }
        if(e.getSource() == tabb[2]){ ed.textPane.replaceSelection("≠"); }
        if(e.getSource() == tabb[3]){ ed.textPane.replaceSelection("×"); }
        if(e.getSource() == tabb[4]){ ed.textPane.replaceSelection("÷"); }
        if(e.getSource() == tabb[5]){ ed.textPane.replaceSelection("∝"); }
        if(e.getSource() == tabb[6]){ ed.textPane.replaceSelection("≪"); }
        if(e.getSource() == tabb[7]){ ed.textPane.replaceSelection("≫"); }
        if(e.getSource() == tabb[8]){ ed.textPane.replaceSelection("≤"); }
        if(e.getSource() == tabb[9]){ ed.textPane.replaceSelection("≥"); }
        if(e.getSource() == tabb[10]){ ed.textPane.replaceSelection("∓"); }
        if(e.getSource() == tabb[11]){ ed.textPane.replaceSelection("≅"); }
        if(e.getSource() == tabb[12]){ ed.textPane.replaceSelection("≈"); }
        if(e.getSource() == tabb[13]){ ed.textPane.replaceSelection("≡"); }
        if(e.getSource() == tabb[14]){ ed.textPane.replaceSelection("∀"); }
        if(e.getSource() == tabb[15]){ ed.textPane.replaceSelection("∁"); }
        if(e.getSource() == tabb[16]){ ed.textPane.replaceSelection("∂"); }
        if(e.getSource() == tabb[17]){ ed.textPane.replaceSelection("√"); }
        if(e.getSource() == tabb[18]){ ed.textPane.replaceSelection("∛"); }
        if(e.getSource() == tabb[19]){ ed.textPane.replaceSelection("∜"); }
        if(e.getSource() == tabb[20]){ ed.textPane.replaceSelection("∩"); }
        if(e.getSource() == tabb[21]){ ed.textPane.replaceSelection("∪"); }
        if(e.getSource() == tabb[22]){ ed.textPane.replaceSelection("∅");}
        if(e.getSource() == tabb[23]){ ed.textPane.replaceSelection("∆"); }
        if(e.getSource() == tabb[24]){ ed.textPane.replaceSelection("∇"); }
        if(e.getSource() == tabb[25]){ ed.textPane.replaceSelection("∃"); }
        if(e.getSource() == tabb[26]){ ed.textPane.replaceSelection("∄");}
        if(e.getSource() == tabb[27]){ ed.textPane.replaceSelection("∈");}
        if(e.getSource() == tabb[28]){ ed.textPane.replaceSelection("∋"); }
        if(e.getSource() == tabb[29]){ ed.textPane.replaceSelection("←");}
        if(e.getSource() == tabb[30]){ ed.textPane.replaceSelection("↑"); }
        if(e.getSource() == tabb[31]){ ed.textPane.replaceSelection("→");}
        
        if(e.getSource() == tabb[32]){ ed.textPane.replaceSelection("↓"); }
        if(e.getSource() == tabb[33]){ ed.textPane.replaceSelection("↔"); }
        if(e.getSource() == tabb[34]){ ed.textPane.replaceSelection("∴"); }
        if(e.getSource() == tabb[35]){ ed.textPane.replaceSelection("⋮"); }
        if(e.getSource() == tabb[36]){ ed.textPane.replaceSelection("∎"); }
        if(e.getSource() == tabb[37]){ ed.textPane.replaceSelection("α"); }
        if(e.getSource() == tabb[38]){ ed.textPane.replaceSelection("β"); }
        if(e.getSource() == tabb[39]){ ed.textPane.replaceSelection("γ"); }
        if(e.getSource() == tabb[40]){ ed.textPane.replaceSelection("δ"); }
        if(e.getSource() == tabb[41]){ ed.textPane.replaceSelection("ε"); }
        if(e.getSource() == tabb[42]){ ed.textPane.replaceSelection("ϵ"); }
        if(e.getSource() == tabb[43]){ ed.textPane.replaceSelection("ζ"); }
        if(e.getSource() == tabb[44]){ ed.textPane.replaceSelection("η"); }
        if(e.getSource() == tabb[45]){ ed.textPane.replaceSelection("θ"); }
        if(e.getSource() == tabb[46]){ ed.textPane.replaceSelection("ϑ"); }
        if(e.getSource() == tabb[47]){ ed.textPane.replaceSelection("π"); }
        if(e.getSource() == tabb[48]){ ed.textPane.replaceSelection("ω"); }
        if(e.getSource() == tabb[49]){ ed.textPane.replaceSelection("ψ"); }
        if(e.getSource() == tabb[50]){ ed.textPane.replaceSelection("χ"); }
        if(e.getSource() == tabb[51]){ ed.textPane.replaceSelection("ϕ"); }
        if(e.getSource() == tabb[52]){ ed.textPane.replaceSelection("φ"); }
        if(e.getSource() == tabb[53]){ ed.textPane.replaceSelection("ϖ"); }
        if(e.getSource() == tabb[54]){ ed.textPane.replaceSelection("σ"); }
        if(e.getSource() == tabb[55]){ ed.textPane.replaceSelection("τ"); }
        if(e.getSource() == tabb[56]){ ed.textPane.replaceSelection("Γ"); }
        if(e.getSource() == tabb[57]){ ed.textPane.replaceSelection("Ξ"); }
        if(e.getSource() == tabb[58]){ ed.textPane.replaceSelection("Δ"); }
        if(e.getSource() == tabb[59]){ ed.textPane.replaceSelection("Λ"); }
        if(e.getSource() == tabb[60]){ ed.textPane.replaceSelection("Π"); }
        if(e.getSource() == tabb[61]){ ed.textPane.replaceSelection("Φ"); }
        if(e.getSource() == tabb[62]){ ed.textPane.replaceSelection("Ψ"); }
        if(e.getSource() == tabb[63]){ ed.textPane.replaceSelection("Ω"); }

        
        


    //ecouter de boutons pour panoper
        if(e.getSource() == tabo[0]){ ed.textPane.replaceSelection("+");}
        if(e.getSource() == tabo[1]){ ed.textPane.replaceSelection("-"); }
        if(e.getSource() == tabo[2]){ ed.textPane.replaceSelection("÷"); }
        if(e.getSource() == tabo[3]){ ed.textPane.replaceSelection("×"); }
        if(e.getSource() == tabo[4]){ ed.textPane.replaceSelection("±");}
        if(e.getSource() == tabo[5]){ ed.textPane.replaceSelection("∝"); }
        if(e.getSource() == tabo[6]){ ed.textPane.replaceSelection("∘"); }
        if(e.getSource() == tabo[7]){ ed.textPane.replaceSelection("⊎"); }
        if(e.getSource() == tabo[8]){ ed.textPane.replaceSelection("⋄"); }
        if(e.getSource() == tabo[9]){ ed.textPane.replaceSelection("∧");}
        if(e.getSource() == tabo[10]){ ed.textPane.replaceSelection("≠");}
        if(e.getSource() == tabo[11]){ ed.textPane.replaceSelection("<"); }
        if(e.getSource() == tabo[12]){ ed.textPane.replaceSelection(">"); }
        if(e.getSource() == tabo[13]){ ed.textPane.replaceSelection("≤"); }
        if(e.getSource() == tabo[14]){ ed.textPane.replaceSelection("≥");}
        if(e.getSource() == tabo[15]){ ed.textPane.replaceSelection("≮"); }
        if(e.getSource() == tabo[16]){ ed.textPane.replaceSelection("≰"); }
        if(e.getSource() == tabo[17]){ ed.textPane.replaceSelection("≯"); }
        if(e.getSource() == tabo[18]){ ed.textPane.replaceSelection("≱"); }
        if(e.getSource() == tabo[19]){ ed.textPane.replaceSelection("≡");}
        if(e.getSource() == tabo[20]){ ed.textPane.replaceSelection("∼"); }
        if(e.getSource() == tabo[21]){ ed.textPane.replaceSelection("≃"); }
        if(e.getSource() == tabo[22]){ ed.textPane.replaceSelection("≈"); }
        if(e.getSource() == tabo[23]){ ed.textPane.replaceSelection("≅"); }
        if(e.getSource() == tabo[24]){ ed.textPane.replaceSelection("≢"); }
        if(e.getSource() == tabo[25]){ ed.textPane.replaceSelection("≄"); }
        if(e.getSource() == tabo[26]){ ed.textPane.replaceSelection("≉");}
        if(e.getSource() == tabo[27]){ ed.textPane.replaceSelection("∈");}
        if(e.getSource() == tabo[28]){ ed.textPane.replaceSelection("∉"); }
        if(e.getSource() == tabo[29]){ ed.textPane.replaceSelection("⊂");}
        if(e.getSource() == tabo[30]){ ed.textPane.replaceSelection("⊃"); }
        if(e.getSource() == tabo[31]){ ed.textPane.replaceSelection("⊆"); }
        if(e.getSource() == tabo[32]){ ed.textPane.replaceSelection("⊇");}
        if(e.getSource() == tabo[33]){ ed.textPane.replaceSelection("∑");}
        if(e.getSource() == tabo[34]){ ed.textPane.replaceSelection("∫"); }
        if(e.getSource() == tabo[35]){ ed.textPane.replaceSelection("∬");}
        if(e.getSource() == tabo[36]){ ed.textPane.replaceSelection("∭"); }
        if(e.getSource() == tabo[37]){ ed.textPane.replaceSelection("∮"); }
        if(e.getSource() == tabo[38]){ ed.textPane.replaceSelection("∯"); }
        if(e.getSource() == tabo[39]){ ed.textPane.replaceSelection("∰"); }
        if(e.getSource() == tabo[40]){ ed.textPane.replaceSelection("∨"); }
        if(e.getSource() == tabo[41]){ ed.textPane.replaceSelection("∏");}
        if(e.getSource() == tabo[42]){ ed.textPane.replaceSelection("∐"); }
        if(e.getSource() == tabo[43]){ ed.textPane.replaceSelection("≪"); }
        if(e.getSource() == tabo[44]){ ed.textPane.replaceSelection("≫");}
        if(e.getSource() == tabo[45]){ ed.textPane.replaceSelection("≺");}
        if(e.getSource() == tabo[46]){ ed.textPane.replaceSelection("≻"); }
        if(e.getSource() == tabo[47]){ ed.textPane.replaceSelection("≼");}
        if(e.getSource() == tabo[48]){ ed.textPane.replaceSelection("≽"); }
        if(e.getSource() == tabo[49]){ ed.textPane.replaceSelection("⊏"); }
        if(e.getSource() == tabo[50]){ ed.textPane.replaceSelection("⊐"); }
        if(e.getSource() == tabo[51]){ ed.textPane.replaceSelection("⊑"); }
        if(e.getSource() == tabo[52]){ ed.textPane.replaceSelection("⊒"); }
        if(e.getSource() == tabo[53]){ ed.textPane.replaceSelection("∥"); }
        if(e.getSource() == tabo[54]){ ed.textPane.replaceSelection("⊥"); }
        if(e.getSource() == tabo[55]){ ed.textPane.replaceSelection("⊢"); }
        if(e.getSource() == tabo[56]){ ed.textPane.replaceSelection("⊣"); }
        if(e.getSource() == tabo[57]){ ed.textPane.replaceSelection("⋈"); }
        if(e.getSource() == tabo[58]){ ed.textPane.replaceSelection("≍"); }
        if(e.getSource() == tabo[59]){ ed.textPane.replaceSelection("⊚"); }
        if(e.getSource() == tabo[60]){ ed.textPane.replaceSelection("⋋"); }
        if(e.getSource() == tabo[61]){ ed.textPane.replaceSelection("∪"); }
        if(e.getSource() == tabo[62]){ ed.textPane.replaceSelection("∖"); }
        if(e.getSource() == tabo[63]){ ed.textPane.replaceSelection("∩"); }



    }

}
