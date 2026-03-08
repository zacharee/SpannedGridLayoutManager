import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.application)
}

android {
    compileSdk = 36

    defaultConfig {
        namespace = "com.arasthel.spannedgridlayoutmanager.sample"
        applicationId = "com.arasthel.spannedgridlayoutmanager.sample"
        minSdk = 21
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    packaging {
        resources.excludes.add("META-INF/library_release.kotlin_module")
    }
}

kotlin {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_21)
    }
}

dependencies {
    implementation(fileTree("libs") { include("*.jar") })

    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.recyclerview)
    implementation(libs.kotlin.stdlib)

    implementation(project(":spannedgridlayoutmanager"))
}
