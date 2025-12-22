// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnEditorLayoutRenderingMode;
import com.neome.java.api.meta.base.Types.EnumDefnWizardNavigationMode;
import com.neome.java.api.meta.base.Types.MetaIdComposite;
import com.neome.java.api.meta.base.Types.MetaIdLayoutForm;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnLayoutFormEditor extends DefnLayoutForm
{
  @Nullable
  public MetaIdLayoutForm[] allowToSwitchLayoutIdSet;

  @Nullable
  public MetaIdComposite[] compositeIdSet;

  @Nullable
  public EnumDefnEditorLayoutRenderingMode editorLayoutRenderingMode;

  @Nullable
  public MetaIdLayoutForm[] formEditorLayoutIdSet;

  @Nullable
  public MetaIdComposite[] hideLabelCompositeIdSet;

  @Nullable
  public String label;

  @Nullable
  public DefnMapOfLayoutFormEditorComposite layoutCompositeMap;

  @Nullable
  public EnumDefnWizardNavigationMode navigationMode;

  @Nullable
  public String nextButtonLabel;

  @Nullable
  public String prevButtonLabel;

  @Nullable
  public Boolean showStepper;
}
