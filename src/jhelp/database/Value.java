/**
 * Project : JHelpDataBase<br>
 * Package : jhelp.database<br>
 * Class : Value<br>
 * Date : 16 avr. 2009<br>
 * By JHelp
 */
package jhelp.database;

/**
 * A value have column name and data<br>
 * Use to insert value in table<br>
 * <br>
 * Last modification : 16 avr. 2009<br>
 * Version 0.0.0<br>
 * 
 * @author JHelp
 */
public class Value
{
   /** Column name */
   private String name;
   /** Data */
   private Data   data;

   /**
    * Constructs Value
    * 
    * @param name
    *           Column name
    * @param data
    *           Data
    */
   public Value(String name, Data data)
   {
      if(name == null)
      {
         throw new NullPointerException("name musn't be null");
      }
      if(data == null)
      {
         throw new NullPointerException("data musn't be null");
      }
      this.name = name;
      this.data = data;
   }

   /**
    * Return name
    * 
    * @return name
    */
   public String getName()
   {
      return this.name;
   }

   /**
    * Return data
    * 
    * @return data
    */
   public Data getData()
   {
      return this.data;
   }
}