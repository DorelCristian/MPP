package repo;
import domain.Entity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import domain.Rezervare;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

public class RezervareDBRepository implements IRepository{

    private JdbcUtils dbUtils;
    private static final Logger logger= LogManager.getLogger();

    public RezervareDBRepository(Properties props) {
        logger.info("Initializing ClientDBRepository with properties: {} ",props);
        dbUtils=new JdbcUtils(props);
    }
    @Override
    public void save(Object elem) {
        logger.traceEntry("saving rezervare {}",elem);
        Connection con=dbUtils.getConnection();
        if(con==null)
            return;
        Rezervare rezervare=(Rezervare)elem;
        try(PreparedStatement preStmt=con.prepareStatement("insert into Rezervare(id_client,id_cursa, locuri) values (?,?,?)")){
            preStmt.setInt(1,rezervare.getClient().getId().intValue());
            preStmt.setInt(2,rezervare.getCursa().getId().intValue());
            preStmt.setInt(3,rezervare.getLocuri());
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
        logger.traceEntry("updating rezervare {}",o);
        Connection con=dbUtils.getConnection();
        if(con==null)
            return;
        Rezervare rezervare=(Rezervare)o;
        try(PreparedStatement preStmt=con.prepareStatement("update Rezervare set id_client=?,id_cursa=?,locuri=? where id=?")){
            preStmt.setInt(1,rezervare.getClient().getId().intValue());
            preStmt.setInt(2,rezervare.getCursa().getId().intValue());
            preStmt.setInt(3,rezervare.getLocuri());
            preStmt.setInt(4, Integer.parseInt(rezervare.getId().toString()));
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
}
