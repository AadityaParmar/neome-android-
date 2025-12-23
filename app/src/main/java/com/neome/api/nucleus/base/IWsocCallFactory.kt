// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.nucleus.base

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.ServiceName
import com.neome.api.meta.base.sig.ISig

interface IWsocCallFactory {
    fun <S : ISig> create(
        sigClass: Class<S>,
        artifactId: Types.ArtifactId,
        serviceName: ServiceName,
        apiName: String
    ): IWsocCall<S>
}
