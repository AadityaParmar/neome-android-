// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Types.EntId
import com.neome.api.meta.base.dto.DefnForm
import com.neome.api.meta.base.dto.FormValueRaw

open class DeeplinkDataPayloadEntHumanLink : DeeplinkDataPayloadEnt() {
    lateinit var embedFormDefn: DefnForm
    var embedFormValue: FormValueRaw? = null
    lateinit var entId: EntId
    lateinit var message: String
    var senderHandle: String? = null
    var senderName: String? = null
    var targetHandle: String? = null
    var targetName: String? = null
    lateinit var title: String
}
