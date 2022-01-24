# Africa4DataKotlinTest
This app is for testing my skills in Kotlin - Let's go !

-------------------------------- Library Used --------------------------------
- Viewmodel for implementing MVVM architecture
- Glide to load images and bitmaps.
- Espresso and JUnit For testing (Unit tests and UI test).
- Dagger2 For dependency injection
- Proguard user (See build.gradle)
- Rx-java rx android For background threading and handling database access.
- Rx-observables to detect changes
- Slider A fancy SeekBar.

-------------------------------- Fonctions --------------------------------
- Each device have its own class (See 'classes' folder under com.test.africafordata)
- Data are fetched and parsed from http://storage42.com/modulotest/data.json
- List devices in the HomeFragment are filterable and deletable (Swipe Left or Right to delete)
- Click on a device to get details and modify informations depending on your needs
- A User profile page to update informations. All fields are typed and handle errors and empty states (We don't have and email informations to be handled here)
- Each device state (mode, intensity...) is kept within the app life cycle, even if the app is killed.
- App is translated to both (French and English). It take the current active language in the device by default
- Unit tests and UI tests are made like specified in the specs. You can see them in the 'androidTest' folder and the 'test' folder under 'src'
- Sexy UI used and Animations are available on 'anim' folder under drawable.
- Support Darkmode

-------------------------------- Architecture ----------------------------------
- Langage used : Kotlin

--------------------------------- END ---------------------------------------------
I am sure this app can be better so feel free to ask me changes, i would be great to apply them.