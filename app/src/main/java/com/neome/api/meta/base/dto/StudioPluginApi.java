// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Symbol;
import com.neome.api.meta.base.Types.EnumDefnPluginApiMethod;
import com.neome.api.meta.base.Types.MetaIdForm;
import com.neome.api.meta.base.Types.PluginApiId;

import org.jetbrains.annotations.Nullable;

import java.util.Date;

@SuppressWarnings("unused")
public class StudioPluginApi extends StudioBase
{
  public EnumDefnPluginApiMethod apiType;

  @Nullable
  public StudioValueVarIdText baseURLVarId;

  public Date creationDate;

  @Nullable
  public String description;

  @Nullable
  public Boolean guaranteedInvocation;

  @Nullable
  public StudioMapOfArgBinder headerParamMap;

  @Nullable
  public MetaIdForm inputFormId;

  public PluginApiId metaId;

  @Nullable
  public StudioModuleSelection modules;

  public Symbol name;

  @Nullable
  public MetaIdForm outputFormId;

  @Nullable
  public StudioMapOfArgBinder queryParamMap;

  @Nullable
  public StudioPluginApiBody requestBody;

  @Nullable
  public StudioPluginApiBody responseBody;
}
