package com.hacslunar.leaderboard;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//Mirrors LeaderBoardActivity Fragments.
public class SubmissionPageFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";

    public static SubmissionPageFragment newInstance(int index) {
        SubmissionPageFragment fragment = new SubmissionPageFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.fragment_submission, container, false);
        final Button submitButton = fragment.findViewById(R.id.submit_button);
        final TextView lv_first_Name = fragment.findViewById(R.id.first_name_tv);
        final TextView lv_lastName = fragment.findViewById(R.id.last_name_tv);
        final TextView lv_emailAddress = fragment.findViewById(R.id.email_address_tv);
        final TextView lv_gitLink = fragment.findViewById(R.id.github_link_tv);
        submitButton.setOnClickListener(view -> {
            submitButton.setVisibility(View.GONE);
            lv_first_Name.setVisibility(View.GONE);
            lv_lastName.setVisibility(View.GONE);
            lv_emailAddress.setVisibility(View.GONE);
            lv_gitLink.setVisibility(View.GONE);
            Dialog my = new Dialog(Objects.requireNonNull(getContext()));
            my.requestWindowFeature(Window.FEATURE_NO_TITLE);
            my.setContentView(R.layout.dialog_ask);
            my.show();

            ImageView cancelIcon = my.findViewById(R.id.cancel_icon);
            cancelIcon.setOnClickListener(view12 -> {
                my.cancel();
                submitButton.setVisibility(View.VISIBLE);
                lv_first_Name.setVisibility(View.VISIBLE);
                lv_lastName.setVisibility(View.VISIBLE);
                lv_emailAddress.setVisibility(View.VISIBLE);
                lv_gitLink.setVisibility(View.VISIBLE);
            });

            Button button = my.findViewById(R.id.yes_button);
            button.setOnClickListener(view1 -> {
                my.cancel();
                String firstName;
                String lastName;
                String emailAddress;
                String gitHubLink;
                firstName = lv_first_Name.getText().toString();
                lastName = lv_lastName.getText().toString();
                emailAddress = lv_emailAddress.getText().toString();
                gitHubLink = lv_gitLink.getText().toString();

                NetUtil apiUtility = SubmitFormNetUtil.sendResponse().create(NetUtil.class);
                Call<Void> send = apiUtility.sendForm(firstName, lastName, emailAddress, gitHubLink);
                send.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(@NonNull Call<Void> call, @NonNull Response<Void> response) {
                        Toast.makeText(getContext(), "Successfully Submitted", Toast.LENGTH_SHORT).show();
                        Dialog my1 = new Dialog(Objects.requireNonNull(getContext()));
                        my1.requestWindowFeature(Window.FEATURE_NO_TITLE);
                        my1.setContentView(R.layout.dialog_success);
                        my1.show();
                        submitButton.setVisibility(View.VISIBLE);
                        lv_first_Name.setVisibility(View.VISIBLE);
                        lv_lastName.setVisibility(View.VISIBLE);
                        lv_emailAddress.setVisibility(View.VISIBLE);
                        lv_gitLink.setVisibility(View.VISIBLE);
                        Log.d("TAG", "Response = " + response.toString());
                    }

                    @Override
                    public void onFailure(@NonNull Call<Void> call, @NonNull Throwable t) {
                        my.cancel();
                        Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
                        Dialog my1 = new Dialog(Objects.requireNonNull(getContext()));
                        my1.requestWindowFeature(Window.FEATURE_NO_TITLE);
                        my1.setContentView(R.layout.dialog_failed);
                        my1.show();
                        submitButton.setVisibility(View.VISIBLE);
                        lv_first_Name.setVisibility(View.VISIBLE);
                        lv_lastName.setVisibility(View.VISIBLE);
                        lv_emailAddress.setVisibility(View.VISIBLE);
                        lv_gitLink.setVisibility(View.VISIBLE);
                        Log.d("TAG", "Response = " + t.toString());
                    }
                });
            });
        });
        return fragment;
    }
}