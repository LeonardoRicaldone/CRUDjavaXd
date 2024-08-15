
package modelo;

import java.sql.*;
import java.util.UUID;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Menu {
    
    //creacion de parametros 
    String UUID_menu;
    String nombre;
    double precio;
    String ingredientes;
    
    //Getters y Setters clic derecho abajo insetar codigo y clic en getter y setter

    public String getUUID_menu() {
        return UUID_menu;
    }

    public void setUUID_menu(String UUID_menu) {
        this.UUID_menu = UUID_menu;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }
    //insert
      public void Guardar() {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();
        try {
            //Creamos el PreparedStatement que ejecutará la Query
            PreparedStatement addMenu = conexion.prepareStatement("INSERT INTO tbMenu(UUID_menu, nombre, precio, ingredientes) VALUES (?, ?, ?, ?)");
            //Establecer valores de la consulta SQL
            addMenu.setString(1, UUID.randomUUID().toString());
            addMenu.setString(2, getNombre());
            addMenu.setDouble(3, getPrecio());
            addMenu.setString(4, getIngredientes());
 
            //Ejecutar la consulta
            addMenu.executeUpdate();
 
        } catch (SQLException ex) {
            System.out.println("este es el error en el modelo:metodo guardar " + ex);
        }
      }
      //para mostrar en el datagridview
      public void Mostrar(JTable tabla) {
        //Creamos una variable de la clase de conexion
        Connection conexion = ClaseConexion.getConexion();
        //Definimos el modelo de la tabla
        DefaultTableModel modeloTacos = new DefaultTableModel();
        modeloTacos.setColumnIdentifiers(new Object[]{"UUID_menu", "Nombre", "Precio", "Ingredientes"});
        try {
            //Creamos un Statement
            Statement statement = conexion.createStatement();
            //Ejecutamos el Statement con la consulta y lo asignamos a una variable de tipo ResultSet
            ResultSet rs = statement.executeQuery("SELECT * FROM tbMenu");
            //Recorremos el ResultSet
            while (rs.next()) {
                //Llenamos el modelo por cada vez que recorremos el resultSet
                modeloTacos.addRow(new Object[]{rs.getString("UUID_menu"), 
                    rs.getString("nombre"), 
                    rs.getInt("precio"), 
                    rs.getString("ingredientes")});
            }
            //Asignamos el nuevo modelo lleno a la tabla
            tabla.setModel(modeloTacos);
        } catch (Exception e) {
            System.out.println("Este es el error en el modelo, metodo mostrar " + e);
        }
    }
}
      
