
package proyectopaint.presentacion;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import proyectopaint.logica.Sistema;
import proyectopaint.presentacion.herramientas.AbstractTool;
import proyectopaint.presentacion.herramientas.Tool;


public class ModeloPrincipal implements Runnable{

          Principal vistaPrincipal;
          
           private Sistema sistema;
    //******************************************************************//
    
    @Override
    public void run() {
        
        
    }
    
    
          //*********** Métodos ocultación de información
      public Sistema getSistema() {
            if (sistema == null) {
                  sistema = new Sistema();
            }
            return sistema;
      }
    
    
    public void iniciar (){
        getVentanaPrincipal().setVisible(true);
    }
    
     public Principal getVentanaPrincipal() {
            if (vistaPrincipal == null) {
                  vistaPrincipal = new Principal(this);
            }
            return vistaPrincipal;
      }
    
}
