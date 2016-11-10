package com.xiu.fragmentwithrecyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jude.rollviewpager.OnItemClickListener;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.xiu.fragmentwithrecyclerview.R;
import com.xiu.fragmentwithrecyclerview.custom.Constants;
import com.xiu.fragmentwithrecyclerview.fragment.RecyclerViewFragment;

/**
 * Created by xiu on 2016/10/25.
 */
public class HomePageAdapter extends RecyclerView.Adapter <RecyclerView.ViewHolder>{

    private final LayoutInflater inflater;
    private OnItemClickLitener mOnItemClickLitener;
    private RecyclerViewFragment mRecycleviewListener;

    private AlphaAnimation alphaAnimation;

    public HomePageAdapter(Context context,RecyclerViewFragment recycleviewListener) {
        inflater = LayoutInflater.from(context);
        mRecycleviewListener = recycleviewListener;

        alphaAnimation = new AlphaAnimation(1,0);
        alphaAnimation.setDuration(500);
    }

    @Override
    public int getItemViewType(int position) {

        if (position < 1) {//d第0个位置是图片轮播
            return Constants.ViewPagerFlag;
        }else if (position < 9 && position > 0) {//1-8gridview
            return Constants.GridFlag;
        }else
            return Constants.ListFlag;//列表

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //根据不同的item类型创建不同的ViewHolder
        View view;
        RecyclerView.ViewHolder mViewHolder = null;

        if(viewType == Constants.GridFlag) {//网格布局的item

            view = inflater.inflate(R.layout.with_grid_view, parent, false);
            mViewHolder = new gvViewHolder(view);//网格布局的holder

        }else if (viewType == Constants.ListFlag) {

            view = inflater.inflate(R.layout.with_list_view,parent,false);
            mViewHolder = new lvViewHolder(view);

        }else {
            view = inflater.inflate(R.layout.with_view_pger,parent,false);
            mViewHolder = new vpViewHoldr(view);
        }
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        //通过类型判断控件类型
        //将创建好的holder与特定的类型绑定
        switch (getItemViewType(position)) {
            case Constants.GridFlag://4-11
                final gvViewHolder gvHolder = (gvViewHolder)holder;
                //Log.i("HomePageAdapter", "pod"+(position-4));
                gvHolder.gvHoldersimpleDraweeView.setImageURI(Constants.gridViewImgURI[position-1]);//1-8
                gvHolder.gvHolderGridViewText.setText(Constants.gridItemName[position-1]);
                //gvHolder.gvHoldersimpleDraweeView.setAlpha(1.0f);
                gvHolder.gvHolderLinear.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        mRecycleviewListener.OnItemClick(gvHolder,position);
                        //gvHolder.gvHoldersimpleDraweeView.setAnimation(alphaAnimation);
                        gvHolder.gvHoldersimpleDraweeView.setAlpha(0.1f);
                    }
                });
                break;
            case Constants.ListFlag://5-
                final lvViewHolder lvViewHolder = (lvViewHolder) holder;
                lvViewHolder.txt_pLName.setText(Constants.gridItemName[position-9]);
                Log.i("ddd", "onBindViewHolder: "+position);
                break;
            case Constants.ViewPagerFlag:
                Log.i("HomePageAdapter", "-----不绑定数据----------pod"+position);
                return;
        }

    }
    @Override
    public int getItemCount() {
        return Constants.gridViewImgURI.length+Constants.gridItemName.length;
    }

    public class vpViewHoldr extends  RecyclerView.ViewHolder{

        LinearLayout vpHolderLinear;
        RollPagerView mRollViewPager;

        public vpViewHoldr(View itemView) {
            super(itemView);

            vpHolderLinear = (LinearLayout) itemView.findViewById(R.id.linear_vp);
            mRollViewPager = (RollPagerView) vpHolderLinear.findViewById(R.id.view_pager);
            mRollViewPager.setAdapter(new TestNomalAdapter());
            mRollViewPager.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(int position) {
                    Log.i("vpViewHoldr", "ddd");
                }
            });
        }
    }

    private class TestNomalAdapter extends StaticPagerAdapter{
        private int[] imgs = {
                R.drawable.item1,
                R.drawable.item2,
                R.drawable.item2,
                R.drawable.item4,
        };

        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view = new ImageView(container.getContext());
            view.setImageResource(imgs[position]);
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return view;
        }

        @Override
        public int getCount() {
            return imgs.length;
        }
    }

    public class gvViewHolder extends RecyclerView.ViewHolder {

        LinearLayout gvHolderLinear;
        public final SimpleDraweeView gvHoldersimpleDraweeView;
        TextView gvHolderGridViewText;

        public gvViewHolder(View itemView) {
            super(itemView);

            gvHolderLinear = (LinearLayout)itemView.findViewById(R.id.linear_g);

            gvHoldersimpleDraweeView = (SimpleDraweeView) itemView.findViewById(R.id.gvImgV);
            gvHolderGridViewText = (TextView)itemView.findViewById(R.id.gvTV);
        }

    }

    /**
     * List形式的布局数据
     */
    class lvViewHolder extends RecyclerView.ViewHolder {

        LinearLayout rela_listview;
        TextView txt_pLName;

        public lvViewHolder(View itemView) {
            super(itemView);

            rela_listview = (LinearLayout)itemView.findViewById(R.id.linear_listview);
            txt_pLName = (TextView)itemView.findViewById(R.id.txt_pLName);
        }
    }


    /**
     * 定义点击每项的回调接口,此处只实现了点击，没有实现长按
     */
    public interface OnItemClickLitener{
        void OnItemClick(gvViewHolder gv,int positon);
    }

}
