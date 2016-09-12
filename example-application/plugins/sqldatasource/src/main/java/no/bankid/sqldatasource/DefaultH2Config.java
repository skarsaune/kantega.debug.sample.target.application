package no.bankid.sqldatasource;

public class DefaultH2Config implements DatasourceConfig {
	
	@Override
	public String getDatasourceUrl() {
		return "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
	}

	@Override
	public String getUsername() {
		return "da";
	}

	@Override
	public String getPassword() {
		return "";
	}

	@Override
	public String getDriverClass() {
		return "org.h2.Driver";
	}

}
