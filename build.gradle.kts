buildscript {
    extra.apply {
        set("lifecycle_version", "2.7.0")
    }
}

plugins {
    id("com.android.application") version "8.3.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.20" apply false
    id("com.google.devtools.ksp") version "1.9.21-1.0.15" apply false
}