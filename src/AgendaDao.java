import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AgendaDao {

    public void insertar(Agenda a) {
        String sql = "INSERT INTO agenda (nombre, apellido, telefono, descripcion) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, a.getNombre());
            stmt.setString(2, a.getApellido());
            stmt.setString(3, a.getTelefono());
            stmt.setString(4, a.getDescripcion());
            stmt.executeUpdate();
            System.out.println("✅ Registro agregado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Agenda> listar() {
        List<Agenda> lista = new ArrayList<>();
        String sql = "SELECT * FROM agenda";
        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Agenda(
                        rs.getInt("codigo"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("telefono"),
                        rs.getString("descripcion")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void buscar(int codigo) {
        String sql = "SELECT * FROM agenda WHERE codigo=?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, codigo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("Código: " + rs.getInt("codigo"));
                System.out.println("Nombre: " + rs.getString("nombre"));
                System.out.println("Apellido: " + rs.getString("apellido"));
                System.out.println("Teléfono: " + rs.getString("telefono"));
                System.out.println("Descripción: " + rs.getString("descripcion"));
            } else {
                System.out.println("⚠ No se encontró el registro.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizar(Agenda a) {
        String sql = "UPDATE agenda SET nombre=?, apellido=?, telefono=?, descripcion=? WHERE codigo=?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, a.getNombre());
            stmt.setString(2, a.getApellido());
            stmt.setString(3, a.getTelefono());
            stmt.setString(4, a.getDescripcion());
            stmt.setInt(5, a.getCodigo());
            stmt.executeUpdate();
            System.out.println("✅ Registro actualizado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminar(int codigo) {
        String sql = "DELETE FROM agenda WHERE codigo=?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
            System.out.println("✅ Registro eliminado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
