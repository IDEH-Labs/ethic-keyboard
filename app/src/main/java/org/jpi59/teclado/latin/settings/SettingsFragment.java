/*
 * Copyright (C) 2008 The Android Open Source Project
 * Copyright (C) 2025 Raimondas Rimkus
 * Copyright (C) 2021 wittmane
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jpi59.teclado.latin.settings;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import android.util.Log;

import org.jpi59.teclado.R;
import org.jpi59.teclado.latin.utils.ApplicationUtils;
import org.jpi59.teclado.latin.utils.AppLocale;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public final class SettingsFragment extends InputMethodSettingsFragment {
    private static final String TAG = "SettingsFragment";

    @Override
    public void onCreate(final Bundle icicle) {
        super.onCreate(icicle);
        setHasOptionsMenu(true);
        addPreferencesFromResource(R.xml.prefs);
        final PreferenceScreen preferenceScreen = getPreferenceScreen();
        preferenceScreen.setTitle(
                ApplicationUtils.getActivityTitleResId(getActivity(), SettingsActivity.class));
        final Resources res = getResources();

        findPreference(AppLocale.UI_LANGUAGE_KEY).setOnPreferenceChangeListener(
                new Preference.OnPreferenceChangeListener() {
                    @Override
                    public boolean onPreferenceChange(Preference preference, Object newValue) {
                        AppLocale.setLanguage(getActivity(), (String) newValue);
                        getActivity().recreate();
                        // The value was stored above so the recreated screen reads the new locale.
                        return false;
                    }
                });

        findPreference("privacy_policy").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                openUrl(res.getString(R.string.privacy_policy_url));
                return true;
            }
        });
        findPreference("license").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                openUrl(res.getString(R.string.license_url));
                return true;
            }
        });
    }

    @Override
    public void onCreateOptionsMenu(final Menu menu, final MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        final MenuItem item = menu.add(0, 1001, 0, R.string.menu_title);
        item.setIcon(R.drawable.ic_settings_menu);
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        if (item.getItemId() == 1001) {
            EthicEcosystemMenu.show(getActivity(), false);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void openUrl(String uri) {
        try {
            final Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
            startActivity(browserIntent);
        } catch (ActivityNotFoundException e) {
            Log.e(TAG, "Browser not found");
        }
    }
}
