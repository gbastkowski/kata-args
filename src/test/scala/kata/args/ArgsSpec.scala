package kata.args

import org.scalatest._

class ArgsSpec extends FreeSpec with Matchers with EitherValues {

  "A command argument parser " - {
    "parses -h" in {
       parser.parse("-h").right.value shouldBe Seq(HelpArg)
    }

    "parsing an unsupported flag displays an error" in {
      parser.parse("-q").left.value shouldBe a [RuntimeException]
    }

    "parse -f filename" in {
      parser.parse("-f", "filename") shouldBe Right(Seq(FileArg("filename")))
    }

    "parses port and filename" in {
      parser.parse("-f", "asdf", "-p", "8080") shouldBe Right(Seq(FileArg("asdf"), PortArg(8080)))
    }
  }

}
