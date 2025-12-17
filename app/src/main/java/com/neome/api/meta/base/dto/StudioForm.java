// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnCalculateFormulaMode;
import com.neome.api.meta.base.Types.EnumDefnThemeTabVariant;
import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdForm;
import com.neome.api.meta.base.Types.MetaIdRole;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioForm extends StudioBase
{
  @Nullable
  public StudioMapOfActionPermission actionPermissionMap;

  @Nullable
  public String aiInstructions;

  @Nullable
  public Boolean allowToPrintForm;

  @Nullable
  public EnumDefnCalculateFormulaMode calculateFormulaMode;

  @Nullable
  public MetaIdField[] chatBubbleFieldIdSet;

  @Nullable
  public MetaIdField chatLabelFieldId;

  @Nullable
  public StudioValueVarIdText chatLabelPatternVarId;

  @Nullable
  public StudioValueVarIdParagraph chatPatternVarId;

  @Nullable
  public MetaIdRole[] commentReadOnlyRoleSet;

  @Nullable
  public MetaIdRole[] commentRoleSet;

  public StudioCompositeMap compositeMap;

  @Nullable
  public Boolean configForm;

  public StudioDetails details;

  @Nullable
  public StudioMapOfFormula formulaMap;

  @Nullable
  public StudioMapOfLayoutForm layoutMap;

  public MetaIdForm metaId;

  @Nullable
  public StudioPaymentConfig payment;

  @Nullable
  public StudioDtoPermissionMatrix permissionMatrix;

  @Nullable
  public EnumDefnThemeTabVariant tabVariant;

  @Nullable
  public StudioVisibilityRuleMap visibilityRuleMap;
}
