// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Symbol;
import com.neome.java.api.meta.base.Types.EnumDefnCalculateFormulaMode;
import com.neome.java.api.meta.base.Types.MetaIdComp;
import com.neome.java.api.meta.base.Types.MetaIdComposite;
import com.neome.java.api.meta.base.Types.MetaIdField;
import com.neome.java.api.meta.base.Types.MetaIdForm;
import com.neome.java.api.meta.base.Types.MetaIdGrid;
import com.neome.java.api.meta.base.Types.MetaIdLayoutGrid;
import com.neome.java.api.meta.base.Types.MetaIdRole;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class DefnForm
{
  @Nullable
  public DefnStudioMapOfActionPermission actionPermissionMap;

  @Nullable
  public Boolean allowToPrintForm;

  @Nullable
  public EnumDefnCalculateFormulaMode calculateFormulaMode;

  @Nullable
  public MetaIdField[] chatBubbleFieldIdSet;

  @Nullable
  public MetaIdField chatLabelFieldId;

  @Nullable
  public DefnDtoText chatLabelPatternVar;

  @Nullable
  public DefnDtoParagraph chatPatternVar;

  @Nullable
  public MetaIdRole[] commentReadOnlyRoleSet;

  @Nullable
  public MetaIdRole[] commentRoleSet;

  public Map<MetaIdComp, DefnComp> compMap;

  @Nullable
  public Boolean configForm;

  public MetaIdComposite displayCompositeId;

  @Nullable
  public MetaIdField[] formulaFieldIdSet;

  @Nullable
  public Map<MetaIdLayoutGrid, MetaIdGrid> gridLookupMap;

  @Nullable
  public String label;

  @Nullable
  public DefnLayoutFormMap layoutMap;

  public MetaIdForm metaId;

  public Symbol name;

  @Nullable
  public DefnPaymentConfig paymentConfig;

  @Nullable
  public DefnDtoPermissionMatrix permissionMatrix;

  @Nullable
  public DefnDtoFormTheme theme;

  @Nullable
  public DefnVisibilityRuleMap visibilityRuleMap;
}
