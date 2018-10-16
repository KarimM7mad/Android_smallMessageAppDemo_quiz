package com.example.karimm7mad.quiz2_karimm7mad;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class figure1_fragment extends Fragment {

    public Button submitBtn;
    public EditText passwordEntry, emailEntry;
    public figure1Interface mainReference;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.figure1_fragment_layout, container, false);
    }


    public void setF1Listener(figure1Interface mainReference) {
        this.mainReference = mainReference;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.emailEntry = this.getActivity().findViewById(R.id.emailEntry);
        this.passwordEntry = this.getActivity().findViewById(R.id.passwordEntry);


        this.submitBtn = this.getActivity().findViewById(R.id.submitBtn);
        this.submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                boolean b = (emailEntry.getText().toString().equals("quiz2@holaapp.com")) && (passwordEntry.getText().toString().equals("123456"));
//                boolean b2 = (emailEntry.getText().toString().equals("")) && (passwordEntry.getText().toString().equals(""));
                boolean b = (emailEntry.getText().toString().equals("a")) && (passwordEntry.getText().toString().equals("1"));
                boolean b2 = (emailEntry.getText().toString().equals("")) && (passwordEntry.getText().toString().equals(""));



                if (b) {
                    mainReference.login();
                } else if (!b2) {
                    Toast.makeText(v.getContext(), "Wrong Email/Password, Try again", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(v.getContext(), "Fill in the missing data", Toast.LENGTH_SHORT).show();
                }


            }
        });


    }


    public interface figure1Interface {
        public void login();
    }

}
