// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.sig

import com.neome.api.meta.base.dto.DtoWhatsAppTemplateGroup
import java.util.Map
import com.neome.api.nucleus.base.sig.Sig

open class SigWhatsAppTemplateGroupMap : Sig()
{
  lateinit var map: Map<String, DtoWhatsAppTemplateGroup>
}