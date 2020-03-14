/*
 * Copyright (c) 2020. This code is created and written by Ariful Jannat Arif on 3/2/20 9:07 PM
 */

package com.example.hautomation.activity.profile;

import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.Toolbar;
import com.example.hautomation.R;
import com.example.hautomation._enums.UserTypes;
import com.example.hautomation.common.BaseOvservableViewMvc;


public class ProfileMvcImpl extends BaseOvservableViewMvc<ProfileMvc.Listener> implements ProfileMvc {
    ImageView profileImagebg,profileEdtbtn;
    boolean isEditing=false;
    int ids[]=new int[]{R.id.profile_user_name,R.id.profile_name,R.id.profile_mobile,
            R.id.profile_institution,R.id.profile_guardian,R.id.profile_guardian_mobile,
            R.id.profile_address,R.id.profile_monthly_fee,R.id.profile_reference};
    EditText[] fields=new EditText[9];
    AppCompatSpinner userType;

    public ProfileMvcImpl(LayoutInflater inflater, ViewGroup parent){
        setmRootView(inflater.inflate(R.layout.activity_profile,parent,false));
        try{
            registerListener((Listener) getContext());
        }catch (Exception e){
            throw new IllegalArgumentException("Your context activity must implements Listener "+ProfileMvc.Listener.class);
        }
        initViews();
    }
    @Override
    public void initViews() {
        profileImagebg=findViewById(R.id.profile_image_bg);
        userType=findViewById(R.id.user_typeSpinner);
        for(int i=0;i<ids.length;i++)
        {
            fields[i]=findViewById(ids[i]);
            fields[i].setInputType(InputType.TYPE_NULL);
            //fields[i].setBackgroundResource(R.drawable.selectable_icon_bg);
        }
        profileEdtbtn=findViewById(R.id.profile_edit);
        profileEdtbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setEditable(!isEditing);
            }
        });
        setuptoolbar();
        setUserTypespinner();

      /*  Glide.with(getContext())
                .load(R.drawable.peaple)
                .apply(bitmapTransform(new BlurTransformation(5, 5)))
                .into(profileImagebg);*/
    }
    private void setEditable(boolean state){
        isEditing=state;
        for(EditText field:fields){
            if(state) {
                field.setInputType(InputType.TYPE_CLASS_TEXT);
                field.setBackgroundResource(R.drawable.edittextbg);
            }else {
                field.setInputType(InputType.TYPE_NULL);
                field.setBackgroundResource(R.drawable.selectable_icon_bg);
            }
        }

    }
    private void setUserTypespinner() {
        ArrayAdapter<UserTypes> adapter=new ArrayAdapter<UserTypes >(getContext(),android.R.layout.simple_spinner_dropdown_item, UserTypes.values());
        userType.setAdapter(adapter);
    }

    private void setuptoolbar() {
        for(Listener listener:getListensers()) {
            listener.setupToolbar((Toolbar) findViewById(R.id.toolbar));
            listener.setToolbarTitle("Profile");
        }
    }
}
