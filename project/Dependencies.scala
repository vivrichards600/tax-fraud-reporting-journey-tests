import sbt._

object Dependencies {

  val test = Seq(
    "uk.gov.hmrc"         %% "webdriver-factory-upgrade-spike" % "0.3.0"    % Test,
    "org.scalatest"       %% "scalatest"                       % "3.2.11"   % Test,
    "org.scalatestplus"   %% "selenium-4-1"                    % "3.2.11.0" % Test,
    "com.vladsch.flexmark" % "flexmark-all"                    % "0.62.2"   % Test,
    "org.pegdown"          % "pegdown"                         % "1.2.1"    % Test,
    "com.typesafe"         % "config"                          % "1.3.2"    % Test,
    "org.mongodb.scala"   %% "mongo-scala-driver"              % "4.4.0",
    "uk.gov.hmrc"         %% "domain"                          % "7.0.0-play-28"
  )

}
