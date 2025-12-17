// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Symbol;
import com.neome.api.meta.base.Types.EnumDefnDeeplinkConstraint;
import com.neome.api.meta.base.Types.EnumDefnDeeplinkExpiry;
import com.neome.api.meta.base.Types.EnumDefnKindDeeplink;
import com.neome.api.meta.base.Types.EnumDefnUserProps;
import com.neome.api.meta.base.Types.MetaIdDeeplink;
import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdRole;
import com.neome.api.meta.base.Types.MetaIdSpreadsheet;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class StudioEntDeeplink extends StudioBase
{
  @Nullable
  public MetaIdRole[] creationRoles;

  @Nullable
  public String description;

  @Nullable
  public EnumDefnDeeplinkExpiry expiry;

  public EnumDefnKindDeeplink kind;

  @Nullable
  public MetaIdRole[] makeUserDefaultRoles;

  public MetaIdDeeplink metaId;

  @Nullable
  public StudioModuleSelection modules;

  public Symbol name;

  @Nullable
  public Boolean showEnterpriseImageInLinkPreview;

  @Nullable
  public MetaIdField targetUserHandleFieldId;

  @Nullable
  public MetaIdSpreadsheet targetUserSpreadsheetId;

  @Nullable
  public Map<EnumDefnUserProps, MetaIdField> userFieldMap;

  @Nullable
  public EnumDefnDeeplinkConstraint visibilityConstraint;
}
