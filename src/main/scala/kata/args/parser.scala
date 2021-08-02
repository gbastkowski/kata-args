package kata.args

trait Arg

case object HelpArg extends Arg
case class FileArg(name: String) extends Arg
case class PortArg(port: Int) extends Arg

object parser {

    def parse(str: String*): Either[RuntimeException,Seq[Arg]] =
        parseArgs(str.toList)

    private def parseArgs(str: List[String]): Either[RuntimeException,Seq[Arg]] = {
        Left(new RuntimeException("Boom!"))
    }
}
