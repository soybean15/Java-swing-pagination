/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pagination.listener;

import java.util.function.Consumer;
import javax.swing.JLabel;
import pagination.event.PaginationEvent;

/**
 *
 * @author root
 */
public interface CustomComponentListener {
    
    public PaginationEvent onClick();
    public void onNext();
    public void onPrevious();
   // public default void onSelected(Consumer<JLabel> label){
        
    
    
}
