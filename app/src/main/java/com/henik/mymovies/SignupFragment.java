package com.henik.mymovies;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.henik.mymovies.databinding.FragmentSignupBinding;

public class SignupFragment extends Fragment {
    private FragmentSignupBinding binding = null;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSignupBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SharedPreferences auth = requireContext().getSharedPreferences("auth", Context.MODE_PRIVATE);

        binding.btnSignup.setOnClickListener(view1 -> {
            if (binding.etSignupPassword.getText().toString().equals(binding.etSignupPasswordConfirm.getText().toString())){
                String userEmail = binding.etSignupEmail.getText().toString();
                String password = binding.etSignupPassword.getText().toString();
                auth.edit().putString(userEmail,password).apply();
                Toast.makeText(requireContext(), "You have Successfully signed up", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(requireContext(), "Passwords aren't the same", Toast.LENGTH_SHORT).show();
            }
        });
    }
}