package cn.da0ke.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import cn.da0ke.statuslayout.StatusLayout;

public class MainActivity extends AppCompatActivity {

    private StatusLayout statusLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        statusLayout = findViewById(R.id.statusLayout);
        statusLayout.hide();

        findViewById(R.id.loading).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loading();
            }
        });

        findViewById(R.id.empty).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                empty();
            }
        });

        findViewById(R.id.error).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                error();
            }
        });

        findViewById(R.id.progress).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progress();
            }
        });

        findViewById(R.id.hide).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hide();
            }
        });

        findViewById(R.id.msg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customEmpty();
            }
        });
    }

    private void customEmpty() {
        statusLayout.showEmpty("自定义文字");
    }

    /**
     * show loading view
     */
    private void loading() {
        statusLayout.showLoading();
    }

    /**
     * show empty view
     */
    private void empty() {
        statusLayout.showEmpty();
    }

    /**
     * show error view
     */
    private void error() {
        statusLayout.showError();
        statusLayout.errorClick(this,"dataTask");
    }

    /**
     * show progress view
     */
    private void progress() {
        statusLayout.showProgress();
    }

    /**
     * hide statusLayout
     */
    private void hide() {
        statusLayout.hide();
    }

    private void dataTask() {
        Toast.makeText(this,"error click",Toast.LENGTH_LONG).show();
    }
}
