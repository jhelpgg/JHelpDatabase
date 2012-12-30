/**
 * Project : JHelpDataBase<br>
 * Package : jhelp.database.file<br>
 * Class : ConditionFileAssociation<br>
 * Date : 18 avr. 2009<br>
 * By JHelp
 */
package jhelp.database.file;

import jhelp.database.Condition;
import jhelp.database.Database;

/**
 * Condition specification file association<br>
 * <br>
 * Last modification : 18 avr. 2009<br>
 * Version 0.0.0<br>
 * 
 * @author JHelp
 */
class ConditionFileAssociation
      extends Condition
{
   /** Files id */
   private final int[] filesID;

   /**
    * Constructs ConditionFileAssociation
    * 
    * @param filesID
    *           files ID
    */
   public ConditionFileAssociation(final int... filesID)
   {
      this.filesID = filesID;
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
      final StringBuffer condition = new StringBuffer();

      final int length = this.filesID.length;

      int mult = 1;
      if(this.filesID[0] < 0)
      {
         condition.append(" NOT (");
         mult = -1;
      }

      condition.append("ID");

      condition.append(" IN (");
      condition.append(mult * this.filesID[0]);

      for(int i = 1; i < length; i++)
      {
         condition.append(", ");
         condition.append(mult * this.filesID[i]);
      }
      condition.append(")");

      if(mult < 0)
      {
         condition.append(")");
      }

      return condition.toString();
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
   public String toString(final Database database)
   {
      final StringBuffer condition = new StringBuffer();

      final int length = this.filesID.length;

      int mult = 1;
      if(this.filesID[0] < 0)
      {
         condition.append(" NOT (");
         mult = -1;
      }

      condition.append("ID");

      condition.append(" IN (");
      condition.append(mult * this.filesID[0]);

      for(int i = 1; i < length; i++)
      {
         condition.append(", ");
         condition.append(mult * this.filesID[i]);
      }
      condition.append(")");

      if(mult < 0)
      {
         condition.append(")");
      }

      return condition.toString();
   }
}