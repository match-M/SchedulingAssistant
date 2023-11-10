package com.match.schedulingassistant.adapter.list;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.content.Context;
import android.widget.PopupMenu;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.match.schedulingassistant.R;
import com.match.schedulingassistant.presenter.StartPresenter;

import java.util.List;

/**
 * 排班文件列表适配器
 * @author match
 */
public class SchedulingFileListAdapter<E> extends BaseAdapter {

    private Context context;
    private StartPresenter startPresenter;
    private List<String> fileList;

    public SchedulingFileListAdapter(@NonNull Context context, @NonNull StartPresenter startPresenter
            , @NonNull List<String> fileList){
        this.context = context;
        this.fileList = fileList;
        this.startPresenter = startPresenter;
    }

    @Override
    public int getCount() {
        return this.fileList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.fileList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;

        //已经存在缓存就直接调用
        if(view != null) {
            viewHolder = (ViewHolder) view.getTag();
        }
        //缓存不存在需要获取布局后创建新的缓存
        if(view == null){
            //获取布局
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.scheduling_file_list_item, viewGroup, false);
            //创建新的缓存
            viewHolder = new ViewHolder();
            viewHolder.tv_file_name = view.findViewById(R.id.file_name);
            view.setTag(viewHolder);

        }
        //设置item内容
        String name = this.fileList.get(position);
        viewHolder.tv_file_name.setText(name);
        //设置长按
        viewHolder.tv_file_name.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                TextView tv_file_name = (TextView) view;
                showPopupMenu(view, String.valueOf(tv_file_name.getText()));
                return true;
            }
        });

        return view;

    }

    private void showPopupMenu(View v, String fileName){
        //定义PopupMenu对象
        PopupMenu popupMenu = new PopupMenu(this.context, v);
        //设置PopupMenu对象的布局
        popupMenu.getMenuInflater().inflate(R.menu.list_item_menu, popupMenu.getMenu());
        //设置PopupMenu的点击事件
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                //删除文件
                startPresenter.doDelete(fileName);
                return true;
            }
        });

        //显示菜单
        popupMenu.show();

    }

    //缓存，减少界面卡顿
    private class ViewHolder {
        TextView tv_file_name;
    }
}
