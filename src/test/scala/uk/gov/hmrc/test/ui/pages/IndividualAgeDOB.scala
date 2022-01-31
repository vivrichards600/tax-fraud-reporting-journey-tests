package uk.gov.hmrc.test.ui.pages

object IndividualAgeDOB extends BasePage {

  val ageDOB: String = " What is this individual's date of birth? - Report tax fraud or evasion - GOV.UK"

  def enterDOB = {
    onPage(ageDOB)
    findByID("value.day").sendKeys("25")
    findByID("value.month").sendKeys("04")
    findByID("value.year").sendKeys("1994")
    submitPage()
  }

}
