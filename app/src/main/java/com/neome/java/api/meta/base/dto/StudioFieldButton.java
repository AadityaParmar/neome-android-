// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnButtonTargetType;
import com.neome.java.api.meta.base.Types.EnumDefnKindButton;
import com.neome.java.api.meta.base.Types.EnumDefnPlacement;
import com.neome.java.api.meta.base.Types.EnumDefnTextSize;
import com.neome.java.api.meta.base.Types.EnumDefnThemeButtonVariant;
import com.neome.java.api.meta.base.Types.MetaIdAction;
import com.neome.java.api.meta.base.Types.MetaIdAutomation;
import com.neome.java.api.meta.base.Types.MetaIdField;
import com.neome.java.api.meta.base.Types.MetaIdGroup;
import com.neome.java.api.meta.base.Types.MetaIdReport;
import com.neome.java.api.meta.base.Types.MetaIdSpreadsheet;
import com.neome.java.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioFieldButton extends StudioFieldEditable
{
  @Nullable
  public MetaIdField[] actionClickButtonFieldIdArray;

  @Nullable
  public Boolean actionCloseAside;

  @Nullable
  public MetaIdField[] actionDisableFieldIdArray;

  @Nullable
  public MetaIdField[] actionEnableFieldIdArray;

  @Nullable
  public MetaIdGroup[] actionGroupIdSet;

  @Nullable
  public MetaIdAction actionId;

  @Nullable
  public MetaIdVar actionInputMappingVarId;

  @Nullable
  public MetaIdField[] actionInvisibleFieldIdArray;

  @Nullable
  public MetaIdField actionOpenLinkInNewTabFieldId;

  @Nullable
  public MetaIdVar actionOpenLinkInNewTabVarId;

  @Nullable
  public MetaIdField actionOpenLinkInSameTabFieldId;

  @Nullable
  public MetaIdVar actionOpenLinkInSameTabVarId;

  @Nullable
  public MetaIdVar actionOutputMappingVarId;

  @Nullable
  public MetaIdField[] actionSetDefaultFieldIdArray;

  @Nullable
  public MetaIdField[] actionToggleBooleanFieldIdArray;

  @Nullable
  public MetaIdField[] actionVisibleFieldIdArray;

  @Nullable
  public MetaIdAutomation automationId;

  @Nullable
  public MetaIdVar automationInputMappingVarId;

  @Nullable
  public StudioDtoColor bgColor;

  @Nullable
  public MetaIdVar bgColorVarId;

  @Nullable
  public Boolean btnPosDoNotInline;

  @Nullable
  public Boolean btnPosFloating;

  @Nullable
  public Boolean btnPosFooter;

  @Nullable
  public Boolean btnPosMenu;

  @Nullable
  public Boolean btnPosToolbar;

  @Nullable
  public EnumDefnKindButton buttonKind;

  @Nullable
  public EnumDefnPlacement buttonPosition;

  @Nullable
  public MetaIdVar buttonPositionVarId;

  @Nullable
  public EnumDefnThemeButtonVariant buttonVariant;

  @Nullable
  public MetaIdVar buttonVariantVarId;

  @Nullable
  public MetaIdField disableElevationFieldId;

  @Nullable
  public MetaIdVar disableElevationVarId;

  @Nullable
  public Boolean disabledElevation;

  @Nullable
  public Boolean executeActionsAfterTargetSuccess;

  @Nullable
  public EnumDefnPlacement iconPosition;

  @Nullable
  public MetaIdVar iconPositionVarId;

  @Nullable
  public StudioDtoPluginApi pluginApi;

  @Nullable
  public MetaIdField pluginErrorFieldId;

  @Nullable
  public MetaIdVar pluginInputMappingVarId;

  @Nullable
  public MetaIdVar pluginOutputMappingVarId;

  @Nullable
  public MetaIdReport reportId;

  @Nullable
  public MetaIdVar reportInputMappingVarId;

  @Nullable
  public MetaIdVar reportOutputMappingVarId;

  @Nullable
  public MetaIdSpreadsheet spreadsheetId;

  @Nullable
  public MetaIdVar spreadsheetMappingVarId;

  @Nullable
  public EnumDefnButtonTargetType targetType;

  @Nullable
  public EnumDefnTextSize textSize;

  @Nullable
  public MetaIdField textSizeFieldId;

  @Nullable
  public MetaIdVar textSizeVarId;

  @Nullable
  public StudioValueVarIdText toastMessageOnClickVarId;

  @Nullable
  public String toolTip;

  @Nullable
  public MetaIdField whatsAppHandleFieldId;

  @Nullable
  public StudioValueVarIdParagraph whatsAppMessageVarId;

  @Nullable
  public MetaIdVar workflowInputMappingVarId;

  @Nullable
  public EntVdWorkflowPointer workflowPointer;
}
