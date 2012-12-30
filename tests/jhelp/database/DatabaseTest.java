/**
 * Project : TestingAll<br>
 * Package : jhelp.database<br>
 * Class : DatabaseTest<br>
 * Date : 17 juil. 2010<br>
 * By JHelp
 */
package jhelp.database;

import org.junit.Assert;
import org.junit.Test;

/**
 * Database test<br>
 * <br>
 * Last modification : 17 juil. 2010<br>
 * Version 0.0.0<br>
 * 
 * @author JHelp
 */
public class DatabaseTest
{
   /**
    * Password test
    * 
    * @throws DatabaseException
    *            On database access issue
    */
   @Test
   public void testPasswordNormal() throws DatabaseException
   {
      Database database = new Database("TEST", "password");

      database.createTable("TABLE", new ColumnDescription("Column1", DataType.LONGVARCHAR), new ColumnDescription("Column2", DataType.INT));

      database.insertOrUpdate("TABLE", new ConditionColumnEquals("Column2", new Data(1)), new Value("Column1", Data.createLongStringData("Test of password to see if encrypted database work")), new Value("Column2", new Data(1)));

      database.closeDatabase();

      //

      database = new Database("TEST", "password");

      final SelectQuery selectQuery = new SelectQuery("TABLE", new ColumnDescription("Column1", DataType.LONGVARCHAR));
      selectQuery.setWhere(new ConditionColumnEquals("Column2", new Data(1)));

      final QueryResult queryResult = database.query(selectQuery);

      Assert.assertEquals(1, queryResult.numberOfRows());
      Assert.assertEquals("Test of password to see if encrypted database work", queryResult.getData(0, 0).getLongString());

      queryResult.destroy();

      database.closeDatabase();
   }

   /**
    * Security of password test
    * 
    * @throws DatabaseException
    *            On database access issue
    */
   @Test
   public void testPasswordSecurity() throws DatabaseException
   {
      Database database = new Database("TEST", "password");

      database.createTable("TABLE", new ColumnDescription("Column1", DataType.LONGVARCHAR), new ColumnDescription("Column2", DataType.INT));

      database.insertOrUpdate("TABLE", new ConditionColumnEquals("Column2", new Data(1)), new Value("Column1", Data.createLongStringData("Test of password to see if encrypted database work")), new Value("Column2", new Data(1)));

      database.closeDatabase();

      //

      try
      {
         database = new Database("TEST", "password2");

         Assert.fail("Can't continue with wrong password");
      }
      catch(final Exception exception)
      {
         // That we want
      }
   }
}