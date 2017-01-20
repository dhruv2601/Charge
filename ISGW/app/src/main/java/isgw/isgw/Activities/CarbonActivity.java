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


}
