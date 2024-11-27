/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import BD.Conexion;
import Interfaz.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.sql.ResultSet;

/**
 *
 * @author thais
 */
public class Registro {
    public Producto buscarPornombre(String nombre)
    {
        Producto producto = new Producto();        
        try {
                   
            Conexion con = new Conexion();
            Connection cnx = con.conectar();
            
            //SQL
            String query = "SELECT * FROM PRODUCTO WHERE nombre_producto = ?" ;
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setString(1,nombre);
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                
                producto.setNombre(rs.getString("nombre_producto"));
                producto.setStock(rs.getInt("stock"));
                producto.setPrecio(rs.getInt("precio"));
                
                
            }
            rs.close();
            stmt.close();
            cnx.close();
            
        } catch (SQLException e) {
            System.out.println("Error en SQL al actualizar producto " + e.getMessage());
        }
       return producto;
    }
    public boolean borrar(String nombre)
    {
        try {
            
            Conexion con = new Conexion();
            Connection cnx = con.conectar();
            
            //SQL
            String query = "DELETE FROM PRODUCTO WHERE nombre_producto=?" ;
            PreparedStatement stmt = cnx.prepareStatement(query);
            
            //ahora le diremos los ?,?,?,?,?
            stmt.setString(1,nombre);
            
            
            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            
            return true;
        } catch (SQLException e) {
            System.out.println("Error en SQL al eliminar producto " + e.getMessage());
            return false;
        }
        catch(Exception e){
            System.out.println("Error en el método eliminar producto " + e.getMessage());
            return false;
        }
    }
    public boolean agregar(Producto producto)
    {
        try {
                        
            Conexion con = new Conexion();
            Connection cnx = con.conectar();
            
            
            //SQL
            String query = "INSERT INTO PRODUCTO(nombre_producto,stock,precio) VALUES(?,?,?)";
            PreparedStatement stmt = cnx.prepareStatement(query);
            
            //ahora le diremos los ?,?,?,?,?
            stmt.setString(1, producto.getNombre());
            stmt.setInt(2, producto.getStock());
            stmt.setDouble(3, producto.getPrecio());
            
            
            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            
            return true;
        } catch (SQLException e) {
            System.out.println("Error en SQL al agregar producto " + e.getMessage());
            return false;
        }
        catch(Exception e){
            System.out.println("Error en el método agregar producto " + e.getMessage());
            return false;
        }
    }
    public boolean actualizar(Producto producto,String nombre_Antiguo)
            
    {
        try {
            
            Conexion con = new Conexion();
            Connection cnx = con.conectar();
            
           
            //SQL
            String query = "UPDATE PRODUCTO set nombre_producto = ?,stock=?,precio=? WHERE nombre_producto=?" ;
            PreparedStatement stmt = cnx.prepareStatement(query);
            
            //ahora le diremos los ?,?,?,?,?
            stmt.setString(1, producto.getNombre());//nombre nuevo
            stmt.setInt(2, producto.getStock());
            stmt.setDouble(3,producto.getPrecio());
            stmt.setString(4,nombre_Antiguo);//nombre viejo
            
            
            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            
            return true;
        } catch (SQLException e) {
            System.out.println("Error en SQL al actualizar producto " + e.getMessage());
            return false;
        }
        catch(Exception e){
            System.out.println("Error en el método actualizar producto " + e.getMessage());
            return false;
        }
    }
    
    
}

