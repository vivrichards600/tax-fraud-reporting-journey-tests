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

import org.scalatest.prop.TableDrivenPropertyChecks
import uk.gov.hmrc.test.ui.pages.ReportTaxFraudHomePage._
import uk.gov.hmrc.test.ui.pages._
import uk.gov.hmrc.test.ui.specs.tags.{Solo, ZapTests}

class DoNotUseThisServiceSpec extends BaseSpec with TableDrivenPropertyChecks {
  Feature("Referring user when reporting activity not handled by this service") {
    val reportedActivity =
      Table(
        ("otherActivity", "referrerText"),
        ("Activity related to drugs", "activity-related-to-drugs"),
        ("Smuggling", "smuggling"),
        ("Benefit fraud (not including child benefit or tax credits)", "benefit-fraud-and-universal-credit"),
        ("Universal credit fraud", "benefit-fraud-and-universal-credit"),
        ("Human trafficking", "human-trafficking"),
        ("Border crime", "immigration-border-crime")
      )
    forAll(reportedActivity) { (otherActivity: String, referrerText: String) =>
      Scenario(s"Referring user when reporting $otherActivity", ZapTests) {
        Given("I am on the Using this service")
        ReportTaxFraudHomePage.loadPage

        When(s"I report $otherActivity")
        startApplication
          .reportingOther(s"$otherActivity")

        Then("I will be shown the do not use this service page")
        DoNotUseThisService.result should be(s"$referrerText")
      }
    }
  }
}
