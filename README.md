# TextView4Dev
a textview for develop
# Why use this
At the time of the company's development, there were several test machines on hand, when the test took one of them to test, and then went to crash.And then I'm going to hate it.In fact, it's not the latest code to test the phone running in the past, but the latest code doesn't reproduce the bug, and you haven't changed the code.At this point, you don't know what the version of the bug is, and you can't get git back to the corresponding version to check the bug.Or because of the difference in Android version, the test can't immediately tell you the Android version of your phone.
# Usage 中文请查看我的[简书](https://www.jianshu.com/p/ce32ed12ad54)
1. copy TextView4Dev.java to your module
2. add`TextView4Dev textView4Dev = new TextView4Dev(this);`in MainActivity.class
3. add permission in AndroidManifest.xml
`<uses-permission android:name="android.permission.SYSTEM_ALERT_WINDOW"/>`
# Note
API>=23 Dynamic application permissions


If it is useful for you, please star, thank you very much
