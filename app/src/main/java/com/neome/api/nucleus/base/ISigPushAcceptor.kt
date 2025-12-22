// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.nucleus.base

import com.neome.api.meta.base.sig.ISig

interface ISigPushAcceptor<S : ISig> {
    fun execute(sig: S)
}
