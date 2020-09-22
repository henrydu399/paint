
package proyectopaint.logica;

import java.util.ArrayList;
import proyectopaint.presentacion.herramientas.FillerElement;
import proyectopaint.presentacion.herramientas.Tool;


public class Sistema {
    
    private  ArrayList elements;
    
        
       
    
      public Sistema(){
        elements = new ArrayList();
    }
      
      
      public void  GuardarObjetoDibujo(FillerElement fe){
          this.elements.add(fe);
      }

      
      
      
    public ArrayList getElements() {
        return elements;
    }

    public void setElements(ArrayList elements) {
        this.elements = elements;
    }
    
      
      
    
}
