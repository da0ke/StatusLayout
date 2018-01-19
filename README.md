# StatusLayout
show loading or empty or error or progress view for android

```
maven { url 'https://jitpack.io' }
```
```
implementation 'com.github.da0ke:StatusLayout:1.1.0'
```

```
<FrameLayout
    android:layout_width="match_parent"
    android:layout_height="match_parent">
        <TextView
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:gravity="center"
            android:text="Hello World!"/>

        <cn.da0ke.statuslayout.StatusLayout
            android:id="@+id/statusLayout"
            android:layout_width="match_parent"
            android:layout_height="match_parent"/>
</FrameLayout>
```

```
StatusLayout statusLayout = findViewById(R.id.statusLayout);


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
    statusLayout.setOnErrorClickListener(new ErrorClickListener() {
        @Override
        public void errorClick() {
            dataTask();
        }
    });
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
    Toast.makeText(this,"dataTask()",Toast.LENGTH_SHORT).show();
}
```
