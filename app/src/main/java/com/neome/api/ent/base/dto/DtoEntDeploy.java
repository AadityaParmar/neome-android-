// neome.ai API - do not change
//

package com.neome.api.ent.base.dto;

import com.neome.api.ent.entDrawer.sig.SigEntAvatarUser;
import com.neome.api.meta.base.Types.MetaIdRole;
import com.neome.api.meta.base.Types.MetaIdVar;
import com.neome.api.meta.base.dto.StudioEntRole;

import java.util.Map;

@SuppressWarnings("unused")
public class DtoEntDeploy
{
  public SigEntAvatarUser avatar;

  public Map<MetaIdRole, StudioEntRole> roleMap;

  public Map<MetaIdVar, DtoVarUserSetting> userSettingVarMap;
}
