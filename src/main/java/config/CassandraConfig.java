package config;

import com.datastax.driver.core.AuthProvider;
import com.datastax.driver.core.PlainTextAuthProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.java.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories(basePackages = {"dao"})
public class CassandraConfig extends AbstractCassandraConfiguration{

    @Bean
    @Override
    public CassandraClusterFactoryBean cluster() {
        CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();
        cluster.setContactPoints("75.72.139.144");
        cluster.setPort(9042);
        AuthProvider authProvider = new PlainTextAuthProvider("cassandra","cassandra");
        cluster.setAuthProvider(authProvider);
        /*cluster.setUsername("cassandra");
        cluster.setPassword("cassandra");*/
        return cluster;
    }

    @Override
    protected String getKeyspaceName() {
        return "tcs_cricket";
    }

    /*@Bean
    @Override
    public CassandraConverter cassandraConverter() throws ClassNotFoundException {
        return new MappingCassandraConverter(cassandraMapping());
    }*/

    @Bean
    @Override
    public CassandraMappingContext cassandraMapping() throws  ClassNotFoundException {
        return new BasicCassandraMappingContext();
    }

}
