// neome.ai API - do not change
//

package com.neome.java.api.ent.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdDeeplink;
import com.neome.java.api.meta.base.Types.MetaIdLayoutForm;
import com.neome.java.api.meta.base.Types.MetaIdSpreadsheet;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DtoEntDeeplinkSpreadsheetInsert extends DtoEntDeeplink
{
  @Nullable
  public MetaIdLayoutForm formEditorLayoutId;

  @Nullable
  public MetaIdLayoutForm mobileFormEditorLayoutId;

  @Nullable
  public MetaIdSpreadsheet spreadsheetId;

  @Nullable
  public MetaIdDeeplink successDeeplinkId;
}
