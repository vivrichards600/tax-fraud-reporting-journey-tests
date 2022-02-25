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

object YourContactDetails extends BasePage {

  val whatAreYourDetails = "What are your details? - Report tax fraud or evasion - GOV.UK"

  def enterContactDetails: AnySupportingInformation.type = {
    onPage(whatAreYourDetails)
    findByID("firstName").sendKeys(random.nextString(5))
    findByID("lastName").sendKeys(random.nextString(5))
    findByID("tel").sendKeys("1234567890")
    findByID("memorableWord").sendKeys(random.nextString(5))
    submitPage()
    AnySupportingInformation
  }
}
