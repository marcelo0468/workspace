package br.com.digitalhouse.listadeprofessores.adapters;

import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.digitalhouse.listadeprofessores.R;
import br.com.digitalhouse.listadeprofessores.model.Professor;
import br.com.digitalhouse.listadeprofessores.view.ProfessorActivity;
import br.com.digitalhouse.listadeprofessores.view.RecyclerViewClickListener;

public class RecyclerViewProfessorAdapter extends RecyclerView.Adapter<RecyclerViewProfessorAdapter.ViewHolder> {

    private List<Professor> professores;
    private RecyclerViewClickListener listener;

    public RecyclerViewProfessorAdapter(List<Professor> professores, RecyclerViewClickListener listener) {
        this.professores = professores;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.professor_recyclerview_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        final Professor professor = professores.get(position);
        viewHolder.setarConteudoNaTela(professor);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(professor);
            }
        });
    }

    @Override
    public int getItemCount() {
        return professores.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewNome;
        private TextView textViewCurso;
        private ImageView imageViewFoto;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNome = itemView.findViewById(R.id.textViewNome);
            textViewCurso = itemView.findViewById(R.id.textViewCurso);
            imageViewFoto = itemView.findViewById(R.id.imageViewFoto);
        }

        public void setarConteudoNaTela(Professor professor) {
            textViewNome.setText(professor.getNome());
            textViewCurso.setText(professor.getCurso());
            imageViewFoto.setImageDrawable(ContextCompat.getDrawable(imageViewFoto.getContext(), professor.getFoto()));
        }
    }
}
