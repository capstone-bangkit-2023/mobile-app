<br/>
<p align="center">
  <a href="https://github.com/ShaanCoding/ReadME-Generator">
    <img src="https://raw.githubusercontent.com/capstone-bangkit-2023/mobile-app/main/app/src/main/res/mipmap-xxxhdpi/ic_launcher_round.png" alt="Logo" width="100" height="100">
  </a>

  <h3 align="center">Ayo Pintar</h3>

  <p align="center">
    Smart Quiz Platform
    <br/>
    <br/>
    <a href="https://github.com/ShaanCoding/ReadME-Generator"><strong>Download Ayo Pintar »</strong></a>
    <br/>
  </p>
</p>

![Contributors](https://img.shields.io/github/contributors/capstone-bangkit-2023/mobile-app?color=dark-green)
  ![License](https://img.shields.io/github/license/capstone-bangkit-2023/mobile-app) ![Downloads](https://img.shields.io/github/downloads/capstone-bangkit-2023/mobile-app/total)
 ![Stargazers](https://img.shields.io/github/stars/capstone-bangkit-2023/mobile-app?style=social)

## Table Of Contents

* [About the Project](#about-the-project)
* [Built With](#built-with)
* [Getting Started](#getting-started)
  * [Prerequisites](#prerequisites)
  * [Installation](#installation)
* [Usage](#usage)
* [Plugins](#plugins)
* [Depedency](#depedency)
* [License](#license)

## About The Project

![Screen Shot](https://lh3.googleusercontent.com/itIQJdohoiqaj0YyPTgX4H5UBjK7zG5AsAhrySFVqrD3kwugVrGZc53tDerwCW_YbCipPQjHHunci05RRU9e413hq5hgh3LCDW2ZgcZMeWprwGTogUXGhFw9A4Zom3q3PVFqLh0HEqU5k3SozjZmxgiPSc0_XASB5a8-fGU9LrF-KBhqdvHtg7X_AU6zI4RO9CsQq46EVbpKy1BXWS_w5vGVRL94GA-swseoRbT29q0kDf7COZQvpVm67NmYoducLRJ6t9oyhsG0XiB6WKYIdPI9EYO_UwXwef4lOyNoP3EVNk1SE4Mr4aspWLnGzmgBZ29zfBGF-BeEhMOk-1Kh13GjVMmjFSHBxcCY-AtBVD5VJZV7Wut4JhNgbz6pXAxKO0FGj0dCaCZcbW6wMwFG-io0cD9dL2jOd98Zcvc7TctOBTo9Ij5dF0OUuEQo9vQyWNWZqsEdVBInid3QA0NeYKdCQYgAv7q_7qDYfpGNc3ddR_mXn0fy5VdRZ8B5OvdgcFv5P_SApQj_RxUkXdDZZa0nbEd_Zl-peuCBqsMNxBFTTxQI-LwdnTPY3jVAV5WKKLEq_YbCCaRcwbe-LIFSrUd9qtDl-fVnvi_n9KkEiDSsa34AncbZvKvVsk7d5QpOoiL7yn-wVHDK4k0bhRToutEH0rPQytKSM76Cf3XBs9lkNQXwGNHY97GTlKCxYLdSJRiCdBqkXIliw46c3Hkk3ITg5ZEGVtsiHyuT7yYjwbwYimhdZZZFwjTxMwQa_Zpjy5U5qHHCpLJsI9MpJlOZ9UfZ2R634NNHSliGto0aWgYyWGZSpvvUcA1z6_a5gBnL4vGCeZx9hfh38y0vnyggy6jVExmAeeiJIshEhYzjJQzGZYhDo7z3p-GbkGfHRs4tpXKmbVNsrsNqPyZBuQE0DoidlONM3NV8m-9yeCVyN4ApVlqCukzn1C5f2gEdDA8AYbChPs9jloE1ZqXOXT5lh1tPekWWoxm9wcPFF502i5-IGI8JPI4EPA=w1470-h827-s-no?authuser=1)

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

To install and Ayo Pintar APP Recommendation app on your Android device, follow these steps:


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
