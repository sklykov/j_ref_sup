package databases;

import java.io.File;
import java.sql.*;

// to demonstrate basic database manipulations using sqlite-jdbc
public class ManipulationDatabase {
    public static final String MOVIES_DEMO_DB = "movies_demo.db";
    public static final String MOVIES = "movies";
    public static final String MOVIE_COLUMN = "movie";
    public static final String DIRECTOR_ID = "director_id";
    public static final String LANGUAGE_COLUMN = "language";
    // public static final String durationColumn = "duration [min]";

    public static void main(String[] args) {
        // building OS-agnostic path for a database
        String separator = System.getProperty("file.separator");
        String currentDir = System.getProperty("user.dir");

        // jdbc:sqlite stands for driver specification for database manipulations
        // it's necessary to specify the driver type (sqlite here) for DriveManager
        String connectionCommand = "jdbc:sqlite:" + currentDir + separator + MOVIES_DEMO_DB;
        String databasePath = currentDir + separator + MOVIES_DEMO_DB;

        // there is general vulnerability in the field of preparing queries: SQL injection attack, when input query may be
        // used for retrieving / changing all values in database. To avoid it - use placeholder "?" for preparing a query
        // and class PreparedStatement
        String preparedQuery = "SELECT * FROM " + MOVIES +" WHERE movie = ?";

        // creation of a new or opening an existing database
        // try with resources - connection and statement will be automatically closed
        try(Connection connection = DriverManager.getConnection(connectionCommand);
            Statement statement = connection.createStatement();
            Statement statementDirectors = connection.createStatement()){

            // a bit ugly manual construction of SQL statement
            String command = "CREATE TABLE IF NOT EXISTS " + MOVIES + "(" +
                    MOVIE_COLUMN + " TEXT, " + LANGUAGE_COLUMN + " TEXT, " + DIRECTOR_ID + " INTEGER" + ")";
            //System.out.println("Performed command: " + command);
            statement.execute(command);
            // without construction some manual input into created table
            statement.execute("insert into movies (movie, language, director_id) values ('The Thing', 'English', 1)");
            statement.execute("insert into movies (movie, language, director_id) values ('RoboCop', 'English', 2)");
            statement.execute("insert into movies (movie, language, director_id) values ('Total Recall', 'English', 2)");

            // another table without constants for creation of joined string, just manually
            // !!!: table.rowid - automatically implicitly injects primary key into table,
            // and it's available for queries (see below)
             statementDirectors.execute("create table directors(name text, surname text)");
             statementDirectors.execute("insert into directors values ('John', 'Carpenter')");
             statementDirectors.execute("insert into directors values ('Paul', 'Verhoeven')");

            // performing simple request
            ResultSet results = statement.executeQuery("select * from " + MOVIES);
            while (results.next()) System.out.println(results.getString(MOVIE_COLUMN) + " " + results.getString(LANGUAGE_COLUMN) +
                    " director id:" + results.getInt(DIRECTOR_ID));
            System.out.println("***************************************");
            ResultSet queryResults = statementDirectors.executeQuery("SELECT * FROM movies JOIN directors WHERE" +
                    " movies.director_id = directors.rowid");
            while (queryResults.next()) System.out.println(queryResults.getString(MOVIE_COLUMN) + " is by "
                    + queryResults.getString("name") + " " + queryResults.getString("surname"));

            // trick suggested in the Udemy course for getting metadata about sqlite table
            // (it's stated that direct request returns null)
            System.out.println("***************************************");
            System.out.println("Column names in the table " + MOVIES + ":");
            results = statement.executeQuery("select * from " + MOVIES);
            ResultSetMetaData resultSetMetaData = results.getMetaData(); // getting metadata from performed general query
            int numberOfColsInMovies = resultSetMetaData.getColumnCount();
            for (int i = 1; i <= numberOfColsInMovies; i++){
                System.out.format("Column %d : %s \n", i, resultSetMetaData.getColumnName(i));
            }

            // using PreparedStatement implies that the table already exists - cannot be specified in the try case above
            // so, to use PreparedStatement: 1) Declare the queries with appropriate placeholders; 2) Initialized this class with query
            // 3) Specify by indexing starting at 1 the placeholders literals; 4) Perform the query
            try(PreparedStatement preparedStatement = connection.prepareStatement(preparedQuery)){
                System.out.println("***************************************");
                preparedStatement.setString(1, "RoboCop");  // replace 1st placeholder in the preparedQuery String
                results = preparedStatement.executeQuery();  // the query will pre-compiled
                System.out.println("The prepared statement is: " + preparedStatement);
                System.out.println(results.getString(MOVIE_COLUMN) + " " +  results.getString(LANGUAGE_COLUMN));
            } catch (SQLException e )  { System.out.println(e.getMessage()); }

        } catch (SQLException e){
            System.out.println(e.getMessage());
        } finally {
            // cleaning out the created testing database file in the end of all manipulations
            File databaseFile = new File(databasePath);
            if (databaseFile.isFile()){
                System.out.println("***************************************");
                if (databaseFile.delete()) System.out.println("Database created and now is removed");
            }
        }
    }
}
