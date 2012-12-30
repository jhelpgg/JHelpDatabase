/**
 * Project : JHelpConnection<br>
 * Package : jhelp.connection.sql<br>
 * Class : ConditionAND<br>
 * Date : 17 mars 2009<br>
 * By JHelp
 */
package jhelp.database;

/**
 * Condition make AND between tow conditions<br>
 * <br>
 * Last modification : 17 mars 2009<br>
 * Version 0.0.0<br>
 * 
 * @author JHelp
 */
public class ConditionAND
      extends ConditionBinaire
{
   /**
    * Constructs ConditionAND
    * 
    * @param condition1
    *           First condition
    * @param condition2
    *           Second condition
    */
   public ConditionAND(Condition condition1, Condition condition2)
   {
      super("AND", condition1, condition2);
   }
}