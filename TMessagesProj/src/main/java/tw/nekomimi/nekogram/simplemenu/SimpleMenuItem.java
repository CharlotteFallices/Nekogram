package tw.nekomimi.nekogram.simplemenu;

import android.content.Context;
import android.graphics.Canvas;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.TextView;

import org.telegram.messenger.AndroidUtilities;
import org.telegram.ui.ActionBar.Theme;

public class SimpleMenuItem extends TextView {
    private boolean isSelected;

    public SimpleMenuItem(Context context) {
        super(context);
        setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        setTextColor(Theme.getColor(Theme.key_actionBarDefaultSubmenuItem));
        setMinimumHeight(AndroidUtilities.dp(48));
        setGravity(Gravity.CENTER_VERTICAL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (isSelected) {
            canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), Theme.dialogs_tabletSeletedPaint);
        }
    }

    public void setTextAndCheck(CharSequence text, boolean selected, boolean multiline, int padding) {
        setText(text);
        isSelected = selected;
        setMaxLines(multiline ? Integer.MAX_VALUE : 1);
        setPadding(padding, AndroidUtilities.dp(8), padding, AndroidUtilities.dp(8));
    }
}
