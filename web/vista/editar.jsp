<%@page import="com.emergentes.modelo.FarmaciaDAO"%>
<%@page import="com.emergentes.modelo.Farmacia"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Farmacia item = (Farmacia) request.getAttribute("item");
        %>
        <h1>Editar Paciente</h1>
        <form action="Principal?op=guardar" method="post">
            Id: <input type="text" name="id" value="<%= item.getId() %>" size="2" pattern="[1-9]{1}[0-9]*"/>
            <input type="hidden" name="tipo" value="<%= item.getId() %>" required/>
            <br>
            Nombre: <input type="text" name="nombre" value="<%= item.getnombre() %>" required/>
            <br>
            Peso: <input type="number" name="peso" value="<%= item.getpeso() %>" required/>
            <br>
            Talla: <input type="number" name="talla" value="<%= item.gettalla() %>" required/>
            <br>
            Vacuna: <input type="text" name="vacuna" value="<%= item.getvacuna() %>" required/>
            <br>
            <input type="submit" value="Enviar"/>
        </form>
    </body>
</html>
