/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.persistencia;

import java.util.List;
import libreria.entidades.Autor;

/**
 *
 * @author Mile
 */
public class AutorDAO extends DAO<Autor>{

    @Override
    public void guardar(Autor autor) {        
        try{
            if (buscarPorNombre(autor.getNombre()).getNombre().equalsIgnoreCase(autor.getNombre())){
                throw new Exception("El autor indicado ya se encuentra registrado");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }    
    }
    
    public void eliminar(Integer id) throws Exception {        
        try{
            Autor autor = buscarPorId(id);
            if(autor == null){
                throw new Exception("El autor con el id indicado no existe");
            }
            super.eliminar(autor);
        }catch(Exception e){
            System.out.println(e.getMessage());            
        }
    
    }
    
    public List<Autor> listarTodos() throws Exception {
        try{
            conectar();
            List<Autor> autores = em.createQuery("SELECT a FROM Autor a ").getResultList();
            desconectar();
            return autores;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }    
    }
    
    public Autor buscarPorId(Integer id) throws Exception {        
        try{
            conectar();
            Autor autor = (Autor) em.createQuery("SELECT a FROM Autor a WHERE a.id LIKE :id").setParameter("id", id).getSingleResult();
            if (autor == null){
                throw new Exception("El autor con el id indicado no existe");
            }
            desconectar();
            return autor;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }    
    }
    
    public Autor buscarPorNombre(String nombre) throws Exception {           
        try{
            super.conectar();
            Autor autor = em.createNamedQuery("Autor.buscarPorNombre", Autor.class).setParameter("nombre", nombre).getSingleResult();
            if (autor == null){
                throw new Exception("El autor con el nombre indicado no existe");
            }
            super.desconectar();
            return autor;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }    
    }
}
