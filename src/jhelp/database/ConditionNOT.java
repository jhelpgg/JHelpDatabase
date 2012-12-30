/**
 * Project : JHelpConnection<br>
 * Package : jhelp.connection.sql<br>
 * Class : ConditionNOT<br>
 * Date : 17 mars 2009<br>
 * By JHelp
 */
package jhelp.database;

/**
 * Condition to negate a condition<br>
 * <br>
 * Last modification : 17 mars 2009<br>
 * Version 0.0.0<br>
 * 
 * @author JHelp
 */
public class ConditionNOT
      extends ConditionUnaire
{
   /**
    * Constructs ConditionNOT
    * 
    * @param condition
    *           Condition to negate
    */
   public ConditionNOT(Condition condition)
   {
      super("NOT", condition);
   }
}