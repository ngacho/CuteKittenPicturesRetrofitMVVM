package com.brocodes.catspics.di

import dagger.Module
import dagger.Provides

@Module
class PetTypeModule(val petType : String) {

    @Provides
    fun providePetType(): String = petType

}