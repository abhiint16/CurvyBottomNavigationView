package abhiint.com.curvybottomnavigationview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.support.design.widget.BottomNavigationView;
import android.util.AttributeSet;

public class CustomBottomNavigationView extends BottomNavigationView {
    private Path mPath, mPath1, mPath2, mPath3, mPath4, mPath5, mPath6, mPath7, mPath8;
    private Paint mPaint, mPaint1, mPaint2, mPaint3, mPaint4, mPaint5, mPaint6, mPaint7, mPaint8;

    /**
     * the CURVE_CIRCLE_RADIUS represent the radius of the fab button
     */
    private final int CURVE_CIRCLE_RADIUS = 256 / 4;
    // the coordinates of the first curve
    private Point mFirstCurveStartPoint = new Point();
    private Point mFirstCurveEndPoint = new Point();
    private Point mFirstCurveControlPoint1 = new Point();
    private Point mFirstCurveControlPoint2 = new Point();

    //the coordinates of the second curve
    @SuppressWarnings("FieldCanBeLocal")
    private Point mSecondCurveStartPoint = new Point();
    private Point mSecondCurveEndPoint = new Point();
    private Point mSecondCurveControlPoint1 = new Point();
    private Point mSecondCurveControlPoint2 = new Point();
    private int mNavigationBarWidth;
    private int mNavigationBarHeight;

    public CustomBottomNavigationView(Context context) {
        super(context);
        init();
    }

