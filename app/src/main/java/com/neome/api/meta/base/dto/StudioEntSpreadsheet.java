// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import org.jetbrains.annotations.Nullable;

import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdForm;
import com.neome.api.meta.base.Types.MetaIdRole;
import com.neome.api.meta.base.Types.MetaIdSpreadsheet;
import com.neome.api.meta.base.Types.MetaIdVar;
import com.neome.api.meta.base.dto.StudioBase;
import com.neome.api.meta.base.dto.StudioDetails;
import com.neome.api.meta.base.dto.StudioMapOfForwardRolePermission;
import com.neome.api.meta.base.dto.StudioMapOfLayoutGrid;
import com.neome.api.meta.base.dto.StudioMapOfPartition;

@SuppressWarnings("unused")
public class StudioEntSpreadsheet extends StudioBase
{
  public String alias;

  @Nullable
  public MetaIdRole[] auditTrailFormRoleSet;

  @Nullable
  public MetaIdRole[] bypassDurationRoleSet;

  @Nullable
  public MetaIdRole[] clearRoleSet;

  public StudioDetails details;

  public MetaIdForm formId;

  @Nullable
  public StudioMapOfForwardRolePermission groupForwardRolePermissionMap;

  @Nullable
  public MetaIdField[] historyIdSet;

  @Nullable
  public MetaIdRole[] insertRoleSet;

  @Nullable
  public MetaIdVar invisibleAfterDurationVarId;

  @Nullable
  public Boolean isMasterSheet;

  @Nullable
  public StudioMapOfLayoutGrid layoutSpreadsheetMap;

  public MetaIdSpreadsheet metaId;

  @Nullable
  public StudioMapOfPartition partitionMap;

  @Nullable
  public MetaIdField[] queryableIdSet;

  @Nullable
  public MetaIdField[] ragIdSet;

  @Nullable
  public MetaIdVar readAfterDurationVarId;

  @Nullable
  public MetaIdRole[] readRoleSet;

  @Nullable
  public MetaIdVar readRoleVarId;

  @Nullable
  public MetaIdRole[] removeRoleSet;

  @Nullable
  public MetaIdField[] searchableIdSet;

  @Nullable
  public Boolean supportOffline;

  @Nullable
  public MetaIdField[] uniqueIdSet;

  @Nullable
  public MetaIdField[] uniqueIndexIdSet;

  @Nullable
  public MetaIdRole[] updateRoleSet;

  @Nullable
  public StudioMapOfForwardRolePermission userForwardRolePermissionMap;
}
