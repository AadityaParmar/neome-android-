// neome.ai API - do not change
//

package com.neome.java.api.ent.entDrawer.sig;

import com.neome.java.api.ent.base.dto.DtoEntGroupFreezeSettingMap;
import com.neome.java.api.meta.base.Types.EntId;
import com.neome.java.api.nucleus.base.sig.Sig;

import java.util.Map;

@SuppressWarnings("unused")
public class SigEntFreezeGroupListGet extends Sig
{
  public Map<EntId, DtoEntGroupFreezeSettingMap> entMap;
}
