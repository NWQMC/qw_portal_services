# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](http://keepachangelog.com/en/1.0.0/)
and this project adheres to [Semantic Versioning](http://semver.org/spec/v2.0.0.html). (Patch version X.Y.0 is implied if not specified.)
## [Unrelease](https://github.com/NWQMC/qw_portal_services/compare/qw_portal_services-2.6.0...master)

## [2.6.0](https://github.com/NWQMC/qw_portal_services/compare/qw_portal_services-2.5.0...qw_portal_services-2.6.0) - 2020-07-13
### Added
-   Redirect from ../swagger to the correct url for the Swagger UI

### Changed
-   Artifactory Location
-   Multiple Deploys

## [2.5.0](https://github.com/NWQMC/qw_portal_services/compare/qw_portal_services-2.2.0...qw_portal_services-2.5.0)
### Changed
-   Updated Dockerfile to use the latest openjdk-debian-stretch 11 version rather than specific.
-   Updated SLD template to use lowercase property names
-   spring-boot-starter-parent to > 2.2.0-RELEASE
-   travis with integration tests

## [2.2.0](https://github.com/NWQMC/qw_portal_services/compare/qw_portal_services-1.4...qw_portal_services-2.2.0)

### Added
-   CHANGELOG.md
-   README.md
-   Converted project to Spring Boot 2.
-   OAuth2 Security for Internal App.
-   Dockerized project in preparation for building a docker image suitable for deployment.
-   pipeline.yml and two Jenkinsfiles

### Changed
-   Changed the pom to create a jar.
-   Updated Jenkinsfiles to use new pipeline library and added new variables to pipeline.yml
-   Updated Dockerfile to use new openJDK image, and changed RUN command to comply with best practices
-   Updated Jenkins build and deploy pipeline to pull configuration from GitLab via new pipeline library

