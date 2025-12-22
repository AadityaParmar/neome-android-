// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.session.sig

import com.neome.api.meta.base.Types.ArtifactId
import com.neome.api.core.base.Types.EnumTopicType
import com.neome.api.nucleus.base.sig.Sig
import com.neome.api.meta.base.SysId

class SigTopic : Sig() {
    val aboutId: SysId
    val artifactId: ArtifactId
    val type: EnumTopicType
}
