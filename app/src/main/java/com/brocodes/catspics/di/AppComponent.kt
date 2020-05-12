package com.brocodes.catspics.di

import com.brocodes.catspics.ui.kittens.KittieFragment
import com.brocodes.catspics.ui.puppies.DoggoFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, PetTypeModule::class])
interface AppComponent {
    fun inject(kittieFragment: KittieFragment)
    fun inject(doggoFragment: DoggoFragment)
}