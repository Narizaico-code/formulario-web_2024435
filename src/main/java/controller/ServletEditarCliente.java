package controller;

import dao.ClienteDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;

/**
 *
 * @author informatica
 */
@WebServlet("/ServletEditarCliente")
public class ServletEditarCliente extends HttpServlet {
    ClienteDAO clienteDao = new ClienteDAO();
    protected void doGet(HttpServletRequest solicitud, HttpServletResponse respuesta) throws IOException, ServletException {
        String accion = solicitud.getParameter("accion");
        switch (accion) {
            case "editar":
                int idEditar = Integer.parseInt(solicitud.getParameter("id"));
                Cliente cliente = clienteDao.buscarPorId(idEditar);
                //Prepara el objetoCliente para enviarlo
                solicitud.setAttribute("cliente", cliente);
                //Despacharlo a el jsp con los atributos a modificar(actualizar)
                solicitud.getRequestDispatcher("editarCliente.jsp").forward(solicitud, respuesta);
                break;
            case "actualizar":

                break;
            default:
                throw new AssertionError();
        }
    }
}
