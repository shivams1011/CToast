# CToast
Custom Toast for Android

## Implmentation:-
Add following code in Project Gradle file
```bash
allprojects {
	repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  ```
Add following dependency in App Gradle file.
  ```bash
  dependencies {
	        implementation 'com.github.shivams1011:CToast:v1.2'
	}
  ```
## Configuration
Here how you can use it:-
```java
CToast cToast = new CToast.Builder(getApplicationContext())
						.setToastBgColor(R.color.colorPrimary)
						.setMsg(R.string.test_msg)
						.setLeftDrawable(R.drawable.ic_error_red_24dp)
						.setTopDrawable(R.drawable.ic_done_green_24dp)
						.setRightDrawable(R.drawable.ic_done_green_24dp)
						.setBottomDrawable(R.drawable.ic_error_red_24dp)
						.setGravity(Gravity.CENTER)
						.setDuration(Toast.LENGTH_SHORT)
						.setXYoffSet(-80,50)
						.setTextColor(R.color.white)
						.build();
				cToast.show();
```
Here we are using Builder pattern for customize the Toast according to user requirement.

## Screen Shot

<img src="https://github.com/shivams1011/CToast/blob/master/images/success.jpeg" alt="success" width="200"/>

<img src="https://github.com/shivams1011/CToast/blob/master/images/erro.jpeg" alt="error" width="200"/>
