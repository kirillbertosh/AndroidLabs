package by.constpe.lab3.activity.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import by.constpe.lab3.R;
import by.constpe.lab3.model.Bridge;
import by.constpe.lab3.util.BitmapUtil;

public class CustomListAdapter extends ArrayAdapter<Bridge> {
    private Activity context;
    private List<Bridge> bridges;

    public CustomListAdapter(Activity context, List<Bridge> bridges) {
        super(context, R.layout.list_row, bridges);

        this.context = context;
        this.bridges = bridges;
    }

    private class ViewHolder {
        private TextView name;
        private TextView height;
        private TextView description;
        private ImageView image;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            LayoutInflater layoutInflater = context.getLayoutInflater();
            convertView = layoutInflater.inflate(R.layout.list_row, parent, false);

            TextView nameText = convertView.findViewById(R.id.name);
            TextView heightText = convertView.findViewById(R.id.height);
            TextView infoText = convertView.findViewById(R.id.info);
            ImageView imageView = convertView.findViewById(R.id.image);

            viewHolder = new ViewHolder();
            viewHolder.name = nameText;
            viewHolder.height = heightText;
            viewHolder.description = infoText;
            viewHolder.image = imageView;

            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder)convertView.getTag();
        }

        viewHolder.name.setText(bridges.get(position).getName());
        viewHolder.height.setText(bridges.get(position).getHeight());
        viewHolder.description.setText(bridges.get(position).getDescription());
        viewHolder.image.setImageBitmap(BitmapUtil.decodeBitmapFromResources(context.getResources(),
                context.getResources().getIdentifier(bridges.get(position).getTableImage(),
                        "drawable", context.getPackageName()), 100, 100));

        return convertView;
    }
}
