package android.tool;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.URLSpan;
import android.widget.TextView;


/**
 * Created by asus-wh on 2017/10/8.
 */
@SuppressLint("ParcelCreator")
public class NoUnderlineSpan extends URLSpan {
    public NoUnderlineSpan(String url){
        super(url);
    }
    @Override
    public void updateDrawState(TextPaint ds){
        if(ds!=null){
            ds.setColor(Color.rgb(255,0,0));
            ds.setUnderlineText(false);
        }
    }
    public static void TripUbderLine(TextView textView){
        if (textView.getText() instanceof Spannable) {
            URLSpan[] urlSpans = (((Spannable) textView.getText()).getSpans(0, textView.getText().length() - 1, URLSpan.class));
            for (URLSpan urlSpan : urlSpans) {
                String url = urlSpan.getURL();
                int start = ((Spannable) textView.getText()).getSpanStart(urlSpan);
                int end = ((Spannable) textView.getText()).getSpanEnd(urlSpan);
                NoUnderlineSpan noUnderlineSpan = new NoUnderlineSpan(url);
                Spannable s = (Spannable) textView.getText();
                s.setSpan(noUnderlineSpan, start, end, Spanned.SPAN_POINT_MARK);
            }
        }
    }
}
