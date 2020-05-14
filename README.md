# Pawsome
A simple app that displays Kitten and Puppy pictures.

##Uses:
1. MVVM architecture.
2. Retrofit for consuming Rest Apis.
3. DataBinding Library.
4. Paging Library Infinite Scrolling.
5. Dagger 2 for dependency Injection.
6. Kotlin Coroutines for making network calls.


##SET UP
**create a _PawIdentifier object_ to have the following constants
```
object PawIdentifier{
    const val KITTENS = "Kittens" //Kitten query value in retrofit call
    const val PUPPIES = "Puppies" //Puppy query value in retrofit call
    const val KITTIE = "KITTIE" //Kitten Fragment name, used in view pager adapter
    const val DOGGO = "DOGGO" //Puppy fragment name, used in view pager adapter
    const val API_KEY = "******" //fetch your own pixabay api key and place it here
}
```
