/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopaint.presentacion;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import proyectopaint.presentacion.elements.LineElement;
import proyectopaint.presentacion.elements.OvalElement;
import proyectopaint.presentacion.elements.RectangleElement;
import proyectopaint.presentacion.herramientas.AbstractTool;
import proyectopaint.presentacion.herramientas.DragTool;
import proyectopaint.presentacion.herramientas.FillerElement;
import proyectopaint.presentacion.herramientas.PaintElement;
import proyectopaint.presentacion.elements.PencilElement;
import proyectopaint.presentacion.herramientas.PencilTool;
import proyectopaint.presentacion.herramientas.StrokeStyle;
import proyectopaint.presentacion.herramientas.Tool;

/**
 *
 * @author henry duarte
 */
public class DrawPanelGenerico extends javax.swing.JPanel implements Runnable {

    private ModeloPrincipal modeloPrincipal;
    
    
    public int frameCount;

    //LISTA DE TODO LOS OBJETOS PINTADOS
    //public ArrayList elements;
    //BANDERA PARA SABER SI SE ESTA ES CLICK SOSTENIDO
    protected Boolean mousePressed = false;
    //ENUMERABLE PARA MANEJAR EL TIPO DE OPCIONES O HERRAMIENTA DEL PAINT 
    public Tool currentTool;
    //
    public AbstractTool tool; 
    //COLOR DE LA BROCHA O COLOR DE  HERRAMIENTA 
    public Color colorTool;
    //COLOR DE FONDO DEL DRAWPANEL 
    public Color backgroundColor;
    //HILO PARA REDENRIZAR LA VISTA
    protected Thread animator;

    /**
     * Creates new form DrawPanelGenerico
     */
    public DrawPanelGenerico( ModeloPrincipal _modeloPrincipal ) {
        
         this.modeloPrincipal = _modeloPrincipal;
        initComponents();
        
//
        backgroundColor = Color.WHITE;

        setBackground(backgroundColor);
        setPreferredSize(new Dimension(400,400));

        MouseHandler handler = new MouseHandler();
        addMouseListener(handler);

        
       // elements = new ArrayList();
        this.modeloPrincipal.getSistema().GuardarObjetoDibujo(new FillerElement(getBackground()));
        
       // mousePressed = false;
 

        colorTool = Color.black;
        tool = new PencilTool(colorTool, 1);
        currentTool = Tool.PENCIL;
        frameCount = -1;
        
        
       
    }
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public void startTheThread() {
        animator = new Thread(this);
        animator.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        
        try{
        super.paintComponent(g);

        for (int i = 0; i < this.modeloPrincipal.getSistema().getElements().size(); i++) {
            ((PaintElement) this.modeloPrincipal.getSistema().getElements().get(i)).update(g);
        }
        }catch(Exception e){
            
        }

    }

    public void addTemporaryDragElement(Color clr, Point sPoint, Point cPoint, int strokeW, StrokeStyle strokeS) {
        switch (currentTool) {

        }
    }

    public boolean isPaintingTool(Tool tool) {
        switch (tool) {
            case PENCIL: {
                return true;
            }
        }
        return false;
    }

    public boolean isDraggingTool(Tool tool) {
       switch (tool)
        {
            case LINE:
            case CIRCLE:
            case SQUARE:
            {
                return true;
            }
        }
        return false;
    }

    public void setBrushColor(Color clr) {
        colorTool = clr;
        tool.setColor(clr);
    }

    public Color getBrushColor() {
        return colorTool;
    }

    public void setTool(Tool tool) {
        currentTool = tool;
        setPaintTool(tool);

        if (currentTool == Tool.PICKER) {
            if (animator == null) {
                startTheThread();
            }
        }
    }

    public Tool getTool() {
        return currentTool;
    }
    

    
    public void setPaintTool(Tool tool) {
        int stroke = this.tool.getStroke();

        if (tool != Tool.ERASER && stroke >= 16) {
            this.tool.setStrokeWidth(16);
        }

        switch (tool) {
            case PENCIL: {
                this.tool = new PencilTool(colorTool, this.tool.getStroke());
                // Principal.paintTools.setToolOptionPanel(new PencilToolPanel(Tool.PENCIL, this.tool.getStroke()));
                break;
            }

        }
    }

    public boolean getMousePressed() {
        return mousePressed;
    }

