/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopaint.presentacion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import proyectopaint.presentacion.elements.*;

import proyectopaint.presentacion.herramientas.LineTool;
import proyectopaint.presentacion.herramientas.OvalTool;
import proyectopaint.presentacion.herramientas.PencilTool;
import proyectopaint.presentacion.herramientas.RectangleTool;
import proyectopaint.presentacion.herramientas.StrokeStyle;
import proyectopaint.presentacion.herramientas.Tool;

/**
 *
 * @author henry duarte
 */
public class PrincipalController implements MouseListener,ActionListener, ComponentListener, ChangeListener  {

    private final Principal vistaPrincipal;
    
    
    public PrincipalController(Principal _vistaPrincipal){
        this.vistaPrincipal = _vistaPrincipal;
        
        this.vistaPrincipal.getjButtLinea().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClickLinea(evt);
            }
        });
           this.vistaPrincipal.getjButtSquare().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClickSquare(evt);
            }
        });
              this.vistaPrincipal.getjButtCircle().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClickCircle(evt);
            }
        });
                 this.vistaPrincipal.getjButtPencil().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClickPencil(evt);
            }
        });
        
        

        
    }
    
    
    
    public void ClickLinea(java.awt.event.ActionEvent evt){        
        this.vistaPrincipal.getjButtLinea().setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        this.vistaPrincipal.getjButtSquare().setBorder(javax.swing.BorderFactory.createEmptyBorder());
        this.vistaPrincipal.getjButtCircle().setBorder(javax.swing.BorderFactory.createEmptyBorder());
        this.vistaPrincipal.getjButtPencil().setBorder(javax.swing.BorderFactory.createEmptyBorder());
        
         this.vistaPrincipal.getDrawPanelGenerico().currentTool = Tool.LINE;
         this.vistaPrincipal.getDrawPanelGenerico().tool =  new LineTool(Color.BLACK, 1, StrokeStyle.LINE);
         
    }
    
    public void ClickSquare(java.awt.event.ActionEvent evt){        
        this.vistaPrincipal.getjButtSquare().setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        this.vistaPrincipal.getjButtLinea().setBorder(javax.swing.BorderFactory.createEmptyBorder());
        this.vistaPrincipal.getjButtCircle().setBorder(javax.swing.BorderFactory.createEmptyBorder());
        this.vistaPrincipal.getjButtPencil().setBorder(javax.swing.BorderFactory.createEmptyBorder());
         this.vistaPrincipal.getDrawPanelGenerico().currentTool = Tool.SQUARE;
         this.vistaPrincipal.getDrawPanelGenerico().tool =  new RectangleTool(Color.BLACK, 1 );
    }
    
     public void ClickCircle(java.awt.event.ActionEvent evt){        
        this.vistaPrincipal.getjButtCircle().setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        this.vistaPrincipal.getjButtLinea().setBorder(javax.swing.BorderFactory.createEmptyBorder());
        this.vistaPrincipal.getjButtSquare().setBorder(javax.swing.BorderFactory.createEmptyBorder());
        this.vistaPrincipal.getjButtPencil().setBorder(javax.swing.BorderFactory.createEmptyBorder());
          this.vistaPrincipal.getDrawPanelGenerico().currentTool = Tool.CIRCLE;
         this.vistaPrincipal.getDrawPanelGenerico().tool =  new OvalTool(Color.BLACK, 1);
    }
     
      public void ClickPencil(java.awt.event.ActionEvent evt){        
        this.vistaPrincipal.getjButtPencil().setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        this.vistaPrincipal.getjButtLinea().setBorder(javax.swing.BorderFactory.createEmptyBorder());
        this.vistaPrincipal.getjButtSquare().setBorder(javax.swing.BorderFactory.createEmptyBorder());
        this.vistaPrincipal.getjButtCircle().setBorder(javax.swing.BorderFactory.createEmptyBorder());
        this.vistaPrincipal.getDrawPanelGenerico().currentTool = Tool.PENCIL;
         this.vistaPrincipal.getDrawPanelGenerico().tool =  new PencilTool(Color.BLACK, 1);
         
    }
      
      
      public  void restaurarButton(){
          this.vistaPrincipal.getjButtLinea().setBorder(javax.swing.BorderFactory.createEmptyBorder());
      }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
      /////////////dsfsdfasdfsd
    }

    @Override
    public void mouseReleased(MouseEvent e) {
      
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
    }

    @Override
    public void componentResized(ComponentEvent e) {
       
    }

    @Override
    public void componentMoved(ComponentEvent e) {
      
    }

    @Override
    public void componentShown(ComponentEvent e) {
        
    }

    @Override
    public void componentHidden(ComponentEvent e) {
      
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        
    }
    
    
    
    
}
