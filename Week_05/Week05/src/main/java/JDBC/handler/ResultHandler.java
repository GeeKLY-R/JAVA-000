import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultHandler<T> {

    T handler(ResultSet set) throws Exception;
}