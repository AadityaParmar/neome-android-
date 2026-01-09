package com.neome.core.common.serializer.api.home.base.dto

import com.neome.api.home.base.dto.DtoUserGroupConfiguration
import kotlinx.serialization.Serializable


@Serializable
data class DtoUserGroupConfigurationData(
    override val canAddMember: Boolean,
    override val canDeleteGroup: Boolean,
    override val canExitGroup: Boolean,
    override val canInvite: Boolean,
    override val canMakeAdmin: Boolean,
    override val canRemoveAdmin: Boolean,
    override val canRemoveMember: Boolean
) : DtoUserGroupConfiguration
