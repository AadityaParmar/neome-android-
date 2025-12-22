// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Symbol;
import com.neome.java.api.meta.base.Types.EnumDefnPluginApiMethod;
import com.neome.java.api.meta.base.Types.MetaIdForm;
import com.neome.java.api.meta.base.Types.PluginApiId;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioEntPluginApi extends StudioBase
{
  public EnumDefnPluginApiMethod apiType;

  @Nullable
  public String baseURL;

  @Nullable
  public Boolean guaranteedInvocation;

  @Nullable
  public StudioMapOfArgBinder headerParamMap;

  @Nullable
  public MetaIdForm inputFormId;

  public Symbol name;

  @Nullable
  public MetaIdForm outputFormId;

  public PluginApiId pluginApiId;

  @Nullable
  public StudioMapOfArgBinder queryParamMap;

  @Nullable
  public StudioPluginApiBody requestBody;

  @Nullable
  public StudioPluginApiBody responseBody;
}
