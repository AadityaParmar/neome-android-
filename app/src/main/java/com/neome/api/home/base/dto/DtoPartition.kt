// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdPartition

interface DtoPartition
{
  val assignPartitionFieldId: MetaIdField
  val partition: String
  val partitionId: MetaIdPartition
}