package com.trayan.thechallenger.data;

import android.app.AuthenticationRequiredException;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.trayan.thechallenger.data.model.LoggedInUser;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import androidx.annotation.NonNull;
import okio.Timeout;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    private FirebaseAuth firebaseAuth;

//    public Result<LoggedInUser> register(String username, String password) {
//        try {
//            firebaseAuth = FirebaseAuth.getInstance();
//            // handle authentication
//            Task<AuthResult> authResultTask = firebaseAuth.createUserWithEmailAndPassword(username, password);
//            // wait for request
//            TimeUnit.MILLISECONDS.sleep(1);
//            // check if task is completed and successful
//            if (authResultTask.isComplete() && !authResultTask.isSuccessful()){
//                throw new Exception("Error with Google authentication.");
//            } else {
//                TimeUnit.MILLISECONDS.sleep(1);
//                if (authResultTask.isComplete() && !authResultTask.isSuccessful()){
//                    throw new Exception("Error with Google authentication.");
//                }
//            }
//            // store logged in user
//            LoggedInUser loggedInUser = new LoggedInUser(java.util.UUID.randomUUID().toString(), username);
//            return new Result.Success<>(loggedInUser);
//        } catch (Exception e) {
//            return new Result.Error(new IOException("Error logging in.", e));
//        }
//    }

    public Result<LoggedInUser> login(String username, String password) {
        try {
            firebaseAuth = FirebaseAuth.getInstance();
            // handle authentication
            Task<AuthResult> authResultTask = firebaseAuth.createUserWithEmailAndPassword(username, password);

//            // TODO: check if task is successful
//            if (!authResultTask.isSuccessful()){
//                throw new Exception("Error with Google authentication.");
//            }

            // store logged in user
            LoggedInUser loggedInUser = new LoggedInUser(java.util.UUID.randomUUID().toString(), username);
            return new Result.Success<>(loggedInUser);
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in.", e));
        }
    }

    public void logout() {
        firebaseAuth.signOut();
    }
}
