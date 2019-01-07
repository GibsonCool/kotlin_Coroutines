group = "com.doublex.coroutines"
version = "1.0-SNAPSHOT"

plugins {
    //添加支持Java开发的插件
    java
//    id("org.jetbrains.kotlin.jvm") version "1.3.11"
    //支持开发kotlin的插件
    kotlin("jvm") version "1.3.11"
}

// 仓库
repositories {
    mavenCentral()
    jcenter()
}

// 依赖
dependencies {
    //kotlin基础lib
    compile(kotlin("stdlib"))
    //配置协程依赖
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.1.0")
}