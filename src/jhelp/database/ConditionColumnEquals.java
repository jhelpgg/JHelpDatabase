/**
 * <h1>License :</h1> <br>
 * The following code is deliver as is. I take care that code compile and work, but I am not responsible about any damage it may
 * cause.<br>
 * You can use, modify, the code as your need for any usage. But you can't do any action that avoid me or other person use,
 * modify this code. The code is free for usage and modification, you can't change that fact.<br>
 * <br>
 * 
 * @author JHelp
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
      final StringBuilder stringBuffer = new StringBuilder(this.columnName);

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

   /**
    * String representation
    * 
    * @return String representation
    * @see jhelp.database.Condition#toString()
    */
   @Override
   public String toString()
   {
      final StringBuilder stringBuffer = new StringBuilder(this.columnName);

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
}