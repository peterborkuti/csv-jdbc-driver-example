## csv jdbc driver usage

Jdbc driver experiment. For more info, see

https://github.com/peterborkuti/csv-jdbc-driver

### running from command line

* check the App.java and modify the jdb url last part (the directory) for and existing directory
* put a ';' separated test.csv file for that directory with at least two columns and two rows
* mvn clean install for both repository (csv-jdbc-driver and csv-jdbc-driver-example)
* put both jars into a directory, example 'modules'
* ```java --module-path modules -m CsvSqlDriverExample/org.usageexample.App```

