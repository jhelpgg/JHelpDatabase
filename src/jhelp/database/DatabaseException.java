/**
 * Project : JHelpDataBase<br>
 * Package : jhelp.database<br>
 * Class : DatabaseException<br>
 * Date : 16 avr. 2009<br>
 * By JHelp
 */
package jhelp.database;

/**
 * Exception on use data base<br>
 * <br>
 * Last modification : 16 avr. 2009<br>
 * Version 0.0.0<br>
 * 
 * @author JHelp
 */
public class DatabaseException
      extends Exception
{

   /** serialVersionUID */
   private static final long serialVersionUID = -5698685938159931801L;

   /**
    * Constructs DatabaseException
    */
   public DatabaseException()
   {
   }

   /**
    * Constructs DatabaseException
    * 
    * @param message
    *           Message
    */
   public DatabaseException(final String message)
   {
      super(message);
   }

   /**
    * Constructs DatabaseException
    * 
    * @param message
    *           Message
    * @param cause
    *           Cause
    */
   public DatabaseException(final String message, final Throwable cause)
   {
      super(message, cause);
   }

   /**
    * Constructs DatabaseException
    * 
    * @param cause
    *           Cause
    */
   public DatabaseException(final Throwable cause)
   {
      super(cause);
   }
}