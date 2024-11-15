# PillMax

**Created by Max Machado, Owen Clarke, Diya Shah, Neil Makur**

## The Problem
Anyone who has ever had to stick to a schedule for taking medication knows that sticking to the routine is often difficult. In severe cases, these simply missed pills can lead to life-altering effects - for example, some epilepsy patients can be so sensitive to the time they take their medication that even a 20-minute slip-up can cause a dangerous wave of seizures throughout the day. 

## Our Solution
Our hack seeks to keep those pills on schedule by synchronizing visual prompts from the pill case itself with our PillMax companion app, which will remind the patient as the time draws near and even actively search to ensure the pillbox is nearby. 

**The project is split into two main parts: the app and the physical pillbox.** 

### The App
The app allows you to input which pills you take, their doses, and the days and times they must be taken. The app then conveniently displays the next pill you must take and when and then further lists pills you must take soon.

*Built with Java using Android Studio*

### The Pillbox
The pillbox itself lights up as a reminder to take the pill, and it uses a circuit that is broken when the pill box cap is lifted to know that the user has taken the pill.

*Built with a Raspberry Pi to communicate with the app and Arduino to control LCD display*
