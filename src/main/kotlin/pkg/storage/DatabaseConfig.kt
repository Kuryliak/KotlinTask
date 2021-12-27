package pkg.storage

import io.ebean.DB
import io.ebean.Database

object DatabaseConfig {
    val database: Database = DB.byName("kotlin-taskdb")
}
