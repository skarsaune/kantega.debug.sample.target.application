package no.bankid.sqldatasource;


import org.kantega.reststop.api.Config;
import org.kantega.reststop.api.DefaultReststopPlugin;
import org.kantega.reststop.api.Export;
import org.kantega.reststop.api.Reststop;

import javax.sql.DataSource;

public class SqldatasourcePlugin extends DefaultReststopPlugin implements DatasourceConfig {

    @Export
    private final DataSource dataSource;

    @Config(property = "datasource.url")
    private String datasourceUrl;

    @Config(property = "datasource.username")
    private String username;

    @Config(property = "datasource.password")
    private String password;

    @Config(property = "datasource.driver.class")
    private String driverClass;

    @Config(property="profile",defaultValue = "dev")
    private String profile;


    public SqldatasourcePlugin(Reststop reststop) {
        this.dataSource = DataSourceProvider.configureAndMigrateDataSource( this );
    }


    public String getDatasourceUrl() {
        return datasourceUrl;
    }


    public String getUsername() {
        return username;
    }


    public String getPassword() {
        return password;
    }


    public String getDriverClass() {
        return driverClass;
    }


}
