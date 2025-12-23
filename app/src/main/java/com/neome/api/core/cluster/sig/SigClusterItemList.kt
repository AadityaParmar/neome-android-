// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.cluster.sig

import com.neome.api.core.base.dto.DtoClusterItem
import com.neome.api.nucleus.base.sig.Sig

open class SigClusterItemList : Sig()
{
  var clusterItemList: Array<DtoClusterItem>? = null
}