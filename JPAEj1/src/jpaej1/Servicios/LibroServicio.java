/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaej1.Servicios;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import jpaej1.Entidades.Libro;
import jpaej1.Persistencia.LibroDAO;

/**
 *
 * @author Mile
 */
public class LibroServicio {
    
    EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
    
    private final LibroDAO dao;

    public LibroServicio() {
        this.dao = new LibroDAO();
    }
    
    public Libro crearLibro() throws Exception{
        Libro libro = null;
        try {
            
            System.out.println("Ingrese el nombre");
            //isbn, titulo, anio, ejemplares, ejemplaresPrestados, ejemplaresRestantes, alta, autor, editorial
            
        } catch (Exception e) {
            throw e;
        }
        
        return libro;
    }
    
    
    
}
