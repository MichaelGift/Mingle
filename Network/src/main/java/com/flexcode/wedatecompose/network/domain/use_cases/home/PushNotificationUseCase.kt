package com.flexcode.wedatecompose.network.domain.use_cases.home

import com.flexcode.wedatecompose.network.domain.repository.home.HomeRepository

class PushNotificationUseCase(
    private val repository: HomeRepository
) {
    operator fun invoke(crushUserId: String) =
        repository.sendPushNotificationToLikedUser(crushUserId)
}
