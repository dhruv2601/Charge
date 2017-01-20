package isgw.isgw.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.thefinestartist.finestwebview.FinestWebView;

import java.io.InputStream;

import isgw.isgw.R;

import static com.thefinestartist.finestwebview.R.id.url;

public class CarbonActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carbon);

        getSupportActionBar().hide();

        new FinestWebView.Builder(this).show("https://kathylovan.github.io/carbon-footprint-calculator/");

    }

    private void injectCSS() {
        try {
            InputStream inputStream = getAssets().open("style.css");
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            inputStream.close();
            String encoded = Base64.encodeToString(buffer, Base64.NO_WRAP);
            webView.loadUrl("javascript:(function() {" +
                    "var parent = document.getElementsByTagName('head').item(0);" +
                    "var style = document.createElement('style');" +
                    "style.type = 'text/css';" +
                    // Tell the browser to BASE64-decode the string into your script !!!
                    "style.innerHTML = window.atob('" + encoded + "');" +
                    "parent.appendChild(style)" +
                    "})()");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
