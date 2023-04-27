/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.servicios;

import java.util.List;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;
import libreria.persistencia.LibroDAO;

/**
 *
 * @author Mile
 */
public class LibroServicio {
    
    private AutorServicio autorServicio;
    private EditorialServicio editorialServicio;
    private final LibroDAO DAO;

    public LibroServicio() {
        this.DAO = new LibroDAO();
    }

    public void setServicios(AutorServicio autorServicio, EditorialServicio editorialServicio) {
        this.autorServicio = autorServicio;
        this.editorialServicio = editorialServicio;
    }   
    
    public Libro crearLibro(Long isbn, String titulo, Integer anio, Integer ejemplares, Integer ejemplaresPrestados, Integer ejemplaresRestantes, Boolean alta, Autor autor, Editorial editorial) throws Exception {
        //algun dato null/vacio
        //ya existe el libro
        Libro libro = new Libro();
        try {
            libro.setIsbn(isbn);
            libro.setTitulo(titulo);
            libro.setAnio(anio);
            libro.setEjemplares(ejemplares);
            libro.setEjemplaresPrestados(ejemplaresPrestados);
            libro.setEjemplaresRestantes(ejemplaresRestantes);
            libro.setAlta(alta);
            libro.setAutor(autor);
            libro.setEditorial(editorial);
            DAO.guardar(libro);
            return libro;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public Libro buscarPorIsbn(Long isbn) {
        //isbn null
        try {
            return DAO.buscarPorIsbn(isbn);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public boolean eliminarPorIsbn(Long isbn) {
        //isbn null
        try {
            DAO.eliminar(isbn);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public List<Libro> listarLibros() {
        try {
            return DAO.listarTodos();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public void editar(Libro libro) throws Exception {
        try{
            DAO.editar(libro);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }    
        
    }
    
    public Libro buscarPorTitulo(String titulo) throws Exception{
        if (DAO.buscarPorTitulo(titulo).getTitulo() == null){
            throw new Exception("El libro con el titulo indicado no se encuentra registrado");
        }
        return DAO.buscarPorTitulo(titulo);
    }
}
