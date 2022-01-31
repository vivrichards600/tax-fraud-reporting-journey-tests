package uk.gov.hmrc.test.ui.pages

object IndividualAgeApprox extends BasePage {

  val approxAge: String = " What is the individual's approximate age? - Report tax fraud or evasion - GOV.UK"

  def enterApproxAge = {
    onPage(approxAge)
    findByID("value").sendKeys(random.nextInt(100).toString)
    submitPage()
  }
}
