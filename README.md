# CS441Assignment1
Name: Vladimir Malcevic
Assignment 1 for CS441 at Binghamton University

Wrote the project in Android Studio and worked mostly on graphics.

Button is implemented to work on button press (initial button down event until the button up event)

On button press:
* Screen background changes color gradually from black to blue
* Text changes to a hello world message

On button release:
* Screen background changes color gradually from blue to black
    * If background color transition is not finished, color transition to black begins from current background color
* Text changes to new prompt to press button
* Button animates a small bounce

For the animation, xml files were used in the anim resource folder.

Button press and release functionallity was accomplished through use of event actions ```MotionEvent.ACTION_DOWN``` and ```MotionEvent.ACTION_UP```.

Screen background was transitioned from colors by using ColorDrawable and TransitionDrawable classes in Android Stuido. 
