package com.example.listviewsecondproject.userdetails;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.listviewsecondproject.R;
import com.example.listviewsecondproject.User;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<User> userArrayList = new ArrayList<>();

    public UserAdapter(Context context, ArrayList<User> userArrayList) {
        this.context = context;
        this.userArrayList = userArrayList;
    }

    @Override
    public int getCount() {
        return userArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        User user = userArrayList.get(i);

        View view1 = LayoutInflater.from(context).inflate(R.layout.eachitem,viewGroup,false);

        TextView txtName = view1.findViewById(R.id.txt_name);
        TextView txtMsg = view1.findViewById(R.id.txt_msg);
        TextView txtTime = view1.findViewById(R.id.txt_time);
        CircleImageView profileImage = view1.findViewById(R.id.profile_image);

        txtName.setText(user.userName);
        txtMsg.setText(user.userMsg);
        txtTime.setText(user.lastTime);
        profileImage.setImageResource(user.imageId);



        return view1;
    }
}
