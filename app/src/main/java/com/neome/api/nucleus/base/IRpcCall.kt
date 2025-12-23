// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.nucleus.base

import com.neome.api.meta.base.msg.IMsg
import com.neome.api.meta.base.sig.ISig

interface IRpcCall<S : ISig> {
    fun sendRefreshToken(): IRpcCall<S>
    fun sendBearerToken(): IRpcCall<S>
    fun post(msg: IMsg?, sigAcceptor: ISigAcceptor<S>)
    fun put(msg: IMsg?, sigAcceptor: ISigAcceptor<S>)
    fun patch(msg: IMsg?, sigAcceptor: ISigAcceptor<S>)
    fun get(msg: IMsg?, sigAcceptor: ISigAcceptor<S>)
    fun delete(msg: IMsg?, sigAcceptor: ISigAcceptor<S>)
}
