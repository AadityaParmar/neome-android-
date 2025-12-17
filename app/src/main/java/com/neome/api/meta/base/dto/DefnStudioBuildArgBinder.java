// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnArgBinder;
import com.neome.api.meta.base.Types.EnumDefnCompType;
import com.neome.api.meta.base.Types.EnumDefnThemeDirection;
import com.neome.api.meta.base.Types.EnumStudioVarKind;
import com.neome.api.meta.base.Types.MetaIdComposite;
import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdForm;
import com.neome.api.meta.base.Types.MetaIdGrid;
import com.neome.api.meta.base.Types.MetaIdPlugin;
import com.neome.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnStudioBuildArgBinder extends DefnField
{
  @Nullable
  public MetaIdComposite[] compositeIdSet;

  @Nullable
  public MetaIdComposite[] derivedCompositeIdSet;

  @Nullable
  public MetaIdForm derivedFormId;

  @Nullable
  public MetaIdPlugin derivedPluginId;

  @Nullable
  public EnumDefnThemeDirection direction;

  @Nullable
  public MetaIdField[] excludeFieldIdSet;

  @Nullable
  public MetaIdVar[] excludeVarIdSet;

  @Nullable
  public EnumDefnCompType[] filterConstantFieldTypeSet;

  @Nullable
  public String[] filterContextCallerSet;

  @Nullable
  public String[] filterContextCallerSettingSet;

  @Nullable
  public String[] filterContextEntSet;

  @Nullable
  public String[] filterContextOptionSet;

  @Nullable
  public String[] filterContextRowSet;

  @Nullable
  public EnumDefnCompType[] filterDerivedFieldTypeSet;

  @Nullable
  public EnumDefnCompType[] filterFieldTypeSet;

  @Nullable
  public EnumDefnArgBinder[] filterKindSet;

  @Nullable
  public EnumStudioVarKind[] filterVarKindSet;

  @Nullable
  public MetaIdForm formId;

  @Nullable
  public MetaIdGrid gridId;

  @Nullable
  public DefnStudioMapOfDtoOption includeOptionMap;

  @Nullable
  public MetaIdForm inputFormId;

  @Nullable
  public MetaIdField peerFieldId;

  @Nullable
  public EnumDefnArgBinder peerKind;

  @Nullable
  public MetaIdForm pluginConfigFormId;

  @Nullable
  public MetaIdPlugin pluginId;

  @Nullable
  public MetaIdField refTargetFieldId;

  @Nullable
  public MetaIdForm refTargetFormId;

  @Nullable
  public Boolean required;
}
