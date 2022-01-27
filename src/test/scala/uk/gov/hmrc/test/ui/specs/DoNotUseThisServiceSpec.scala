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

import uk.gov.hmrc.test.ui.pages.ReportTaxFraudHomePage._
import uk.gov.hmrc.test.ui.pages.Result.result
import uk.gov.hmrc.test.ui.pages._
import uk.gov.hmrc.test.ui.specs.tags.{Solo, ZapTests}

class DoNotUseThisServiceSpec extends BaseSpec {

  Feature("Referring user when reporting activity not handled by this service") {

    Scenario("Referring user when reporting Activity related to drugs", Solo) {
      Given("I am on the Using this service")
      ReportTaxFraudHomePage.loadPage

      When("I report Activity related to drugs")
      startApplication
        .reportingOther("Activity related to drugs")

      Then("I will be shown the do not use this service page")
      DoNotUseThisService.result should be("")
    }

    Scenario("Referring user when reporting Smuggling") {
      Given("I am on the Using this service")
      ReportTaxFraudHomePage.loadPage

      When("I report Smuggling")
      startApplication
        .reportingOther("Smuggling")

      Then("I will be shown the do not use this service page")
      result should be("")
    }

    Scenario("Referring user when reporting Benefit fraud (not including child benefit or tax credits)") {
      Given("I am on the Using this service")
      ReportTaxFraudHomePage.loadPage

      When("I report Benefit fraud (not including child benefit or tax credits)")
      startApplication
        .reportingOther("Benefit fraud (not including child benefit or tax credits)")

      Then("I will be shown the do not use this service page")
      result should be("")
    }
    Scenario("Referring user when reporting Universal credit fraud") {
      Given("I am on the Using this service")
      ReportTaxFraudHomePage.loadPage

      When("I report Universal credit fraud)")
      startApplication
        .reportingOther("Universal credit fraud")

      Then("I will be shown the do not use this service page")
      result should be("")
    }

    Scenario("Referring user when reporting Human trafficking") {
      Given("I am on the Using this service")
      ReportTaxFraudHomePage.loadPage

      When("I report Human trafficking")
      startApplication
        .reportingOther("Human trafficking")

      Then("I will be shown the do not use this service page")
      result should be("")
    }

    Scenario("Referring user when reporting Illegal immigration") {
      Given("I am on the Using this service")
      ReportTaxFraudHomePage.loadPage

      When("I report Illegal immigration")
      startApplication
        .reportingOther("Illegal immigration")

      Then("I will be shown the do not use this service page")
      result should be("")
    }

    Scenario("Referring user when reporting Border crime") {
      Given("I am on the Using this service")
      ReportTaxFraudHomePage.loadPage

      When("I report Border crime")
      startApplication
        .reportingOther("Border crime")

      Then("I will be shown the do not use this service page")
      result should be("")
    }
  }
}
