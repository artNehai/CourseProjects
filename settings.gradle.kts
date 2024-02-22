pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "CourseProjects"
include(":artspace")
include(":tip_calculator")
include(":affirmations")
include(":courses")
include(":woof")
include(":superheroes")
include(":sports")
include(":racetracker")
include(":marsphotos")
