package controller;

import dao.ClienteDAO;
import java.io.IOException;
import java.util.List;
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
        respuesta.setContentType("text/html;charset=UTF-8");
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
                int id = Integer.parseInt(solicitud.getParameter("id"));
                cliente = clienteDao.buscarPorId(id);
                cliente.setNombre(solicitud.getParameter("nombre"));
                cliente.setApellido(solicitud.getParameter("apellido"));
                cliente.setTelefono(solicitud.getParameter("telefono"));
                cliente.setCorreo(solicitud.getParameter("correo"));
                cliente.setGenero(solicitud.getParameter("genero"));
                cliente.setEdad(Integer.parseInt(solicitud.getParameter("edad")));

                clienteDao.actualizar(cliente);
                respuesta.sendRedirect("ServletListarClientes");

                break;
            default:
                throw new AssertionError();
        }
    }
}
