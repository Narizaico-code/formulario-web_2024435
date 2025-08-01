<%-- Document : editarCliente Created on : 18/07/2025, 16:32:11 Author : informatica --%>

    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <%@page import="model.Cliente" %>
            <% Cliente cliente=(Cliente) request.getAttribute("cliente");%>
                <!DOCTYPE html>
                <html lang="es">

                <head>
                    <meta charset="utf-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1">
                    <title>Editar cliente</title>
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

                </head>

                <body>
                    <a href="index.jsp"><img class="menu" src="resources/menu.png" alt="Regresar a menu principal"></a>
                    <div class="container mt-4">
                        <form action="ServletEditarCliente" method="get">

                            <input type="hidden" id="accion" name="accion" value="actualizar">
                            <input type="hidden" id="id" name="id" value="<%=cliente.getCodigoCliente()%>">
                            <div class="mb-3">
                                <label for="Nombre" class="form-control">Nombre</label>
                                <input type="text" id="nombre" name="nombre" class="form-control"
                                    value="<%=cliente.getNombre()%>">
                            </div>

                            <div class="mb-3">
                                <label for="apellido" class="form-control">Apellido</label>
                                <input type="text" id="apellido" name="apellido" class="form-control"
                                    value="<%=cliente.getApellido()%>">
                            </div>

                            <div class="mb-3">
                                <label for="telefono" class="form-control">Telefono</label>
                                <input type="text" id="telefono" name="telefono" class="form-control"
                                    value="<%=cliente.getTelefono()%>">
                            </div>

                            <div class="mb-3">
                                <label for="correo" class="form-control">Correo</label>
                                <input type="email" id="correo" name="correo" class="form-control"
                                    value="<%=cliente.getCorreo()%>">
                            </div>

                            <div class="mb-3">
                                <label for="genero" class="form-control">Genero</label>
                                <select name="genero" id="genero">
                                    <option <%=cliente.getGenero().equals("masculino") ? "selected" : "masculino" %>
                                        >Masculino</option>
                                    <option <%=cliente.getGenero().equals("femenino") ? "selected" : "femenino" %>
                                        >Femenino</option>
                                    <option <%=cliente.getGenero().equals("no") ? "selected" : "no" %>>No especifico
                                    </option>
                                </select>
                            </div>

                            <div>
                                <label for="edad" class="form-control">Edad:</label>
                                <input type="number" name="edad" id="edad" class="form-control"
                                    value="<%=cliente.getEdad()%>">
                            </div>

                            <input type="submit" value="Enviar" class="btn btn-primary">

                            <a href="ServletListarClientes" class="btn btn-secondary"></a>
                        </form>
                    </div>
                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"
                        integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q"
                        crossorigin="anonymous"></script>
                </body>

                </html>