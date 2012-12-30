/**
 * Project : JHelpConnection<br>
 * Package : jhelp.connection.sql<br>
 * Class : Condition<br>
 * Date : 17 mars 2009<br>
 * By JHelp
 */
package jhelp.database;

/**
 * Generic condition<br>
 * <br>
 * Last modification : 17 mars 2009<br>
 * Version 0.0.0<br>
 * 
 * @author JHelp
 */
public abstract class Condition
{

   /**
    * Constructs Condition
    */
   public Condition()
   {
   }

   /**
    * String representation on asking database for encrypt if need
    * 
    * @param database
    *           Database reference
    * @return String representation
    */
   protected abstract String toString(Database database);

   /**
    * String representation
    * 
    * @return String representation
    * @see java.lang.Object#toString()
    */
   @Override
   public abstract String toString();
}