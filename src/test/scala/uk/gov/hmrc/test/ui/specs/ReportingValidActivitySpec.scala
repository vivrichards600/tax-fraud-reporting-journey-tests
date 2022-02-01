/*
 * Copyright 2022 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.test.ui.specs

import uk.gov.hmrc.test.ui.pages.IndividualAgeApprox.enterApproxAge
import uk.gov.hmrc.test.ui.pages.PersonOrBusiness.reportAnIndividual
import uk.gov.hmrc.test.ui.pages.ReportTaxFraudHomePage

class ReportingValidActivitySpec extends BaseSpec {

  Feature("Taking information when a user is reporting a valid activity") {

    Scenario("User is reporting all types of information for an individual with a business") {
      Given("I start reporting a valid activity")
      ReportTaxFraudHomePage.loadPage.startApplication.reportingValidActivity

      When("I provide name, age(DOB), address, contact details and Nino of an individual")
      reportAnIndividual.selectAllFields.enterNameDetails.selectDOB
//        .enterDOB

      And("The Individual has a business I provide all types of information for")

      And("I provide all activity and personal details and submit")

      Then("I will receive confirmation my report has been submitted")
    }

    Scenario("User anonymously reporting multiple individuals, with an estimated age and other connection") {
      Given("I start reporting a valid activity for an individual")
      ReportTaxFraudHomePage.loadPage.startApplication.reportingValidActivity.reportAnIndividual.individualAgeSelection.selectApprox

      When("I provide age,(approx)")
      enterApproxAge

      Then("")
    }

//    Scenario("User is reporting a business with all types of information") {
//      Given("")
//      When("")
//      Then("")
//    }
//
  }

}
