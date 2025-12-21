package com.neome.feature.camera.di

import com.neome.feature.camera.data.repository.ImageStorageRepositoryImpl
import com.neome.feature.camera.data.source.ImageFileDataSource
import com.neome.feature.camera.domain.repository.ImageStorageRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class CameraModule {

    @Binds
    @Singleton
    abstract fun bindImageStorageRepository(
        impl: ImageStorageRepositoryImpl
    ): ImageStorageRepository
}
