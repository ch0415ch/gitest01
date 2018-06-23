package org.techtown.nearlogin;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;

     private EditText Editemail, Editpassword;
   // private Button Buttonlogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance(); //FirebaseAuth인스턴스 얻기


    }




public void buttonLogin (View v)
{

    Editemail = (EditText)findViewById(R.id.editEmail);
    Editpassword = (EditText)findViewById(R.id.editPassword);
    String email = Editemail.getText().toString();
    String password = Editpassword.getText().toString();
    mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                   //Log.d(TAG, "signInWithEmail:onComplete:" + task.isSuccessful());

                    // If sign in fails, display a message to the user. If sign in succeeds
                    // the auth state listener will be notified and logic to handle the
                    // signed in user can be handled in the listener.
                    if (task.isSuccessful()) {
                      //  Log.w(TAG, "signInWithEmail:failed", task.getException());
                        Toast.makeText(getApplicationContext(), "이메일 로그인 성공",
                                Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "이메일 로그인 실패",
                                Toast.LENGTH_SHORT).show();
                    }

                    // ...
                }
            });



}
}
