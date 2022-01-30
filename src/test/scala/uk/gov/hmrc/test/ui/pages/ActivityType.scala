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

import org.openqa.selenium.support.ui.{ExpectedConditions, FluentWait}
import org.openqa.selenium.{By, JavascriptExecutor}
import uk.gov.hmrc.test.ui.pages.DoNotUseThisService.doNotUseThisService
import uk.gov.hmrc.test.ui.utils.Lists._

import scala.util.Random

object ActivityType extends BasePage {

  val activityType               = "What type of HMRC activity are you reporting? - Report tax fraud or evasion - GOV.UK"
  val random                     = new Random
  val reportableActivity: String = validActivityTypeList(random.nextInt(validActivityTypeList.length))
  val inputBox                   = "value"

  def reportingFraud: PersonOrBusiness.type = {
    onPage(activityType)
    driver.findElement(By.id(inputBox)).sendKeys(reportableActivity)
    driver.findElement(By.id("value__option--0")).click()
    submitPage()
    PersonOrBusiness
  }

  def reportingOther(activity: String): DoNotUseThisService.type = {
    onPage(activityType)
    driver.findElement(By.id(inputBox)).clear()
    driver.findElement(By.id(inputBox)).sendKeys(activity)
    driver.findElement(By.id("value__option--0")).click()
    submitPage()
    DoNotUseThisService
  }

}
