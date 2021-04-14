<%@page import="com.emergentes.modelo.Farmacia"%>
<%@page import="com.emergentes.modelo.FarmaciaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <u><p aling="center"><font face="goticas" style="fontsize: 35pt">
    <marquee><font color="#000000"><table border="2px" align ="left"><th align =left>PRIMER PARCIAL TEM-742<BR>NOMBRE: GERMAN MARVIN CHAMBI POMA<BR>CEDULA DE IDENTIDAD: 5973745LP </tr></table></font>
    <p align="left"></marquee></p></u>
            
    <body bgcolor="#9b9b9b">
        <%
            FarmaciaDAO lista = (FarmaciaDAO) session.getAttribute("gestor");
        %>
        <h1 align="center">REGISTRO DE VACUNAS</h1>
        <table border="0px" align ="center"><th>
        <p ><a href="../Principal?op=nuevo">Nuevo</a></p>
        <%
            if(lista.getAlm().size() > 0){
        %>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>NOMBRE</th>
                <th>PESO</th>
                <th>TALLA</th>
                <th>VACUNA</th>
                <th></th>
                <th></th>
            </tr>
        <%
            for(Farmacia item : lista.getAlm()){
        %>
            <tr>
                <td><%= item.getId() %></td>
                <td><%= item.getnombre() %></td>
                <td><%= item.getpeso() %></td>
                <td><%= item.gettalla() %></td>
                 <td><%= item.getvacuna() %></td>
                <td><a href="../Principal?op=editar&id=<%=item.getId()%>">Editar</a></td>
                <td><a href="../Principal?op=eliminar&id=<%=item.getId()%>">Eliminar</a></td>
            </th>
        <%
            }
        %>    
        </table>
        <%
        }
            else{
                out.println("<p>No existen registros");;
            }
        %>   
        </tr></table>
    </body>
</html>
