#!/usr/bin/env bash

set -e

display_usage(){
    echo "Usage: $0 <version>"
}

if ! [[ $# -eq 1 ]]
  then
    echo "Missing argument !"
    display_usage
    exit 1
fi
if [[ ( $1 == "--help") ||  $1 == "-h" ]]
  then
    display_usage
    exit 0
fi

new_version=$1

# README
echo "Set README version to : ${new_version}"
sed -i "s/\:project-version\:.*/:project-version: ${new_version}/" README.adoc
sed -i "s/\:project-version\:.*/:project-version: ${new_version}/" CHANGELOG.adoc
# POM
echo "Set Maven project version to : ${new_version}"
./mvnw -ntp -B -q versions:set -DnewVersion="${new_version}" versions:commit