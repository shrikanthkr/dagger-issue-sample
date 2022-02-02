package com.example.network

import com.example.store.FromStore
import com.example.store.StoreComponent
import dagger.Component
import dagger.Module
import dagger.Provides

@Component(
    modules = [NetworkModule::class],
    dependencies = [StoreComponent::class]
)
interface NetworkComponent {

    fun dummy(): Dummy

    @Component.Factory
    interface Factory {
        public fun create(
            modelComponent: StoreComponent,
        ): NetworkComponent
    }

    companion object {
        @JvmStatic fun factory(): Factory {
            return DaggerNetworkComponent.factory()
        }
    }
}

@Module
object NetworkModule {
    @Provides
    fun dummy(store: FromStore): Dummy {
        return Dummy((store))
    }
}

data class Dummy(val store: FromStore)
