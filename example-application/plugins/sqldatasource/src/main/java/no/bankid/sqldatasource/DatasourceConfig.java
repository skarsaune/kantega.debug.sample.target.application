package no.bankid.sqldatasource;

/**
 * Parameter object for configuring a datasource
 * @author marska
 *
 */
public interface DatasourceConfig {
	public String getDatasourceUrl();

	public String getUsername();

	public String getPassword();

	public String getDriverClass();
}