    @Override
    public void run() {
        {
            while (true) {
                if (getMousePosition() != null) {
                    ///////////////////DIBUJAR LAPIZ /////////////////////////77
                    ////SI EL CURSOS SALE DEL OBJETO PANEL DrawPanel, deja de pintar 
                    if (isPaintingTool(currentTool)) {
                        if (getMousePressed() == false) {
                            tool.setCPoint(null);
                            tool.setDrawing(false);
                        }
                        ///////////////////////
                        if (tool.isDrawing()) {
                            if (getMousePosition() != tool.getCPoint()) {
                                if (getMousePressed()) {
                                    tool.setPPoint(tool.getCPoint());
                                    if (getMousePosition() != null) {
                                        tool.setCPoint(new Point(this.getMousePosition()));
                                    }

                                    if (currentTool == Tool.PENCIL) {
                                        modeloPrincipal.getSistema().getElements().add(new PencilElement(tool.getPPoint(), tool.getCPoint(),
                                            tool.getColor(), tool.getStroke()));
                                    }

                                }
                                repaint();
                            }
                        } else {
                            if (this.getMousePressed()) {
                                tool.setCPoint(getMousePosition());
                                tool.setDrawing(true);
                            }
                        }
                    }
                    /////////////////DIBUJAR FIGURAS //////////////////////////////////////
                    if (isDraggingTool(currentTool)) {
                         ////SI EL CURSOS SALE DEL OBJETO PANEL DrawPanel, deja de pintar 
                        if ((tool.isDrawing()) && (getMousePosition() == null)) {
                            tool.setDrawing(false);
                            mousePressed = false;
                        }
                        ///////////////////////////////////////////////////77

                        if ((mousePressed)) {
                            if (tool.isDrawing() == false) {
                                
                               tool.setDrawing(true);
                                ((DragTool) tool).setSPoint(getMousePosition());
                                tool.setCPoint(getMousePosition());

                                addTemporaryDragElement(tool.getColor(), ((DragTool) tool ).getSPoint(),
                                                        tool.getCPoint(), tool.getStroke(),tool.getStrokeStyle());
                            
                            }
                            
                            if (getMousePosition() != tool.getCPoint()) {
                            ((DragTool)tool).setFPoint(getMousePosition());
                            
                            tool.setPPoint(tool.getPPoint());
                            tool.setCPoint(getMousePosition());
                            
                            //elements.remove(elements.size()-1);

                            addTemporaryDragElement(tool.getColor(), ((DragTool) tool).getSPoint(),
                                                    tool.getCPoint(), tool.getStroke(),tool.getStrokeStyle());
                            }
                            
                        }

                               
                     if (( tool.isDrawing()) && (mousePressed==false) ) {
                        tool.setDrawing(false);

                       // elements.remove(elements.size()-1);
                        
                        switch(currentTool)
                        {
                            case CIRCLE:
                            {
                                modeloPrincipal.getSistema().getElements().add( new OvalElement(tool.getColor(), ((DragTool) tool).getSPoint(), ((DragTool) tool).getFPoint(), tool.getStroke(), tool.getStrokeStyle()));
                                break;
                            }
                            case SQUARE:
                            {
                                modeloPrincipal.getSistema().getElements().add( new RectangleElement(tool.getColor(), ((DragTool) tool).getSPoint(), ((DragTool) tool).getFPoint(),tool.getStroke(),tool.getStrokeStyle()));
                                break;
                            }

                            case LINE:
                            {
                                modeloPrincipal.getSistema().getElements().add( new LineElement(tool.getColor(), ((DragTool) tool).getSPoint(), ((DragTool) tool).getFPoint(),tool.getStroke(),tool.getStrokeStyle()));
                                break;
                            }
                        }
                    }
                        

                        repaint();
                    }

                    
                    frameCount++;
                }
                else {
                    tool.setDrawing(false);
                    tool.setCPoint(null);
                }

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }

    }

    
    
    
    
    
    
    
        private class MouseHandler extends MouseAdapter
    {
        @Override
        public void mousePressed(MouseEvent event) 
        {
            if (animator == null)
                   startTheThread();
            
            mousePressed = true;
        }
   
        @Override
        public void mouseReleased(MouseEvent event)
        {
            mousePressed = false;
        }
        
        @Override
        public void mouseClicked(MouseEvent event)
        {
           
        }
        @Override
        public void mouseExited(MouseEvent event)
        {
            mousePressed = false;
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
