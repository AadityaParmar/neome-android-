// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.google.gson.JsonElement;
import com.neome.java.api.meta.base.Types.EnumDefnKindAction;
import com.neome.java.api.meta.base.Types.MetaIdAction;
import com.neome.java.api.meta.base.Types.MetaIdComp;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class StudioEntAction extends StudioBase
{
  @Nullable
  public String aiInstructions;

  @Nullable
  public Map<MetaIdComp, JsonElement> defaultValueMap;

  public StudioDetails details;

  @Nullable
  public String icon;

  @Nullable
  public Boolean increaseAsideWidth;

  public EnumDefnKindAction kind;

  public MetaIdAction metaId;

  @Nullable
  public String tooltip;
}
