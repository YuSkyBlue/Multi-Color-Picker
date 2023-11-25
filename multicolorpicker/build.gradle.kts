plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    // to make opensource
    id ("maven-publish")
}
group = "com.github.yuskyblue"
version = "1.0.1"


afterEvaluate {
    publishing{
        publications {
            create<MavenPublication>("maven"){
                groupId = "com.github.yuskyblue"
                artifactId = "multicolorpicker"
                version = "1.0.1"
                from(components["release"])
            }
        }
    }
}
android {
    namespace = "com.bluesky.multicolorpicker"
    compileSdk = 34

    defaultConfig {
        minSdk = 21

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")

    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}