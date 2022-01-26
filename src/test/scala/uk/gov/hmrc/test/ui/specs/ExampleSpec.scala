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

import uk.gov.hmrc.test.ui.pages.Result.{result, useSetVATFlatRate, useUniqueVATFlatRate}
import uk.gov.hmrc.test.ui.pages._
import uk.gov.hmrc.test.ui.specs.tags.ZapTests

class ExampleSpec extends BaseSpec {

  Feature("Examples") {

    Scenario("Referring user when reporting other activity") {
      Given("I am on the Using this service")
      ReportTaxFraudHomePage.loadPage

      When("I attempt to report an activity not handled by this service")
      ReportTaxFraudHomePage.startApplication
        .reportingOther

      Then("I will be shown the do not use this service page")
      result should be("You should not use this service to report this activity")
    }
    //
    //    Scenario("User is a limited cost business that pays quarterly and should use the 16.5% flat rate") {
    //      Given("I am on the Check your VAT flat rate service")
    //      ReportTaxFraudHomePage.loadPage
    //
    //      When("I submit my VAT information for goods under £250 for the quarter")
    //      provideVATPeriod("Quarterly")
    //        .provideTurnoverAmount("1000")
    //        .provideCostOfGoodsAmount("249")
    //        .submitVATInformation
    //
    //      Then("I will be asked to use the 16.5% VAT flat rate")
    //      result should be(useSetVATFlatRate)
    //    }
    //
    //    Scenario("User is not a limited cost business that pays quarterly and should use the VAT flat rate") {
    //      Given("I am on the Check your VAT flat rate service")
    //      ReportTaxFraudHomePage.loadPage
    //
    //      When("I submit my VAT information for goods for £250 for the quarter")
    //      provideVATPeriod("Quarterly")
    //        .provideTurnoverAmount("1000")
    //        .provideCostOfGoodsAmount("250")
    //        .submitVATInformation
    //
    //      Then("I will be asked to use the VAT flat rate")
    //      result should be(useUniqueVATFlatRate)
    //    }
  }
}
