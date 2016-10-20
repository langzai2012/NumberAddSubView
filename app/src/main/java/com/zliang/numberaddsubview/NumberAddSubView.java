package com.zliang.numberaddsubview;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/10/20 0020.
 */
public class NumberAddSubView extends LinearLayout implements View.OnClickListener {
    private LayoutInflater mInflater;
    private Button mBtnAdd;
    private Button mBtnSub;
    private TextView mTvNumber;

    private int value;
    private int minValue;
    private int maxValue;
    private OnButtonClickListener mListener;


    public NumberAddSubView(Context context) {
        this(context, null);
    }

    public NumberAddSubView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NumberAddSubView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        mInflater = LayoutInflater.from(context);
        View view = mInflater.inflate(R.layout.number_add_sub_view, this, true);
        mBtnAdd = (Button) view.findViewById(R.id.btn_add);
        mBtnSub = (Button) view.findViewById(R.id.btn_sub);
        mTvNumber = (TextView) view.findViewById(R.id.tv_number);
        mBtnAdd.setOnClickListener(this);
        mBtnSub.setOnClickListener(this);
    }

    public int getValue() {
        String val = mTvNumber.getText().toString();
        if (!TextUtils.isEmpty(val)) {
            this.value = Integer.parseInt(val);
        }
        return this.value;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_add) {
            numberAdd();
            if (mListener != null) {
                mListener.onButtonAddClick(v, getValue());
            }
        } else if (v.getId() == R.id.btn_sub) {

        }
    }

    private void numberAdd() {
        if (value < maxValue) {
            value += 1;
        }
        mTvNumber.setText(value + "");
    }

    public interface OnButtonClickListener {
        void onButtonAddClick(View view, int value);

        void onButtonSubClick(View view, int value);
    }

    public void setOnButtonClickListener(OnButtonClickListener listener) {
        this.mListener = listener;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }


}
