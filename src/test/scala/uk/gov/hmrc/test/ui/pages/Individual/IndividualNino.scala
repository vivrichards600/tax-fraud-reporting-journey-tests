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

package uk.gov.hmrc.test.ui.pages.Individual

import uk.gov.hmrc.domain.{Generator, Nino}
import uk.gov.hmrc.test.ui.pages.BasePage

object IndividualNino extends BasePage {

  val individualNino = "What is the individual's National Insurance Number? - Report tax fraud or evasion - GOV.UK"

  private val ninoGenerator = new Generator(random)

  def generateNino(): Nino = ninoGenerator.nextNino

  def enterIndividualNino: SelectConnectionIndividual.type = {
    onPage(individualNino)
    //TODO request ID be changed to more meaningful
    findByID("value").sendKeys(generateNino().toString())
    submitPage()
    SelectConnectionIndividual
  }

}
