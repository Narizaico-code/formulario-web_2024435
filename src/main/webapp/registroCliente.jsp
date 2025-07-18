<%-- Document : index Created on : 17/07/2025, 14:38:35 Author : informatica --%>

    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!doctype html>
        <html lang="en">

        <head>
            <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>Register controller</title>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr"
                crossorigin="anonymous">
        </head>

        <body>
            <div class="container">
                <h1>Cliente</h1>
                <!-- nombre, apellido, telefono, correo, genero, edad -->
                <form action="ServletCliente" method="get">
                    <div class="mb-3">
                        <label for="Nombre" class="form-control">Nombre</label>
                        <input type="text" id="nombre" name="nombre" class="form-control">
                    </div>

                    <div class="mb-3">
                        <label for="apellido" class="form-control">Apellido</label>
                        <input type="text" id="apellido" name="apellido" class="form-control">
                    </div>

                    <div class="mb-3">
                        <label for="telefono" class="form-control">Telefono</label>
                        <input type="text" id="telefono" name="telefono" class="form-control">
                    </div>

                    <div class="mb-3">
                        <label for="correo" class="form-control">Correo</label>
                        <input type="email" id="correo" name="correo" class="form-control">
                    </div>

                    <div class="mb-3">
                        <label for="genero" class="form-control">Genero</label>
                            <select name="genero" id="id">
                                <option value="masculino">Masculino</option>
                                <option value="femenino">Femenino</option>
                                <option value="no">No especifico</option>
                            </select>
                    </div>

                    <div>
                        <label for="edad" class="form-control">Edad:</label>
                        <input type="number" name="edad" id="edad" class="form-control">
                    </div>
                    
                    <input type="submit" value="Enviar" class= "btn btn-primary">
                </form>

            </div>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q"
                crossorigin="anonymous"></script>
        </body>

        </html>