package jhelp.database.cache;

import jhelp.database.DatabaseException;
import jhelp.util.math.UtilMath;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test of cache based on database
 * 
 * @author JHelp
 */
public class DatabaseCacheTest
{
   /**
    * Do a simple test about type and value
    * 
    * @throws DatabaseException
    *            On database creation/request issue
    */
   @Test
   public void test() throws DatabaseException
   {
      final DatabaseCache database = new DatabaseCache("TEST_CACHE");

      database.store("5", 5);
      database.store("PI", Math.PI);
      database.store("String", "String");
      database.store("TRUE", true);
      database.store("array", new byte[]
      {
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9
      });

      Assert.assertEquals(5, database.getInteger("5", 0));
      Assert.assertEquals(Math.PI, database.getReal("PI", 0), UtilMath.EPSILON);
      Assert.assertEquals("String", database.getString("String"));
      Assert.assertEquals(true, database.getBoolean("TRUE", false));
      Assert.assertArrayEquals(new byte[]
      {
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9
      }, database.getByteArray("array"));

      //

      database.store("String", "String2");
      Assert.assertEquals("String2", database.getString("String"));

      database.closeDatabaseCache();
   }
}