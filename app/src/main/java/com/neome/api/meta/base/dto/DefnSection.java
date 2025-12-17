// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnPlacement;
import com.neome.api.meta.base.Types.EnumDefnThemeDirection;
import com.neome.api.meta.base.Types.EnumDefnThemeSectionVariant;
import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdSection;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class DefnSection extends DefnComp
{
  @Nullable
  public DefnStudioMapOfActionPermission actionPermissionMap;

  @Nullable
  public MetaIdField[] fieldIdSet;

  @Nullable
  public Map<MetaIdField, Long> fieldSpanMap;

  @Nullable
  public Boolean flexGrow;

  @Nullable
  public EnumDefnPlacement justifyContent;

  public MetaIdSection metaId;

  @Nullable
  public Boolean overflowHidden;

  @Nullable
  public String propertyEditorLabel;

  @Nullable
  public FieldDtoSectionLayout reportLayout;

  @Nullable
  public EnumDefnThemeDirection sectionDirection;

  @Nullable
  public EnumDefnThemeSectionVariant sectionVariant;
}
