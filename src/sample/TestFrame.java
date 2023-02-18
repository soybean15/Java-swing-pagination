package sample;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import pagination.PaginationHandler;
import pagination.event.PaginationEvent;
import pagination.listener.PaginationMouseListener;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author root
 */
public class TestFrame extends javax.swing.JFrame {

    /**
     * Creates new form TestFrame
     */
    List<Music> musics = new ArrayList<>();
    JPanel container = new JPanel();
    JLabel pages;
    int page;
    int totalPage;
    
    
    
    
    public TestFrame() {
        
        setSize(300, 400);
        int testSize = 10;

    

        
        //create music list
        for (int i = 0; i < 102; i++) {
            musics.add(new Music("music" + i, "artist" + i));
        }
        setLayout(new BorderLayout());
        

        pages = new JLabel("Page "+page+" of "+totalPage);
        add(pages,BorderLayout.NORTH);
        container.setLayout(new GridLayout(10,0));
        
        add(container,BorderLayout.CENTER);
        populate( 0,  9);

       
       
        PaginationHandler paginationHandler = new PaginationHandler(10, musics.size(), 4);
        
        paginationHandler.modifyNextAndPreviousButton((previous, next)->{
            previous.setBackground(Color.blue);
            previous.setForeground(Color.green);
            next.setBackground(Color.red);
            next.setForeground(Color.white);
            next.setText("Next");
            
        });
        
        
        paginationHandler.modifyButton(label -> {
            label.setOpaque(true);
            label.setBackground(Color.ORANGE);
      
            label.setForeground(Color.BLACK);
        });
        
        
        
        
       
        paginationHandler.addMouseListener(new PaginationMouseListener(){
            
            @Override
            public void onClick(PaginationEvent e) {  //on click event  
                
                populate( e.startIndex(),  e.endIndex());
                pages.setText("Page "+e.getCurrentPage()+" of "+e.getTotalPage());

            }
            @Override
            public void onSelected(PaginationEvent e){
              
                //change background color to red and foreground to yellow once selected
                e.getButton().setBackground(Color.red);
                e.getButton().setForeground(Color.yellow);
                
            }
            @Override
            public void onHover(PaginationEvent e){
              
                //mouse entered event
                e.getButton().setBackground(Color.green);               
                
            }

          
        });
        
        
        
        add(paginationHandler.getPagination(),BorderLayout.SOUTH);

    }
    
    private void populate(int start, int end){
        container.removeAll();
        container.repaint();
        container.revalidate();
       
        List<Music> _musics = musics.subList(start, end+1);
        

       
        for (int i = 0; i < 10; i++) {
            try{
                 JLabel item = new JLabel(_musics.get(i).title);
                 container.add(item);
                 System.out.println(_musics.get(i).title);
          
            }catch(Exception e){
               
                break;
            }
          
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(664, 520));
        setMinimumSize(new java.awt.Dimension(664, 520));
        setPreferredSize(new java.awt.Dimension(664, 520));
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
