package com.reloadbug;

import androidx.annotation.NonNull;

import com.facebook.common.internal.DoNotStrip;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;

@DoNotStrip
@ReactModule(name = "NativeReloadBugModule")
public class NativeReloadBugModule extends NativeReloadBugModuleSpec {

  private final ReactApplicationContext mContext;

  public NativeReloadBugModule(ReactApplicationContext reactContext) {
    super(reactContext);
    mContext = reactContext;
    // Comment me out to get a crash in `assertYourself` method.
    assert(reactContext.getJavaScriptContextHolder() != null);
  }

  @NonNull
  @Override
  public String getName() {
    return NAME;
  }

  @Override
  public boolean assertYourself() {
      if ((!mContext.hasNativeModule(getClass()))) throw new AssertionError("Invoking JSI Methods in the wrong context!");
    return true;
  }
}
