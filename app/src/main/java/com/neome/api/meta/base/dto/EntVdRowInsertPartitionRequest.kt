// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAutoStep
import com.neome.api.meta.base.Types.MetaIdGroup
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.dto.StudioBuildArgBinder
import com.neome.api.meta.base.dto.StudioDtoChatBubbleHeader

interface EntVdRowInsertPartitionRequest : EntVdAutoStep
{
  val fromSender: StudioBuildArgBinder?
  val requestBubbleHeader: StudioDtoChatBubbleHeader?
  val spreadsheetId: MetaIdSpreadsheet?
  val toGroupIdSet: Array<MetaIdGroup>?
}