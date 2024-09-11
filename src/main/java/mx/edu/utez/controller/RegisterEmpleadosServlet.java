package mx.edu.utez.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mx.edu.utez.dao.EmpleadoDao;
import mx.edu.utez.model.Empleado;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(name = "RegisterEmpleadosServlet", urlPatterns = "/RegisterEmpleados")
public class RegisterEmpleadosServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Capturar los datos del empleado desde el formulario
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        int salario = Integer.parseInt(req.getParameter("salario"));
        Date fecha = Date.valueOf(req.getParameter("fecha"));

        // Crear y configurar el objeto Empleado
        Empleado empleado = new Empleado();
        empleado.setFecha_Contratacion(fecha);
        empleado.setSalario(salario);
        empleado.setEstado(true);  // Asignar estado activo (true) al empleado

        EmpleadoDao empleadoDao = new EmpleadoDao();

        try {
            // Registrar el empleado
            empleadoDao.registrarEmpleado(empleado);
            resp.sendRedirect("homeadmin.jsp");
        } catch (SQLException e) {
            String errorMessage = e.getMessage();
            req.setAttribute("errorMessage", "Error al registrar empleado: " + errorMessage);
            req.getRequestDispatcher("registroEmpleado.jsp").forward(req, resp);
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
