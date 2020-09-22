
package proyectopaint;

import proyectopaint.presentacion.ModeloPrincipal;
import proyectopaint.presentacion.Principal;


public class ProyectoPaint {

    private ModeloPrincipal miApp;
    
    public static void main(String[] args) {
        //new Principal().setVisible(true);
        
        new ProyectoPaint();
    }
    
    
    public ProyectoPaint() {
        miApp = new ModeloPrincipal();
        miApp.iniciar();        
    }
    
}
