#!/bin/bash -e
# add browserstack details here:
. ./src/test/resources/BrowserConfig.properties

# Scalafmt checks have been separated from the test command to avoid OutOfMemoryError in Jenkins
sbt scalafmtCheckAll scalafmtSbtCheck

#more info about capabilities here:
#https://www.browserstack.com/automate/capabilities
#keep browser versions complaint with this:
#https://www.gov.uk/service-manual/technology/designing-for-different-browsers-and-devices

#windows
sbt -Dbrowser=browserstack -Denvironment=local -Dbrowserstack.username=${username} -Dbrowserstack.key=${automatekey} -Dbrowserstack.browser_version="latest" -Dbrowserstack.browser="Chrome" -Dbrowserstack.os="Windows" -Dbrowserstack.os_version="11" "testOnly uk.gov.hmrc.test.ui.specs.*"
sbt -Dbrowser=browserstack -Denvironment=local -Dbrowserstack.username=${username} -Dbrowserstack.key=${automatekey} -Dbrowserstack.browser_version="latest" -Dbrowserstack.browser="Edge" -Dbrowserstack.os="Windows" -Dbrowserstack.os_version="11" "testOnly uk.gov.hmrc.test.ui.specs.*"
sbt -Dbrowser=browserstack -Denvironment=local -Dbrowserstack.username=${username} -Dbrowserstack.key=${automatekey} -Dbrowserstack.browser_version="latest" -Dbrowserstack.browser="Firefox" -Dbrowserstack.os="Windows" -Dbrowserstack.os_version="11" "testOnly uk.gov.hmrc.test.ui.specs.*"

#needs to be reviewed manually
#sbt -Dbrowser=browserstack -Dlanguage=english -Denvironment=local -Dbrowserstack.username=${username} -Dbrowserstack.key=${automatekey} -Dbrowserstack.browser_version="11" -Dbrowserstack.browser="IE" -Dbrowserstack.os="Windows" -Dbrowserstack.os_version="10" "testOnly uk.gov.hmrc.test.ui.specs.*"

#mac
#needs to be reviewed manually
#sbt -Dbrowser=browserstack -Dlanguage=english -Denvironment=local -Dbrowserstack.username=${username} -Dbrowserstack.key=${automatekey} -Dbrowserstack.local="true" -Dbrowserstack.browser="Safari" -Dbrowserstack.os="OS X" -Dbrowserstack.os_version="Catalina" 'testOnly uk.gov.hmrc.test.ui.specs.*'
sbt -Dbrowser=browserstack -Dlanguage=english -Denvironment=local -Dbrowserstack.username=${username} -Dbrowserstack.key=${automatekey} -Dbrowserstack.browser_version="latest" -Dbrowserstack.browser="Firefox" -Dbrowserstack.os="OS X" -Dbrowserstack.os_version="Catalina" 'testOnly uk.gov.hmrc.test.ui.specs.*'
sbt -Dbrowser=browserstack -Dlanguage=english -Denvironment=local -Dbrowserstack.username=${username} -Dbrowserstack.key=${automatekey} -Dbrowserstack.browser_version="latest" -Dbrowserstack.browser="Chrome" -Dbrowserstack.os="OS X" -Dbrowserstack.os_version="Catalina" 'testOnly uk.gov.hmrc.test.ui.specs.*'

#iOS
##needs to be reviewed manually
sbt -Dbrowser=browserstack -Denvironment=local -Dbrowserstack.username=${username} -Dbrowserstack.key=${automatekey} -Dbrowserstack.real_mobile="true" -Dbrowserstack.device="iPhone 12" -Dbrowserstack.os_version="14" -Dbrowserstack.local=true "testOnly uk.gov.hmrc.test.ui.specs.*"

#Android
sbt -Dbrowser=browserstack -Denvironment=local -Dbrowserstack.username=${username} -Dbrowserstack.key=${automatekey}  -Dbrowserstack.real_mobile="true" -Dbrowserstack.device="Samsung Galaxy S20" -Dbrowserstack.os_version="10.0" -Dbrowserstack.browser="samsung" "testOnly uk.gov.hmrc.test.ui.specs.*"