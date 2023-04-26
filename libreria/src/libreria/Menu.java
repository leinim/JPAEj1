/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria;

import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;
import libreria.servicios.AutorServicio;
import libreria.servicios.EditorialServicio;
import libreria.servicios.LibroServicio;

/**
 *
 * @author Mile
 */
public class Menu {
    
    private final LibroServicio ls = new LibroServicio();
    private final EditorialServicio es = new EditorialServicio();
    private final AutorServicio as = new AutorServicio();
    
    public Menu(){
        ls.setServicios(as, es);
        es.setServicios(as, ls);
        as.setServicios(ls, es);
    }
    
    public void ejecucion() {
//        Libro
//                
//        String titulo1 = "La conspiracion";
//        Integer anio1 = 2001;
//        Integer ej1 = 40;
//        Integer ejPres1 = 3 ;
//        Integer ejRes1 = 37;
//        Boolean al1 = true;
//        
//        String titulo2 = "El principito";
//        Integer anio2 = 1943;
//        Integer ej2 = 58;
//        Integer ejPres2 = 40;
//        Integer ejRes2 = 18;
//        Boolean al2 = true;
//        
//        String titulo3 = "El viejo y el mar";
//        Integer anio3 = 1953;
//        Integer ej3 = 80;
//        Integer ejPres3 = 40;
//        Integer ejRes3 = 40;
//        Boolean al3 = true;
//        
//        Editorial
//        
//        String nombre1 = "Planeta";
//        Boolean alta1 = true;
//        
//        String nombre2 = "Paidos";
//        Boolean alta2 = true;
//        
//        String nombre3 = "Colihue";
//        Boolean alta3 = true;
//        
//        Autor
//        
//        String nom1 = "Dan Brown";
//        Boolean alt1 = true;
//        
//        String nom2 = "Antoine de Saint-Exupéry";
//        Boolean alt2 = true;
//        
//        String nom3 = "Ernest Hemingway";
//        Boolean alt3 = true;
//        
//        Crear Autores
//        
//        Autor autor1 = as.crearAutor(nom1, alt1);
//        Autor autor2 = as.crearAutor(nom2, alt2);
//        Autor autor3 = as.crearAutor(nom3, alt3);
//        
//        Crear Editoriales
//        
//        Editorial ed1 = es.crearEditorial(nombre1, alta1);
//        Editorial ed2 = es.crearEditorial(nombre2, alta2);
//        Editorial ed3 = es.crearEditorial(nombre3, alta3);
//        
//        Crear Libros
//        
//        Libro libro1 = ls.crearAutor(titulo1, anio1, ej1, ejPres1, ejRes1, al1, autor1, ed1);
//        Libro libro2 = ls.crearAutor(titulo2, anio2, ej2, ejPres2, ejRes2, al2, autor2, ed2);
//        Libro libro3 = ls.crearAutor(titulo3, anio3, ej3, ejPres3, ejRes3, al3, autor3, ed3);

            
    }
}
