package main.beans;

import main.config.DatabaseDatasource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NamesRepository {

    private DatabaseDatasource ds;

    @Autowired
    public NamesRepository(DatabaseDatasource ds){
        this.ds = ds;
    }

    public List<String> getAll(){
        return ds.getDatabase();
    }
}
