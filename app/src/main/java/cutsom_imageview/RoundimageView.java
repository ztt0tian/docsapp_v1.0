package cutsom_imageview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Region;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by asus-wh on 2017/10/5.
 */

public class RoundimageView extends ImageView {
    private Bitmap bitmap;
    private Rect rect=new Rect();
    private PaintFlagsDrawFilter pdf=new PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG);
    private Paint paint=new Paint();
    private Path path=new Path();

    public RoundimageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
       init();
    }
    public void setBitmap(Bitmap mbitmap){
        this.bitmap=mbitmap;
    }
    private void init(){
        paint.setStyle(Paint.Style.STROKE);
        paint.setFlags(Paint.ANTI_ALIAS_FLAG);
        paint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(bitmap==null){
            return;
        }
        rect.set(0,0,getWidth(),getHeight());
        canvas.save();
        canvas.setDrawFilter(pdf);
        path.addCircle(getWidth()/2,getWidth()/2,getHeight()/2,Path.Direction.CCW);
        canvas.clipPath(path, Region.Op.REPLACE);
        canvas.drawBitmap(bitmap,null,rect,paint);
        canvas.restore();
    }
}
