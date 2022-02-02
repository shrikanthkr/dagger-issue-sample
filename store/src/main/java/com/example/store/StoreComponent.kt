package com.example.store

import com.example.crypto.CryptoComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Inject

@Component(dependencies = [CryptoComponent::class])
interface StoreComponent {

    fun store(): FromStore

    @Component.Factory
    interface Factory {
        public fun create(
            @BindsInstance value: String,
            cryptoComponent: CryptoComponent
        ): StoreComponent
    }

    companion object {
        @JvmStatic fun factory(): Factory {
            return DaggerStoreComponent.factory()
        }
    }
}

data class FromStore @Inject constructor(val value: String)