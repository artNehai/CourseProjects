buildscript {
    extra.apply {
        set("lifecycle_version", "2.7.0")
    }
}

plugins {
    id("com.android.application") version "8.2.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.20" apply false
}