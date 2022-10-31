# MavenArtifact-AndroidStudio

# Create maven artifact && With android studio

Happy reading time:

## Tools that used for creating example projects:

1- IntelliJ with java 11 (IntelliJ IDEA 2022.2.3 (Community Edition)

2- Android studio (Android Studio Dolphin | 2021.3.1)

Let's Start :

1- Clone repo 

2- Will find two video for working demo

3- Two folders for android project & maven (Maven App, Android App)

4- open maven project you will most important file 

    (Main) which contain simple java ui allow you to select file and then consume api and show result on ui also.

    (KPITApi) which contain one class with simple java func (countFileWords) to take file path and return number of words or throw Exception

    (KPITApiTests) which have couple of unit tests for (KPITApi.countFileWords)

5- Try to build and run maven project to see it on ui.

6- To generate your artifact all you need just open maven window inside lifeCycle folder you will find package option double click on it.

7- locate Jar file on your file system (we will use it on android studio)


8- Open android project and try to build it and run it and see it on action with ui.

9- It only have one fragment with simple ui to select file and show result back on same screen.

10- for artifact setup switch file system to project on android studio 
you will find it inside (app/libs)

11- also need to be configure inside build.gradle 

```
dependencies {
    ......
    implementation files('libs/TestKPIT-1.0.jar')
}
```

#### This demo dosen't have full steps to do it, it more about working demo to show result.



## Thanks for your reading time.


