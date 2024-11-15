include(":app")
val filePath = settingsDir.parentFile.toString() + "/Flutter-add-to-app-Android-native-sample/my_flutter/.android/include_flutter.groovy"
apply(from = File(filePath))