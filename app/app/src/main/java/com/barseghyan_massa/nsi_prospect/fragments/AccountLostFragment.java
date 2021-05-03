package com.barseghyan_massa.nsi_prospect.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.barseghyan_massa.nsi_prospect.MyApplication;
import com.barseghyan_massa.nsi_prospect.R;
import com.barseghyan_massa.nsi_prospect.db.helper.UserHelper;
import com.barseghyan_massa.nsi_prospect.db.model.User;
import com.barseghyan_massa.nsi_prospect.mail.JavaMailAPI;

/**
 * A simple {@link Fragment} subclass.
 */
public class AccountLostFragment extends Fragment {

    EditText et_mail, et_message;
    Button btn_generate;

    public AccountLostFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account_lost, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        et_mail = getActivity().findViewById(R.id.lost_acc_mail);
        et_message = getActivity().findViewById(R.id.lost_acc_msg);
        btn_generate = getActivity().findViewById(R.id.btn_rec_lost_acc);

        btn_generate.setOnClickListener(v -> {
            try {
                recoverAccount(et_mail.getText().toString().trim(), et_message.getText().toString().trim());
                Toast.makeText(MyApplication.getAppContext(), "Success", Toast.LENGTH_SHORT).show();

            } catch (Exception e) {
                Log.d(this.getTag(), e.toString());
            }
        });
    }

    private void recoverAccount(String et_mail, String et_msg) throws Exception {
        //Creer le mail
        Toast.makeText(MyApplication.getAppContext(), "Envoi..", Toast.LENGTH_SHORT).show();

        String subject = "Demande de récupération de compte.";

        try {
            JavaMailAPI javaMailAPI = new JavaMailAPI(MyApplication.getAppContext(), et_mail, subject, et_msg);
            javaMailAPI.execute();
            Toast.makeText(MyApplication.getAppContext(), "Succès!", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Log.d("recoverAccount", e.toString());
            Toast.makeText(MyApplication.getAppContext(), "Erreur lors de l'envoi.", Toast.LENGTH_SHORT).show();
        }
    }
}