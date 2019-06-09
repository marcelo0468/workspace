package br.com.digitalhouse.listadeprofessores.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.Layout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import br.com.digitalhouse.listadeprofessores.R;
import br.com.digitalhouse.listadeprofessores.adapters.RecyclerViewProfessorAdapter;
import br.com.digitalhouse.listadeprofessores.model.Professor;

public class ProfessorActivity extends AppCompatActivity implements RecyclerViewClickListener{

    private RecyclerView recyclerView;
    private RecyclerViewProfessorAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor);


        recyclerView = findViewById(R.id.recyclerViewProfessor);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        adapter = new RecyclerViewProfessorAdapter(getProfessor(), this);
        recyclerView.setAdapter(adapter);



    }

    private List<Professor> getProfessor() {
        List<Professor> professor = new ArrayList<>();
        professor.add(new Professor("Jéssica Milena", "Mobile Android", "Mini Curriculum", R.drawable.lisa));
        professor.add(new Professor("Tairo Roberto", "Mobile Android", "Mini Curriculum1", R.drawable.homersimpson));
        professor.add(new Professor("Fabio Tadashi", "Mobile Android", "Mini Curriculum2", R.drawable.flanders));
        professor.add(new Professor("Guilherme", "FullStack", "Mini Curriculum3", R.drawable.burns));
        professor.add(new Professor("Victor Caldas", "Marketing Digital", "Mini Curriculum4", R.drawable.homersimpson));
        professor.add(new Professor("Hugo Rosso", "Mobile IOS", "Mini Curriculum5", R.drawable.flanders));
        professor.add(new Professor("Hendy Almeida", "Mobile Android", "Mini Curriculum6", R.drawable.burns));
        professor.add(new Professor("Vinicius", "Mobile IOS", "Mini Curriculum7", R.drawable.nerd));
        professor.add(new Professor("Jéssica Milena", "Mobile Android", "Mini Curriculum", R.drawable.lisa));
        professor.add(new Professor("Tairo Roberto", "Mobile Android", "Mini Curriculum1", R.drawable.homersimpson));
        professor.add(new Professor("Fabio Tadashi", "Mobile Android", "Mini Curriculum2", R.drawable.flanders));
        professor.add(new Professor("Guilherme", "FullStack", "Mini Curriculum3", R.drawable.burns));
        professor.add(new Professor("Victor Caldas", "Marketing Digital", "Mini Curriculum4", R.drawable.homersimpson));
        professor.add(new Professor("Hugo Rosso", "Mobile IOS", "Mini Curriculum5", R.drawable.flanders));
        professor.add(new Professor("Hendy Almeida", "Mobile Android", "Mini Curriculum6", R.drawable.burns));
        professor.add(new Professor("Vinicius", "Mobile IOS", "Mini Curriculum7", R.drawable.nerd));
        professor.add(new Professor("Jéssica Milena", "Mobile Android", "Mini Curriculum", R.drawable.lisa));
        professor.add(new Professor("Tairo Roberto", "Mobile Android", "Mini Curriculum1", R.drawable.homersimpson));
        professor.add(new Professor("Fabio Tadashi", "Mobile Android", "Mini Curriculum2", R.drawable.flanders));
        professor.add(new Professor("Guilherme", "FullStack", "Mini Curriculum3", R.drawable.burns));
        professor.add(new Professor("Victor Caldas", "Marketing Digital", "Mini Curriculum4", R.drawable.homersimpson));
        professor.add(new Professor("Hugo Rosso", "Mobile IOS", "Mini Curriculum5", R.drawable.flanders));
        professor.add(new Professor("Hendy Almeida", "Mobile Android", "Mini Curriculum6", R.drawable.burns));
        professor.add(new Professor("Vinicius", "Mobile IOS", "Mini Curriculum7", R.drawable.nerd));
        professor.add(new Professor("Jéssica Milena", "Mobile Android", "Mini Curriculum", R.drawable.lisa));
        professor.add(new Professor("Tairo Roberto", "Mobile Android", "Mini Curriculum1", R.drawable.homersimpson));
        professor.add(new Professor("Fabio Tadashi", "Mobile Android", "Mini Curriculum2", R.drawable.flanders));
        professor.add(new Professor("Guilherme", "FullStack", "Mini Curriculum3", R.drawable.burns));
        professor.add(new Professor("Victor Caldas", "Marketing Digital", "Mini Curriculum4", R.drawable.homersimpson));
        professor.add(new Professor("Hugo Rosso", "Mobile IOS", "Mini Curriculum5", R.drawable.flanders));
        professor.add(new Professor("Hendy Almeida", "Mobile Android", "Mini Curriculum6", R.drawable.burns));
        professor.add(new Professor("Vinicius", "Mobile IOS", "Mini Curriculum7", R.drawable.nerd));
        return professor;
    }


    @Override
    public void onClick(Professor professor) {
        Intent intent = new Intent(this, DetalheProfessorActivity.class);
        intent.putExtra("PROFESSOR", professor);
        startActivity(intent);
    }


}
