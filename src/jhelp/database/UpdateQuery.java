/**
 * Project : JHelpDataBase<br>
 * Package : jhelp.database<br>
 * Class : UpdateQuery<br>
 * Date : 20 avr. 2009<br>
 * By JHelp
 */
package jhelp.database;

/**
 * Querry for update<br>
 * <br>
 * Last modification : 20 avr. 2009<br>
 * Version 0.0.0<br>
 * 
 * @author JHelp
 */
public class UpdateQuery
{
   /** Table to update */
   private final String  table;
   /** Values for each columns */
   private final Value[] values;
   /** Condition for update */
   private Condition     where;

   /**
    * Constructs UpdateQuery
    * 
    * @param table
    *           Table to update
    * @param values
    *           New values
    */
   public UpdateQuery(final String table, final Value... values)
   {
      if(table == null)
      {
         throw new NullPointerException("table musn't be null");
      }

      if(values == null)
      {
         throw new NullPointerException("values musn't be null");
      }

      if(values.length < 1)
      {
         throw new IllegalArgumentException("values must have at least 1 element");
      }

      this.table = table;
      this.values = values;
   }

   /**
    * String representation on asking database for encrypt if need
    * 
    * @param database
    *           Database reference
    * @return String representation
    */
   String toString(final Database database)
   {
      final StringBuffer stringBuffer = new StringBuffer("UPDATE ");
      stringBuffer.append(this.table);
      stringBuffer.append(" SET ");
      stringBuffer.append(this.values[0].getName());
      stringBuffer.append("=");
      stringBuffer.append(database.stringForWrite(this.values[0]));

      for(int i = 1; i < this.values.length; i++)
      {
         stringBuffer.append(" , ");
         stringBuffer.append(this.values[i].getName());
         stringBuffer.append("=");
         stringBuffer.append(database.stringForWrite(this.values[i]));
      }

      if(this.where != null)
      {
         stringBuffer.append(" WHERE ");
         stringBuffer.append(this.where.toString(database));
      }

      return stringBuffer.toString();
   }

   /**
    * Actual condition (can be {@code null} if no condition)
    * 
    * @return Actual condition
    */
   public Condition getWhere()
   {
      return this.where;
   }

   /**
    * Set the condition (can be {@code null} if no condition)
    * 
    * @param where
    *           New condition
    */
   public void setWhere(final Condition where)
   {
      this.where = where;
   }

   /**
    * Condition string
    * 
    * @return Condition string
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString()
   {
      final StringBuffer stringBuffer = new StringBuffer("UPDATE ");
      stringBuffer.append(this.table);
      stringBuffer.append(" SET ");
      stringBuffer.append(this.values[0].getName());
      stringBuffer.append("=");
      stringBuffer.append(this.values[0].getData().toString());

      for(int i = 1; i < this.values.length; i++)
      {
         stringBuffer.append(" , ");
         stringBuffer.append(this.values[i].getName());
         stringBuffer.append("=");
         stringBuffer.append(this.values[i].getData().toString());
      }

      if(this.where != null)
      {
         stringBuffer.append(" WHERE ");
         stringBuffer.append(this.where.toString());
      }

      return stringBuffer.toString();
   }
}