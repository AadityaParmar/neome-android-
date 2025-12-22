// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdGroup;
import com.neome.java.api.meta.base.Types.MetaIdSpreadsheet;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class EntVdRowInsertPartitionRequest extends EntVdAutoStep
{
  @Nullable
  public StudioBuildArgBinder fromSender;

  @Nullable
  public StudioDtoChatBubbleHeader requestBubbleHeader;

  @Nullable
  public MetaIdSpreadsheet spreadsheetId;

  @Nullable
  public MetaIdGroup[] toGroupIdSet;
}
