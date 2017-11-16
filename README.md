Android MVP
===========

Android MVP is a base library to work with [Model-View-Presenter](http://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93presenter) pattern. Works on Android 4.1 (API level 16) and upwards.

[![Release](https://img.shields.io/github/tag/raxden/android-mvp.svg?label=Download)](https://jitpack.io/#raxden/android-mvp/)
[![API](https://img.shields.io/badge/API-16%2B-green.svg?style=flat)](https://android-arsenal.com/api?level=16)


A lot of Android applications use only the Model-View architecture. Using this approach, we can quickly develop new features. We use Activity or Fragment as an object that implements logic, handles UI, and controls the flow between data objects and UI. One typical scenario for creating a new screen entails creating a new Activity class, adding a bunch of views, some AsyncTasks for background operations, tracking the state of Activity… before realizing that we’ve ended up with complex code where everything is connected to everything.

<p align="center">
<img src="https://raw.githubusercontent.com/raxden/AndroidMVP/master/mvc_mvp.png"/>
</p>

The Model-View-Presenter (MVP) architecture comprises:

#### The presenter
The presenter is responsible to act as the middle man between view and model. It retrieves data from the model and returns it formatted to the view. But unlike the typical MVC, it also decides what happens when you interact with the view.
#### The View
The view, usually implemented by an Activity (it may be a Fragment, a View… depending on how the app is structured), will contain a reference to the presenter. The only thing that the view will do is calling a method from the presenter every time there is an interface action (a button click for example).
#### The model
In an application with a good layered architecture, this model would only be the gateway to the domain layer or business logic. If we were using the Uncle Bob clean architecture , the model would probably be an interactor that implements a use case.

Everything is easier to understand when you have examples. So here’s one on how to develop apps using the AndroidMVP.

https://github.com/raxden/AndroidMVP/tree/master/sample

## Presenter lifecycle

The presenter lifecycle is described below.

<p align="center">
<img src="https://raw.githubusercontent.com/raxden/AndroidMVP/master/mvp_lifecycle.png"/>
</p>

## Usage

### Best aproach: Fragment like view

<img align="right" src="https://github.com/raxden/AndroidMVP/blob/master/mvp_fragment.png?raw=true" />

**1. Create your view contract**

Every View interface extends an empty interface, in this case IView (no methods declared). ILoginFragmentView should be able to show progress bar as the user are fetched, display the user data, or an error message when fetching fails.

 ```java
public interface ILoginFragmentView extends IView {
    void showLoading(String loadingMessage);
    void hideLoading();
    void showError(String title, String message);
    void userLogged();
}
```

**2. Create your presenter contract.**

ILoginFragmentPresnter 

 ```java
public interface ILoginFragmentPresenter {
    void login(String email, String password);
}
```

**3. Create your presenter implementation, it must extends from Presenter to extend the AndroidMVP advantages and implements your contract presenter.**

 ```java
public class LoginFragmentPresenter extends Presenter<ILoginFragmentView> implements ILoginFragmentPresenter {

    public YourFragmentPresenter(Context context) {
        super(context);
    }

    @Override
    public void login(String email, String password) {
        if (validateCredentials(email, password)) {
            retrieveUserData(email, password);
        }
    }

    private void retrieveUserData(final String email, final String password) {
        mView.showLoading("loading...");

        { // this code simulate asynctask usecase...
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    if (mView != null) {
                        mView.userLogged();
                        mView.hideLoading();
                    }
                }
            }, 2000);
        }
    }
}
```

**4. Create your view implementation, it must extends from MVPFragment and implements your contract view.**

 ```java
public class LoginFragment extends MVPFragment<LoginFragmentPresenter> implements ILoginFragmentView {

    @Override
    public YourFragmentPresenter initializePresenter(Context context) {
        return new YourFragmentPresenter(context);
    }

    @Override
    public void userLogged() {
        // user logged!
    }

    @Override
    public void showLoading(String loadingMessage) {
        // show loading progress
    }

    @Override
    public void hideLoading() {
        // hide loading progress
    }

    @Override
    public void showError(String title, String message) {
        // show error message
    }
}
```

Why use a Fragment as a view and not an Activity? If we use a fragment like view, we can separate the view of the controller. In this way the activity will only contain the logic of the controller and the fragment the logic of the view. Then you will see that code is much easier to understand, scalable, and that its degree of complexity does not rise in step with the expansion of the application itself.

### In order to use the library, there are 3 options:

**1. Gradle dependency**

 - 	Add the following to your `build.gradle`:
 ```gradle
repositories {
	    maven { url "https://jitpack.io" }
}

dependencies {
	    compile 'com.github.raxden:AndroidMVP:3.0.15@aar'
}
```

**2. Maven**
- Add the following to your `pom.xml`:
 ```xml
<repository>
       	<id>jitpack.io</id>
	    <url>https://jitpack.io</url>
</repository>

<dependency>
	    <groupId>com.github.raxden</groupId>
	    <artifactId>AndroidMVP</artifactId>
	    <version>3.0.15</version>
</dependency>
```

**3. clone whole repository**
 - Open your **commandline-input** and navigate to your desired destination folder (where you want to put the library)
 - Use the command `git clone https://github.com/raxden/AndroidMVP.git` to download the full AndroidMVP repository to your computer (this includes the folder of the library project as well as the example project)

### Documentation

For a **detailed documentation**, please have a look at the [**Wiki**](https://github.com/raxden/AndroidMVP/wiki) or the [**Javadocs**](https://jitpack.io/com/github/raxden/AndroidMVP/3.0.15/javadoc/).

## LICENSE

    Copyright 2015 Ángel Gómez

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.