/**
 * Project : JHelpConnection<br>
 * Package : jhelp.connection.sql<br>
 * Class : ConditionUnaire<br>
 * Date : 17 mars 2009<br>
 * By JHelp
 */
package jhelp.database;

/**
 * Condition with one argument<br>
 * <br>
 * Last modification : 17 mars 2009<br>
 * Version 0.0.0<br>
 * 
 * @author JHelp
 */
public abstract class ConditionUnaire
      extends Condition
{
   /** Condition where apply operation */
   private final Condition condition;
   /** Condition operation name */
   private final String    conditionName;

   /**
    * Constructs ConditionUnaire
    * 
    * @param conditionName
    *           Condition operation name
    * @param condition
    *           Condition where apply condition
    */
   public ConditionUnaire(final String conditionName, final Condition condition)
   {
      if(conditionName == null)
      {
         throw new NullPointerException("conditionName musn't be null");
      }
      if(condition == null)
      {
         throw new NullPointerException("condition musn't be null");
      }
      this.conditionName = conditionName;
      this.condition = condition;
   }

   /**
    * String representation on asking database for encrypt if need
    * 
    * @param database
    *           Database reference
    * @return String representation
    * @see jhelp.database.Condition#toString(jhelp.database.Database)
    */
   @Override
   protected String toString(final Database database)
   {
      final StringBuffer stringBuffer = new StringBuffer(this.conditionName);
      stringBuffer.append('(');
      stringBuffer.append(this.condition.toString(database));
      stringBuffer.append(')');

      return stringBuffer.toString();
   }

   /**
    * String representation
    * 
    * @return String representation
    * @see jhelp.database.Condition#toString()
    */
   @Override
   public String toString()
   {
      final StringBuffer stringBuffer = new StringBuffer(this.conditionName);
      stringBuffer.append('(');
      stringBuffer.append(this.condition.toString());
      stringBuffer.append(')');

      return stringBuffer.toString();
   }
}