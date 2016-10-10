package com.example.yu.work5_alertdialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv1;
    private AlertDialog adialog;
    private AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = (TextView) findViewById(R.id.textview);
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        Button button6 = (Button) findViewById(R.id.button6);
        Button button7 = (Button) findViewById(R.id.button7);

        View.OnClickListener  listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()){
                    case R.id.button1:
                        dialog1();
                        break;
                    case R.id.button2:
                        dialog2();
                        break;
                    case R.id.button3:
                        dialog3();
                        break;
                    case R.id.button4:
                        dialog4();
                        break;
                    case R.id.button5:
                        dialog5();
                        break;
                    case R.id.button6:
                        dialog6();
                        break;
                    case R.id.button7:
                        dialog7();
                        break;
                }
            }
        };

        button1.setOnClickListener(listener);
        button2.setOnClickListener(listener);
        button3.setOnClickListener(listener);
        button4.setOnClickListener(listener);
        button5.setOnClickListener(listener);
        button6.setOnClickListener(listener);
        button7.setOnClickListener(listener);
    }
    public void dialog1(){
        adialog = new AlertDialog.Builder(this).create();
        adialog.setTitle("提示");
        adialog.setMessage("确认退出吗？");
        adialog.setIcon(android.R.drawable.ic_dialog_alert);
        DialogInterface.OnClickListener listen = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(which==DialogInterface.BUTTON_POSITIVE){
                    adialog.dismiss();
                    MainActivity.this.finish();
                }else if(which == DialogInterface.BUTTON_NEGATIVE){
                    adialog.dismiss();
                }
            }
        };
        adialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listen);
        adialog.setButton(DialogInterface.BUTTON_NEUTRAL,"取消",listen);
        adialog.show();
    }
    public void dialog2(){
        adialog = new AlertDialog.Builder(this).create();
        adialog.setTitle("调查");
        adialog.setMessage("你平时忙吗");
        adialog.setIcon(android.R.drawable.ic_dialog_info);
        DialogInterface.OnClickListener listen = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               String str ="";
                switch(which){
                    case DialogInterface.BUTTON_POSITIVE:
                        str="平时很忙";
                        break;
                    case DialogInterface.BUTTON_NEUTRAL:
                        str="平时一般咯";
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        str="平时轻松咯";
                        break;
                }
                tv1.setText(str);
            }
        };
        adialog.setButton(DialogInterface.BUTTON_POSITIVE,"忙死了",listen);
        adialog.setButton(DialogInterface.BUTTON_NEUTRAL,"一般般",listen);
        adialog.setButton(DialogInterface.BUTTON_NEGATIVE,"闲",listen);
        adialog.show();
    }
    public void dialog3(){
        adialog = new AlertDialog.Builder(this).create();
        adialog.setTitle("请输入：");
        adialog.setMessage("你平时忙吗?");
        adialog.setIcon(android.R.drawable.ic_dialog_info);
        final EditText tEdit = new EditText(this);
        adialog.setView(tEdit);
        DialogInterface.OnClickListener listen = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv1.setText("输入的是："+tEdit.getText().toString());
            }
        };
        adialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listen);
        adialog.show();
    }
    public void dialog4(){
       final String item[] = new String[]{"北","上","广"};
       final boolean bSelect[] = new boolean[item.length];
       DialogInterface.OnMultiChoiceClickListener mListen = new DialogInterface.OnMultiChoiceClickListener() {
           @Override
           public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                bSelect[which] = isChecked;
           }
       };
        builder = new AlertDialog.Builder(this);
        builder.setMultiChoiceItems(item,null,mListen);
        adialog =builder.create();
        adialog.setTitle("复选框");
        DialogInterface.OnClickListener listen = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = "你选择了";
                for(int i =0;i<bSelect.length;i++){
                    if(bSelect[i]){
                        str = str + "\n"+ item[i];
                    }
                }
                tv1.setText(str);
            }
        };
        adialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listen);
        adialog.show();

    }
    public void dialog5(){
        final String item[] = new String[]{"北","上","广"};
        final boolean bSelect[] = new boolean[item.length];
        DialogInterface.OnClickListener sListen = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                bSelect[which]=true;
            }
        };
        builder = new AlertDialog.Builder(this);
        builder.setSingleChoiceItems(item,-1,sListen);
        adialog = builder.create();
        adialog.setTitle("单选框");
        DialogInterface.OnClickListener listen = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = "你选择了";
                for(int i =0;i<bSelect.length;i++){
                    if(bSelect[i]){
                        str = str + "\n"+ item[i];
                    }
                }
                tv1.setText(str);
            }
        };
        adialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listen);
        adialog.show();
    }
    public void dialog6(){
        final String item[] = new String[]{"北","上","广"};
        final boolean bSelect[] = new boolean[item.length];
        DialogInterface.OnClickListener listen = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = "你选择了:"+item[which];
                tv1.setText(str);
            }
        };
        builder= new AlertDialog.Builder(this);
        builder.setItems(item,listen);
        adialog= builder.create();
        adialog.setTitle("列表框");
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                adialog.dismiss();
            }
        };
        adialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",listener);
        adialog.show();
    }
    public void dialog7(){
        LayoutInflater inflater = getLayoutInflater();
        View layout =inflater.inflate(R.layout.diydialog,null);
        final EditText tEdit = (EditText) layout.findViewById(R.id.edit);
        adialog = new AlertDialog.Builder(this).create();
        adialog.setTitle("自定义布局");
        adialog.setView(layout);
        DialogInterface.OnClickListener listen = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv1.setText("输入"+tEdit.getText().toString());
            }
        };
        adialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listen);
        adialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",listen);
        adialog.show();
    }

}
