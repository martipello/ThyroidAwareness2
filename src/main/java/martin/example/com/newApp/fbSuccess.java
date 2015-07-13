package martin.example.com.newApp;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.*;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.login.widget.ProfilePictureView;
import com.facebook.share.ShareApi;
import com.facebook.share.Sharer;
import com.facebook.share.internal.LikeButton;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.JoinAppGroupDialog;
import com.facebook.share.widget.ShareButton;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;


public class fbSuccess extends android.support.v4.app.Fragment {

    private TextView mTextDetails;
    private CallbackManager mCallbackManager;
    private AccessTokenTracker mTokenTracker;
    private ProfileTracker mProfileTracker;
    ShareButton shareButton;
    private ProfilePictureView mProfilePic;
    Button groupButton;
    private TextView groupText;


    private FacebookCallback<LoginResult> mCallback = new FacebookCallback<LoginResult>() {
        @Override
        public void onSuccess(LoginResult loginResult) {
            AccessToken accessToken = loginResult.getAccessToken();
            Profile profile = Profile.getCurrentProfile();

            displayWelcomeMessage(profile);
        }

        @Override
        public void onCancel() {

        }

        @Override
        public void onError(FacebookException e) {

        }
    };


    public fbSuccess(){
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getActivity().getApplicationContext());
        mCallbackManager = CallbackManager.Factory.create();

        mTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldToken, AccessToken newToken) {

            }
        };
        mProfileTracker = new ProfileTracker() {
            @Override
            protected void onCurrentProfileChanged(Profile oldProfile, Profile newProfile1) {

                displayWelcomeMessage(newProfile1);
            }
        };
        mTokenTracker.startTracking();
        mProfileTracker.startTracking();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fbsuccess, container, false);

        return rootView;
    }
    private void displayWelcomeMessage(final Profile profile) {

        if (profile != null) {

            new GraphRequest(
                    AccessToken.getCurrentAccessToken(),
                    "/profile/groups",
                    null,
                    HttpMethod.GET,
                    new GraphRequest.Callback() {
                        public void onCompleted(GraphResponse response) {
            /* handle the result */


                        }
                    }
            ).executeAsync();


            mTextDetails.setText("Welcome " + profile.getName());
            mProfilePic = (ProfilePictureView)getActivity().findViewById(R.id.imageView);
            mProfilePic.setProfileId(profile.getId());
            groupText.setVisibility(View.VISIBLE);

            ShareLinkContent content = new ShareLinkContent.Builder()
                    .setContentUrl(Uri.parse("https://www.facebook.com/martin.seal.35"))
                    .build();
            shareButton = (ShareButton) getActivity().findViewById(R.id.share);
            shareButton.setVisibility(View.VISIBLE);
            shareButton.setFragment(this);
            shareButton.setShareContent(content);
            groupButton = (Button)getActivity().findViewById(R.id.button2);
            groupButton.setVisibility(View.VISIBLE);
            groupButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

        } else {
            mTextDetails.setText("Welcome");
            shareButton = (ShareButton) getActivity().findViewById(R.id.share);
            shareButton.setVisibility(View.INVISIBLE);
            groupButton = (Button)getActivity().findViewById(R.id.button2);
            groupButton.setVisibility(View.INVISIBLE);
            groupText.setVisibility(View.INVISIBLE);
            mProfilePic.setProfileId(null);

        }
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        LoginButton loginButton = (LoginButton) view.findViewById(R.id.login_button);

        mProfilePic = (ProfilePictureView)view.findViewById(R.id.imageView);


        mTextDetails = (TextView) view.findViewById(R.id.text_detail);
        groupText = (TextView) view.findViewById(R.id.groupText);
        loginButton.setReadPermissions("user_friends");

        loginButton.setFragment(this);
        loginButton.registerCallback(mCallbackManager,mCallback);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode,data);
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onResume() {
        super.onResume();
        Profile profile = Profile.getCurrentProfile();
        displayWelcomeMessage(profile);
    }
    @Override
    public void onStop(){
        super.onStop();
        mTokenTracker.stopTracking();
        mProfileTracker.stopTracking();
    }
}
