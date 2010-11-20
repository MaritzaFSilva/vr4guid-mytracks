/*
 * Copyright 2010 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.android.apps.mytracks;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.test.ActivityInstrumentationTestCase2;

/**
 * @author Sandor Dornbush
 */
public class DialogManagerTest
    extends ActivityInstrumentationTestCase2<MyTracks> {

  public DialogManagerTest() {
    super(MyTracks.class);
  }

  @Override
  protected void setUp() throws Exception {
    super.setUp();
    MyTracks.clearInstance();
    assertNull(MyTracks.getInstance());
  }

  public void test_onCreateChartSettings() {
    Dialog d =
        getActivity().onCreateDialog(DialogManager.DIALOG_CHART_SETTINGS, null);
    assertNotNull(d);
    assertTrue(d instanceof ChartSettingsDialog);
  }

  public void test_onCreateImportProgress() {
    Dialog d =
        getActivity().onCreateDialog(
            DialogManager.DIALOG_IMPORT_PROGRESS, null);
    assertNotNull(d);
    assertTrue(d instanceof ProgressDialog);
  }

  public void test_onCreateProgress() {
    Dialog d =
        getActivity().onCreateDialog(DialogManager.DIALOG_PROGRESS, null);
    assertNotNull(d);
    assertTrue(d instanceof ProgressDialog);
    ProgressDialog pd = (ProgressDialog) d;
    assertEquals(100, pd.getMax());
    assertEquals(10, pd.getProgress());
  }

  public void test_onCreateSendToGoogle() {
    Dialog d =
        getActivity().onCreateDialog(DialogManager.DIALOG_SEND_TO_GOOGLE, null);
    assertNotNull(d);
    assertTrue(d instanceof SendToGoogleDialog);
  }

  public void test_onCreateSendToGoogleResult() {
    Dialog d =
        getActivity().onCreateDialog(
            DialogManager.DIALOG_SEND_TO_GOOGLE_RESULT, null);
    assertNotNull(d);
    assertTrue(d instanceof AlertDialog);
  }

  public void test_onCreateWriteProgress() {
    Dialog d =
        getActivity().onCreateDialog(
            DialogManager.DIALOG_WRITE_PROGRESS, null);
    assertNotNull(d);
    assertTrue(d instanceof ProgressDialog);
  }

}