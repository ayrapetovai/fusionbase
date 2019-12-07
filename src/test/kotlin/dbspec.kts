import ru.solidbase.drivers.*

// java -jar lus-solidbase-120.jar --tag=3 --url=jdbc:postgres:localhost:3456/postgres

//config {
//    versionComporator = Cmp(pattern = "")
//    recurciveConfig = true
//    variables {
//        system
//        maven
//        gradle
//        cmd
//        properties
//    }
//}
postgres {
    catalog("postgres", "3") {
        schema("myscheme") {
            table("mytable1") {
                column("id") {
                    primary = true
                    incrementing = true
                    type = Number(10)
                }
                column("valuea") {
                    type = Varchar(100)
                }
                column("valueb") {
                    type = Varchar(100)
                    nullable = false
                }
                data {
                    url = "classpath:db/data/1342/mytable.csv"
                }
//                schema("") {}
            }
            table("mytable2") {
                column("id") {
                    primary = true
                    incrementing = true
                    type = Number(10)
                }
                column("value") {
                    type = Varchar(200)
                }
            }
            table("table3") {
                from(HibernateEntity::class)
            }
        }
        schema("anothers") { }
        schema("trololo") {
            fromPackage("ru.msc.model")
        }
    }
}
