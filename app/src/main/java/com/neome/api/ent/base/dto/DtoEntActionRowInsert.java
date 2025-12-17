// neome.ai API - do not change
//

package com.neome.api.ent.base.dto;

import com.google.gson.JsonElement;
import com.neome.api.meta.base.Types.MetaIdComp;
import com.neome.api.meta.base.Types.MetaIdForm;
import com.neome.api.meta.base.Types.MetaIdLayoutForm;
import com.neome.api.meta.base.Types.MetaIdSpreadsheet;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class DtoEntActionRowInsert extends DtoEntAction
{
  @Nullable
  public Map<MetaIdComp, JsonElement> defaultValueMap;

  @Nullable
  public MetaIdLayoutForm formEditorLayoutId;

  @Nullable
  public Boolean hasPartitions;

  @Nullable
  public MetaIdLayoutForm mobileFormEditorLayoutId;

  @Nullable
  public Boolean sendMessageToInbox;

  public MetaIdForm spreadsheetFormId;

  public MetaIdSpreadsheet spreadsheetId;
}
