package repo;
import domain.Entity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import domain.Cursa;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

public class CursaDBRepository implements IRepository{
    private JdbcUtils dbUtils;
    private static final Logger logger= LogManager.getLogger();

    public CursaDBRepository(Properties props) {
        logger.info("Initializing CursaDBRepository with properties: {} ",props);
        dbUtils=new JdbcUtils(props);
    }

    @Override
    public void save(Object elem) {
        logger.traceEntry("saving cursa {}",elem);
        Connection con=dbUtils.getConnection();
        if(con==null)
            return;
        Cursa cursa=(Cursa)elem;
        try(PreparedStatement preStmt=con.prepareStatement("insert into Cursa(destinatie,date,ora) values (?,?,?)")){

            preStmt.setString(1,cursa.getDestinatie());
            preStmt.setDate(2, new java.sql.Date(cursa.getDate().getTime()));
            preStmt.setTime(3, new java.sql.Time(cursa.getOra().getTime()));
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
        logger.traceEntry("updating cursa {}",o);
        Connection con=dbUtils.getConnection();
        if(con==null)
            return;
        Cursa cursa=(Cursa)o;
        try(PreparedStatement preStmt=con.prepareStatement("update Cursa set destinatie=?,data=?,ora=? where id=?")){
            preStmt.setString(1,cursa.getDestinatie());
            preStmt.setDate(2, new java.sql.Date(cursa.getDate().getTime()));
            preStmt.setTime(3, new java.sql.Time(cursa.getOra().getTime()));
            preStmt.setInt(4, Integer.parseInt(cursa.getId().toString()));
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
