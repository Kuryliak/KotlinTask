package backend.infrastructure.config

import io.ebean.DB
import io.ebean.Database

object DatabaseConfig {
    val database: Database = DB.getDefault()
}
