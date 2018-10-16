package com.example.karimm7mad.quiz2_karimm7mad;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class figure3_fragment extends Fragment {

    private int msgNum=-1;
    public String message;
    public String senderName;
    public TextView msgDisplay,nameDisplay;
    public Button backBtn;
    public figure3Interface mainReference;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.figure3_fragment_layout, container, false);
    }

    public void setF3Listener(MainActivity main){
        this.mainReference = main;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            this.senderName = (this.getResources().getStringArray(R.array.senders))[msgNum];
            this.message = (this.getResources().getStringArray(R.array.messages))[msgNum];
        }
        catch(Exception e){
            this.senderName = "hahahahahahahhahahahaha";
            this.message = "HAHHAHAHAHHAHAHAHAHHA";
        }
    }

    public void setMsgNum(int msgNum) {
        this.msgNum = msgNum;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.msgDisplay = this.getActivity().findViewById(R.id.msgDisplay);
        this.msgDisplay.setText(this.message);

        this.nameDisplay = this.getActivity().findViewById(R.id.senderTxtName);
        this.nameDisplay.setText(this.senderName);

        this.backBtn = this.getActivity().findViewById(R.id.backBtn);
        this.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainReference.goBack();
            }
        });

    }

    public interface figure3Interface{
        public void goBack();
    }


}
