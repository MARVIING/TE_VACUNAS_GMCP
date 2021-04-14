package com.emergentes.controlador;

import com.emergentes.modelo.Farmacia;
import com.emergentes.modelo.FarmaciaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Principal", urlPatterns = {"/Principal"})
public class Principal extends HttpServlet {
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses = request.getSession();
        
        FarmaciaDAO gestor = (FarmaciaDAO) ses.getAttribute("gestor");
        
        if(gestor == null){
            
            FarmaciaDAO auxi = new FarmaciaDAO();
            ses.setAttribute("gestor", auxi);
        }
        String op = request.getParameter("op");
        if(op == null){
            op = "";
        }
        
        if(op.trim().equals("")){
            response.sendRedirect("vista/listado.jsp");
        }
        if(op.trim().equals("nuevo")){
            ses = request.getSession();
                
            Farmacia obj = new Farmacia();
                
            obj.setId(gestor.getCorrelativo()+1);
            request.setAttribute("item", obj);
            request.getRequestDispatcher("vista/nuevo.jsp").forward(request, response);
        }
        
        if(op.trim().equals("editar")){
            int pos = gestor.posicion(Integer.parseInt(request.getParameter("id")));
            Farmacia obj = gestor.getAlm().get(pos);
            
            request.setAttribute("item", obj);
            request.getRequestDispatcher("vista/editar.jsp").forward(request, response);
        }
        
        if(op.trim().equals("eliminar")){
            int pos = gestor.posicion(Integer.parseInt(request.getParameter("id")));
            gestor.getAlm().remove(pos);
            
            response.sendRedirect("vista/listado.jsp");
        }
                
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses = request.getSession();
        
        FarmaciaDAO gestor = (FarmaciaDAO) ses.getAttribute("gestor");
        Farmacia obj = new  Farmacia();
        
        gestor.setCorrelativo(gestor.getCorrelativo()+1);
        
        obj.setId(gestor.getCorrelativo());
        obj.setnombre(request.getParameter("nombre"));
        obj.setpeso(Integer.parseInt(request.getParameter("peso")));
        obj.settalla(Integer.parseInt(request.getParameter("talla")));
        obj.setvacuna(request.getParameter("vacuna"));
        
        String tipo = request.getParameter("tipo");
        
        if(tipo.equals("-1")){
            gestor.insertar(obj);
        } else{
            gestor.editar(obj.getId(), obj);
        }
        response.sendRedirect("vista/listado.jsp");
        
    }

}
