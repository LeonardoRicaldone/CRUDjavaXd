package controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import modelo.Menu;
import vista.frmMenu;

//se modifica esto XD se añade el implements el nombre de la clase dara error alt enter en el nombre y selecciona la primera opcion
public class ctrlMenu implements MouseListener, KeyListener {

    //mandamos a llamar a las otra 2 capas (modelo, vista)
    //el nombre Menu es el nombre de la tabla (clase) si da error alt enter importar clase
    private Menu modeloMenu;
    private frmMenu vistaMenu;

    //crear el constructor de retorno de la clase
    //debe llevar el nombre de la clase
    public ctrlMenu(Menu modeloQuePido, frmMenu vistaQuePido) {

        this.modeloMenu = modeloQuePido;
        this.vistaMenu = vistaQuePido;

        //siempre poner todos los botones que vamos a ocupar
        vistaQuePido.btnGuardar.addMouseListener(this);
        vistaQuePido.btnEliminar.addMouseListener(this);
        //mostrar el datagridview
        modeloMenu.Mostrar(vistaQuePido.jtbMenu);
    }

    //al crear estos cosos borrar la linea dentro de ellos
    @Override
    public void mouseClicked(MouseEvent e) {
        //programamos el boton como un onclicklistener
        if (e.getSource() == vistaMenu.btnGuardar) {
            //le mandamos valores de los txt
            modeloMenu.setNombre(vistaMenu.txtNombre.getText());
            modeloMenu.setPrecio(Double.parseDouble(vistaMenu.txtPrecio.getText()));
            modeloMenu.setIngredientes(vistaMenu.txtIngrediente.getText());

            //ejecutamos el boton guardar
            modeloMenu.Guardar();
            //ejecutamos para que se actualice en cada insert
            modeloMenu.Mostrar(vistaMenu.jtbMenu);

        }
        if (e.getSource() == vistaMenu.btnEliminar) {
            modeloMenu.Eliminar(vistaMenu.jtbMenu);
            modeloMenu.Mostrar(vistaMenu.jtbMenu);

        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
