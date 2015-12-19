/**
 * <h1>License :</h1> <br>
 * The following code is deliver as is. I take care that code compile and work, but I am not responsible about any damage it may
 * cause.<br>
 * You can use, modify, the code as your need for any usage. But you can't do any action that avoid me or other person use,
 * modify this code. The code is free for usage and modification, you can't change that fact.<br>
 * <br>
 * 
 * @author JHelp
 */
package jhelp.database;

/**
 * Condition that implies two conditions<br>
 * <br>
 * Last modification : 17 mars 2009<br>
 * Version 0.0.0<br>
 * 
 * @author JHelp
 */
public abstract class ConditionBinaire
      extends Condition
{
   /** First condition */
   private final Condition condition1;
   /** Second condition */
   private final Condition condition2;
   /** Condition operation name */
   private final String    conditionName;

   /**
    * Constructs ConditionBinaire
    * 
    * @param conditionName
    *           Condition operation name
    * @param condition1
    *           First condition
    * @param condition2
    *           Second condition
    */
   public ConditionBinaire(final String conditionName, final Condition condition1, final Condition condition2)
   {
      if(conditionName == null)
      {
         throw new NullPointerException("conditionName musn't be null");
      }
      if(condition1 == null)
      {
         throw new NullPointerException("condition1 musn't be null");
      }
      if(condition2 == null)
      {
         throw new NullPointerException("condition2 musn't be null");
      }

      this.conditionName = conditionName;
      this.condition1 = condition1;
      this.condition2 = condition2;
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
      final StringBuffer stringBuffer = new StringBuffer();
      stringBuffer.append('(');
      stringBuffer.append(this.condition1.toString(database));
      stringBuffer.append(") ");
      stringBuffer.append(this.conditionName);
      stringBuffer.append(" (");
      stringBuffer.append(this.condition2.toString(database));
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
      final StringBuffer stringBuffer = new StringBuffer();
      stringBuffer.append('(');
      stringBuffer.append(this.condition1.toString());
      stringBuffer.append(") ");
      stringBuffer.append(this.conditionName);
      stringBuffer.append(" (");
      stringBuffer.append(this.condition2.toString());
      stringBuffer.append(')');

      return stringBuffer.toString();
   }
}