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

package uk.gov.hmrc.test.ui.pages

import uk.gov.hmrc.test.ui.conf.TestConfiguration

object ReportTaxFraudHomePage extends BasePage {
  val url: String        = TestConfiguration.url("tax-fraud-reporting-frontend")
  val reportTaxFraudHome = "What you need to know - Report tax fraud or evasion - GOV.UK"

  def loadPage: this.type = {
    driver.navigate().to(url)
    onPage(reportTaxFraudHome)
    this
  }

  def startApplication: ActivityType.type = {
    submitPage()
    ActivityType
  }
}
