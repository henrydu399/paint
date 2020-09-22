/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectopaint.presentacion.herramientas;




import java.awt.Graphics;
import java.awt.Color;
import proyectopaint.presentacion.Principal;

public class FillerElement extends PaintElement
{
    public FillerElement(Color clr)
    {
        super(clr);
    }

    @Override
    public void update(Graphics g)
    {
        Principal.drawPanelGenerico.setBackground(color);
        Principal.drawPanelGenerico.backgroundColor = color;
        Principal.drawPanelGenerico.repaint();
    }
}
