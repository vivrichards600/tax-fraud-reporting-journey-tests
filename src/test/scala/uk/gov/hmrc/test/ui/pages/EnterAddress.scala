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

import uk.gov.hmrc.test.ui.pages.Business.BusinessAddressLookup
import uk.gov.hmrc.test.ui.pages.Individual.IndividualAddressLookup
import uk.gov.hmrc.test.ui.pages.Individual.IndividualAddressLookup.findByID

object EnterAddress extends BasePage {

  val EnterAddress = "Enter address - Report tax fraud or evasion - GOV.UK"

  def individualEnterAddress: IndividualAddressLookup.type = {
    onPage(EnterAddress)
    findByID("countryCode").sendKeys("United Kingdom")
    findByID("pageHeading").click()
    findByID("continue").click()
    IndividualAddressLookup
  }

  def businessEnterAddress: BusinessAddressLookup.type = {
    onPage(EnterAddress)
    findByID("countryCode").sendKeys("United Kingdom")
    findByID("pageHeading").click()
    findByID("continue").click()
    BusinessAddressLookup
  }
}
