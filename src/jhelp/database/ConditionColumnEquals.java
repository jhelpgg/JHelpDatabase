/**
 * Project : JHelpConnection<br>
 * Package : jhelp.connection.sql<br>
 * Class : ColumnEquals<br>
 * Date : 17 mars 2009<br>
 * By JHelp
 */
package jhelp.database;

/**
 * Condition to verify if column is equal to a specify value<br>
 * <br>
 * Last modification : 17 mars 2009<br>
 * Version 0.0.0<br>
 * 
 * @author JHelp
 */
public class ConditionColumnEquals
      extends Condition
{
   /** Column name */
   private final String columnName;
   /** Value expected */
   private final Data   value;

   /**
    * Constructs ColumnEquals
    * 
    * @param columnName
    *           Column name
    * @param value
    *           Value test
    */
   public ConditionColumnEquals(final String columnName, final Data value)
   {
      if(columnName == null)
      {
         throw new NullPointerException("columnName musn't be null");
      }
      this.columnName = columnName;
      this.value = value;
   }

   /**
    * String representation
    * 
    * @return String representation
    * @see jhelp.database.Condition#toString()
    */
   @Override
   public String toString()
   {
      final StringBuffer stringBuffer = new StringBuffer(this.columnName);

      if(this.value == null)
      {
         stringBuffer.append("=NULL");
      }
      else
      {
         stringBuffer.append("=");
         stringBuffer.append(this.value.toString());
      }

      return stringBuffer.toString();
   }

   /**
    * String representation on asking database for encrypt if need
    * 
    * @param database
    *           Database reference
    * @return String representation
    * @see jhelp.database.Condition#toString(jhelp.database.Database)
    */
   @Override
   protected String toString(final Database database)
   {
      final StringBuffer stringBuffer = new StringBuffer(this.columnName);

      if(this.value == null)
      {
         stringBuffer.append("=NULL");
      }
      else
      {
         stringBuffer.append("=");
         stringBuffer.append(database.stringForWrite(this.value));
      }

      return stringBuffer.toString();
   }
}