// neome.ai API - do not change
//

package com.neome.api.home.drawer.sig;

import com.neome.api.home.base.dto.DtoUserNotification;
import com.neome.api.nucleus.base.sig.SigVersion;

@SuppressWarnings("unused")
public class SigUserNotificationList extends SigVersion
{
  public DtoUserNotification[] notificationList;
}