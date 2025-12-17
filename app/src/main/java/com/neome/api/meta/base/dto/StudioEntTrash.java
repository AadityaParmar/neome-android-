// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

import com.neome.api.meta.base.Types.MetaIdAction;
import com.neome.api.meta.base.Types.MetaIdComposite;
import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdForm;
import com.neome.api.meta.base.Types.MetaIdGroup;
import com.neome.api.meta.base.Types.MetaIdLayoutForm;
import com.neome.api.meta.base.Types.MetaIdLayoutGrid;
import com.neome.api.meta.base.Types.MetaIdLayoutUser;
import com.neome.api.meta.base.Types.MetaIdModule;
import com.neome.api.meta.base.Types.MetaIdReport;
import com.neome.api.meta.base.Types.MetaIdRole;
import com.neome.api.meta.base.Types.MetaIdSpreadsheet;
import com.neome.api.meta.base.Types.MetaIdVar;
import com.neome.api.meta.base.dto.StudioComposite;
import com.neome.api.meta.base.dto.StudioDtoLayoutForm;
import com.neome.api.meta.base.dto.StudioDtoLayoutGrid;
import com.neome.api.meta.base.dto.StudioDtoLayoutUser;
import com.neome.api.meta.base.dto.StudioEntAction;
import com.neome.api.meta.base.dto.StudioEntGroup;
import com.neome.api.meta.base.dto.StudioEntReport;
import com.neome.api.meta.base.dto.StudioEntRole;
import com.neome.api.meta.base.dto.StudioEntSpreadsheet;
import com.neome.api.meta.base.dto.StudioField;
import com.neome.api.meta.base.dto.StudioForm;
import com.neome.api.meta.base.dto.StudioVar;

@SuppressWarnings("unused")
public class StudioEntTrash
{
  @Nullable
  public Map<MetaIdAction, StudioEntAction> actionMap;

  @Nullable
  public Map<MetaIdComposite, StudioComposite> compositeMap;

  @Nullable
  public Map<MetaIdLayoutForm, StudioDtoLayoutForm> contentMap;

  @Nullable
  public Map<MetaIdField, StudioField> fieldMap;

  @Nullable
  public Map<MetaIdForm, StudioForm> formMap;

  @Nullable
  public Map<MetaIdGroup, StudioEntGroup> groupMap;

  @Nullable
  public Map<MetaIdLayoutGrid, StudioDtoLayoutGrid> layoutGridMap;

  @Nullable
  public Map<MetaIdLayoutUser, StudioDtoLayoutUser> layoutUserMap;

  @Nullable
  public Map<MetaIdModule, String> moduleMap;

  @Nullable
  public Map<MetaIdReport, StudioEntReport> reportMap;

  @Nullable
  public Map<MetaIdRole, StudioEntRole> roleMap;

  @Nullable
  public Map<MetaIdSpreadsheet, StudioEntSpreadsheet> spreadsheetMap;

  @Nullable
  public Map<MetaIdVar, StudioVar> varMap;
}
