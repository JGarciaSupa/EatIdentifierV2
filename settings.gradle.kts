pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { setUrl("https://jitpack.io") }
        maven { setUrl("https://maven.fabric.io/public") }
        maven { setUrl("https://repo.eclipse.org/content/repositories/paho-snapshots/") }   // added

        flatDir {
            dirs ("libs")
        }
    }
}

rootProject.name = "AppBusesVIP"
include(":app")
