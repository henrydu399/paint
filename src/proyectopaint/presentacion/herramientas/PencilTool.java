/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopaint.presentacion.herramientas;


import proyectopaint.presentacion.elements.PencilElement;
import java.awt.*;


public class PencilTool extends PaintTool
{
    public PencilTool(Color clr, int dim)
    {
        super(clr, dim);
        element = new PencilElement();
        strokeWidth = dim;
        isDrawing   = false;
    }
    
    @Override
    public void drawElement(Graphics g)
    {
        element.update(g);
    }
}
