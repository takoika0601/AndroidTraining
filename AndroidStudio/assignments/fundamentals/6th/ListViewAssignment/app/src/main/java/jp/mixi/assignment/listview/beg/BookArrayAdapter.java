package jp.mixi.assignment.listview.beg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by takoika0601 on 2014/07/08.
 */
public class BookArrayAdapter extends ArrayAdapter<Book> {

    private Context context;
    private ArrayList<Book> objects;

    private LayoutInflater mLayoutInflater;

    public BookArrayAdapter(Context context, ArrayList<Book> objects) {
        super(context, 0, objects);
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = null;

        if (convertView == null) {
            view = mLayoutInflater.inflate(R.layout.list_item_book, parent, false);
        } else {
            view = convertView;
        }

        Book item = getItem(position);

        TextView title = (TextView) view.findViewById(R.id.Title);
        TextView publisher = (TextView) view.findViewById(R.id.Publisher);
        TextView price = (TextView) view.findViewById(R.id.Price);

        title.setText(item.getTitle());
        publisher.setText(item.getPublisher());
        price.setText(item.getPrice() + "円");

        return view;
    }
}
