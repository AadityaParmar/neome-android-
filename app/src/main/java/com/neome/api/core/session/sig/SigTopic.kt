// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.session.sig

import com.neome.api.core.base.Types.EnumTopicType
import com.neome.api.meta.base.SysId
import com.neome.api.meta.base.Types.ArtifactId
import com.neome.api.nucleus.base.sig.Sig

open class SigTopic : Sig() {
    lateinit var aboutId: SysId
    lateinit var artifactId: ArtifactId
    lateinit var type: EnumTopicType
}
