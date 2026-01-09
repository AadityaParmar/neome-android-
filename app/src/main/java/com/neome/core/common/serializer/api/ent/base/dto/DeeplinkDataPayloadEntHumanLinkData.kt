package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.core.base.Types.EnumDeeplinkActionType
import com.neome.api.ent.base.dto.DeeplinkDataPayloadEnt
import com.neome.api.ent.base.dto.DeeplinkDataPayloadEntHeader
import com.neome.api.ent.base.dto.DeeplinkDataPayloadEntHumanLink
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.DefnForm
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.core.common.serializer.sysId.EntIdSer
import kotlinx.serialization.Serializable


@Serializable
data class DeeplinkDataPayloadEntHumanLinkData(
    override val deeplinkActionType: EnumDeeplinkActionType,
    override val header: DeeplinkDataPayloadEntHeader? = null,
    override val embedFormDefn: DefnForm,
    override val embedFormValue: FormValueRaw? = null,
    @Serializable(with = EntIdSer::class) override val entId: Types.EntId,
    override val message: String,
    override val senderHandle: String? = null,
    override val senderName: String? = null,
    override val targetHandle: String? = null,
    override val targetName: String? = null,
    override val title: String
) : DeeplinkDataPayloadEntHumanLink
