// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.nucleus.base

import com.neome.api.meta.base.sig.ISig
import com.neome.api.nucleus.base.dto.EnvSignal

interface ISigAcceptor<S : ISig> {
    fun execute(envSig: EnvSignal<S>)
}
