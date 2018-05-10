
package dao;

import java.sql.PreparedStatement;
import model.PersonalModel;

/**
 *
 * @author Valentin
 */
public class PersonalDao extends DAO1{
        public void guardar(PersonalModel model) throws Exception {
        try {
            this.Conectar();
            String sql = "INSERT INTO personal (dni,nombre,apellido,celular,correo)  VALUES (?,?,?,?,?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, model.getDni());
            ps.setString(2, model.getNombre());
            ps.setString(3, model.getApellido());
            ps.setString(4, model.getCelular());
            ps.setString(5, model.getCorreo());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    
}
