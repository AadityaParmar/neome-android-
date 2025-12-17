// neome.ai API - do not change
//

package com.neome.api.ent.base.dto;

import com.google.gson.JsonElement;
import com.neome.api.meta.base.Types.EnumDefnKindReport;
import com.neome.api.meta.base.Types.MetaIdComp;
import com.neome.api.meta.base.Types.MetaIdForm;
import com.neome.api.meta.base.Types.MetaIdLayoutForm;
import com.neome.api.meta.base.Types.MetaIdReport;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class DtoEntActionReport extends DtoEntAction
{
  @Nullable
  public Map<MetaIdComp, JsonElement> defaultValueMap;

  @Nullable
  public MetaIdForm inputFormId;

  @Nullable
  public MetaIdLayoutForm outputFormContentLayoutId;

  public MetaIdForm outputFormId;

  @Nullable
  public MetaIdLayoutForm outputFormTemplateLayoutId;

  public MetaIdReport reportId;

  public EnumDefnKindReport reportKind;

  @Nullable
  public Boolean sendMessageToInbox;
}
