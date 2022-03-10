#!/bin/bash

. ./src/test/resources/BrowserConfig.properties

echo "BrowserStackLocal instances:"

if pidof BrowserStackLocal; then
        ./BrowserStackLocal $automatekey &
else
    echo "BrowserStack pid not found,  initialising BrowserStack"

        if [[ "$OSTYPE" == "linux-gnu" ]]; then
        if [ ! -e BrowserStackLocal ]; then
        wget https://www.browserstack.com/browserstack-local/BrowserStackLocal-linux-x64.zip
        unzip BrowserStackLocal-linux-x64.zip
        fi

       ./BrowserStackLocal $automatekey &

        elif [[ "$OSTYPE" == "darwin"* ]]; then
           echo "downloading mac osx browserstack driver..."
           if [ ! -e BrowserStackLocal ]; then
        wget  https://www.browserstack.com/browserstack-local/BrowserStackLocal-darwin-x64.zip
        unzip BrowserStackLocal-darwin-x64.zip
        fi

       ./BrowserStackLocal $automatekey &

        else
           echo "OS not supported"
        fi
  fi