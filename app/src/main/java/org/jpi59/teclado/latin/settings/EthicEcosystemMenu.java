/* Copyright (C) 2026 jpi59. SPDX-License-Identifier: GPL-3.0-or-later */
package org.jpi59.teclado.latin.settings;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import org.jpi59.teclado.R;

import java.security.MessageDigest;
import java.util.Locale;

/**
 * Sovereign Ethic Ecosystem panel and technical integrity inspection dialog.
 */
public final class EthicEcosystemMenu {

    private static final String[][] ALL_ECOSYSTEM_APPS = {
            {"Ethic Tuner", "org.jpi59.ethictuner", "Afinador cromático de máxima precisión", "Ultra-precise chromatic tuner", "https://github.com/jpi59/ethic-tuner"},
            {"Ethic Notes", "org.jpi59.ethicnotes", "Gestor de notas seguro y 100% privado", "Ultra-secure, zero-permission private notes manager", "https://github.com/jpi59/ethic-notes"},
            {"Ethic Compass", "org.jpi59.ethiccompass", "Brújula offline de sensores puros", "Offline pure sensor compass", "https://github.com/jpi59/ethic-compass"},
            {"Ethic QR Scanner", "org.jpi59.ethicqrscanner", "Lector QR sin rastreadores", "Tracker-free QR reader", "https://github.com/jpi59/ethic-qr-scanner"},
            {"Ethic Keyboard", "org.jpi59.teclado", "Teclado privado sin conexión a red", "Private offline keyboard", "https://github.com/jpi59/ethic-keyboard"},
            {"Ethic APK Guard", "org.jpi59.ethicupdatesafe", "Instalador y verificador seguro de APKs", "Secure APK analyzer and installer", "https://github.com/jpi59/ethic-apk-guard"},
            {"Ethic One Call", "org.jpi59.ethichandoff", "Gestor ético de llamadas de emergencia", "Ethical emergency call handoff", "https://github.com/jpi59/ethic-one-call"}
    };

    public static void show(Activity activity, boolean darkMode) {
        int surface = darkMode ? Color.rgb(20, 23, 21) : Color.rgb(248, 247, 243);
        int dialogSurface = darkMode ? Color.rgb(30, 35, 32) : Color.rgb(255, 255, 255);
        int cardStroke = darkMode ? Color.rgb(44, 51, 46) : Color.rgb(228, 226, 220);
        int ink = darkMode ? Color.rgb(226, 232, 226) : Color.rgb(20, 23, 21);
        int muted = darkMode ? Color.rgb(177, 184, 177) : Color.rgb(86, 98, 92);
        int action = darkMode ? Color.rgb(114, 205, 187) : Color.rgb(20, 92, 82);

        LinearLayout root = new LinearLayout(activity);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(dp(activity, 20), dp(activity, 16), dp(activity, 20), dp(activity, 20));

        // 1. Header with App Icon, Name, and Badge
        LinearLayout header = new LinearLayout(activity);
        header.setOrientation(LinearLayout.HORIZONTAL);
        header.setGravity(Gravity.CENTER_VERTICAL);
        header.setPadding(0, 0, 0, dp(activity, 14));

        ImageView icon = new ImageView(activity);
        Drawable appIcon = null;
        try {
            appIcon = activity.getPackageManager().getApplicationIcon(activity.getPackageName());
        } catch (Exception ignored) { }
        if (appIcon != null) {
            icon.setImageDrawable(appIcon);
        }
        LinearLayout.LayoutParams iconParams = new LinearLayout.LayoutParams(dp(activity, 44), dp(activity, 44));
        iconParams.setMarginEnd(dp(activity, 12));
        header.addView(icon, iconParams);

        LinearLayout titleCol = new LinearLayout(activity);
        titleCol.setOrientation(LinearLayout.VERTICAL);
        TextView title = new TextView(activity);
        title.setText(activity.getString(R.string.english_ime_name) + " · v" + getAppVersionName(activity));
        title.setTextSize(18);
        title.setTypeface(Typeface.create("sans-serif-medium", Typeface.NORMAL));
        title.setTextColor(ink);
        titleCol.addView(title);

        TextView badge = new TextView(activity);
        badge.setText(R.string.keyboard_badge);
        badge.setTextSize(12);
        badge.setTypeface(Typeface.create("sans-serif", Typeface.NORMAL));
        badge.setTextColor(action);
        titleCol.addView(badge);
        header.addView(titleCol);
        root.addView(header);

        // 2. Ethic Ecosystem Section
        root.addView(createSectionHeader(activity, activity.getString(R.string.ecosystem_section), action));
        TextView ecoDesc = new TextView(activity);
        ecoDesc.setText(R.string.ecosystem_desc);
        ecoDesc.setTextSize(12);
        ecoDesc.setTextColor(muted);
        ecoDesc.setPadding(0, 0, 0, dp(activity, 6));
        root.addView(ecoDesc);

        LinearLayout ecoCard = createCardLayout(activity, dialogSurface, cardStroke);
        PackageManager pm = activity.getPackageManager();
        boolean isSpanish = Locale.getDefault().getLanguage().startsWith("es");
        String currentPkg = activity.getPackageName();

        boolean first = true;
        for (String[] app : ALL_ECOSYSTEM_APPS) {
            final String name = app[0];
            final String pkg = app[1];
            final String desc = isSpanish ? app[2] : app[3];
            final String url = app[4];

            if (pkg.equals(currentPkg)) {
                continue;
            }

            if (!first) {
                ecoCard.addView(createDivider(activity, cardStroke));
            }
            first = false;

            final Intent launchIntent = pm.getLaunchIntentForPackage(pkg);
            final boolean isInstalled = launchIntent != null;

            LinearLayout appRow = new LinearLayout(activity);
            appRow.setOrientation(LinearLayout.HORIZONTAL);
            appRow.setGravity(Gravity.CENTER_VERTICAL);
            appRow.setPadding(0, dp(activity, 8), 0, dp(activity, 8));

            LinearLayout textCol = new LinearLayout(activity);
            textCol.setOrientation(LinearLayout.VERTICAL);
            textCol.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1f));

