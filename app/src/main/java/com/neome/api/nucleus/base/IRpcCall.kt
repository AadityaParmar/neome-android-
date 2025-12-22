// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.nucleus.base

import com.neome.api.meta.base.sig.ISig
import com.neome.api.nucleus.base.dto.GsonMsg

interface IRpcCall<S : ISig> {
    fun sendRefreshToken(): IRpcCall<S>
    fun sendBearerToken(): IRpcCall<S>
    fun post(msg: GsonMsg?, sigAcceptor: ISigAcceptor<S>)
    fun put(msg: GsonMsg?, sigAcceptor: ISigAcceptor<S>)
    fun patch(msg: GsonMsg?, sigAcceptor: ISigAcceptor<S>)
    fun get(msg: GsonMsg?, sigAcceptor: ISigAcceptor<S>)
    fun delete(msg: GsonMsg?, sigAcceptor: ISigAcceptor<S>)
}
