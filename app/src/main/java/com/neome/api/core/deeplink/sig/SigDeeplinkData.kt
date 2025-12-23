// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.deeplink.sig

import kotlin.properties.Delegates
import com.neome.api.meta.base.Types.ArtifactId
import com.neome.api.core.base.dto.DeeplinkDataPayload
import com.neome.api.core.base.dto.DtoDeeplinkWebPreview
import com.neome.api.core.base.Types.EnumDeeplinkActionType
import com.neome.api.nucleus.base.sig.Sig

open class SigDeeplinkData : Sig()
{
  lateinit var artifactId: ArtifactId
  lateinit var deeplinkActionType: EnumDeeplinkActionType
  var payload: DeeplinkDataPayload? = null
  var preview: DtoDeeplinkWebPreview? = null
  var requiredSignIn: Boolean by Delegates.notNull<Boolean>()
}