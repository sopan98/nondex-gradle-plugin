# nondex-gradle-plugin

This is the gradle version of the NonDex plugin which is written for maven projects
https://github.com/TestingResearchIllinois/NonDex

## Usage
Since this plugin has not been published to gradle plugin portal, it needs to be built from source in the local machine and then be imported into the target project.

### Steps:
1. Clone the repo, build it, and run `publishToMavenLocal` task to publish the plugin to local maven repository.
2. To import the plugin into target project, add these things to `settings.gradle` and `build.gradle` of the project:

*settings.gradle*: 
```
pluginManagement { 
    repositories { 
        mavenLocal()
        mavenCentral()
        gradlePluginPortal()
    }
}
```
*build.gradle*:
```
buildscript {
    repositories {
        mavenLocal()
    }
    dependencies {
        classpath 'edu.illinois:NondexGradlePlugin:1.1.2'
    }
}
```
After adding these snippets in the project, you will be able to run the plugin tasks. Currently, they are `nonDexHelp` and `nonDexTest`.