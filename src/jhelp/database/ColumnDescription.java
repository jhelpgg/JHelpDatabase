/**
 * Project : JHelpDataBase<br>
 * Package : jhelp.database<br>
 * Class : ColumnDescription<br>
 * Date : 16 avr. 2009<br>
 * By JHelp
 */
package jhelp.database;

import jhelp.util.HashCode;

/**
 * describe a column<br>
 * <br>
 * Last modification : 16 avr. 2009<br>
 * Version 0.0.0<br>
 * 
 * @author JHelp
 */
public class ColumnDescription
{
   /** Column name */
   private final String   columnName;
   /** Column data type */
   private final DataType dataType;
   /** Table reference if column is foreign key */
   private String         foreignKey;

   /**
    * Constructs ColumnDescription
    * 
    * @param columnName
    *           Column name
    * @param dataType
    *           Data type
    */
   public ColumnDescription(final String columnName, final DataType dataType)
   {
      if(columnName == null)
      {
         throw new NullPointerException("columnName musn't be null");
      }
      if(dataType == null)
      {
         throw new NullPointerException("dataType musn't be null");
      }
      this.columnName = columnName;
      this.dataType = dataType;
      this.foreignKey = null;
   }

   /**
    * Indicates if this column description is equals to a given object
    * 
    * @param obj
    *           Object test
    * @return {@code true} if the given object is equals to this column description
    * @see java.lang.Object#equals(java.lang.Object)
    */
   @Override
   public boolean equals(final Object obj)
   {
      if(this == obj)
      {
         return true;
      }
      if(obj == null)
      {
         return false;
      }
      if(!(obj instanceof ColumnDescription))
      {
         return false;
      }
      final ColumnDescription other = (ColumnDescription) obj;
      if(this.columnName == null)
      {
         if(other.columnName != null)
         {
            return false;
         }
      }
      else if(!this.columnName.equalsIgnoreCase(other.columnName))
      {
         return false;
      }
      if(this.dataType == null)
      {
         if(other.dataType != null)
         {
            return false;
         }
      }
      else if(!this.dataType.equals(other.dataType))
      {
         return false;
      }
      return true;
   }

   /**
    * Return columnName
    * 
    * @return columnName
    */
   public String getColumnName()
   {
      return this.columnName;
   }

   /**
    * Return dataType
    * 
    * @return dataType
    */
   public DataType getDataType()
   {
      return this.dataType;
   }

   /**
    * Hash code
    * 
    * @return Hash code
    * @see java.lang.Object#hashCode()
    */
   @Override
   public int hashCode()
   {
      return HashCode.computeHashCode(this.columnName, this.dataType);
   }

   /**
    * Return foreignKey
    * 
    * @return foreignKey
    */
   public String isForeignKey()
   {
      return this.foreignKey;
   }

   /**
    * Modify foreignKey
    * 
    * @param foreignKey
    *           New foreignKey value
    */
   public void setForeignKey(final String foreignKey)
   {
      this.foreignKey = foreignKey;
   }
}