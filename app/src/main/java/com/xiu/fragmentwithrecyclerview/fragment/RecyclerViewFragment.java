package com.xiu.fragmentwithrecyclerview.fragment;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.xiu.fragmentwithrecyclerview.R;
import com.xiu.fragmentwithrecyclerview.activity.Main2Activity;
import com.xiu.fragmentwithrecyclerview.adapter.HomePageAdapter;
import com.xiu.fragmentwithrecyclerview.custom.Constants;

import static com.xiu.fragmentwithrecyclerview.custom.Constants.rowTotalFourColumn;


public class RecyclerViewFragment extends Fragment implements HomePageAdapter.OnItemClickLitener {

    //private OnFragmentInteractionListener mListener;
    private RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;

    private HomePageAdapter.gvViewHolder gvViewHolderSt;//实现GridView的item跳转后恢复状态

    public RecyclerViewFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recycler_view, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        gridLayoutManager = new GridLayoutManager(getActivity(),rowTotalFourColumn);

        //定制每一个item的布局类型
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
             /*   if (position ==0) {
                    return Constants.oneItemFourColumn;
                }else */if ( position < 9 && position>0) {
                    return Constants.oneItemOneColumn;
                }else
                    Log.i("TAG", "getSpanSize: "+position);
                    return Constants.oneItemFourColumn;
            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(new HomePageAdapter(getActivity(),this));

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onResume() {
        super.onResume();
        if (gvViewHolderSt != null) {
            gvViewHolderSt.gvHoldersimpleDraweeView.setAlpha(1.0f);
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (gvViewHolderSt != null) {
            gvViewHolderSt = null;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        //mListener = null;
    }

    @Override
    public void OnItemClick(HomePageAdapter.gvViewHolder gvh, int positon) {
        gvViewHolderSt = gvh;
        Toast.makeText(getActivity(), "5555"+positon, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getActivity(), Main2Activity.class);
        getActivity().startActivity(intent);
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
   /* public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }*/
}
