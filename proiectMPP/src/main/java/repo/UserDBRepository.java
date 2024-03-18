package repo;
import domain.Client;
import domain.Entity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import domain.User;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
public class UserDBRepository implements IRepository{
    private JdbcUtils dbUtils;
    private static final Logger logger= LogManager.getLogger();

    public UserDBRepository(Properties props) {
        logger.info("Initializing ClientDBRepository with properties: {} ",props);
        dbUtils=new JdbcUtils(props);
    }

    @Override
    public void save(Object elem) {
        logger.traceEntry("saving user {}",elem);
        Connection con=dbUtils.getConnection();
        if(con==null)
            return;
        User user=(User)elem;
        try(PreparedStatement preStmt=con.prepareStatement("insert into User(username,password) values (?,?)")){

            preStmt.setString(1,user.getUsername());
            preStmt.setString(2,user.getPassword());
            int result=preStmt.executeUpdate();
            logger.trace("Saved {} instances",result);
        }catch (Exception ex){
            logger.error(ex);
            System.out.println("Error DB "+ex);
        }
        logger.traceExit();

    }

    @Override
    public void update(Object o) {
        logger.traceEntry("updating user {}",o);
        Connection con=dbUtils.getConnection();
        if(con==null)
            return;
        User user=(User)o;
        try(PreparedStatement preStmt=con.prepareStatement("update User set username=?,password=? where id=?")){
            preStmt.setString(1,user.getUsername());
            preStmt.setString(2,user.getPassword());
            preStmt.setInt(3, Integer.parseInt(user.getId().toString()));
            int result=preStmt.executeUpdate();
            logger.trace("Updated {} instances",result);
        }catch (Exception ex){
            logger.error(ex);
            System.out.println("Error DB "+ex);
        }
        logger.traceExit();

    }

    @Override
    public void delete(Object o) {

    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public Object findOne(Object o) {
        return null;
    }

    @Override
    public Object findOne(Client client) {
        return null;
    }
}
