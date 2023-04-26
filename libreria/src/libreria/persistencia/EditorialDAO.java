/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.persistencia;

import java.util.List;
import libreria.entidades.Editorial;

/**
 *
 * @author Mile
 */
public class EditorialDAO extends DAO<Editorial>{

    @Override
    public void guardar(Editorial editorial) {        
        try{
            if (buscarPorNombre(editorial.getNombre()).getNombre().equalsIgnoreCase(editorial.getNombre())){
                throw new Exception("La editorial indicada ya esta registrada");
            }
            super.guardar(editorial);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }    
    }
    
    public void eliminar(Integer id) throws Exception {           
        try{            
            Editorial editorial = buscarPorId(id);
            if (editorial == null){
                throw new Exception("No existe la editorial con el id indicado");
            }
            super.eliminar(editorial);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }    
    }
    
    public List<Editorial> listarTodos() throws Exception {
        
        try{
            conectar();
            List<Editorial> editoriales = em.createQuery("SELECT e FROM Editorial e ").getResultList();
            desconectar();
            return editoriales;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }    
    }
    
    public Editorial buscarPorId(Integer id) throws Exception {
           
        try{
            conectar();
            Editorial editorial = (Editorial) em.createQuery("SELECT e FROM Editorial e WHERE e.id LIKE :id").setParameter("id", id).getSingleResult();
            if (editorial == null){
                throw new Exception("No existe la editorial con el id indicado");
            }
            desconectar();
            return editorial;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }    
    }
    
    public Editorial buscarPorNombre(String nombre) throws Exception {
           
        try{
            conectar();
            Editorial editorial = em.createNamedQuery("Editorial.buscarPorNombre", Editorial.class).setParameter("nombre", nombre).getSingleResult();
            if (editorial == null){
                throw new Exception("No existe la editorial con el nombre indicado");
            }
            desconectar();
            return editorial;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }    
    }
}
