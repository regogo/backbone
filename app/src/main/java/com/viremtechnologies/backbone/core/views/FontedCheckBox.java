package com.viremtechnologies.backbone.core.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.CheckBox;

import com.viremtechnologies.backbone.R;


public class FontedCheckBox extends CheckBox {
    private AttributeSet attrs;

    public FontedCheckBox(Context context) {
        super(context);
        init(null);

        this.attrs = null;
    }

    public FontedCheckBox(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);

        this.attrs = attrs;
    }

    public FontedCheckBox(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);

        this.attrs = attrs;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public FontedCheckBox(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);

        this.attrs = attrs;
    }

    /**
     * @param attrs
     */
    private void init(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.CustomFont);

            String fontName = a.getString(R.styleable.CustomFont_fontName);

            if (fontName != null) {
                Typeface myTypeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/" + fontName);
                setTypeface(myTypeface);
            } else {
                Typeface myTypeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/Gotham-Light.otf");
                setTypeface(myTypeface);
            }
            a.recycle();
        }
    }
}