    public CustomBottomNavigationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomBottomNavigationView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPath = new Path();
        mPath1 = new Path();
        mPath2 = new Path();
        mPath3 = new Path();
        mPath4 = new Path();
        mPath5 = new Path();
        mPath6 = new Path();
        mPath7 = new Path();
        mPath8 = new Path();
        mPaint = new Paint();
        mPaint1 = new Paint();
        mPaint2 = new Paint();
        mPaint3 = new Paint();
        mPaint4 = new Paint();
        mPaint5 = new Paint();
        mPaint6 = new Paint();
        mPaint7 = new Paint();
        mPaint8 = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint1.setStyle(Paint.Style.STROKE);
        mPaint2.setStyle(Paint.Style.STROKE);
        mPaint3.setStyle(Paint.Style.STROKE);
        mPaint4.setStyle(Paint.Style.STROKE);
        mPaint5.setStyle(Paint.Style.STROKE);
        mPaint6.setStyle(Paint.Style.STROKE);
        mPaint7.setStyle(Paint.Style.STROKE);
        mPaint8.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.RED);
        mPaint1.setColor(Color.GREEN);
        mPaint2.setColor(Color.WHITE);
        mPaint3.setColor(Color.BLUE);
        mPaint4.setColor(Color.YELLOW);
        mPaint5.setColor(Color.MAGENTA);
        mPaint6.setColor(Color.CYAN);
        mPaint7.setColor(Color.LTGRAY);
        mPaint8.setColor(Color.DKGRAY);
        setBackgroundColor(Color.TRANSPARENT);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        // get width and height of navigation bar
        // Navigation bar bounds (width & height)
        mNavigationBarWidth = getWidth();
        mNavigationBarHeight = getHeight();
        // the coordinates (x,y) of the start point before curve
        mFirstCurveStartPoint.set((mNavigationBarWidth / 2) - (CURVE_CIRCLE_RADIUS * 2) - (CURVE_CIRCLE_RADIUS / 3), 0);
        // the coordinates (x,y) of the end point after curve
        mFirstCurveEndPoint.set(mNavigationBarWidth / 2, CURVE_CIRCLE_RADIUS + (CURVE_CIRCLE_RADIUS / 4));
        // same thing for the second curve
        mSecondCurveStartPoint = mFirstCurveEndPoint;
        mSecondCurveEndPoint.set((mNavigationBarWidth / 2) + (CURVE_CIRCLE_RADIUS * 2) + (CURVE_CIRCLE_RADIUS / 3), 0);

        // the coordinates (x,y)  of the 1st control point on a cubic curve
        mFirstCurveControlPoint1.set(mFirstCurveStartPoint.x + CURVE_CIRCLE_RADIUS + (CURVE_CIRCLE_RADIUS / 4), mFirstCurveStartPoint.y);
        // the coordinates (x,y)  of the 2nd control point on a cubic curve
        mFirstCurveControlPoint2.set(mFirstCurveEndPoint.x - (CURVE_CIRCLE_RADIUS * 2) + CURVE_CIRCLE_RADIUS, mFirstCurveEndPoint.y);

        mSecondCurveControlPoint1.set(mSecondCurveStartPoint.x + (CURVE_CIRCLE_RADIUS * 2) - CURVE_CIRCLE_RADIUS, mSecondCurveStartPoint.y);
        mSecondCurveControlPoint2.set(mSecondCurveEndPoint.x - (CURVE_CIRCLE_RADIUS + (CURVE_CIRCLE_RADIUS / 4)), mSecondCurveEndPoint.y);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPath.reset();
        mPath.moveTo(0, 0);
        mPath.lineTo(mFirstCurveStartPoint.x, mFirstCurveStartPoint.y);
        mPath1.addCircle(mFirstCurveStartPoint.x, mFirstCurveStartPoint.y, 1, Path.Direction.CCW);
        mPath1.addRect(mFirstCurveStartPoint.x - 0.5f, mFirstCurveStartPoint.y - 0.5f,
                mFirstCurveStartPoint.x + 0.5f, mFirstCurveStartPoint.y + 0.5f, Path.Direction.CCW);

        mPath.cubicTo(mFirstCurveControlPoint1.x, mFirstCurveControlPoint1.y,
                mFirstCurveControlPoint2.x, mFirstCurveControlPoint2.y,
                mFirstCurveEndPoint.x, mFirstCurveEndPoint.y);
        mPath2.addCircle(mFirstCurveControlPoint1.x, mFirstCurveControlPoint1.y, 1, Path.Direction.CCW);
        mPath2.addRect(mFirstCurveControlPoint1.x - 0.5f, mFirstCurveControlPoint1.y - 0.5f,
                mFirstCurveControlPoint1.x + 0.5f, mFirstCurveControlPoint1.y + 0.5f, Path.Direction.CCW);

        mPath3.addCircle(mFirstCurveControlPoint2.x, mFirstCurveControlPoint2.y, 1, Path.Direction.CCW);
        mPath3.addRect(mFirstCurveControlPoint2.x - 0.5f, mFirstCurveControlPoint2.y - 0.5f,
                mFirstCurveControlPoint2.x + 0.5f, mFirstCurveControlPoint2.y + 0.5f, Path.Direction.CCW);

        mPath4.addCircle(mFirstCurveEndPoint.x, mFirstCurveEndPoint.y, 1, Path.Direction.CCW);
        mPath4.addRect(mFirstCurveEndPoint.x - 0.5f, mFirstCurveEndPoint.y - 0.5f,
                mFirstCurveEndPoint.x + 0.5f, mFirstCurveEndPoint.y + 0.5f, Path.Direction.CCW);

        mPath.cubicTo(mSecondCurveControlPoint1.x, mSecondCurveControlPoint1.y,
                mSecondCurveControlPoint2.x, mSecondCurveControlPoint2.y,
                mSecondCurveEndPoint.x, mSecondCurveEndPoint.y);

        mPath5.addCircle(mSecondCurveControlPoint1.x, mSecondCurveControlPoint1.y, 1, Path.Direction.CCW);
        mPath5.addRect(mSecondCurveControlPoint1.x - 0.5f, mSecondCurveControlPoint1.y - 0.5f,
                mSecondCurveControlPoint1.x + 0.5f, mSecondCurveControlPoint1.y + 0.5f, Path.Direction.CCW);

        mPath6.addCircle(mSecondCurveControlPoint2.x, mSecondCurveControlPoint2.y, 1, Path.Direction.CCW);
        mPath6.addRect(mSecondCurveControlPoint2.x - 0.5f, mSecondCurveControlPoint2.y - 0.5f,
                mSecondCurveControlPoint2.x + 0.5f, mSecondCurveControlPoint2.y + 0.5f, Path.Direction.CCW);

        mPath7.addCircle(mSecondCurveEndPoint.x, mSecondCurveEndPoint.y, 1, Path.Direction.CCW);
        mPath7.addRect(mSecondCurveEndPoint.x - 0.5f, mSecondCurveEndPoint.y - 0.5f,
                mSecondCurveEndPoint.x + 0.5f, mSecondCurveEndPoint.y + 0.5f, Path.Direction.CCW);

        mPath.lineTo(mNavigationBarWidth, 0);

        mPath7.addCircle(mNavigationBarWidth, 0, 1, Path.Direction.CCW);
        mPath7.addRect(mNavigationBarWidth - 0.5f, 0 - 0.5f,
                mNavigationBarWidth + 0.5f, 0 + 0.5f, Path.Direction.CCW);

        mPath.lineTo(mNavigationBarWidth, mNavigationBarHeight);

        mPath7.addCircle(mNavigationBarWidth, mNavigationBarHeight, 1, Path.Direction.CCW);
        mPath7.addRect(mNavigationBarWidth - 0.5f, mNavigationBarHeight - 0.5f,
                mNavigationBarWidth + 0.5f, mNavigationBarHeight + 0.5f, Path.Direction.CCW);

        mPath.lineTo(0, mNavigationBarHeight);

        mPath7.addCircle(0, mNavigationBarHeight, 1, Path.Direction.CCW);
        mPath7.addRect(0 - 0.5f, mNavigationBarHeight - 0.5f,
                0 + 0.5f, mNavigationBarHeight + 0.5f, Path.Direction.CCW);

        mPath.close();
        mPath1.close();
        mPath2.close();
        mPath3.close();
        mPath4.close();
        mPath5.close();
        mPath6.close();
        mPath7.close();
        mPath8.close();

        canvas.drawPath(mPath, mPaint);
        canvas.drawPath(mPath1, mPaint1);
        canvas.drawPath(mPath2, mPaint2);
        canvas.drawPath(mPath3, mPaint3);
        canvas.drawPath(mPath4, mPaint4);
        canvas.drawPath(mPath5, mPaint5);
        canvas.drawPath(mPath6, mPaint6);
        canvas.drawPath(mPath7, mPaint7);
        canvas.drawPath(mPath8, mPaint8);
    }
}
