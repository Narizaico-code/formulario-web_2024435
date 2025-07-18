/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;
import java.util.List;
import model.Cliente;

/**
 *
 * @author informatica
 */
@WebServlet("/ServletCliente")
public class ServletCliente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest solicitud, HttpServletResponse respuesta) throws IOException, ServletException {
        respuesta.setContentType("text/html;charset=UTF-8");
        PrintWriter impresoraHtml = respuesta.getWriter();

        String nombre = solicitud.getParameter("nombre");
        String apellido = solicitud.getParameter("apellido");
        String telefono = solicitud.getParameter("telefono");
        String correo = solicitud.getParameter("correo");
        String genero = solicitud.getParameter("genero");
        int edad = Integer.parseInt(solicitud.getParameter("edad"));

        Cliente cliente = new Cliente();
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setTelefono(telefono);
        cliente.setCorreo(correo);
        cliente.setGenero(genero);
        cliente.setEdad(edad);

        ClienteDAO dao = new ClienteDAO();
        dao.guardar(cliente);

//        impresoraHtml.println("<html><body>");
//        impresoraHtml.println("<h1> hola "+ nombre + "!!Bienvenido al sistema </h1>" );
//        impresoraHtml.println("<p> Agregado correctamente</p>");
//        impresoraHtml.println("</body> </hmtl>");
        List<Cliente> listaClientes = dao.listarTodos();
        //Cargar la lista en un elemento a enviar
        solicitud.setAttribute("listaClientes", listaClientes);
        //Enviar lista
        solicitud.getRequestDispatcher("listarClientes.jsp").forward(solicitud, respuesta);
    }
}
