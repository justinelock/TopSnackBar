package choi.ccb.com.snackbardemo;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.material.snackbar.Snackbar;
import com.kongzue.dialog.v3.Notification;
import com.yw.game.floatmenu.FloatItem;

import java.util.ArrayList;
import java.util.List;

import choi.ccb.com.snackbardemo.utils.TopWindowUtils;
import choi.ccb.com.topsnackbarlibrary.TopSnackbar;
import de.keyboardsurfer.android.widget.crouton.Crouton;

public class MainActivity extends BaseActivity {

    private LinearLayout rlRoot;

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    private List<FloatItem> itemList = new ArrayList<>();

    @Override
    protected void initView() {
        for (int i = 0; i < 2; i++) {
            itemList.add(new FloatItem("ccb", 0x99000000, 0x99000000, BitmapFactory.decodeResource(this.getResources(), R.drawable.ic_launcher_background), String.valueOf(i + 1)));
        }


        final Button btn = findViewById(R.id.btn);
        rlRoot = findViewById(R.id.rl);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TopSnackbar.make(rlRoot, "我是在顶部弹出的", 6000).show();
            }
        });
        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                start(A1.class);
                TopSnackbar.make(getDecorView(), "你看看\n我是在最顶部弹出的", 6000).show();
            }
        });
        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iii();
            }
        });
        findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                start(A1.class);
                ///
            }

        });

        findViewById(R.id.btn4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Notification.show(mContext, "你好啊");
            }
        });
        findViewById(R.id.btn5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TopWindowUtils.show(MainActivity.this, ++sign + "个任务下载完成");
            }

        });
        findViewById(R.id.btnCrouton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Crouton.makeText((Activity) mContext, "你好\n中国", de.keyboardsurfer.android.widget.crouton.Style.INFO).show();
            }

        });
    }

    private int sign = 0;

    private void iii() {
        Snackbar.make(rlRoot, "普通Snackbar", 6000).show();
    }


    /**
     * 从dp单位转换为px
     *
     * @param dp dp值
     * @return 返回转换后的px值
     */
    private int dp2px(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }
}
