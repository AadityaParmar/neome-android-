// neome.ai API - do not change
//

package com.neome.java.api.home.base.dto;

import com.neome.java.api.core.base.dto.NotificationCustomData;

import org.jetbrains.annotations.Nullable;

import java.util.Date;

@SuppressWarnings("unused")
public class DtoUserNotification
{
  public String body;

  @Nullable
  public Date createdOn;

  @Nullable
  public NotificationCustomData customData;

  public String id;

  @Nullable
  public Boolean isRead;

  public String title;
}
