package dev.gabrielsancho.boombox.config

object ConfigureFirebase {

//    private val options = FirebaseOptions
//        .Builder()
//        .setApiKey("AIzaSyCIcqY0mdUP9YOCbkiVdEWTwNfQ0WP1cSA")
//        .setApplicationId("1:572164854915:web:888a2ed8190b2f844937b6")
//        .setProjectId("boombox-21595")
//        .setStorageBucket("boombox-21595.appspot.com")
//        .setGcmSenderId("572164854915")
//        .setDatabaseUrl("https://boombox-21595-default-rtdb.firebaseio.com")
//        .build()

//    private object LocalFirebasePlatform : FirebasePlatform() {
//        private val storage = mutableMapOf<String, String>()
//
//        override fun store(key: String, value: String) {
//            storage[key] = value
//        }
//
//        override fun retrieve(key: String): String? {
//            return storage[key]
//        }
//
//        override fun clear(key: String) {
//            storage.remove(key)
//        }
//
//        override fun log(msg: String) = println(msg)
//    }

    operator fun invoke() {
//        FirebasePlatform.initializeFirebasePlatform(LocalFirebasePlatform)
//        FirebaseApp.initializeApp(Application(), options)
    }
}
