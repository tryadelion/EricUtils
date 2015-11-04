# EricUtils

This document will cover the main features of this library. it will be always growing.

## 1 - (x)Utils Classes
The classes named xUtils (MapUtils, DateUtils), contain for now a dozen or so methods that i've found useful during my android dev life and that i don't want to have to write again. never. ever. what a damn pain to remember every name!

## 2 - AbstractActivity

This is a fancy class. to implement it, create a custom activity class (MyAbstractActivity) , and extend abstract activity.
This way, you'll have to implement two methods and a  lot fancy more things that i will explain soon.

## 3 - Helper Classes

Soon to be added, those classes should provide even more functionality to my utils classes by, for example, helping you query the google maps API for a location, or for the list of polylines between A and B, or an extended webview that has, by default, all ready-to-work required features ( html5, chromium, javascript, tel: and mailto: detection intents...), etc...


# How to get it?

using Jcenter() on your gradle file of choice ( but it won't work unless it's in your app's build.gradle),

compile 'com.cpteric:ericutils2:0.+'
