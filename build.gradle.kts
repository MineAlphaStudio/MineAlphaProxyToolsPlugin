plugins {
    java
}

group = "com.minealpha"
version = "1.0.0"

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
}

repositories { mavenCentral() }

dependencies {
    compileOnly(files("D:/MineAlphaProxy1/build/libs/MineAlphaProxy-1.0.1-ALPHA.jar"))
    compileOnly("net.kyori:adventure-api:4.24.0")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.release.set(17)
}

tasks.jar {
    archiveFileName.set("MineAlphaProxyTools-1.0.0.jar")
}