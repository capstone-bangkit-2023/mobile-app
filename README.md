<br/>
<p align="center">
  <a href="#">
    <img src="https://raw.githubusercontent.com/capstone-bangkit-2023/mobile-app/main/app/src/main/res/mipmap-xxxhdpi/ic_launcher_round.png" alt="Logo" width="100" height="100">
  </a>

  <h3 align="center">Ayo Pintar</h3>
</p>

  <p align="center">
    Smart Quiz Platform
    <br/>
    <br/>
    <a href="#"><strong>Download Ayo Pintar »</strong></a>
    <br/>
  </p>

![Contributors](https://img.shields.io/github/contributors/capstone-bangkit-2023/mobile-app?color=dark-green)
  ![License](https://img.shields.io/github/license/capstone-bangkit-2023/mobile-app) ![Downloads](https://img.shields.io/github/downloads/capstone-bangkit-2023/mobile-app/total)
 ![Stargazers](https://img.shields.io/github/stars/capstone-bangkit-2023/mobile-app?style=social)

## Table Of Contents

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#plugins">Roadmap</a></li>
    <li><a href="#depedency">Contributing</a></li>
    <li><a href="#license">License</a></li>
  </ol>
</details>

## About The Project

![Screen Shot](https://photos.app.goo.gl/21jAsGho2dogdFW4A)

Ayo Pintar is a solution from us to increase learning efficiency. Ayo Pintar comes with several features such as
- AI powered answer check
- User potential profession prediction
- Get quiz scores in no time


## Built With

- Programming Language: Kotlin
- Android SDK: Android Studio
- API: Google Cloud API
- UI/UX: XML, Material Design


## Getting Started

To install and use Ayo Pintar App on your Android device, follow these steps:


### Prerequisites
- Make sure you are you have internet connection
- Make sure you are using a mobile device with minimum Android 7.0 (API level 24)


### Installation

you can download the app from https://github.com/capstone-bangkit-2023/mobile-app.git
- install the application on your device
### Or you can install manually using Android Studio

Clone the repository: 
```
git clone https://github.com/capstone-bangkit-2023/mobile-app.git
```

- Navigate to the directory where you cloned or extracted the source code and select the project's root folder. Click "OK" to open the project.

- Android Studio will take a moment to set up the project and build the necessary files.

- Connect your Android device to your computer using a USB cable. Make sure that USB debugging is enabled on your device.

- In Android Studio, click on the "Run" button (green triangle) or select "Run" from the toolbar.

- Select your connected device from the list of available devices, and Android Studio will install and launch the app on your device.

## Features
- Register/Login
- Dashboard
- Profile
- Quiz
- Recommendation profession (not implemented yet)
- Score History (not implemented yet)

## Usage

- Sign up for a new account or log in with your existing credentials.

- Select a course and start answering the questions.

- Review your quiz results and explore the recommended professions.

## Plugins
```gradle
plugins {
    id 'com.android.application'
    id 'org.jetbrains.kotlin.android'
    id 'androidx.navigation.safeargs'
    id 'kotlin-parcelize'
}
```
## Depedency
```gradle
dependencies {

    //Default Library
    implementation 'androidx.core:core-ktx:1.10.1'
    implementation 'androidx.appcompat:appcompat:1.6.1'
    implementation 'com.google.android.material:material:1.9.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.4'

    //API Library
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation "com.squareup.retrofit2:converter-gson:2.9.0"
    implementation "com.squareup.okhttp3:logging-interceptor:4.9.3"

    //Datastore & Viewmodel
    implementation "androidx.datastore:datastore-preferences:1.0.0"
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1"
    implementation "androidx.lifecycle:lifecycle-livedata-ktx:2.6.1"
    implementation "androidx.activity:activity-ktx:1.7.2"

    // UI Library
    implementation 'com.github.bumptech.glide:glide:4.15.1'


    //SplashScreen Library
    implementation 'androidx.core:core-splashscreen:1.0.1'

    //Navigation Library
    implementation 'androidx.navigation:navigation-fragment-ktx:2.6.0'
    implementation 'androidx.navigation:navigation-ui-ktx:2.6.0'

    //Testing Library
    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.5'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'


}
```

## License

Distributed under the MIT License. See [LICENSE](https://github.com/capstone-bangkit-2023/mobile-app/blob/main/LICENSE) for more information.

## 
