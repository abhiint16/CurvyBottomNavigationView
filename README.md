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
* 
## view has following packages

* **base**: Base classes for the Activities, Fragments and Fragment Dialogs
   1. ```BaseActivity<Binding extends ViewDataBinding, VM extends BaseViewModel>``` : Base for all the activities in the application. It requires ```Binding which is a Data Binding layout of the activity``` and ```VM which is a ViewModel of the activity```. It holds below common attributes and dependecies
      * NetworkUtils : Provides the information that, mobile (or) tab connected to the interent or not
      * AnalyticsTracker : Analytics instance to send the analytics
      * ProgressDialog : To display common dialog through out the application
      * ViewModel : Activities ViewModel
      * Logout Dialog : To display common dialog
      * Data Binding : binding UI components in layouts to data sources in app using a declarative format rather than programmatically
      * KeyPad Utils : To get the information that, whether keypad is open or not
      
  2. ```BaseFragment<VM extends BaseViewModel,Binding extends ViewDataBinding>``` : Base for all the fragment in the application. It requires ```Binding which is a Data Binding layout of the activity``` and ```VM which is a ViewModel of the activity```. It holds below common attributes and dependecies
      * NetworkUtils : Provides the information that, mobile (or) tab connected to the interent or not
      * AnalyticsTracker : Analytics instance to send the analytics
      * ProgressDialog : To display common dialog through out the application
      * ViewModel : Activities ViewModel
      * Logout Dialog : To display common dialog
      * Data Binding : binding UI components in layouts to data sources in app using a declarative format rather than programmatically
      * KeyPad Utils : To get the information that, whether keypad is open or not
      
  3. ```BaseDialogFragment<VM extends BaseViewModel,Binding extends ViewDataBinding>``` : Base for all the fragment dialogs in the application. It requires ```Binding which is a Data Binding layout of the activity``` and ```VM which is a ViewModel of the activity```. It holds below common attributes and dependecies
      * NetworkUtils : Provides the information that, mobile (or) tab connected to the interent or not
      * AnalyticsTracker : Analytics instance to send the analytics
      * ProgressDialog : To display common dialog through out the application
      * ViewModel : Activities ViewModel
      * Logout Dialog : To display common dialog
      * Data Binding : binding UI components in layouts to data sources in app using a declarative format rather than programmatically
      * KeyPad Utils : To get the information that, whether keypad is open or not
      
  4. ```BaseAdapter<ViewHolder, Item>```: Base for all the adapters used in the application and holds below common attributes and dependecies
      * listItems : List of items are present in the recycler view ```listItems```
      * **Add Initial List** : Adding the list. This method should call to add the list.
      
         ```
         public void addInitialData(List<Item> data) {

           if (data == null) {
               return;
           }

           listItems.clear();
           listItems.addAll(new ArrayList<>(data));
           notifyDataSetChanged();
         }
        ```
       * **Add New List** : This method will be used when recycler view has pagination feature
      
        ```
           public void addNewData(List<Item> newData) {
              listItems.addAll(new ArrayList<>(newData));
              notifyDataSetChanged();
            }
        ```
        
   5. ```BaseViewHolder<Binding extends ViewDataBinding, Item>```: Base for all the ViewHolders used in the application. It requires ```DataBinding and Item``` values. It holds below common attributes and dependecies
      * ```Binding``` : DataBinding of the item layout 
      
   6. ```BaseViewModel```: Base for all the ```viewModles``` used in the application. It works according to life cycle of ``` Activity, Fragment and Dialog Fragments```.
            It needs ```NLearnDataManager```,```ScheduleProvider```,```NetworkUtils``` as arguments in the constructor. These arguments we get through **Dependency Injection** 
   
      * ```refreshToken()``` : Refreshing the token when expired
      
         ```
         @NonNull final String refreshToken = dataManager.getRefreshToken();
         RefreshTokenRequest refreshTokenRequest = new RefreshTokenRequest();
         
         refreshTokenRequest.setRefreshToken(refreshToken);
         dataManager.refreshToken(refreshTokenRequest)
        ```
       * ```logoutUserApiCall()``` : Logout api call and when it success, Logouts the user from the application. Uses ``LiveData`` and it gets called by the 
       ```BaseActivity. viewModel.logoutUser()``` method
      
        ```
           dataManager.logOutUser()
        ``` 
       * ```showLoading()``` : Displays loading bar (Uses ``LiveData`` and it gets called by the ```BaseActivity.viewModel.getProgressDialogStatus()``` method)
       * ```hideLoading()``` : Displays loading bar (Uses ``LiveData`` and it gets called by the ```BaseActivity.viewModel.getProgressDialogStatus()``` method)
      
      
      
* **appupdate**: 
* **custom**: 
* **home**: 
* **registration** : 

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
