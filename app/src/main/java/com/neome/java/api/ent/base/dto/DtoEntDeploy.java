// neome.ai API - do not change
//

package com.neome.java.api.ent.base.dto;

import com.neome.java.api.ent.entDrawer.sig.SigEntAvatarUser;
import com.neome.java.api.meta.base.Types.MetaIdRole;
import com.neome.java.api.meta.base.Types.MetaIdVar;
import com.neome.java.api.meta.base.dto.StudioEntRole;

import java.util.Map;

@SuppressWarnings("unused")
public class DtoEntDeploy
{
  public SigEntAvatarUser avatar;

  public Map<MetaIdRole, StudioEntRole> roleMap;

  public Map<MetaIdVar, DtoVarUserSetting> userSettingVarMap;
}
