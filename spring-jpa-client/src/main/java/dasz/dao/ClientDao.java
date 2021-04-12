package dasz.dao;

import dasz.model.Client;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ClientDao extends GenericDao<Client, Long> {
    @Override
    public Client get(Long key){
        Client client = super.get(key);
        client.getOrders().size();
        return client;
    }
}
