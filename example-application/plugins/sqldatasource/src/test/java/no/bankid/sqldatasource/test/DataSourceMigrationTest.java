package no.bankid.sqldatasource.test;

import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import javax.sql.DataSource;

import no.bankid.sqldatasource.DataSourceProvider;
import no.bankid.sqldatasource.DefaultH2Config;

import org.junit.Test;

public class DataSourceMigrationTest  {

	@Test
	public void testInitializationAndMigration() throws SQLException {
		final DataSource dataSource = DataSourceProvider
				.configureAndMigrateDataSource( new DefaultH2Config() );
		Connection connection = dataSource.getConnection();
		DatabaseMetaData metaData = connection.getMetaData();

		assertTableCreation(metaData, "ORIGINATOR");
		assertTableCreation(metaData, "CAGROUP");
		assertTableCreation(metaData, "MERCHANT");
		assertTableCreation(metaData, "AGGREGATOR");
	}

	private void assertTableCreation(DatabaseMetaData metaData, String tableName) throws SQLException {
	    assertTrue(tableName + " table created",metaData.getTables(null, null, "ORIGINATOR", null).next());
    }



}
