// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdLayoutForm;
import com.neome.api.meta.base.Types.MetaIdSpreadsheet;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioEntActionRowInsert extends StudioEntAction
{
  @Nullable
  public StudioDtoChatBubbleHeader chatBubbleHeader;

  @Nullable
  public MetaIdLayoutForm formEditorLayoutId;

  @Nullable
  public MetaIdLayoutForm mobileFormEditorLayoutId;

  @Nullable
  public Boolean sendMessageToInbox;

  @Nullable
  public MetaIdSpreadsheet spreadsheetId;
}
