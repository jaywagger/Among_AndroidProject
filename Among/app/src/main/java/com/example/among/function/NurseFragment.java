package com.example.among.function;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.among.R;
import com.example.among.function.detail.NurseDetailFragment1;
import com.example.among.function.detail.NurseDetailFragment2;
import com.example.among.function.detail.NurseDetailFragment3;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class NurseFragment extends Fragment {
    RecyclerView card_list;

    MyReplaceFragment myReplaceFragment;
    public NurseFragment() {
        // Required empty public constructor
    }
    public NurseFragment(MyReplaceFragment myReplaceFragment){
        this.myReplaceFragment = myReplaceFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View viewGroup = (View)LayoutInflater.from(getContext()).inflate(R.layout.fragment_nurse, container, false);
        card_list = (RecyclerView)viewGroup.findViewById(R.id.card_list);

        ArrayList<NurseViewItem> recycle_card_data = new ArrayList<NurseViewItem>();
        NurseViewItem[] item = new NurseViewItem[3];
        item[0] = new NurseViewItem("노인 일자리 및 사회활동 지원 사업");
        item[1] = new NurseViewItem("노인자원봉사활성화");
        item[2] = new NurseViewItem("장사제도");

        for(int i=0;i<3;i++){
            recycle_card_data.add(item[i]);
        }

        NurseViewAdapter adapter = new NurseViewAdapter(this, R.layout.fragment_nurse,recycle_card_data);

        adapter.setOnItemClickListener(new NurseViewAdapter.MyOnItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                Fragment fragment = null;
                switch (pos){
                    case 0:
                        fragment = new NurseDetailFragment1();
                        break;
                    case 1:
                        fragment = new NurseDetailFragment2();
                        break;
                    case 2:
                        fragment = new NurseDetailFragment3();
                        break;
                }
                myReplaceFragment.onClick(fragment);
            }
        });


        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        /*GridLayoutManager manager = new GridLayoutManager(getContext(),2);*/

        card_list.setHasFixedSize(true);
        card_list.setLayoutManager(manager);
        card_list.setAdapter(adapter);

        return viewGroup;
    }

}
