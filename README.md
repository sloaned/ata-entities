# Catalyst Application Module Platform

The CAMP is a collection of micorservice applications which serve as a core platform for internal Catalyst web apps. 

## camp-oauth2-ldap

This is a centralized OAuth2 provider integrated with LDAP

## Build Instructions

$ mvn package docker:build
$ docker push catalystdevlabs/camp-oauth2-ldap [Optional]