# Pawsome
A simple app that displays Kitten and Puppy pictures.

##Uses:
    1. MVVM architecture.
    2. Retrofit for consuming Rest Apis.
    3. DataBinding library in recyclerview.
    4. Paging Library for Infinite scrolling
    5. Dagger 2 for dependency Injection


##SET UP
**create a _PawIdentifier object_ and add the following constants**
    1. const val KITTENS = "Kittens" //Kitten query value in retrofit call
    2. const val PUPPIES = "Puppies" //Puppy query value in retrofit call
    3. const val KITTIE = "KITTIE" //Kitten Fragment name, used in view pager adapter
    4. const val DOGGO = "DOGGO" //Puppy fragment name, used in view pager adapter
    5. const val API_KEY = "******" //fetch your own pixabay api key and place it here