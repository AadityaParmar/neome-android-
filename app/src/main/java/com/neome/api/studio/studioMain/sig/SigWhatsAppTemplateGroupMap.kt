// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.sig

import com.neome.api.meta.base.dto.DtoWhatsAppTemplateGroup
import com.neome.api.nucleus.base.sig.Sig
import java.util.Map

open class SigWhatsAppTemplateGroupMap : Sig() {
    lateinit var map: Map<String, DtoWhatsAppTemplateGroup>
}
