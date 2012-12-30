/**
 * Project : JHelpDataBase<br>
 * Package : jhelp.database<br>
 * Class : QueryResult<br>
 * Date : 16 avr. 2009<br>
 * By JHelp
 */
package jhelp.database;

import java.util.ArrayList;

/**
 * Result from a select query <br>
 * <br>
 * Last modification : 16 avr. 2009<br>
 * Version 0.0.0<br>
 * 
 * @author JHelp
 */
public class QueryResult
{
   /** Columns in the result */
   private ColumnDescription[] columns;
   /** Result table */
   private ArrayList<Data[]>   rows;

   /**
    * Constructs QueryResult
    * 
    * @param columns
    *           Columns in result
    */
   QueryResult(ColumnDescription... columns)
   {
      this.columns = columns;
      this.rows = new ArrayList<Data[]>();
   }

   /**
    * Add row to the result
    * 
    * @param datas
    *           Data for each column
    */
   void addRow(Data... datas)
   {
      this.rows.add(datas);
   }

   /**
    * Number of columns in the result
    * 
    * @return Number of columns in the result
    */
   public int numberOfColumns()
   {
      return this.columns.length;
   }

   /**
    * Column description
    * 
    * @param column
    *           Column index
    * @return Column description
    */
   public ColumnDescription getColumnDescription(int column)
   {
      return this.columns[column];
   }

   /**
    * Obtain index of column with the given name
    * 
    * @param columnName
    *           Column name search
    * @return Index of the column
    */
   public int getColumnIndex(String columnName)
   {
      for(int i = 0; i < this.columns.length; i++)
      {
         if(this.columns[i].getColumnName().equals(columnName) == true)
         {
            return i;
         }
      }

      return -1;
   }

   /**
    * Number of rows in the result
    * 
    * @return Number of rows in the result
    */
   public int numberOfRows()
   {
      return this.rows.size();
   }

   /**
    * Data in the result
    * 
    * @param column
    *           Column
    * @param row
    *           Row
    * @return Data at the specified position
    */
   public Data getData(int column, int row)
   {
      return this.rows.get(row)[column];
   }

   /**
    * Destroy the result<br>
    * Use it when you not need result again, to free memory
    */
   public void destroy()
   {
      for(int i = this.columns.length - 1; i >= 0; i--)
      {
         this.columns[i] = null;
      }
      this.columns = null;
      this.rows.clear();
      this.rows = null;
   }
}