            TextView appNameView = new TextView(activity);
            appNameView.setText(name);
            appNameView.setTextSize(15);
            appNameView.setTypeface(Typeface.create("sans-serif-medium", Typeface.NORMAL));
            appNameView.setTextColor(ink);
            textCol.addView(appNameView);

            TextView appDescView = new TextView(activity);
            appDescView.setText(desc);
            appDescView.setTextSize(12);
            appDescView.setTextColor(muted);
            textCol.addView(appDescView);

            appRow.addView(textCol);

            Button actionBtn = new Button(activity);
            actionBtn.setText(isInstalled ? R.string.app_open : R.string.app_view);
            actionBtn.setTextSize(13);
            actionBtn.setAllCaps(false);
            actionBtn.setTypeface(Typeface.create("sans-serif-medium", Typeface.NORMAL));
            if (isInstalled) {
                actionBtn.setTextColor(Color.WHITE);
                actionBtn.setBackground(roundedBackground(action, action, 14, activity.getResources().getDisplayMetrics().density));
            } else {
                actionBtn.setTextColor(action);
                actionBtn.setBackground(roundedBackground(Color.TRANSPARENT, action, 14, activity.getResources().getDisplayMetrics().density));
            }
            actionBtn.setPadding(dp(activity, 12), dp(activity, 4), dp(activity, 12), dp(activity, 4));
            actionBtn.setOnClickListener(v -> {
                if (isInstalled) {
                    activity.startActivity(launchIntent);
                } else {
                    Intent browseIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    activity.startActivity(browseIntent);
                }
            });
            LinearLayout.LayoutParams btnParams = new LinearLayout.LayoutParams(-2, dp(activity, 36));
            btnParams.setMarginStart(dp(activity, 8));
            appRow.addView(actionBtn, btnParams);
            ecoCard.addView(appRow);
        }
        root.addView(ecoCard);

        // 3. Open Source & Sovereignty
        root.addView(createSectionHeader(activity, activity.getString(R.string.open_source_section), action));
        LinearLayout repoCard = createCardLayout(activity, dialogSurface, cardStroke);
        repoCard.addView(createActionRow(
                activity,
                R.drawable.ic_code,
                activity.getString(R.string.github_repo_label),
                "github.com/jpi59/ethic-keyboard",
                ink, muted, action,
                v -> activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/jpi59/ethic-keyboard")))
        ));
        repoCard.addView(createDivider(activity, cardStroke));
        repoCard.addView(createActionRow(
                activity,
                R.drawable.ic_code,
                activity.getString(R.string.gitlab_repo_label),
                "gitlab.com/jpi59/ethic-keyboard",
                ink, muted, action,
                v -> activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://gitlab.com/jpi59/ethic-keyboard")))
        ));
        repoCard.addView(createDivider(activity, cardStroke));
        repoCard.addView(createActionRow(
                activity,
                R.drawable.ic_info,
                activity.getString(R.string.license_label),
                activity.getString(R.string.license_desc),
                ink, muted, action,
                v -> showLicenseDialog(activity, darkMode, action, dialogSurface)
        ));
        root.addView(repoCard);

        // 4. Technical Integrity
        root.addView(createSectionHeader(activity, activity.getString(R.string.technical_info_section), action));
        LinearLayout techCard = createCardLayout(activity, dialogSurface, cardStroke);
        techCard.addView(createKeyValueRow(activity, activity.getString(R.string.package_id_label), activity.getPackageName(), ink, muted));
        techCard.addView(createDivider(activity, cardStroke));
        techCard.addView(createKeyValueRow(activity, activity.getString(R.string.key_fingerprint_label), getSigningCertificateSha256(activity), ink, muted));
        root.addView(techCard);

        ScrollView scroll = new ScrollView(activity);
        scroll.addView(root);

        AlertDialog dialog = new AlertDialog.Builder(activity)
                .setView(scroll)
                .setPositiveButton(R.string.done, null)
                .create();

        dialog.show();
        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(surface));
        }
        Button doneBtn = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
        if (doneBtn != null) {
            doneBtn.setTextColor(action);
            doneBtn.setTextSize(16);
            doneBtn.setTypeface(Typeface.create("sans-serif-medium", Typeface.NORMAL));
        }
    }

    public static void showLicenseDialog(Activity activity, boolean darkMode, int action, int surface) {
        AlertDialog d = new AlertDialog.Builder(activity)
                .setTitle(R.string.license_label)
                .setMessage("Ethic Keyboard · Copyright (C) 2026 jpi59\n\n" +
                        "This program is free software: you can redistribute it and/or modify " +
                        "it under the terms of the GNU General Public License as published by " +
                        "the Free Software Foundation, either version 3 of the License, or " +
                        "(at your option) any later version.\n\n" +
                        "This program is distributed in the hope that it will be useful, " +
                        "but WITHOUT ANY WARRANTY; without even the implied warranty of " +
                        "MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the " +
                        "GNU General Public License for more details.")
                .setPositiveButton(R.string.done, null)
                .create();
        d.show();
        if (d.getWindow() != null) {
            d.getWindow().setBackgroundDrawable(new ColorDrawable(surface));
        }
        Button b = d.getButton(AlertDialog.BUTTON_POSITIVE);
        if (b != null) b.setTextColor(action);
    }

    public static String getAppVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception ignored) {
            return "6.6.5";
        }
    }

    public static String getSigningCertificateSha256(Context context) {
        try {
            Signature[] signatures;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                PackageInfo pi = context.getPackageManager().getPackageInfo(
                        context.getPackageName(), PackageManager.GET_SIGNING_CERTIFICATES);
                SigningInfo si = pi.signingInfo;
                signatures = (si != null) ? (si.hasMultipleSigners() ? si.getApkContentsSigners() : si.getSigningCertificateHistory()) : null;
            } else {
                PackageInfo pi = context.getPackageManager().getPackageInfo(
                        context.getPackageName(), PackageManager.GET_SIGNATURES);
                signatures = pi.signatures;
            }
            if (signatures != null && signatures.length > 0) {
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                byte[] digest = md.digest(signatures[0].toByteArray());
                StringBuilder sb = new StringBuilder();
                for (byte b : digest) {
                    sb.append(String.format("%02x", b));
                }
                return sb.toString();
            }
        } catch (Exception ignored) { }
        return "No disponible";
    }

    private static TextView createSectionHeader(Context ctx, String text, int color) {
        TextView tv = new TextView(ctx);
        tv.setText(text.toUpperCase(Locale.ROOT));
        tv.setTextSize(12);
        tv.setTypeface(Typeface.create("sans-serif-medium", Typeface.NORMAL));
        tv.setTextColor(color);
        tv.setLetterSpacing(0.08f);
        tv.setPadding(0, dp(ctx, 14), 0, dp(ctx, 6));
        return tv;
    }

    private static LinearLayout createCardLayout(Context ctx, int fill, int stroke) {
        LinearLayout layout = new LinearLayout(ctx);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setBackground(roundedBackground(fill, stroke, 14, ctx.getResources().getDisplayMetrics().density));
        layout.setPadding(dp(ctx, 14), dp(ctx, 10), dp(ctx, 14), dp(ctx, 10));
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(-1, -2);
        params.bottomMargin = dp(ctx, 4);
        layout.setLayoutParams(params);
        return layout;
    }

    private static View createDivider(Context ctx, int stroke) {
        View v = new View(ctx);
        v.setBackgroundColor(stroke);
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(-1, dp(ctx, 1));
        p.topMargin = dp(ctx, 6);
        p.bottomMargin = dp(ctx, 6);
        v.setLayoutParams(p);
        return v;
    }

    private static View createActionRow(Context ctx, int iconRes, String title, String desc, int ink, int muted, int action, View.OnClickListener listener) {
        LinearLayout row = new LinearLayout(ctx);
        row.setOrientation(LinearLayout.HORIZONTAL);
        row.setGravity(Gravity.CENTER_VERTICAL);
        row.setPadding(0, dp(ctx, 8), 0, dp(ctx, 8));
        row.setClickable(true);
        row.setFocusable(true);

        ImageView icon = new ImageView(ctx);
        Drawable d = ctx.getDrawable(iconRes);
        if (d != null) {
            d = d.mutate();
            d.setTint(action);
            icon.setImageDrawable(d);
        }
        LinearLayout.LayoutParams iconParams = new LinearLayout.LayoutParams(dp(ctx, 24), dp(ctx, 24));
        iconParams.setMarginEnd(dp(ctx, 12));
        row.addView(icon, iconParams);

        LinearLayout textCol = new LinearLayout(ctx);
        textCol.setOrientation(LinearLayout.VERTICAL);
        textCol.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1f));

        TextView tvTitle = new TextView(ctx);
        tvTitle.setText(title);
        tvTitle.setTextSize(15);
        tvTitle.setTypeface(Typeface.create("sans-serif-medium", Typeface.NORMAL));
        tvTitle.setTextColor(ink);
        textCol.addView(tvTitle);

        if (desc != null && !desc.isEmpty()) {
            TextView tvDesc = new TextView(ctx);
            tvDesc.setText(desc);
            tvDesc.setTextSize(12);
            tvDesc.setTextColor(muted);
            textCol.addView(tvDesc);
        }
        row.addView(textCol);

        ImageView openIcon = new ImageView(ctx);
        Drawable arrow = ctx.getDrawable(R.drawable.ic_open_app);
        if (arrow != null) {
            arrow = arrow.mutate();
            arrow.setTint(muted);
            openIcon.setImageDrawable(arrow);
        }
        LinearLayout.LayoutParams arrowParams = new LinearLayout.LayoutParams(dp(ctx, 18), dp(ctx, 18));
        arrowParams.setMarginStart(dp(ctx, 8));
        row.addView(openIcon, arrowParams);

        row.setOnClickListener(listener);
        return row;
    }

    private static View createKeyValueRow(Context ctx, String key, String value, int ink, int muted) {
        LinearLayout row = new LinearLayout(ctx);
        row.setOrientation(LinearLayout.VERTICAL);
        row.setPadding(0, dp(ctx, 6), 0, dp(ctx, 6));

        TextView tvKey = new TextView(ctx);
        tvKey.setText(key);
        tvKey.setTextSize(12);
        tvKey.setTypeface(Typeface.create("sans-serif-medium", Typeface.NORMAL));
        tvKey.setTextColor(muted);
        row.addView(tvKey);

        TextView tvVal = new TextView(ctx);
        tvVal.setText(value);
        tvVal.setTextSize(13);
        tvVal.setTypeface(Typeface.create("sans-serif", Typeface.NORMAL));
        tvVal.setTextColor(ink);
        row.addView(tvVal);
        return row;
    }

    private static Drawable roundedBackground(int fillColor, int strokeColor, int cornerRadiusDp, float density) {
        GradientDrawable drawable = new GradientDrawable();
        drawable.setColor(fillColor);
        drawable.setCornerRadius(cornerRadiusDp * density);
        drawable.setStroke(Math.round(1 * density), strokeColor);
        return drawable;
    }

    private static int dp(Context ctx, int dp) {
        return Math.round(dp * ctx.getResources().getDisplayMetrics().density);
    }
}
