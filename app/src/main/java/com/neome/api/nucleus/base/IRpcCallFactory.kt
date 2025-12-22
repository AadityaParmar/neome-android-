// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.nucleus.base

import com.neome.api.meta.base.ArtifactId
import com.neome.api.meta.base.Types.ServiceName
import com.neome.api.meta.base.sig.ISig

interface IRpcCallFactory {
    fun <S : ISig> create(
        sigClass: Class<S>,
        artifactId: ArtifactId,
        serviceName: ServiceName,
        apiName: String
    ): IRpcCall<S>
}
