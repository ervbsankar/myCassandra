package dao;

import Entity.User;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Component;


import java.util.List;

/**
 * Created by A513915 on 6/10/2015.
 */

@Component
public interface UserDao extends CassandraRepository<User> {
    @Query("Select * from users")
    List<User> findByName();

    @Query("Select count(*) from users")
    Integer countUsers();
}
