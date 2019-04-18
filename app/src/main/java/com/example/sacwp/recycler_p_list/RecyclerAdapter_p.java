package com.example.sacwp.recycler_p_list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sacwp.R;

import java.util.List;

public class RecyclerAdapter_p extends RecyclerView.Adapter<RecyclerAdapter_p.ViewHolder> {

    private List<RecyclerItem_p> list;
    private ItemClicked callback;


    public RecyclerAdapter_p(List<RecyclerItem_p> list,
                             ItemClicked callback) {
        this.list = list;
        this.callback = callback;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter_p.ViewHolder viewHolder, int position) {
        final RecyclerItem_p recyclerItemP = list.get(position);

        viewHolder.firstTextView.setText(recyclerItemP.getCity());
        viewHolder.secondTextView.setText(recyclerItemP.getComent());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        // указываем лаяут
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list_p_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        // добавляем слушатель кликов на все подобные лаяуты (добавится слушатель всего один раз)
        // рекомендую подробно прочесть про анонимные классы, если не понятен код ниже
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // находим позицию элемента, на который нажали
                int adapterPosition = holder.getAdapterPosition();
                // проверяем корректность позиции и наличие callback
                if (adapterPosition != RecyclerView.NO_POSITION && callback != null) {
                    // делегируем работу с данными через callback.
                    // В адаптере не должно быть лишней логики.
                    callback.itemClickedCallback(adapterPosition);
                }
            }
        });
        return holder;
    }

    public interface ItemClicked {
        void itemClickedCallback(int itemPosition);
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        TextView firstTextView;
        TextView secondTextView;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            firstTextView = itemView.findViewById(R.id.first_text_item);
            secondTextView = itemView.findViewById(R.id.second_text_item);

        }
    }

    public void setList(List<RecyclerItem_p> list) {
        this.list = list;
        notifyDataSetChanged();
    }
}
