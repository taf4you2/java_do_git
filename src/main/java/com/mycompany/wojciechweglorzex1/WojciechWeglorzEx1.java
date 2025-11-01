package com.mycompany.wojciechweglorzex1;

import view.LottoGameFrame;

/**
 * Main class for Lotto Game application
 * Launches GUI for lottery number generation
 * 
 * Parameters order: not applicable - GUI application
 * 
 * @author wojtek
 * @version 2.0
 */
public class WojciechWeglorzEx1 {
    
    /**
     * Main method - launches the GUI application
     * 
     * @param args command line arguments (not used in GUI mode)
     */
    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WojciechWeglorzEx1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LottoGameFrame().setVisible(true);
            }
        });
    }
}