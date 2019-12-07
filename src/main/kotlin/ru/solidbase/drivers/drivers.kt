package ru.solidbase.drivers

import java.lang.IllegalStateException
import kotlin.reflect.KClass

class Configuration {
    val driver: Driver = Driver()
}

class Driver {
    protected var catalog: Catalog = Catalog("", mutableMapOf())
    fun catalog(name: String, version: String, configure: Catalog.() -> Unit) {
        catalog = Catalog(name, mutableMapOf()).apply(configure)
    }
}
class Catalog(
    protected val name: String,
    protected val schemas: MutableMap<String, Schema>
) {
    private var schemaLocked = false

    fun schema(name: String, configure: Schema.() -> Unit) {
        if (!schemaLocked) {
            schemaLocked = true
            schemas.getOrPut(name, { Schema(name, mutableListOf()) }).configure()
            schemaLocked = false
        } else {
            throw IllegalStateException("Invalid call")
        }

    }
}
class Schema(
    protected val name: String,
    protected val tables: MutableList<Table>
) {

    fun table(name: String, configure: Table.() -> Unit) {
        tables.add(Table(name, mutableListOf()).apply(configure))
    }

    fun fromPackage(packageName: String) {
        println("make schema from classes of package $packageName")
    }
}

fun postgres(configure: Driver.() -> Unit): Configuration = Configuration().apply { driver.configure() }

class Table(
    protected val name: String,
    protected val columns: MutableList<Column>
) {
    fun column(name: String, configure: Column.() -> Unit) {
        columns.add(Column(name).apply(configure))
    }

    fun from(clazz: KClass<*>) {
        println("parsing class ${clazz.qualifiedName}")
    }
}

fun data(configure: Data.() -> Unit) {}


class Data {
    var url = ""
}

interface SqlType
class SqlTypeNone: SqlType
class Varchar (
    val length: Int
): SqlType
class Number (
    val digits: Int
): SqlType

class ForiganKey(
    val table: String,
    val column: String
)

infix fun String.column(column: String) = ForiganKey(this, column)

class Column(
    val name: String
) {
    private var primaryWasSet = false
    var primary = false
        set(value) {
            if (!primaryWasSet) {
                field = value
                primaryWasSet = true
            } else {
                throw Exception("field primary was already set to $field")
            }
        }
    var incrementing = true
    var nullable = true
    var type: SqlType = SqlTypeNone()
    var forienKey: ForiganKey = ForiganKey("", "")
}


