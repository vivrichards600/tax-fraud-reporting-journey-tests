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

object IndividualInformationCheck extends BasePage {

  val individualInformationCheck = " What do you know about the individual? - Report tax fraud or evasion - GOV.UK"

  def selectAllFields: IndividualName.type = {
    onPage(individualInformationCheck)
    //TODO request ID be changed to more meaningful
    //Name
    findByID("value_0").click()
    //Age
    findByID("value_1").click()
    //Address
    findByID("value_2").click()
    //Contact Details
    findByID("value_3").click()
    //National Insurance Number
    findByID("value_4").click()
    submitPage()
    IndividualName
  }

  def individualAgeSelection: IndividualAgeFormat.type = {
    onPage(individualInformationCheck)
    //TODO request ID be changed to more meaningful
    findByID("value_1").click()
    submitPage()
    IndividualAgeFormat
  }
}
