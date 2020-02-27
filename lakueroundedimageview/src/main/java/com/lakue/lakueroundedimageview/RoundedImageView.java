package com.lakue.lakueroundedimageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

public class RoundedImageView extends ImageView {

    // 라운드처리 강도 값을 크게하면 라운드 범위가 커짐

    RectF roundRect = new RectF();
    Paint maskPaint = new Paint();
    Paint zonePaint = new Paint();
    float rectRadius = 7f;

    public RoundedImageView(Context context) {
        super(context);
        initView();
    }

    public RoundedImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(attrs);
    }

    public RoundedImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView(attrs);
    }

    private void initView() {
        maskPaint.setAntiAlias(true);
        maskPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        zonePaint.setAntiAlias(true);
        zonePaint.setColor(Color.WHITE);
        float density = getResources().getDisplayMetrics().density;
        rectRadius *= density;
    }

    private void initView(AttributeSet attrs) {
        TypedArray type = getContext().obtainStyledAttributes(attrs,
                R.styleable.RoundedImageView);
        rectRadius = type.getFloat(R.styleable.RoundedImageView_rectRadius,7.0f);

        maskPaint.setAntiAlias(true);
        maskPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        zonePaint.setAntiAlias(true);
        zonePaint.setColor(Color.WHITE);
        float density = getResources().getDisplayMetrics().density;
        rectRadius *= density;
    }

    public void setRectRadius(Float radius){
        this.rectRadius = radius;
        invalidate();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        roundRect.set(0f, 0f, (float) getWidth(), (float) getHeight());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Path clipPath = new Path();
        RectF rect = new RectF(0, 0, this.getWidth(), this.getHeight());
        clipPath.addRoundRect(rect, rectRadius, rectRadius, Path.Direction.CW);
        canvas.clipPath(clipPath);
        super.onDraw(canvas);
    }
}