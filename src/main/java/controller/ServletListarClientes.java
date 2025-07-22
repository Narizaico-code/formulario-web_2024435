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
 * @author angelreyes
 */
@WebServlet("/ServletListarClientes")
public class ServletListarClientes extends HttpServlet {

    //get y post
    protected void doGet(HttpServletRequest solicitud, HttpServletResponse respuesta) throws IOException, ServletException {
        respuesta.setContentType("text/html;charset=UTF-8");
        //Obtener la lista -> DAO
        ClienteDAO dao = new ClienteDAO();
        List<Cliente> listaClientes = dao.listarTodos();
        //Cargar la lista en un elemento a enviar
        solicitud.setAttribute("listaClientes", listaClientes);
        //Enviar lista
        solicitud.getRequestDispatcher("listarClientes.jsp").forward(solicitud, respuesta);
    }
}
