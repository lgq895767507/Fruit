package com.fruitgrower.fruitgrower.view.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.fruitgrower.fruitgrower.R;
import com.fruitgrower.fruitgrower.presenter.bmob.IMessagePresenter;
import com.fruitgrower.fruitgrower.presenter.bmob.MessagePresenter;
import com.fruitgrower.fruitgrower.view.utils.DialogUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PublishActivity extends BaseActivity {

    @BindView(R.id.messageEdit)
    public EditText messageEdit;
    @BindView(R.id.leaveTextCount)
    public TextView leaveTextCount;

    private IMessagePresenter messagePresenter;
    private static final int MAX_TEXT_LENGTH = 99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish);
        ButterKnife.bind(this);
        init();
        calculateLeaveTextlength();
    }

    private void init() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getString(R.string.publish_message));
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }
        messagePresenter = new MessagePresenter();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_button, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.publish) {
            if (TextUtils.isEmpty(messageEdit.getText().toString())) {
                DialogUtils dialogUtils = new DialogUtils(this);
                dialogUtils.createDialog(getString(R.string.content_no_null), getString(R.string.confirm), new DialogUtils.CallBack1() {
                    @Override
                    public void confirm(DialogInterface dialogInterface) {
                        dialogInterface.dismiss();
                    }
                }).show();
            } else {
                messagePresenter.saveMessage(messageEdit.getText().toString());
                finish();
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onSupportNavigateUp() {
        //需要覆盖此方法才会关闭当前activity
        finish();
        return super.onSupportNavigateUp();
    }

    private void calculateLeaveTextlength() {
        messageEdit.setFilters(new InputFilter[]{new InputFilter.LengthFilter(MAX_TEXT_LENGTH)});
        messageEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                leaveTextCount.setText(String.format(getString(R.string.text_content_one), (MAX_TEXT_LENGTH - messageEdit.getText().length())));
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}
