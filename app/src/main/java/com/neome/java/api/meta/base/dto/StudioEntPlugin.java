// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnPluginMode;
import com.neome.java.api.meta.base.Types.MediaIdAvatar;
import com.neome.java.api.meta.base.Types.MetaIdForm;
import com.neome.java.api.meta.base.Types.MetaIdVar;
import com.neome.java.api.meta.base.Types.PluginApiId;
import com.neome.java.api.meta.base.Types.PluginBundleId;
import com.neome.java.api.meta.base.Types.PluginId;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class StudioEntPlugin extends StudioEntImport
{
  public EnumDefnPluginMode mode;

  @Nullable
  public String pluginAbout;

  public PluginApiId[] pluginApiIdKeys;

  public Map<PluginApiId, StudioEntPluginApi> pluginApiIdMap;

  @Nullable
  public MediaIdAvatar pluginAvatarId;

  public PluginBundleId pluginBundleId;

  @Nullable
  public MetaIdForm pluginConfigFormId;

  public MetaIdForm[] pluginFormKeys;

  public Map<MetaIdForm, DefnForm> pluginFormMap;

  public PluginId pluginId;

  public String pluginName;

  @Nullable
  public StudioEntPluginResourceMap pluginResourceMap;

  public MetaIdVar[] pluginVarKeys;

  public Map<MetaIdVar, StudioVar> pluginVarMap;

  public String pluginVersion;

  @Nullable
  public Boolean singleton;
}
