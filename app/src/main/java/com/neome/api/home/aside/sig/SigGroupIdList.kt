// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.aside.sig

import com.neome.api.meta.base.Types.GroupId
import java.util.Set
import com.neome.api.nucleus.base.sig.Sig

open class SigGroupIdList : Sig()
{
  lateinit var groupIdList: Array<GroupId>
}