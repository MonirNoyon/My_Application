import android.widget.Filter;

import com.example.contactwithrecyclerandcardview.Model;
import com.example.contactwithrecyclerandcardview.MyAdapter;

import java.util.ArrayList;

public class CustomFilter extends Filter {

    ArrayList<Model> filterlist;
    MyAdapter adapter;

    public CustomFilter(ArrayList<Model> filterlist, MyAdapter adapter) {
        this.filterlist = filterlist;
        this.adapter = adapter;
    }

    @Override
    protected FilterResults performFiltering(CharSequence charSequence) {

        FilterResults results = new FilterResults();
        if (charSequence!=null && charSequence.length()>0)
        {
            charSequence = charSequence.toString().toUpperCase();

            ArrayList<Model> arrayList = new ArrayList<>();

            for (int i=0;i<filterlist.size();i++)
            {
                if (filterlist.get(i).getTitle().toUpperCase().contains(charSequence))
                {
                    arrayList.add(filterlist.get(i));
                }
            }
            results.count = arrayList.size();
            results.values = arrayList;
        }
        else
        {
            results.count = filterlist.size();
            results.values = filterlist;

        }
        return results;
    }

    @Override
    protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
    }
}
