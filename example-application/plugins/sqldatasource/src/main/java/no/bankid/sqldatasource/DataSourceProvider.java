package no.bankid.sqldatasource;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DataSourceProvider {


    private static Logger logger = LoggerFactory.getLogger( DataSourceProvider.class );

    public static DataSource configureAndMigrateDataSource(final DatasourceConfig configParam) {

        logger.info( "SqlDatasource initializing");

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl( configParam.getDatasourceUrl() );
        config.setUsername( configParam.getUsername() );
        config.setPassword( configParam.getPassword() );
        config.setDriverClassName( configParam.getDriverClass() );
        config.addDataSourceProperty( "cachePrepStmts", "true" );
        config.addDataSourceProperty( "prepStmtCacheSize", "250" );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit", "2048" );
        config.addDataSourceProperty( "useServerPrepStmts", "true" );
        config.setConnectionTestQuery( "select getdate()    " );

        HikariDataSource ds = new HikariDataSource( config );

        logger.info( "SqlDatasource initialized" );
        logger.info( "Flyway migration check" );
        Flyway flyway = new Flyway();
        flyway.setBaselineOnMigrate( true );
        //flyway.setOutOfOrder(true);
        flyway.setDataSource( ds );
        flyway.setLocations( "db/migration");
        flyway.migrate();
        logger.info( "Flyway migration checked" );
        logger.info( "Registering transaction" );
        return ds;
    }

}
