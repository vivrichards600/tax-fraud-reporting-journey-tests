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

import uk.gov.hmrc.test.ui.utils.Lists._

object ActivityType extends BasePage {

  val activityType               = "What type of HMRC activity are you reporting? - Report tax fraud or evasion - GOV.UK"
  val reportableActivity: String = validActivityTypeList(random.nextInt(validActivityTypeList.length))
  val inputBox                   = "value"

  def reportingValidActivity: PersonOrBusiness.type = {
    onPage(activityType)
    findByID(inputBox).sendKeys(reportableActivity)
    findByID("value__option--0").click()
    submitPage()
    PersonOrBusiness
  }

  def reportingOther(activity: String): DoNotUseThisService.type = {
    onPage(activityType)
    findByID(inputBox).clear()
    findByID(inputBox).sendKeys(activity)
    findByID("value__option--0").click()
    submitPage()
    DoNotUseThisService
  }

}
