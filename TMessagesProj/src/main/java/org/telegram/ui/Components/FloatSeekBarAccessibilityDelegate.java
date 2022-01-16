package org.telegram.ui.Components;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

import androidx.annotation.Nullable;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

import tw.nekomimi.nekogram.accessibility.AccConfig;

public abstract class FloatSeekBarAccessibilityDelegate extends SeekBarAccessibilityDelegate {

    private final boolean setPercentsEnabled;

    public FloatSeekBarAccessibilityDelegate() {
        this(false);
    }

    public FloatSeekBarAccessibilityDelegate(boolean setPercentsEnabled) {
        this.setPercentsEnabled = setPercentsEnabled;
    }

    @Override
    public void onInitializeAccessibilityNodeInfoInternal(@Nullable View host, AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfoInternal(host, info);
        if (setPercentsEnabled) {
            final AccessibilityNodeInfoCompat infoCompat = AccessibilityNodeInfoCompat.wrap(info);
            infoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SET_PROGRESS);
            infoCompat.setRangeInfo(AccessibilityNodeInfoCompat.RangeInfoCompat.obtain(AccessibilityNodeInfoCompat.RangeInfoCompat.RANGE_TYPE_FLOAT, getMinValue(), getMaxValue(), getProgress()));
        }
    }

    @Override
    public boolean performAccessibilityActionInternal(@Nullable View host, int action, Bundle args) {
        if (super.performAccessibilityActionInternal(host, action, args)) {
            return true;
        }
        if (action == AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SET_PROGRESS.getId()) {
            setProgress(args.getFloat(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE));
            return true;
        }
        return false;
    }

    @Override
    protected void doScroll(View host, boolean backward) {
        float delta = getDelta();
        if (backward) {
            delta *= -1f;
        }
        setProgress(Math.min(getMaxValue(), Math.max(getMinValue(), getProgress() + delta)));
    }

    @Override
    protected boolean canScrollBackward(View host) {
        return getProgress() > getMinValue();
    }

    @Override
    protected boolean canScrollForward(View host) {
        return getProgress() < getMaxValue();
    }

    @Override
    public void onInitializeAccessibilityEvent(View host, AccessibilityEvent event) {
        super.onInitializeAccessibilityEvent(host, event);
        if (AccConfig.SHOW_NUMBERS_OF_ITEMS || event.getEventType() == AccessibilityEvent.TYPE_ANNOUNCEMENT) event.setItemCount((int)((getMaxValue() - getMinValue()) * 100));
        if (AccConfig.SHOW_INDEX_OF_ITEM || event.getEventType() == AccessibilityEvent.TYPE_ANNOUNCEMENT) event.setCurrentItemIndex((int) (getProgress() * 100));
    }

    protected abstract float getProgress();

    protected abstract void setProgress(float progress);

    protected float getMinValue() {
        return 0f;
    }

    protected float getMaxValue() {
        return 1f;
    }

    protected float getDelta() {
        return 0.01f;
    }
}
