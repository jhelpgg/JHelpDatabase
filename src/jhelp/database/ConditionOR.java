/**
 * Project : JHelpConnection<br>
 * Package : jhelp.connection.sql<br>
 * Class : ConditionOR<br>
 * Date : 17 mars 2009<br>
 * By JHelp
 */
package jhelp.database;

/**
 * Condition for make a OR between two conditions<br>
 * <br>
 * Last modification : 17 mars 2009<br>
 * Version 0.0.0<br>
 * 
 * @author JHelp
 */
public class ConditionOR
      extends ConditionBinaire
{
   /**
    * Constructs ConditionOR
    * 
    * @param condition1
    *           First condition
    * @param condition2
    *           Second condition
    */
   public ConditionOR(Condition condition1, Condition condition2)
   {
      super("OR", condition1, condition2);
   }
}