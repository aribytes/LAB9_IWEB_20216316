package org.example.lab9_iweb_20216316;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    public boolean registrar(Usuario usuario) {

        String sql = "INSERT INTO usuario " + "(nombres, apellidos, email, password_hash, rol, estado) " + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexion.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, usuario.getNombres());
            ps.setString(2, usuario.getApellidos());
            ps.setString(3, usuario.getEmail());
            ps.setString(4, HashUtil.generarHash(usuario.getPasswordHash()));
            ps.setString(5, usuario.getRol());
            ps.setString(6, "ACTIVO");

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();
            return false;
        }
    }

    public Usuario buscarPorEmail(String email) {

        String sql = "SELECT * FROM usuario WHERE email = ?";

        try (Connection conn = Conexion.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Usuario usuario = new Usuario();
                usuario.setNombres(rs.getString("nombres"));
                usuario.setApellidos(rs.getString("apellidos"));
                usuario.setEmail(rs.getString("email"));
                usuario.setPasswordHash(rs.getString("password_hash"));
                usuario.setRol(rs.getString("rol"));
                usuario.setEstado(rs.getString("estado"));

                return usuario;
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return null;
    }

    public Usuario validarLogin(String email, String password) {

        Usuario usuario = buscarPorEmail(email);

        if (usuario != null &&
                usuario.getPasswordHash().equals(
                        HashUtil.generarHash(password)) &&
                usuario.getEstado().equals("ACTIVO")) {

            return usuario;
        }

        return null;
    }
}