/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.servicios;

import java.util.List;
import libreria.entidades.Autor;
import libreria.persistencia.AutorDAO;

/**
 *
 * @author Mile
 */
public class AutorServicio {
    
    private LibroServicio libroServicio;
    private EditorialServicio editorialServicio;
    private final AutorDAO DAO;

    public AutorServicio() {
        this.DAO = new AutorDAO();
    }
    
    public void setServicios(LibroServicio libroServicio, EditorialServicio editorialServicio) {
        this.editorialServicio = editorialServicio;
        this.libroServicio = libroServicio;
    }
    
    public Autor crearAutor(String nombre, Boolean alta) {
        //nombre null o alta null
        Autor autor = new Autor();
        try {
            autor.setNombre(nombre);
            autor.setAlta(alta);
            DAO.guardar(autor);
            return autor;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public Autor buscarPorId(Integer id) {
        //id null
        try {
            return DAO.buscarPorId(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public boolean eliminarPorId(Integer id) {
        //id null
        try {
            DAO.eliminar(id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public List<Autor> listarAutores() {
        try {
            return DAO.listarTodos();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public Autor buscarPorNombre(String nombre) throws Exception{
        return DAO.buscarPorNombre(nombre);
    }
}
