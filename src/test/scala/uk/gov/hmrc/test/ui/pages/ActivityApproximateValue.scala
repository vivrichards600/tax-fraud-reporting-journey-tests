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

object ActivityApproximateValue extends BasePage {

  val activityApproximateValue: String =
    "What is the approximate total value of the activity? - Report tax fraud or evasion - GOV.UK"

  def enterApproximateValue: WhenActivityStart.type = {
    onPage(activityApproximateValue)
    findByID("value").sendKeys(random.nextInt(2111111118).toString)
    submitPage()
    WhenActivityStart
  }
}
