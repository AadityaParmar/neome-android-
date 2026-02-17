// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.cluster.sig

import com.neome.api.core.base.dto.DtoClusterItemMetric
import com.neome.api.nucleus.base.sig.Sig

interface SigClusterItemData : Sig
{
  val metricList: List<DtoClusterItemMetric>
  val nameColList: List<String>
}