package org.taskana.configuration;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.taskana.SpringTaskanaEngineImpl;
import org.taskana.TaskanaEngine;

/**
 * This class configures the TaskanaEngineConfiguration for spring
 */
public class SpringTaskanaEngineConfiguration extends TaskanaEngineConfiguration {

	private static final Logger logger = LoggerFactory.getLogger(SpringTaskanaEngineConfiguration.class);

	/**
	 * This method creates the Spring-based TaskanaEngine without an
	 * sqlSessionFactory
	 * 
	 * @return the TaskanaEngine
	 * @throws SQLException
	 */
	public TaskanaEngine buildTaskanaEngine() {
		this.useContainerManagedTransactions = true;

		dbScriptRunner = new DbScriptRunner(this.dataSource);
		try {
			dbScriptRunner.run();
		} catch (SQLException e) {
			logger.error("The taskana schema could not be created: ", e);
		}

		return new SpringTaskanaEngineImpl(this);
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}
