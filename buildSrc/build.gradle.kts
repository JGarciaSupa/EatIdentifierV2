plugins{
    `kotlin-dsl`
}

repositories {
    // Repositorio Maven Central
    mavenCentral()
    mavenLocal()
    google()
    jcenter()
    // Repositorio de SAP con protocolo inseguro permitido
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:2.0.21")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.9.24")
//    implementation("com.sap.cloud.android:odata-android-gradle-plugin:3.3.1")

}