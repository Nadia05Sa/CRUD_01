package mx.edu.utez.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mx.edu.utez.dao.VentasDao;
import mx.edu.utez.model.Ventas;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/RegistrarVentas")
public class RegistrarVentasServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private VentasDao ventasDao = new VentasDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        // Obtener los datos de la venta desde el formulario
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        boolean estado = Boolean.parseBoolean(request.getParameter("estado"));

        // Crear y configurar el objeto Ventas
        Ventas nuevaVenta = new Ventas();
        nuevaVenta.setNombre(nombre);
        nuevaVenta.setDescripcion(descripcion);
        nuevaVenta.setEstado(estado);

        // Registrar la venta en la base de datos
        int ventaId = ventasDao.addVenta(nuevaVenta);

        if (ventaId != -1) {
            // Enviar respuesta exitosa con el ID de la venta
            out.print("<h1>success=exitosamente</h1> <input name=\"ID_Venta\" value=\"" + ventaId + "\">");
        } else {
            // Enviar respuesta de error
            out.print("<h1>success=fallo</h1> <input name=\"ID_Venta\" value=\"\">");
        }

        out.flush();
    }
}
