// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Types.EntId
import com.neome.api.meta.base.dto.DefnForm
import com.neome.api.meta.base.dto.FormValueRaw

class DeeplinkDataPayloadEntHumanLink : DeeplinkDataPayloadEnt() {
    val embedFormDefn: DefnForm
    var embedFormValue: FormValueRaw? = null
    val entId: EntId
    val message: string
    var senderHandle: string? = null
    var senderName: string? = null
    var targetHandle: string? = null
    var targetName: string? = null
    val title: string
}
