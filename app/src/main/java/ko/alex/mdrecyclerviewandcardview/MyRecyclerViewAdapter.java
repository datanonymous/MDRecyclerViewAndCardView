package ko.alex.mdrecyclerviewandcardview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyRecyclerViewAdapter extends
        RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private List<Person> persons;
    private Context context;

    public MyRecyclerViewAdapter(List<Person> persons, Context context){
        this.persons = persons;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Person person = persons.get(position);
        viewHolder.txtName.setText(person.getName());
        viewHolder.txtJob.setText(person.getJob());
    }

    @Override
    public int getItemCount() {
        return persons.size();//returns elements in persons list
    }

    //inner class
    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView txtName;
        public TextView txtJob;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.txtPersonName);
            txtJob = itemView.findViewById(R.id.txtPersonJob);

        }
    }

}
