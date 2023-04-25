package com.example.and_14_melon2.recycle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and_14_melon2.R;
import com.example.and_14_melon2.databinding.ItemRecvMelonBinding;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MelonAdapter extends RecyclerView.Adapter<MelonAdapter.ViewHolder> {
    //어떤 종류든 Adapter는 LayoutInflater가 필요하다
    //데이터 바인딩(뷰결합)을 통해서 사용이 가능한 형태

    ArrayList<MelonDTO> list;
    ItemRecvMelonBinding binding;

    public MelonAdapter(ArrayList<MelonDTO> list) {
        this.list=list;
    }

    @NonNull
    @Override //View 타입으로 디자인을 담아서 ViewHolder를 하나씩 생성해야 한다.
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ItemRecvMelonBinding.inflate(inflater,parent,false);

        //LayoutInflater의 static메소드 from을 사용한 방법.

        View v =inflater.inflate(R.layout.fragment_melon,parent,false);
        ViewHolder vh = new ViewHolder(binding);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        h.binding.album.setImageResource(list.get(i).getAlbum());
        h.binding.rank.setText(list.get(i).getRank()+"");
        h.binding.title.setText(list.get(i).getTitle());
        h.binding.artist.setText(list.get(i).getArtist());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    //inner class로 우리가 커스텀 할수 있는 위젯용 DTO
    public class ViewHolder extends RecyclerView.ViewHolder {
//        ImageView album;
//        TextView rank, title, artist;
        ItemRecvMelonBinding binding;


        public ViewHolder(ItemRecvMelonBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
//            album=v.findViewById(R.id.album);
//            rank=v.findViewById(R.id.rank);
//           title=v.findViewById(R.id.title);
//            artist=v.findViewById(R.id.artist);


        }
    }
}
