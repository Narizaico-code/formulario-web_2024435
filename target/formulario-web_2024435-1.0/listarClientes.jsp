<%-- Document : listarClientes Created on : 18/07/2025, 14:12:18 Author : informatica --%>

    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <%@page import="java.util.List" %>
            <%@page import="model.Cliente" %>
                <!doctype html>
                <html lang="es">

                <head>
                    <meta charset="utf-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1">
                    <title>Lista clientes</title>
                    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css"
                        rel="stylesheet"
                        integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr"
                        crossorigin="anonymous">
                    <style>
                        .menu {
                            width: 128px;
                            height: auto;
                        }
                    </style>
                    <a href="index.jsp"><img class="menu" src="resources/menu.png" alt="Regresar a menu principal"></a>
                </head>

                <body>

                    <div class="container mt-4">
                        <h2 class="text-center mb-4">Listado de Clientes</h2>
                        <a href="registroCliente.jsp" class="btn btn-primary mb-3">Agregar Cliente</a>

                        <table class="table table-bordered table-stripe">
                            <thead class="table-dark">
                                <tr>
                                    <th>Código</th>
                                    <th>Nombre</th>
                                    <th>Apellido</th>
                                    <th>Telefono</th>
                                    <th>Correo</th>
                                    <th>Genero</th>
                                    <th>Edad</th>
                                    <th>Acciones</th> <!-- editar|eliminar -->
                                </tr>
                            </thead>
                            <tbody>
                                <% //Definir nuestro parametro y comprobar su estado (null o notnull); 
                                List<Cliente> listaClientes = (List<Cliente>) request.getAttribute("listaClientes");
                                        if (listaClientes.isEmpty()) {
                                        System.out.println("Lista de clientes vacía.");
                                        }
                                        if (listaClientes != null && !listaClientes.isEmpty()) {
                                        for (Cliente cliente : listaClientes) {
                                        //filas de la tab|la
                                        %>
                                        <tr>
                                            <td>
                                                <%=cliente.getCodigoCliente()%>
                                            </td>
                                            <td>
                                                <%=cliente.getNombre()%>
                                            </td>
                                            <td>
                                                <%=cliente.getApellido()%>
                                            </td>
                                            <td>
                                                <%=cliente.getTelefono()%>
                                            </td>
                                            <td>
                                                <%=cliente.getCorreo()%>
                                            </td>
                                            <td>
                                                <%=cliente.getGenero()%>
                                            </td>
                                            <td>
                                                <%=cliente.getEdad()%>
                                            </td>
                                            <td>
                                                <a href="ServletEditarCliente?accion=editar&id=<%=cliente.getCodigoCliente()%>"
                                                    class="btn btn-warning btn-sm">Editar</a>
                                                <a href="ServletEliminarCliente?id=<%=cliente.getCodigoCliente()%>"
                                                    class="btn btn-danger btn-sm"
                                                    onclick="return confirm('¿Desea eliminar este cliente?')">Eliminar</a>
                                            </td>
                                        </tr>

                                        <% } } else { //Imprima una columna con mensaje de resultado %>
                                            <tr>
                                                <td class="text-center" colspan="8">No hay clientes registrados</td>
                                            </tr>
                                            <% }%>
                            </tbody>
                        </table>
                    </div>
                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"
                        integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q"
                        crossorigin="anonymous"></script>
                </body>

                </html>