/**
 * Project : JHelpDataBase<br>
 * Package : jhelp.database<br>
 * Class : DatabaseType<br>
 * Date : 16 avr. 2009<br>
 * By JHelp
 */
package jhelp.database;

/**
 * Data type<br>
 * <br>
 * Last modification : 16 avr. 2009<br>
 * Version 0.0.0<br>
 * 
 * @author JHelp
 */
public enum DataType
{
   /** int */
   INT,
   /** double */
   DOUBLE,
   /** String (128) */
   VARCHAR,
   /** String "infinite" */
   LONGVARCHAR,
   /** java.sql.Date */
   DATE,
   /** java.sql.Time */
   TIME,
   /** java.sql.Timestamp */
   TIMESTAMP,
   /** java.math.BigDecimal */
   DECIMAL,
   /** boolean */
   BOOLEAN,
   /** byte */
   TINYINT,
   /** short */
   SMALLINT,
   /** long */
   BIGINT,
   /** byte[] **/
   BINARY,
   /** Object */
   OBJECT
}