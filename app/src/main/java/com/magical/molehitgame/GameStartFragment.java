package com.magical.molehitgame;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import com.magical.molehitgame.base.BaseFragment;

/**
 * Created by magical.zhang on 2018/5/21.
 * Description : 游戏开始页
 */
public class GameStartFragment extends BaseFragment {

    @BindView(R.id.id_start_next) View mNextView;
    @BindView(R.id.woimen)
    TextView women;
    @BindView(R.id.yinsi)
    TextView yinsi;

    @Override
    protected void doLoadData() {
    }

    @Override
    protected void doInit() {

        mNextView.setSelected(true);
        mNextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((GameMainActivity) mContext).changePage(1);
            }
        });
        women.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BroseActivity.page = "2";
                startActivity(new Intent(getActivity(),BroseActivity.class));
            }
        });
        yinsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BroseActivity.page = "1";
                startActivity(new Intent(getActivity(),BroseActivity.class));
            }
        });
    }

    @Override
    protected boolean isNeedShowLoadingView() {
        return false;
    }

    @Override
    protected int getLayoutName() {
        return R.layout.fragment_game_start;
    }
}
