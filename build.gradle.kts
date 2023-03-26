buildscript {
    extra["androidCompileSdk"] = 32 // Allows newer APIs to be used
    extra["androidTargetSdk"] = 31 // Opts the app in to new runtime behavior
    extra["androidMinSdk"] = 26 // Determines which devices the app can be installed on
}// Top-level build file where you can add configuration options common to all sub-projects/modules.

plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.kotlin) apply false
    alias(libs.plugins.hilt) apply false
    alias(libs.plugins.apollo) apply false
}

