/*
package Tavant

/*
class ScalaExceptions {

}
*/

import scala.collection.mutable.ListBuffer

case class errorObj (eCodeName: String , eCodeVal: String , eLevel: String, msgKey: String ="", msgType:String = "ent")

trait Errors extends Serializable{
  def reject(eCode: String , emsg: String , eLevel: String, msgKey: String ="", msgType:String = "ent")
  def hasErrors: Boolean
  def showErrors: List[String]
}


class OxyErrors extends Errors{
  val errors = ListBuffer[errorObj]
  override def reject(eCode: String , emsg: String , eLevel: String, msgKey: String , msgType:String ) = {
    errors += new errorObj(eCode, emsg, eLevel, msgKey, msgType)
  }
  override def hasErrors : Boolean ={
    !errors.isEmpty
  }

  override def showErrors : List[String] ={
    val eValue = for (error <- errors) yield error.eCode
    eValue.toList
  }
}


class OxyException(val msg : String = "", val cause : Throwable = None.orNull, error: Errors = None.orNull) extends Exception(msg, cause) with Serializable{
  def this(msg:String,cause: Throwable)=this(msg, cause,None.orNull)
  def this(msg:String,error: Errors)=this(msg, None.orNull, error)
}

class OxyRunTimeException(val msg : String = "", val cause : Throwable = None.orNull, error: Errors = None.orNull) extends RuntimeException(msg, cause) with Serializable{
  def this(msg:String,cause: Throwable)=this(msg, cause,None.orNull)
  def this(msg:String,error: Errors)=this(msg, None.orNull, error)
}
case class MalFormedException(val mssg : String = "", val causee : Throwable = None.orNull) extends OxyException(mssg, causee)
case class MalFormedFileException(val mssg : String = "", val causee : Throwable = None.orNull) extends OxyException(mssg, causee)
case class MalFormedHeaderException(val mssg : String = "", val causee : Throwable = None.orNull) extends OxyException(mssg, causee)
case class InvalidConfigException(val mssg : String = "", val causee : Throwable = None.orNull) extends OxyException(mssg, causee)
// case class InvalidConfigException(val mssg : String = "", val causee : Throwable = None.orNull) extends OxyException(mssg, causee)

// types of usages of these custom exceptions
// 1.
def createApplicationContext(confi: Array[String]) : OxyContext = {
}
import scala.collection.mutable.ListBuffer

val errors = new OxyErrors

if(errors.hasErrors){
throw new InvalidConfigException(s"InvalidCOnfigList")
}
}

// 2.

@throws(classOf[MalFormedFileException])
def createFileMetaData: FileMetaData {}
// this method is likely to threo the exception

*/
