// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdDeeplink;
import com.neome.java.api.meta.base.Types.MetaIdLayoutForm;
import com.neome.java.api.meta.base.Types.MetaIdSpreadsheet;
import com.neome.java.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioEntDeeplinkSpreadsheetInsert extends StudioEntDeeplinkWithHeader
{
  @Nullable
  public MetaIdLayoutForm formEditorLayoutId;

  @Nullable
  public MetaIdLayoutForm mobileFormEditorLayoutId;

  @Nullable
  public String repeatButtonLabel;

  @Nullable
  public Boolean showRepeatButton;

  @Nullable
  public MetaIdSpreadsheet spreadsheetId;

  @Nullable
  public MetaIdDeeplink successDeeplinkId;

  @Nullable
  public MetaIdVar successMessageBgColorVarId;

  @Nullable
  public MetaIdVar successMessageTextSizeVarId;

  @Nullable
  public StudioValueVarIdParagraph successMessageVarId;
}
