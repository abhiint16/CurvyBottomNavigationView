# nLearn

This repo is a **nLearn application** that implements **MVVM architecture** using **Android Architectural Components from Google (JetPack)**,**AppCompat, CardView, RecyclerView an DesignLibrary**, **ViewModel**, **RxJava2**, **Dagger2**, **Retrofit2**, **Builder,View Holder & Repository Patterns** and **SOLID Principles**.

## The app has following packages:

* **datamanager**: It contains all the data accessing and manipulating components.
* **di**: Dependency providing classes using Dagger2.
* **view**: View classes along with their corresponding Activities, Fragments, Fragment Dialogs, Dialogs,ViewModels, adapters, View Holders and etc...
* **utils**: Utility classes.
* **analytics** : contains analytics initialization part
 
**Classes have been designed in such a way that it could be inherited and maximize the code reuse.**

## Application Architecture (MVVM)

![image](https://i.imgur.com/uAjXXtZ.png)

The main advatage of using MVVM, there is no two way dependency between ViewModel and Model unlike MVP. Here the view can observe the datachanges in the viewmodel as we are using LiveData which is lifecycle aware. The viewmodel to view communication is achieved through observer pattern (basically observing the state changes of the data in the viewmodel).

## Dependency Injection (di) 

![image](https://i.imgur.com/KE9Jy3L.png)

* **App Module** : Provides base dependencies of the application
   1. OkHttpClient : Client for Http calls
   2. NLearnApiService : List of authentication apis are used in the application
   3. NLearnApiService2 : List of ScheduleTest apis are used in the application
   4. NLearnPerformanceService : List of Performance apis are used in the application
   5. ScheduleProvider : They are responsible for performing operations of Observable on different threads
   6. Database Name 
   7. Database Version
   8. Shared Preference Name
   9. NetworkUtils : Provides the information that, mobile (or) tab connected to the interent or not
   10. NLearnDataManager : Provides the common Data Manager instance to access Database, Api and Shared Preference methods
   
* **Analytis Module** : It provides the Analytics Instance
* **AndroidInjectionModule** : We didn’t create this. It is an internal class in Dagger 2.10. Provides our activities and fragments with given module.
* **Activity Builder Module** : We map all activities and fragments used in the application.
* **Service Builder Module** : We map all service classes used in the application.
* **Broadcast Builder Module** : We map all broadcast receivers used in the application.
* **Worker Module** : We map all worker classes used in the application.

## Programming Practices Followed
* **[Android Architectural Components from Google (JetPack)](https://developer.android.com/jetpack)**
* **[AppCompat, CardView, RecyclerView an DesignLibrary](http://developer.android.com/intl/es/tools/support-library/index.html)**
* **Dagger 2 for Dependency Injection** : Dependency providing classes using Dagger2.
* **[RxJava2](https://github.com/ReactiveX/RxJava)**: a library for composing asynchronous and event-based programs by using observable sequences.
* **[Retrofit2 with Okhttp](http://square.github.io/retrofit/)** : For network calls
* **[Dynamic Data Binding](https://developer.android.com/topic/libraries/data-binding/)** : bind UI components in your layouts to data sources in your app using a declarative format rather than programmatically
* **MVVM, Builder, View Holder & Repository Patterns**
* **SOLID Principles**

## Android Architectural Components from Google (JetPack):
* **[ViewModel ](https://developer.android.com/topic/libraries/architecture/viewmodel)** :  Handle data effectively around lifecycle changes of Android components
* **[Data Binding](https://developer.android.com/topic/libraries/data-binding/)** :  Cut down on findViewByIds and make data observing / reactive UI elements and bind UI components in your layouts to data sources in your app using a declarative format rather than programmatically
* **[Lifecycle ](https://developer.android.com/topic/libraries/architecture/lifecycle)** :  Create lifecycle aware components
* **[LiveData](https://developer.android.com/topic/libraries/architecture/livedata)** :   A observable stream of data your Activities & Fragments can react to
* **[Navigation](https://developer.android.com/topic/libraries/architecture/navigation/)** :  Define in-app navigation stacks in a single, concise testable file
* **[Room](https://developer.android.com/topic/libraries/architecture/room)** :  An SQLlite ORM to handle database management in your apps
* **[Worker Manager](https://developer.android.com/topic/libraries/architecture/workmanager)** :  Run parameterized background tasks efficiently


## How to build ?

Open terminal and type the below command to generate debug build

``` ./gradlew assembleDebug ```

Open terminal and type the below command to generate release build 

``` ./gradlew assembleRelease ```

### License

   ```Copyright (C) 2017 NSPIRA CONSUMER BUSINESS DIVISION

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.```
