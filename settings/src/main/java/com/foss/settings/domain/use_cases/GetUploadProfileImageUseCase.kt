package com.foss.settings.domain.use_cases

import com.foss.core.models.CustomResponseModel
import com.foss.core.models.Resource
import com.foss.settings.domain.repository.SettingsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetUploadProfileImageUseCase(private val settingsRepository: SettingsRepository) {

    operator fun invoke(request: ByteArray): Flow<Resource<CustomResponseModel<Any?>>> =
        flow {
            emit(Resource.Loading())
            try {
                emit(
                    Resource.Success(
                        data = settingsRepository.uploadProfileImage(
                            request
                        )
                    )
                )
            } catch (e: Exception) {
                emit(Resource.Error(message = e.toString()))
            }
        }

}