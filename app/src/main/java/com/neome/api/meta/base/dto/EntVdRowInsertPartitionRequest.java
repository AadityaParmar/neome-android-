// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import org.jetbrains.annotations.Nullable;

import com.neome.api.meta.base.dto.EntVdAutoStep;
import com.neome.api.meta.base.Types.MetaIdGroup;
import com.neome.api.meta.base.Types.MetaIdSpreadsheet;
import com.neome.api.meta.base.dto.StudioBuildArgBinder;
import com.neome.api.meta.base.dto.StudioDtoChatBubbleHeader;

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
