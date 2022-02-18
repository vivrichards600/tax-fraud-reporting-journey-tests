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

import uk.gov.hmrc.test.ui.pages.ActivityApproximateValue.enterApproximateValue
import uk.gov.hmrc.test.ui.pages.Individual.DoesPersonOwnBusiness.enterYesIndividualHasBusiness
import uk.gov.hmrc.test.ui.pages.Individual.IndividualAgeApprox.enterApproxAge
import uk.gov.hmrc.test.ui.pages.PersonOrBusiness.{reportABusiness, reportAnIndividual}
import uk.gov.hmrc.test.ui.pages.ReportTaxFraudHomePage
import uk.gov.hmrc.test.ui.specs.tags.ZapTests

class ReportingValidActivitySpec extends BaseSpec {

  Feature("Taking information when a user is reporting a valid activity") {
    Scenario("User is reporting all types of information for an individual with a business", ZapTests) {
      Given("I start reporting a valid activity")
      ReportTaxFraudHomePage.loadPage.startApplication.reportingValidActivity

      When("I provide name, age(DOB), address, contact details and Nino of an individual")
      reportAnIndividual.selectAllFields.enterNameDetails.selectDOB.enterDOB.enterAddress.confirmAddress.enterIndividualContactDetails.enterIndividualNino.selectAConnection

      And("The Individual has a business I provide all types of information for")
      enterYesIndividualHasBusiness.selectAllFields.enterBusinessName.enterBusinessType.enterAddress.confirmAddress.enterBusinessContactDetails.enterBusinessReferenceNumbers.selectABusinessConnectionIndividual.selectActivitySourceOfInfo

      And("I provide all activity and personal details and submit")
      enterApproximateValue.selectDurationOfActivity.enterActivityDescription.selectHowManyPeopleKnow.selectYesProvideContactDetails

      Then("I will receive confirmation my report has been submitted")

    }

    Scenario("User anonymously reporting multiple individuals, with an estimated age", ZapTests) {
      Given("I start reporting a valid activity for an individual")
      ReportTaxFraudHomePage.loadPage.startApplication.reportingValidActivity.reportAnIndividual.individualAgeSelection.selectApprox

      When("I provide age,(approx) and connection with additional individual with manual address")
      enterApproxAge.selectAConnection.enterNoIndividualHasBusiness.enterYesAdditionalPeopleInvolved
//            .individualAddressSelection.selectManualAddress.manuallyEnterAddress.confirmAddressMultipleIndividuals.selectAConnection
      //      .enterIDontKnowIndividualHasBusiness.enterNoAdditionalPeopleInvolved

      And("I provide all activity and personal details and submit")
//      enterApproximateValue.selectDurationOfActivity.enterActivityDescription.selectHowManyPeopleKnow.selectNoProvideContactDetails

      Then("")
    }

    Scenario("User is reporting a business with all types of information", ZapTests) {
      Given("I start reporting a valid activity")
      ReportTaxFraudHomePage.loadPage.startApplication.reportingValidActivity

      When("I provide all information for a business with a manually entered address")
      reportABusiness.selectAllFields.enterBusinessName.enterBusinessType.selectManualAddress.manuallyEnterAddress.confirmAddress.enterBusinessContactDetails.enterBusinessReferenceNumbers.selectABusinessConnectionBusiness

      And("I provide all activity and personal details and submit")
      //      enterApproximateValue.selectDurationOfActivity.enterActivityDescription.selectHowManyPeopleKnow.selectYesProvideContactDetails

      Then("")
    }

  }

}
