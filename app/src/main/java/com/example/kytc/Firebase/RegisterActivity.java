package com.example.kytc.Firebase;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.kytc.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.UploadTask;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {
    EditText fullNameET, emailEt, passwordEt, phoneEt;
    Button registerBt;
    ImageView profileImage;
    FirebaseAuth auth;
    FirebaseFirestore firestore;
    FirebaseStorage storage;
    Uri uri;
    ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    uri = result.getData().getData();
                    profileImage.setImageURI(uri);

                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fullNameET = findViewById(R.id.fullNameEt);
        emailEt = findViewById(R.id.emailEt);
        passwordEt = findViewById(R.id.passwordEt);
        phoneEt = findViewById(R.id.phoneEt);
        registerBt = findViewById(R.id.registerBt);
        profileImage = findViewById(R.id.profileImage);

        auth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();
        storage = FirebaseStorage.getInstance();



        registerBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullName = fullNameET.getText().toString();
                String email = emailEt.getText().toString();
                String password = passwordEt.getText().toString();
                String phone = phoneEt.getText().toString();

                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(RegisterActivity.this, "registered successfully", Toast.LENGTH_SHORT).show();
                            HashMap<Object, Object> map = new HashMap<>();
                            map.put("fullName", fullName);
                            map.put("email", email);
                            map.put("phone", phone);
                            map.put("userId", auth.getCurrentUser().getUid());

                            storage.getReference().child("images").child("userProfile").putFile(uri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                                    if (task.isSuccessful()){
                                        storage.getReference().child("images").child("userProfile").getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Uri> task) {
                                                String path = String.valueOf(task.getResult());

                                                map.put("profileImage",task.getResult());
                                                CollectionReference dr = firestore.collection("users");
                                                dr.add(map);
                                            }
                                        });
                                    }
                                }
                            });


//                            HashMap<Object,Object> map  = new HashMap<>();
//                            map.put("fullName",fullName);
//                            map.put("email",email);
//                            map.put("phone",phone);
//
//                            firestore.collection("users").add(map).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
//                                @Override
//                                public void onComplete(@NonNull Task<DocumentReference> task) {
//                                    if (task.isSuccessful()){
//                                        Toast.makeText(RegisterActivity.this, "user added success", Toast.LENGTH_SHORT).show();
//                                    }else{
//                                        Toast.makeText(RegisterActivity.this, "user added failed", Toast.LENGTH_SHORT).show();
//                                    }
//                                }
//                            });
                            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(RegisterActivity.this, "registered failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
        profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                launcher.launch(intent);


            }
        });

    }
}