# EricUtils

This document will cover the main features of this library. it will be always growing.

## 1 - (x)Utils Classes
The classes named xUtils (MapUtils, DateUtils), contain for now a dozen or so methods that i've found useful during my android dev life and that i don't want to have to write again. never. ever. what a damn pain to remember every name!

## 2 - AbstractActivity

This is a fancy class. to implement it, create a custom activity class (MyAbstractActivity) , and extend abstract activity. this will provide some cool functionality.

i'll start showing off the abstract activity code.

```java
public abstract class AbstractActivity extends AppCompatActivity {
    public abstract Boolean setupView();
    public abstract int layoutId();
}
```

we will use the setupView method as the activity's oncreate method.  i made it return a boolean. you can override it or create a new one if you want another functionality. in my code, i use the boolean in the next context:
###### TRUE - the activity is inside a context, show the homeUpButtom of the toolbar.
###### FALSE - the activity is not inside a context,do not show the homeUpButtom of the toolbar.

the layoutID() method will provide the abstract activity's oncreate the information on what to inflate.

so let's take a look at a test implementation of it, called _MyAbstractActivity_

```java
public abstract class MyAbstractActivity extends AbstractActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState   ) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());
        Boolean interior  = setupView();
        Toolbar t = (Toolbar) findViewById(R.id.myToolbar);
        TextView text = (TextView) t.findViewById(R.id.toolbarTtitle);
        text.setText(findViewText(layoutId()));
        if (interior) {
            t.setDisplayHomeAsUpEnabled(true);
        }

    }

    private String findViewText(int id) {
        String ret = "NoNameFoundActivity";
        switch(id)
        {
            case R.layout.activity_main:
                ret = getResources().getString(R.string.title_activity_main);
                break;
            case R.layout.activity_news:
                ret = getResources().getString(R.string.title_activity_news);
                break;
        }
        return ret;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
```
_BUT_ , *_what does it do?_*

basically what we're doing here is defining a very basic functionality.
calling the ``` setContentView(layoutId()) ``` will retrieve the activity's layout id.

we then retrieve if the window is meant to have a go back home button on the toolbar. 
``` Boolean interior  = setupView(); ```

using the layout id get wet the activity title and set it up, and also put if necessary the homeup button.
```java
text.setText(findViewText(layoutId()));
if (interior) {
  actionBar.setDisplayHomeAsUpEnabled(true);
}
```

##### And what is inside the Activity that calls this?

let's take a look at _MyTestActivity_
```java
public class MyTestActivity extends MyAbstractActivity {
    @Override
    public Boolean setupView() {
        /**
         * INSERT ANY VIEW SETUP HERE, findViewById, API calls,
         * whatever you would put on a normal oncreate method.
         * this is your activity oncreate now. enjoy it.
         * **/

        //you are inside a list, so show a back button to get back to it. because i say so.
        return true;
    }

    @Override
    public int layoutId() {
        return R.layout.activity_details;
    }
}
```

enjoy your clutter-less activities.

## 3 - Helper Classes

Soon to be added, those classes should provide even more functionality to my utils classes by, for example, helping you query the google maps API for a location, or for the list of polylines between A and B, or an extended webview that has, by default, all ready-to-work required features ( html5, chromium, javascript, tel: and mailto: detection intents...), etc...


# How to get it?

using Jcenter() on your gradle file of choice ( but it won't work unless it's in your app's build.gradle),

> compile 'com.cpteric:ericutils2:0.+'
