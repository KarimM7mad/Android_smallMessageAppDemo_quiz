package com.example.karimm7mad.quiz2_karimm7mad;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class figure2_fragment extends Fragment {

    public Intent i;
    public ListView lv;
    public String[] senders;
    public Button logoutBtn;
    public figure2Interface mainReference;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.figure2_fragment_layout,container,false);
    }

    public void setF2Listener(figure2Interface mainReference){
        this.mainReference = mainReference;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.senders = this.getResources().getStringArray(R.array.senders);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.logoutBtn = this.getActivity().findViewById(R.id.logoutBtn);
        this.logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainReference.logout();
            }
        });
        this.lv = this.getActivity().findViewById(R.id.messagesList);
        this.lv.setClickable(false);
        this.lv.setFocusable(false);
        this.configureListView();
    }

    public void configureListView() {
        this.lv.setAdapter(new ArrayAdapter<String>(this.getActivity(), R.layout.one_item_preview, this.senders));
        this.lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mainReference.checkMsg(position);
            }
        });


    }


    public interface figure2Interface{
        public void logout();
        public void checkMsg(int x);
    }

}
