package db

import io.ebean.DatabaseFactory
import io.ebean.config.DatabaseConfig
import io.ebean.datasource.DataSourceConfig

fun db() {
    val dataSourceConfig = DataSourceConfig()
    dataSourceConfig.username = "sa"
    dataSourceConfig.password = ""
    dataSourceConfig.url = "jdbc:h2:mem:myapp;"

    val config = DatabaseConfig()
    config.dataSourceConfig = (dataSourceConfig)


    val database = DatabaseFactory.create(config)


}

