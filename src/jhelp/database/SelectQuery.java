/**
 * Project : JHelpDataBase<br>
 * Package : jhelp.database<br>
 * Class : SelectQuery<br>
 * Date : 16 avr. 2009<br>
 * By JHelp
 */
package jhelp.database;

import jhelp.util.Utilities;

/**
 * Query for make a selection<br>
 * The where can be modified<br>
 * Can be reuse several times<br>
 * All query is compute each time it is use, so if you use a Data instance id where you can modify the data value and reuse the
 * query, the new value will be use<br>
 * <br>
 * Last modification : 16 avr. 2009<br>
 * Version 0.0.0<br>
 * 
 * @author JHelp
 */
public class SelectQuery
{
   /** Columns return the query */
   private final ColumnDescription[] columns;
   /** Table for selection */
   private final String              table;
   /** Condition of selection (can be {@code null} for no condition) */
   private Condition                 where;

   /**
    * Constructs SelectQuery
    * 
    * @param table
    *           Table for selection
    * @param columns
    *           Columns in result
    */
   public SelectQuery(final String table, final ColumnDescription... columns)
   {
      if(table == null)
      {
         throw new NullPointerException("table musn't be null");
      }
      if(columns == null)
      {
         throw new NullPointerException("columns musn't be null");
      }
      if(columns.length == 0)
      {
         throw new IllegalArgumentException("At least one column is need");
      }

      this.columns = columns;
      this.table = table;
   }

   /**
    * Constructs SelectQuery for query all columns
    * 
    * @param tableInfo
    *           Table information
    */
   public SelectQuery(final TableInfo tableInfo)
   {
      this.table = tableInfo.getName();
      this.columns = tableInfo.getColumns();
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
      final StringBuffer stringBuffer = new StringBuffer("SELECT ");

      stringBuffer.append(this.columns[0].getColumnName());
      for(int i = 1; i < this.columns.length; i++)
      {
         stringBuffer.append(",");
         stringBuffer.append(this.columns[i].getColumnName());
      }

      stringBuffer.append(" FROM ");
      stringBuffer.append(this.table);

      if(this.where != null)
      {
         stringBuffer.append(" WHERE ");
         stringBuffer.append(this.where.toString(database));
      }

      return stringBuffer.toString();
   }

   /**
    * Columns in selection
    * 
    * @return Columns in selection
    */
   public ColumnDescription[] getColumns()
   {
      return Utilities.createCopy(this.columns);
   }

   /**
    * Change selection condition
    * 
    * @param where
    *           New condition. Can be {@code null} for no condition
    * @return The query itself
    */
   public SelectQuery setWhere(final Condition where)
   {
      this.where = where;

      return this;
   }

   /**
    * Compute the select query
    * 
    * @return Select query
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString()
   {
      final StringBuffer stringBuffer = new StringBuffer("SELECT ");

      stringBuffer.append(this.columns[0].getColumnName());
      for(int i = 1; i < this.columns.length; i++)
      {
         stringBuffer.append(",");
         stringBuffer.append(this.columns[i].getColumnName());
      }

      stringBuffer.append(" FROM ");
      stringBuffer.append(this.table);

      if(this.where != null)
      {
         stringBuffer.append(" WHERE ");
         stringBuffer.append(this.where.toString());
      }

      return stringBuffer.toString();
   }
}